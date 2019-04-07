
package web.uchile.articular.servicio.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manashiki.uchilearte.servdto.dto.entities.formulario.ArchivoSolicitudDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ComunaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.FinalidadCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadPostulacionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.RegionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudAcademicaDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.SolicitudPostulacionDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoSolicitudDTO;
import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;
import com.manashiki.uchilearte.servdto.transaccion.NegocioSolicitudDTO;
import com.manashiki.uchilearte.servdto.wrapper.UchileArte;
import vijnana.respuesta.wrapper.request.ConsultaWebmail;
import vijnana.respuesta.wrapper.response.seguridad.AplicacionServicioDTO;
import vijnana.utilidades.component.utilidades.Ip;
import web.uchile.articular.servicio.properties.WebUchileProperties;
import web.uchile.articular.servicio.utilidades.ClienteRestUtilidades;

public class SolicitudesUchileModelo {

	private static final Logger objLog = LoggerFactory.getLogger(SolicitudesUchileModelo.class);

	private WebUchileProperties webUchileProperties = new WebUchileProperties();

	private ClienteRestUchile clienteRestUchile = new ClienteRestUchile();

	public SolicitudesUchileModelo() {
		super();

		this.clienteRestUchile = new ClienteRestUchile();

		this.webUchileProperties = new WebUchileProperties();

	}
	
	private boolean validarAccesoServicio(List<AplicacionServicioDTO> listaAplicacionServicio, String tipo, String urlServicio) {
		
		for(AplicacionServicioDTO asDTO: listaAplicacionServicio){
			if(asDTO.getMetodoHttp().toLowerCase().equals(tipo.toLowerCase()) && urlServicio.equals("/"+asDTO.getUriRutaAplicacion()+"/"+asDTO.getUriRutaAplicacionProducto()+"/"+asDTO.getUriRutaAplicacionProductoServicio())){
				return true;
			}
		}
		
		return false;
	}
	
