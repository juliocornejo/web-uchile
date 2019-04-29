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

		if(loginModel.getPasswordContrasenha()!=null && !"".equals(loginModel.getPasswordContrasenha())){
			if(loginModel.getPasswordConfirmacionContrasenha()!=null && !"".equals(loginModel.getPasswordConfirmacionContrasenha())){
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
				if(loginDTO.getRutMember()!=null && !"".equals(loginDTO.getRutMember()) &&loginDTO.getTipoDocumento()!=null && !"".equals(loginDTO.getTipoDocumento())){
						if(loginDTO.getNombreMember()!=null && !"".equals(loginDTO.getNombreMember())){
							if(loginDTO.getApellidoPaternoMember()!=null && !"".equals(loginDTO.getApellidoPaternoMember())){
								if(loginDTO.getFechaNacimientoMember()!=null && !"".equals(loginDTO.getFechaNacimientoMember())){
									if(loginDTO.getTelefonoContactoMember()!=null && !"".equals(loginDTO.getTelefonoContactoMember())){
										if(loginDTO.getMailMember()!=null && ValidacionPatrones.validarPatronEmail(loginDTO.getMailMember())){
												if(loginDTO.getGeneroMember()!=null && !"".equals(loginDTO.getGeneroMember())){
													if(loginDTO.getFirmaMember()!=null && !"".equals(loginDTO.getFirmaMember())){
														if(loginDTO.getUsernamePerfil()!=null && !"".equals(loginDTO.getUsernamePerfil())){
																if(loginDTO.getNombrePerfilLowerCase()!=null && !"".equals(loginDTO.getNombrePerfilLowerCase())){
																		if(loginDTO.getPasswordContrasenha()!=null && !"".equals(loginDTO.getPasswordContrasenha())){
																			if(loginDTO.getPasswordConfirmacionContrasenha()!=null && !"".equals(loginDTO.getPasswordConfirmacionContrasenha())){
																				if(loginDTO.getPasswordConfirmacionContrasenha().equals(loginDTO.getPasswordContrasenha())){
																					if(loginDTO.getPasswordPregunta()!=null && !"".equals(loginDTO.getPasswordPregunta())){
																						if(loginDTO.getRespuestaPregunta()!=null && !"".equals(loginDTO.getRespuestaPregunta())){
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
					}else{
						FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "El Rut ya habia sido ingresado anteriormente");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
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