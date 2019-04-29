
package web.uchile.articular.servicio.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manashiki.uchilearte.servdto.dto.entities.formulario.AlumnoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.AlumnoProgramaActivoSemestreDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ArchivoSolicitudDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.AsignaturaProgramaActivoSemestreDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.AsignaturaTomadaProgramaActivoSemestreDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ComunaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.FinalidadCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaActivoSemestreDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadPostulacionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.RegionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SemestreTemporadaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudAcademicaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudPostulacionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoSolicitudDTO;
import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;
import com.manashiki.uchilearte.servdto.transaccion.NegocioSolicitudDTO;
import com.manashiki.uchilearte.servdto.wrapper.UchileArte;
import vijnana.respuesta.wrapper.request.ConsultaWebmail;
import vijnana.utilidades.component.utilidades.Ip;
import vijnana.utilidades.component.utilidades.ObtenerTexto;
import web.uchile.articular.servicio.properties.WebUchileProperties;
import web.uchile.articular.servicio.utilidades.ClienteRestUtilidades;

public class SolicitudesUchileModelo {

	private static final Logger objLog = LoggerFactory.getLogger(SolicitudesUchileModelo.class);

	private WebUchileProperties webUchileProperties = new WebUchileProperties();

	//	private ClienteRestUchile clienteRestUchile = new ClienteRestUchile();

	public SolicitudesUchileModelo() {
		super();

		//		this.clienteRestUchile = new ClienteRestUchile();

		this.webUchileProperties = new WebUchileProperties();
	}

	private ClienteRestUchile generarClienteRestUchile(String keyAutentificacion) {

		String[] key = ObtenerTexto.obtenerEnDosPartes(keyAutentificacion);
		ClienteRestUchile clienteRestUchile = new ClienteRestUchile(key[0], key[1]);

		return clienteRestUchile;
	}


	public AlumnoDTO crearAlumno(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());

		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearAlumno(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [crearAlumno]");
		}

