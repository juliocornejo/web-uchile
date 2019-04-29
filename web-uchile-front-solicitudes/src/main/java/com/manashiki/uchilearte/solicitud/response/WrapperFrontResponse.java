package com.manashiki.uchilearte.solicitud.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import vijnana.respuesta.wrapper.response.AbstractWrapper;
import vijnana.respuesta.wrapper.response.AbstractWrapperError;
import web.uchile.articular.session.model.ResponseWebUchile;

@XmlRootElement(name="frontResponse")
public class WrapperFrontResponse extends AbstractWrapper implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("data")
	private ResponseWebUchile data;
	
	public WrapperFrontResponse() {
		super();

	}
	
	public WrapperFrontResponse(AbstractWrapperError error, String tiempoRespuesta, String url, 
			String tipoMetodo, ResponseWebUchile data){
		super(tiempoRespuesta,  url, error, tipoMetodo);
		this.data = data;
	}

	public ResponseWebUchile getData() {
		return data;
	}

	public void setData(ResponseWebUchile data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "WrapperFrontResponse [tiempoRespuesta=" + tiempoRespuesta + ", url=" + url + ""
				+ ", error=" + error + ", tipoMetodo=" + tipoMetodo + ", data=" + data +"]";
	}
	
}
