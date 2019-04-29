package web.uchile.articular.session.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.AlumnoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.AlumnoProgramaActivoSemestreDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.AsignaturaProgramaActivoSemestreDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.AsignaturaTomadaProgramaActivoSemestreDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaActivoSemestreDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SemestreTemporadaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudAcademicaDTO;
import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;

import vijnana.utilidades.component.utilidades.ValidacionPatrones;
import web.uchile.articular.servicio.impl.SolicitudesUchileModelo;
import web.uchile.articular.servicio.properties.WebUchileProperties;


public class AlumnoUsuarioImpl {

	private static final Logger objLog = Logger.getLogger(AlumnoUsuarioImpl.class);

	/*********************************************/
//	private int selecPrograma = 0;
	/******************/
//	private List<ProgramaUniversidadDTO> listaProgramaUniversidadDTO = new ArrayList<ProgramaUniversidadDTO>();
//	private List<TipoSolicitudDTO> listaTipoSolicitudDTO = new ArrayList<TipoSolicitudDTO>();
//	private SolicitudAcademicaDTO solicitudAcademicaDTO = new SolicitudAcademicaDTO();
//	private ProgramaUniversidadDTO programaUniversidadDTO = new ProgramaUniversidadDTO();
//	private TipoSolicitudDTO tipoSolicitudDTO = new TipoSolicitudDTO();
//	private ArchivoSolicitudDTO archivoSolicitudDTO = new ArchivoSolicitudDTO();
	
	private AlumnoDTO alumnoDTO;
	private AlumnoProgramaActivoSemestreDTO alumnoProgramaActivoSemestreDTO;
	private AsignaturaProgramaActivoSemestreDTO asignaturaProgramaActivoSemestreDTO;
	private AsignaturaTomadaProgramaActivoSemestreDTO asignaturaTomadaProgramaActivoSemestreDTO;
	private ProgramaActivoSemestreDTO programaActivoSemestreDTO;
	private SemestreTemporadaDTO semestreTemporadaDTO;
	
	private List<AlumnoDTO> listaAlumnoDTO;
	private List<AlumnoProgramaActivoSemestreDTO> listaAlumnoProgramaActivoSemestreDTO;
	private List<AsignaturaProgramaActivoSemestreDTO> listaAsignaturaProgramaActivoSemestreDTO;
	private List<AsignaturaTomadaProgramaActivoSemestreDTO> listaAsignaturaTomadaProgramaActivoSemestreDTO;
	private List<ProgramaActivoSemestreDTO> listaProgramaActivoSemestreDTO;
	private List<SemestreTemporadaDTO> listaSemestreTemporadaDTO;
	
	
	private WebUchileProperties webUchileProperties = new WebUchileProperties();
	
	private boolean mostrarBotonArchivo;
	private boolean mostrarNombreArchivo;
	private int colspanBotonGuardar= 2;
	private int colspanBotonPagar = 0;
	
	private boolean checkNoAdjunto = false;

	private boolean flujoPagoOnline = false;
	private boolean aplicacionPagoOnline = false;
	private boolean flujoEnviarCorreo = false;
	private boolean aplicacionEnviarCorreo = false;
	
	private String remoteAddr = ""; 
	private String remoteHost= "";
	
	
	private String token = "";	
	
	GeneracionAplicacion generarAplicacion;
	
	public AlumnoUsuarioImpl(String remoteAddr, String remoteHost, String token){
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
		
		alumnoDTO = new AlumnoDTO();
		
		alumnoProgramaActivoSemestreDTO = new AlumnoProgramaActivoSemestreDTO();
		
		asignaturaProgramaActivoSemestreDTO = new  AsignaturaProgramaActivoSemestreDTO();
		
		asignaturaTomadaProgramaActivoSemestreDTO = new  AsignaturaTomadaProgramaActivoSemestreDTO();
		
		programaActivoSemestreDTO = new ProgramaActivoSemestreDTO();
		
		semestreTemporadaDTO = new  SemestreTemporadaDTO();
		
		listaAlumnoDTO = new ArrayList<AlumnoDTO>();
		
		listaAlumnoProgramaActivoSemestreDTO = new ArrayList<AlumnoProgramaActivoSemestreDTO>();
		
		listaAsignaturaProgramaActivoSemestreDTO = new ArrayList<AsignaturaProgramaActivoSemestreDTO>();
		
		listaAsignaturaTomadaProgramaActivoSemestreDTO = new ArrayList<AsignaturaTomadaProgramaActivoSemestreDTO>();
		
		listaProgramaActivoSemestreDTO =new ArrayList<ProgramaActivoSemestreDTO>();
		
		listaSemestreTemporadaDTO = new ArrayList<SemestreTemporadaDTO>();
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

		listaAlumnoNoAsociadoToUsuario(solicitudesModelo);

		listarAlumnoProgramaActivoSemestre(solicitudesModelo);
		
		inicializarBotonPago();
	}

