
package web.uchile.articular.servicio.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext;
import vijnana.respuesta.wrapper.request.ConsultaSeguridad;
import vijnana.respuesta.wrapper.response.seguridad.AplicacionServicioDTO;
import vijnana.seguridad.orquestador.cliente.ClienteRestAplicacion;
import vijnana.seguridad.orquestador.properties.VijnanaSeguridadProperties;

import com.manashiki.seguridad.servdto.dto.entities.transferencia.ResponseSeguridad;
import web.uchile.articular.servicio.properties.WebUchileProperties;
import web.uchile.articular.servicio.utilidades.UchileOrquestadorConstantes;

public class LoginModelo {

	private static final Logger objLog = LoggerFactory.getLogger(LoginModelo.class);

	private VijnanaSeguridadProperties vijnanaSeguridadProperties = new VijnanaSeguridadProperties();

	private ClienteRestUchile clienteRestUchile = new ClienteRestUchile();

	public LoginModelo() {
		super();

		this.clienteRestUchile = new ClienteRestUchile();

		this.vijnanaSeguridadProperties = new VijnanaSeguridadProperties();

	}
	
	/*Como tengo toda la lista de servicios disponibles para la aplicacion valido en java-front si tengo acceso a la aplicacion */
	public ResponseSeguridad generarLoginUsuario(AutentificacionContext authenticacionContext, String usernameLogin, String passwordLogin ){
		ResponseSeguridad responseSeguridad = null;

			ConsultaSeguridad consultaSeguridad = new ConsultaSeguridad();

			consultaSeguridad.setRemoteAddr("");

			if(consultaSeguridad.getRemoteAddr().equals("127.0.0.1")){
				consultaSeguridad.setRemoteAddr("localhost");
			}

			consultaSeguridad.setRemoteHost("");

			if(consultaSeguridad.getRemoteHost().equals("127.0.0.1")){
				consultaSeguridad.setRemoteHost("localhost");
			}

			consultaSeguridad.setNombreUsuario(usernameLogin);

			consultaSeguridad.setContrasenhaUsuarioEmpresa(passwordLogin);

			consultaSeguridad.setDominioEmpresa(UchileOrquestadorConstantes.getDominioempresa()); // httpServletRequest.get

			consultaSeguridad.setRolContexto(UchileOrquestadorConstantes.getRolusuario());

			consultaSeguridad.setNombreAplicacion(UchileOrquestadorConstantes.getNombreaplicacionuchile());

			consultaSeguridad.setKeySeguridad(authenticacionContext.getEnterpriseContext().getKeyEnterprise());

			//Si no existe token... generar el token por seguridad
//			vijnana.seguridad.orquestador.cliente.ClienteRest metClienteRest = new vijnana.seguridad.orquestador.cliente.ClienteRest();
			ClienteRestAplicacion clienteRestAplicacion = new vijnana.seguridad.orquestador.cliente.ClienteRestAplicacion(usernameLogin, passwordLogin, 0, 0);
			
			try{
				responseSeguridad = clienteRestAplicacion.post(consultaSeguridad, vijnanaSeguridadProperties.getVijnanaServidor(), vijnanaSeguridadProperties.getLocalObtenerUsuarioLogin());
			}catch(Exception e ){
				e.printStackTrace();
			}

		return responseSeguridad;
	}
	
	
}
