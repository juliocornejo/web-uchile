package web.uchile.articular.session.utilidades;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manashiki.seguridad.servdto.dto.entities.formulario.UsuarioSeguridad;

import vijnana.respuesta.wrapper.response.seguridad.sessionplataforma.SessionPlataforma;
//import vijnana.seguridad.orquestador.app.seguridad.impl.SeguridadModelo;
import vijnana.utilidades.component.utilidades.ObtenerTexto;
import web.uchile.articular.servicio.impl.SeguridadAdmUsuarioModelo;
import web.uchile.articular.servicio.utilidades.UchileOrquestadorConstantes;
import web.uchile.articular.session.direccionamiento.Navigation;
import web.uchile.articular.session.model.LoginModel;

/*Esta Pagina Es Para la Creacion de Nuevos usuarios.*/
public class WebSolicitudesNegocio implements IWebSolicitudesNegocio, Serializable{

	private static final long serialVersionUID = 8793699335553709301L;

	private static final Logger objLog = LoggerFactory.getLogger(WebSolicitudesNegocio.class);
	
	public WebSolicitudesNegocio(){
	}


	public LoginModel inicializarDocumentoIdentificacion(LoginModel actualizarModel, SelectItem[] actListaDocumentoIdentificacion){

		for(SelectItem di: actListaDocumentoIdentificacion){
			if(actualizarModel.getTipoDocumento().equalsIgnoreCase(di.getLabel())){
				actualizarModel.setTipoDocumento(di.getLabel()+"");
				actualizarModel.setSelecDocumento(di.getValue()+"");
				break;
			}
		}

		return actualizarModel;
	}

	public LoginModel inicializarCalendarioActualizar(LoginModel actualizarModel, SelectItem[] actListaDiasNacimiento,
			SelectItem[] actListaMesesNacimiento, SelectItem[] actListaAniosNacimiento){

		String texto[] = ObtenerTexto.obtenerTextoBySplit(actualizarModel.getFechaNacimientoMember(), "-");

		texto[texto.length-2] = (texto[texto.length-2].startsWith("0")) ? texto[texto.length-2].substring(1,texto[texto.length-2].length()) : texto[texto.length-2]; 

		texto[texto.length-1] = (texto[texto.length-1].startsWith("0")) ? texto[texto.length-1].substring(1,texto[texto.length-1].length()) : texto[texto.length-1]; 

		//primero el año
		//segundo el mes
		//tercero el dia

		for(SelectItem anho : actListaAniosNacimiento ){
			if(texto[texto.length-3].equals(anho.getValue())){
				actualizarModel.setBirthYear(anho.getValue()+"");
				break;
			}
		}

		for(SelectItem mes: actListaMesesNacimiento){
			if(texto[texto.length-2].equals(mes.getValue())){
				actualizarModel.setBirthMonth(mes.getValue()+"");
				break;
			}
		}

		for(SelectItem dia : actListaDiasNacimiento){
			if(texto[texto.length-1].equals(dia.getValue())){
				actualizarModel.setBirthDay(dia.getValue()+"");
				break;
			}
		}

		return actualizarModel;
	}

