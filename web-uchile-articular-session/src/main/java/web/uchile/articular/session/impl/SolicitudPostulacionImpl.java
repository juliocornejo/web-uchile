package web.uchile.articular.session.impl;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ArchivoSolicitudDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ComunaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadPostulacionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.RegionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudPostulacionDTO;
import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;

import vijnana.utilidades.component.utilidades.GenerarAlmacenamientoArchivos;
import vijnana.utilidades.component.utilidades.ValidacionPatrones;
import web.uchile.articular.servicio.impl.SolicitudesUchileModelo;
import web.uchile.articular.servicio.properties.WebUchileProperties;
import web.uchile.articular.session.model.ResponseWebUchile;


public class SolicitudPostulacionImpl {

	private static final Logger objLog = Logger.getLogger(SolicitudPostulacionImpl.class);


	private List<ProgramaUniversidadPostulacionDTO> listaProgramaUniversidadPostulacionDTO;
	private List<RegionDTO> listaRegionesDTO;
	private List<ComunaDTO> listaComunasDTO;
	private SolicitudPostulacionDTO solicitudPostulacionDTO;
	private ProgramaUniversidadDTO programaUniversidadDTO;
	private ArchivoSolicitudDTO archivoSolicitudPostulacionDTO;
	
	private WebUchileProperties webUchileProperties = new WebUchileProperties();

	private String textoCostoProgramaUniversidad;
	
	private int colspanBotonGuardar= 2;
	private int colspanBotonPagar = 0;

	private boolean mostrarCondicionesPago;
	private boolean disabledRegion;
	private boolean disabledComuna;
	private boolean mostrarBotonArchivo;
	private boolean mostrarNombreArchivo;

	private boolean flujoPagoOnline = false;
	private boolean aplicacionPagoOnline = false;
	private boolean flujoEnviarCorreo = false;
	private boolean aplicacionEnviarCorreo = false;
	private boolean mostrarBotonPagoOnline = false;
	
	private String remoteAddr = ""; 
	private String remoteHost= "";
	
	GeneracionAplicacion generarAplicacion;
//	private vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext;
	private String token = "";
	
	public SolicitudPostulacionImpl(String remoteAddr, String remoteHost, String token){
		this.remoteAddr= remoteAddr;
		this.remoteHost= remoteHost;
		
		if(token!=null){
			Gson gson = new Gson();
			JsonElement json = gson.fromJson(token, JsonElement.class);
			this.token = json.getAsJsonObject().get("ficha").getAsString();
		}
		
	}

//	public String validarFlujoProceso(FlowEvent event) {
//		if(skip) {
//			skip = false;   //reset in case user goes back
//			return "confirm";
//		}
//		else {
//			return event.getNewStep();
//		}
//	}

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
	/***********************INICIALIZAR VALORES DEL FORMULARIO *************************************/
	/** @Do inicializa los valores de todo el formulario
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void iniciliazarFormulario(){
		inicializarValoresDTO();
		generarValoresFormulario();
	}

	/** @Do inicializa los valores de los datos de trabajo del formulario
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void inicializarValoresDTO(){

		archivoSolicitudPostulacionDTO = null;

		solicitudPostulacionDTO = new SolicitudPostulacionDTO();

		listaProgramaUniversidadPostulacionDTO = new ArrayList<ProgramaUniversidadPostulacionDTO>();

		listaRegionesDTO=new ArrayList<RegionDTO>();

		listaComunasDTO=new ArrayList<ComunaDTO>();

	}
	

	/** @Do genera los valores de disabled y llenado de combobox del formulario 
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void generarValoresFormulario(){
		//		objLog.info("INI - generarValoresFormulario");
		SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();
		
		inicializarDisabled();
		listarProgramasUniversidadPostulacionDTO();
		listarRegionesDTO();

		inicializarBotonPago();
		//		objLog.info("FIN - generarValoresFormulario");
	}

	/** @Do inicializa los valores de los datos de disabled
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void inicializarDisabled(){
		//		objLog.info("INI - iniciliazarDisabled");
		setMostrarCondicionesPago(false);
		setDisabledRegion(true);
		setDisabledComuna(true);
		setMostrarBotonArchivo(true);
		setMostrarNombreArchivo(false);
		//		objLog.info("FIN - iniciliazarDisabled");
	}
	/** @Do inicializa los datos de datatable de aplicaciones del formulario
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */

	public void listarProgramasUniversidadPostulacionDTO(){

		List<ProgramaUniversidadPostulacionDTO> retListaProgramaUniversidadPostulacionDTO = new ArrayList<ProgramaUniversidadPostulacionDTO>();
		// Mostrar Todo
		SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();

		retListaProgramaUniversidadPostulacionDTO = solicitudesModelo.listarProgramasUniversidadPostulacionOrden(generarAplicacion.getAuthenticacionContext());

		setListaProgramaUniversidadPostulacionDTO(retListaProgramaUniversidadPostulacionDTO);

	}

	public void listarRegionesDTO(){
		List<RegionDTO> retListaRegionDTO = new ArrayList<RegionDTO>();
		// Mostrar Todo
		SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();

		retListaRegionDTO = solicitudesModelo.listarRegion(generarAplicacion.getAuthenticacionContext());

		setListaRegionesDTO(retListaRegionDTO);
	}

	public void seleccionarComunaXRegion(){
		//		objLog.info("INI - seleccionarComunaXRegion");

		ComunaDTO metComDTO=new ComunaDTO();
		solicitudPostulacionDTO.setNombreComuna("");
		if(solicitudPostulacionDTO.getIdRegionDomicilio()==0 || solicitudPostulacionDTO.getIdRegionDomicilio()<1){
			listaComunasDTO=new ArrayList<ComunaDTO>();
			setListaComunasDTO(listaComunasDTO);
			solicitudPostulacionDTO.setNombreComuna("");
			solicitudPostulacionDTO.setCiudadDomicilio("");
			setDisabledComuna(true);

		}
		else{
			metComDTO.setIdRegion(solicitudPostulacionDTO.getIdRegionDomicilio());
			listaComunasXRegion(metComDTO);
			setDisabledComuna(false);
		}
		//		objLog.info("FIN - seleccionarComunaXRegion");
	}

	private void listaComunasXRegion(ComunaDTO comDTO){

		List<ComunaDTO> listaComunaDTO = new ArrayList<ComunaDTO>();

		SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();

		//Buscar en Todas las Regiones 
		RequestProductoDTO requestProductoDTO = new RequestProductoDTO();

		requestProductoDTO.setComunaDTO(comDTO);

		listaComunaDTO = solicitudesModelo.listaComunaDTOXRegion(generarAplicacion.getAuthenticacionContext(), requestProductoDTO);

		//Setear el Valor de la Lista del Modelo a la vista.
		setListaComunasDTO(listaComunaDTO);
	}

	public void inicializarBotonPago(){

		flujoPagoOnline = Boolean.parseBoolean(webUchileProperties.getServerFlujoPagoOnlineActivo());

		aplicacionPagoOnline = Boolean.parseBoolean(webUchileProperties.getLocalSolicitudPostulacionPagoOnlineactivo());

		flujoEnviarCorreo = Boolean.parseBoolean(webUchileProperties.getServerFlujoCorreoActivo());

		aplicacionEnviarCorreo = Boolean.parseBoolean(webUchileProperties.getLocalSolicitudPostulacionCorreoActivo());

		if(flujoPagoOnline && aplicacionPagoOnline){
			setMostrarBotonPagoOnline(true);
			colspanBotonGuardar= 1;
			colspanBotonPagar = 1;

		}
	}

	/***********************INICIALIZAR VALORES DEL FORMULARIO ********************/
	/********************* METODOS DE FUNCIONAMIENTO /ACTIVIDADES ******************************/

	


