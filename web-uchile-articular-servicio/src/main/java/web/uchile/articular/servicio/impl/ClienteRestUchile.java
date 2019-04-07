package web.uchile.articular.servicio.impl;

import com.manashiki.uchilearte.servdto.request.RequestProductoDTO;
//import com.manashiki.uchilearte.servdto.wrapper.UchileArte;
import com.manashiki.uchilearte.servdto.wrapper.UchileArte;

import vijnana.seguridad.orquestador.cliente.ClienteRest;
import vijnana.wsrest.client.IClientWsRest;
import vijnana.wsrest.client.exception.VijnanaClientException;
import vijnana.wsrest.client.impl.VijnanaClienteWsRest;

public class ClienteRestUchile extends ClienteRest{
	//hereda del cliente que va a seguridad y al correo
	String usuario = "";
	String seguridadAplicacion = "";
	
	public ClienteRestUchile() {
		super();
	}
	
	public ClienteRestUchile(String usuario, String seguridadAplicacion) {
		super();
		this.usuario = usuario;
		this.seguridadAplicacion = seguridadAplicacion;
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
	
}