	public String[] crearUsuario(String paginaRedireccion, boolean enviarCorreo, boolean online, LoginModel loginModel, SessionPlataforma sessionPlataforma) { 

		String[] mensajeRetorno = new String[2];
		mensajeRetorno[0] = "ERR";
		mensajeRetorno[1] = "No se ha realizado la Solicitud";
		//		FacesContext context = FacesContext.getCurrentInstance();

		SeguridadAdmUsuarioModelo seguridadAdmUsuarioModelo = new SeguridadAdmUsuarioModelo();
		//La aplicacion de seguridad es la que gestiona usuarios.
		boolean validar = ValidacionesWeb.validarLlenadoFormularioCreacion(loginModel, seguridadAdmUsuarioModelo, sessionPlataforma.getDataPlataformaAutentificacion().get(UchileOrquestadorConstantes.getNombreaplicacionseguridad()).getKeyAutentificacion());

		if(validar==true){

			try{
				//Asociar el archivo con la Solicitud Academica
				objLog.info("11 rut:"+loginModel.getRutMember());

				objLog.info("A1: creando Usuario");
				UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

				usuarioSeguridad.setTipoIdentificador(loginModel.getTipoDocumento());
				usuarioSeguridad.setRutMember(loginModel.getRutMember());
				usuarioSeguridad.setNombreMember(loginModel.getNombreMember());//Nombre de la Persona
				usuarioSeguridad.setApellidoPaterno(loginModel.getApellidoPaternoMember());
				usuarioSeguridad.setApellidoMaterno(loginModel.getApellidoMaternoMember());
				usuarioSeguridad.setMailUsuario(loginModel.getMailMember());
				usuarioSeguridad.setTelefonoContactoMember(loginModel.getTelefonoContactoMember());
				usuarioSeguridad.setFechaNacimientoMember(loginModel.getFechaNacimientoMember());
				usuarioSeguridad.setGeneroMember(loginModel.getGeneroMember().toLowerCase());
				usuarioSeguridad.setFirmaMember(loginModel.getFirmaMember());
				usuarioSeguridad.setUsernamePerfil(loginModel.getUsernamePerfil()); //Nombre del Usuario el del eventual login
				usuarioSeguridad.setNombrePerfilLowerCase(loginModel.getNombrePerfilLowerCase()); //Nombre del Perfil a ver en la pagina del perfil
				usuarioSeguridad.setPasswordContrasenha(loginModel.getPasswordContrasenha());
				usuarioSeguridad.setPasswordPregunta(loginModel.getPasswordPregunta());
				usuarioSeguridad.setPasswordRespuesta(loginModel.getRespuestaPregunta());

				usuarioSeguridad = seguridadAdmUsuarioModelo.crearNuevoUsuarioSeguridad(usuarioSeguridad, 
						sessionPlataforma.getDataPlataformaAutentificacion().get(UchileOrquestadorConstantes.getNombreaplicacionseguridad()),
						UchileOrquestadorConstantes.getRolusuario(),
						"cambiar");

				if( usuarioSeguridad!=null && usuarioSeguridad.getIdUsuario()>0){

					objLog.info("A4: Redireccion a exito Usuario "+paginaRedireccion);

					Navigation.redirectInterno(paginaRedireccion);

					if(enviarCorreo==true ){

						seguridadAdmUsuarioModelo.postEmail(sessionPlataforma.getDataPlataformaAutentificacion());

						objLog.info("A2: Envio Email para creacion de Nuevo usuario");
						mensajeRetorno[0] = "OK";
						mensajeRetorno[1] = "Creando Usuario y Envio Email para creacion de Nuevo usuario";
						return mensajeRetorno;
					}else{
						mensajeRetorno[0] = "AOK";
						mensajeRetorno[1] = "Creando Usuario y No se pudo Enviar Email";
						return mensajeRetorno;
					}
				}
				else{
					mensajeRetorno[0] = "ERR";
					mensajeRetorno[1] = "No se pudo Crear el usuario";
					return mensajeRetorno;
				}
			}
			catch(Exception e){
				objLog.info("ERROR - crearUsuario: "+loginModel.getRutMember()+" - "+e.getMessage());
				mensajeRetorno[0] = "ERR";
				mensajeRetorno[1] = "Error en la Creacion del Usuario";
				return mensajeRetorno;
			}
		}

		if(validar==false){
			mensajeRetorno[0] = "ERR";
			mensajeRetorno[1] = "Falta completar Campos";
			return mensajeRetorno;
		}

		objLog.info("A5: Fin almacenarSolicitudPostulacion");
		return mensajeRetorno;
	}

