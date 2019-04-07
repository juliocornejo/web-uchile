package web.uchile.articular.session.model;

import java.io.Serializable;

import com.manashiki.uchilearte.servdto.dto.entities.formulario.ArchivoSolicitudDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.ProgramaUniversidadDTO;
import com.manashiki.uchilearte.servdto.dto.entities.formulario.TipoSolicitudDTO;

public class SolicitudAcademicaModel implements Serializable {

	private static final long serialVersionUID = -94497543430452141L;
	private String nombrePersonaSolicitudAcademica ="";
	private String apellidoPaternoPersonaSolicitudAcademica ="";
	private String apellidoMaternoPersonaSolicitudAcademica =""; 
	private String rutPersonaSolicitudAcademica ="";
	private int idProgramaUniversidad = 0;
	private String programaUniversidad = "";
	private String mailMember =""; //mail usuario
	private String anhoIngreso =""; 
	private int idTipoSolicitud = 0;
	private String tipoSolicitud = "";
	private String fundamentacionSolicitud =""; //mail usuario
	/**********************************************************/
	private boolean archivoAdjunto;
	private String nombreArchivo;
	private int idArchivoSolicitud;
	/**********************************************************/

	private ProgramaUniversidadDTO programaUniversidadDTO;
	private TipoSolicitudDTO tipoSolicitudDTO;
	
	private ArchivoSolicitudDTO archivo;
	

	/*los gets y sets*/

	public String getNombrePersonaSolicitudAcademica() {
		return nombrePersonaSolicitudAcademica;
	}

	public void setNombrePersonaSolicitudAcademica(String nombrePersonaSolicitudAcademica) {
		this.nombrePersonaSolicitudAcademica = nombrePersonaSolicitudAcademica;
	}

	public String getApellidoPaternoPersonaSolicitudAcademica() {
		return apellidoPaternoPersonaSolicitudAcademica;
	}

	public void setApellidoPaternoPersonaSolicitudAcademica(String apellidoPaternoPersonaSolicitudAcademica) {
		this.apellidoPaternoPersonaSolicitudAcademica = apellidoPaternoPersonaSolicitudAcademica;
	}

	public String getApellidoMaternoPersonaSolicitudAcademica() {
		return apellidoMaternoPersonaSolicitudAcademica;
	}

	public void setApellidoMaternoPersonaSolicitudAcademica(String apellidoMaternoPersonaSolicitudAcademica) {
		this.apellidoMaternoPersonaSolicitudAcademica = apellidoMaternoPersonaSolicitudAcademica;
	}

	public String getRutPersonaSolicitudAcademica() {
		return rutPersonaSolicitudAcademica;
	}

	public void setRutPersonaSolicitudAcademica(String rutPersonaSolicitudAcademica) {
		this.rutPersonaSolicitudAcademica = rutPersonaSolicitudAcademica;
	}

	public int getIdProgramaUniversidad() {
		return idProgramaUniversidad;
	}

	public void setIdProgramaUniversidad(int idProgramaUniversidad) {
		this.idProgramaUniversidad = idProgramaUniversidad;
	}

	public String getProgramaUniversidad() {
		return programaUniversidad;
	}

	public void setProgramaUniversidad(String programaUniversidad) {
		this.programaUniversidad = programaUniversidad;
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

	public int getIdTipoSolicitud() {
		return idTipoSolicitud;
	}

	public void setIdTipoSolicitud(int idTipoSolicitud) {
		this.idTipoSolicitud = idTipoSolicitud;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getFundamentacionSolicitud() {
		return fundamentacionSolicitud;
	}

	public void setFundamentacionSolicitud(String fundamentacionSolicitud) {
		this.fundamentacionSolicitud = fundamentacionSolicitud;
	}

	public boolean isArchivoAdjunto() {
		return archivoAdjunto;
	}

	public void setArchivoAdjunto(boolean archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public int getIdArchivoSolicitud() {
		return idArchivoSolicitud;
	}

	public void setIdArchivoSolicitud(int idArchivoSolicitud) {
		this.idArchivoSolicitud = idArchivoSolicitud;
	}

	public ProgramaUniversidadDTO getProgramaUniversidadDTO() {
		return programaUniversidadDTO;
	}

	public void setProgramaUniversidadDTO(ProgramaUniversidadDTO programaUniversidadDTO) {
		this.programaUniversidadDTO = programaUniversidadDTO;
	}

	public TipoSolicitudDTO getTipoSolicitudDTO() {
		return tipoSolicitudDTO;
	}

	public void setTipoSolicitudDTO(TipoSolicitudDTO tipoSolicitudDTO) {
		this.tipoSolicitudDTO = tipoSolicitudDTO;
	}

	public ArchivoSolicitudDTO getArchivo() {
		return archivo;
	}

	public void setArchivo(ArchivoSolicitudDTO archivo) {
		this.archivo = archivo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


	
	
	

	
	

	
	

}
