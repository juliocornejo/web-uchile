package web.uchile.articular.session.model;

import java.io.Serializable;
import java.util.Date;

public class LoginModel  implements Serializable{
	//Se obtiene de BasicContext
	private static final long serialVersionUID = -8663566321865575514L;
	
	private int idUsuario;
	private String usernamePerfil = ""; //Nombre del Usuario el del eventual login
	private String passwordContrasenha= "";
	private String passwordConfirmacionContrasenha= "";
	private String nombrePerfilLowerCase= ""; //Nombre del Perfil a ver en la pagina del perfil
	private String passwordPregunta= "";
	private String respuestaPregunta= "";
	private String tipoDocumento= "";
	private String rutMember= "";
	private String nombreMember= "";//Nombre de la Persona
	private String apellidoPaternoMember= ""; //Apellido de la Persona
	private String apellidoMaternoMember= ""; //Apellido de la Persona
	private String mailMember= ""; //mail usuario
	private String telefonoContactoMember= "";
	private String fechaNacimientoMember= "";
	private String generoMember= "";
	private String firmaMember= "";
	private Date creacionMember;
	private Date ultimaAccionUsuario;
	private Date ultimaConexionPerfil; //ultimo momento en el cual el usuario hizo log-In en el servicio
	private String estadoPerfilLastBloqueado; 
	private int anonimo;
	
	private String selecGenero= "";
	private String selecDocumento= "";

	private String birthDay = "";
	private String birthMonth = "";
	private String birthYear = "";
	
	
	public LoginModel() {
		super();
	}
	
	public LoginModel(int idUsuario, String usernamePerfil, String passwordContrasenha,
			String passwordConfirmacionContrasenha, String nombrePerfilLowerCase, String passwordPregunta,
			String respuestaPregunta, String tipoDocumento, String rutMember, String nombreMember, String apellidoPaternoMember,
			String apellidoMaternoMember, String mailMember, String telefonoContactoMember,
			String fechaNacimientoMember, String generoMember, String firmaMember, Date creacionMember,
			Date ultimaAccionUsuario, Date ultimaConexionPerfil, String estadoPerfilLastBloqueado, int anonimo,
			String selecDocumento, String selecGenero,  String birthDay, String birthMonth, String birthYear) {
		super();
		this.idUsuario = idUsuario;
		this.usernamePerfil = usernamePerfil;
		this.passwordContrasenha = passwordContrasenha;
		this.passwordConfirmacionContrasenha = passwordConfirmacionContrasenha;
		this.nombrePerfilLowerCase = nombrePerfilLowerCase;
		this.passwordPregunta = passwordPregunta;
		this.respuestaPregunta = respuestaPregunta;
		this.tipoDocumento = tipoDocumento;
		this.rutMember = rutMember;
		this.nombreMember = nombreMember;
		this.apellidoPaternoMember = apellidoPaternoMember;
		this.apellidoMaternoMember = apellidoMaternoMember;
		this.mailMember = mailMember;
		this.telefonoContactoMember = telefonoContactoMember;
		this.fechaNacimientoMember = fechaNacimientoMember;
		this.generoMember = generoMember;
		this.firmaMember = firmaMember;
		this.creacionMember = creacionMember;
		this.ultimaAccionUsuario = ultimaAccionUsuario;
		this.ultimaConexionPerfil = ultimaConexionPerfil;
		this.estadoPerfilLastBloqueado = estadoPerfilLastBloqueado;
		this.anonimo = anonimo;
		this.selecDocumento = selecDocumento;
		this.selecGenero = selecGenero;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
	}



	public String getRespuestaPregunta() {
		return respuestaPregunta;
	}


