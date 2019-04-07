package web.uchile.articular.session.model;

import java.io.Serializable;

import com.manashiki.uchilearte.servdto.dto.entities.formulario.FinalidadCertificadoDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoCertificadoDTO;

public class SolicitudCertificadoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombrePersonaSolicitudCertificado;
	private String apellidoPaternoPersonaSolicitudCertificado;
	private String apellidoMaternoPersonaSolicitudCertificado;
	private String rutPersonaSolicitudCertificado;
	private String mailMember;
	private String anhoIngreso;
	private ProgramaUniversidadDTO programa;
	private TipoCertificadoDTO tipoCertificado;
	private FinalidadCertificadoDTO finalidadCertificado;
	
	
	//gets y sets
	public String getNombrePersonaSolicitudCertificado() {
		return nombrePersonaSolicitudCertificado;
	}
	public void setNombrePersonaSolicitudCertificado(String nombrePersonaSolicitudCertificado) {
		this.nombrePersonaSolicitudCertificado = nombrePersonaSolicitudCertificado;
	}
	public String getApellidoPaternoPersonaSolicitudCertificado() {
		return apellidoPaternoPersonaSolicitudCertificado;
	}
	public void setApellidoPaternoPersonaSolicitudCertificado(String apellidoPaternoPersonaSolicitudCertificado) {
		this.apellidoPaternoPersonaSolicitudCertificado = apellidoPaternoPersonaSolicitudCertificado;
	}
	public String getApellidoMaternoPersonaSolicitudCertificado() {
		return apellidoMaternoPersonaSolicitudCertificado;
	}
	public void setApellidoMaternoPersonaSolicitudCertificado(String apellidoMaternoPersonaSolicitudCertificado) {
		this.apellidoMaternoPersonaSolicitudCertificado = apellidoMaternoPersonaSolicitudCertificado;
	}
	public String getRutPersonaSolicitudCertificado() {
		return rutPersonaSolicitudCertificado;
	}
	public void setRutPersonaSolicitudCertificado(String rutPersonaSolicitudCertificado) {
		this.rutPersonaSolicitudCertificado = rutPersonaSolicitudCertificado;
	}
	public String getMailMember() {
		return mailMember;
	}
	public void setMailMember(String mailMember) {
		this.mailMember = mailMember;
	}
	public String getAnhoIngreso() {
		return anhoIngreso;
	}
	public void setAnhoIngreso(String anhoIngreso) {
		this.anhoIngreso = anhoIngreso;
	}
	public ProgramaUniversidadDTO getPrograma() {
		return programa;
	}
	public void setPrograma(ProgramaUniversidadDTO programa) {
		this.programa = programa;
	}
	public TipoCertificadoDTO getTipoCertificado() {
		return tipoCertificado;
	}
	public void setTipoCertificado(TipoCertificadoDTO tipoCertificado) {
		this.tipoCertificado = tipoCertificado;
	}
	public FinalidadCertificadoDTO getFinalidadCertificado() {
		return finalidadCertificado;
	}
	public void setFinalidadCertificado(FinalidadCertificadoDTO finalidadCertificado) {
		this.finalidadCertificado = finalidadCertificado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	

}
