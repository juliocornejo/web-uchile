package com.manashiki.uchilearte.solicitud.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadPostulacionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.RegionDTO;

import web.uchile.articular.session.impl.SolicitudPostulacionImpl;




/**
 * Servlet implementation class PostulacionController
 */
public class SolicitudPostulacionController extends HttpServlet {
	
	private static final long serialVersionUID = 6098745782027999297L;
	private static final Logger logger = Logger.getLogger(SolicitudCertificadoController.class);
	Gson g = new Gson();	
//	SolicitudPostulacionImpl postulacionImpl = new SolicitudPostulacionImpl();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitudPostulacionController() {
        super();
        
    }
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		logger.info("Inicializando Postulaciones Controller.");
		try {
			
			SolicitudPostulacionImpl solicitudPostulacionImpl = new SolicitudPostulacionImpl(request.getRemoteAddr(), request.getRemoteHost(), null);
			solicitudPostulacionImpl.inicializarFormulario();
			
			if(solicitudPostulacionImpl.getGenerarAplicacion().getAuthenticacionContext()!=null){
				ProgramaUniversidadPostulacionDTO postulacion = new ProgramaUniversidadPostulacionDTO();
//				postulacion.setIdProgramaUniversidadPostulacion(0);
				postulacion.setNombreProgramaUniversidadPostulacion("Seleccionar Programa");
				solicitudPostulacionImpl.getListaProgramaUniversidadPostulacionDTO().add(0, postulacion);
				
				RegionDTO region = new RegionDTO();
				region.setIdRegion(0);
				region.setNombreRegion("Seleccione Región");
				solicitudPostulacionImpl.getListaRegionesDTO().add(0, region);
				
				String listaPrograma = g.toJson(solicitudPostulacionImpl.getListaProgramaUniversidadPostulacionDTO());
				String listaRegiones = g.toJson(solicitudPostulacionImpl.getListaRegionesDTO());
				logger.info("Se cargaron las listas");
				
				/*verificacion de archivo*/
				
				try{
					String arhcivoPrueba =  (String) request.getAttribute("Archivo");
					if(arhcivoPrueba != null){
						logger.info("contiene archivo");
					}else{
						logger.info("no contiene archivo, setear archivo vacio");
						request.setAttribute("Archivo", "{'archivo':'No tiene Archivo'}");
					}
					
				}catch (Exception e) {
					logger.info("no contiene archivo, setear archivo vacio");
					request.setAttribute("Archivo", "{'archivo':'No tiene Archivo'}");
				}
				/*fin d ela verificacion*/
				request.setAttribute("listaPrograma", listaPrograma);
				request.setAttribute("listaRegiones", listaRegiones);
				request.setAttribute("ficha", "{'ficha':'"+solicitudPostulacionImpl.getGenerarAplicacion().getToken()+"'}");
				request.setAttribute("Error", "{'mensajeError':''}");
				request.getRequestDispatcher("/main/view/solicitud-postulacion.jsp").forward(request, response);
				logger.info("Pintando Solicitud de Postulaciones");
			}else{
				request.setAttribute("Error", "{'mensajeError':'Usuario Invalido'}");
				request.getRequestDispatcher("/administracion/administracion-error.jsp").forward(request, response);
				logger.info("Pintando Error Solicitud de Postulaciones. Usuario Invalido");
			}
		} 
		catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			request.setAttribute("listaPrograma", "[]");
			request.setAttribute("listaRegiones", "[]");
			request.setAttribute("Archivo", "{'archivo':'No tiene Archivo'}");
			request.setAttribute("Error", "{'mensajeError':'Error de los servicios interno'}");
			request.getRequestDispatcher("/main/view/solicitud-postulacion.jsp").forward(request, response);
			logger.info("Pintando Error Solicitud de Postulaciones. Error de los servicios interno");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	
	}
}
