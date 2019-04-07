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
import java.util.ArrayList;
import java.util.List;

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
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadPostulacionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudPostulacionDTO;

import vijnana.respuesta.front.response.WrapperFrontResponse;
import vijnana.respuesta.wrapper.response.AbstractWrapperError;
import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.JsonMappeo;
import web.uchile.articular.session.impl.SolicitudPostulacionImpl;
import web.uchile.articular.session.model.SolicitudPostulacionModel;


@Path("/SolicitudPostulacionService")
public class SolicitudPostulacionService {
	
	private static final Logger logger = Logger.getLogger(SolicitudPostulacionService.class);
//	SolicitudPostulacionImpl solicitudPostulacionImpl = new SolicitudPostulacionImpl();
	Gson g = new Gson();	
	
	@Context
	private HttpServletRequest request;
	
	@POST
    @Path("/almacenarSolicitudPostulacionPagoOffline")
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
		
		logger.info("Inicio validación de postulación.");
		
		logger.info(jsonParametrosBusquedaRequest);
		
//		Gson g = new Gson();
		
//		WrapperFrontResponse data = new WrapperFrontResponse();
//		String jsonResultado = "";
		try {
			SolicitudPostulacionModel solicitudPostulacionModel = new SolicitudPostulacionModel();
			
			SolicitudPostulacionImpl solicitudPostulacionImpl = new SolicitudPostulacionImpl(request.getRemoteAddr(), request.getRemoteHost(), jsonFicha);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			solicitudPostulacionImpl.iniciliazarFormulario();
			
			if(solicitudPostulacionImpl.getGenerarAplicacion().getAuthenticacionContext()!=null){
				
				solicitudPostulacionModel = objectMapper.readValue(jsonParametrosBusquedaRequest, SolicitudPostulacionModel.class);

				solicitudPostulacionImpl.setSolicitudPostulacionDTO(new SolicitudPostulacionDTO());
				
				List<ProgramaUniversidadPostulacionDTO> lista = new ArrayList<ProgramaUniversidadPostulacionDTO>(0);
				lista.add(solicitudPostulacionModel.getPrograma());
				solicitudPostulacionImpl.setListaProgramaUniversidadPostulacionDTO(lista);
				solicitudPostulacionImpl.setArchivoSolicitudPostulacionDTO(solicitudPostulacionModel.getArchivo());
				
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setIdProgramaUniversidadPostulacion(solicitudPostulacionModel.getIdProgramaUniversidadPostulacion());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setProgramaPostulacionUniversidad(solicitudPostulacionModel.getProgramaPostulacionUniversidad());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setCostoProgramaUniversidad(solicitudPostulacionModel.getCostoProgramaUniversidad());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setTituloVersionSemestral(solicitudPostulacionModel.getTituloVersionSemestral());
				
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setRutPersonaSolicitudPostulacion(solicitudPostulacionModel.getRutPersonaSolicitudPostulacion());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setNombrePersonaSolicitudPostulacion(solicitudPostulacionModel.getNombrePersonaSolicitudPostulacion());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setApellidoPaternoPersonaSolicitudPostulacion(solicitudPostulacionModel.getApellidoPaternoPersonaSolicitudPostulacion());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setApellidoMaternoPersonaSolicitudPostulacion(solicitudPostulacionModel.getApellidoMaternoPersonaSolicitudPostulacion());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setFechaNacimiento(solicitudPostulacionModel.getFechaNacimiento());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setNacionalidad(solicitudPostulacionModel.getNacionalidad());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setFonoContacto(solicitudPostulacionModel.getFonoContacto());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setCelularContacto(solicitudPostulacionModel.getCelularContacto());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setMailMember(solicitudPostulacionModel.getMailMember());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setDomicilio(solicitudPostulacionModel.getDomicilio());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setPaisDomicilio(solicitudPostulacionModel.getPaisDomicilio());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setIdRegionDomicilio(solicitudPostulacionModel.getIdRegionDomicilio());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setNombreRegion(solicitudPostulacionModel.getNombreRegion());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setIdComunaDomicilio(solicitudPostulacionModel.getIdComunaDomicilio());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setNombreComuna(solicitudPostulacionModel.getNombreComuna());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setCiudadDomicilio(solicitudPostulacionModel.getCiudadDomicilio());
				
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setTituloProfesional(solicitudPostulacionModel.getTituloProfesional());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setEntidadEducacional(solicitudPostulacionModel.getEntidadEducacional());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setPaisEntidadEducacional(solicitudPostulacionModel.getPaisDomicilio());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setAnhoObtencionEntidadEducacional(solicitudPostulacionModel.getAnhoObtencionEntidadEducacional());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setOcupacionActual(solicitudPostulacionModel.getOcupacionActual());
				
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setInteresPrograma(solicitudPostulacionModel.getInteresPrograma());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setFuenteFinancimiamiento(solicitudPostulacionModel.getFuenteFinancimiamiento());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setComentarios(solicitudPostulacionModel.getComentarios());
				
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setIdArchivoSolicitud(solicitudPostulacionModel.getIdArchivoSolicitud());
				solicitudPostulacionImpl.getSolicitudPostulacionDTO().setNombreArchivoSolicitud(solicitudPostulacionModel.getNombreArchivoSolicitud());
				/*hay que validar antes de enivar la información*/
				
				logger.info("################################## Siguiente Paso Almacenar dato ###################################################");
				
				try{
					boolean valido = solicitudPostulacionImpl.almacenarSolicitudPostulacionPagoOffline();
					if(valido){
//						data.setEstado("EXITO");
//						data.setMensaje("Fue envianda la solicitd de certificado");
//						data.setOk(true);
//						data.setData("Fue envianda la solicitd de postulacion");
//						data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-postulacion-exito.jsp");
//						jsonResultado = JsonMappeo.convertirObjectToJson(data);	
						data = JsonMappeo.convertirObjectToJson("");
						
						redireccion = "web-uchile-front-solicitudes/main/view/solicitud-postulacion-exito.jsp";
						
						ok = true;
					}else{
//						logger.error("Error en el metodo almacenarSolicitudPostulacionPagoOffline");
////						data.setEstado("ERROR");
////						data.setMensaje("Exception en el seteo de los datos para la solicitud de postulacion");
////						data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-postulacion-error.jsp");
//						AbstractWrapperError error = new AbstractWrapperError();
//						error.setCodigo(400);
//						error.setMensaje("Exception en el seteo de los datos para la solicitud de postulacion");
//						data.setError(error);
//						data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-postulacion-error.jsp");
//						
//						jsonResultado = JsonMappeo.convertirObjectToJson(data);
						ok = false;
					}
				}catch(Exception e){
//					logger.error("Exception No fue posible enviar la solicitud del postulacion. "+e.getMessage(), e);
////					data.setEstado("ERROR");
////					data.setMensaje("Exception en el seteo de los datos para la solicitud de postulacion");
////					data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-postulacion-error.jsp");
//					AbstractWrapperError error = new AbstractWrapperError();
//					error.setCodigo(400);
//					error.setMensaje("Exception en el seteo de los datos para la solicitud de postulacion");
//					data.setError(error);
//					data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-postulacion-error.jsp");
//					jsonResultado = JsonMappeo.convertirObjectToJson(data);
//					return jsonResultado;
					error = new AbstractWrapperError();

					error.setMensaje("Exception en la obtencion de los datos del negocio"+ e.getMessage());

					error.setCodigo(400);
				}
			
			}else{
				ok = false;
			}
		} catch (Exception e) {
//			logger.error("Exception en el seteo de los datos para la solicitud de certificado: "+e.getMessage(), e);
////			data.setEstado("ERROR");
////			data.setMensaje("Exception en el seteo de los datos para la solicitud de certificado");
////			data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-postualcion-error.jsp");
//			AbstractWrapperError error = new AbstractWrapperError();
//			error.setCodigo(400);
//			error.setMensaje("Exception en el seteo de los datos para la solicitud de postulacion");
//			data.setError(error);
//			data.setUrl("web-uchile-front-solicitudes/main/view/solicitud-postualcion-error.jsp");
//			jsonResultado = JsonMappeo.convertirObjectToJson(data);
//			return jsonResultado;
			error = new AbstractWrapperError();

			error.setMensaje("Exception en la obtencion de los datos del servicio"+e.getMessage());

			error.setCodigo(400);
			
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
//        return jsonResultado;
	}
	