	public String[] actualizarUsuario(int idLogin, String paginaRedireccion, boolean enviarCorreo, boolean online, LoginModel loginModel, SessionPlataforma sessionPlataforma) { 

		String[] mensajeRetorno = new String[2];
		mensajeRetorno[0] = "ERR";
		mensajeRetorno[1] = "No se ha realizado la Solicitud";

		SeguridadAdmUsuarioModelo seguridadAdmUsuarioModelo = new SeguridadAdmUsuarioModelo();
		//La aplicacion de seguridad es la que gestiona usuarios.
		boolean validar = ValidacionesWeb.validarLlenadoFormularioCreacion(loginModel, seguridadAdmUsuarioModelo, sessionPlataforma.getDataPlataformaAutentificacion().get(UchileOrquestadorConstantes.getNombreaplicacionseguridad()).getKeyAutentificacion());

		if(validar==true){

			try{
				//Asociar el archivo con la Solicitud Academica
				objLog.info("11 rut:"+loginModel.getRutMember());

				objLog.info("A1: actualizando Usuario");
				UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

				usuarioSeguridad.setIdUsuario(idLogin);
				usuarioSeguridad.setRutMember(loginModel.getRutMember());
				usuarioSeguridad.setNombreMember(loginModel.getNombreMember());//Nombre de la Persona
				usuarioSeguridad.setApellidoPaterno(loginModel.getApellidoPaternoMember());
				usuarioSeguridad.setApellidoMaterno(loginModel.getApellidoMaternoMember());
				usuarioSeguridad.setMailUsuario(loginModel.getMailMember());
				usuarioSeguridad.setTelefonoContactoMember(loginModel.getTelefonoContactoMember());
				usuarioSeguridad.setFechaNacimientoMember(loginModel.getFechaNacimientoMember());
				usuarioSeguridad.setGeneroMember(loginModel.getGeneroMember().toLowerCase());
				usuarioSeguridad.setFirmaMember(loginModel.getFirmaMember());
				usuarioSeguridad.setUsernamePerfil(loginModel.getUsernamePerfil()); //Nombre del Usuario el del eventual login
				usuarioSeguridad.setNombrePerfilLowerCase(loginModel.getNombrePerfilLowerCase()); //Nombre del Perfil a ver en la pagina del perfil
				usuarioSeguridad.setPasswordContrasenha(loginModel.getPasswordContrasenha());
				usuarioSeguridad.setPasswordPregunta(loginModel.getPasswordPregunta());
				usuarioSeguridad.setPasswordRespuesta(loginModel.getRespuestaPregunta());

				usuarioSeguridad = seguridadAdmUsuarioModelo.actualizarNuevoUsuarioSeguridad(usuarioSeguridad, 
						sessionPlataforma.getDataPlataformaAutentificacion().get(UchileOrquestadorConstantes.getNombreaplicacionseguridad()),
						UchileOrquestadorConstantes.getRolusuario(),
						"cambiar");

				if( usuarioSeguridad!=null && usuarioSeguridad.getIdUsuario()>0){

					objLog.info("A4: Redireccion a exito Usuario "+paginaRedireccion);

					Navigation.redirectInterno(paginaRedireccion);

					if(enviarCorreo==true ){

						seguridadAdmUsuarioModelo.postEmail(sessionPlataforma.getDataPlataformaAutentificacion());

						objLog.info("A2: Envio Email para actualizacion de usuario");
						mensajeRetorno[0] = "OK";
						mensajeRetorno[1] = "Actualizando Usuario y Envio Email para actualizacion de usuario";
						return mensajeRetorno;
					}else{
						mensajeRetorno[0] = "AOK";
						mensajeRetorno[1] = "Actualizando Usuario y No se pudo Enviar Email";
						return mensajeRetorno;
					}
				}
				else{
					mensajeRetorno[0] = "ERR";
					mensajeRetorno[1] = "No se pudo Actualizar el usuario";
					return mensajeRetorno;
				}
			}
			catch(Exception e){
				objLog.info("ERROR - actualizarUsuario: "+loginModel.getRutMember()+" - "+e.getMessage());
				mensajeRetorno[0] = "ERR";
				mensajeRetorno[1] = "Error en la Actualizacion del Usuario";
				return mensajeRetorno;
			}
		}

		if(validar==false){
			mensajeRetorno[0] = "ERR";
			mensajeRetorno[1] = "Falta completar Campos";
			return mensajeRetorno;
		}

		objLog.info("A5: Fin actualizarUsuario");
		return mensajeRetorno;
	}

