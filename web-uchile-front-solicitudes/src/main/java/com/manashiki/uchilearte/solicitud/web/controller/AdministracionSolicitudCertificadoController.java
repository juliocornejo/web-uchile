package com.manashiki.uchilearte.solicitud.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;

import web.uchile.articular.session.impl.AdministracionSolicitudCertificadoImpl;
import web.uchile.articular.session.impl.SolicitudCertificadoImpl;


/**
 * Servlet implementation class SolicitudCertificadoController
 */
public class AdministracionSolicitudCertificadoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdministracionSolicitudCertificadoController.class);
	Gson g = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministracionSolicitudCertificadoController() {
        super();
        
    }
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger.info("Inicializando Solicitud Certificado Controller.");
		try {
			AdministracionSolicitudCertificadoImpl administracionSolicitudCertificadoImpl = new AdministracionSolicitudCertificadoImpl(request.getRemoteAddr(), request.getRemoteHost(), null);
			administracionSolicitudCertificadoImpl.inicializarFormulario();
			
			if(administracionSolicitudCertificadoImpl.getGenerarAplicacion().getAuthenticacionContext()!=null){
				ProgramaUniversidadDTO  primerObjeto = new ProgramaUniversidadDTO(); 
				primerObjeto.setNombreProgramaUniversidad("Seleccionar Programa");
				administracionSolicitudCertificadoImpl.getListaProgramaUniversidad().add(0, primerObjeto);
				String listaPrograma = g.toJson(administracionSolicitudCertificadoImpl.getListaProgramaUniversidad());
				String listaTipoCertificado = g.toJson(administracionSolicitudCertificadoImpl.getListaTipoCertificado());
				String listaFinalidadCertificado = g.toJson(administracionSolicitudCertificadoImpl.getListaFinalidadCertificado());
				String listaSolicitudCertificado = g.toJson(administracionSolicitudCertificadoImpl.getListaSolicitudCertificado());
				
				logger.info(listaPrograma);
					
				request.setAttribute("listaPrograma", listaPrograma);
				request.setAttribute("listaTipoCertificado", listaTipoCertificado);
				request.setAttribute("listaFinalidadCertificado", listaFinalidadCertificado);
				request.setAttribute("listaSolicitudCertificado", listaSolicitudCertificado);
				request.setAttribute("ficha", "{'ficha':'"+administracionSolicitudCertificadoImpl.getGenerarAplicacion().getToken()+"'}");
				request.setAttribute("Error", "{'mensajeError':''}");
				request.getRequestDispatcher("/main/view/login.jsp").forward(request, response);
//				request.getRequestDispatcher("/main/view/administracion-solicitud-certificado.jsp").forward(request, response);
				logger.info("Pintando Solicitud de certificados.");
			}
	
		} 
		catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			request.setAttribute("listaPrograma", "[]");
			request.setAttribute("listaTipoCertificado", "[]");
			request.setAttribute("listaFinalidadCertificado", "[]");
			request.setAttribute("listaSolicitudCertificado", "[]");
			request.setAttribute("Error", "{'mensajeError':'Error de los servicios interno'}");
			request.getRequestDispatcher("/main/view/administracion-solicitud-certificado.jsp").forward(request, response);
			logger.info("Pintando Solicitud de certificados.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
	
	}
}