	@POST
    @Path("/subirArchivo")
    @Produces(MediaType.APPLICATION_JSON)
    public String subirArchivo(@FormParam("requestFicha") String jsonFicha, @Context HttpServletRequest servletRequest, @Context HttpServletResponse servletResponse) {

		String archivo = "{'archivo':'No tiene Archivo'}";
		try {
				logger.info("iniciando la subida de archivo en la pagina de postulaciones.");
//				solicitudPostulacionImpl.llamarRemoteCommandSeguridad();
				SolicitudPostulacionImpl solicitudPostulacionImpl = new SolicitudPostulacionImpl(servletRequest.getRemoteAddr(), servletRequest.getRemoteHost(), jsonFicha);
				WrapperFrontResponse res = new WrapperFrontResponse();
				
				String nombreArchivoFinal = ""; 
			    //StringBuilder sb = new StringBuilder(); 
			    //InputStream reader = servletRequest.getInputStream(); 
			    String primerosdatos = "";
			    String segundodatos = "";
			    
			    InputStream inStream = servletRequest.getInputStream(); 
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

						   InputStream readerNew = servletRequest.getInputStream(); 
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
							           //System.out.println("Archivo" +  is.toString());
						       } catch (UnsupportedEncodingException e) {
						            e.printStackTrace();
						       }
				           solicitudPostulacionImpl.handleFileUpload(nombreArchivoFinal,is, f, contenido);
				          
							 
						   salida.close();
						   readerNew.close();
						   //System.out.println("Se realizo la conversion con exito");
						   //System.out.println(salida);
					  }catch(IOException e){
						  logger.error("Se produjo el error : "+e.toString());
					  }
			    } finally { 
			     reader.close(); 
			    } 
			  
			   ArchivoSolicitudDTO archivoGuardado = (solicitudPostulacionImpl.getArchivoSolicitudPostulacionDTO()!= null) ? solicitudPostulacionImpl.getArchivoSolicitudPostulacionDTO(): null; 
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
