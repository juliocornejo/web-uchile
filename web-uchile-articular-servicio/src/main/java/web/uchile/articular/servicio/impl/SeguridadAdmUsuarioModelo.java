package web.uchile.articular.servicio.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manashiki.seguridad.servdto.dto.entities.formulario.TipoAccionUsuario;
import com.manashiki.seguridad.servdto.dto.entities.formulario.UsuarioSeguridad;
import com.manashiki.seguridad.servdto.dto.entities.transferencia.ResponseSeguridad;

import vijnana.respuesta.wrapper.request.ConsultaWebmail;
import vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext;
import vijnana.seguridad.orquestador.cliente.ClienteRest;
import vijnana.seguridad.orquestador.properties.VijnanaSeguridadProperties;
import vijnana.seguridad.orquestador.properties.adm.VijnanaSeguridadAdmUsuarioProperties;
import vijnana.utilidades.component.utilidades.Ip;

//para las aplicaciones que en su front van a modificar
public class SeguridadAdmUsuarioModelo {

	private static final Logger objLog = LoggerFactory.getLogger(SeguridadAdmUsuarioModelo.class);

	private VijnanaSeguridadProperties vijnanaSeguridadProperties = new VijnanaSeguridadProperties();
	
	private VijnanaSeguridadAdmUsuarioProperties vijnanaSeguridadAdmUsuarioProperties = new VijnanaSeguridadAdmUsuarioProperties();

	private ClienteRest clienteRest = new ClienteRest();

//	private ClienteSeguridad clienteSeguridad = new ClienteSeguridad();

	public SeguridadAdmUsuarioModelo() {
		super();
//		this.clienteRest = new ClienteRest();
//		this.webUchileProperties = new WebUchileProperties();
//		this.clienteSeguridad = new ClienteSeguridad();
	}

	public boolean validarExistenciaRut(String rutMember, String tipoDocumento, String tokenAuthenticacionContextSeguridad){

		boolean retorno = false;

		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

		usuarioSeguridad.setKeyAutentificacion(tokenAuthenticacionContextSeguridad);

		usuarioSeguridad.setRutMember(rutMember);

		usuarioSeguridad.setTipoIdentificador(tipoDocumento);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad,   vijnanaSeguridadProperties.getVijnanaServidor(),vijnanaSeguridadAdmUsuarioProperties.getLocalValidarExistenciaRut());

		if(responseSeguridad!=null){
			try{
				retorno = !responseSeguridad.isValido();
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}

		return retorno;
	}

	public boolean validarExistenciaCorreoElectronico(String mailMember, String tokenAuthenticacionContextSeguridad){

		boolean retorno = false;

		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

		usuarioSeguridad.setKeyAutentificacion(tokenAuthenticacionContextSeguridad);

		usuarioSeguridad.setMailUsuario(mailMember);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad,  vijnanaSeguridadProperties.getVijnanaServidor(), vijnanaSeguridadAdmUsuarioProperties.getLocalValidarExistenciaCorreoElectronico());

		if(responseSeguridad!=null){
			try{
				retorno = !responseSeguridad.isValido();
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}

		return retorno;
	}


	public boolean validarExistenciaUsernameLogin(String usernamePerfil, String tokenAuthenticacionContextSeguridad){

		boolean retorno = false;

		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

		usuarioSeguridad.setKeyAutentificacion(tokenAuthenticacionContextSeguridad);

		usuarioSeguridad.setUsernamePerfil(usernamePerfil);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad,  vijnanaSeguridadProperties.getVijnanaServidor(), vijnanaSeguridadAdmUsuarioProperties.getLocalValidarExistenciaUsernameLogin());

		if(responseSeguridad!=null){
			try{
				retorno = !responseSeguridad.isValido();
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}

		return retorno;
	}

