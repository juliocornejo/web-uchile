package web.uchile.articular.session.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

import vijnana.respuesta.wrapper.request.ConsultaSeguridad;
import vijnana.seguridad.orquestador.exception.WebImplException;
import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.TipoFormatoFecha;
import vijnana.utilidades.component.utilidades.ValidacionPatrones;
import web.uchile.articular.servicio.impl.SolicitudesUchileModelo;
import web.uchile.articular.servicio.properties.WebUchileProperties;
import web.uchile.articular.servicio.utilidades.UchileOrquestadorConstantes;


public class SolicitudCertificadoImpl {

	private static final Logger objLog = Logger.getLogger(SolicitudCertificadoImpl.class);

	/*********************************************/
	private int selecPrograma = 0;
	/******************/
	private List<ProgramaUniversidadDTO> listaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();
	private List<TipoCertificadoDTO> listaTipoCertificado = new ArrayList<TipoCertificadoDTO>();
	private List<FinalidadCertificadoDTO> listaFinalidadCertificado = new ArrayList<FinalidadCertificadoDTO>();
	private SolicitudCertificadoDTO solicitudCertificadoDTO = new SolicitudCertificadoDTO();
	private ProgramaUniversidadDTO programaUniversidadDTO = new ProgramaUniversidadDTO();
	private FinalidadCertificadoDTO finalidadCertificado = new FinalidadCertificadoDTO();

	private WebUchileProperties webUchileProperties = new WebUchileProperties();

	private int colspanBotonGuardar= 2;
	private int colspanBotonPagar = 0;

	private boolean flujoPagoOnline = false;
	private boolean aplicacionPagoOnline = false;
	private boolean flujoEnviarCorreo = false;
	private boolean aplicacionEnviarCorreo = false;
	private boolean mostrarBotonPagoOnline = false;
	
	private String remoteAddr = ""; 
	private String remoteHost= "";
	
	private GeneracionAplicacion generarAplicacion;
	
	private String token = "";
	
	public SolicitudCertificadoImpl(String remoteAddr, String remoteHost, String token){
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

		selecPrograma = 0;

		solicitudCertificadoDTO = new SolicitudCertificadoDTO();

		listaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();

		listaTipoCertificado = new ArrayList<TipoCertificadoDTO>();
		
		listaFinalidadCertificado = new ArrayList<FinalidadCertificadoDTO>();
	}

	/** @Do genera los valores de disabled y llenado de combobox del formulario 
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void generarValoresFormulario(){
		
		SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();
		
		inicializarDisabled();

		listarProgramasUniversidadDTO(solicitudesModelo);

		listarTipoCertificadoDTO(solicitudesModelo);

		listarFinalidadCertificadoDTO(solicitudesModelo);

		inicializarBotonPago();
		
	}
	
	/** @Do inicializa los valores de los datos de disabled
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void inicializarDisabled(){
//		objLog.info("INI - inicializarDisabled");
//		objLog.info("FIN - inicializarDisabled");
	}
	
	public void listarProgramasUniversidadDTO(SolicitudesUchileModelo solicitudesModelo){

		List<ProgramaUniversidadDTO> retListaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();
		/**Traer Activos*/
		retListaProgramaUniversidadDTO  = solicitudesModelo.listarProgramasUniversidadOrdenDTO(generarAplicacion.getAuthenticacionContext());

