package web.uchile.articular.session.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ArchivoSolicitudDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ComunaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.FinalidadCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadPostulacionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.RegionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudAcademicaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudPostulacionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoSolicitudDTO;
import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;

import vijnana.respuesta.wrapper.response.seguridad.BasicContext;
import vijnana.respuesta.wrapper.response.seguridad.Identificacion;
import web.uchile.articular.servicio.impl.LoginModelo;
import web.uchile.articular.servicio.impl.SolicitudesUchileModelo;
import web.uchile.articular.session.model.LoginModel;
import web.uchile.articular.session.model.ServicioModel;
import web.uchile.articular.session.utilidades.AccionesObjetosEstaticos;
;

public class AdministracionSolicitudImpl {

	private static final Logger objLog = Logger.getLogger(AdministracionSolicitudImpl.class);
	/*********************************************/
	private List<ServicioModel> listaServicioModel;
	
	private List<ProgramaUniversidadDTO> listaProgramaUniversidad;
	private List<ProgramaUniversidadPostulacionDTO> listaProgramaUniversidadPostulacion;
	private List<TipoCertificadoDTO> listaTipoCertificado;
	private List<FinalidadCertificadoDTO> listaFinalidadCertificado;
	private List<TipoSolicitudDTO> listaTipoSolicitud;
	private List<RegionDTO> listaRegion;
	private List<ComunaDTO> listaComuna;
	private List<SolicitudCertificadoDTO> listaSolicitudCertificado;
	private List<SolicitudAcademicaDTO> listaSolicitudAcademica;
	private List<SolicitudPostulacionDTO> listaSolicitudPostulacion;

	private ArchivoSolicitudDTO archivoSolicitud = new ArchivoSolicitudDTO();
	
	private Date fechaInicial;
	private Date fechaFinal;

	private Date limiteInferiorFechaInicial=new Date();
	private Date limiteInferiorFechaFinal=new Date();
	private Date limiteSuperiorFechaInicial=new Date();
	private Date limiteSuperiorFechaFinal=new Date();
	
	private String remoteAddr = ""; 
	private String remoteHost= "";
	
	private GeneracionAplicacion generarAplicacion;
	private LoginModel loginModel;
	private String token = "";
	private String tokenSessionUsuario = "";
	
	//token debe ser session de la aplicacion.
	public AdministracionSolicitudImpl(String remoteAddr, String remoteHost, String token, String keySessionUsuario){
		this.remoteAddr= remoteAddr;
		this.remoteHost= remoteHost;
		
		if(token!=null){
			Gson gson = new Gson();
			JsonElement json = gson.fromJson(token, JsonElement.class);
			this.token = json.getAsJsonObject().get("ficha").getAsString();
		}
		
		if(keySessionUsuario!=null){
			tokenSessionUsuario = keySessionUsuario;
		}
		
	}

	public void llamarRemoteCommandHotel(){
		inicializarFormulario();
	}

