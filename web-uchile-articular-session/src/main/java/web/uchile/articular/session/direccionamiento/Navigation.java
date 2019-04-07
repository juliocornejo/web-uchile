package web.uchile.articular.session.direccionamiento;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

public class Navigation {
    
//	private static final Logger objLog = LoggerFactory.getLogger(Navigation.class);
	
     public static String redirectInterno(String link) {
//    	 objLog.info("INI - redirectInterno "+link);
    	 //Formato de linkInterno "/emision/pages/facturaExentaElectronica.xhtml"
    	//Traerlas desde un Parametro o desde un Xml
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extContext = ctx.getExternalContext();
        //se le agrega el encodeActionUrl
        String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, link));
        
        try {
                extContext.redirect(url);
            } catch (IOException ioe) {
                throw new FacesException(ioe);

            }
            return null;
      }
     
     public static String redirectExterno(String linkExterno) {
//    	 objLog.info("INI - redirectExterno "+linkExterno);
         //Formato de linkExterno http://www.google.com;
    	//Traerlas desde un Parametro o desde un Xml
    	 FacesContext ctx = FacesContext.getCurrentInstance();
             try {
            	 ctx.getExternalContext().redirect(linkExterno);
             } catch (IOException ioe) {
                 throw new FacesException(ioe);
             }
             return null;
     
       }
     
}


