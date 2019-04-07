package web.uchile.articular.session.model;
//package web.uchile.orquestador.session.model;
//
//import java.io.Serializable;
//import java.util.Date;
//
//public class SolicitudCreacionUsuarioModel implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	
//	private int idUsuario;
//	private String usernamePerfil; //Nombre del Usuario el del eventual login
//	private String passwordContrasenha;
//	private String passwordConfirmacionContrasenha;
//	private String nombrePerfilLowerCase; //Nombre del Perfil a ver en la pagina del perfil
//	private String passwordPregunta;
//	private String respuestaPregunta;
//	private String rutMember;
//	private String nombreMember;//Nombre de la Persona
//	private String apellidoPaternoMember; //Apellido de la Persona
//	private String apellidoMaternoMember; //Apellido de la Persona
//	private String mailMember; //mail usuario
//	private String telefonoContactoMember;
//	private String fechaNacimientoMember;
//	private String generoMember;
//	private String firmaMember;
//	private Date creacionMember;
//	private Date ultimaAccionUsuario;
//	private Date ultimaConexionPerfil; //ultimo momento en el cual el usuario hizo log-In en el servicio
//	private String estadoPerfilLastBloqueado; 
//	private int anonimo;
//	
//	private String diaNacimiento;
//	private String mesNacimiento;
//	private String anhoNacimiento;
//	
//	public int getIdUsuario() {
//		return idUsuario;
//	}
//
//	public String getUsernamePerfil() {
//		return usernamePerfil;
//	}
//
//	public String getPasswordContrasenha() {
//		return passwordContrasenha;
//	}
//
//	public String getPasswordConfirmacionContrasenha() {
//		return passwordConfirmacionContrasenha;
//	}
//
//	public String getNombrePerfilLowerCase() {
//		return nombrePerfilLowerCase;
//	}
//
//	public String getPasswordPregunta() {
//		return passwordPregunta;
//	}
//
//	public String getRespuestaPregunta() {
//		return respuestaPregunta;
//	}
//
//	public String getRutMember() {
//		return rutMember;
//	}
//
//	public String getNombreMember() {
//		return nombreMember;
//	}
//
//	public String getApellidoPaternoMember() {
//		return apellidoPaternoMember;
//	}
//
//	public String getApellidoMaternoMember() {
//		return apellidoMaternoMember;
//	}
//
//	public String getMailMember() {
//		return mailMember;
//	}
//
//	public String getTelefonoContactoMember() {
//		return telefonoContactoMember;
//	}
//
//	public String getFechaNacimientoMember() {
//		return fechaNacimientoMember;
//	}
//
//	public String getGeneroMember() {
//		return generoMember;
//	}
//
//	public String getFirmaMember() {
//		return firmaMember;
//	}
//
//	public Date getCreacionMember() {
//		return creacionMember;
//	}
//
//	public Date getUltimaAccionUsuario() {
//		return ultimaAccionUsuario;
//	}
//
//	public Date getUltimaConexionPerfil() {
//		return ultimaConexionPerfil;
//	}
//
//	public String getEstadoPerfilLastBloqueado() {
//		return estadoPerfilLastBloqueado;
//	}
//
//	public int getAnonimo() {
//		return anonimo;
//	}
//
//	public String getDiaNacimiento() {
//		return diaNacimiento;
//	}
//
//	public String getMesNacimiento() {
//		return mesNacimiento;
//	}
//
//	public String getAnhoNacimiento() {
//		return anhoNacimiento;
//	}
//
//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}
//
//	public void setUsernamePerfil(String usernamePerfil) {
//		this.usernamePerfil = usernamePerfil;
//	}
//
//	public void setPasswordContrasenha(String passwordContrasenha) {
//		this.passwordContrasenha = passwordContrasenha;
//	}
//
//	public void setPasswordConfirmacionContrasenha(String passwordConfirmacionContrasenha) {
//		this.passwordConfirmacionContrasenha = passwordConfirmacionContrasenha;
//	}
//
//	public void setNombrePerfilLowerCase(String nombrePerfilLowerCase) {
//		this.nombrePerfilLowerCase = nombrePerfilLowerCase;
//	}
//
//	public void setPasswordPregunta(String passwordPregunta) {
//		this.passwordPregunta = passwordPregunta;
//	}
//
//	public void setRespuestaPregunta(String respuestaPregunta) {
//		this.respuestaPregunta = respuestaPregunta;
//	}
//
//	public void setRutMember(String rutMember) {
//		this.rutMember = rutMember;
//	}
//
//	public void setNombreMember(String nombreMember) {
//		this.nombreMember = nombreMember;
//	}
//
//	public void setApellidoPaternoMember(String apellidoPaternoMember) {
//		this.apellidoPaternoMember = apellidoPaternoMember;
//	}
//
//	public void setApellidoMaternoMember(String apellidoMaternoMember) {
//		this.apellidoMaternoMember = apellidoMaternoMember;
//	}
//
//	public void setMailMember(String mailMember) {
//		this.mailMember = mailMember;
//	}
//
//	public void setTelefonoContactoMember(String telefonoContactoMember) {
//		this.telefonoContactoMember = telefonoContactoMember;
//	}
//
//	public void setFechaNacimientoMember(String fechaNacimientoMember) {
//		this.fechaNacimientoMember = fechaNacimientoMember;
//	}
//
//	public void setGeneroMember(String generoMember) {
//		this.generoMember = generoMember;
//	}
//
//	public void setFirmaMember(String firmaMember) {
//		this.firmaMember = firmaMember;
//	}
//
//	public void setCreacionMember(Date creacionMember) {
//		this.creacionMember = creacionMember;
//	}
//
//	public void setUltimaAccionUsuario(Date ultimaAccionUsuario) {
//		this.ultimaAccionUsuario = ultimaAccionUsuario;
//	}
//
//	public void setUltimaConexionPerfil(Date ultimaConexionPerfil) {
//		this.ultimaConexionPerfil = ultimaConexionPerfil;
//	}
//
//	public void setEstadoPerfilLastBloqueado(String estadoPerfilLastBloqueado) {
//		this.estadoPerfilLastBloqueado = estadoPerfilLastBloqueado;
//	}
//
//	public void setAnonimo(int anonimo) {
//		this.anonimo = anonimo;
//	}
//
//	public void setDiaNacimiento(String diaNacimiento) {
//		this.diaNacimiento = diaNacimiento;
//	}
//
//	public void setMesNacimiento(String mesNacimiento) {
//		this.mesNacimiento = mesNacimiento;
//	}
//
//	public void setAnhoNacimiento(String anhoNacimiento) {
//		this.anhoNacimiento = anhoNacimiento;
//	}
//	
//	
//}