	/***********************INICIALIZAR VALORES DEL FORMULARIO *************************************/
	/** @Do inicializa los valores de todo el formulario
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void inicializarFormulario(){
//		generarValoresAplicacion();
		generarAplicacion = new GeneracionAplicacion(remoteHost, token);
		
		if(generarAplicacion.getAuthenticacionContext()!=null){
			loginModel = obtenerUsuarioLogin();
			
			if(loginModel!=null && loginModel.getIdUsuario()>0){
				inicializarValoresDTO();
				generarValoresFormulario();
			}
			
		}
	}
	
	//El perfil requerido debe ser administrador o mas
	public LoginModel obtenerUsuarioLogin() {
		//Almacenar y redirigir a exito.xhtml
		LoginModelo loginModelo = new LoginModelo();
//		UchileArte uchileArte = null;
//		generarAplicacion.generarLoginUsuario( loginDTO.getUsernamePerfil(), loginDTO.getPasswordContrasenha());
		HashMap<String, String> mapaClaves = new LinkedHashMap<String, String>();
		mapaClaves.put("key", tokenSessionUsuario);
		
		BasicContext basicContext = loginModelo.generarLoginUsuario(generarAplicacion.getAuthenticacionContext(), mapaClaves);
		
		if(basicContext!=null){
			loginModel = new LoginModel();
			loginModel.setIdUsuario(basicContext.getIdUsuario());
			loginModel.setUsernamePerfil(basicContext.getUsernamePerfil());
			loginModel.setMailMember(basicContext.getMailPerfil());
			loginModel.setUsernamePerfil(basicContext.getUsernamePerfil());
			loginModel.setNombreMember(basicContext.getNombreMember());
			loginModel.setApellidoPaternoMember(basicContext.getApellidoPaternoMember());
			loginModel.setApellidoMaternoMember(basicContext.getApellidoMaternoMember());
			loginModel.setAnonimo(basicContext.getAnonimo());
			loginModel.setUltimaConexionPerfil(new Date());
			
			for(Identificacion i: basicContext.getListaIdentificacion()){
				 if(i.getNombreIdentificador().equalsIgnoreCase("RUT")){
					 loginModel.setRutMember(i.getValueIdentificador());
					 break;
				 }
			}
			
			objLog.info(basicContext.getIdUsuario()+" - "+basicContext.getIdEmpresa()+" - "+basicContext.getIdEmpresaUsuario());
			
			token = basicContext.getKeyBasic();
		}else{
			loginModel = null;
		}

		return loginModel;
	}
	
//	LoginModelo loginModelo = new LoginModelo();
//	BasicContext basicContext = loginModelo.generarLoginUsuario(generarAplicacion.getAuthenticacionContext(), tokenSessionUsuario);
	/** @Do inicializa los valores de los datos de trabajo del formulario
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void inicializarValoresDTO(){
//		objLog.info("INI - iniciliazarValoresDTO");
		
		listaServicioModel = new ArrayList<ServicioModel>();
		
		listaProgramaUniversidad = new ArrayList<ProgramaUniversidadDTO>();
		
		listaProgramaUniversidadPostulacion = new ArrayList<ProgramaUniversidadPostulacionDTO>();
		
		listaTipoCertificado  = new ArrayList<TipoCertificadoDTO>();
		
		listaTipoSolicitud  = new ArrayList<TipoSolicitudDTO>();
		
		listaFinalidadCertificado = new ArrayList<FinalidadCertificadoDTO>();
		
		listaRegion = new ArrayList<RegionDTO>();
		
		listaComuna = new ArrayList<ComunaDTO>();
		
//		listaSolicitudCertificado = new ArrayList<SolicitudCertificadoDTO>();
	}

	/** @Do genera los valores de disabled y llenado de combobox del formulario 
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void generarValoresFormulario(){
//		objLog.info("INI - generarValoresFormulario");
		
		SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();
		
		iniciliazarDisabled();
		
		llenarFechasCertificados();
		
		listarServicios();
		
		listarProgramasUniversidad(solicitudesModelo);
		
		listarProgramasUniversidadPostulacion(solicitudesModelo);

		listarTipoCertificado(solicitudesModelo);
		
		listarTipoSolicitud(solicitudesModelo);

		listarFinalidadCertificado(solicitudesModelo);

//		listarUltimosSolicitudCertificadoDTO(solicitudesModelo);
		
//		objLog.info("FIN - generarValoresFormulario");
	}

	/** @Do inicializa los valores de los datos de disabled
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void iniciliazarDisabled(){
//		objLog.info("INI - iniciliazarDisabled");

//		objLog.info("FIN - iniciliazarDisabled");
	}
	
	
	public void llenarFechasCertificados(){
		Date MfechaHoy=new Date();

		Date MfechaInicial=new Date();
		Date MfechaFinal=new Date();
		Date MfechaLimInfIni=new Date();
		Date MfechaLimSupIni=new Date();
		Date MfechaLimInfFin=new Date();
		Date MfechaLimSupFin=new Date();

		SimpleDateFormat formatInicial = new SimpleDateFormat("dd/MM/yyyy");
		String fechaCompare1=formatInicial.format(MfechaHoy).toString();
		Calendar calHoy = Calendar.getInstance();
		Calendar calInicio = Calendar.getInstance();
		Calendar calFinal = Calendar.getInstance();
		Calendar calLimiteInferiorOrigen = Calendar.getInstance();
		Calendar calLimiteSuperiorOrigen = Calendar.getInstance();
		Calendar calLimiteInferiorRegreso = Calendar.getInstance();
		Calendar calLimiteSuperiorRegreso = Calendar.getInstance();

		long miliHoy = 0;
		int dia1 = Integer.parseInt(fechaCompare1.substring(0, 2));
		int mes1 = Integer.parseInt(fechaCompare1.substring(3, 5));
		int ano1 = Integer.parseInt(fechaCompare1.substring(6, 10));
		GregorianCalendar c = new GregorianCalendar(ano1, mes1 - 1, dia1);

		miliHoy = c.getTime().getTime();
		java.util.Date fechaHoy = new java.util.Date(miliHoy);

		calHoy.setTime(fechaHoy);
		calInicio.setTime(fechaHoy);
		calFinal.setTime(fechaHoy);
		calLimiteInferiorOrigen.setTime(fechaHoy);
		calLimiteSuperiorOrigen.setTime(fechaHoy);
		calLimiteInferiorRegreso.setTime(fechaHoy);
		calLimiteSuperiorRegreso.setTime(fechaHoy);

		calInicio.add(Calendar.DATE, -7);
		MfechaInicial=calInicio.getTime();

		calFinal.add(Calendar.DATE, 0);
		calFinal.add(Calendar.HOUR, 23);
		calFinal.add(Calendar.MINUTE, 59);
		calFinal.add(Calendar.SECOND, 59);
		MfechaFinal=calFinal.getTime();

		calLimiteInferiorOrigen.add(Calendar.DATE, -365);
		MfechaLimInfIni=calLimiteInferiorOrigen.getTime();

		calLimiteSuperiorOrigen.add(Calendar.DATE, -1);
		MfechaLimSupIni=calLimiteSuperiorOrigen.getTime();

		calLimiteInferiorRegreso.add(Calendar.DATE, -365);
		MfechaLimInfFin=calLimiteInferiorRegreso.getTime();
		//un a\F1o desde el Origen
		calLimiteSuperiorRegreso.add(Calendar.DATE, 0);
		MfechaLimSupFin=calLimiteSuperiorRegreso.getTime();


		setFechaInicial(MfechaInicial);
		setFechaFinal(MfechaFinal);
		//generar los 4 limites
		setLimiteInferiorFechaInicial(MfechaLimInfIni);
		setLimiteSuperiorFechaInicial(MfechaLimSupIni);
		setLimiteInferiorFechaFinal(MfechaLimInfFin);
		setLimiteSuperiorFechaFinal(MfechaLimSupFin);

	}

	
	public void listarServicios(){

		/**Traer Todos*/
		SelectItem[] listaServicios = AccionesObjetosEstaticos.listarServicios();
		
