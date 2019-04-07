package web.uchile.articular.session.impl;

import vijnana.respuesta.wrapper.request.ConsultaSeguridad;
import vijnana.seguridad.orquestador.exception.WebImplException;
import vijnana.seguridad.orquestador.properties.VijnanaSeguridadProperties;
import com.manashiki.seguridad.servdto.dto.entities.transferencia.ResponseSeguridad;
import web.uchile.articular.servicio.utilidades.UchileOrquestadorConstantes;

/*Esta Pagina Es Para la Creacion de Nuevos usuarios.*/
public class GeneracionAplicacion {

	protected vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext;
	protected String token;
	protected String remoteHost;
	
	
	
	public GeneracionAplicacion( String remoteHost, String token) {
		super();
		this.remoteHost = remoteHost;
		this.token = token;
		generarValoresAplicacion();
	}

	public void generarValoresAplicacion(){
		try {
			ConsultaSeguridad consultaSeguridad = new ConsultaSeguridad();

			consultaSeguridad.setRemoteHost(remoteHost);
			consultaSeguridad.setDominioEmpresa(UchileOrquestadorConstantes.getDominioempresa());
			consultaSeguridad.setNombreUsuario(UchileOrquestadorConstantes.getNombreperfil());
			consultaSeguridad.setNombreAplicacion(UchileOrquestadorConstantes.getNombreaplicacionuchile());
			consultaSeguridad.setNombreAplicacionSeguridad(UchileOrquestadorConstantes.getNombreaplicacionseguridad());
			consultaSeguridad.setContrasenhaUsuarioEmpresa(UchileOrquestadorConstantes.getContrasenhausuarioempresa());
			consultaSeguridad.setRolContexto(UchileOrquestadorConstantes.getRolcontexto());
			
			//Si no existe token... generar el token por seguridad
			if(token==null || token.equals("")){
				vijnana.wsrest.seguridad.Seguridad seguridad = new vijnana.wsrest.seguridad.Seguridad(consultaSeguridad);
				
				authenticacionContext = seguridad.getSessionPlataforma().getDataPlataformaAutentificacion().get(UchileOrquestadorConstantes.getNombreaplicacionuchile());
				
				setToken(seguridad.getTokenAutenticacionSeguridadAplicacion());
				
			}else{
				//Si existe token... obtener el token almacenado
				consultaSeguridad.setKeySeguridad(getToken());
				vijnana.wsrest.seguridad.Seguridad seguridad = new vijnana.wsrest.seguridad.Seguridad(consultaSeguridad, getToken());

				if(seguridad!=null && seguridad.getSessionPlataforma()!=null && seguridad.getSessionPlataforma().getDataPlataformaEnterprise()!=null && 
						seguridad.getSessionPlataforma().getDataPlataformaEnterprise().get(UchileOrquestadorConstantes.getNombreaplicacionuchile())!=null && 
						seguridad.getSessionPlataforma().getDataPlataformaEnterprise().get(UchileOrquestadorConstantes.getNombreaplicacionuchile()).getBasicContext()!=null){

					authenticacionContext = seguridad.getSessionPlataforma().getDataPlataformaAutentificacion().get(UchileOrquestadorConstantes.getNombreaplicacionuchile());
				}
			}
		} catch (WebImplException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	

	public vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext getAuthenticacionContext() {
		return authenticacionContext;
	}

	public void setAuthenticacionContext(
			vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext authenticacionContext) {
		this.authenticacionContext = authenticacionContext;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	
	
	

}
