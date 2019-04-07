package web.uchile.articular.servicio.properties;
//package web.uchile.orquestador.properties;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.Serializable;
//import java.util.Properties;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//class WebUchileLocalAplicacion implements Serializable {
//	
//	private static final long serialVersionUID = 1L;
//
//	public WebUchileLocalAplicacion(){
//		super();
//	}
//	
//	private static final Logger objLog = LoggerFactory.getLogger(WebUchileLocalAplicacion.class);
//	
//	private static Properties properties;
//	
//	public Properties obtenerProperties(){
//
//		if(properties == null){  
//
//			generarProperties();  
//		}  
//
//		return properties; 
//	}
//	
//	public void generarProperties(){
//		Properties metProp = new Properties();
//		InputStream is = null;
//		String nombreArch = "seguridad.properties";
//
//		is = getClass().getClassLoader().getResourceAsStream(nombreArch);
//
//		try {
//			metProp.load(is);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			metProp = new Properties();
//			objLog.error("Error en la obtencion del properties");
//		}
//
//		properties = metProp;
//	}
//	
////	public String getLocalObtenerBasicContext() {
////		Properties metProp = obtenerProperties();
////		
////		String propLocal = metProp.getProperty("url.metodo.obtener.Basic.Context");
////		
////		return propLocal;
////	}
////	
////	public String getLocalObtenerEnterpriseContext() {
////		Properties metProp = obtenerProperties();
////		
////		String propLocal = metProp.getProperty("url.metodo.obtener.Enterprise.Context");
////		
////		return propLocal;
////	}
////	
////	public String getLocalObtenerAuthenticacionContext() {
////		Properties metProp = obtenerProperties();
////		
////		String propLocal = metProp.getProperty("url.metodo.obtener.Authenticacion.Context");
////		
////		return propLocal;
////	}
////	
////	
////	public String getLocalRegistrarSessionPLataforma() {
////		Properties metProp = obtenerProperties();
////		
////		String propLocal = metProp.getProperty("url.metodo.obtener.registrar.session.Plataforma");
////		
////		return propLocal;
////	}
////	
////	public String getLocalGetSessionPLataforma() {
////		Properties metProp = obtenerProperties();
////		
////		String propLocal = metProp.getProperty("url.metodo.obtener.get.session.Plataforma");
////		
////		return propLocal;
////	}
////	
////	
////	public String getLocalObtenerUsuarioLogin() {
////		Properties metProp = obtenerProperties();
////		
////		String propLocal = metProp.getProperty("url.metodo.obtener.Usuario.Login");
////		
////		return propLocal;
////	}
////	
////	public String getLocalObtenerServicioAutenticacion() { 
////		Properties metProp = obtenerProperties();
////		
////		String propLocal = metProp.getProperty("url.metodo.obtener.servicio.Authenticacion");
////		
////		return propLocal;
////	}
//	/**************************************************************/
//	public String getLocalValidarExistenciaRut() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.validar.existencia.rut");
//		
//		return propLocal;
//	}
//	
//	public String getLocalValidarExistenciaCorreoElectronico() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.validar.existencia.correo.electronico");
//		
//		return propLocal;
//	}
//	
//	public String getLocalValidarExistenciaUsernameLogin() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.validar.existencia.username.login");
//		
//		return propLocal;
//	}
//	
//	public String getLocalValidarExistenciaNombrePerfil() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.validar.existencia.nombre.perfil");
//		
//		return propLocal;
//	}
//	
//	public String getLocalCrearNuevoUsuarioSeguridad() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.crear.nuevo.usuario.seguridad");
//		
//		return propLocal;
//	}
//	
//	public String getLocalActualizarNuevoUsuarioSeguridad() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.actualizar.usuario.seguridad");
//		
//		return propLocal;
//	}
//	
//	public String getLocalRecuperarContrasenhaUsuarioSeguridad() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.recuperar.contrasenha.usuario.seguridad");
//		
//		return propLocal;
//	}
//	
//	public String getLocalCambiarContrasenhaUsuarioSeguridad() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.cambiar.contrasenha.usuario.seguridad");
//		
//		return propLocal;
//	}
//	
//	public String getLocalListarUsuarioSeguridadxEmpresaxRolxFechaCreacion() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.listar.usuario.seguridad.x.empresa.x.rol.x.fechaCreacion");
//		
//		return propLocal;
//	}
//	
//	public String getLocalObtenerUsuarioSeguridadByIdUsuarioByEmailPerfil() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.obtener.usuario.seguridad.x.idusuario.x.correo.electronico");
//		
//		return propLocal;
//	}
//	
//	
//	
//	public String getLocalWebmailEnviarCorreoCreacionUsuario() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.webmail.enviar.correo.creacion.usuario");
//		
//		return propLocal;
//	}
//	
////	public String getLocalListarTipoAccionUsuario() {
////		Properties metProp = obtenerProperties();
////		
////		String propLocal = metProp.getProperty("url.metodo.listar.tipo.accion.usuario");
////		
////		return propLocal;
////	}
//	
//	public String getLocalListarAccionPerfilUsuario() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.listar.accion.perfil.x.usuario");
//		
//		return propLocal;
//	}
//	
//	public String getLocalRegistrarAccionPerfilUsuario() {
//		Properties metProp = obtenerProperties();
//		
//		String propLocal = metProp.getProperty("url.metodo.registrar.accion.perfil.usuario");
//		
//		return propLocal;
//	}
//	
//}