	public void handleFileUpload(String nombreArchivo, InputStream entrega, File f, byte[] contenido){
		

		try {
			GenerarAlmacenamientoArchivos GenerarAlmacenamientoArchivos = new GenerarAlmacenamientoArchivos();
			/***Archivo creado en la carpeta temp del tomcat ***/
			String filePath = GenerarAlmacenamientoArchivos.generarNombreCarpetaProyectoNombreArchivo("solicitudesPostulaciones", nombreArchivo);
			GenerarAlmacenamientoArchivos.almacenarObjectFile(f, filePath, contenido);

			solicitudPostulacionDTO.setNombreArchivoSolicitud(nombreArchivo);

			/***Archivo creado en la carpeta temp del tomcat ***/
			/***Asociar el archivo con la postulacion ***/
			archivoSolicitudPostulacionDTO = new ArchivoSolicitudDTO();

			archivoSolicitudPostulacionDTO.setNombreArchivoSolicitud(nombreArchivo);

			archivoSolicitudPostulacionDTO.setDireccionAlmacenamientoArchivoSolicitud(filePath);

			archivoSolicitudPostulacionDTO.setTipoArchivoSolicitud("solicitudPostulacion");

			objLog.info("archivo:"+filePath+""+nombreArchivo);

			SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();

			ArchivoSolicitudDTO metArchivoSolicitudDTO = solicitudesModelo.handleFileUpload(generarAplicacion.getAuthenticacionContext(), archivoSolicitudPostulacionDTO);
			
			setMostrarBotonArchivo(false);

			setMostrarNombreArchivo(true);

			setArchivoSolicitudPostulacionDTO(metArchivoSolicitudDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validarLlenadoFormularioPostulacion(SolicitudPostulacionDTO solicitudPostulacionDTO){

		boolean validar = false;

		if(solicitudPostulacionDTO.getNombrePersonaSolicitudPostulacion()!=null && !"".equals(solicitudPostulacionDTO.getNombrePersonaSolicitudPostulacion())){
			if(solicitudPostulacionDTO.getApellidoPaternoPersonaSolicitudPostulacion()!=null && !"".equals(solicitudPostulacionDTO.getApellidoPaternoPersonaSolicitudPostulacion())){
				if(solicitudPostulacionDTO.getApellidoMaternoPersonaSolicitudPostulacion()!=null && !"".equals(solicitudPostulacionDTO.getApellidoMaternoPersonaSolicitudPostulacion())){
					if(solicitudPostulacionDTO.getIdProgramaUniversidadPostulacion()!= 0 ){
						if(solicitudPostulacionDTO.getRutPersonaSolicitudPostulacion()!=null && !"".equals(solicitudPostulacionDTO.getRutPersonaSolicitudPostulacion())){
							if(solicitudPostulacionDTO.getFechaNacimiento()!=null && !"".equals(solicitudPostulacionDTO.getFechaNacimiento())){
								if(solicitudPostulacionDTO.getMailMember()!=null && !"".equals(solicitudPostulacionDTO.getMailMember())){
									if(ValidacionPatrones.validarPatronEmail(solicitudPostulacionDTO.getMailMember())){	
										if(solicitudPostulacionDTO.getTituloProfesional()!=null && !"".equals(solicitudPostulacionDTO.getTituloProfesional())){
											if(solicitudPostulacionDTO.getEntidadEducacional()!=null && !"".equals(solicitudPostulacionDTO.getEntidadEducacional())){
												if(getArchivoSolicitudPostulacionDTO()==null){
													objLog.warn("Deben adjuntarse los documentos obligatorios para la postulación");
													//FacesContext.getCurrentInstance().addMessage(null, msg);
												}else{
													ArchivoSolicitudDTO metArchivoSolicitudPostulacionDTO = getArchivoSolicitudPostulacionDTO();
													if(metArchivoSolicitudPostulacionDTO!=null && metArchivoSolicitudPostulacionDTO.getIdArchivoSolicitud()>0){
														validar = true;
													}else{
														objLog.warn("No se han adjuntado los documentos obligatorios para la postulación");
														//FacesContext.getCurrentInstance().addMessage(null, msg);
													}
												}
											}else{
												objLog.warn("No se ingreso casa de estudios");
												//FacesContext.getCurrentInstance().addMessage(null, msg);
											}
										}else{
											objLog.warn("No se ingreso titulo profesional");
											//FacesContext.getCurrentInstance().addMessage(null, msg);
										}
									}else{
										objLog.warn("el mail ingresado no es valido");
										//FacesContext.getCurrentInstance().addMessage(null, msg);
									}
								}else{
									objLog.warn("No se ingreso email para postulación");
									//FacesContext.getCurrentInstance().addMessage(null, msg);
								}
							}else{
								objLog.warn("No se ingreso fecha de nacimiento del postulante");
								//FacesContext.getCurrentInstance().addMessage(null, msg);
							}
						}else{
							objLog.warn("No se ingreso rut del postulante");
							//FacesContext.getCurrentInstance().addMessage(null, msg);
						}
					}
					else{
						objLog.warn("No se seleccionó programa de la universidad");
						//FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				}else{
					objLog.warn("No se ingreso apellido materno del postulante");
					//FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}else{
				objLog.warn("No se ingreso apellido paterno del postulante");
				//FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}else{
			objLog.warn("No se ingreso nombre del postulante");
			//FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return validar;
	}

	/** @Do almacena/actualiza una aplicacion en la base de datos
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	boolean enviarCorreo = false;
	boolean online = false;
	
	public ResponseWebUchile almacenarSolicitudPostulacionPagoOffline() throws IOException {
		//Almacenar y redirigir a exito.xhtml
		if(generarAplicacion.getAuthenticacionContext()!=null){
			if(  almacenarSolicitudPostulacion( enviarCorreo, false)){
				return new ResponseWebUchile("web-uchile-front-solicitudes/main/view/solicitud-postulacion-exito.jsp", true);
			}
		}
		return new ResponseWebUchile(false);
	}
	
	public ResponseWebUchile almacenarSolicitudPostulacionPagoOnline() throws IOException {
		//Almacenar y redirigir a pago.xhtml
		if(generarAplicacion.getAuthenticacionContext()!=null){
			if( almacenarSolicitudPostulacion(enviarCorreo, true)){
				return new ResponseWebUchile("/pago.xhtml", true);
			}
		}
		return new ResponseWebUchile(false);

	}



	public boolean  almacenarSolicitudPostulacion(boolean enviarCorreo, boolean online) throws IOException { 

		boolean validar = false;

		validar = validarLlenadoFormularioPostulacion(solicitudPostulacionDTO);

		if(validar==true){

			try{
				//Asociar el archivo con la Solicitud Academica
				archivoSolicitudPostulacionDTO = getArchivoSolicitudPostulacionDTO();

				solicitudPostulacionDTO.setIdArchivoSolicitud(archivoSolicitudPostulacionDTO.getIdArchivoSolicitud());

				solicitudPostulacionDTO.setFechaSolicitudPostulacion(new Date());

				solicitudPostulacionDTO.setEstadoSolicitudPostulacion(1);

				objLog.info("1:"+solicitudPostulacionDTO.getNombrePersonaSolicitudPostulacion());
				objLog.info("2:"+solicitudPostulacionDTO.getApellidoPaternoPersonaSolicitudPostulacion());
				objLog.info("3:"+solicitudPostulacionDTO.getApellidoMaternoPersonaSolicitudPostulacion());
				objLog.info("4:"+solicitudPostulacionDTO.getRutPersonaSolicitudPostulacion());
				objLog.info("5:"+solicitudPostulacionDTO.getIdProgramaUniversidadPostulacion());
				objLog.info("5a:"+solicitudPostulacionDTO.getProgramaPostulacionUniversidad());
				objLog.info("6:"+solicitudPostulacionDTO.getMailMember());
				objLog.info("7:"+solicitudPostulacionDTO.getCelularContacto());
				objLog.info("8:"+solicitudPostulacionDTO.getCiudadDomicilio());
				objLog.info("9 fuentes:"+solicitudPostulacionDTO.getFuenteFinancimiamiento());
				objLog.info("10 comentarios:"+solicitudPostulacionDTO.getComentarios());
				objLog.info("11 interes:"+solicitudPostulacionDTO.getInteresPrograma());

				objLog.info("A1: creando Solicitud");
				
				if(solicitudPostulacionDTO.getIdRegionDomicilio()>0){
					solicitudPostulacionDTO.setNombreRegion(obtenerRegion(solicitudPostulacionDTO.getIdRegionDomicilio()));
				}

				if(solicitudPostulacionDTO.getIdComunaDomicilio()>0){
					solicitudPostulacionDTO.setNombreComuna(obtenerComuna(solicitudPostulacionDTO.getIdComunaDomicilio()));
				}
				
				solicitudPostulacionDTO.setProgramaPostulacionUniversidad(obtenerProgramaPostulacionUniversidad(solicitudPostulacionDTO.getIdProgramaUniversidadPostulacion()));
				
				SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();
				
				
				RequestProductoDTO requestProductoDTO = solicitudesModelo.almacenarSolicitudAdmisionPostgrado(generarAplicacion.getAuthenticacionContext(), solicitudPostulacionDTO);
					
				if(flujoEnviarCorreo==true && aplicacionEnviarCorreo==true ){
					
					requestProductoDTO.setSolicitudPostulacionDTO(solicitudPostulacionDTO);
					
					solicitudesModelo.enviarEmailSolicitudPostulacion(generarAplicacion.getAuthenticacionContext(), requestProductoDTO);
					
					objLog.info("A2: Envio Email");
				}else{
					objLog.info("A2: Envio Email false");
					objLog.info("flujoEnviarCorreo:"+flujoEnviarCorreo +" - aplicacionEnviarCorreo:"+aplicacionEnviarCorreo);
				}

				if(flujoPagoOnline == true && aplicacionPagoOnline==true && online == true){
					
					
					//##################################################
//					UchileArte uchileArte = clienteWsRestUtilidades.crearNegocioSolicitud(requestProductoDTO, ipServer);
					//##################################################
					objLog.info("A3: Creando Negocio Solicitud");
				}else{
					objLog.info("A3: Creando Negocio Solicitud false");
					objLog.info("flujoPagoOnline:"+flujoPagoOnline +" - aplicacionPagoOnline:"+aplicacionPagoOnline);
				}
				objLog.info("Creando Solicitud de Postulacion");
				
			}catch(Exception e){
				objLog.info("ERROR - almacenarSolicitudAcademica: "+solicitudPostulacionDTO.getRutPersonaSolicitudPostulacion()+" - "+e.getMessage());
				return false;
			}
			iniciliazarFormulario();

			if(flujoPagoOnline == true && aplicacionPagoOnline==true && online == true){
				//Navigation.redirectExterno(paginaRedireccion);
			}else{
				//Navigation.redirectInterno(paginaRedireccion);
			}
		}
		
		if(validar==false){
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ha realizado Solicitud");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return false;
		}
		
		objLog.info("A5: Fin almacenarSolicitudPostulacion");
		return true;
	}
	
	public String obtenerProgramaPostulacionUniversidad(int idProgramaPostulacionUniversidad) {
		for(ProgramaUniversidadPostulacionDTO ppuDTO: listaProgramaUniversidadPostulacionDTO){
			if(ppuDTO.getIdProgramaUniversidadPostulacion()==idProgramaPostulacionUniversidad){
				return ppuDTO.getNombreProgramaUniversidadPostulacion(); 
			}
		}
		return "";
	}


	/** @Do limpia e inicializa el formulario mediante el boton limpiar
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public String limpiarFormularioSolicitudPostulacion(){

		iniciliazarFormulario();

		return null;
	}

	public static String redirectInterno(String paginaRedireccion) {
		//Formato de linkInterno "/exito.xhtml"
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext extContext = ctx.getExternalContext();
		//se le agrega el encodeActionUrl
		//String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, "/exito.xhtml"));
		String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, paginaRedireccion));

		try {
			extContext.redirect(url);
		} catch (IOException ioe) {
			throw new FacesException(ioe);

		}
		return null;

	}



	public String obtenerRegion(int idRegion) {
		for(RegionDTO regDTO: listaRegionesDTO){
			if(regDTO.getIdRegion()==idRegion){
				return regDTO.getNombreRegion(); 
			}
		}
		return "";
	}

	public String obtenerComuna(int idComuna) {
		for(ComunaDTO comDTO: listaComunasDTO){
			if(comDTO.getIdComuna()==idComuna){
				return comDTO.getNombreComuna(); 
			}
		}
		return "";
	}
	/********************* METODOS DE FUNCIONAMIENTO ******************************/
	/******************GETTER y SETTER********************************************/

	public List<ProgramaUniversidadPostulacionDTO> getListaProgramaUniversidadPostulacionDTO() {
		return listaProgramaUniversidadPostulacionDTO;
	}

	public void setListaProgramaUniversidadPostulacionDTO(
			List<ProgramaUniversidadPostulacionDTO> listaProgramaUniversidadPostulacionDTO) {
		this.listaProgramaUniversidadPostulacionDTO = listaProgramaUniversidadPostulacionDTO;
	}

	public List<RegionDTO> getListaRegionesDTO() {
		return listaRegionesDTO;
	}

	public void setListaRegionesDTO(List<RegionDTO> listaRegionesDTO) {
		this.listaRegionesDTO = listaRegionesDTO;
	}

	public List<ComunaDTO> getListaComunasDTO() {
		return listaComunasDTO;
	}

	public void setListaComunasDTO(List<ComunaDTO> listaComunasDTO) {
		this.listaComunasDTO = listaComunasDTO;
	}

	public SolicitudPostulacionDTO getSolicitudPostulacionDTO() {
		return solicitudPostulacionDTO;
	}

	public void setSolicitudPostulacionDTO(SolicitudPostulacionDTO solicitudPostulacionDTO) {
		this.solicitudPostulacionDTO = solicitudPostulacionDTO;
	}

	public ProgramaUniversidadDTO getProgramaUniversidadDTO() {
		return programaUniversidadDTO;
	}

	public void setProgramaUniversidadDTO(ProgramaUniversidadDTO programaUniversidadDTO) {
		this.programaUniversidadDTO = programaUniversidadDTO;
	}

	public ArchivoSolicitudDTO getArchivoSolicitudPostulacionDTO() {
		return archivoSolicitudPostulacionDTO;
	}

	public void setArchivoSolicitudPostulacionDTO(ArchivoSolicitudDTO archivoSolicitudPostulacionDTO) {
		this.archivoSolicitudPostulacionDTO = archivoSolicitudPostulacionDTO;
	}

	public WebUchileProperties getWebUchileProperties() {
		return webUchileProperties;
	}

	public void setWebUchileProperties(WebUchileProperties webUchileProperties) {
		this.webUchileProperties = webUchileProperties;
	}

	public String getTextoCostoProgramaUniversidad() {
		return textoCostoProgramaUniversidad;
	}

	public void setTextoCostoProgramaUniversidad(String textoCostoProgramaUniversidad) {
		this.textoCostoProgramaUniversidad = textoCostoProgramaUniversidad;
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

	public boolean isMostrarCondicionesPago() {
		return mostrarCondicionesPago;
	}

	public void setMostrarCondicionesPago(boolean mostrarCondicionesPago) {
		this.mostrarCondicionesPago = mostrarCondicionesPago;
	}

	public boolean isDisabledRegion() {
		return disabledRegion;
	}

	public void setDisabledRegion(boolean disabledRegion) {
		this.disabledRegion = disabledRegion;
	}

	public boolean isDisabledComuna() {
		return disabledComuna;
	}

	public void setDisabledComuna(boolean disabledComuna) {
		this.disabledComuna = disabledComuna;
	}

	public boolean isMostrarBotonArchivo() {
		return mostrarBotonArchivo;
	}

	public void setMostrarBotonArchivo(boolean mostrarBotonArchivo) {
		this.mostrarBotonArchivo = mostrarBotonArchivo;
	}

	public boolean isMostrarNombreArchivo() {
		return mostrarNombreArchivo;
	}

	public void setMostrarNombreArchivo(boolean mostrarNombreArchivo) {
		this.mostrarNombreArchivo = mostrarNombreArchivo;
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

	public boolean isEnviarCorreo() {
		return enviarCorreo;
	}

	public void setEnviarCorreo(boolean enviarCorreo) {
		this.enviarCorreo = enviarCorreo;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
}