	public String[] recuperarContrasenhaUsuarioByMail( String paginaRedireccion, boolean enviarCorreo, boolean online, LoginModel loginModel, SessionPlataforma sessionPlataforma) { 

		String[] mensajeRetorno = new String[2];
		mensajeRetorno[0] = "ERR";
		mensajeRetorno[1] = "No se ha realizado la Solicitud";

		SeguridadAdmUsuarioModelo seguridadAdmUsuarioModelo = new SeguridadAdmUsuarioModelo();
		//La aplicacion de seguridad es la que gestiona usuarios.

		if(true){

			try{
				//Asociar el archivo con la Solicitud Academica
				objLog.info("11 rut:"+loginModel.getMailMember());

				objLog.info("A1: recuperar Contrasenha Usuario By Mail");
				UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

				usuarioSeguridad.setMailUsuario(loginModel.getMailMember());

				boolean existeCorreo = seguridadAdmUsuarioModelo.recuperarContrasenhaUsuarioByMail(usuarioSeguridad, sessionPlataforma.getDataPlataformaAutentificacion().get(UchileOrquestadorConstantes.getNombreaplicacionseguridad()),
						UchileOrquestadorConstantes.getRolusuario(),
						"cambiar");

				if( existeCorreo){

					objLog.info("A4: Redireccion a exito Usuario "+paginaRedireccion);

					Navigation.redirectInterno(paginaRedireccion);

					if(enviarCorreo==true ){

						seguridadAdmUsuarioModelo.postEmailRecuperacionCorreo(sessionPlataforma.getDataPlataformaAutentificacion());

						objLog.info("A2: Envio Email para actualizacion de usuario");
						mensajeRetorno[0] = "OK";
						mensajeRetorno[1] = "Envio Email para recuperacion de usuario";
						return mensajeRetorno;
					}else{
						mensajeRetorno[0] = "AOK";
						mensajeRetorno[1] = "No se pudo Enviar Email";
						return mensajeRetorno;
					}
				}
				else{
					mensajeRetorno[0] = "ERR";
					mensajeRetorno[1] = "No Existe el correo del usuario";
					return mensajeRetorno;
				}
			}
			catch(Exception e){
				objLog.info("ERROR - actualizarUsuario: "+loginModel.getRutMember()+" - "+e.getMessage());
				mensajeRetorno[0] = "ERR";
				mensajeRetorno[1] = "Error en la Actualizacion del Usuario";
				return mensajeRetorno;
			}
		}

		return null;
	}

