package web.uchile.articular.servicio.properties;


import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vijnana.utilidades.component.apiproperties.AppProperties;
import vijnana.utilidades.component.exception.VijnanaUtilidadesException;


class PropertiesServerAplicacion implements Serializable {

	private static final long serialVersionUID = 1L;

	public PropertiesServerAplicacion(){
		super();
	}
	private static final Logger objLog = LoggerFactory.getLogger(PropertiesServerAplicacion.class);

	private static AppProperties appProperties;

	public AppProperties obtenerAppProperties(){

		try{
			if(appProperties == null ){  

				appProperties = new AppProperties();
			}  
		}
		catch(Exception ex){
			objLog.error("Error en la obtencion del appProperties");
		}
		return appProperties; 
	}
	

	
	//app.properties
	public String obtenerAmbiente(){
		AppProperties appProperties = new AppProperties();
		
		String ambiente = null;
		try {
			ambiente = appProperties.getLineaAppProperties("tomcat.ambiente");
		} catch (VijnanaUtilidadesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ambiente;
	}
	
	public String getServerFlujoPagoOnlineActivo() {
		appProperties = obtenerAppProperties();
		
		String retorno = null;
		
		try{
			retorno =appProperties.getLineaAppProperties("flujo.pagoOnline.activo");
		}catch(Exception e){

		}
		return retorno;
	}
	
	public String getServerFlujoCorreoActivo() {
		appProperties = obtenerAppProperties();
		
		String retorno = null;
		
		try{
			retorno =appProperties.getLineaAppProperties("flujo.correo.activo");
		}catch(Exception e){

		}
		return retorno;
	}
	
	

}
