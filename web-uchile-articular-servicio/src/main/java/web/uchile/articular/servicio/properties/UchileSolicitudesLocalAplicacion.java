package web.uchile.articular.servicio.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vijnana.wsrest.client.impl.PropertiesCliente;

class UchileSolicitudesLocalAplicacion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public UchileSolicitudesLocalAplicacion(){
		super();
	}
	private static final Logger objLog = LoggerFactory.getLogger(UchileSolicitudesLocalAplicacion.class);
	
	private static Properties properties;
	
	
	
	public Properties obtenerProperties(){

		if(properties == null){  

			generarProperties();  
		}  

		return properties; 
	}
	
	public void generarProperties(){
		Properties metProp = new Properties();
		InputStream is = null;
		String nombreArch = "uchile.facultad.de.arte.properties";

		is = getClass().getClassLoader().getResourceAsStream(nombreArch);

		try {
			metProp.load(is);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			metProp = new Properties();
			objLog.error("Error en la obtencion del properties");
		}

		properties = metProp;
	}
	
	public static String getVijnanaServidor(){
		PropertiesServerAplicacion metProp = new PropertiesServerAplicacion();
		
		PropertiesCliente propertiesCliente = new PropertiesCliente();

		String servidorProp =  propertiesCliente.getWProduccion(metProp.obtenerAmbiente());

		return servidorProp;
	}

	
	public String getLocalListarProgramaUniversidad() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Programa.Universidad");
		
		return wserver;
	}
	
	public String getLocalListarProgramaUniversidadOrden() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Programa.Universidad.con.Estado");
		
		return wserver;
	}
	
	public String getLocalListarProgramaUniversidadPostulacion() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Programa.Universidad.Postulacion");
		
		return wserver;
	}
	
	public String getLocalListarProgramaUniversidadPostulacionOrden() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Programa.Universidad.Postulacion.con.Estado");
		
		return wserver;
	}
	
	public String getLocalListarTipoCertificados() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Tipo.Certificados");
		
		return wserver;
	}
	
	public String getLocalListarTipoCertificadosOrden() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Tipo.Certificados.con.Estado");
		
		return wserver;
	}
	
	public String getLocalListarFinalidadCertificados() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Finalidad.Certificados");
		
		return wserver;
	}
	
	public String getLocalListarFinalidadCertificadosOrden() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Finalidad.Certificados.con.Estado");
		
		return wserver;
	}
	
	public String getLocalCrearSolicitudCertificado() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.Crear.Solicitud.Certificado");
		
		return wserver;
	}
	
	public String getLocalListarSolicitudCertificados() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Solicitud.Certificados");
		
		return wserver;
	}
	
	public String getLocalListarSolicitudCertificadoxEntreFechas() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Solicitud.Certificado.x.Entre.Fechas");
		
		return wserver;
	}
	
	public String getLocalListarTipoSolicitudes() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Tipo.Solicitudes");
		
		return wserver;
	}
	
	public String getLocalListarTipoSolicitudesOrden() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Tipo.Solicitudes.con.Estado");
		
		return wserver;
	}
	
	public String getLocalCrearArchivoSolicitud() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.Crear.Archivo.Solicitud");
		
		return wserver;
	}
	
	public String getLocalBuscarArchivoSolicitud() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.Buscar.Archivo.Solicitud");
		
		return wserver;
	}
	
	public String getLocalActualizarArchivoSolicitud() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.Actualizar.Archivo.Solicitud");
		
		return wserver;
	}
	
	public String getLocalCrearSolicitudAcademica() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.Crear.Solicitud.Academica");
		
		return wserver;
	}
	
	public String getLocalListarSolicitudAcademicaxEntreFechas() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Solicitud.Academica.x.Entre.Fechas");
		
		return wserver;
	}
	
	public String getLocalListarRegiones() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Regiones");
		
		return wserver;
	}
	
	public String getLocalListarComunasxRegion() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Comunas.x.Region");
		
		return wserver;
	}
	
	public String getLocalCrearSolicitudPostulacion() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.Crear.Solicitud.Postulacion");
		
		return wserver;
	}
	
	public String getLocalCrearNegocioSolicitud() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.Crear.Negocio.Solicitud");
		
		return wserver;
	}
	
	public String getLocalListarSolicitudPostulacion() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Solicitud.Postulacion");
		
		return wserver;
	}
	
	public String getLocalListarSolicitudPostulacionxEntreFechas() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.metodo.listar.Solicitud.Postulacion.x.Entre.Fechas");
		
		return wserver;
	}
	
	public String getLocalEnviarCorreoSolicitud() {
		Properties metProp = obtenerProperties();
		
		String wserver = metProp.getProperty("url.Envio.Mail.solicitudes");
		
		return wserver;
	}
	
	public String getLocalIdSolicitudCertificadoAplicacion() {
		Properties metProp = obtenerProperties();
		
		String idAplicacion =metProp.getProperty("id.solicitud.certificado.aplicacion");
		
		return idAplicacion;
	}
	
	public String getLocalIdSolicitudAcademicaAplicacion() {
		Properties metProp = obtenerProperties();
		
		String idAplicacion =metProp.getProperty("id.solicitud.academica.aplicacion");
		
		return idAplicacion;
	}
	
	public String getLocalIdSolicitudPostulacionAplicacion() {
		Properties metProp = obtenerProperties();
		
		String idAplicacion =metProp.getProperty("id.solicitud.postulacion.aplicacion");
		
		return idAplicacion;
	}
	
	public String getLocalIdSolicitudCertificadoEmailWebmail() {
		Properties metProp = obtenerProperties();
		
		String idAplicacion =metProp.getProperty("id.solicitud.certificado.email.webmail");
		
		return idAplicacion;
	}
	
	public String getLocalIdSolicitudAcademicaEmailWebmail() {
		Properties metProp = obtenerProperties();
		
		String idAplicacion =metProp.getProperty("id.solicitud.academica.email.webmail");
		
		return idAplicacion;
	}
	
	public String getLocalIdSolicitudPostulacionEmailWebmail() {
		Properties metProp = obtenerProperties();
		
		String idAplicacion =metProp.getProperty("id.solicitud.postulacion.email.webmail");
		
		return idAplicacion;
	}
	
	/**************Traer desde app.properties**************/
	public String getLocalSolicitudCertificadoPagoOnlineactivo() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("solicitud.certificado.pagoOnline.activo");
		
		return retorno;
	}
	
	public String getLocalSolicitudAcademicaPagoOnlineactivo() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("solicitud.academica.pagoOnline.activo");
		
		return retorno;
	}
	
	public String getLocalSolicitudPostulacionPagoOnlineactivo() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("solicitud.postulacion.pagoOnline.activo");
		
		return retorno;
	}
	
	public String getLocalSolicitudCertificadoCorreoActivo() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("solicitud.certificado.correo.activo");
		
		return retorno;
	}
	
	public String getLocalSolicitudAcademicaCorreoActivo() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("solicitud.academica.correo.activo");
		
		return retorno;
	}
	
	public String getLocalSolicitudPostulacionCorreoActivo() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("solicitud.postulacion.correo.activo");
		
		return retorno;
	}
	
	public String getLocalListarSemestreTemporada() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("url.metodo.listar.Semestre.Temporada");
		
		return retorno;
	}
	
	public String getLocalCrearSemestreTemporada() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("url.metodo.crear.Semestre.Temporada");
		
		return retorno;
	}
	
	public String getLocalActualizarSemestreTemporada() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("url.metodo.actualizar.Semestre.Temporada");
		
		return retorno;
	}
	
	public String getLocalBuscarSemestreTemporada() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("url.metodo.buscar.Semestre.Temporada");
		
		return retorno;
	}
	
	public String getLocalCrearAlumno() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("url.metodo.crear.Alumno");
		
		return retorno;
	}
	
	public String getLocalActualizarAlumno() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("url.metodo.actualizar.Alumno");
		
		return retorno;
	}
	
	public String getLocalObtenerAlumnoxUsuario() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("url.metodo.obtener.Alumno.x.Usuario");
		
		return retorno;
	}
	
	public String getLocalListarAlumnoNoAsociadoToUsuario() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("url.metodo.listar.Alumno.NoAsociado.To.Usuario");
		
		return retorno;
	}
	
	public String getLocalListarAlumnoNoAsociadoToSeguridad() {
		Properties metProp = obtenerProperties();
		
		String retorno =metProp.getProperty("url.metodo.listar.Alumno.NoAsociado.ToSeguridad");
		
		return retorno;
	}
	
	public String getLocalCrearProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.crear.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalActualizarProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.actualizar.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalBuscarProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.buscar.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalListarProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.listar.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalCrearAlumnoProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.crear.Alumno.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalActualizarAlumnoProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.actualizar.Alumno.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalBuscarAlumnoProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.buscar.Alumno.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalListarAlumnoProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.listar.Alumno.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalCrearAsignaturaProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.crear.Asignatura.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalActualizarAsignaturaProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.actualizar.Asignatura.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalBuscarAsignaturaProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.buscar.Asignatura.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalListarAsignaturaProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.listar.Asignatura.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalCrearAsignaturaTomadaProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.crear.Asignatura.Tomada.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalActualizarAsignaturaTomadaProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.actualizar.Asignatura.Tomada.Programa.Activo.Semestre");
		
		return retorno;
	}
			
	public String getLocalBuscarAsignaturaTomadaProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.buscar.Asignatura.Tomada.Programa.Activo.Semestre");
		
		return retorno;
	}
	
	public String getLocalListarAsignaturaTomadaProgramaActivoSemestre() {
		Properties metProp = obtenerProperties();
		
		String retorno = metProp.getProperty("url.metodo.listar.Asignatura.Tomada.Programa.Activo.Semestre");
		
		return retorno;
	}

}