	public String[] cambiarContrasenhaUsuario( String paginaRedireccion, boolean enviarCorreo, boolean online, LoginModel loginModel, LoginModel nuevoLoginModel, SessionPlataforma sessionPlataforma) { 

		String[] mensajeRetorno = new String[2];


		if(!nuevoLoginModel.getPasswordContrasenha().equals(loginModel.getPasswordContrasenha())){
			SeguridadAdmUsuarioModelo seguridadAdmUsuarioModelo = new SeguridadAdmUsuarioModelo();
			//nuevo loginDTO
			//La aplicacion de seguridad es la que gestiona usuarios.

			if(nuevoLoginModel.getPasswordConfirmacionContrasenha().equals(nuevoLoginModel.getPasswordContrasenha())){
				try{
					//Asociar el archivo con la Solicitud Academica
					objLog.info("XxxxAsociarlo Al Login - -:");

					objLog.info("A1: cambiar Contrasenha Usuario");
					UsuarioSeguridad usuarioSeguridad = new UsuarioSeguridad();

					//Nueva Contrasenha debe venir aquí
					usuarioSeguridad.setPasswordContrasenha(loginModel.getPasswordContrasenha());

					boolean existeCorreo = seguridadAdmUsuarioModelo.cambiarContrasenhaUsuario(usuarioSeguridad, sessionPlataforma.getDataPlataformaAutentificacion().get(UchileOrquestadorConstantes.getNombreaplicacionseguridad()),
							UchileOrquestadorConstantes.getRolusuario(),
							"cambiar");

					if( existeCorreo){

						objLog.info("A4: Redireccion a exito Usuario "+paginaRedireccion);

						Navigation.redirectInterno(paginaRedireccion);

						if(enviarCorreo==true ){

							seguridadAdmUsuarioModelo.postEmailRecuperacionCorreo(sessionPlataforma.getDataPlataformaAutentificacion());

							objLog.info("A2: Envio Email para actualizacion de usuario");
							mensajeRetorno[0] = "OK";
							mensajeRetorno[1] = "Envio Email para recuperacion de usuario";
							return mensajeRetorno;
						}else{
							mensajeRetorno[0] = "AOK";
							mensajeRetorno[1] = "No se pudo Enviar Email";
							return mensajeRetorno;
						}
					}
					else{
						mensajeRetorno[0] = "ERR";
						mensajeRetorno[1] = "No Existe el correo del usuario";
						return mensajeRetorno;
					}
				}
				catch(Exception e){
					objLog.info("ERROR - actualizarUsuario: "+loginModel.getRutMember()+" - "+e.getMessage());
					mensajeRetorno[0] = "ERR";
					mensajeRetorno[1] = "Error en la Actualizacion del Usuario";
					return mensajeRetorno;
				}
			}else{
				mensajeRetorno[0] = "ERR";
				mensajeRetorno[1] = "La Nueva contraseña y su confirmacion no son iguales ";
			}
		}else{
			mensajeRetorno[0] = "ERR";
			mensajeRetorno[1] = "La Actual contraseña y la nueva son iguales";
		}


		return mensajeRetorno;
	}

