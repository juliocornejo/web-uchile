package com.manashiki.uchilearte.solicitud.rest;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

//import com.google.gson.Gson;
import vijnana.respuesta.front.response.WrapperFrontResponse;
import vijnana.respuesta.wrapper.response.AbstractWrapperError;
import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.JsonMappeo;
import web.uchile.articular.session.impl.LoginImpl;
import web.uchile.articular.session.model.LoginModel;


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
		
		logger.info("Login de Usuario");
		
		logger.info(jsonFicha);
		
		String data = null;
		
		String redireccion = null;
		
		String jsonResultado = "";
		
		boolean ok = false;

		try {
			
			LoginModel loginModel = new LoginModel();
			LoginImpl loginImpl = new LoginImpl(request.getRemoteAddr(), request.getRemoteHost(), jsonFicha);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			loginImpl.inicializarFormulario();
			
			loginModel = objectMapper.readValue(jsonParametrosBusquedaRequest, LoginModel.class);
			
			if(loginImpl.getGenerarAplicacion().getAuthenticacionContext()!=null && loginModel.getUsernamePerfil()!=null && !loginModel.getUsernamePerfil().equals("") && 
					loginModel.getPasswordContrasenha()!=null && !loginModel.getPasswordContrasenha().equals("")){
					/*hay que validar antes de enivar la información*/
					try{
						
						loginModel = loginImpl.obtenerUsuarioLogin(loginModel.getUsernamePerfil(), loginModel.getPasswordContrasenha());
						
						if(loginModel!=null){
							data = loginImpl.getToken();
							redireccion = "web-uchile-front-solicitudes/main/view/administracion-solicitudes/administracion.jsp";
							ok = true;
						}else{
							ok = false;
						}
					}catch(Exception e){
						error = new AbstractWrapperError();

						error.setMensaje("Exception en la obtencion de los datos del negocio"+ e.getMessage());

						error.setCodigo(1);
					}
				}else{
					ok = false;
				}
		} catch (Exception e) {
//			logger.error("Exception en el seteo de los datos para la solicitud de certificado: "+e.getMessage(), e);
//			AbstractWrapperError error = new AbstractWrapperError();
//			error.setCodigo(400);
//			error.setMensaje("Exception en el seteo de los datos para la solicitud de certificado");
//			wrapper.setError(error);
//			wrapper.setUrl("web-uchile-front-solicitudes/main/view/login.jsp");
//			jsonResultado = JsonMappeo.convertirObjectToJson(wrapper);
//			return jsonResultado;
			error = new AbstractWrapperError();

			error.setMensaje("Exception en la obtencion de los datos del servicio"+ e.getMessage());

			error.setCodigo(1);
		}
		
		if(error==null){
			wrapper = new WrapperFrontResponse(new vijnana.respuesta.wrapper.response.AbstractWrapperError(), ok, AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())), 0, this.request.getRequestURL().toString(),
					this.request.getMethod(), redireccion, data);
		}
		else{
			wrapper = new WrapperFrontResponse(error, ok, AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())), 0, this.request.getRequestURL().toString(), 
					this.request.getMethod(), redireccion, data);
		}
		
		jsonResultado = JsonMappeo.convertirObjectToJson(wrapper);
		
        return jsonResultado;
	}
	
	
//	@POST
//    @Path("/loginUsuario")
//    @Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//    public String loginUsuario(
//    									@FormParam("requestJson") String jsonParametrosBusquedaRequest,
//    									@FormParam("requestFicha") String jsonFicha,
//    									@Context HttpServletResponse servletResponse) throws IOException {
//		Instant start = Instant.now();
//		
//		AbstractWrapperError error = null;
//		
//		WrapperFrontResponse wrapper = new WrapperFrontResponse();
//		
//		logger.info("Login de Usuario");
//		
//		logger.info(jsonFicha);
//		
//		String data = null;
//		
//		String redireccion = null;
//		
//		String jsonResultado = "";
//		
//		boolean ok = false;
//
//		try {
//			
//			LoginModel loginModel = new LoginModel();
//			LoginImpl loginImpl = new LoginImpl(request.getRemoteAddr(), request.getRemoteHost(), jsonFicha);
//			
//			ObjectMapper objectMapper = new ObjectMapper();
//			
//			loginImpl.inicializarFormulario();
//			
//			loginModel = objectMapper.readValue(jsonParametrosBusquedaRequest, LoginModel.class);
//			
//			if(loginImpl.getGenerarAplicacion().getAuthenticacionContext()!=null && loginModel.getUsernamePerfil()!=null && !loginModel.getUsernamePerfil().equals("") && 
//					loginModel.getPasswordContrasenha()!=null && !loginModel.getPasswordContrasenha().equals("")){
//					/*hay que validar antes de enivar la información*/
//					try{
//						
//						loginModel = loginImpl.obtenerUsuarioLogin(loginModel.getUsernamePerfil(), loginModel.getPasswordContrasenha());
//						
//						if(loginModel!=null){
//							data = loginImpl.getToken();
//							redireccion = "web-uchile-front-solicitudes/main/view/administracion-solicitudes/administracion.jsp";
//							ok = true;
//						}else{
//							ok = false;
//						}
//					}catch(Exception e){
//						error = new AbstractWrapperError();
//
//						error.setMensaje("Exception en la obtencion de los datos del negocio"+ e.getMessage());
//
//						error.setCodigo(1);
//					}
//				}else{
//					ok = false;
//				}
//		} catch (Exception e) {
////			logger.error("Exception en el seteo de los datos para la solicitud de certificado: "+e.getMessage(), e);
////			AbstractWrapperError error = new AbstractWrapperError();
////			error.setCodigo(400);
////			error.setMensaje("Exception en el seteo de los datos para la solicitud de certificado");
////			wrapper.setError(error);
////			wrapper.setUrl("web-uchile-front-solicitudes/main/view/login.jsp");
////			jsonResultado = JsonMappeo.convertirObjectToJson(wrapper);
////			return jsonResultado;
//			error = new AbstractWrapperError();
//
//			error.setMensaje("Exception en la obtencion de los datos del servicio"+ e.getMessage());
//
//			error.setCodigo(1);
//		}
//		
//		if(error==null){
//			wrapper = new WrapperFrontResponse(new vijnana.respuesta.wrapper.response.AbstractWrapperError(), ok, AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())), 0, this.request.getRequestURL().toString(),
//					this.request.getMethod(), redireccion, data);
//		}
//		else{
//			wrapper = new WrapperFrontResponse(error, ok, AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())), 0, this.request.getRequestURL().toString(), 
//					this.request.getMethod(), redireccion, data);
//		}
//		
//		jsonResultado = JsonMappeo.convertirObjectToJson(wrapper);
//		
//        return jsonResultado;
//	}
	
	
	
	
}
