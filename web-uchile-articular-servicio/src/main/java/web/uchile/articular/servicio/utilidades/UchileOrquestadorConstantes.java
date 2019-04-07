package web.uchile.articular.servicio.utilidades;

import java.io.Serializable;


public class UchileOrquestadorConstantes implements Serializable{

	private static final long serialVersionUID = 4265074225318807512L;
	
	
//	private static final String usernamePerfilCertificado = "solicitudcertificado";
//	private static final String usernamePerfilAcademica = "solicitudcertificado";
//	private static final String usernamePerfilPostulacion = "plataformauchile";
	
	private static final String dominioEmpresa = "uchile";
	private static final String nombrePerfil = "plataformauchile";

	private static final String nombreAplicacionUchile = "uchile";
	private static final String nombreAplicacionSeguridad = "seguridad";

	private static final String contrasenhaUsuarioEmpresa = "7890qw";
	

	private static final String rolContexto = "aplicacion";
	private static final String rolUsuario = "usuario";
	
//	private static final String aplicacion = "uchile";
	
	private static final String idEmailCorreo = "4"; //crear columna en correo relacionada con el id especifico del email en la aplicacion.
	private static final String idAplicacionCorreo = "2";
	
	private static final int largoFirma = 250;
	

	public UchileOrquestadorConstantes() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getNombreperfil() {
		return nombrePerfil;
	}

	public static String getNombreaplicacionuchile() {
		return nombreAplicacionUchile;
	}


	public static String getNombreaplicacionseguridad() {
		return nombreAplicacionSeguridad;
	}


	public static String getContrasenhausuarioempresa() {
		return contrasenhaUsuarioEmpresa;
	}


	public static String getDominioempresa() {
		return dominioEmpresa;
	}


	public static String getRolcontexto() {
		return rolContexto;
	}


	public static String getRolusuario() {
		return rolUsuario;
	}

//
//	public static String getAplicacion() {
//		return aplicacion;
//	}


	public static String getIdemailcorreo() {
		return idEmailCorreo;
	}


	public static String getIdaplicacioncorreo() {
		return idAplicacionCorreo;
	}

	public static int getLargofirma() {
		return largoFirma;
	}
	
	
	

}