package com.manashiki.uchilearte.solicitud.rest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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

import com.google.gson.Gson;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ArchivoSolicitudDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudAcademicaDTO;

import vijnana.respuesta.front.response.WrapperFrontResponse;
import vijnana.respuesta.wrapper.response.AbstractWrapperError;
import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.JsonMappeo;
import web.uchile.articular.session.impl.SolicitudAcademicaImpl;
import web.uchile.articular.session.model.SolicitudAcademicaModel;



@Path("/SolicitudAcademicaService")
public class SolicitudAcademicaService {
	
	private static final Logger logger = Logger.getLogger(SolicitudPostulacionService.class);
	Gson g = new Gson();	
	
	@Context
	private HttpServletRequest request;
	
	@POST
    @Path("/almacenarSolicitudAcademicaPagoOffline")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    public String almacenarSolicitudAcademicaPagoOffline(
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
		
		logger.info("Inicio validación de solicitud academica.");
//		logger.info(jsonFicha);
		
//		String jsonFicha = null;
//		WrapperFrontResponse data = new WrapperFrontResponse();
//		String jsonResultado = "";
		
		try {
			SolicitudAcademicaModel solicitudAcademicaModel = new SolicitudAcademicaModel();
			SolicitudAcademicaImpl solicitudAcademicaImpl = new SolicitudAcademicaImpl(request.getRemoteAddr(), request.getRemoteHost(), jsonFicha);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			solicitudAcademicaImpl.inicializarFormulario();
			
			if(solicitudAcademicaImpl.getGenerarAplicacion().getAuthenticacionContext()!=null){
				solicitudAcademicaModel = objectMapper.readValue(jsonParametrosBusquedaRequest, SolicitudAcademicaModel.class);
				System.out.println("data :: " + g.toJson(solicitudAcademicaModel));

				solicitudAcademicaImpl.setSolicitudAcademicaDTO(new SolicitudAcademicaDTO());
				
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setNombrePersonaSolicitudAcademica(solicitudAcademicaModel.getNombrePersonaSolicitudAcademica());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setApellidoPaternoPersonaSolicitudAcademica(solicitudAcademicaModel.getApellidoPaternoPersonaSolicitudAcademica());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setApellidoMaternoPersonaSolicitudAcademica(solicitudAcademicaModel.getApellidoMaternoPersonaSolicitudAcademica());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setRutPersonaSolicitudAcademica(solicitudAcademicaModel.getRutPersonaSolicitudAcademica());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setIdProgramaUniversidad(solicitudAcademicaModel.getIdProgramaUniversidad());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setProgramaUniversidad(solicitudAcademicaModel.getProgramaUniversidad());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setMailMember(solicitudAcademicaModel.getMailMember());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setAnhoIngreso(solicitudAcademicaModel.getAnhoIngreso());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setIdTipoSolicitud(solicitudAcademicaModel.getIdTipoSolicitud());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setTipoSolicitud(solicitudAcademicaModel.getTipoSolicitud());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setFundamentacionSolicitud(solicitudAcademicaModel.getFundamentacionSolicitud());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setArchivoAdjunto(solicitudAcademicaModel.isArchivoAdjunto());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setNombreArchivo(solicitudAcademicaModel.getNombreArchivo());
				solicitudAcademicaImpl.getSolicitudAcademicaDTO().setIdArchivoSolicitud(solicitudAcademicaModel.getIdArchivoSolicitud());
		
				solicitudAcademicaImpl.setArchivoSolicitudDTO(solicitudAcademicaModel.getArchivo());
				
				solicitudAcademicaImpl.setProgramaUniversidadDTO(solicitudAcademicaModel.getProgramaUniversidadDTO());
				
				if(solicitudAcademicaImpl.getProgramaUniversidadDTO() != null && solicitudAcademicaImpl.getTipoSolicitudDTO() != null){
					solicitudAcademicaImpl.getSolicitudAcademicaDTO().setIdProgramaUniversidad(solicitudAcademicaImpl.getProgramaUniversidadDTO().getIdProgramaUniversidad());
					solicitudAcademicaImpl.getSolicitudAcademicaDTO().setProgramaUniversidad(solicitudAcademicaImpl.getProgramaUniversidadDTO().getNombreProgramaUniversidad());
//					solicitudAcademicaImpl.setSelecPrograma(solicitudAcademicaImpl.getProgramaUniversidadDTO().getIdProgramaUniversidad());
					
					solicitudAcademicaImpl.setTipoSolicitudDTO(solicitudAcademicaModel.getTipoSolicitudDTO());
					
					solicitudAcademicaImpl.getTipoSolicitudDTO().setIdTipoSolicitud(solicitudAcademicaImpl.getTipoSolicitudDTO().getIdTipoSolicitud());
					solicitudAcademicaImpl.getTipoSolicitudDTO().setNombreTipoSolicitud(solicitudAcademicaImpl.getTipoSolicitudDTO().getNombreTipoSolicitud());
					
					try{
						if(solicitudAcademicaImpl.almacenarSolicitudAcademicaPagoOffline()){
							data = JsonMappeo.convertirObjectToJson("");
							redireccion = "web-uchile-front-solicitudes/main/view/solicitud-certificado-exito.jsp";
							ok = true;
//							data.setOk(true);
//							data.setData("Fue envianda la solicitd de certificado");
//							data.setUrl("");
//							jsonResultado = JsonMappeo.convertirObjectToJson(data);
						}else{
							ok = false;
						}
						
					}catch(Exception e){
//						logger.error("Exception No fue posible enviar la solicitud del certificado. "+e.getMessage(), e);
//						AbstractWrapperError error = new AbstractWrapperError();
//						error.setCodigo(400);
//						error.setMensaje("Exception en el seteo de los datos para la solicitud de certificado");
//						data.setError(error);
//						data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-certificado-error.jsp");
//						jsonResultado = JsonMappeo.convertirObjectToJson(data);
//						return jsonResultado;	
						error = new AbstractWrapperError();

						error.setMensaje("Exception en la obtencion de los datos del negocio"+ e.getMessage());

						error.setCodigo(400);
					}
				
				}
								
				
				
			}else{
				ok = false;
//				logger.error("Error en el metodo almacenarSolicitudAcademicaPagoOffline");
//				AbstractWrapperError error = new AbstractWrapperError();
//				error.setCodigo(400);
//				error.setMensaje("Exception en el seteo de los datos para la solicitud de academica");
//				data.setError(error);
//				data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-academia-error.jsp");
//				jsonResultado = JsonMappeo.convertirObjectToJson(data);
				
			}
			/*hay que validar antes de enivar la información*/
//			
//			data.setEstado("EXITO");
//			data.setMensaje("Fue envianda la solicitd de certificado");
//			data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-academica-exito.jsp");
//			jsonResultado = JsonMappeo.convertirObjectToJson(data);	

		} catch (Exception e) {
//			logger.error("Exception en el seteo de los datos para la solicitud de certificado: "+e.getMessage(), e);
//			AbstractWrapperError error = new AbstractWrapperError();
//			error.setCodigo(400);
//			error.setMensaje("Exception en el seteo de los datos para la solicitud de certificado");
//			data.setError(error);
//			data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-academia-error.jsp");
//			jsonResultado = JsonMappeo.convertirObjectToJson(data);
//			return jsonResultado;
			error = new AbstractWrapperError();

			error.setMensaje("Exception en la obtencion de los datos del servicio"+e.getMessage());

			error.setCodigo(400);
		}		
		
		logger.info("################################## Siguiente Paso Almacenar dato ###################################################");
//		try{
//			boolean valido = solicitudAcademicaImpl.validarLlenadoFormulario(solicitudAcademicaImpl.getSolicitudAcademicaDTO());
//			if(valido){
//				boolean guardado = ;
//				if(guardado){
//					
//					data.setOk(true); //("EXITO");
//					data.setData("Fue envianda la solicitd de academica");
//					data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-academica-exito.jsp");
//					jsonResultado = JsonMappeo.convertirObjectToJson(data);		
//				}else{
//					logger.error("Error en el metodo almacenarSolicitudAcademicaPagoOffline");
//					Error error = new Error();
//					error.setCodigo(400);
//					error.setMensaje("Exception en el seteo de los datos para la solicitud de academica");
//					data.setError(error);
//					data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-academia-error.jsp");
//					jsonResultado = JsonMappeo.convertirObjectToJson(data);
//				}
//			}else{
//				logger.error("Error en el metodo almacenarSolicitudAcademicaPagoOffline");
////				data.setEstado("ERROR");
////				data.setMensaje("Exception en el seteo de los datos para la solicitud de academica");
//				Error error = new Error();
//				error.setCodigo(400);
//				error.setMensaje("Exception en el seteo de los datos para la solicitud de academica");
//				data.setError(error);
//				data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-academia-error.jsp");
//				jsonResultado = JsonMappeo.convertirObjectToJson(data);
//			}
//		}catch(Exception e){
//			logger.error("Exception No fue posible enviar la solicitud del academica. "+e.getMessage(), e);
////			data.setEstado("ERROR");
////			data.setMensaje("Exception en el seteo de los datos para la solicitud de academica");
//			Error error = new Error();
//			error.setCodigo(400);
//			error.setMensaje("Exception en el seteo de los datos para la solicitud de academica");
//			data.setError(error);
//			data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-academia-error.jsp");
//			jsonResultado = JsonMappeo.convertirObjectToJson(data);
//			return jsonResultado;			
//		}
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
    @Path("/subirArchivo")
    @Produces(MediaType.APPLICATION_JSON)
    public String subirArchivo(
    			@Context HttpServletRequest httpServletRequest, @Context HttpServletResponse servletResponse) {

		String archivo = "{'archivo':'No tiene Archivo'}";
		SolicitudAcademicaImpl solicitudAcademicaImpl = new SolicitudAcademicaImpl(request.getRemoteAddr(), request.getRemoteHost(), null);
		WrapperFrontResponse res = new WrapperFrontResponse();
//		WrapperFrontResponse data = new WrapperFrontResponse();
//		String jsonResultado = "";
		
		try {
				logger.info("iniciando la subida de archivo en la pagina de postulaciones.");
//				solicitudAcademicaImpl.inicializarSolicitudAcademicaImpl(httpServletRequest.getRemoteHost())
				solicitudAcademicaImpl.inicializarFormulario();
				String nombreArchivoFinal = ""; 
			    String primerosdatos = "";
			    String segundodatos = "";
			    
			    InputStream inStream = httpServletRequest.getInputStream(); 
			    InputStreamReader reader = new InputStreamReader(inStream);
			    BufferedReader bReader = new BufferedReader(reader);

			    
			    
			    
			    StringBuffer sb = new StringBuffer();
			    String inputLine;
			    int contador = 0;
			    while ((inputLine = bReader.readLine()) != null) {
			    	 	if(contador == 1){
			    	 		primerosdatos = inputLine;
			    	 	}
			    	 	if(contador == 2){
			    	 		segundodatos = inputLine;
			    	 	}
			    	 	sb.append(inputLine).append('\n');
			    	 	contador++;
				    	
			        sb.append(inputLine);
			        sb.append("\n");
			    }

			    String[] arrayDatos = null;
			   try { 
				    if(primerosdatos != null && segundodatos != null){
				    	 StringBuilder cadena = new  StringBuilder(primerosdatos);
				    	 cadena.append(";");
				    	 cadena.append(segundodatos);
				    	 cadena.append(";");
				    	 arrayDatos = cadena.toString().split(";");
				    	 if(arrayDatos != null && arrayDatos.length > 0){
				    		 logger.info(arrayDatos[2]);
				    		 String[] arrayNombreArchivo= arrayDatos[2].split("=");
				    		 if(arrayNombreArchivo != null && arrayNombreArchivo.length > 0){
				    			 nombreArchivoFinal = arrayNombreArchivo[1].replaceAll("\"","");
				    		 }
				    	 }
				     }
				    
					 try{

						   InputStream readerNew = httpServletRequest.getInputStream(); 
						   File f = new File(nombreArchivoFinal);		//Aqui le dan el nombre y/o con la ruta del archivo salida
						   OutputStream salida=new FileOutputStream(f);
						   byte[] buf =new byte[1024];					//Actualizado me olvide del 1024
						   int len;
						   while((len=readerNew.read())>0){
						      salida.write(buf,0,len);
						   }
						   
						   InputStream is = null;
						   byte[] contenido = null;
						       try {
							           is = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
							           contenido = sb.toString().getBytes("UTF-8");
							           logger.info("se ha transformado a un archivo .-.!!"+ contenido );
						       } catch (UnsupportedEncodingException e) {
						            e.printStackTrace();
						       }
						       solicitudAcademicaImpl.handleFileUpload(is, f, contenido);
							 
						   salida.close();
						   readerNew.close();
					  }catch(IOException e){
						  logger.error("Se produjo el error : "+e.toString());
					  }
			    } finally { 
			     reader.close(); 
			    } 
			  
			   ArchivoSolicitudDTO archivoGuardado = (solicitudAcademicaImpl.getArchivoSolicitudDTO()!= null) ? solicitudAcademicaImpl.getArchivoSolicitudDTO(): null; 
			   if(archivoGuardado != null){
				   archivo = g.toJson(archivoGuardado);
				   res.setCantidadResultados(1);
				   res.setTiempoRespuesta(archivo);
				   res.setOk(true);
				   res.setTipoMetodo("subir_archivo");
				   return g.toJson(res);

			   }

			   logger.info("archivo subido y el objeto esta trasnformado de json.");
				
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage(), e);
			e.printStackTrace();
			logger.info("Pintando pagina de Postulaciones del alumno, error al subir el archivo adjunto.");
			archivo = "{'archivo':'No tiene Archivo'}";
		}
		logger.info("se sube archivo con exito");
		
        return archivo;
    }
	
}
