package web.uchile.articular.session.utilidades;

import javax.faces.model.SelectItem;

import vijnana.respuesta.wrapper.response.seguridad.sessionplataforma.SessionPlataforma;
import web.uchile.articular.session.model.LoginModel;

public interface IWebSolicitudesNegocio {
	
	public LoginModel inicializarDocumentoIdentificacion(LoginModel actualizarModel, SelectItem[] actListaDocumentoIdentificacion);

	public LoginModel inicializarCalendarioActualizar(LoginModel actualizarModel, SelectItem[] actListaDiasNacimiento, SelectItem[] actListaMesesNacimiento, SelectItem[] actListaAniosNacimiento);

	public String[] crearUsuario(String paginaRedireccion, boolean enviarCorreo, boolean online, LoginModel loginModel, SessionPlataforma sessionPlataforma);

	public String[] actualizarUsuario(int idLogin, String paginaRedireccion, boolean enviarCorreo, boolean online, LoginModel loginModel, SessionPlataforma sessionPlataforma);

	public String[] recuperarContrasenhaUsuarioByMail( String paginaRedireccion, boolean enviarCorreo, boolean online, LoginModel loginModel, SessionPlataforma sessionPlataforma);

	public String[] cambiarContrasenhaUsuario( String paginaRedireccion, boolean enviarCorreo, boolean online, LoginModel loginModel, LoginModel nuevoLoginModel, SessionPlataforma sessionPlataforma);

	public LoginModel validarDocumentoIdentificacion(LoginModel loginModel, SelectItem[] listaDocumentoIdentificacion) throws Exception;
	
	public LoginModel validarRutMember(LoginModel loginModel) throws Exception;

	public LoginModel validarNombreMember(LoginModel loginModel) throws Exception;

	public LoginModel validarApellidoPaternoMember(LoginModel loginModel) throws Exception;

	public LoginModel validarApellidoMaternoMember(LoginModel loginModel) throws Exception;

	public LoginModel validarBirthDay(LoginModel loginModel) throws Exception;

	public LoginModel validarBirthMonth(LoginModel loginModel) throws Exception;

	public LoginModel validarBirthYear(LoginModel loginModel) throws Exception;

	public LoginModel validarTelefonoContactoMember(LoginModel loginModel) throws Exception;
	
	public LoginModel validarMailMember(LoginModel loginModel) throws Exception;

	public LoginModel validarGeneroMember(LoginModel loginModel, SelectItem[] listaGenero) throws Exception;

	public LoginModel validarFirmaMember(LoginModel loginModel, int largoFirma) throws Exception;

	public LoginModel validarUsernamePerfil(LoginModel loginModel) throws Exception;
	
	public LoginModel validarNombrePerfilLowerCase(LoginModel loginModel) throws Exception;
	
	public LoginModel validarPasswordContrasenha(LoginModel loginModel) throws Exception;
	
	public LoginModel validarPasswordConfirmacionContrasenha(LoginModel loginModel) throws Exception;
	
	public LoginModel validarPasswordPregunta(LoginModel loginModel) throws Exception;
	
	public LoginModel validarRespuestaPregunta(LoginModel loginModel) throws Exception;
	
	public LoginModel recuperarContrasenha(LoginModel loginModel) throws Exception;

	public LoginModel cambiarContrasenha(LoginModel antiguoLoginModel, LoginModel nuevaLoginModel) throws Exception ;

}
