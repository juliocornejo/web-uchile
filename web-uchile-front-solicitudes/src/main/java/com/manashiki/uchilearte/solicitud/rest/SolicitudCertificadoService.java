package com.manashiki.uchilearte.solicitud.rest;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

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
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudCertificadoDTO;
import com.manashiki.uchilearte.solicitud.response.WrapperFrontResponse;

import vijnana.respuesta.wrapper.response.AbstractWrapperError;
import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.JsonMappeo;
import web.uchile.articular.session.impl.SolicitudCertificadoImpl;
import web.uchile.articular.session.model.ResponseWebUchile;
import web.uchile.articular.session.model.SolicitudCertificadoModel;


@Path("/SolicitudCertificadoService")
public class SolicitudCertificadoService {
	
	private static final Logger logger = Logger.getLogger(SolicitudCertificadoService.class);
	
	
	@Context
	private HttpServletRequest request;
	
	@POST
    @Path("/almacenarSolicitudCertificadoPagoOffline")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public String obtenerListadoCertificados(
    									@FormParam("requestJson") String jsonParametrosBusquedaRequest,
    									@FormParam("requestFicha") String jsonFicha,
    									@Context HttpServletResponse servletResponse) throws IOException {
		Instant start = Instant.now();
		
		AbstractWrapperError error = null;
		
		WrapperFrontResponse wrapper = new WrapperFrontResponse();
		
		logger.info("almacenarSolicitudCertificadoPagoOffline");
		
		ResponseWebUchile data = null;
		
		String jsonResultado = "";
		
		logger.info(jsonFicha);

		try {
			
			SolicitudCertificadoModel solicitudCertificadoModel = new SolicitudCertificadoModel();
			
			SolicitudCertificadoImpl solicitudCertificadoImpl = new SolicitudCertificadoImpl(request.getRemoteAddr(), request.getRemoteHost(), jsonFicha);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			solicitudCertificadoImpl.inicializarFormulario();
			
			if(solicitudCertificadoImpl.getGenerarAplicacion().getAuthenticacionContext()!=null){
				solicitudCertificadoModel = objectMapper.readValue(jsonParametrosBusquedaRequest, SolicitudCertificadoModel.class);

				solicitudCertificadoImpl.setSolicitudCertificadoDTO(new SolicitudCertificadoDTO());
				
				solicitudCertificadoImpl.setProgramaUniversidadDTO(solicitudCertificadoModel.getPrograma());
				solicitudCertificadoImpl.setFinalidadCertificado(solicitudCertificadoModel.getFinalidadCertificado());
				
				solicitudCertificadoImpl.getSolicitudCertificadoDTO().setAnhoIngreso(solicitudCertificadoModel.getAnhoIngreso());
				solicitudCertificadoImpl.getSolicitudCertificadoDTO().setRutPersonaSolicitudCertificado(solicitudCertificadoModel.getRutPersonaSolicitudCertificado());
				solicitudCertificadoImpl.getSolicitudCertificadoDTO().setNombrePersonaSolicitudCertificado(solicitudCertificadoModel.getNombrePersonaSolicitudCertificado());
				solicitudCertificadoImpl.getSolicitudCertificadoDTO().setApellidoMaternoPersonaSolicitudCertificado(solicitudCertificadoModel.getApellidoMaternoPersonaSolicitudCertificado());
				solicitudCertificadoImpl.getSolicitudCertificadoDTO().setApellidoPaternoPersonaSolicitudCertificado(solicitudCertificadoModel.getApellidoPaternoPersonaSolicitudCertificado());
				solicitudCertificadoImpl.getSolicitudCertificadoDTO().setMailMember(solicitudCertificadoModel.getMailMember());
				
				solicitudCertificadoImpl.getSolicitudCertificadoDTO().setDescripcionEstadoSolicitud("enviado");
				solicitudCertificadoImpl.getSolicitudCertificadoDTO().setEstadoSolicitud(0);
				solicitudCertificadoImpl.getSolicitudCertificadoDTO().setFechaSolicitud(new Date());

				if(solicitudCertificadoImpl.getFinalidadCertificado() != null && solicitudCertificadoImpl.getProgramaUniversidadDTO() != null && solicitudCertificadoModel.getTipoCertificado() !=null){
					solicitudCertificadoImpl.getSolicitudCertificadoDTO().setFinalidadCertificado(solicitudCertificadoImpl.getFinalidadCertificado().getNombreFinalidadCertificado());	
					solicitudCertificadoImpl.getSolicitudCertificadoDTO().setIdFinalidadCertificado(solicitudCertificadoImpl.getFinalidadCertificado().getIdFinalidadCertificado());
					
					solicitudCertificadoImpl.getSolicitudCertificadoDTO().setIdProgramaUniversidad(solicitudCertificadoImpl.getProgramaUniversidadDTO().getIdProgramaUniversidad());
					solicitudCertificadoImpl.getSolicitudCertificadoDTO().setProgramaUniversidad(solicitudCertificadoImpl.getProgramaUniversidadDTO().getNombreProgramaUniversidad());
					solicitudCertificadoImpl.setSelecPrograma(solicitudCertificadoImpl.getProgramaUniversidadDTO().getIdProgramaUniversidad());
					
					solicitudCertificadoImpl.getSolicitudCertificadoDTO().setIdTipoCertificado(solicitudCertificadoModel.getTipoCertificado().getIdTipoCertificado());
					solicitudCertificadoImpl.getSolicitudCertificadoDTO().setTipoCertificado(solicitudCertificadoModel.getTipoCertificado().getNombreTipoCertificado());
				}
				
				/*hay que validar antes de enivar la información*/
				try{
					data = solicitudCertificadoImpl.almacenarSolicitudCertificadoPagoOffline();
					
				}catch(Exception e){

					error = new AbstractWrapperError();

					error.setMensaje("Exception en la obtencion de los datos del negocio"+ e.getMessage());

					error.setCodigo(400);
				}
			}

		} catch (Exception e) {
			error = new AbstractWrapperError();

			error.setMensaje("Exception en la obtencion de los datos del servicio"+e.getMessage());

			error.setCodigo(400);
		}		
		
		if(error==null){
			wrapper = new WrapperFrontResponse(null, AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())), this.request.getRequestURL().toString(),
					this.request.getMethod(),data);
		}
		else{
			wrapper = new WrapperFrontResponse(error, AppDate.generarTiempoDuracion(Duration.between(start, Instant.now())), this.request.getRequestURL().toString(), 
					this.request.getMethod(), data);
		}
		
		jsonResultado = JsonMappeo.convertirObjectToJson(wrapper);
		
        return jsonResultado;
        
	}
	
}
