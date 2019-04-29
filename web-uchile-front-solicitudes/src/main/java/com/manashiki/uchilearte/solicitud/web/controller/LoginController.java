package com.manashiki.uchilearte.solicitud.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;

import web.uchile.articular.session.impl.LoginImpl;
import web.uchile.articular.session.impl.SolicitudCertificadoImpl;


/**
 * Servlet implementation class SolicitudCertificadoController
 */
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginController.class);
	Gson g = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("Inicializando Login Controller.");
		try {
			LoginImpl loginImpl = new LoginImpl(request.getRemoteAddr(), request.getRemoteHost(), null);
			loginImpl.inicializarFormulario();
			
			if(loginImpl.getGenerarAplicacion().getAuthenticacionContext()!=null){
				String login = g.toJson(loginImpl.getLoginDTO());
				
				request.setAttribute("login", login);
				request.setAttribute("ficha", "{'ficha':'"+loginImpl.getGenerarAplicacion().getToken()+"'}");
				request.setAttribute("Error", "{'mensajeError':''}");
				request.getRequestDispatcher("/main/login/view/login.jsp").forward(request, response);
				logger.info("Pintando Login Controller");
				
			}else{
				request.setAttribute("Error", "{'mensajeError':'Aplicacion Invalida'}");
				request.getRequestDispatcher("/administracion/error/login-error.jsp").forward(request, response);
				logger.info("Pintando Error Login Controller. Aplicacion Invalida");
			}
		} 
		catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			request.setAttribute("login", "{}");
			request.setAttribute("ficha", "{}");
			request.setAttribute("Error", "{'mensajeError':'Error de los servicios interno'}");
			request.getRequestDispatcher("/login/error/login-error.jsp").forward(request, response);
			logger.info("Pintando Error Login Controller. Error de los servicios interno");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
	
	}
}