		setListaProgramaUniversidadDTO(retListaProgramaUniversidadDTO);
	}

	//Ordenado
	public void listarTipoCertificadoDTO(SolicitudesUchileModelo solicitudesModelo){

		List<TipoCertificadoDTO> retListaTipoCertificadoDTO = new ArrayList<TipoCertificadoDTO>();

		retListaTipoCertificadoDTO  = solicitudesModelo.listarTipoCertificadoOrdenDTO(generarAplicacion.getAuthenticacionContext());

		setListaTipoCertificado(retListaTipoCertificadoDTO);
	}

	public void listarFinalidadCertificadoDTO(SolicitudesUchileModelo solicitudesModelo){

		List<FinalidadCertificadoDTO> retListaFinalidadCertificadoDTO = new ArrayList<FinalidadCertificadoDTO>();

		retListaFinalidadCertificadoDTO = solicitudesModelo.listarFinalidadCertificadoOrdenDTO(generarAplicacion.getAuthenticacionContext());

		setListaFinalidadCertificado(retListaFinalidadCertificadoDTO);
	}
	
	public void inicializarBotonPago(){

		flujoPagoOnline = Boolean.parseBoolean(webUchileProperties.getServerFlujoPagoOnlineActivo());

		aplicacionPagoOnline = Boolean.parseBoolean(webUchileProperties.getLocalSolicitudCertificadoPagoOnlineactivo());

		flujoEnviarCorreo = Boolean.parseBoolean(webUchileProperties.getServerFlujoCorreoActivo());

		aplicacionEnviarCorreo = Boolean.parseBoolean(webUchileProperties.getLocalSolicitudCertificadoCorreoActivo());

		if(flujoPagoOnline && aplicacionPagoOnline){
			setMostrarBotonPagoOnline(true);
			colspanBotonGuardar= 1;
			colspanBotonPagar = 1;
		}
	}
	/***********************INICIALIZAR VALORES DEL FORMULARIO ********************/
	/********************* METODOS DE FUNCIONAMIENTO /ACTIVIDADES ******************************/
	/** @Do valida si el llenado de los datos del formulario es correcto o no.
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */

	public boolean validarLlenadoFormulario(SolicitudCertificadoDTO solicitudCertificadoDTO){
		//		objLog.info("INI - validarLlenadoFormulario");
		boolean validar = false;

		if(solicitudCertificadoDTO.getNombrePersonaSolicitudCertificado()!=null && !solicitudCertificadoDTO.getNombrePersonaSolicitudCertificado().equals("")){
			if(solicitudCertificadoDTO.getApellidoPaternoPersonaSolicitudCertificado()!=null && !solicitudCertificadoDTO.getApellidoPaternoPersonaSolicitudCertificado().equals("")){
				if(solicitudCertificadoDTO.getApellidoMaternoPersonaSolicitudCertificado()!=null && !solicitudCertificadoDTO.getApellidoMaternoPersonaSolicitudCertificado().equals("")){
					if(solicitudCertificadoDTO.getRutPersonaSolicitudCertificado()!=null && !solicitudCertificadoDTO.getRutPersonaSolicitudCertificado().equals("")){
						if(solicitudCertificadoDTO.getIdProgramaUniversidad()!= 0 ){
							if(solicitudCertificadoDTO.getMailMember()!=null && !solicitudCertificadoDTO.getMailMember().equals("")){
								if(ValidacionPatrones.validarPatronEmail(solicitudCertificadoDTO.getMailMember())){	
									if(solicitudCertificadoDTO.getAnhoIngreso()!=null && !solicitudCertificadoDTO.getAnhoIngreso().equals("")){
										if(solicitudCertificadoDTO.getIdTipoCertificado()!=0){
											if(solicitudCertificadoDTO.getIdFinalidadCertificado()!=0){
												validar = true;
											}else{
												FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se indicó la finalidad del certificado");
												FacesContext.getCurrentInstance().addMessage(null, msg);
											}
										}else{
											FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se indicó el tipo de certificado");
											FacesContext.getCurrentInstance().addMessage(null, msg);
										}
									}else{
										FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se indicó el año de ingreso del alumno");
										FacesContext.getCurrentInstance().addMessage(null, msg);
									}
								}
								else{
									FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "el mail ingresado no es valido");
									FacesContext.getCurrentInstance().addMessage(null, msg);
								}
							}else{
								FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso el mail del alumno");
								FacesContext.getCurrentInstance().addMessage(null, msg);
							}
						}else{
							FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se indicó el programa de la universidad");
							FacesContext.getCurrentInstance().addMessage(null, msg);
						}
					}else{
						FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso el rut del alumno");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				}else{
					FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso el apellido materno del alumno");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}else{
				FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso el apellido paterno del alumno");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}else{
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso el nombre del alumno");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return validar;
	}
	
	/** @Do almacena/actualiza una aplicacion en la base de datos
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public boolean almacenarSolicitudCertificadoPagoOffline() throws IOException {
		//Almacenar y redirigir a exito.xhtml
		String paginaRedireccion = "/exito.xhtml";
		if(generarAplicacion.getAuthenticacionContext()!=null){
			return almacenarSolicitudPostulacion(paginaRedireccion, false);
		}
		return false;
	}

	public boolean almacenarSolicitudCertificadoPagoOnline() throws IOException {
		//Almacenar y redirigir a pago.xhtml
		String paginaRedireccion = "/pago.xhtml";

		if(generarAplicacion.getAuthenticacionContext()!=null){
			return almacenarSolicitudPostulacion(paginaRedireccion, true);
		}
		return false;
	}
	
	/*AlmacenarSolicitud recibe Online y Offline, envio Correo o sin envio*/
	public boolean almacenarSolicitudPostulacion(String paginaRedireccion, boolean online) throws IOException { 
		
		objLog.info("INI - almacenarSolicitudCertificado "+solicitudCertificadoDTO.getRutPersonaSolicitudCertificado());
		
		boolean validar = false;

		validar = validarLlenadoFormulario(solicitudCertificadoDTO);

		if(validar==true){

			try{

				solicitudCertificadoDTO.setFechaSolicitud(new Date());

				solicitudCertificadoDTO.setEstadoSolicitud(1);
				
				objLog.info("-------------------------");
				objLog.info("1 nombrePersona:"+solicitudCertificadoDTO.getNombrePersonaSolicitudCertificado());
				objLog.info("2 ApellidoPaterno:"+solicitudCertificadoDTO.getApellidoPaternoPersonaSolicitudCertificado());
				objLog.info("3 ApellidoMaterno:"+solicitudCertificadoDTO.getApellidoMaternoPersonaSolicitudCertificado());
				objLog.info("4 RutPersona:"+solicitudCertificadoDTO.getRutPersonaSolicitudCertificado());
				objLog.info("5 idProgramaUniversidad:"+solicitudCertificadoDTO.getIdProgramaUniversidad());
				objLog.info("5a programaUniversidad:"+solicitudCertificadoDTO.getProgramaUniversidad());
				objLog.info("6 MailMember:"+solicitudCertificadoDTO.getMailMember());
				objLog.info("7 AnhoIngreso:"+solicitudCertificadoDTO.getAnhoIngreso());
				objLog.info("8 idTipoCertificado:"+solicitudCertificadoDTO.getIdTipoCertificado());
				objLog.info("8a tipoCertificado:"+solicitudCertificadoDTO.getTipoCertificado());
				objLog.info("9 FinalidadCertificado:"+solicitudCertificadoDTO.getIdFinalidadCertificado());
				objLog.info("9a finalidadCertificado:"+solicitudCertificadoDTO.getFinalidadCertificado());
				objLog.info("10 FechaSolicitud :"+solicitudCertificadoDTO.getFechaSolicitud());
				objLog.info("-------------------------");
				
				objLog.info("VALUES	("+solicitudCertificadoDTO.getAnhoIngreso()+","+solicitudCertificadoDTO.getApellidoMaternoPersonaSolicitudCertificado()+","+
				solicitudCertificadoDTO.getApellidoPaternoPersonaSolicitudCertificado()+", 1,"+solicitudCertificadoDTO.getFechaSolicitud()+", "+solicitudCertificadoDTO.getMailMember()+","+
				solicitudCertificadoDTO.getNombrePersonaSolicitudCertificado() +","+solicitudCertificadoDTO.getRutPersonaSolicitudCertificado() +","+
				solicitudCertificadoDTO.getIdFinalidadCertificado()+","+solicitudCertificadoDTO.getIdProgramaUniversidad()+","+solicitudCertificadoDTO.getIdTipoCertificado());
				objLog.info("-------------------------");
				
				SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();

				RequestProductoDTO requestProductoDTO = solicitudesModelo.almacenarSolicitudCertificado(generarAplicacion.getAuthenticacionContext(), solicitudCertificadoDTO);
				
				objLog.info("A1: creando Solicitud");
//				UchileArte uchileArte = clienteRest.post(requestProductoDTO, propertiesAplicacion.getLocalCrearSolicitudCertificado());
				//##################################################
//				String ipServer = PropertiesAplicacion.getVijnanaServidor();
//				//		String ipServer = "localhost:8080";
//				ClienteWsRestUtilidades clienteWsRestUtilidades = new ClienteWsRestUtilidades();
//
//				UchileArte uchileArte = clienteWsRestUtilidades.crearSolicitudCertificado(requestProductoDTO, ipServer);
				//##################################################
				if(requestProductoDTO!=null){
					requestProductoDTO.getSolicitudCertificadoDTO().setIdSolicitudCertificado(requestProductoDTO.getSolicitudCertificadoDTO().getIdSolicitudCertificado());
//					requestProductoDTO.getSolicitudCertificadoDTO().setProgramaUniversidad(obtenerProgramaUniversidad(solicitudCertificadoDTO.getIdProgramaUniversidad()));
//					requestProductoDTO.getSolicitudCertificadoDTO().setTipoCertificado(obtenerTipoCertificado(solicitudCertificadoDTO.getIdTipoCertificado()));
//					requestProductoDTO.getSolicitudCertificadoDTO().setFinalidadCertificado(obtenerFinalidadCertificado(solicitudCertificadoDTO.getIdFinalidadCertificado()));
					requestProductoDTO.getSolicitudCertificadoDTO().setSfechaSolicitud(AppDate.obtenerFechaEnFormato(solicitudCertificadoDTO.getFechaSolicitud(), TipoFormatoFecha.DD_MM_YYYY));

//					String key = ClienteRestUtilidades.generacionSolicitudCertificadoSHA(requestProductoDTO);

					if(flujoEnviarCorreo==true && aplicacionEnviarCorreo==true ){
						solicitudesModelo.enviarEmailSolicitudAcademica(generarAplicacion.getAuthenticacionContext(),requestProductoDTO);
						objLog.info("A2: Envio Email true");
					}else{
						objLog.info("A2: Envio Email false");
						objLog.info("flujoEnviarCorreo:"+flujoEnviarCorreo +" - aplicacionEnviarCorreo:"+aplicacionEnviarCorreo);
					}
					//permitido en los flujos, en la aplicacion particular, si el usuario seleccionó pagar
					if(flujoPagoOnline == true && aplicacionPagoOnline==true && online == true){
//						String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, propertiesAplicacion.getServerIdSolicitudCertificadoAplicacion(), propertiesAplicacion.getServerIdSolicitudCertificadoEmailWebmail());
	//
//						NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();
	//
//						negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);
//						negocioSolicitudDTO.setKeyNegocioSolicitud(key);
//						negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());
//						negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());
	//
//						requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);
	//
//						clienteRest.post(requestProductoDTO, propertiesAplicacion.getLocalCrearNegocioSolicitud());
						//##################################################
//						uchileArte = clienteWsRestUtilidades.crearNegocioSolicitud(requestProductoDTO, ipServer);
						//##################################################
						
						
						objLog.info("A3: Creando Negocio Solicitud true");
						
						
					}else{
						objLog.info("A3: Creando Negocio Solicitud false");
						objLog.info("flujoPagoOnline:"+flujoPagoOnline +" - aplicacionPagoOnline:"+aplicacionPagoOnline);
					}

					return true;
				}else{
//					paginaRedireccion = "/error.xhtml";
					return false;
				}

			}catch(Exception e){
				e.printStackTrace();
				objLog.info("ERROR - almacenarSolicitudAcademica:"+solicitudCertificadoDTO.getRutPersonaSolicitudCertificado()+" - "+e.getMessage());
				return false;
			}

//			inicializarFormulario();
//
//			objLog.info("A4: Redireccion a "+paginaRedireccion);
//
//			if(flujoPagoOnline == true && aplicacionPagoOnline==true && online == true){
//				//Navigation.redirectExterno(paginaRedireccion);
//				return true;
//			}else{
//				return false;
//				//Navigation.redirectInterno(paginaRedireccion);
//			}
		}

		objLog.info("A5: Fin almacenarSolicitudCertificado");
		return false;
	}
	
	/** @Do limpia e inicializa el formulario mediante el boton limpiar
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public String limpiarFormularioSolicitudCertificado(){

		inicializarFormulario();

		return null;
	}

	/********************* METODOS DE FUNCIONAMIENTO ******************************/
	/******************GETTER y SETTER********************************************/

	public SolicitudCertificadoDTO getSolicitudCertificadoDTO() {
		return solicitudCertificadoDTO;
	}

	public void setSolicitudCertificadoDTO(SolicitudCertificadoDTO solicitudCertificadoDTO) {
		this.solicitudCertificadoDTO = solicitudCertificadoDTO;
	}

	public List<TipoCertificadoDTO> getListaTipoCertificado() {
		return listaTipoCertificado;
	}

	public FinalidadCertificadoDTO getFinalidadCertificado() {
		return finalidadCertificado;
	}

	public List<FinalidadCertificadoDTO> getListaFinalidadCertificado() {
		return listaFinalidadCertificado;
	}

	public ProgramaUniversidadDTO getProgramaUniversidadDTO() {
		return programaUniversidadDTO;
	}

	public void setProgramaUniversidadDTO(ProgramaUniversidadDTO programaUniversidadDTO) {
		this.programaUniversidadDTO = programaUniversidadDTO;
	}

	public List<ProgramaUniversidadDTO> getListaProgramaUniversidadDTO() {
		return listaProgramaUniversidadDTO;
	}

	public void setListaProgramaUniversidadDTO(List<ProgramaUniversidadDTO> listaProgramaUniversidadDTO) {
		this.listaProgramaUniversidadDTO = listaProgramaUniversidadDTO;
	}

	public void setListaTipoCertificado(List<TipoCertificadoDTO> listaTipoCertificado) {
		this.listaTipoCertificado = listaTipoCertificado;
	}

	public void setFinalidadCertificado(FinalidadCertificadoDTO finalidadCertificado) {
		this.finalidadCertificado = finalidadCertificado;
	}

	public void setListaFinalidadCertificado(List<FinalidadCertificadoDTO> listaFinalidadCertificado) {
		this.listaFinalidadCertificado = listaFinalidadCertificado;
	}

	public int getSelecPrograma() {
		return selecPrograma;
	}

	public void setSelecPrograma(int selecPrograma) {
		this.selecPrograma = selecPrograma;
	}

	public boolean isFlujoPagoOnline() {
		return flujoPagoOnline;
	}

	public void setFlujoPagoOnline(boolean flujoPagoOnline) {
		this.flujoPagoOnline = flujoPagoOnline;
	}

	public boolean isAplicacionPagoOnline() {
		return aplicacionPagoOnline;
	}

	public void setAplicacionPagoOnline(boolean aplicacionPagoOnline) {
		this.aplicacionPagoOnline = aplicacionPagoOnline;
	}

	public boolean isFlujoEnviarCorreo() {
		return flujoEnviarCorreo;
	}

	public void setFlujoEnviarCorreo(boolean flujoEnviarCorreo) {
		this.flujoEnviarCorreo = flujoEnviarCorreo;
	}

	public boolean isAplicacionEnviarCorreo() {
		return aplicacionEnviarCorreo;
	}

	public void setAplicacionEnviarCorreo(boolean aplicacionEnviarCorreo) {
		this.aplicacionEnviarCorreo = aplicacionEnviarCorreo;
	}

	public boolean isMostrarBotonPagoOnline() {
		return mostrarBotonPagoOnline;
	}

	public void setMostrarBotonPagoOnline(boolean mostrarBotonPagoOnline) {
		this.mostrarBotonPagoOnline = mostrarBotonPagoOnline;
	}

	public int getColspanBotonGuardar() {
		return colspanBotonGuardar;
	}

	public void setColspanBotonGuardar(int colspanBotonGuardar) {
		this.colspanBotonGuardar = colspanBotonGuardar;
	}

	public int getColspanBotonPagar() {
		return colspanBotonPagar;
	}

	public void setColspanBotonPagar(int colspanBotonPagar) {
		this.colspanBotonPagar = colspanBotonPagar;
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

	public WebUchileProperties getWebUchileProperties() {
		return webUchileProperties;
	}

	public void setWebUchileProperties(WebUchileProperties webUchileProperties) {
		this.webUchileProperties = webUchileProperties;
	}

	public GeneracionAplicacion getGenerarAplicacion() {
		return generarAplicacion;
	}

	public void setGenerarAplicacion(GeneracionAplicacion generarAplicacion) {
		this.generarAplicacion = generarAplicacion;
	}
	
}