		return uchileArte.getAlumnoDTO(); 

	}

	public AlumnoDTO actualizarAlumno(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalActualizarAlumno(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [actualizarAlumno]");
		}

		return uchileArte.getAlumnoDTO(); 

	}

	public AlumnoDTO buscarAlumno(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalObtenerAlumnoxUsuario(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [buscarAlumno]");
		}

		return uchileArte.getAlumnoDTO(); 

	}

	//Para Asociar un Alumno a un Usuario
	public List<AlumnoDTO> listaAlumnoNoAsociadoToUsuario(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarAlumnoNoAsociadoToUsuario(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listaAlumnoDTO]");
		}

		return uchileArte.getListaAlumnoDTO(); 

	}

	//Para Asociar un Alumno a un Usuario/Seguridad
	public List<AlumnoDTO> listaAlumnoNoAsociadoToSeguridad(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarAlumnoNoAsociadoToSeguridad(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listaAlumnoNoAsociadoToSeguridad]");
		}

		return uchileArte.getListaAlumnoDTO(); 

	}

	public AlumnoProgramaActivoSemestreDTO crearAlumnoProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearAlumnoProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [crearAlumnoProgramaActivoSemestre]");
		}

		return uchileArte.getAlumnoProgramaActivoSemestreDTO();

	}

	public AlumnoProgramaActivoSemestreDTO actualizarAlumnoProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalActualizarAlumnoProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [actualizarAlumnoProgramaActivoSemestre]");
		}

		return uchileArte.getAlumnoProgramaActivoSemestreDTO();

	}

	public AlumnoProgramaActivoSemestreDTO buscarAlumnoProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalBuscarAlumnoProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [buscarAlumnoProgramaActivoSemestre]");
		}

		return uchileArte.getAlumnoProgramaActivoSemestreDTO();

	}

	//Para Asociar un Alumno a un Usuario
	public List<AlumnoProgramaActivoSemestreDTO> listarAlumnoProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarAlumnoProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarAlumnoProgramaActivoSemestre]");
		}

		return uchileArte.getListaAlumnoProgramaActivoSemestreDTO();

	}


	public AsignaturaProgramaActivoSemestreDTO crearAsignaturaProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearAsignaturaProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [crearAlumnoProgramaActivoSemestre]");
		}

		return uchileArte.getAsignaturaProgramaActivoSemestreDTO();

	}

	public AsignaturaProgramaActivoSemestreDTO actualizarAsignaturaProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalActualizarAsignaturaProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [actualizarAlumnoProgramaActivoSemestre]");
		}

		return uchileArte.getAsignaturaProgramaActivoSemestreDTO();

	}

	public AsignaturaProgramaActivoSemestreDTO buscarAsignaturaProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalBuscarAsignaturaProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [buscarAlumnoProgramaActivoSemestre]");
		}

		return uchileArte.getAsignaturaProgramaActivoSemestreDTO();

	}

	//Para Asociar un Alumno a un Usuario
	public List<AsignaturaProgramaActivoSemestreDTO> listarAsignaturaProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarAsignaturaProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarAlumnoProgramaActivoSemestre]");
		}

		return uchileArte.getListaAsignaturaProgramaActivoSemestreDTO();

	}

	public AsignaturaTomadaProgramaActivoSemestreDTO crearAsignaturaTomadaProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearAsignaturaProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [crearAsignaturaTomadaProgramaActivoSemestreDTO]");
		}

		return uchileArte.getAsignaturaTomadaProgramaActivoSemestreDTO();

	}

	public AsignaturaTomadaProgramaActivoSemestreDTO actualizarAsignaturaTomadaProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalActualizarAsignaturaTomadaProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [actualizarAsignaturaTomadaProgramaActivoSemestreDTO]");
		}

		return uchileArte.getAsignaturaTomadaProgramaActivoSemestreDTO();

	}

	public AsignaturaTomadaProgramaActivoSemestreDTO buscarAsignaturaTomadaProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalBuscarAsignaturaTomadaProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [buscarAsignaturaTomadaProgramaActivoSemestre]");
		}

		return uchileArte.getAsignaturaTomadaProgramaActivoSemestreDTO();

	}

	//Para Asociar un Alumno a un Usuario
	public List<AsignaturaTomadaProgramaActivoSemestreDTO> listarAsignaturaTomadaProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarAsignaturaTomadaProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarAsignaturaTomadaProgramaActivoSemestre]");
		}

		return uchileArte.getListaAsignaturaTomadaProgramaActivoSemestreDTO();

	}

	public List<ComunaDTO> listaComunaDTOXRegion(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarComunasxRegion(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listaComunaDTOXRegion]");
		}

		return uchileArte.getListaComunaDTO(); 

	}

	public List<FinalidadCertificadoDTO> listarFinalidadCertificado(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());

		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarFinalidadCertificados(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarFinalidadCertificadoDTO]");
		}

		return  uchileArte.getListaFinalidadCertificadoDTO();

	}

	public List<FinalidadCertificadoDTO> listarFinalidadCertificadoOrden(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarFinalidadCertificadosOrden(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarFinalidadCertificadoOrdenDTO]");
		}

		return  uchileArte.getListaFinalidadCertificadoDTO();

	}


	/*Como tengo toda la lista de servicios disponibles para la aplicacion valido en java-front si tengo acceso a la aplicacion */
	public ProgramaActivoSemestreDTO crearProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalCrearProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [crearProgramaActivoSemestreDTO]");
		}


		return uchileArte.getProgramaActivoSemestreDTO();

	}

	public ProgramaActivoSemestreDTO actualizarProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalActualizarProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [actualizarProgramaActivoSemestreDTO]");
		}


		return uchileArte.getProgramaActivoSemestreDTO();

	}

	public ProgramaActivoSemestreDTO buscarProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalBuscarProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [buscarProgramaActivoSemestreDTO]");
		}


		return uchileArte.getProgramaActivoSemestreDTO();

	}

	/*Como tengo toda la lista de servicios disponibles para la aplicacion valido en java-front si tengo acceso a la aplicacion */
	public List<ProgramaActivoSemestreDTO> listarProgramaActivoSemestre(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarProgramaActivoSemestre(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarProgramasUniversidadOrdenDTO]");
		}


		return uchileArte.getListaProgramaActivoSemestreDTO(); 

	}

	/*Como tengo toda la lista de servicios disponibles para la aplicacion valido en java-front si tengo acceso a la aplicacion */
	public List<ProgramaUniversidadDTO> listarProgramasUniversidad(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarProgramaUniversidad(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarProgramasUniversidadOrdenDTO]");
		}


		return uchileArte.getListaProgramaUniversidadDTO(); 

	}

	/*Como tengo toda la lista de servicios disponibles para la aplicacion valido en java-front si tengo acceso a la aplicacion */
	public List<ProgramaUniversidadDTO> listarProgramasUniversidadOrden(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());

		//		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarProgramaUniversidad())){
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarProgramaUniversidadOrden(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarProgramasUniversidadOrdenDTO]");
		}

		//		}
		return uchileArte.getListaProgramaUniversidadDTO(); 

	}

	public List<ProgramaUniversidadPostulacionDTO> listarProgramasUniversidadPostulacion(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarProgramaUniversidadPostulacion(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarProgramasUniversidadPostulacionOrdenDTO]");
		}

		return  uchileArte.getListaProgramaUniversidadPostulacionDTO();

	}

	public List<ProgramaUniversidadPostulacionDTO> listarProgramasUniversidadPostulacionOrden(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarProgramaUniversidadPostulacionOrden(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarProgramasUniversidadPostulacionOrdenDTO]");
		}

		return  uchileArte.getListaProgramaUniversidadPostulacionDTO();

	}

	public List<RegionDTO> listarRegion(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		List<RegionDTO> finalListaRegionDTO = new ArrayList<RegionDTO>();

		UchileArte uchileArte = new UchileArte();
		//		 Mostrar Todo
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarRegiones(), 0 , 0);

		if(uchileArte==null || uchileArte.getListaRegionDTO()==null){
			objLog.info("Error en la generacion [listarRegionDTO]");
		}

		List<RegionDTO> metListaRegionDTO = uchileArte.getListaRegionDTO();

		for(RegionDTO reg: metListaRegionDTO){
			if(!reg.getCodigoRegion().equals("None")){
				finalListaRegionDTO.add(reg);
			}
		}

		return finalListaRegionDTO;
	}

	public SemestreTemporadaDTO crearSemestreTemporada(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearSemestreTemporada(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [crearAlumnoProgramaActivoSemestre]");
		}

		return uchileArte.getSemestreTemporadaDTO();

	}

	public SemestreTemporadaDTO actualizarSemestreTemporada(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalActualizarSemestreTemporada(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [actualizarSemestreTemporada]");
		}

		return uchileArte.getSemestreTemporadaDTO();

	}

	public SemestreTemporadaDTO buscarSemestreTemporada(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalBuscarSemestreTemporada(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [buscarSemestreTemporada]");
		}

		return uchileArte.getSemestreTemporadaDTO();

	}

	//Para Asociar un Alumno a un Usuario
	public List<SemestreTemporadaDTO> listarSemestreTemporada(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarSemestreTemporada(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarSemestreTemporada]");
		}

		return uchileArte.getListaSemestreTemporadaDTO();

	}

	public List<TipoCertificadoDTO> listarTipoCertificado(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarTipoCertificados(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarTipoCertificadoDTO]");
		}

		return  uchileArte.getListaTipoCertificadoDTO();

	}

	public List<TipoCertificadoDTO> listarTipoCertificadoOrden(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());

		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarTipoCertificadosOrden(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarTipoCertificadoOrdenDTO]");
		}

		return  uchileArte.getListaTipoCertificadoDTO();

	}

	public List<TipoSolicitudDTO> listarTipoSolicitud(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarTipoSolicitudes() , 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarTipoSolicitudDTO]");
		}

		return  uchileArte.getListaTipoSolicitudDTO();

	}

	public List<TipoSolicitudDTO> listarTipoSolicitudOrden(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
		uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarTipoSolicitudesOrden(), 0 , 0);

		if(uchileArte==null){
			objLog.info("Error en la generacion [listarTipoSolicitudOrdenDTO]");
		}

		return  uchileArte.getListaTipoSolicitudDTO();

	}









	public ArchivoSolicitudDTO handleFileUpload(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, ArchivoSolicitudDTO archivoSolicitudDTO){
		objLog.info("INI handleFileUpload");
		//UploadedFile upFile = fileUploadEvent.getFile();
		try {
			UchileArte uchileArte = new UchileArte();
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());

			RequestProductoDTO requestProductoDTO = new RequestProductoDTO();

			requestProductoDTO.setArchivoSolicitudDTO(archivoSolicitudDTO);

			uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearArchivoSolicitud());

			if(uchileArte==null){
				objLog.info("Error en la generacion [handleFileUpload]");
			}
			return uchileArte.getArchivoAcademicaDTO();
			//			if(archivoSolicitudDTO!=null && archivoSolicitudDTO.getIdArchivoSolicitud()>0 && archivoSolicitudDTO.getNombreArchivoSolicitud()!=null){
			//				objLog.info("I - validar Archivo: "+archivoSolicitudDTO.getIdArchivoSolicitud());
			//			}
			//Guardar el nombre y la direccion en la base de datos "archivoSolicitud y relacionarlo con solicitudAcademica"
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public RequestProductoDTO almacenarSolicitudCertificado(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, SolicitudCertificadoDTO solicitudCertificadoDTO) throws IOException {

		try{

			RequestProductoDTO requestProductoDTO = new RequestProductoDTO();
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
			requestProductoDTO.setSolicitudCertificadoDTO(solicitudCertificadoDTO);

			UchileArte uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearSolicitudCertificado());

			if(uchileArte==null){
				objLog.info("Error en la generacion [almacenarSolicitudCertificado]");
			}

			return requestProductoDTO;

		}
		catch(Exception e){
			e.printStackTrace();
			objLog.info("ERROR - almacenarSolicitudAcademica:"+solicitudCertificadoDTO.getRutPersonaSolicitudCertificado()+" - "+e.getMessage());
		}

		return null;
	}

	public RequestProductoDTO almacenarSolicitudAcademica(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, SolicitudAcademicaDTO solicitudAcademicaDTO) throws IOException {

		try{

			RequestProductoDTO requestProductoDTO = new RequestProductoDTO();
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
			requestProductoDTO.setSolicitudAcademicaDTO(solicitudAcademicaDTO);

			UchileArte uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearSolicitudAcademica());

			if(uchileArte==null){
				objLog.info("Error en la generacion [almacenarSolicitudAcademica]");
			}

			return requestProductoDTO;

		}
		catch(Exception e){
			e.printStackTrace();
			objLog.info("ERROR - almacenarSolicitudAcademica:"+solicitudAcademicaDTO.getRutPersonaSolicitudAcademica()+" - "+e.getMessage());
		}

		return null;
	}

	public RequestProductoDTO almacenarSolicitudAdmisionPostgrado(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, SolicitudPostulacionDTO solicitudPostulacionDTO) throws IOException {

		RequestProductoDTO requestProductoDTO = new RequestProductoDTO();

		try{
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
			requestProductoDTO.setSolicitudPostulacionDTO(solicitudPostulacionDTO);

			//			String key = ClienteRestUtilidades.generacionSolicitudPostulacionSHA(requestProductoDTO);
			//Cambiar
			UchileArte uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearSolicitudPostulacion());

			if(uchileArte==null){
				objLog.info("Error en la generacion [almacenarSolicitudAdmisionPostgrado]");
			}
			return requestProductoDTO;

		}
		catch(Exception e){
			e.printStackTrace();
			objLog.info("ERROR - almacenarSolicitudAcademica:"+solicitudPostulacionDTO.getRutPersonaSolicitudPostulacion()+" - "+e.getMessage());
		}

		return null;
	}

	public List<SolicitudCertificadoDTO> listarSolicitudCertificadoEntreFechas(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {

		try{
			UchileArte uchileArte = new UchileArte();
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());

			uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarSolicitudCertificadoxEntreFechas());

			if(uchileArte==null){
				objLog.info("Error en la generacion [listarSolicitudCertificadoEntreFechas]");
			}

			return uchileArte.getListaSolicitudCertificadoDTO();

		}
		catch(Exception e){
			e.printStackTrace();
			objLog.info("ERROR - listarSolicitudCertificadoEntreFechas: "+e.getMessage());
		}

		return null;
	}



	public RequestProductoDTO almacenarBusinessAcademica(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO, boolean online) {
		//		UchileArte uchileArte = null; 
		try{
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
			String key = ClienteRestUtilidades.generacionSolicitudAcademicaSHA(requestProductoDTO);

			String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

			NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

			negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

			negocioSolicitudDTO.setKeyNegocioSolicitud(key);

			negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

			negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

			requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);

			UchileArte uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalCrearNegocioSolicitud());

			if(uchileArte==null){
				objLog.info("Error en la generacion [almacenarBusinessAcademica]");
			}
		}

		catch(Exception e){
			e.printStackTrace();
		}
		return requestProductoDTO;

	}

	public void enviarEmailSolicitudCertificado(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {
		//		UchileArte uchileArte = null;
		ConsultaWebmail consultaWebmail = new ConsultaWebmail();

		try{
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
			String key = ClienteRestUtilidades.generacionSolicitudCertificadoSHA(requestProductoDTO);

			String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

			NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

			negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

			negocioSolicitudDTO.setKeyNegocioSolicitud(key);

			negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

			negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

			requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);

			//			consultaWebmail.setIdAplicacion(UchileOrquestadorConstantes.getIdaplicacioncorreo());
			//			
			//			consultaWebmail.setIdEmail(UchileOrquestadorConstantes.getIdemailcorreo());

			consultaWebmail.setRemoteAddr(Ip.direccionServer());

			clienteRestUchile.postEmail(consultaWebmail, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalEnviarCorreoSolicitud());

		}
		catch(Exception e){
			e.printStackTrace();
		}

		//		return uchileArte;
	}

	public void enviarEmailSolicitudAcademica(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {
		//		UchileArte uchileArte = null;
		ConsultaWebmail consultaWebmail = new ConsultaWebmail();

		try{
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
			String key = ClienteRestUtilidades.generacionSolicitudAcademicaSHA(requestProductoDTO);

			String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

			NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

			negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

			negocioSolicitudDTO.setKeyNegocioSolicitud(key);

			negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

			negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

			requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);


			consultaWebmail.setRemoteAddr(Ip.direccionServer());

			clienteRestUchile.postEmail(consultaWebmail, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalEnviarCorreoSolicitud());
		}

		catch(Exception e){
			e.printStackTrace();
		}

		//		return uchileArte;
	}

	public void enviarEmailSolicitudPostulacion(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {
		//		UchileArte uchileArte = null;
		ConsultaWebmail consultaWebmail = new ConsultaWebmail();

		try{
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
			String key = ClienteRestUtilidades.generacionSolicitudPostulacionSHA(requestProductoDTO);

			String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

			NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

			negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

			negocioSolicitudDTO.setKeyNegocioSolicitud(key);

			negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

			negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

			requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);

			//			consultaWebmail.setIdAplicacion(UchileOrquestadorConstantes.getIdaplicacioncorreo());
			//			
			//			consultaWebmail.setIdEmail(UchileOrquestadorConstantes.getIdemailcorreo());

			consultaWebmail.setRemoteAddr(Ip.direccionServer());

			clienteRestUchile.postEmail(consultaWebmail, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalEnviarCorreoSolicitud());

		}
		catch(Exception e){
			e.printStackTrace();
		}

		//		return uchileArte;
	}

	public String obtenerContenidoRequestByMail(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {
		//		UchileArte uchileArte = null;
		ConsultaWebmail consultaWebmail = new ConsultaWebmail();

		try{
			ClienteRestUchile clienteRestUchile = generarClienteRestUchile(authenticacionContext.getKeyAutentificacion());
			String key = ClienteRestUtilidades.generacionSolicitudPostulacionSHA(requestProductoDTO);

			String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

			NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

			negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

			negocioSolicitudDTO.setKeyNegocioSolicitud(key);

			negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

			negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

			requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);

			consultaWebmail.setRemoteAddr(Ip.direccionServer());

			clienteRestUchile.postEmail(consultaWebmail, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalEnviarCorreoSolicitud());

		}
		catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}

	public String obtenerContenidoRequestByFlujo(RequestProductoDTO requestProductoDTO) {
		//		UchileArte uchileArte = null;
		//		ConsultaWebmail consultaWebmail = new ConsultaWebmail();
		//		
		//		try{
		//			
		//			String valorNegocioSolicitud= solicitudesModelo.obtenerContenidoRequestByMail(requestProductoDTO);
		//
		//			NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();
		//
		//			negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);
		//			negocioSolicitudDTO.setKeyNegocioSolicitud(key);
		//			negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());
		//			negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());
		//
		//			requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);
		//
		//			clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalCrearNegocioSolicitud());
		//		}
		//		catch(Exception e){
		//			e.printStackTrace();
		//		}
		//
		return null;
	}


}