	public boolean validarExistenciaNombrePerfil(String nombrePerfilLowerCase, String tokenAuthenticacionContextSeguridad){

		boolean retorno = false;

		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

		usuarioSeguridad.setKeyAutentificacion(tokenAuthenticacionContextSeguridad);
		usuarioSeguridad.setNombrePerfilLowerCase(nombrePerfilLowerCase);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad,  vijnanaSeguridadProperties.getVijnanaServidor(), vijnanaSeguridadAdmUsuarioProperties.getLocalValidarExistenciaNombrePerfil());

		if(responseSeguridad!=null){
			try{
				retorno = !responseSeguridad.isValido();
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}

		return retorno;
	}

	public List<UsuarioSeguridad> obtenerUsuarioSeguridadByIdUsuarioByEmailPerfil(){

		List<UsuarioSeguridad> listaUsuarioSeguridad = new ArrayList<UsuarioSeguridad>();

		return listaUsuarioSeguridad;
	}

	public UsuarioSeguridad crearNuevoUsuarioSeguridad(UsuarioSeguridad usuarioSeguridad, AutentificacionContext authenticacionContext, String rolUsuario, String nombreAplicacion){


		objLog.info("A fechaNac :"+usuarioSeguridad.getFechaNacimientoMember());
		objLog.info("B rutMembe :"+usuarioSeguridad.getRutMember());
		objLog.info("C nombreMe :"+usuarioSeguridad.getNombreMember());
		objLog.info("D apellMat :"+usuarioSeguridad.getTelefonoContactoMember());
		objLog.info("E generoMe :"+usuarioSeguridad.getGeneroMember());
		objLog.info("F firmaMem :"+usuarioSeguridad.getFirmaMember());
		objLog.info("G username :"+usuarioSeguridad.getUsernamePerfil());
		objLog.info("H nombrPfl :"+usuarioSeguridad.getNombrePerfilLowerCase());
		objLog.info("I password :"+usuarioSeguridad.getPasswordContrasenha());
		objLog.info("J pregPass :"+usuarioSeguridad.getPasswordPregunta());

		usuarioSeguridad.setKeyAutentificacion(authenticacionContext.getKeyAutentificacion());
		usuarioSeguridad.setIdEmpresa(authenticacionContext.getEnterpriseContext().getBasicContext().getIdEmpresa());
//		usuarioSeguridad.setNombreRol(UchileOrquestadorConstantes.getRolusuario());
		usuarioSeguridad.setNombreRol(rolUsuario);
//		usuarioSeguridad.setConcatAplicacion(UchileOrquestadorConstantes.getAplicacion());
		usuarioSeguridad.setConcatAplicacion(nombreAplicacion);
		

		usuarioSeguridad.setAnonimo(0);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad, vijnanaSeguridadProperties.getVijnanaServidor(),  vijnanaSeguridadAdmUsuarioProperties.getLocalNuevoUsuarioSeguridad());

		if(responseSeguridad!=null && responseSeguridad.getListaUsuarioSeguridad()!=null && responseSeguridad.getListaUsuarioSeguridad().size()>0){
			usuarioSeguridad = responseSeguridad.getListaUsuarioSeguridad().get(0);
		}else{
			usuarioSeguridad =  new UsuarioSeguridad();
		}

