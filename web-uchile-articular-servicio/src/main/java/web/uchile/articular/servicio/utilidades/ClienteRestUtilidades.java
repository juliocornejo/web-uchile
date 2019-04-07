package web.uchile.articular.servicio.utilidades;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;

import vijnana.utilidades.component.utilidades.excriptar.Sha256;


public class ClienteRestUtilidades {

	public static String obtenerContenidoRequestCertificado(RequestProductoDTO requestProductoDTO){
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		objectMapper.setDateFormat(sdf);
		objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		String request = null;
		try {
				request = objectMapper.writeValueAsString(requestProductoDTO.getSolicitudCertificadoDTO());
			
				request = request.replace("null", "\"\"");
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return request;
	}
	
	public static String obtenerContenidoRequestAcademica(RequestProductoDTO requestProductoDTO){
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		objectMapper.setDateFormat(sdf);
		objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		String request = null;
		try {
				request = objectMapper.writeValueAsString(requestProductoDTO.getSolicitudAcademicaDTO());
			
				request = request.replace("null", "\"\"");
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return request;
	}
	
	public static String obtenerContenidoRequestPostulacion(RequestProductoDTO requestProductoDTO){
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		objectMapper.setDateFormat(sdf);
		objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		String request = null;
		try {
				request = objectMapper.writeValueAsString(requestProductoDTO.getSolicitudPostulacionDTO());
			
				request = request.replace("null", "\"\"");
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return request;
	}
	
	public static String obtenerContenidoRequestByMail(RequestProductoDTO requestProductoDTO, String idAplicacion, String idEmail){
//		ObjectMapper objectMapper = new ObjectMapper();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//		objectMapper.setDateFormat(sdf);
//		objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		String request = null;
//		try {
			if(idAplicacion.equals("1") && idEmail.equals("1")){
				request = obtenerContenidoRequestCertificado(requestProductoDTO);
//				request = objectMapper.writeValueAsString(requestProductoDTO.getSolicitudCertificadoDTO());
			}
			else if(idAplicacion.equals("2") && idEmail.equals("2")){
//				request = objectMapper.writeValueAsString(requestProductoDTO.getSolicitudAcademicaDTO());
				request = obtenerContenidoRequestAcademica(requestProductoDTO);
			}
			else if(idAplicacion.equals("3") && idEmail.equals("3")){
//				request = objectMapper.writeValueAsString(requestProductoDTO.getSolicitudPostulacionDTO());
				request = obtenerContenidoRequestPostulacion(requestProductoDTO);
			}
			else{
//				request = objectMapper.writeValueAsString(requestProductoDTO.getSolicitudCertificadoDTO());
				request = obtenerContenidoRequestCertificado(requestProductoDTO);
			}
//			request = request.replace("null", "\"\"");
//		} catch (JsonGenerationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return request;
	}

	public static String generacionSolicitudCertificadoSHA(RequestProductoDTO requestProductoDTO){
		String key = requestProductoDTO.getSolicitudCertificadoDTO().getNombrePersonaSolicitudCertificado() + 
				requestProductoDTO.getSolicitudCertificadoDTO().getApellidoPaternoPersonaSolicitudCertificado() + 
				requestProductoDTO.getSolicitudCertificadoDTO().getApellidoMaternoPersonaSolicitudCertificado() +
				requestProductoDTO.getSolicitudCertificadoDTO().getRutPersonaSolicitudCertificado() +
				requestProductoDTO.getSolicitudCertificadoDTO().getIdProgramaUniversidad() +
				requestProductoDTO.getSolicitudCertificadoDTO().getMailMember() +
				requestProductoDTO.getSolicitudCertificadoDTO().getAnhoIngreso() +
				requestProductoDTO.getSolicitudCertificadoDTO().getIdTipoCertificado() +
				requestProductoDTO.getSolicitudCertificadoDTO().getIdFinalidadCertificado() + 
				requestProductoDTO.getSolicitudCertificadoDTO().getFechaSolicitud();

		return Sha256.generacionSHA(key, String.class);
	}

	public static String generacionSolicitudPostulacionSHA(RequestProductoDTO requestProductoDTO){
		String key = requestProductoDTO.getSolicitudPostulacionDTO().getNombrePersonaSolicitudPostulacion() +
				requestProductoDTO.getSolicitudPostulacionDTO().getApellidoPaternoPersonaSolicitudPostulacion() +
				requestProductoDTO.getSolicitudPostulacionDTO().getApellidoMaternoPersonaSolicitudPostulacion() +
				requestProductoDTO.getSolicitudPostulacionDTO().getRutPersonaSolicitudPostulacion() +
				requestProductoDTO.getSolicitudPostulacionDTO().getIdProgramaUniversidadPostulacion() +
				requestProductoDTO.getSolicitudPostulacionDTO().getMailMember() +
				requestProductoDTO.getSolicitudPostulacionDTO().getCelularContacto() +
				requestProductoDTO.getSolicitudPostulacionDTO().getIdRegionDomicilio() +
				requestProductoDTO.getSolicitudPostulacionDTO().getIdComunaDomicilio() +
				requestProductoDTO.getSolicitudPostulacionDTO().getCiudadDomicilio() +
				requestProductoDTO.getSolicitudPostulacionDTO().getFuenteFinancimiamiento() +
				requestProductoDTO.getSolicitudPostulacionDTO().getComentarios() +
				requestProductoDTO.getSolicitudPostulacionDTO().getInteresPrograma() +
				requestProductoDTO.getSolicitudPostulacionDTO().getSfechaSolicitud();

		return Sha256.generacionSHA(key, String.class);
	}

	public static String generacionSolicitudAcademicaSHA(RequestProductoDTO requestProductoDTO){
		String key = requestProductoDTO.getSolicitudAcademicaDTO().getNombrePersonaSolicitudAcademica() + 
				requestProductoDTO.getSolicitudAcademicaDTO().getApellidoPaternoPersonaSolicitudAcademica() + 
				requestProductoDTO.getSolicitudAcademicaDTO().getApellidoMaternoPersonaSolicitudAcademica() +
				requestProductoDTO.getSolicitudAcademicaDTO().getRutPersonaSolicitudAcademica() +
				requestProductoDTO.getSolicitudAcademicaDTO().getIdProgramaUniversidad() +
				requestProductoDTO.getSolicitudAcademicaDTO().getMailMember() +
				requestProductoDTO.getSolicitudAcademicaDTO().getAnhoIngreso() +
				requestProductoDTO.getSolicitudAcademicaDTO().getIdTipoSolicitud() +
				requestProductoDTO.getSolicitudAcademicaDTO().getIdArchivoSolicitud() +
				requestProductoDTO.getSolicitudAcademicaDTO().getFechaSolicitud();

		return Sha256.generacionSHA(key, String.class);
	}

}
