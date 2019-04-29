package web.uchile.articular.session.impl;


import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import vijnana.respuesta.wrapper.response.seguridad.BasicContext;
import web.uchile.articular.servicio.impl.LoginModelo;
import web.uchile.articular.session.model.ResponseWebUchile;


public class LoginImpl {

	private static final Logger objLog = Logger.getLogger(LoginImpl.class);

	/*********************************************/
	private int selecPrograma = 0;
	/******************/
	private web.uchile.articular.session.model.LoginModel loginDTO;
	
	private String remoteAddr = "";
	private String remoteHost= "";
	
	private GeneracionAplicacion generarAplicacion;
	
	private String token = "";
	
	public LoginImpl(String remoteAddr, String remoteHost, String token){
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

	}

	/** @Do genera los valores de disabled y llenado de combobox del formulario 
	 * @param no param
	 * @return void.
	 * no lanza Excepciones.
	 */
	public void generarValoresFormulario(){
//		LoginModelo loginModelo = new LoginModelo();
		inicializarDisabled();
		
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
	
	
	public ResponseWebUchile obtenerUsuarioLoginAdministrador(String usernameLogin, String passwordLogin) {
		//Almacenar y redirigir a exito.xhtml
		return  obtenerUsuarioLogin(usernameLogin, passwordLogin, 3);
		
	}
	
	public ResponseWebUchile obtenerUsuarioLogin(String usernameLogin, String passwordLogin, int idRol) {
		//Almacenar y redirigir a exito.xhtml
		
		LoginModelo loginModelo = new LoginModelo();
		
		BasicContext basicContext = loginModelo.generarLoginUsuario(generarAplicacion.getAuthenticacionContext(), usernameLogin, passwordLogin, idRol);
		
		if(basicContext!=null){
			
			if(basicContext.getIdUsuario()>0 && basicContext.getUsernamePerfil()!=null && !"".equals(basicContext.getUsernamePerfil()) &&
					basicContext.getMailPerfil()!=null && !"".equals(basicContext.getMailPerfil()) && 
					basicContext.getNombreMember()!=null && !"".equals(basicContext.getNombreMember()) &&
					basicContext.getApellidoPaternoMember()!=null && !"".equals(basicContext.getApellidoPaternoMember()) &&
					basicContext.getApellidoMaternoMember()!=null && !"".equals(basicContext.getApellidoMaternoMember()) &&
							basicContext.getKeyBasic()!=null && !"".equals(basicContext.getKeyBasic()) &&
								basicContext.getIdRol()>0 && idRol ==basicContext.getIdRol()){
					
				objLog.info(basicContext.getIdUsuario()+" - "+basicContext.getIdEmpresa()+" - "+basicContext.getIdEmpresaUsuario());
				
				token = basicContext.getKeyBasic();
					
				return new ResponseWebUchile("administracion-solicitudes/", true);
			}
		}

		return null;
	}

	public int getSelecPrograma() {
		return selecPrograma;
	}

	public void setSelecPrograma(int selecPrograma) {
		this.selecPrograma = selecPrograma;
	}

	public web.uchile.articular.session.model.LoginModel getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(web.uchile.articular.session.model.LoginModel loginDTO) {
		this.loginDTO = loginDTO;
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

	/********************* METODOS DE FUNCIONAMIENTO ******************************/
	/******************GETTER y SETTER********************************************/
	
}