		listaServicioModel = new ArrayList<ServicioModel>();
		
		for(int i=0; i<listaServicios.length ; i++){
			ServicioModel servicioModel = new ServicioModel(i, listaServicios[0].getValue()+"");
			listaServicioModel.add(servicioModel);
		}
	
	}
	
	public void listarProgramasUniversidad(SolicitudesUchileModelo solicitudesModelo){

		List<ProgramaUniversidadDTO> retListaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();
		
		/**Traer Todos*/
		retListaProgramaUniversidadDTO = solicitudesModelo.listarProgramasUniversidad(generarAplicacion.getAuthenticacionContext());
		
		setListaProgramaUniversidad(retListaProgramaUniversidadDTO);
	}
	
	public void listarProgramasUniversidadPostulacion(SolicitudesUchileModelo solicitudesModelo){

		List<ProgramaUniversidadPostulacionDTO> retListaProgramasUniversidadPostulacionDTO = new ArrayList<ProgramaUniversidadPostulacionDTO>();
		/**Traer Todos*/
		retListaProgramasUniversidadPostulacionDTO = solicitudesModelo.listarProgramasUniversidadPostulacion(generarAplicacion.getAuthenticacionContext());
		
		setListaProgramaUniversidadPostulacion(retListaProgramasUniversidadPostulacionDTO);
	}
	
	public void listarTipoCertificado(SolicitudesUchileModelo solicitudesModelo){
		
		List<TipoCertificadoDTO> retListaTipoCertificadoDTO = new ArrayList<TipoCertificadoDTO>();
		
		retListaTipoCertificadoDTO = solicitudesModelo.listarTipoCertificado(generarAplicacion.getAuthenticacionContext());
		
		setListaTipoCertificado(retListaTipoCertificadoDTO);
	}
	
	public void listarTipoSolicitud(SolicitudesUchileModelo solicitudesModelo){
		
		List<TipoSolicitudDTO> retListaTipoSolicitudDTO = new ArrayList<TipoSolicitudDTO>();
		
		retListaTipoSolicitudDTO = solicitudesModelo.listarTipoSolicitud(generarAplicacion.getAuthenticacionContext());
		
		setListaTipoSolicitud(retListaTipoSolicitudDTO);
	}

	public void listarFinalidadCertificado(SolicitudesUchileModelo solicitudesModelo){
		
		List<FinalidadCertificadoDTO> retListaFinalidadCertificadoDTO = new ArrayList<FinalidadCertificadoDTO>();
		
		retListaFinalidadCertificadoDTO = solicitudesModelo.listarFinalidadCertificado(generarAplicacion.getAuthenticacionContext());
		
		setListaFinalidadCertificado(retListaFinalidadCertificadoDTO);
	}


	/** @Do inicializa los datos de datatable de aplicaciones del formulario
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void listarUltimosSolicitudCertificadoDTO(SolicitudesUchileModelo solicitudesModelo){
//		
		RequestProductoDTO requestProductoDTO = generarRequestProductoBusquedaSolicitudCertificados();
		
		List<SolicitudCertificadoDTO> retListaSolicitudCertificadoDTO  = solicitudesModelo.listarSolicitudCertificadoEntreFechas(generarAplicacion.getAuthenticacionContext(), requestProductoDTO);
		
		List<SolicitudCertificadoDTO> metListaSolicitudCertificadoDTO = new ArrayList<SolicitudCertificadoDTO>();
		
		SolicitudCertificadoDTO metSolicitudCertificadoDTO = new SolicitudCertificadoDTO();
		
		for(SolicitudCertificadoDTO SolAcaDTO : retListaSolicitudCertificadoDTO){
			metSolicitudCertificadoDTO = new SolicitudCertificadoDTO(); 
			
			metSolicitudCertificadoDTO = SolAcaDTO;

			for(ProgramaUniversidadDTO proUniDTO: listaProgramaUniversidad){
				if(SolAcaDTO.getIdProgramaUniversidad()==proUniDTO.getIdProgramaUniversidad()){
					metSolicitudCertificadoDTO.setProgramaUniversidad(proUniDTO.getNombreProgramaUniversidad());
					break;
				}
			}

			for(TipoCertificadoDTO tipCertDTO: listaTipoCertificado){
				if(SolAcaDTO.getIdTipoCertificado()==tipCertDTO.getIdTipoCertificado()){
					metSolicitudCertificadoDTO.setTipoCertificado(tipCertDTO.getNombreTipoCertificado());
					break;
				}
			}

			for(FinalidadCertificadoDTO finCertDTO: listaFinalidadCertificado ){
				if(SolAcaDTO.getIdFinalidadCertificado()==finCertDTO.getIdFinalidadCertificado()){
					metSolicitudCertificadoDTO.setFinalidadCertificado(finCertDTO.getNombreFinalidadCertificado());
					break;
				}
			}
			metSolicitudCertificadoDTO.setSfechaSolicitud(transformarDateToString(metSolicitudCertificadoDTO.getSfechaSolicitud()));
			
			metListaSolicitudCertificadoDTO.add(metSolicitudCertificadoDTO);

		}

		setListaSolicitudCertificado(metListaSolicitudCertificadoDTO);

	}
	
	public RequestProductoDTO generarRequestProductoBusquedaSolicitudCertificados(){
		RequestProductoDTO requestProductoDTO = new RequestProductoDTO();
		
		Date fechaAhora = new Date();
		
		Date fechaCasiManhana = obtenerFechaMañana(fechaAhora);
		
		Date fechaSemanaPasada = obtenerFechaSemanaPasada(fechaAhora);
		
		List<SolicitudCertificadoDTO> listaSolicitudCertificadoDTO = new ArrayList<SolicitudCertificadoDTO>();
		
		SolicitudCertificadoDTO solicitudCertificadoDTOInicial = new SolicitudCertificadoDTO();
		
		SolicitudCertificadoDTO solicitudCertificadoDTOFinal = new SolicitudCertificadoDTO();
		
		solicitudCertificadoDTOInicial.setFechaSolicitud(fechaSemanaPasada);
		
		solicitudCertificadoDTOFinal.setFechaSolicitud(fechaCasiManhana);
		
		listaSolicitudCertificadoDTO.add(solicitudCertificadoDTOInicial);
		
		listaSolicitudCertificadoDTO.add(solicitudCertificadoDTOFinal);
		
		requestProductoDTO.setListaSolicitudCertificadoDTO(listaSolicitudCertificadoDTO);
		
		return requestProductoDTO;
	}
	
	public Date obtenerFechaMañana(Date fechaAhora) {
		SimpleDateFormat formatFechaHpoy = new SimpleDateFormat("dd/MM/yyyy");
		
		String stringFechaAhora=formatFechaHpoy.format(fechaAhora).toString();
		Calendar calCasiManhana = Calendar.getInstance();
		long miliHoy = 0;
		
		int diaHoy = Integer.parseInt(stringFechaAhora.substring(0, 2));
		int mesHoy = Integer.parseInt(stringFechaAhora.substring(3, 5));
		int anoHoy = Integer.parseInt(stringFechaAhora.substring(6, 10));
		
		GregorianCalendar cHoy = new GregorianCalendar(anoHoy, mesHoy - 1, diaHoy);
		miliHoy = cHoy.getTime().getTime();
		java.util.Date dateFechaCasiMañana = new java.util.Date(miliHoy);
		calCasiManhana.setTime(dateFechaCasiMañana);
		calCasiManhana.add(Calendar.DATE, 0); //Dar Un Dia
		calCasiManhana.add(Calendar.HOUR, 23);
		calCasiManhana.add(Calendar.MINUTE, 59);
		calCasiManhana.add(Calendar.SECOND, 59);
		Date fechaCasiMañana=calCasiManhana.getTime();
		
		return fechaCasiMañana;
	}
	
	public Date obtenerFechaSemanaPasada(Date fechaAhora) {
		SimpleDateFormat formatFechaHpoy = new SimpleDateFormat("dd/MM/yyyy");
		
		String stringFechaAhora=formatFechaHpoy.format(fechaAhora).toString();
		Calendar calSemanaPasada = Calendar.getInstance();
		long miliHoy = 0;
		
		int diaHoy = Integer.parseInt(stringFechaAhora.substring(0, 2));
		int mesHoy = Integer.parseInt(stringFechaAhora.substring(3, 5));
		int anoHoy = Integer.parseInt(stringFechaAhora.substring(6, 10));
		
		GregorianCalendar cHoy = new GregorianCalendar(anoHoy, mesHoy - 1, diaHoy);
		miliHoy = cHoy.getTime().getTime();
		java.util.Date dateFechaSemanaPasada = new java.util.Date(miliHoy);
		calSemanaPasada.setTime(dateFechaSemanaPasada);
		
		calSemanaPasada.add(Calendar.DATE, -7); //Dar Un Dia
		
		Date fechaSemanaPasada=calSemanaPasada.getTime();
		
		return fechaSemanaPasada;
	}

	/********************* METODOS DE FUNCIONAMIENTO /ACTIVIDADES ******************************/
	public void cambiarFechaFinal(){
		//Obtener fecha de resolucion, Osea...cuando el usuario creo la empresa en el registro de SII.
		//		Date MfechaHoy=new Date();

		Date MfechaHoy=new Date();
		Date MfechaIda=new Date();

		Date MfechaRetorno=new Date();
		Date MfechaLimInfIni=new Date();
		Date MfechaLimSupIni=new Date();
		Date MfechaLimInfFin=new Date();
		Date MfechaLimSupFin=new Date();

		MfechaIda= (Date) new Date();

		SimpleDateFormat formatFechaHpoy = new SimpleDateFormat("dd/MM/yyyy");
		String stringFechaHoy=formatFechaHpoy.format(MfechaHoy).toString();

		SimpleDateFormat formatFechaIda = new SimpleDateFormat("dd/MM/yyyy");
		String stringFechaIda=formatFechaIda.format(MfechaIda).toString();

		Calendar calRegreso = Calendar.getInstance();
		Calendar calLimiteInferiorOrigen = Calendar.getInstance();
		Calendar calLimiteSuperiorOrigen = Calendar.getInstance();
		Calendar calLimiteInferiorRegreso = Calendar.getInstance();
		Calendar calLimiteSuperiorRegreso = Calendar.getInstance();

		//Milisegundos de Fecha de Hoy
		long miliHoy = 0;
		int diaHoy = Integer.parseInt(stringFechaHoy.substring(0, 2));
		int mesHoy = Integer.parseInt(stringFechaHoy.substring(3, 5));
		int anoHoy = Integer.parseInt(stringFechaHoy.substring(6, 10));

		GregorianCalendar cHoy = new GregorianCalendar(anoHoy, mesHoy - 1, diaHoy);
		miliHoy = cHoy.getTime().getTime();
		java.util.Date dateFechaHoy = new java.util.Date(miliHoy);
		//Milisegundos de Fecha de Hoy
		//Milisegundos de Fecha de Ida
		long mili1 = 0;
		int dia1 = Integer.parseInt(stringFechaIda.substring(0, 2));
		int mes1 = Integer.parseInt(stringFechaIda.substring(3, 5));
		int ano1 = Integer.parseInt(stringFechaIda.substring(6, 10));
		GregorianCalendar c = new GregorianCalendar(ano1, mes1 - 1, dia1);
		mili1 = c.getTime().getTime();
		java.util.Date dateFechaIda = new java.util.Date(mili1);
		//Milisegundos de Fecha de Ida

		calRegreso.setTime(dateFechaIda);
		//desde la Fecha de Hoy hasta un a\F1o
		calLimiteInferiorOrigen.setTime(dateFechaHoy);
		calLimiteSuperiorOrigen.setTime(dateFechaHoy);
		//desde la Fecha de Hoy hasta un a\F1o despues de la Ida
		calLimiteInferiorRegreso.setTime(dateFechaIda);
		calLimiteSuperiorRegreso.setTime(dateFechaHoy);

		//Setear el Mismo dia de la Fecha de Inicio.
		calRegreso.add(Calendar.DATE, 0); //Dar Un Dia
		calRegreso.add(Calendar.HOUR, 23);
		calRegreso.add(Calendar.MINUTE, 59);
		calRegreso.add(Calendar.SECOND, 59);
		MfechaRetorno=calRegreso.getTime();

		calLimiteInferiorOrigen.add(Calendar.DATE, -365);
		MfechaLimInfIni=calLimiteInferiorOrigen.getTime();

		calLimiteSuperiorOrigen.add(Calendar.DATE, 0);
		MfechaLimSupIni=calLimiteSuperiorOrigen.getTime();

		calLimiteInferiorRegreso.add(Calendar.DATE, 1);
		MfechaLimInfFin=calLimiteInferiorRegreso.getTime();
		//un a\F1o desde el Origen
		calLimiteSuperiorRegreso.add(Calendar.DATE, 0);
		MfechaLimSupFin=calLimiteSuperiorRegreso.getTime();

		if (MfechaLimSupIni.before(MfechaRetorno)) {
			calRegreso.setTime(dateFechaIda);
			calRegreso.add(Calendar.DATE, 0);
			MfechaRetorno=calRegreso.getTime();
		}

		setFechaInicial(MfechaIda);
		setFechaFinal(MfechaRetorno);
		//generar los 4 limites
		setLimiteInferiorFechaInicial(MfechaLimInfIni);
		setLimiteSuperiorFechaInicial(MfechaLimSupIni);
		setLimiteInferiorFechaFinal(MfechaLimInfFin);
		setLimiteSuperiorFechaFinal(MfechaLimSupFin);
		//limpiar referencias siempre

	}