	public LoginModel validarDocumentoIdentificacion(LoginModel loginModel, SelectItem[] listaDocumentoIdentificacion) throws Exception{

		if(loginModel.getSelecDocumento()!=null && !"".equals(loginModel.getSelecDocumento())){
			for(SelectItem doc: listaDocumentoIdentificacion){
				if(loginModel.getSelecDocumento().equals(doc.getValue()+"")){
					loginModel.setTipoDocumento(doc.getLabel());
					break;
				}
			}
			objLog.info("H DocumentoIdentificacion:"+loginModel.getTipoDocumento());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	/***** Validaciones del Formulario ****/
	public LoginModel validarRutMember(LoginModel loginModel) throws Exception{
		if(loginModel.getRutMember()!=null && !"".equals(loginModel.getRutMember())){
			objLog.info("A nombre:"+loginModel.getRutMember());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	public LoginModel validarNombreMember(LoginModel loginModel) throws Exception{
		if(loginModel.getNombreMember()!=null && !"".equals(loginModel.getNombreMember())){
			objLog.info("B nombre:"+loginModel.getNombreMember());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	public LoginModel validarApellidoPaternoMember(LoginModel loginModel) throws Exception{
		if(loginModel.getApellidoPaternoMember()!=null && !"".equals(loginModel.getApellidoPaternoMember())){
			objLog.info("C Apellido Paterno:"+loginModel.getApellidoPaternoMember());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	public LoginModel validarApellidoMaternoMember(LoginModel loginModel) throws Exception{
		if(loginModel.getApellidoMaternoMember()!=null && !"".equals(loginModel.getApellidoMaternoMember())){
			objLog.info("D Apellido Materno:"+loginModel.getApellidoMaternoMember());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	public LoginModel validarBirthDay(LoginModel loginModel) throws Exception{
		if(loginModel.getBirthDay()!=null && !"".equals(loginModel.getBirthDay())){
			objLog.info("BD Dia de Nacimiento:"+loginModel.getBirthDay());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	public LoginModel validarBirthMonth(LoginModel loginModel) throws Exception{
		if(loginModel.getBirthMonth()!=null && !"".equals(loginModel.getBirthMonth())){
			objLog.info("BM Mes de Nacimiento:"+loginModel.getBirthMonth());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	public LoginModel validarBirthYear(LoginModel loginModel) throws Exception{
		if(loginModel.getBirthYear()!=null && !"".equals(loginModel.getBirthYear())){
			objLog.info("BY Anho de Nacimiento:"+loginModel.getBirthYear());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	public LoginModel validarTelefonoContactoMember(LoginModel loginModel) throws Exception{
		if(loginModel.getTelefonoContactoMember()!=null && !"".equals(loginModel.getTelefonoContactoMember())){
			objLog.info("F Telefono de Contacto:"+loginModel.getTelefonoContactoMember());
		}
		else{
			throw new Exception();
		}
		return loginModel;

	}
	public LoginModel validarMailMember(LoginModel loginModel) throws Exception{
		if(loginModel.getMailMember()!=null && !"".equals(loginModel.getMailMember())){
			objLog.info("G Email de Contacto:"+loginModel.getMailMember());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	public LoginModel validarGeneroMember(LoginModel loginModel, SelectItem[] listaGenero) throws Exception{

		if(loginModel.getSelecGenero()!=null && !"".equals(loginModel.getSelecGenero())){
			for(SelectItem gen:listaGenero){
				if(loginModel.getSelecGenero().equals(gen.getValue()+"")){
					loginModel.setGeneroMember(gen.getLabel());
					break;
				}
			}
			objLog.info("H Genero:"+loginModel.getGeneroMember());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}

	public LoginModel validarFirmaMember(LoginModel loginModel, int largoFirma) throws Exception{
		if(loginModel.getFirmaMember()!=null && !"".equals(loginModel.getFirmaMember())){
			if(loginModel.getFirmaMember().length()>largoFirma){
				loginModel.setFirmaMember(loginModel.getFirmaMember().substring(0,largoFirma));
			}
			objLog.info("I Firma:"+loginModel.getFirmaMember());
		}
		else{
			throw new Exception();
		}
		return loginModel;

	}
	public LoginModel validarUsernamePerfil(LoginModel loginModel) throws Exception{
		if(loginModel.getUsernamePerfil()!=null && !"".equals(loginModel.getUsernamePerfil())){
			objLog.info("J Username:"+loginModel.getUsernamePerfil());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}
	public LoginModel validarNombrePerfilLowerCase(LoginModel loginModel) throws Exception{
		if(loginModel.getNombrePerfilLowerCase()!=null && !"".equals(loginModel.getNombrePerfilLowerCase())){
			objLog.info("K NombrePerfilLowerCase:"+loginModel.getNombrePerfilLowerCase());
		}
		else{
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ha ingresado nombre del usuario");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return loginModel;
	}
	public LoginModel validarPasswordContrasenha(LoginModel loginModel) throws Exception{
		if(loginModel.getPasswordContrasenha()!=null && !"".equals(loginModel.getPasswordContrasenha())){
			objLog.info("L PasswordContraseña:"+loginModel.getPasswordContrasenha());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}
	public LoginModel validarPasswordConfirmacionContrasenha(LoginModel loginModel) throws Exception{
		if(loginModel.getPasswordConfirmacionContrasenha()!=null && !"".equals(loginModel.getPasswordConfirmacionContrasenha())){
			objLog.info("M PasswordConfirmacionContrasenha:"+loginModel.getPasswordConfirmacionContrasenha());
		}
		else{
			throw new Exception();
		}
		return loginModel;

	}
	public LoginModel validarPasswordPregunta(LoginModel loginModel) throws Exception{
		if(loginModel.getPasswordPregunta()!=null && !"".equals(loginModel.getPasswordPregunta())){
			objLog.info("O PasswordPregunta:"+loginModel.getPasswordPregunta());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}
	public LoginModel validarRespuestaPregunta(LoginModel loginModel) throws Exception{
		if(loginModel.getRespuestaPregunta()!=null && !"".equals(loginModel.getRespuestaPregunta())){
			objLog.info("P RespuestaPregunta:"+loginModel.getRespuestaPregunta());
		}
		else{
			throw new Exception();
		}
		return loginModel;
	}


	public LoginModel recuperarContrasenha(LoginModel loginModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public LoginModel cambiarContrasenha(LoginModel antiguoLoginModel, LoginModel nuevaLoginModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