		return usuarioSeguridad;
	}

	public UsuarioSeguridad actualizarNuevoUsuarioSeguridad(UsuarioSeguridad usuarioSeguridad, AutentificacionContext authenticacionContext, String rolUsuario, String nombreAplicacion){

		objLog.info("A IdUsuario :"+usuarioSeguridad.getIdUsuario());
		objLog.info("B fechaNac :"+usuarioSeguridad.getFechaNacimientoMember());
		objLog.info("C rutMembe :"+usuarioSeguridad.getRutMember());
		objLog.info("E nombreMe :"+usuarioSeguridad.getNombreMember());
		objLog.info("F apellMat :"+usuarioSeguridad.getTelefonoContactoMember());
		objLog.info("G generoMe :"+usuarioSeguridad.getGeneroMember());
		objLog.info("H firmaMem :"+usuarioSeguridad.getFirmaMember());
		objLog.info("I username :"+usuarioSeguridad.getUsernamePerfil());
		objLog.info("J nombrPfl :"+usuarioSeguridad.getNombrePerfilLowerCase());
		objLog.info("L password :"+usuarioSeguridad.getPasswordContrasenha());
		objLog.info("M pregPass :"+usuarioSeguridad.getPasswordPregunta());

		usuarioSeguridad.setKeyAutentificacion(authenticacionContext.getKeyAutentificacion());
		usuarioSeguridad.setIdEmpresa(authenticacionContext.getEnterpriseContext().getBasicContext().getIdEmpresa());
//		usuarioSeguridad.setNombreRol(UchileOrquestadorConstantes.getRolusuario());
		usuarioSeguridad.setNombreRol(rolUsuario);
//		usuarioSeguridad.setConcatAplicacion(UchileOrquestadorConstantes.getAplicacion());
		usuarioSeguridad.setConcatAplicacion(nombreAplicacion);

		usuarioSeguridad.setAnonimo(0);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad, vijnanaSeguridadProperties.getVijnanaServidor(),  vijnanaSeguridadAdmUsuarioProperties.getLocalNuevoUsuarioSeguridad());

		if(responseSeguridad!=null && responseSeguridad.getListaUsuarioSeguridad()!=null && responseSeguridad.getListaUsuarioSeguridad().size()>0){
			usuarioSeguridad = responseSeguridad.getListaUsuarioSeguridad().get(0);
		}else{
			usuarioSeguridad =  new UsuarioSeguridad();
		}

		return usuarioSeguridad;
	}

	public boolean recuperarContrasenhaUsuarioByMail(UsuarioSeguridad usuarioSeguridad, AutentificacionContext authenticacionContext, String rolUsuario, String nombreAplicacion){

		objLog.info("A Email :"+usuarioSeguridad.getMailUsuario());

		boolean retorno = false;

		usuarioSeguridad.setKeyAutentificacion(authenticacionContext.getKeyAutentificacion());
		usuarioSeguridad.setIdEmpresa(authenticacionContext.getEnterpriseContext().getBasicContext().getIdEmpresa());
		usuarioSeguridad.setIdEmpresa(authenticacionContext.getEnterpriseContext().getBasicContext().getIdEmpresa());
//		usuarioSeguridad.setNombreRol(UchileOrquestadorConstantes.getRolusuario());
		usuarioSeguridad.setNombreRol(rolUsuario);
//		usuarioSeguridad.setConcatAplicacion(UchileOrquestadorConstantes.getAplicacion());
		usuarioSeguridad.setConcatAplicacion(nombreAplicacion);

		usuarioSeguridad.setAnonimo(0);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad, vijnanaSeguridadProperties.getVijnanaServidor(),  vijnanaSeguridadAdmUsuarioProperties.getLocalRecuperarContrasenhaUsuarioSeguridad());

		if(responseSeguridad!=null){
			try{
				retorno = responseSeguridad.isValido();
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}

		return retorno;
	}
	
	public boolean cambiarContrasenhaUsuario(UsuarioSeguridad usuarioSeguridad, AutentificacionContext authenticacionContext, String rolUsuario, String nombreAplicacion){

		objLog.info("A cambiarContrasenhaUsuario :");

		boolean retorno = false;

		usuarioSeguridad.setKeyAutentificacion(authenticacionContext.getKeyAutentificacion());
		usuarioSeguridad.setIdEmpresa(authenticacionContext.getEnterpriseContext().getBasicContext().getIdEmpresa());
//		usuarioSeguridad.setNombreRol(UchileOrquestadorConstantes.getRolusuario());
		usuarioSeguridad.setNombreRol(rolUsuario);
//		usuarioSeguridad.setConcatAplicacion(UchileOrquestadorConstantes.getAplicacion());
		usuarioSeguridad.setConcatAplicacion(nombreAplicacion);

		usuarioSeguridad.setAnonimo(0);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad, vijnanaSeguridadProperties.getVijnanaServidor(),  vijnanaSeguridadAdmUsuarioProperties.getLocalCambiarContrasenhaUsuarioSeguridad());

		if(responseSeguridad!=null){
			try{
				retorno = responseSeguridad.isValido();
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}

		return retorno;
	}


	public ResponseSeguridad listarUsuarioSeguridadPorAdministradorEmpresa(ResponseSeguridad responseSeguridad){


		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

		usuarioSeguridad.setKeyAutentificacion(responseSeguridad.getAutentificacionContext().getKeyAutentificacion());
		usuarioSeguridad.setIdEmpresa(responseSeguridad.getBasicContext().getIdEmpresa());

		responseSeguridad = clienteRest.post(usuarioSeguridad,  vijnanaSeguridadProperties.getVijnanaServidor(), vijnanaSeguridadAdmUsuarioProperties.getLocalListarUsuarioSeguridadxEmpresaxRolxFechaCreacion());

		return null;
	}

	/**	
//		public List<UsuarioSeguridad> listarUsuarioSeguridadxEmpresaxRolxFechaCreacion(Date fechaInicial, Date fechaFinal,  String rolUsuario, String tokenAuthenticacionContextSeguridad){
//
//		List<UsuarioSeguridad> listaUsuarioSeguridad = new ArrayList<UsuarioSeguridad>();
//
//		UsuarioSeguridad usuarioSeguridadInicial = new UsuarioSeguridad();
//
//		UsuarioSeguridad usuarioSeguridadFinal = new UsuarioSeguridad();
//
//		usuarioSeguridadInicial.setCreacionMember(AppDate.obtenerFechaEnFormato(fechaInicial, TipoFormatoFecha.YYYY_MM_ddTHH_MM_SSZ));
//
//		usuarioSeguridadFinal.setCreacionMember(AppDate.obtenerFechaEnFormato(fechaFinal, TipoFormatoFecha.YYYY_MM_ddTHH_MM_SSZ));
//
//		listaUsuarioSeguridad.add(usuarioSeguridadInicial);
//
//		listaUsuarioSeguridad.add(usuarioSeguridadFinal);
//
//		ResponseSeguridad responseSeguridad = new ResponseSeguridad(listaUsuarioSeguridad);
//		String dataRequest = JsonMappeo.convertirObjectToJson(responseSeguridad);
//
//		ConsultaSeguridad consultaSeguridad = new ConsultaSeguridad();
//		consultaSeguridad.setDataRequest(dataRequest);
//		consultaSeguridad.setKeySeguridad(tokenAuthenticacionContextSeguridad);
//		consultaSeguridad.setRolContexto(rolUsuario);
//		
//		responseSeguridad = clienteRest.post(consultaSeguridad, vijnanaSeguridadProperties.getVijnanaServidor(),  vijnanaSeguridadAdmUsuarioProperties.getLocalListarUsuarioSeguridadxEmpresaxRolxFechaCreacion());
//
//		if(responseSeguridad!=null && responseSeguridad.getListaUsuarioSeguridad()!=null){
//			listaUsuarioSeguridad = responseSeguridad.getListaUsuarioSeguridad();
//		}else{
//			listaUsuarioSeguridad = new ArrayList<UsuarioSeguridad>();
//		}
//
//		return listaUsuarioSeguridad;
//	}
***/

	public boolean postEmail(Map<String, AutentificacionContext> dataPlataformaAutentificacion){

//		usuarioSeguridad.setKeyAutentificacion(dataPlataformaAutentificacion.get(UchileOrquestadorConstantes.getAplicacion()).getKeyAutentificacion());
//		usuarioSeguridad.setIdEmpresa(dataPlataformaAutentificacion.get(UchileOrquestadorConstantes.getAplicacion()).getEnterpriseContext().getBasicContext().getIdEmpresa());


		ConsultaWebmail consultaWebmail = new ConsultaWebmail();
//		consultaWebmail.setIdAplicacion(UchileOrquestadorConstantes.getIdaplicacioncorreo());
//		consultaWebmail.setIdEmail(UchileOrquestadorConstantes.getIdemailcorreo());
		consultaWebmail.setRemoteAddr(Ip.direccionServer());

		ObjectMapper objectMapper = new ObjectMapper();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

		objectMapper.setDateFormat(sdf);

		objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		return false;
	}

	public boolean postEmailRecuperacionCorreo(Map<String, AutentificacionContext> dataPlataformaAutentificacion){

//		usuarioSeguridad.setKeyAutentificacion(dataPlataformaAutentificacion.get(UchileOrquestadorConstantes.getAplicacion()).getKeyAutentificacion());
//		usuarioSeguridad.setIdEmpresa(dataPlataformaAutentificacion.get(UchileOrquestadorConstantes.getAplicacion()).getEnterpriseContext().getBasicContext().getIdEmpresa());


		ConsultaWebmail consultaWebmail = new ConsultaWebmail();
//		consultaWebmail.setIdAplicacion(UchileOrquestadorConstantes.getIdaplicacioncorreo());
//		consultaWebmail.setIdEmail(UchileOrquestadorConstantes.getIdemailcorreo());
		consultaWebmail.setRemoteAddr(Ip.direccionServer());

		ObjectMapper objectMapper = new ObjectMapper();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

		objectMapper.setDateFormat(sdf);

		objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		try{
			clienteRest.postEmail(consultaWebmail, vijnanaSeguridadProperties.getVijnanaServidor(),  vijnanaSeguridadAdmUsuarioProperties.getLocalWebmailEnviarCorreoCreacionUsuario());
			return true;
		}catch(Exception e){
			return false;
		}

	}




	public List<TipoAccionUsuario>  listaAccionPerfilxUsuario(String usernamePerfil, String tokenAuthenticacionContextSeguridad, String tipoAccionPerfil){

		List<TipoAccionUsuario> listaTipoAccionUsuario = null;

		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

		usuarioSeguridad.setKeyAutentificacion(tokenAuthenticacionContextSeguridad);

		usuarioSeguridad.setUsernamePerfil(usernamePerfil);

		usuarioSeguridad.setTipoAccionUsuario(tipoAccionPerfil);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad,  vijnanaSeguridadProperties.getVijnanaServidor(),vijnanaSeguridadAdmUsuarioProperties.getLocalListarAccionPerfilUsuario());

		if(responseSeguridad!=null){
			try{
				listaTipoAccionUsuario = responseSeguridad.getListaTipoAccionUsuario();
			}catch(Exception e){
				return null;
			}
		}else{
			return null;
		}

		return listaTipoAccionUsuario;
	}

	public boolean crearAccionPerfil(String usernamePerfil, String tokenAuthenticacionContextSeguridad, String tipoAccionPerfil){

		boolean retorno = false;

		UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

		usuarioSeguridad.setKeyAutentificacion(tokenAuthenticacionContextSeguridad);

		usuarioSeguridad.setUsernamePerfil(usernamePerfil);

		usuarioSeguridad.setTipoAccionUsuario(tipoAccionPerfil);

		ResponseSeguridad responseSeguridad = clienteRest.post(usuarioSeguridad,  vijnanaSeguridadProperties.getVijnanaServidor(),vijnanaSeguridadAdmUsuarioProperties.getLocalRegistrarAccionPerfilUsuario());

		if(responseSeguridad!=null){
			try{
				retorno = responseSeguridad.isValido();
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}

		return retorno;
	}

}
