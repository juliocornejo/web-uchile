package web.uchile.articular.servicio.properties;

import java.io.Serializable;

import vijnana.wsrest.client.impl.PropertiesCliente;

public class WebUchileProperties implements Serializable {

	private static final long serialVersionUID = 1L;

	public WebUchileProperties(){
		super();
	}

	public String getVijnanaServidor(){

		PropertiesCliente propertiesCliente = new PropertiesCliente();
		
		PropertiesServerAplicacion propertiesServerAplicacion = new PropertiesServerAplicacion();

		String servidorProp =  propertiesCliente.getWProduccion(propertiesServerAplicacion.obtenerAmbiente());

		return servidorProp;
	}
	
	public int getVijnanaClientTimeoutConexion(){

		PropertiesCliente propertiesCliente = new PropertiesCliente();

		String retorno =  propertiesCliente.getWClientTimeoutConexion();
		
		try{
			if(new Integer(Integer.parseInt(retorno)) instanceof Integer){
				return Integer.parseInt(retorno);
			}
		}
		catch(Exception e){
			return 0;
		}
		return 0;
	}
	
	public int getVijnanaClientReadConexion(){
		PropertiesCliente propertiesCliente = new PropertiesCliente();
		
		String retorno =  propertiesCliente.getWClientReadConexion();
		
		try{
			if(new Integer(Integer.parseInt(retorno)) instanceof Integer){
				return Integer.parseInt(retorno);
			}
		}
		catch(Exception e){
			return 0;
		}
		return 0;
	}

//	public String getLocalObtenerBasicContext() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalObtenerBasicContext();
//
//		return retorno;
//	}
//
//	public String getLocalObtenerEnterpriseContext() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalObtenerEnterpriseContext();
//
//		return retorno;
//	}
//
//	public String getLocalObtenerAuthenticacionContext() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalObtenerAuthenticacionContext();
//
//		return retorno;
//	}
//	
//	public String getLocalRegistrarSessionPLataforma() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalRegistrarSessionPLataforma();
//
//		return retorno;
//	}
//	
//	public String getLocalGetSessionPLataforma() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalGetSessionPLataforma();
//
//		return retorno;
//	}
//
//	public String getLocalObtenerUsuarioLogin() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalObtenerUsuarioLogin();
//
//		return retorno;
//	}
//	
//	public String getLocalObtenerServicioAutenticacion() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalObtenerServicioAutenticacion();
//
//		return retorno;
//	}

//	public String getLocalValidarExistenciaRut() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//		
//		String wserver  = metProp.getLocalValidarExistenciaRut();
//		
//		return wserver;
//	}
//	
//	public String getLocalValidarExistenciaCorreoElectronico() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//		
//		String wserver = metProp.getLocalValidarExistenciaCorreoElectronico();
//		
//		return wserver;
//	}
//	
//	public String getLocalValidarExistenciaUsernameLogin() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//		
//		String wserver  = metProp.getLocalValidarExistenciaUsernameLogin();
//		
//		return wserver;
//	}
//	
//	public String getLocalValidarExistenciaNombrePerfil() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//		
//		String wserver  = metProp.getLocalValidarExistenciaNombrePerfil();
//		
//		return wserver;
//	}
//	
//	public String getLocalNuevoUsuarioSeguridad() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalCrearNuevoUsuarioSeguridad();
//		return retorno;
//	}
//	
//	public String getLocalActualizarUsuarioSeguridad() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalActualizarNuevoUsuarioSeguridad();
//		return retorno;
//	}
//	
//	public String getLocalRecuperarContrasenhaUsuarioSeguridad() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalRecuperarContrasenhaUsuarioSeguridad();
//		return retorno;
//	}
//	
//	public String getLocalCambiarContrasenhaUsuarioSeguridad() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalCambiarContrasenhaUsuarioSeguridad();
//		return retorno;
//	}
//	
//	public String getLocalListarUsuarioSeguridadxEmpresaxRolxFechaCreacion() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalListarUsuarioSeguridadxEmpresaxRolxFechaCreacion();	
//		
//		return retorno;
//	}
//	
//	public String getLocalObtenerUsuarioSeguridadByIdUsuarioByEmailPerfil() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalObtenerUsuarioSeguridadByIdUsuarioByEmailPerfil();	
//		
//		return retorno;
//	}
//	
//	public String getLocalWebmailEnviarCorreoCreacionUsuario() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//
//		String retorno = metProp.getLocalWebmailEnviarCorreoCreacionUsuario();	
//		
//		return retorno;
//	}
	
//	public String getLocalListarTipoAccionUsuario() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//		
//		String retorno = metProp.getLocalListarTipoAccionUsuario();
//		
//		return retorno;
//	}
	
//	public String getLocalListarAccionPerfilUsuario() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//		
//		String retorno = metProp.getLocalListarAccionPerfilUsuario();
//		
//		return retorno;
//	}
//	
//	
//	
//	public String getLocalRegistrarAccionPerfilUsuario() {
//		WebUchileLocalAplicacion metProp = new WebUchileLocalAplicacion();
//		
//		String retorno = metProp.getLocalRegistrarAccionPerfilUsuario();	
//		
//		return retorno;
//	}
	
