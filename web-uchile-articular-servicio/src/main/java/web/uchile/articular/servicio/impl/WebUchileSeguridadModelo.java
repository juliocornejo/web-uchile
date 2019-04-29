package web.uchile.articular.servicio.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vijnana.respuesta.wrapper.request.ConsultaSeguridad;
import vijnana.respuesta.wrapper.response.seguridad.AutentificacionResponse;
import vijnana.respuesta.wrapper.response.seguridad.BasicContext;
import vijnana.respuesta.wrapper.response.seguridad.sessionplataforma.SessionPlataforma;
import vijnana.seguridad.orquestador.cliente.ClienteRestSeguridad;
import vijnana.seguridad.orquestador.properties.VijnanaSeguridadProperties;
import web.uchile.articular.servicio.utilidades.UchileOrquestadorConstantes;

public class WebUchileSeguridadModelo {

	private static final Logger objLog = LoggerFactory.getLogger(WebUchileSeguridadModelo.class);

	private VijnanaSeguridadProperties vijnanaSeguridadProperties = new VijnanaSeguridadProperties();
	
	private ClienteRestSeguridad clienteRestSeguridad = new ClienteRestSeguridad();

	//Aqui se setean las variables que van a ir a seguridad.
	public WebUchileSeguridadModelo() {
		super();
		this.vijnanaSeguridadProperties = new VijnanaSeguridadProperties();
		this.clienteRestSeguridad = new ClienteRestSeguridad();
	}
	
	
	public SessionPlataforma obtenerUsuarioLogin(SessionPlataforma sessionPlataforma, String usernamePerfil, String passwordContrasenha, int idRol) throws Exception{


		ConsultaSeguridad consultaSeguridad = new ConsultaSeguridad();

		consultaSeguridad.setDominioEmpresa(UchileOrquestadorConstantes.getDominioempresa()); // httpServletRequest.get
		consultaSeguridad.setRolContexto(UchileOrquestadorConstantes.setRolUsuarioById(idRol));
		//---------------------------------------
//		consultaSeguridad.setNombreAplicacion(UchileOrquestadorConstantes.getAplicacion());
		consultaSeguridad.setKeySeguridad(sessionPlataforma.getDataPlataformaAutentificacion().get("seguridad").getEnterpriseContext().getKeyEnterprise());

		//ir a buscar todos los metodos que van a ser utilizados

		clienteRestSeguridad = new ClienteRestSeguridad(usernamePerfil, passwordContrasenha,
				vijnanaSeguridadProperties.getVijnanaClientTimeoutConexion(),
				vijnanaSeguridadProperties.getVijnanaClientReadConexion());
		
		AutentificacionResponse autentificacionResponse = clienteRestSeguridad.post(consultaSeguridad, vijnanaSeguridadProperties.getVijnanaServidor(), vijnanaSeguridadProperties.getLocalObtenerUsuarioLogin());

		if(autentificacionResponse!=null && autentificacionResponse.getBasicContext()!=null){
			sessionPlataforma.setDataUsuarioBasic(new HashMap<String, BasicContext>());  
			sessionPlataforma.getDataUsuarioBasic().put(usernamePerfil, autentificacionResponse.getBasicContext());
		}

		return sessionPlataforma;
	}

}