	public void setRespuestaPregunta(String respuestaPregunta) {
		this.respuestaPregunta = respuestaPregunta;
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public String getUsernamePerfil() {
		return usernamePerfil;
	}

	public String getPasswordContrasenha() {
		return passwordContrasenha;
	}

	public String getNombrePerfilLowerCase() {
		return nombrePerfilLowerCase;
	}

	public String getPasswordPregunta() {
		return passwordPregunta;
	}

	public String getRutMember() {
		return rutMember;
	}

	public String getNombreMember() {
		return nombreMember;
	}

	public String getMailMember() {
		return mailMember;
	}

	public String getTelefonoContactoMember() {
		return telefonoContactoMember;
	}

	public String getFechaNacimientoMember() {
		return fechaNacimientoMember;
	}

	public String getGeneroMember() {
		return generoMember;
	}

	public String getFirmaMember() {
		return firmaMember;
	}

	public Date getCreacionMember() {
		return creacionMember;
	}

	public Date getUltimaAccionUsuario() {
		return ultimaAccionUsuario;
	}

	public Date getUltimaConexionPerfil() {
		return ultimaConexionPerfil;
	}

	public String getEstadoPerfilLastBloqueado() {
		return estadoPerfilLastBloqueado;
	}

	public int getAnonimo() {
		return anonimo;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setUsernamePerfil(String usernamePerfil) {
		this.usernamePerfil = usernamePerfil;
	}

	public void setPasswordContrasenha(String passwordContrasenha) {
		this.passwordContrasenha = passwordContrasenha;
	}

	public void setNombrePerfilLowerCase(String nombrePerfilLowerCase) {
		this.nombrePerfilLowerCase = nombrePerfilLowerCase;
	}

	public void setPasswordPregunta(String passwordPregunta) {
		this.passwordPregunta = passwordPregunta;
	}

	public void setRutMember(String rutMember) {
		this.rutMember = rutMember;
	}

	public void setNombreMember(String nombreMember) {
		this.nombreMember = nombreMember;
	}

	public void setMailMember(String mailMember) {
		this.mailMember = mailMember;
	}

	public void setTelefonoContactoMember(String telefonoContactoMember) {
		this.telefonoContactoMember = telefonoContactoMember;
	}

	public void setFechaNacimientoMember(String fechaNacimientoMember) {
		this.fechaNacimientoMember = fechaNacimientoMember;
	}

	public void setGeneroMember(String generoMember) {
		this.generoMember = generoMember;
	}

	public void setFirmaMember(String firmaMember) {
		this.firmaMember = firmaMember;
	}

	public void setCreacionMember(Date creacionMember) {
		this.creacionMember = creacionMember;
	}

	public void setUltimaAccionUsuario(Date ultimaAccionUsuario) {
		this.ultimaAccionUsuario = ultimaAccionUsuario;
	}

	public void setUltimaConexionPerfil(Date ultimaConexionPerfil) {
		this.ultimaConexionPerfil = ultimaConexionPerfil;
	}

	public void setEstadoPerfilLastBloqueado(String estadoPerfilLastBloqueado) {
		this.estadoPerfilLastBloqueado = estadoPerfilLastBloqueado;
	}

	public void setAnonimo(int anonimo) {
		this.anonimo = anonimo;
	}

	public String getApellidoPaternoMember() {
		return apellidoPaternoMember;
	}

	public String getApellidoMaternoMember() {
		return apellidoMaternoMember;
	}

	public void setApellidoPaternoMember(String apellidoPaternoMember) {
		this.apellidoPaternoMember = apellidoPaternoMember;
	}

	public void setApellidoMaternoMember(String apellidoMaternoMember) {
		this.apellidoMaternoMember = apellidoMaternoMember;
	}

	public String getPasswordConfirmacionContrasenha() {
		return passwordConfirmacionContrasenha;
	}

	public void setPasswordConfirmacionContrasenha(String passwordConfirmacionContrasenha) {
		this.passwordConfirmacionContrasenha = passwordConfirmacionContrasenha;
	}
	
	public String getSelecGenero() {
		return selecGenero;
	}

	public void setSelecGenero(String selecGenero) {
		this.selecGenero = selecGenero;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getSelecDocumento() {
		return selecDocumento;
	}

	public void setSelecDocumento(String selecDocumento) {
		this.selecDocumento = selecDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	
}
