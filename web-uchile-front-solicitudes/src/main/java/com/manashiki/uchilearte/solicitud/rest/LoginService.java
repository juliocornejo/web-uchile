package com.manashiki.uchilearte.solicitud.rest;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.manashiki.uchilearte.solicitud.response.WrapperFrontResponse;

import vijnana.respuesta.wrapper.response.AbstractWrapperError;
import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.JsonMappeo;
import web.uchile.articular.session.direccionamiento.Navigation;
import web.uchile.articular.session.impl.LoginImpl;
import web.uchile.articular.session.model.LoginModel;
import web.uchile.articular.session.model.ResponseWebUchile;


@Path("/LoginService")
public class LoginService {
	
	private static final Logger logger = Logger.getLogger(LoginService.class);
	
	
	@Context
	private HttpServletRequest request;
	
	
	@POST
    @Path("/loginUsuario")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public String loginUsuario(
    									@FormParam("requestJson") String jsonParametrosBusquedaRequest,
    									@FormParam("requestFicha") String jsonFicha,
    									@Context HttpServletResponse servletResponse) throws IOException {
		Instant start = Instant.now();
		
		AbstractWrapperError error = null;
		
		WrapperFrontResponse wrapper = new WrapperFrontResponse();
		
		logger.info("Login de Usuario "+jsonFicha);
		
		ResponseWebUchile data = null;
		
		String jsonResultado = "";
		
		try {
			
			LoginModel loginModel = new LoginModel();
			LoginImpl loginImpl = new LoginImpl(request.getRemoteAddr(), request.getRemoteHost(), jsonFicha);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			loginImpl.inicializarFormulario();
			
			loginModel = objectMapper.readValue(jsonParametrosBusquedaRequest, LoginModel.class);
			
			if(loginImpl.getGenerarAplicacion().getAuthenticacionContext()!=null && loginModel.getUsernamePerfil()!=null && !"".equals(loginModel.getUsernamePerfil()) && 
					loginModel.getPasswordContrasenha()!=null && !"".equals(loginModel.getPasswordContrasenha())){
					/*hay que validar antes de enivar la información*/
					try{
						
						data = loginImpl.obtenerUsuarioLoginAdministrador(loginModel.getUsernamePerfil(), loginModel.getPasswordContrasenha());
						
						if(data!=null){
							
							HttpSession misession= request.getSession(true);
							
							misession.setAttribute("keyAplicacionUchile", jsonFicha);
							
							misession.setAttribute("keySessionUsuario",loginImpl.getToken());
							
						}
					}catch(Exception e){
						error = new AbstractWrapperError();

						error.setMensaje("Exception en la obtencion de los datos del negocio"+ e.getMessage());

						error.setCodigo(1);
					}
				}
		} catch (Exception e) {
			error = new AbstractWrapperError();

			error.setMensaje("Exception en la obtencion de los datos del servicio"+ e.getMessage());

			error.setCodigo(1);
		}
		
		if(error==null){
			wrapper = new WrapperFrontResponse(null, AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())),  this.request.getRequestURL().toString(),
					this.request.getMethod(), data);
		}
		else{
			wrapper = new WrapperFrontResponse(error, AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())),  this.request.getRequestURL().toString(), 
					this.request.getMethod(), data);
		}
		
		jsonResultado = JsonMappeo.convertirObjectToJson(wrapper);
		
        return jsonResultado;
	}
	
	
	@POST
    @Path("/redireccionAdministracion")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public String obtenerUsuarioLogin(
    									@FormParam("requestFicha") String jsonFicha,
    									@Context HttpServletResponse servletResponse) throws IOException {
		Instant start = Instant.now();
		
		AbstractWrapperError error = null;
		
		WrapperFrontResponse wrapper = new WrapperFrontResponse();
		
		logger.info("Login de Usuario"+jsonFicha);
	
		ResponseWebUchile data = null;
		
		String jsonResultado = "";
		
		try {
				Navigation navigation = new Navigation();
//				navigation.redirectExterno(linkExterno);
			
		} catch (Exception e) {
			error = new AbstractWrapperError();

			error.setMensaje("Exception en la obtencion de los datos del servicio"+ e.getMessage());

			error.setCodigo(1);
		}
		
		if(error==null){
			wrapper = new WrapperFrontResponse(new vijnana.respuesta.wrapper.response.AbstractWrapperError(),  AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())),  this.request.getRequestURL().toString(),
					this.request.getMethod(), data);
		}
		else{
			wrapper = new WrapperFrontResponse(error, AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())),  this.request.getRequestURL().toString(), 
					this.request.getMethod(), data);
		}
		
		jsonResultado = JsonMappeo.convertirObjectToJson(wrapper);
		
        return jsonResultado;
	}
	
	
	
	
}
