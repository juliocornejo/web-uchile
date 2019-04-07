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

import vijnana.respuesta.front.response.WrapperFrontResponse;
import vijnana.respuesta.wrapper.response.AbstractWrapperError;
import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.JsonMappeo;
import web.uchile.articular.session.impl.SolicitudCertificadoImpl;
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
		
		logger.info("Login de Usuario");
		
		logger.info(jsonFicha);
		
		String data = null;
		
		String redireccion = null;
		
		String jsonResultado = "";
		
		boolean ok = false;
		
		logger.info("Inicio validación de Certificados.");
		logger.info(jsonFicha);
//		Gson g = new Gson();
		
//		WrapperFrontResponse data = new WrapperFrontResponse();
//		String jsonResultado = "";
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
					if(solicitudCertificadoImpl.almacenarSolicitudCertificadoPagoOffline()){
//					data.setOk(true);
//					data.setData("Fue envianda la solicitd de certificado");
//					data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-certificado-exito.jsp");
					data = JsonMappeo.convertirObjectToJson("");
					
					redireccion = "web-uchile-front-solicitudes/main/view/solicitud-certificado-exito.jsp";
					
					ok = true;
						
//					jsonResultado = JsonMappeo.convertirObjectToJson(data);
					}else{
						ok = false;
					}
					
				}catch(Exception e){
//					logger.error("Exception No fue posible enviar la solicitud del certificado. "+e.getMessage(), e);
//					AbstractWrapperError error = new AbstractWrapperError();
//					error.setCodigo(400);
//					error.setMensaje("Exception en el seteo de los datos para la solicitud de certificado");
//					data.setError(error);
//					data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-certificado-error.jsp");
//					jsonResultado = JsonMappeo.convertirObjectToJson(data);
//					return jsonResultado;	
					error = new AbstractWrapperError();

					error.setMensaje("Exception en la obtencion de los datos del negocio"+ e.getMessage());

					error.setCodigo(400);
				}
			}else{
				ok = false;
//				logger.error("Exception No fue posible enviar la solicitud del certificado. sin autenticacion");
//				AbstractWrapperError error = new AbstractWrapperError();
//				error.setCodigo(400);
//				error.setMensaje("Exception en el seteo de los datos para la solicitud de certificado. sin autenticacion");
//				data.setError(error);
//				data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-certificado-error.jsp");
//				jsonResultado = JsonMappeo.convertirObjectToJson(data);
//				return jsonResultado;
			}
			


		} catch (Exception e) {
//			logger.error("Exception en el seteo de los datos para la solicitud de certificado: "+e.getMessage(), e);
//			AbstractWrapperError error = new AbstractWrapperError();
//			error.setCodigo(400);
//			error.setMensaje("Exception en el seteo de los datos para la solicitud de certificado");
//			data.setError(error);
//			data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-certificado-error.jsp");
//			
//			jsonResultado = JsonMappeo.convertirObjectToJson(data);
//			return jsonResultado;
			error = new AbstractWrapperError();

			error.setMensaje("Exception en la obtencion de los datos del servicio"+e.getMessage());

			error.setCodigo(400);
		}		
		
//		logger.info("################################## Siguiente Paso Almacenar dato ###################################################");
//		
//        return jsonResultado;
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
	

	@POST
    @Path("/levantarFicha")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public String levantarFichaHotel(
    									@FormParam("requestJson") String jsonParametrosRequest,
    									@FormParam("hotelJson") String jsonHotelRequest,
    									@Context HttpServletResponse servletResponse) {
		logger.info("Levantando Ficha.");
		logger.info(jsonParametrosRequest);
		
		try {
			logger.info("LLamar persistir paso 2: ");
			
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);

		}
		
		logger.info("Fin Levantando Ficha");
		
        return "";
    }
	
	@POST
    @Path("/obtenerDetalleHotel")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public String obtenerDetalleHotel(
    									@FormParam("requestJson") String jsonParametrosRequest,
    									@FormParam("hotelJson") String jsonHotelRequest,
    									@Context HttpServletResponse servletResponse) {
		logger.info("Levantando Ficha.");
		logger.info(jsonParametrosRequest);
		
		try {
	
			
	
				
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			
		}
		
		logger.info("Fin Levantando Ficha");
		
        return "";
    }
	
}
