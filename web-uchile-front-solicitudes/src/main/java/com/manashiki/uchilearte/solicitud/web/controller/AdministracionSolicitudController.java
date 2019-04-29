package com.manashiki.uchilearte.solicitud.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import web.uchile.articular.session.impl.AdministracionSolicitudImpl;


/**
 * Servlet implementation class SolicitudCertificadoController
 */
public class AdministracionSolicitudController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdministracionSolicitudController.class);
	Gson g = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministracionSolicitudController() {
        super();
        
    }
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger.info("Inicializando Solicitud Certificado Controller.");
		
		try {
			
			HttpSession misession= (HttpSession) request.getSession();
			String keyAplicacion= (String) misession.getAttribute("keyAplicacionUchile");
			String keySessionUsuario= (String) misession.getAttribute("keySessionUsuario");
			
			if(keyAplicacion!=null && keySessionUsuario!=null){
				
				AdministracionSolicitudImpl administracionSolicitudCertificadoImpl = new AdministracionSolicitudImpl(request.getRemoteAddr(), request.getRemoteHost(), keyAplicacion, keySessionUsuario);
				
				administracionSolicitudCertificadoImpl.inicializarFormulario();
				
				if(administracionSolicitudCertificadoImpl.getGenerarAplicacion().getAuthenticacionContext()!=null &&
						administracionSolicitudCertificadoImpl.getLoginModel() !=null ){
					//evaluar si le corresponse Usuario en modo administracion
					String loginSession = g.toJson(administracionSolicitudCertificadoImpl.getLoginModel());
					
					String listaServicio = g.toJson(administracionSolicitudCertificadoImpl.getListaServicioModel());
					String listaPrograma = g.toJson(administracionSolicitudCertificadoImpl.getListaProgramaUniversidad());
					String listaProgramaPostulacion = g.toJson(administracionSolicitudCertificadoImpl.getListaProgramaUniversidadPostulacion());
					String listaTipoCertificado = g.toJson(administracionSolicitudCertificadoImpl.getListaTipoCertificado());
					String listaTipoSolicitud = g.toJson(administracionSolicitudCertificadoImpl.getListaTipoSolicitud());
					String listaFinalidadCertificado = g.toJson(administracionSolicitudCertificadoImpl.getListaFinalidadCertificado());
					String listaRegion = g.toJson(administracionSolicitudCertificadoImpl.getListaRegion());
					String listaComuna = g.toJson(administracionSolicitudCertificadoImpl.getListaComuna());
					
					request.setAttribute("usuario", "{'usuario':'"+loginSession+"'}");
					request.setAttribute("listaServicio", listaServicio);
					request.setAttribute("listaPrograma", listaPrograma);
					request.setAttribute("listaProgramaPostulacion", listaProgramaPostulacion);
					request.setAttribute("listaTipoCertificado", listaTipoCertificado);
					request.setAttribute("listaTipoSolicitud", listaTipoSolicitud);
					request.setAttribute("listaFinalidadCertificado", listaFinalidadCertificado);
					request.setAttribute("listaRegion", listaRegion);
					request.setAttribute("listaComuna", listaComuna);
					
					request.setAttribute("Error", "{'mensajeError':''}");
					request.getRequestDispatcher("/administracion/administracion.jsp").forward(request, response);
					logger.info("Pintando Administracion de Solicitudes.");
				}else{
					request.setAttribute("Error", "{'mensajeError':'Usuario Invalido'}");
					request.getRequestDispatcher("/administracion/administracion-error.jsp").forward(request, response);
					logger.info("Pintando Error Administracion de Solicitudes. Usuario Invalido");
				}
			}else{
				request.setAttribute("Error", "{'mensajeError':'Session Invalida'}");
				request.getRequestDispatcher("/administracion/administracion-error.jsp").forward(request, response);
				logger.info("Pintando Error Administracion de Solicitudes. Session Invalida");
			}
	
		} 
		catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			request.setAttribute("Error", "{'mensajeError':'Error de los servicios interno'}");
			request.getRequestDispatcher("/administracion/administracion-error.jsp").forward(request, response);
			logger.info("Pintando Error Administracion de Solicitudes. Error de los servicios interno");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
	
	}
}
