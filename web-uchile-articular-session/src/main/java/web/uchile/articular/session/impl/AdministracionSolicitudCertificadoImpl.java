package web.uchile.articular.session.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.FinalidadCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoCertificadoDTO;
import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;

import web.uchile.articular.servicio.impl.SolicitudesUchileModelo;
;

public class AdministracionSolicitudCertificadoImpl {

	private static final Logger objLog = Logger.getLogger(AdministracionSolicitudCertificadoImpl.class);
	/*********************************************/
	private List<SolicitudCertificadoDTO> listaSolicitudCertificado;
	private List<ProgramaUniversidadDTO> listaProgramaUniversidad;
	private List<TipoCertificadoDTO> listaTipoCertificado;
	private List<FinalidadCertificadoDTO> listaFinalidadCertificado;
	private SolicitudCertificadoDTO solicitudCertificado;
	private SolicitudCertificadoDTO verSolicitudCertificado = new SolicitudCertificadoDTO();
	
	private Date fechaInicial;
	private Date fechaFinal;

	private Date limiteInferiorFechaInicial=new Date();
	private Date limiteInferiorFechaFinal=new Date();
	private Date limiteSuperiorFechaInicial=new Date();
	private Date limiteSuperiorFechaFinal=new Date();
	
	private String remoteAddr = ""; 
	private String remoteHost= "";
	
	private GeneracionAplicacion generarAplicacion;
	
	private String token = "";
	
	public AdministracionSolicitudCertificadoImpl(String remoteAddr, String remoteHost, String token){
		this.remoteAddr= remoteAddr;
		this.remoteHost= remoteHost;
		
		if(token!=null){
			Gson gson = new Gson();
			JsonElement json = gson.fromJson(token, JsonElement.class);
			this.token = json.getAsJsonObject().get("ficha").getAsString();
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
			
			inicializarValoresDTO();
			generarValoresFormulario();
		}
	}

	/** @Do inicializa los valores de los datos de trabajo del formulario
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void inicializarValoresDTO(){
//		objLog.info("INI - iniciliazarValoresDTO");
		
		solicitudCertificado = new SolicitudCertificadoDTO();
		
		verSolicitudCertificado  = new SolicitudCertificadoDTO();
		
		listaSolicitudCertificado = new ArrayList<SolicitudCertificadoDTO>();
		
		listaProgramaUniversidad = new ArrayList<ProgramaUniversidadDTO>();
		
		listaTipoCertificado  = new ArrayList<TipoCertificadoDTO>();
		
		listaFinalidadCertificado = new ArrayList<FinalidadCertificadoDTO>();
//		objLog.info("FIN - iniciliazarValoresDTO");
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

		listarProgramasUniversidadDTO(solicitudesModelo);

		listarTipoCertificadoDTO(solicitudesModelo);

		listarFinalidadCertificadoDTO(solicitudesModelo);

		listarUltimosSolicitudCertificadoDTO(solicitudesModelo);
		
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

	public void listarProgramasUniversidadDTO(SolicitudesUchileModelo solicitudesModelo){

		List<ProgramaUniversidadDTO> retListaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();
		
		/**Traer Todos*/
		retListaProgramaUniversidadDTO = solicitudesModelo.listarProgramasUniversidadDTO(generarAplicacion.getAuthenticacionContext());
		
		setListaProgramaUniversidad(retListaProgramaUniversidadDTO);
	}

	public void listarTipoCertificadoDTO(SolicitudesUchileModelo solicitudesModelo){
		
		List<TipoCertificadoDTO> retListaTipoCertificadoDTO = new ArrayList<TipoCertificadoDTO>();
		
		retListaTipoCertificadoDTO = solicitudesModelo.listarTipoCertificadoDTO(generarAplicacion.getAuthenticacionContext());
		
		setListaTipoCertificado(retListaTipoCertificadoDTO);
	}

	public void listarFinalidadCertificadoDTO(SolicitudesUchileModelo solicitudesModelo){
		
		List<FinalidadCertificadoDTO> retListaFinalidadCertificadoDTO = new ArrayList<FinalidadCertificadoDTO>();
		
		retListaFinalidadCertificadoDTO = solicitudesModelo.listarFinalidadCertificadoDTO(generarAplicacion.getAuthenticacionContext());
		
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

	

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public List<SolicitudCertificadoDTO> getListaSolicitudCertificado() {
		return listaSolicitudCertificado;
	}

	public void setListaSolicitudCertificado(List<SolicitudCertificadoDTO> listaSolicitudCertificado) {
		this.listaSolicitudCertificado = listaSolicitudCertificado;
	}

	public List<ProgramaUniversidadDTO> getListaProgramaUniversidad() {
		return listaProgramaUniversidad;
	}

	public void setListaProgramaUniversidad(List<ProgramaUniversidadDTO> listaProgramaUniversidad) {
		this.listaProgramaUniversidad = listaProgramaUniversidad;
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

	public SolicitudCertificadoDTO getSolicitudCertificado() {
		return solicitudCertificado;
	}

	public void setSolicitudCertificado(SolicitudCertificadoDTO solicitudCertificado) {
		this.solicitudCertificado = solicitudCertificado;
	}

	public SolicitudCertificadoDTO getVerSolicitudCertificado() {
		return verSolicitudCertificado;
	}

	public void setVerSolicitudCertificado(SolicitudCertificadoDTO verSolicitudCertificado) {
		this.verSolicitudCertificado = verSolicitudCertificado;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
