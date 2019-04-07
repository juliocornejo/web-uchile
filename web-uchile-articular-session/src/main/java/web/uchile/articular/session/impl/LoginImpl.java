package web.uchile.articular.session.impl;


import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.manashiki.seguridad.servdto.dto.entities.transferencia.ResponseSeguridad;

import web.uchile.articular.servicio.impl.LoginModelo;
import web.uchile.articular.session.model.LoginModel;


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
	
	public LoginModel obtenerUsuarioLogin(String usernameLogin, String passwordLogin) {
		//Almacenar y redirigir a exito.xhtml
		LoginModel loginModel = null;
		LoginModelo loginModelo = new LoginModelo();
		
//		UchileArte uchileArte = null;
//		generarAplicacion.generarLoginUsuario( loginDTO.getUsernamePerfil(), loginDTO.getPasswordContrasenha());
		ResponseSeguridad responseSeguridad = loginModelo.generarLoginUsuario(generarAplicacion.getAuthenticacionContext(), usernameLogin, passwordLogin);
		
		if(responseSeguridad!=null && responseSeguridad.getBasicContext()!=null){
			responseSeguridad.getBasicContext();
			loginModel = new LoginModel();
			loginModel.setIdUsuario(responseSeguridad.getBasicContext().getIdUsuario());
			loginModel.setUsernamePerfil(responseSeguridad.getBasicContext().getUsernamePerfil());
			loginModel.setMailMember(responseSeguridad.getBasicContext().getMailPerfil());
			loginModel.setUsernamePerfil(usernameLogin);
			loginModel.setNombreMember(responseSeguridad.getBasicContext().getNombreMember());
			loginModel.setApellidoPaternoMember(responseSeguridad.getBasicContext().getApellidoPaternoMember());
			loginModel.setApellidoMaternoMember(responseSeguridad.getBasicContext().getApellidoMaternoMember());
			loginModel.setAnonimo(responseSeguridad.getBasicContext().getAnonimo());
			loginModel.setUltimaConexionPerfil(new Date());
			loginModel.setRutMember(responseSeguridad.getBasicContext().getValueIdentificador());
			objLog.info(responseSeguridad.getBasicContext().getIdUsuario()+" - "+responseSeguridad.getBasicContext().getIdEmpresa()+" - "+responseSeguridad.getBasicContext().getIdEmpresaUsuario());
			
			token = responseSeguridad.getBasicContext().getKeyBasic();
		}

		return loginModel;
	}

	/********************* METODOS DE FUNCIONAMIENTO ******************************/
	/******************GETTER y SETTER********************************************/

	public int getSelecPrograma() {
		return selecPrograma;
	}

	public web.uchile.articular.session.model.LoginModel getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(web.uchile.articular.session.model.LoginModel loginDTO) {
		this.loginDTO = loginDTO;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setSelecPrograma(int selecPrograma) {
		this.selecPrograma = selecPrograma;
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
	
}
