package com.manashiki.uchilearte.solicitud.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class UrlRewriteFilter implements Filter {
	
		private static final Logger logger = Logger.getLogger(UrlRewriteFilter.class);
		private boolean enviado = false;

	   @Override
	    public void init(FilterConfig config) throws ServletException {
	        //
	    }

	    @Override
	    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
	        try{
        	
		    	HttpServletRequest request = (HttpServletRequest) req;
		    	HttpServletResponse response = (HttpServletResponse) res;
		        String requestURI = request.getRequestURI();

		        if (requestURI.endsWith("/administracion") == true){
		        	String url = request.getRequestURL().toString();
					try{
//			    		String[] arraysUrls = url.split("/");
//							if("AR".equals(portal)){
//								request.setAttribute("metaInicial", arraysUrls[4].replace("-", " "));
//								request.setAttribute("metaSubInicial"," Hoteles");
//								request.setAttribute("metaFinal"," Reservá tu estadía en "+ arraysUrls[4].replace("-", " ") +" hoy ");
//								request.setAttribute("ciudad",arraysUrls[5]);
//								request.setAttribute("llamado","ficha");
//								
//							}else{
//								request.setAttribute("metaInicial",arraysUrls[4].replace("-", " "));
								request.setAttribute("ficha"," Hoteles");
//								request.setAttribute("metaFinal"," Reserva tu estadía en "+ arraysUrls[4].replace("-", " ") +" hoy ");	
//								request.setAttribute("ciudad",arraysUrls[5]);
								request.setAttribute("llamado","session");
//								
//							}
						}catch(Exception ex){
							logger.error("Se cae al sacar las url");
						}
		        	
		        	request.getRequestDispatcher("/administracion").forward(request, response);
	            
		        } else {
		        	try{
			            chain.doFilter(req, res);			        		
		        	}catch(Exception ex){
		        		logger.error("reenviando");	
		        	}
 		        }
	        	
	        }catch (Exception e) {
	        	logger.error("Error al momento de redirecionar la url la ficha.", e);	
			}
	    }

	    @Override
	    public void destroy() {
	        //
	    }

		public boolean isEnviado() {
			return enviado;
		}

		public void setEnviado(boolean enviado) {
			this.enviado = enviado;
		}
	    
	    

}