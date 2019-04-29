
package web.uchile.articular.servicio.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vijnana.respuesta.wrapper.response.seguridad.AutentificacionContext;
import vijnana.respuesta.wrapper.response.seguridad.BasicContext;
import vijnana.respuesta.wrapper.request.ConsultaSeguridad;
import vijnana.seguridad.orquestador.cliente.ClienteRestSeguridad;
import vijnana.seguridad.orquestador.properties.VijnanaSeguridadProperties;
import vijnana.wsrest.seguridad.utilidades.UtilidadesClienteWsRest;

import com.manashiki.seguridad.servdto.dto.entities.transferencia.ResponseSeguridad;
import web.uchile.articular.servicio.utilidades.UchileOrquestadorConstantes;

public class LoginModelo {

	private static final Logger objLog = LoggerFactory.getLogger(LoginModelo.class);

	private VijnanaSeguridadProperties vijnanaSeguridadProperties = new VijnanaSeguridadProperties();

	private ClienteRestSeguridad clienteRestAplicacion = new ClienteRestSeguridad();

	public LoginModelo() {
		super();

		this.clienteRestAplicacion = new ClienteRestSeguridad();

		this.vijnanaSeguridadProperties = new VijnanaSeguridadProperties();

	}

	/*Como tengo toda la lista de servicios disponibles para la aplicacion valido en java-front si tengo acceso a la aplicacion */
	public BasicContext generarLoginUsuario(AutentificacionContext authenticacionContext, String usernameLogin, String passwordLogin , int idRol){
		BasicContext basicContext = null;

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

		consultaSeguridad.setRolContexto(UchileOrquestadorConstantes.setRolUsuarioById(idRol));

		consultaSeguridad.setNombreAplicacion(UchileOrquestadorConstantes.getNombreaplicacionuchile());

		consultaSeguridad.setKeySeguridad(authenticacionContext.getEnterpriseContext().getKeyEnterprise());

		//Si no existe token... generar el token por seguridad
		//			vijnana.seguridad.orquestador.cliente.ClienteRest metClienteRest = new vijnana.seguridad.orquestador.cliente.ClienteRest();
		clienteRestAplicacion = new vijnana.seguridad.orquestador.cliente.ClienteRestSeguridad(usernameLogin, passwordLogin, 0, 0);

		try{
			ResponseSeguridad responseSeguridad = clienteRestAplicacion.post(consultaSeguridad, vijnanaSeguridadProperties.getVijnanaServidor(), vijnanaSeguridadProperties.getLocalObtenerUsuarioLogin());
			
			if(responseSeguridad != null && responseSeguridad.getBasicContext()!=null){
				basicContext =  responseSeguridad.getBasicContext();
			}
			
		}catch(Exception e ){
			e.printStackTrace();
		}

		return basicContext;
	}

	public BasicContext generarLoginUsuario(AutentificacionContext authenticacionContext, HashMap<String, String> mapaClaves){
		BasicContext basicContext = null;

		ConsultaSeguridad consultaSeguridad = new ConsultaSeguridad();

		consultaSeguridad.setRemoteAddr("");

		if(consultaSeguridad.getRemoteAddr().equals("127.0.0.1")){
			consultaSeguridad.setRemoteAddr("localhost");
		}

		consultaSeguridad.setRemoteHost("");

		if(consultaSeguridad.getRemoteHost().equals("127.0.0.1")){
			consultaSeguridad.setRemoteHost("localhost");
		}

		consultaSeguridad.setDominioEmpresa(UchileOrquestadorConstantes.getDominioempresa()); // httpServletRequest.get

		consultaSeguridad.setRolContexto(UchileOrquestadorConstantes.setRolUsuarioById(1));

		consultaSeguridad.setNombreAplicacion(UchileOrquestadorConstantes.getNombreaplicacionuchile());

		consultaSeguridad.setKeySeguridad(authenticacionContext.getEnterpriseContext().getKeyEnterprise());

		clienteRestAplicacion = new ClienteRestSeguridad(consultaSeguridad.getNombreUsuario(), "", 
				vijnanaSeguridadProperties.getVijnanaClientTimeoutConexion(),
				vijnanaSeguridadProperties.getVijnanaClientReadConexion());
		try{

			String urlMetodo = UtilidadesClienteWsRest.urlMetodoGET(vijnanaSeguridadProperties.getLocalObtenerGetUsuarioLogin(), mapaClaves);

			ResponseSeguridad responseSeguridad = 
					(ResponseSeguridad) clienteRestAplicacion.
					get(vijnanaSeguridadProperties.getVijnanaServidor(), urlMetodo);

			if(responseSeguridad != null && responseSeguridad.getBasicContext()!=null){
				basicContext =  responseSeguridad.getBasicContext();
			}

		}catch(Exception e ){
			e.printStackTrace();
		}

		return basicContext;
	}

}