	/** @Do inicializa los valores de los datos de disabled
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void inicializarDisabled(){

	}

	
	public void crearAlumnoDTO(SolicitudesUchileModelo solicitudesModelo){

		AlumnoDTO retAlumnoDTO = new AlumnoDTO();

		retAlumnoDTO  = solicitudesModelo.crearAlumno(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAlumnoDTO(retAlumnoDTO);
	}
	
	public void actualizarAlumnoDTO(SolicitudesUchileModelo solicitudesModelo){

		AlumnoDTO retAlumnoDTO = new AlumnoDTO();

		retAlumnoDTO  = solicitudesModelo.actualizarAlumno(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAlumnoDTO(retAlumnoDTO);
	}
	
	public void buscarAlumnoDTO(SolicitudesUchileModelo solicitudesModelo){

		AlumnoDTO retAlumnoDTO = new AlumnoDTO();

		retAlumnoDTO  = solicitudesModelo.buscarAlumno(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAlumnoDTO(retAlumnoDTO);
	}
	
	public void listaAlumnoNoAsociadoToUsuario(SolicitudesUchileModelo solicitudesModelo){

		List<AlumnoDTO> retListaAlumnoDTO = new ArrayList<AlumnoDTO>();

		retListaAlumnoDTO  = solicitudesModelo.listaAlumnoNoAsociadoToUsuario(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setListaAlumnoDTO(retListaAlumnoDTO);
	}
	
	public void crearAlumnoProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		AlumnoProgramaActivoSemestreDTO retAlumnoProgramaActivoSemestreDTO = new AlumnoProgramaActivoSemestreDTO();

		retAlumnoProgramaActivoSemestreDTO  = solicitudesModelo.crearAlumnoProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAlumnoProgramaActivoSemestreDTO(retAlumnoProgramaActivoSemestreDTO);
	}
	
	public void actualizarAlumnoProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		AlumnoProgramaActivoSemestreDTO retAlumnoProgramaActivoSemestreDTO = new AlumnoProgramaActivoSemestreDTO();

		retAlumnoProgramaActivoSemestreDTO  = solicitudesModelo.actualizarAlumnoProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAlumnoProgramaActivoSemestreDTO(retAlumnoProgramaActivoSemestreDTO);
	}
	
	public void buscarAlumnoProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		AlumnoProgramaActivoSemestreDTO retAlumnoProgramaActivoSemestreDTO = new AlumnoProgramaActivoSemestreDTO();

		retAlumnoProgramaActivoSemestreDTO  = solicitudesModelo.buscarAlumnoProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAlumnoProgramaActivoSemestreDTO(retAlumnoProgramaActivoSemestreDTO);
	}
	
	public void listarAlumnoProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		List<AlumnoProgramaActivoSemestreDTO> retListaAlumnoProgramaActivoSemestreDTO = new ArrayList<AlumnoProgramaActivoSemestreDTO>();

		retListaAlumnoProgramaActivoSemestreDTO  = solicitudesModelo.listarAlumnoProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setListaAlumnoProgramaActivoSemestreDTO(retListaAlumnoProgramaActivoSemestreDTO);
	}
	
	public void crearAsignaturaProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		AsignaturaProgramaActivoSemestreDTO retAsignaturaProgramaActivoSemestreDTO = new AsignaturaProgramaActivoSemestreDTO();

		retAsignaturaProgramaActivoSemestreDTO  = solicitudesModelo.crearAsignaturaProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAsignaturaProgramaActivoSemestreDTO(retAsignaturaProgramaActivoSemestreDTO);
	}
	
	public void actualizarAsignaturaProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		AsignaturaProgramaActivoSemestreDTO retAsignaturaProgramaActivoSemestreDTO = new AsignaturaProgramaActivoSemestreDTO();

		retAsignaturaProgramaActivoSemestreDTO  = solicitudesModelo.actualizarAsignaturaProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAsignaturaProgramaActivoSemestreDTO(retAsignaturaProgramaActivoSemestreDTO);
	}
	
	public void buscarAsignaturaProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		AsignaturaProgramaActivoSemestreDTO retAsignaturaProgramaActivoSemestreDTO = new AsignaturaProgramaActivoSemestreDTO();

		retAsignaturaProgramaActivoSemestreDTO  = solicitudesModelo.buscarAsignaturaProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAsignaturaProgramaActivoSemestreDTO(retAsignaturaProgramaActivoSemestreDTO);
	}
	
	public void listarAsignaturaProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		List<AsignaturaProgramaActivoSemestreDTO> retListaAsignaturaProgramaActivoSemestreDTO = new ArrayList<AsignaturaProgramaActivoSemestreDTO>();

		retListaAsignaturaProgramaActivoSemestreDTO  = solicitudesModelo.listarAsignaturaProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setListaAsignaturaProgramaActivoSemestreDTO(retListaAsignaturaProgramaActivoSemestreDTO);
	}
	
	public void crearAsignaturaTomadaProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		AsignaturaTomadaProgramaActivoSemestreDTO retAsignaturaTomadaProgramaActivoSemestreDTO = new AsignaturaTomadaProgramaActivoSemestreDTO();

		retAsignaturaTomadaProgramaActivoSemestreDTO  = solicitudesModelo.crearAsignaturaTomadaProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAsignaturaTomadaProgramaActivoSemestreDTO(retAsignaturaTomadaProgramaActivoSemestreDTO);
	}
	
	public void actualizarAsignaturaTomadaProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		AsignaturaTomadaProgramaActivoSemestreDTO retAsignaturaTomadaProgramaActivoSemestreDTO = new AsignaturaTomadaProgramaActivoSemestreDTO();

		retAsignaturaTomadaProgramaActivoSemestreDTO  = solicitudesModelo.actualizarAsignaturaTomadaProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAsignaturaTomadaProgramaActivoSemestreDTO(retAsignaturaTomadaProgramaActivoSemestreDTO);
	}
	
	public void buscarAsignaturaTomadaProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		AsignaturaTomadaProgramaActivoSemestreDTO retAsignaturaTomadaProgramaActivoSemestreDTO = new AsignaturaTomadaProgramaActivoSemestreDTO();

		retAsignaturaTomadaProgramaActivoSemestreDTO  = solicitudesModelo.buscarAsignaturaTomadaProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setAsignaturaTomadaProgramaActivoSemestreDTO(retAsignaturaTomadaProgramaActivoSemestreDTO);
	}
	
	public void listarAsignaturaTomadaProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		List<AsignaturaTomadaProgramaActivoSemestreDTO> retListaAsignaturaTomadaProgramaActivoSemestreDTO = new ArrayList<AsignaturaTomadaProgramaActivoSemestreDTO>();

		retListaAsignaturaTomadaProgramaActivoSemestreDTO  = solicitudesModelo.listarAsignaturaTomadaProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setListaAsignaturaTomadaProgramaActivoSemestreDTO(retListaAsignaturaTomadaProgramaActivoSemestreDTO);
	}
	
	public void crearProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		ProgramaActivoSemestreDTO retProgramaActivoSemestreDTO = new ProgramaActivoSemestreDTO();

		retProgramaActivoSemestreDTO  = solicitudesModelo.crearProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setProgramaActivoSemestreDTO(retProgramaActivoSemestreDTO);
	}
	
	public void actualizarProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		ProgramaActivoSemestreDTO retProgramaActivoSemestreDTO = new ProgramaActivoSemestreDTO();

		retProgramaActivoSemestreDTO  = solicitudesModelo.actualizarProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setProgramaActivoSemestreDTO(retProgramaActivoSemestreDTO);
	}
	
	public void buscarProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		ProgramaActivoSemestreDTO retProgramaActivoSemestreDTO = new ProgramaActivoSemestreDTO();

		retProgramaActivoSemestreDTO  = solicitudesModelo.buscarProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setProgramaActivoSemestreDTO(retProgramaActivoSemestreDTO);
	}
	
	public void listarProgramaActivoSemestre(SolicitudesUchileModelo solicitudesModelo){

		List<ProgramaActivoSemestreDTO> retListaProgramaActivoSemestreDTO = new ArrayList<ProgramaActivoSemestreDTO>();

		retListaProgramaActivoSemestreDTO  = solicitudesModelo.listarProgramaActivoSemestre(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setListaProgramaActivoSemestreDTO(retListaProgramaActivoSemestreDTO);
	}
	
	public void crearSemestreTemporada(SolicitudesUchileModelo solicitudesModelo){

		SemestreTemporadaDTO retSemestreTemporadaDTO = new SemestreTemporadaDTO();

		retSemestreTemporadaDTO  = solicitudesModelo.crearSemestreTemporada(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setSemestreTemporadaDTO(retSemestreTemporadaDTO);
	}
	
	public void actualizarSemestreTemporada(SolicitudesUchileModelo solicitudesModelo){

		SemestreTemporadaDTO retSemestreTemporadaDTO = new SemestreTemporadaDTO();

		retSemestreTemporadaDTO  = solicitudesModelo.actualizarSemestreTemporada(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setSemestreTemporadaDTO(retSemestreTemporadaDTO);
	}
	
	public void buscarSemestreTemporada(SolicitudesUchileModelo solicitudesModelo){

		SemestreTemporadaDTO retSemestreTemporadaDTO = new SemestreTemporadaDTO();

		retSemestreTemporadaDTO  = solicitudesModelo.buscarSemestreTemporada(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setSemestreTemporadaDTO(retSemestreTemporadaDTO);
	}
	
	public void listarSemestreTemporada(SolicitudesUchileModelo solicitudesModelo){

		List<SemestreTemporadaDTO> retListaSemestreTemporadaDTO = new ArrayList<SemestreTemporadaDTO>();

		retListaSemestreTemporadaDTO  = solicitudesModelo.listarSemestreTemporada(generarAplicacion.getAuthenticacionContext(), new RequestProductoDTO());

		setListaSemestreTemporadaDTO(retListaSemestreTemporadaDTO);
	}
	
	public void inicializarBotonAdjunto(){
	}
	
	public void inicializarBotonPago(){
		
		
//		selecPrograma = 0;
		
		flujoPagoOnline = Boolean.parseBoolean(webUchileProperties.getServerFlujoPagoOnlineActivo());

		aplicacionPagoOnline = Boolean.parseBoolean(webUchileProperties.getLocalSolicitudAcademicaPagoOnlineactivo());

		flujoEnviarCorreo = Boolean.parseBoolean(webUchileProperties.getServerFlujoCorreoActivo());

		aplicacionEnviarCorreo = Boolean.parseBoolean(webUchileProperties.getLocalSolicitudAcademicaCorreoActivo());

		if(flujoPagoOnline && aplicacionPagoOnline){
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
	public boolean almacenarSolicitudAcademicaPagoOffline() {
		//Almacenar y redirigir a exito.xhtml
		String paginaRedireccion = "/exito.xhtml";
		
		if(generarAplicacion.getAuthenticacionContext()!=null){
			if(almacenarSolicitudAcademica(paginaRedireccion, false)){
				return true;
			}
		}
		
		return false;
	}

	public boolean almacenarSolicitudAcademicaPagoOnline() throws IOException {
		//Almacenar y redirigir a pago.xhtml
		String paginaRedireccion = "/pago.xhtml";
		if(generarAplicacion.getAuthenticacionContext()!=null){
			if(almacenarSolicitudAcademica(paginaRedireccion, true)){
				return true;
			}
		}
		return false;
	}



	/*AlmacenarSolicitud recibe Online y Offline, envio Correo o sin envio*/
	public boolean almacenarSolicitudAcademica(String paginaRedireccion, boolean online) {
//		objLog.info("INI - almacenarSolicitudAcademica:"+solicitudAcademicaDTO.getRutPersonaSolicitudAcademica());
//		FacesContext context = FacesContext.getCurrentInstance();
		
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

	public AlumnoDTO getAlumnoDTO() {
		return alumnoDTO;
	}

	public void setAlumnoDTO(AlumnoDTO alumnoDTO) {
		this.alumnoDTO = alumnoDTO;
	}

	public AlumnoProgramaActivoSemestreDTO getAlumnoProgramaActivoSemestreDTO() {
		return alumnoProgramaActivoSemestreDTO;
	}

	public void setAlumnoProgramaActivoSemestreDTO(AlumnoProgramaActivoSemestreDTO alumnoProgramaActivoSemestreDTO) {
		this.alumnoProgramaActivoSemestreDTO = alumnoProgramaActivoSemestreDTO;
	}

	public AsignaturaProgramaActivoSemestreDTO getAsignaturaProgramaActivoSemestreDTO() {
		return asignaturaProgramaActivoSemestreDTO;
	}

	public void setAsignaturaProgramaActivoSemestreDTO(
			AsignaturaProgramaActivoSemestreDTO asignaturaProgramaActivoSemestreDTO) {
		this.asignaturaProgramaActivoSemestreDTO = asignaturaProgramaActivoSemestreDTO;
	}

	public AsignaturaTomadaProgramaActivoSemestreDTO getAsignaturaTomadaProgramaActivoSemestreDTO() {
		return asignaturaTomadaProgramaActivoSemestreDTO;
	}

	public void setAsignaturaTomadaProgramaActivoSemestreDTO(
			AsignaturaTomadaProgramaActivoSemestreDTO asignaturaTomadaProgramaActivoSemestreDTO) {
		this.asignaturaTomadaProgramaActivoSemestreDTO = asignaturaTomadaProgramaActivoSemestreDTO;
	}

	public ProgramaActivoSemestreDTO getProgramaActivoSemestreDTO() {
		return programaActivoSemestreDTO;
	}

	public void setProgramaActivoSemestreDTO(ProgramaActivoSemestreDTO programaActivoSemestreDTO) {
		this.programaActivoSemestreDTO = programaActivoSemestreDTO;
	}

	public SemestreTemporadaDTO getSemestreTemporadaDTO() {
		return semestreTemporadaDTO;
	}

	public void setSemestreTemporadaDTO(SemestreTemporadaDTO semestreTemporadaDTO) {
		this.semestreTemporadaDTO = semestreTemporadaDTO;
	}

	public List<AlumnoDTO> getListaAlumnoDTO() {
		return listaAlumnoDTO;
	}

	public void setListaAlumnoDTO(List<AlumnoDTO> listaAlumnoDTO) {
		this.listaAlumnoDTO = listaAlumnoDTO;
	}

	public List<AlumnoProgramaActivoSemestreDTO> getListaAlumnoProgramaActivoSemestreDTO() {
		return listaAlumnoProgramaActivoSemestreDTO;
	}

	public void setListaAlumnoProgramaActivoSemestreDTO(
			List<AlumnoProgramaActivoSemestreDTO> listaAlumnoProgramaActivoSemestreDTO) {
		this.listaAlumnoProgramaActivoSemestreDTO = listaAlumnoProgramaActivoSemestreDTO;
	}

	public List<AsignaturaProgramaActivoSemestreDTO> getListaAsignaturaProgramaActivoSemestreDTO() {
		return listaAsignaturaProgramaActivoSemestreDTO;
	}

	public void setListaAsignaturaProgramaActivoSemestreDTO(
			List<AsignaturaProgramaActivoSemestreDTO> listaAsignaturaProgramaActivoSemestreDTO) {
		this.listaAsignaturaProgramaActivoSemestreDTO = listaAsignaturaProgramaActivoSemestreDTO;
	}

	public List<AsignaturaTomadaProgramaActivoSemestreDTO> getListaAsignaturaTomadaProgramaActivoSemestreDTO() {
		return listaAsignaturaTomadaProgramaActivoSemestreDTO;
	}

	public void setListaAsignaturaTomadaProgramaActivoSemestreDTO(
			List<AsignaturaTomadaProgramaActivoSemestreDTO> listaAsignaturaTomadaProgramaActivoSemestreDTO) {
		this.listaAsignaturaTomadaProgramaActivoSemestreDTO = listaAsignaturaTomadaProgramaActivoSemestreDTO;
	}

	public List<ProgramaActivoSemestreDTO> getListaProgramaActivoSemestreDTO() {
		return listaProgramaActivoSemestreDTO;
	}

	public void setListaProgramaActivoSemestreDTO(List<ProgramaActivoSemestreDTO> listaProgramaActivoSemestreDTO) {
		this.listaProgramaActivoSemestreDTO = listaProgramaActivoSemestreDTO;
	}

	public List<SemestreTemporadaDTO> getListaSemestreTemporadaDTO() {
		return listaSemestreTemporadaDTO;
	}

	public void setListaSemestreTemporadaDTO(List<SemestreTemporadaDTO> listaSemestreTemporadaDTO) {
		this.listaSemestreTemporadaDTO = listaSemestreTemporadaDTO;
	}

	public WebUchileProperties getWebUchileProperties() {
		return webUchileProperties;
	}

	public void setWebUchileProperties(WebUchileProperties webUchileProperties) {
		this.webUchileProperties = webUchileProperties;
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