	public String getLocalListarProgramaUniversidad() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarProgramaUniversidad();
		
		return retorno;
	}
	
	public String getLocalListarProgramaUniversidadOrden() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarProgramaUniversidadOrden();
		
		return retorno;
	}
	
	public String getLocalListarProgramaUniversidadPostulacion() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarProgramaUniversidadPostulacion();
		
		return retorno;
	}
	
	public String getLocalListarProgramaUniversidadPostulacionOrden() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarProgramaUniversidadPostulacionOrden();
		
		return retorno;
	}
	
	public String getLocalListarTipoCertificados() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarTipoCertificados();
		
		return retorno;
	}
	
	public String getLocalListarTipoCertificadosOrden() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarTipoCertificadosOrden();
		
		return retorno;
	}
	
	public String getLocalListarFinalidadCertificados() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarFinalidadCertificados();
		
		return retorno;
	}
	
	public String getLocalListarFinalidadCertificadosOrden() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarFinalidadCertificadosOrden();
		
		return retorno;
	}
	
	public String getLocalCrearSolicitudCertificado() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalCrearSolicitudCertificado();
		
		return retorno;
	}
	
	public String getLocalListarSolicitudCertificados() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarSolicitudCertificados();
		
		return retorno;
	}
	
	public String getLocalListarSolicitudCertificadoxEntreFechas() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarSolicitudCertificadoxEntreFechas();
		
		return retorno;
	}
	
	public String getLocalListarTipoSolicitudes() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarTipoSolicitudes();
		
		return retorno;
	}
	
	public String getLocalListarTipoSolicitudesOrden() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarTipoSolicitudesOrden();
		
		return retorno;
	}
	
	public String getLocalCrearArchivoSolicitud() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalCrearArchivoSolicitud();
		
		return retorno;
	}
	
	public String getLocalBuscarArchivoSolicitud() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalBuscarArchivoSolicitud();
		
		return retorno;
	}
	
	public String getLocalActualizarArchivoSolicitud() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalActualizarArchivoSolicitud();
		
		return retorno;
	}
	
	public String getLocalCrearSolicitudAcademica() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalCrearSolicitudAcademica();
		
		return retorno;
	}
	
	public String getLocalListarSolicitudAcademicaxEntreFechas() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarSolicitudAcademicaxEntreFechas();
		
		return retorno;
	}
	
	public String getLocalListarRegiones() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarRegiones();
		
		return retorno;
	}
	
	public String getLocalListarComunasxRegion() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarComunasxRegion();
		
		return retorno;
	}
	
	public String getLocalCrearSolicitudPostulacion() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalCrearSolicitudPostulacion();
		
		return retorno;
	}
	
	public String getLocalCrearNegocioSolicitud() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalCrearNegocioSolicitud();
		
		return retorno;
	}
	
	public String getLocalListarSolicitudPostulacion() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalCrearNegocioSolicitud();
		
		return retorno;
	}
	
	public String getLocalListarSolicitudPostulacionxEntreFechas() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalListarSolicitudPostulacionxEntreFechas();
		
		return retorno;
	}
	
	public String getLocalEnviarCorreoSolicitud() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno = metProp.getLocalEnviarCorreoSolicitud();
		
		return retorno;
	}
	
	public String getServerIdSolicitudCertificadoAplicacion() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String idAplicacion = metProp.getLocalIdSolicitudCertificadoAplicacion();
		
		return idAplicacion;
	}
	
	public String getServerIdSolicitudAcademicaAplicacion() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String idAplicacion =metProp.getLocalIdSolicitudAcademicaAplicacion();
		
		return idAplicacion;
	}
	
	public String getServerIdSolicitudPostulacionAplicacion() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String idAplicacion =metProp.getLocalIdSolicitudPostulacionAplicacion();
		
		return idAplicacion;
	}
	
	public String getServerIdSolicitudCertificadoEmailWebmail() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String idEmailWebmail =metProp.getLocalIdSolicitudCertificadoEmailWebmail();
		
		return idEmailWebmail;
	}
	
	public String getServerIdSolicitudAcademicaEmailWebmail() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String idEmailWebmail =metProp.getLocalIdSolicitudAcademicaEmailWebmail();
		
		return idEmailWebmail;
	}
	
	public String getServerIdSolicitudPostulacionEmailWebmail() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String idEmailWebmail =metProp.getLocalIdSolicitudPostulacionEmailWebmail();
		
		return idEmailWebmail;
	}
	
	/***********************************************************************/
	/***********************************************************************/
	/***********************************************************************/
	public String getLocalSolicitudCertificadoCorreoActivo() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalSolicitudCertificadoCorreoActivo();
		
		return retorno;
	}
	
	public String getLocalSolicitudAcademicaCorreoActivo() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalSolicitudAcademicaCorreoActivo();
		
		return retorno;
	}
	
	public String getLocalSolicitudPostulacionCorreoActivo() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalSolicitudPostulacionCorreoActivo();
		
		return retorno;
	}
	
	public String getLocalSolicitudCertificadoPagoOnlineactivo() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalSolicitudCertificadoPagoOnlineactivo();
		
		return retorno;
	}
	
	public String getLocalSolicitudAcademicaPagoOnlineactivo() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalSolicitudAcademicaPagoOnlineactivo();
		
		return retorno;
	}
	
	public String getLocalSolicitudPostulacionPagoOnlineactivo() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalSolicitudPostulacionPagoOnlineactivo();
		
		return retorno;
	}
	
	/***********************************************************************/
	public String getServerFlujoPagoOnlineActivo() {
		PropertiesServerAplicacion metProp = new PropertiesServerAplicacion();
		
		String retorno =metProp.getServerFlujoPagoOnlineActivo();
		
		return retorno;
	}
	
	public String getServerFlujoCorreoActivo() {
		PropertiesServerAplicacion metProp = new PropertiesServerAplicacion();
		
		String retorno =metProp.getServerFlujoCorreoActivo();
		
		return retorno;
	}
	/***********************************************************************/
	
	public String getLocalListarSemestreTemporada() {
		
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalListarSemestreTemporada();
		
		return retorno;
	}
	
	public String getLocalCrearSemestreTemporada() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalCrearSemestreTemporada();
		
		return retorno;
	}
	
	public String getLocalActualizarSemestreTemporada() {
		
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalActualizarSemestreTemporada();
		
		return retorno;

	}
	
	public String getLocalBuscarSemestreTemporada() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalBuscarSemestreTemporada();
		
		return retorno;
		
	}
	
	public String getLocalCrearAlumno() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalCrearAlumno();
		
		return retorno;
	}
	
	public String getLocalActualizarAlumno() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalActualizarAlumno();
		
		return retorno;
	}
	
	public String getLocalObtenerAlumnoxUsuario() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalObtenerAlumnoxUsuario();
		
		return retorno;
		
	}
	
	public String getLocalListarAlumnoNoAsociadoToUsuario() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalListarAlumnoNoAsociadoToUsuario();
		
		return retorno;
	}
	
	public String getLocalListarAlumnoNoAsociadoToSeguridad() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalListarAlumnoNoAsociadoToSeguridad();
		
		return retorno;
	}
	
	public String getLocalCrearProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalCrearProgramaActivoSemestre();
		
		return retorno;
		
	}
	
	public String getLocalActualizarProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalActualizarProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalBuscarProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalBuscarProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalListarProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalListarProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalCrearAlumnoProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalCrearAlumnoProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalActualizarAlumnoProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalActualizarAlumnoProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalBuscarAlumnoProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalBuscarAlumnoProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalListarAlumnoProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalListarAlumnoProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalCrearAsignaturaProgramaActivoSemestre() {
UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalCrearAsignaturaProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalActualizarAsignaturaProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalActualizarAsignaturaProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalBuscarAsignaturaProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalBuscarAsignaturaProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalListarAsignaturaProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalListarAsignaturaProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalCrearAsignaturaTomadaProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalCrearAsignaturaTomadaProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalActualizarAsignaturaTomadaProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalActualizarAsignaturaTomadaProgramaActivoSemestre();
		
		return retorno;
	}
			
	public String getLocalBuscarAsignaturaTomadaProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalBuscarAsignaturaTomadaProgramaActivoSemestre();
		
		return retorno;
	}
	
	public String getLocalListarAsignaturaTomadaProgramaActivoSemestre() {
		UchileSolicitudesLocalAplicacion metProp = new UchileSolicitudesLocalAplicacion();
		
		String retorno =metProp.getLocalListarAsignaturaTomadaProgramaActivoSemestre();
		
		return retorno;
	}

	
}
