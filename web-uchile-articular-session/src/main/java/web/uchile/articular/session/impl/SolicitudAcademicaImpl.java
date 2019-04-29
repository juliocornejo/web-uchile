package web.uchile.articular.session.impl;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ArchivoSolicitudDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudAcademicaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoSolicitudDTO;
import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;

import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.GenerarAlmacenamientoArchivos;
import vijnana.utilidades.component.utilidades.TipoFormatoFecha;
import vijnana.utilidades.component.utilidades.ValidacionPatrones;
import web.uchile.articular.servicio.impl.SolicitudesUchileModelo;
import web.uchile.articular.servicio.properties.WebUchileProperties;
import web.uchile.articular.session.model.ResponseWebUchile;


public class SolicitudAcademicaImpl {

	private static final Logger objLog = Logger.getLogger(SolicitudAcademicaImpl.class);

	/*********************************************/
//	private int selecPrograma = 0;
	/******************/
	private List<ProgramaUniversidadDTO> listaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();
	private List<TipoSolicitudDTO> listaTipoSolicitudDTO = new ArrayList<TipoSolicitudDTO>();
	private SolicitudAcademicaDTO solicitudAcademicaDTO = new SolicitudAcademicaDTO();
	private ProgramaUniversidadDTO programaUniversidadDTO = new ProgramaUniversidadDTO();
	private TipoSolicitudDTO tipoSolicitudDTO = new TipoSolicitudDTO();
	private ArchivoSolicitudDTO archivoSolicitudDTO = new ArchivoSolicitudDTO();
	
	private WebUchileProperties webUchileProperties = new WebUchileProperties();
	
	private File file=null;
	
	private boolean mostrarBotonArchivo;
	private boolean mostrarNombreArchivo;
	private int colspanBotonGuardar= 2;
	private int colspanBotonPagar = 0;
	
	private boolean reversoArchivoSolicitud =true;
	private boolean adjuntoArchivoSolicitud =false;
	private boolean checkNoAdjunto = false;

	private boolean flujoPagoOnline = false;
	private boolean aplicacionPagoOnline = false;
	private boolean flujoEnviarCorreo = false;
	private boolean aplicacionEnviarCorreo = false;
	private boolean mostrarBotonPagoOnline = false;
	
	private String remoteAddr = ""; 
	private String remoteHost= "";
	
	
	private String token = "";	
	
	GeneracionAplicacion generarAplicacion;
	