	/*Como tengo toda la lista de servicios disponibles para la aplicacion valido en java-front si tengo acceso a la aplicacion */
	public List<ProgramaUniversidadDTO> listarProgramasUniversidadDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarProgramaUniversidad())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarProgramaUniversidad());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listarProgramasUniversidadOrdenDTO]");
			}
			
		}
		return uchileArte.getListaProgramaUniversidadDTO(); 

	}
	
	/*Como tengo toda la lista de servicios disponibles para la aplicacion valido en java-front si tengo acceso a la aplicacion */
	public List<ProgramaUniversidadDTO> listarProgramasUniversidadOrdenDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarProgramaUniversidad())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarProgramaUniversidadOrden());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listarProgramasUniversidadOrdenDTO]");
			}
			
		}
		return uchileArte.getListaProgramaUniversidadDTO(); 

	}

	public List<TipoSolicitudDTO> listarTipoSolicitudDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarTipoSolicitudes())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarTipoSolicitudes() );
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listarTipoSolicitudDTO]");
			}
			
		}
		return  uchileArte.getListaTipoSolicitudDTO();

	}
	
	public List<TipoSolicitudDTO> listarTipoSolicitudOrdenDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();
		
		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarTipoSolicitudesOrden())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarTipoSolicitudesOrden());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listarTipoSolicitudOrdenDTO]");
			}
			
		}
		return  uchileArte.getListaTipoSolicitudDTO();

	}
	
	public List<TipoCertificadoDTO> listarTipoCertificadoDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();

		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarTipoCertificados())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarTipoCertificados());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listarTipoCertificadoDTO]");
			}
		}
		return  uchileArte.getListaTipoCertificadoDTO();

	}
	
	public List<TipoCertificadoDTO> listarTipoCertificadoOrdenDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();
		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarTipoCertificadosOrden())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarTipoCertificadosOrden());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listarTipoCertificadoOrdenDTO]");
			}
		}
		return  uchileArte.getListaTipoCertificadoDTO();

	}
	
	public List<FinalidadCertificadoDTO> listarFinalidadCertificadoDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();
		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarFinalidadCertificados())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarFinalidadCertificados());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listarFinalidadCertificadoDTO]");
			}
			
		}
		return  uchileArte.getListaFinalidadCertificadoDTO();

	}
	
	public List<FinalidadCertificadoDTO> listarFinalidadCertificadoOrdenDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();
		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarFinalidadCertificadosOrden())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(),webUchileProperties.getLocalListarFinalidadCertificadosOrden());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listarFinalidadCertificadoOrdenDTO]");
			}
		}
		return  uchileArte.getListaFinalidadCertificadoDTO();

	}
	
	public List<ProgramaUniversidadPostulacionDTO> listarProgramasUniversidadPostulacionOrdenDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		UchileArte uchileArte = new UchileArte();
		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarProgramaUniversidadPostulacionOrden())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarProgramaUniversidadPostulacionOrden());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listarProgramasUniversidadPostulacionOrdenDTO]");
			}
		}
		return  uchileArte.getListaProgramaUniversidadPostulacionDTO();

	}
	
	public List<RegionDTO> listarRegionDTO(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext){

		List<RegionDTO> finalListaRegionDTO = null;

		UchileArte uchileArte = new UchileArte();
		//		 Mostrar Todo
		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarRegiones())){
			uchileArte = clienteRestUchile.post(new RequestProductoDTO(), webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarRegiones());
			
			if(uchileArte==null || uchileArte.getListaRegionDTO()==null){
				objLog.info("Error en la generacion [listarRegionDTO]");
			}
			
			List<RegionDTO> metListaRegionDTO = uchileArte.getListaRegionDTO();

			finalListaRegionDTO = uchileArte.getListaRegionDTO();

			for(RegionDTO reg: metListaRegionDTO){
				if(!reg.getCodigoRegion().equals("None")){
					finalListaRegionDTO.add(reg);
				}
			}
		}
		return finalListaRegionDTO;
	}
	
	public List<ComunaDTO> listaComunaDTOXRegion(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO){

		UchileArte uchileArte = new UchileArte();
		//Buscar en Todas las Comunas 
		if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarComunasxRegion())){
			uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarComunasxRegion());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [listaComunaDTOXRegion]");
			}
		}
		return uchileArte.getListaComunaDTO(); 

	}
	
	public ArchivoSolicitudDTO handleFileUpload(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, ArchivoSolicitudDTO archivoSolicitudDTO){
		objLog.info("INI handleFileUpload");
		//UploadedFile upFile = fileUploadEvent.getFile();
		try {
			UchileArte uchileArte = new UchileArte();
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalCrearArchivoSolicitud())){
			
				RequestProductoDTO requestProductoDTO = new RequestProductoDTO();
				
				requestProductoDTO.setArchivoSolicitudDTO(archivoSolicitudDTO);

				uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearArchivoSolicitud());
				
				if(uchileArte==null){
					objLog.info("Error en la generacion [handleFileUpload]");
				}
			}
			
			return uchileArte.getArchivoAcademicaDTO();
			//			if(archivoSolicitudDTO!=null && archivoSolicitudDTO.getIdArchivoSolicitud()>0 && archivoSolicitudDTO.getNombreArchivoSolicitud()!=null){
			//				objLog.info("I - validar Archivo: "+archivoSolicitudDTO.getIdArchivoSolicitud());
			//			}
			//Guardar el nombre y la direccion en la base de datos "archivoSolicitud y relacionarlo con solicitudAcademica"
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public RequestProductoDTO almacenarSolicitudCertificado(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, SolicitudCertificadoDTO solicitudCertificadoDTO) throws IOException {

		try{

			RequestProductoDTO requestProductoDTO = new RequestProductoDTO();
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalCrearSolicitudCertificado())){
				requestProductoDTO.setSolicitudCertificadoDTO(solicitudCertificadoDTO);

				UchileArte uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearSolicitudCertificado());
				
				if(uchileArte==null){
					objLog.info("Error en la generacion [almacenarSolicitudCertificado]");
				}
			}
			return requestProductoDTO;

		}
		catch(Exception e){
			e.printStackTrace();
			objLog.info("ERROR - almacenarSolicitudAcademica:"+solicitudCertificadoDTO.getRutPersonaSolicitudCertificado()+" - "+e.getMessage());
		}

		return null;
	}
	
	public RequestProductoDTO almacenarSolicitudAcademica(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, SolicitudAcademicaDTO solicitudAcademicaDTO) throws IOException {

		try{

			RequestProductoDTO requestProductoDTO = new RequestProductoDTO();
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalCrearSolicitudAcademica())){
				requestProductoDTO.setSolicitudAcademicaDTO(solicitudAcademicaDTO);

				UchileArte uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearSolicitudAcademica());
				
				if(uchileArte==null){
					objLog.info("Error en la generacion [almacenarSolicitudAcademica]");
				}
			}
			return requestProductoDTO;

		}
		catch(Exception e){
			e.printStackTrace();
			objLog.info("ERROR - almacenarSolicitudAcademica:"+solicitudAcademicaDTO.getRutPersonaSolicitudAcademica()+" - "+e.getMessage());
		}

		return null;
	}
	
	public RequestProductoDTO almacenarSolicitudAdmisionPostgrado(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, SolicitudPostulacionDTO solicitudPostulacionDTO) throws IOException {
		
		RequestProductoDTO requestProductoDTO = new RequestProductoDTO();
		
		try{
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarProgramaUniversidad())){
			requestProductoDTO.setSolicitudPostulacionDTO(solicitudPostulacionDTO);
			
//			String key = ClienteRestUtilidades.generacionSolicitudPostulacionSHA(requestProductoDTO);
			//Cambiar
			UchileArte uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalCrearSolicitudPostulacion());
			
			if(uchileArte==null){
				objLog.info("Error en la generacion [almacenarSolicitudAdmisionPostgrado]");
			}
			}
			return requestProductoDTO;

		}
		catch(Exception e){
			e.printStackTrace();
			objLog.info("ERROR - almacenarSolicitudAcademica:"+solicitudPostulacionDTO.getRutPersonaSolicitudPostulacion()+" - "+e.getMessage());
		}

		return null;
	}
	
	public List<SolicitudCertificadoDTO> listarSolicitudCertificadoEntreFechas(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {

		try{
			UchileArte uchileArte = new UchileArte();
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalCrearSolicitudAcademica())){

				uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(), webUchileProperties.getLocalListarSolicitudCertificadoxEntreFechas());
				
				if(uchileArte==null){
					objLog.info("Error en la generacion [listarSolicitudCertificadoEntreFechas]");
				}
			}
			return uchileArte.getListaSolicitudCertificadoDTO();

		}
		catch(Exception e){
			e.printStackTrace();
			objLog.info("ERROR - listarSolicitudCertificadoEntreFechas: "+e.getMessage());
		}

		return null;
	}
	
	

	public RequestProductoDTO almacenarBusinessAcademica(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO, boolean online) {
//		UchileArte uchileArte = null; 
		try{
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalCrearNegocioSolicitud())){
				String key = ClienteRestUtilidades.generacionSolicitudAcademicaSHA(requestProductoDTO);

				String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

				NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

				negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

				negocioSolicitudDTO.setKeyNegocioSolicitud(key);

				negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

				negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

				requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);

				UchileArte uchileArte = clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalCrearNegocioSolicitud());
				
				if(uchileArte==null){
					objLog.info("Error en la generacion [almacenarBusinessAcademica]");
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return requestProductoDTO;

	}
	
	public void enviarEmailSolicitudCertificado(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {
//		UchileArte uchileArte = null;
		ConsultaWebmail consultaWebmail = new ConsultaWebmail();
		
		try{
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail())){
				String key = ClienteRestUtilidades.generacionSolicitudCertificadoSHA(requestProductoDTO);

				String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

				NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

				negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

				negocioSolicitudDTO.setKeyNegocioSolicitud(key);

				negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

				negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

				requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);

				//			consultaWebmail.setIdAplicacion(UchileOrquestadorConstantes.getIdaplicacioncorreo());
				//			
				//			consultaWebmail.setIdEmail(UchileOrquestadorConstantes.getIdemailcorreo());

				consultaWebmail.setRemoteAddr(Ip.direccionServer());

				clienteRestUchile.postEmail(consultaWebmail, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalEnviarCorreoSolicitud());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

//		return uchileArte;
	}
	
	public void enviarEmailSolicitudAcademica(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {
//		UchileArte uchileArte = null;
		ConsultaWebmail consultaWebmail = new ConsultaWebmail();
		
		try{
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalEnviarCorreoSolicitud())){
			String key = ClienteRestUtilidades.generacionSolicitudAcademicaSHA(requestProductoDTO);

			String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

			NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

			negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

			negocioSolicitudDTO.setKeyNegocioSolicitud(key);

			negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

			negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

			requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);
			

			consultaWebmail.setRemoteAddr(Ip.direccionServer());
			
			clienteRestUchile.postEmail(consultaWebmail, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalEnviarCorreoSolicitud());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

//		return uchileArte;
	}
	
	public void enviarEmailSolicitudPostulacion(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {
//		UchileArte uchileArte = null;
		ConsultaWebmail consultaWebmail = new ConsultaWebmail();
		
		try{
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarProgramaUniversidad())){
				String key = ClienteRestUtilidades.generacionSolicitudPostulacionSHA(requestProductoDTO);

				String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

				NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

				negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

				negocioSolicitudDTO.setKeyNegocioSolicitud(key);

				negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

				negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

				requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);

				//			consultaWebmail.setIdAplicacion(UchileOrquestadorConstantes.getIdaplicacioncorreo());
				//			
				//			consultaWebmail.setIdEmail(UchileOrquestadorConstantes.getIdemailcorreo());

				consultaWebmail.setRemoteAddr(Ip.direccionServer());

				clienteRestUchile.postEmail(consultaWebmail, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalEnviarCorreoSolicitud());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

//		return uchileArte;
	}
	
	public String obtenerContenidoRequestByMail(vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext, RequestProductoDTO requestProductoDTO) {
//		UchileArte uchileArte = null;
		ConsultaWebmail consultaWebmail = new ConsultaWebmail();
		
		try{
			if(validarAccesoServicio(authenticacionContext.getListaAplicacionServicio(), "post", webUchileProperties.getLocalListarProgramaUniversidad())){
				String key = ClienteRestUtilidades.generacionSolicitudPostulacionSHA(requestProductoDTO);

				String valorNegocioSolicitud= ClienteRestUtilidades.obtenerContenidoRequestByMail(requestProductoDTO, webUchileProperties.getServerIdSolicitudAcademicaAplicacion(), webUchileProperties.getServerIdSolicitudAcademicaEmailWebmail());

				NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();

				negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);

				negocioSolicitudDTO.setKeyNegocioSolicitud(key);

				negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());

				negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());

				requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);

				consultaWebmail.setRemoteAddr(Ip.direccionServer());

				clienteRestUchile.postEmail(consultaWebmail, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalEnviarCorreoSolicitud());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}
	
	public String obtenerContenidoRequestByFlujo(RequestProductoDTO requestProductoDTO) {
//		UchileArte uchileArte = null;
//		ConsultaWebmail consultaWebmail = new ConsultaWebmail();
//		
//		try{
//			
//			String valorNegocioSolicitud= solicitudesModelo.obtenerContenidoRequestByMail(requestProductoDTO);
//
//			NegocioSolicitudDTO negocioSolicitudDTO = new NegocioSolicitudDTO();
//
//			negocioSolicitudDTO.setValorNegocioSolicitud(valorNegocioSolicitud);
//			negocioSolicitudDTO.setKeyNegocioSolicitud(key);
//			negocioSolicitudDTO.setFechaInicialNegocioSolicitud(new Date());
//			negocioSolicitudDTO.setFechaVencimientoNegocioSolicitud(new Date());
//
//			requestProductoDTO.setNegocioSolicitudDTO(negocioSolicitudDTO);
//
//			clienteRestUchile.post(requestProductoDTO, webUchileProperties.getVijnanaServidor(),  webUchileProperties.getLocalCrearNegocioSolicitud());
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//
		return null;
	}
	
	
}
