package web.uchile.articular.session.utilidades;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.ValidacionPatrones;
import web.uchile.articular.servicio.impl.SeguridadAdmUsuarioModelo;
import web.uchile.articular.session.model.LoginModel;

public class ValidacionesWeb {

	public static boolean validarContrasenha(LoginModel loginModel){

		boolean validar = false;

		if(loginModel.getPasswordContrasenha()!=null && !loginModel.getPasswordContrasenha().equals("")){
			if(loginModel.getPasswordConfirmacionContrasenha()!=null && !loginModel.getPasswordConfirmacionContrasenha().equals("")){
				if(loginModel.getPasswordConfirmacionContrasenha().equals(loginModel.getPasswordContrasenha())){
					validar = true;
				}else{
					FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso respuesta a pregunta de recuperacion");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}else{
				FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso pregunta de recuperacion");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}else{
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "Contraseña de Verificacion es Distinta");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return validar;
	}

	public static boolean validarLlenadoFormularioCreacion(LoginModel loginDTO, 
			SeguridadAdmUsuarioModelo seguridadAdmUsuarioModelo, 
			String tokenAuthenticacionContextSeguridad){

		boolean validar = false;

		String year = loginDTO.getBirthYear();

		String month = loginDTO.getBirthMonth();

		String day = loginDTO.getBirthDay();

		String birthDate ="";

		if (month.length() == 1)
			month = "0" + month;
		if (day.length() == 1)
			day = "0" + day;

		if (!"0".equals(year) && !"00".equals(month) && !"00".equals(day)) {
			birthDate = year + "-" + month + "-" + day;
			if (AppDate.isValidDate(birthDate, AppDate.strFormatoFechaYYYY_MM_DD)) {
				loginDTO.setFechaNacimientoMember(birthDate);
				//loginDTO.generoMember - loginDTO.firmaMember - loginDTO.usernamePerfil - loginDTO.nombrePerfilLowerCase - loginDTO.passwordContrasenha - loginDTO.passwordConfirmacionContrasenha - loginDTO.passwordPregunta - loginDTO.respuestaPregunta
				if(loginDTO.getRutMember()!=null && !loginDTO.getRutMember().equals("") &&loginDTO.getTipoDocumento()!=null && !loginDTO.getTipoDocumento().equals("")){
//					if(seguridadModelo.validarExistenciaRut(loginDTO.getRutMember(), loginDTO.getTipoDocumento(), tokenAuthenticacionContextSeguridad)){
						if(loginDTO.getNombreMember()!=null && !loginDTO.getNombreMember().equals("")){
							if(loginDTO.getApellidoPaternoMember()!=null && !loginDTO.getApellidoPaternoMember().equals("")){
								if(loginDTO.getFechaNacimientoMember()!=null && !loginDTO.getFechaNacimientoMember().equals("")){
									if(loginDTO.getTelefonoContactoMember()!=null && !loginDTO.getTelefonoContactoMember().equals("")){
										if(loginDTO.getMailMember()!=null && ValidacionPatrones.validarPatronEmail(loginDTO.getMailMember())){
//											if(seguridadModelo.validarExistenciaCorreoElectronico(loginDTO.getMailMember(), tokenAuthenticacionContextSeguridad)){
												if(loginDTO.getGeneroMember()!=null && !loginDTO.getGeneroMember().equals("")){
													if(loginDTO.getFirmaMember()!=null && !loginDTO.getFirmaMember().equals("")){
														if(loginDTO.getUsernamePerfil()!=null && !loginDTO.getUsernamePerfil().equals("")){
//															if(seguridadModelo.validarExistenciaUsernameLogin(loginDTO.getUsernamePerfil(), tokenAuthenticacionContextSeguridad)){
																if(loginDTO.getNombrePerfilLowerCase()!=null && !loginDTO.getNombrePerfilLowerCase().equals("")){
//																	if(seguridadModelo.validarExistenciaNombrePerfil(loginDTO.getNombrePerfilLowerCase(), tokenAuthenticacionContextSeguridad)){
																		if(loginDTO.getPasswordContrasenha()!=null && !loginDTO.getPasswordContrasenha().equals("")){
																			if(loginDTO.getPasswordConfirmacionContrasenha()!=null && !loginDTO.getPasswordConfirmacionContrasenha().equals("")){
																				if(loginDTO.getPasswordConfirmacionContrasenha().equals(loginDTO.getPasswordContrasenha())){
																					if(loginDTO.getPasswordPregunta()!=null && !loginDTO.getPasswordPregunta().equals("")){
																						if(loginDTO.getRespuestaPregunta()!=null && !loginDTO.getRespuestaPregunta().equals("")){
																							validar = true;
																						}else{
																							FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso respuesta a pregunta de recuperacion");
																							FacesContext.getCurrentInstance().addMessage(null, msg);
																						}
																					}else{
																						FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso pregunta de recuperacion");
																						FacesContext.getCurrentInstance().addMessage(null, msg);
																					}
																				}else{
																					FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "Contraseña de Verificacion es Distinta");
																					FacesContext.getCurrentInstance().addMessage(null, msg);
																				}
																			}else{
																				FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso confirmacion password");
																				FacesContext.getCurrentInstance().addMessage(null, msg);
																			}
																		}else{
																			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso password");
																			FacesContext.getCurrentInstance().addMessage(null, msg);
																		}
																	}else{
																		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "el nombre de perfil ya habia sido ingresado");
																		FacesContext.getCurrentInstance().addMessage(null, msg);
																	}
//																}else{
//																	FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso nombre del perfil");
//																	FacesContext.getCurrentInstance().addMessage(null, msg);
//																}
															}else{
																FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "username de login ya habia sido registrado");
																FacesContext.getCurrentInstance().addMessage(null, msg);
															}
														}else{
															FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso username");
															FacesContext.getCurrentInstance().addMessage(null, msg);
														}
													}else{
														FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso una descripcion de la persona");
														FacesContext.getCurrentInstance().addMessage(null, msg);
													}
//												}else{
//													FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se selecciono el genero de la persona");
//													FacesContext.getCurrentInstance().addMessage(null, msg);
//												}
											}else{
												FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "el Email ya habia sido registrado");
												FacesContext.getCurrentInstance().addMessage(null, msg);
											}
										}else{
											FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso el email de la persona");
											FacesContext.getCurrentInstance().addMessage(null, msg);
										}
									}else{
										FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso el telefono de la persona");
										FacesContext.getCurrentInstance().addMessage(null, msg);
									}
								}else{
									FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso apellido materno de la persona");
									FacesContext.getCurrentInstance().addMessage(null, msg);
								}
							}else{
								FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso apellido paterno de la persona");
								FacesContext.getCurrentInstance().addMessage(null, msg);
							}	
//						}else{
//							FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso nombre de la persona");
//							FacesContext.getCurrentInstance().addMessage(null, msg);
//						}
					}else{
						FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "El Rut ya habia sido ingresado anteriormente");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}

//				}else{
//					FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "No se ingreso rut del usuario");
//					FacesContext.getCurrentInstance().addMessage(null, msg);
//				}
			}else{
				FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "Fecha de Nacimiento invalida");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}else{
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "Fecha de Nacimiento invalida");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return validar;
	}

}