	public SolicitudAcademicaImpl(String remoteAddr, String remoteHost, String token){
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
	public void inicializarValoresDTO(){
		
//		selecPrograma = 0;
		
		solicitudAcademicaDTO= new SolicitudAcademicaDTO();

		listaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();

		listaTipoSolicitudDTO = new ArrayList<TipoSolicitudDTO>();
	}

	/** @Do inicializa los valores de los datos de trabajo del formulario
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
//	public void inicializarValoresDTO(){
//		selecPrograma = 0;
//		solicitudAcademicaDTO = new SolicitudAcademicaDTO();
//		listaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();
//		listaTipoSolicitudDTO = new ArrayList<TipoSolicitudDTO>();
//		archivoSolicitudDTO = new ArchivoSolicitudDTO();
//		reversoArchivoSolicitud =true;
//		adjuntoArchivoSolicitud =false;
//		setMostrarBotonArchivo(true);
//		setMostrarNombreArchivo(false);
//		checkNoAdjunto = false;
//	}

	/** @Do genera los valores de disabled y llenado de combobox del formulario 
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void generarValoresFormulario(){
		
		SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();
		
		inicializarDisabled();

		listarProgramasUniversidadDTO(solicitudesModelo);

		listarTipoSolicitudDTO(solicitudesModelo);
		
		inicializarSubirArchivo();
		
		inicializarBotonPago();
	}

	/** @Do inicializa los valores de los datos de disabled
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void inicializarDisabled(){

	}

	
	public void listarProgramasUniversidadDTO(SolicitudesUchileModelo solicitudesModelo){

		List<ProgramaUniversidadDTO> retListaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();

		retListaProgramaUniversidadDTO  = solicitudesModelo.listarProgramasUniversidadOrden(generarAplicacion.getAuthenticacionContext());

		setListaProgramaUniversidadDTO(retListaProgramaUniversidadDTO);
	}
	
	public void listarTipoSolicitudDTO(SolicitudesUchileModelo solicitudesModelo){

		List<TipoSolicitudDTO> retListaTipoSolicitudDTO = new ArrayList<TipoSolicitudDTO>();

		retListaTipoSolicitudDTO  = solicitudesModelo.listarTipoSolicitudOrden(generarAplicacion.getAuthenticacionContext());

		setListaTipoSolicitudDTO(retListaTipoSolicitudDTO);
	}
	
	public void inicializarSubirArchivo(){
		try {
			fileNulo();
			inicializarBotonAdjunto();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void inicializarBotonAdjunto(){
		reversoArchivoSolicitud =true;
		adjuntoArchivoSolicitud =false;
		setMostrarBotonArchivo(true);
		setMostrarNombreArchivo(false);
		checkNoAdjunto = false;
	}
	
	public void inicializarBotonPago(){
		
		
//		selecPrograma = 0;
		
		flujoPagoOnline = Boolean.parseBoolean(webUchileProperties.getServerFlujoPagoOnlineActivo());

		aplicacionPagoOnline = Boolean.parseBoolean(webUchileProperties.getLocalSolicitudAcademicaPagoOnlineactivo());

		flujoEnviarCorreo = Boolean.parseBoolean(webUchileProperties.getServerFlujoCorreoActivo());

		aplicacionEnviarCorreo = Boolean.parseBoolean(webUchileProperties.getLocalSolicitudAcademicaCorreoActivo());

		if(flujoPagoOnline && aplicacionPagoOnline){
			setMostrarBotonPagoOnline(true);
			colspanBotonGuardar= 1;
			colspanBotonPagar = 1;

		}
	}


	/***********************INICIALIZAR VALORES DEL FORMULARIO ********************/
	/********************* METODOS DE FUNCIONAMIENTO /ACTIVIDADES ******************************/


	public void fileNulo() throws IOException {
		setFile(null);
	}

	public void handleFileUpload( InputStream entrega, File f, byte[] contenido){
		objLog.info("INI handleFileUpload");
		
		try {
			long size = f.length();
			if(size<20646905){
				GenerarAlmacenamientoArchivos GenerarAlmacenamientoArchivos = new GenerarAlmacenamientoArchivos();

				String filePath = GenerarAlmacenamientoArchivos.generarNombreCarpetaProyectoNombreArchivo("solicitudesAcademicas", f.getPath());

				GenerarAlmacenamientoArchivos.almacenarObjectFile(f, filePath, contenido);

				solicitudAcademicaDTO.setNombreArchivo(f.getPath());

				archivoSolicitudDTO = new ArchivoSolicitudDTO();
				/************/
				solicitudAcademicaDTO.setNombreArchivo(f.getPath());
				setReversoArchivoSolicitud(false);
				setAdjuntoArchivoSolicitud(true);

				archivoSolicitudDTO.setNombreArchivoSolicitud(f.getPath());

				archivoSolicitudDTO.setDireccionAlmacenamientoArchivoSolicitud(filePath);

				archivoSolicitudDTO.setTipoArchivoSolicitud("solicitudAcademica");

				checkNoAdjunto = false;

				objLog.info("archivo:"+filePath+""+f.getPath());
				/************/
				RequestProductoDTO requestProductoDTO = new RequestProductoDTO();
				
				requestProductoDTO.setArchivoSolicitudDTO(archivoSolicitudDTO);
				// Mostrar Todo
				SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();

				ArchivoSolicitudDTO metArchivoSolicitudDTO = solicitudesModelo.handleFileUpload(generarAplicacion.getAuthenticacionContext(), archivoSolicitudDTO);
				
				setMostrarBotonArchivo(false);
				
				setMostrarNombreArchivo(true);
				
				setArchivoSolicitudDTO(metArchivoSolicitudDTO);
				
				setFile(f);

				if(archivoSolicitudDTO!=null && archivoSolicitudDTO.getNombreArchivoSolicitud()!=null && archivoSolicitudDTO.getTipoArchivoSolicitud()!=null){
					objLog.info("I - validarFundamenteSolicitudAcademica: "+solicitudAcademicaDTO.getTipoSolicitud());
				}

			}else{
				objLog.info("Archivo " + f.getPath() + " el archivo ha excedido el tamaño maximo 20MB.");
			}
			//Guardar el nombre y la direccion en la base de datos "archivoSolicitud y relacionarlo con solicitudAcademica"
		} catch (Exception e) {
			e.printStackTrace();
		}


		objLog.info("FIN handleFileUpload");

	}

	/** @Do valida si el llenado de los datos del formulario es correcto o no.
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public boolean validarLlenadoFormulario(SolicitudAcademicaDTO solicitudAcademicaDTO){
		boolean validar = false;

		if(solicitudAcademicaDTO.getNombrePersonaSolicitudAcademica()!=null && !"".equals(solicitudAcademicaDTO.getNombrePersonaSolicitudAcademica())){
			if(solicitudAcademicaDTO.getApellidoPaternoPersonaSolicitudAcademica()!=null && !"".equals(solicitudAcademicaDTO.getApellidoPaternoPersonaSolicitudAcademica())){
				if(solicitudAcademicaDTO.getApellidoMaternoPersonaSolicitudAcademica()!=null && !"".equals(solicitudAcademicaDTO.getApellidoMaternoPersonaSolicitudAcademica())){
					if(solicitudAcademicaDTO.getRutPersonaSolicitudAcademica()!=null && !"".equals(solicitudAcademicaDTO.getRutPersonaSolicitudAcademica())){
						if(solicitudAcademicaDTO.getIdProgramaUniversidad()!= 0 ){
								if(solicitudAcademicaDTO.getMailMember()!=null && !"".equals(solicitudAcademicaDTO.getMailMember())){
									if(ValidacionPatrones.validarPatronEmail(solicitudAcademicaDTO.getMailMember())){	
										if(solicitudAcademicaDTO.getAnhoIngreso()!=null && !"".equals(solicitudAcademicaDTO.getAnhoIngreso())){
											if(solicitudAcademicaDTO.getIdTipoSolicitud()!=0){
												if(solicitudAcademicaDTO.getFundamentacionSolicitud()!=null && !"".equals(solicitudAcademicaDTO.getFundamentacionSolicitud())){
													validar = true;
												}else{
													objLog.error("No se fundamento la solicitud académica");
												}
											}else{
												objLog.error("No se seleccionó tipo de solicitud del alumno");
												
											}
										}else{
											objLog.error( "No se seleccionó año de ingreso del alumno");
										}
									}else{
										objLog.error("el mail ingresado no es valido");
									}
								}
								else{
									objLog.error( "No se ingreso el mail del alumno");
								}
						}else{
							objLog.error( "No se seleccionó programa de la universidad");
						}
					}else{
						objLog.error( "No se ingreso rut del alumno");
					}
				}else{
					objLog.error( "No se ingreso apellido materno del alumno");
				}
			}else{
				objLog.error( "No se ingreso apellido paterno del alumno");
			}
		}else{
			objLog.error( "No se ingreso nombre del alumno");
		}

		return validar;
	}




	/** @Do almacena/actualiza una aplicacion en la base de datos
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public ResponseWebUchile almacenarSolicitudAcademicaPagoOffline() {
		//Almacenar y redirigir a exito.xhtml
		String paginaRedireccion = "/exito.xhtml";
		
		if(generarAplicacion.getAuthenticacionContext()!=null){
			if(almacenarSolicitudAcademica(paginaRedireccion, false)){
				return new ResponseWebUchile("web-uchile-front-solicitudes/main/view/solicitud-academica-exito.jsp", true);
			}
		}
		
		return new ResponseWebUchile(false);
	}

	public ResponseWebUchile almacenarSolicitudAcademicaPagoOnline() throws IOException {
		//Almacenar y redirigir a pago.xhtml
		String paginaRedireccion = "/pago.xhtml";
		if(generarAplicacion.getAuthenticacionContext()!=null){
			if(almacenarSolicitudAcademica(paginaRedireccion, true)){
				return new ResponseWebUchile("web-uchile-front-solicitudes/main/view/solicitud-certificado-exito.jsp", true);
			}
		}
		return new ResponseWebUchile(false);
	}



	/*AlmacenarSolicitud recibe Online y Offline, envio Correo o sin envio*/
	public boolean almacenarSolicitudAcademica(String paginaRedireccion, boolean online) {
		objLog.info("INI - almacenarSolicitudAcademica:"+solicitudAcademicaDTO.getRutPersonaSolicitudAcademica());
//		FacesContext context = FacesContext.getCurrentInstance();

		boolean validar = validarLlenadoFormulario(solicitudAcademicaDTO);

		if(validar==true){

			try{
				archivoSolicitudDTO = getArchivoSolicitudDTO();
				if(archivoSolicitudDTO==null){
					//Todo Ok
				}
				else{

					objLog.info("1:"+solicitudAcademicaDTO.getNombrePersonaSolicitudAcademica());
					objLog.info("2:"+solicitudAcademicaDTO.getApellidoPaternoPersonaSolicitudAcademica());
					objLog.info("3:"+solicitudAcademicaDTO.getApellidoMaternoPersonaSolicitudAcademica());
					objLog.info("4:"+solicitudAcademicaDTO.getRutPersonaSolicitudAcademica());
					objLog.info("5:"+solicitudAcademicaDTO.getIdProgramaUniversidad());
					objLog.info("6:"+solicitudAcademicaDTO.getMailMember());
					objLog.info("7:"+solicitudAcademicaDTO.getAnhoIngreso());
					objLog.info("8:"+solicitudAcademicaDTO.getIdTipoSolicitud());
					objLog.info("9:"+solicitudAcademicaDTO.getFundamentacionSolicitud()); 
					
//					int hayArchivo = 0;
					
//					String archivo = null;
					if(checkNoAdjunto!=true && archivoSolicitudDTO!=null && archivoSolicitudDTO.getIdArchivoSolicitud()>0){	
						//Se relaciona la direccion del archivo almacenado con la solicitud academica.
						if(archivoSolicitudDTO.getNombreArchivoSolicitud()!=null){
							objLog.info("10:"+archivoSolicitudDTO.getNombreArchivoSolicitud());
						}
						solicitudAcademicaDTO.setIdArchivoSolicitud(archivoSolicitudDTO.getIdArchivoSolicitud());
						solicitudAcademicaDTO.setArchivoAdjunto(true);
//						hayArchivo = 1;
//						archivo = solicitudAcademicaDTO.getIdArchivoSolicitud()+"";

					}else{
						solicitudAcademicaDTO.setArchivoAdjunto(false);
					}

				}
				//Asociar la direccion del Archivo almacenado
				solicitudAcademicaDTO.setFechaSolicitud(new Date());

				solicitudAcademicaDTO.setEstadoSolicitud(1);

				SolicitudesUchileModelo solicitudesModelo = new SolicitudesUchileModelo();

				RequestProductoDTO requestProductoDTO = solicitudesModelo.almacenarSolicitudAcademica(generarAplicacion.getAuthenticacionContext(), solicitudAcademicaDTO);
				
				if(requestProductoDTO!=null){
					objLog.info("A1: creando Solicitud");

					requestProductoDTO.getSolicitudAcademicaDTO().setIdSolicitudAcademica(solicitudAcademicaDTO.getIdSolicitudAcademica());
					
					requestProductoDTO.getSolicitudAcademicaDTO().setSfechaSolicitud(AppDate.obtenerFechaEnFormato(solicitudAcademicaDTO.getFechaSolicitud(), TipoFormatoFecha.DD_MM_YYYY));

					if(flujoEnviarCorreo==true && aplicacionEnviarCorreo==true ){
						solicitudesModelo.enviarEmailSolicitudAcademica(generarAplicacion.getAuthenticacionContext(), requestProductoDTO);
						objLog.info("A2: Envio Email");
					}else{
						objLog.info("A2: Envio Email false");
						objLog.info("flujoEnviarCorreo:"+flujoEnviarCorreo +" - aplicacionEnviarCorreo:"+aplicacionEnviarCorreo);
					}

					if(flujoPagoOnline == true && aplicacionPagoOnline==true && online == true){
						
						requestProductoDTO.setSolicitudAcademicaDTO(solicitudAcademicaDTO);
						
						solicitudesModelo.almacenarBusinessAcademica(generarAplicacion.getAuthenticacionContext(), requestProductoDTO, online);
					
						objLog.info("A3: Creando Negocio Solicitud");
						
					}else{
						objLog.info("A3: Creando Negocio Solicitud false");
						objLog.info("flujoPagoOnline:"+flujoPagoOnline +" - aplicacionPagoOnline:"+aplicacionPagoOnline);
					}
					return true;
				}else{
					return false;
				}
				
			

			}
			catch(Exception e){
				e.printStackTrace();
				objLog.info("ERROR - almacenarSolicitudAcademica:"+solicitudAcademicaDTO.getRutPersonaSolicitudAcademica()+" - "+e.getMessage());
				return false;
			}

		}

		objLog.info("A5: Fin almacenarSolicitudAcademica");
		return false;
	}


	/** @Do limpia e inicializa el formulario mediante el boton limpiar
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public String limpiarFormularioSolicitudAcademica(){

		inicializarValoresDTO();

		return null;
	}
	/********************* METODOS DE FUNCIONAMIENTO ******************************/
	/******************GETTER y SETTER********************************************/

	public List<ProgramaUniversidadDTO> getListaProgramaUniversidadDTO() {
		return listaProgramaUniversidadDTO;
	}

	public void setListaProgramaUniversidadDTO(List<ProgramaUniversidadDTO> listaProgramaUniversidadDTO) {
		this.listaProgramaUniversidadDTO = listaProgramaUniversidadDTO;
	}

	public List<TipoSolicitudDTO> getListaTipoSolicitudDTO() {
		return listaTipoSolicitudDTO;
	}

	public void setListaTipoSolicitudDTO(List<TipoSolicitudDTO> listaTipoSolicitudDTO) {
		this.listaTipoSolicitudDTO = listaTipoSolicitudDTO;
	}

	public SolicitudAcademicaDTO getSolicitudAcademicaDTO() {
		return solicitudAcademicaDTO;
	}

	public void setSolicitudAcademicaDTO(SolicitudAcademicaDTO solicitudAcademicaDTO) {
		this.solicitudAcademicaDTO = solicitudAcademicaDTO;
	}

	public ProgramaUniversidadDTO getProgramaUniversidadDTO() {
		return programaUniversidadDTO;
	}

	public void setProgramaUniversidadDTO(ProgramaUniversidadDTO programaUniversidadDTO) {
		this.programaUniversidadDTO = programaUniversidadDTO;
	}

	public TipoSolicitudDTO getTipoSolicitudDTO() {
		return tipoSolicitudDTO;
	}

	public void setTipoSolicitudDTO(TipoSolicitudDTO tipoSolicitudDTO) {
		this.tipoSolicitudDTO = tipoSolicitudDTO;
	}

	public ArchivoSolicitudDTO getArchivoSolicitudDTO() {
		return archivoSolicitudDTO;
	}

	public void setArchivoSolicitudDTO(ArchivoSolicitudDTO archivoSolicitudDTO) {
		this.archivoSolicitudDTO = archivoSolicitudDTO;
	}

	public WebUchileProperties getWebUchileProperties() {
		return webUchileProperties;
	}

	public void setWebUchileProperties(WebUchileProperties webUchileProperties) {
		this.webUchileProperties = webUchileProperties;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
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

	public boolean isReversoArchivoSolicitud() {
		return reversoArchivoSolicitud;
	}

	public void setReversoArchivoSolicitud(boolean reversoArchivoSolicitud) {
		this.reversoArchivoSolicitud = reversoArchivoSolicitud;
	}

	public boolean isAdjuntoArchivoSolicitud() {
		return adjuntoArchivoSolicitud;
	}

	public void setAdjuntoArchivoSolicitud(boolean adjuntoArchivoSolicitud) {
		this.adjuntoArchivoSolicitud = adjuntoArchivoSolicitud;
	}

	public boolean isCheckNoAdjunto() {
		return checkNoAdjunto;
	}

	public void setCheckNoAdjunto(boolean checkNoAdjunto) {
		this.checkNoAdjunto = checkNoAdjunto;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public GeneracionAplicacion getGenerarAplicacion() {
		return generarAplicacion;
	}

	public void setGenerarAplicacion(GeneracionAplicacion generarAplicacion) {
		this.generarAplicacion = generarAplicacion;
	}
}