//	public String buscarSolicitudCertificado(){
//
//		listarSolicitudCertificadoDTOEntreFechas();
//
//		return null;
//	}
//
//		public void listarSolicitudCertificadoDTOEntreFechas(){
////			objLog.info("INI - listarSolicitudCertificadoDTOEntreFechas");
//			List<SolicitudCertificadoDTO> listaSolicitudCertificadoDTO = new ArrayList<SolicitudCertificadoDTO>();
//			List<SolicitudCertificadoDTO> metListaSolicitudCertificadoDTO = new ArrayList<SolicitudCertificadoDTO>();
//			List<SolicitudCertificadoDTO> retListaSolicitudCertificadoDTO = new ArrayList<SolicitudCertificadoDTO>();
//			RequestProductoDTO requestProductoDTO = new RequestProductoDTO();
//			SolicitudCertificadoDTO metSolicitudCertificadoDTO = new SolicitudCertificadoDTO();
//			
//			SolicitudCertificadoDTO SolicitudCertificadoDTOInicial = new SolicitudCertificadoDTO();
//			SolicitudCertificadoDTOInicial.setFechaSolicitud(fechaInicial);
//			
//			SolicitudCertificadoDTO SolicitudCertificadoDTOFinal = new SolicitudCertificadoDTO();
//			//Agregar 23 Hrs - 59 min 59 sec
//			SimpleDateFormat formatFechaIda = new SimpleDateFormat("dd/MM/yyyy");
//			String stringFechaFinal=formatFechaIda.format(fechaFinal).toString();
//			Calendar calRegreso = Calendar.getInstance();
//			
//			long mili1 = 0;
//			int dia1 = Integer.parseInt(stringFechaFinal.substring(0, 2));
//			int mes1 = Integer.parseInt(stringFechaFinal.substring(3, 5));
//			int ano1 = Integer.parseInt(stringFechaFinal.substring(6, 10));
//			GregorianCalendar c = new GregorianCalendar(ano1, mes1 - 1, dia1);
//			mili1 = c.getTime().getTime();
//			java.util.Date dateFechaFinal = new java.util.Date(mili1);
//			calRegreso.setTime(dateFechaFinal);
//			
//			calRegreso.add(Calendar.DATE, 0); //Dar Un Dia
//			calRegreso.add(Calendar.HOUR, 23);
//			calRegreso.add(Calendar.MINUTE, 59);
//			calRegreso.add(Calendar.SECOND, 59);
//			fechaFinal=calRegreso.getTime();
//			//Agregar 23 Hrs - 59 min 59 sec
//			
//			SolicitudCertificadoDTOFinal.setFechaSolicitud(fechaFinal);
//			
//			listaSolicitudCertificadoDTO.add(SolicitudCertificadoDTOInicial);
//			
//			listaSolicitudCertificadoDTO.add(SolicitudCertificadoDTOFinal);
//			
//			requestProductoDTO.setListaSolicitudCertificadoDTO(listaSolicitudCertificadoDTO);
//			
//			UchileArte uchileArte = new UchileArte();
//			//		 Mostrar Todo
//			ClienteRest clienteRest = new ClienteRest();
//			
//			uchileArte = clienteRest.post(requestProductoDTO, uchileProperties.getLocalListarSolicitudCertificadoxEntreFechas());
//			
//			retListaSolicitudCertificadoDTO = uchileArte.getListaSolicitudCertificadoDTO(); 
//			
//			for(SolicitudCertificadoDTO SolAcaDTO : retListaSolicitudCertificadoDTO){
//				metSolicitudCertificadoDTO = new SolicitudCertificadoDTO(); 
//				metSolicitudCertificadoDTO = SolAcaDTO;
//				
//				for(ProgramaUniversidadDTO proUniDTO: listaProgramaUniversidadDTO){
//					if(SolAcaDTO.getIdProgramaUniversidad()==proUniDTO.getIdProgramaUniversidad()){
//						metSolicitudCertificadoDTO.setProgramaUniversidad(proUniDTO.getNombreProgramaUniversidad());
//					}
//				}
//				for(TipoCertificadoDTO tipCerDTO: listaTipoCertificadoDTO){
//					if(SolAcaDTO.getIdTipoCertificado()==tipCerDTO.getIdTipoCertificado()){
//						metSolicitudCertificadoDTO.setTipoCertificado(tipCerDTO.getNombreTipoCertificado());
//					}
//				}
//				
//				for(FinalidadCertificadoDTO finCertDTO: listaFinalidadCertificadoDTO){
//					if(SolAcaDTO.getIdFinalidadCertificado()==finCertDTO.getIdFinalidadCertificado()){
//						metSolicitudCertificadoDTO.setFinalidadCertificado(finCertDTO.getNombreFinalidadCertificado());
//					}
//				}
//				
//				metSolicitudCertificadoDTO.setSfechaSolicitud(transformarDateToString(metSolicitudCertificadoDTO.getSfechaSolicitud()));
//				
//				metListaSolicitudCertificadoDTO.add(metSolicitudCertificadoDTO);
//			}
//			
//			setListaSolicitudCertificadoDTO(retListaSolicitudCertificadoDTO);
//	
////			objLog.info("FIN - listarProgramasUniversidadDTO "+retListaSolicitudCertificadoDTO.size());
//		}

	/** @Do almacena/actualiza una aplicacion en la base de datos
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public String enviarGestionSolicitudCertificado(){
//		objLog.info("INI - almacenarSolicitudCertificado");
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage("Aviso", "No se ha realizado Almacenamiento"));

//		objLog.info("FIN - almacenarSolicitudCertificado");
		
		return null;
	}

	public String transformarDateToString(String sfechaSolicitud){
		
		sfechaSolicitud=sfechaSolicitud.substring(0,10);
		
		return sfechaSolicitud;
	}

	/** @Do limpia e inicializa el formulario mediante el boton limpiar
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public String limpiarFormularioSolicitudCertificado(){
//		objLog.info("INI - limpiarFormularioSolicitudCertificado");
		
		inicializarFormulario();
		
//		objLog.info("FIN - limpiarFormularioSolicitudCertificado");
		
		return null;
	}
	/********************* METODOS DE FUNCIONAMIENTO ******************************/
	/******************GETTER y SETTER********************************************/

	public List<ServicioModel> getListaServicioModel() {
		return listaServicioModel;
	}

	public void setListaServicioModel(List<ServicioModel> listaServicioModel) {
		this.listaServicioModel = listaServicioModel;
	}

	public List<ProgramaUniversidadDTO> getListaProgramaUniversidad() {
		return listaProgramaUniversidad;
	}

	public void setListaProgramaUniversidad(List<ProgramaUniversidadDTO> listaProgramaUniversidad) {
		this.listaProgramaUniversidad = listaProgramaUniversidad;
	}

	public List<ProgramaUniversidadPostulacionDTO> getListaProgramaUniversidadPostulacion() {
		return listaProgramaUniversidadPostulacion;
	}

	public void setListaProgramaUniversidadPostulacion(
			List<ProgramaUniversidadPostulacionDTO> listaProgramaUniversidadPostulacion) {
		this.listaProgramaUniversidadPostulacion = listaProgramaUniversidadPostulacion;
	}

	public List<TipoCertificadoDTO> getListaTipoCertificado() {
		return listaTipoCertificado;
	}

	public void setListaTipoCertificado(List<TipoCertificadoDTO> listaTipoCertificado) {
		this.listaTipoCertificado = listaTipoCertificado;
	}

	public List<FinalidadCertificadoDTO> getListaFinalidadCertificado() {
		return listaFinalidadCertificado;
	}

	public void setListaFinalidadCertificado(List<FinalidadCertificadoDTO> listaFinalidadCertificado) {
		this.listaFinalidadCertificado = listaFinalidadCertificado;
	}

	public List<TipoSolicitudDTO> getListaTipoSolicitud() {
		return listaTipoSolicitud;
	}

	public void setListaTipoSolicitud(List<TipoSolicitudDTO> listaTipoSolicitud) {
		this.listaTipoSolicitud = listaTipoSolicitud;
	}

	public List<RegionDTO> getListaRegion() {
		return listaRegion;
	}

	public void setListaRegion(List<RegionDTO> listaRegion) {
		this.listaRegion = listaRegion;
	}

	public List<ComunaDTO> getListaComuna() {
		return listaComuna;
	}

	public void setListaComuna(List<ComunaDTO> listaComuna) {
		this.listaComuna = listaComuna;
	}

	public List<SolicitudCertificadoDTO> getListaSolicitudCertificado() {
		return listaSolicitudCertificado;
	}

	public void setListaSolicitudCertificado(List<SolicitudCertificadoDTO> listaSolicitudCertificado) {
		this.listaSolicitudCertificado = listaSolicitudCertificado;
	}

	public List<SolicitudAcademicaDTO> getListaSolicitudAcademica() {
		return listaSolicitudAcademica;
	}

	public void setListaSolicitudAcademica(List<SolicitudAcademicaDTO> listaSolicitudAcademica) {
		this.listaSolicitudAcademica = listaSolicitudAcademica;
	}

	public List<SolicitudPostulacionDTO> getListaSolicitudPostulacion() {
		return listaSolicitudPostulacion;
	}

	public void setListaSolicitudPostulacion(List<SolicitudPostulacionDTO> listaSolicitudPostulacion) {
		this.listaSolicitudPostulacion = listaSolicitudPostulacion;
	}

