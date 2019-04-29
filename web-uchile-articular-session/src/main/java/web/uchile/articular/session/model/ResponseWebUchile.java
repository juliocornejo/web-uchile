package web.uchile.articular.session.model;

import java.io.Serializable;
import java.util.List;

public class ResponseWebUchile  implements Serializable{
	//Se obtiene de BasicContext
	private static final long serialVersionUID = -8663566321865575514L;
	
	private String redireccion = ""; //Nombre del Usuario el del eventual login
	private boolean procesoWebUchile;
	private LoginModel loginModel;
	private SolicitudAcademicaModel solicitudAcademicaModel;
	private SolicitudCertificadoModel solicitudCertificadoModel;
	private SolicitudPostulacionModel solicitudPostulacionModel;
	private List<LoginModel> listaLoginModel;
	private List<SolicitudAcademicaModel> listaSolicitudAcademicaModel;
	private List<SolicitudCertificadoModel> listaSolicitudCertificadoModel;
	private List<SolicitudPostulacionModel> listaSolicitudPostulacionModel;
	
	public ResponseWebUchile() {
		super();
	}
	
	public ResponseWebUchile( boolean procesoWebUchile) {
		super();
		this.procesoWebUchile = procesoWebUchile;
	}
	
	public ResponseWebUchile(String redireccion, boolean procesoWebUchile) {
		super();
		this.redireccion = redireccion;
		this.procesoWebUchile = procesoWebUchile;
	}

	public String getRedireccion() {
		return redireccion;
	}

	public void setRedireccion(String redireccion) {
		this.redireccion = redireccion;
	}

	public boolean isProcesoWebUchile() {
		return procesoWebUchile;
	}

	public void setProcesoWebUchile(boolean procesoWebUchile) {
		this.procesoWebUchile = procesoWebUchile;
	}

	public LoginModel getLoginModel() {
		return loginModel;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	public SolicitudAcademicaModel getSolicitudAcademicaModel() {
		return solicitudAcademicaModel;
	}

	public void setSolicitudAcademicaModel(SolicitudAcademicaModel solicitudAcademicaModel) {
		this.solicitudAcademicaModel = solicitudAcademicaModel;
	}

	public SolicitudCertificadoModel getSolicitudCertificadoModel() {
		return solicitudCertificadoModel;
	}

	public void setSolicitudCertificadoModel(SolicitudCertificadoModel solicitudCertificadoModel) {
		this.solicitudCertificadoModel = solicitudCertificadoModel;
	}

	public SolicitudPostulacionModel getSolicitudPostulacionModel() {
		return solicitudPostulacionModel;
	}

	public void setSolicitudPostulacionModel(SolicitudPostulacionModel solicitudPostulacionModel) {
		this.solicitudPostulacionModel = solicitudPostulacionModel;
	}

	public List<LoginModel> getListaLoginModel() {
		return listaLoginModel;
	}

	public void setListaLoginModel(List<LoginModel> listaLoginModel) {
		this.listaLoginModel = listaLoginModel;
	}

	public List<SolicitudAcademicaModel> getListaSolicitudAcademicaModel() {
		return listaSolicitudAcademicaModel;
	}

	public void setListaSolicitudAcademicaModel(List<SolicitudAcademicaModel> listaSolicitudAcademicaModel) {
		this.listaSolicitudAcademicaModel = listaSolicitudAcademicaModel;
	}

	public List<SolicitudCertificadoModel> getListaSolicitudCertificadoModel() {
		return listaSolicitudCertificadoModel;
	}

	public void setListaSolicitudCertificadoModel(List<SolicitudCertificadoModel> listaSolicitudCertificadoModel) {
		this.listaSolicitudCertificadoModel = listaSolicitudCertificadoModel;
	}

	public List<SolicitudPostulacionModel> getListaSolicitudPostulacionModel() {
		return listaSolicitudPostulacionModel;
	}

	public void setListaSolicitudPostulacionModel(List<SolicitudPostulacionModel> listaSolicitudPostulacionModel) {
		this.listaSolicitudPostulacionModel = listaSolicitudPostulacionModel;
	}
	
}
