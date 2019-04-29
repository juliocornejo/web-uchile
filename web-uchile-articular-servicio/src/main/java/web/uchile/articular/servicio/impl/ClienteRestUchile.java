package web.uchile.articular.servicio.impl;

import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;
//import com.manashiki.uchilearte.servdto.wrapper.UchileArte;
import com.manashiki.uchilearte.servdto.wrapper.UchileArte;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import vijnana.seguridad.orquestador.cliente.ClienteRest;
import vijnana.wsrest.client.IClientWsRest;
import vijnana.wsrest.client.exception.VijnanaClientException;
import vijnana.wsrest.client.impl.VijnanaClienteWsRest;

public class ClienteRestUchile extends ClienteRest{
	//hereda del cliente que va a seguridad y al correo

	
	public ClienteRestUchile() {
		super();
	}
	
	public ClienteRestUchile(String usuarioCredencial, String seguridadAplicacion) {
		super(usuarioCredencial, seguridadAplicacion);
	}

	@SuppressWarnings("unchecked")
	public UchileArte post(RequestProductoDTO requestProductoDTO, String servidorProp, String urlMetodo){
		UchileArte data = null;
		
		try {
			@SuppressWarnings("rawtypes")

			IClientWsRest clientWsRest = new VijnanaClienteWsRest();
			
			data = (UchileArte) clientWsRest.post(requestProductoDTO, RequestProductoDTO.class, UchileArte.class, servidorProp, urlMetodo);
			
		} catch (VijnanaClientException e) {
			// TODO Auto-generated catch block
			 return null;
		} catch (Exception e) {
			return null;
		}
		
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public UchileArte post(RequestProductoDTO requestProductoDTO, String servidorProp, String urlMetodo, int tiempoConexion,  int tiempoLectura) {
		UchileArte data = null;
		try {
			@SuppressWarnings("rawtypes")
			IClientWsRest clientWsRest = new VijnanaClienteWsRest();
			
			ClientFilter clientFilterAgentAuth  = new HTTPBasicAuthFilter(getUsuarioCredencial(), getSeguridadAplicacion());
			
			data = (UchileArte) clientWsRest.postWithFilter(requestProductoDTO, RequestProductoDTO.class,  UchileArte.class, servidorProp, urlMetodo, clientFilterAgentAuth, tiempoConexion, tiempoLectura);
			
			
		} catch (VijnanaClientException e) {
			// TODO Auto-generated catch block
			 return null;
		} catch (Exception e) {
			return null;
		}
		
		return data;
	}
	
}