//	public SolicitudCertificadoDTO getVerSolicitudCertificado() {
//		return verSolicitudCertificado;
//	}
//
//	public void setVerSolicitudCertificado(SolicitudCertificadoDTO verSolicitudCertificado) {
//		this.verSolicitudCertificado = verSolicitudCertificado;
//	}
//
//	public SolicitudAcademicaDTO getVerSolicitudAcademica() {
//		return verSolicitudAcademica;
//	}
//
//	public void setVerSolicitudAcademica(SolicitudAcademicaDTO verSolicitudAcademica) {
//		this.verSolicitudAcademica = verSolicitudAcademica;
//	}
//
//	public SolicitudPostulacionDTO getVerSolicitudPostulacion() {
//		return verSolicitudPostulacion;
//	}
//
//	public void setVerSolicitudPostulacion(SolicitudPostulacionDTO verSolicitudPostulacion) {
//		this.verSolicitudPostulacion = verSolicitudPostulacion;
//	}

	public ArchivoSolicitudDTO getArchivoSolicitud() {
		return archivoSolicitud;
	}

	public void setArchivoSolicitud(ArchivoSolicitudDTO archivoSolicitud) {
		this.archivoSolicitud = archivoSolicitud;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getLimiteInferiorFechaInicial() {
		return limiteInferiorFechaInicial;
	}

	public void setLimiteInferiorFechaInicial(Date limiteInferiorFechaInicial) {
		this.limiteInferiorFechaInicial = limiteInferiorFechaInicial;
	}

	public Date getLimiteInferiorFechaFinal() {
		return limiteInferiorFechaFinal;
	}

	public void setLimiteInferiorFechaFinal(Date limiteInferiorFechaFinal) {
		this.limiteInferiorFechaFinal = limiteInferiorFechaFinal;
	}

	public Date getLimiteSuperiorFechaInicial() {
		return limiteSuperiorFechaInicial;
	}

	public void setLimiteSuperiorFechaInicial(Date limiteSuperiorFechaInicial) {
		this.limiteSuperiorFechaInicial = limiteSuperiorFechaInicial;
	}

	public Date getLimiteSuperiorFechaFinal() {
		return limiteSuperiorFechaFinal;
	}

	public void setLimiteSuperiorFechaFinal(Date limiteSuperiorFechaFinal) {
		this.limiteSuperiorFechaFinal = limiteSuperiorFechaFinal;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public GeneracionAplicacion getGenerarAplicacion() {
		return generarAplicacion;
	}

	public void setGenerarAplicacion(GeneracionAplicacion generarAplicacion) {
		this.generarAplicacion = generarAplicacion;
	}

	public LoginModel getLoginModel() {
		return loginModel;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenSessionUsuario() {
		return tokenSessionUsuario;
	}

	public void setTokenSessionUsuario(String tokenSessionUsuario) {
		this.tokenSessionUsuario = tokenSessionUsuario;
	}
	
}
