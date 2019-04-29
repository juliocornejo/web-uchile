package web.uchile.articular.session.model;

import java.io.Serializable;

public class ServicioModel  implements Serializable{
	//Se obtiene de BasicContext
	private static final long serialVersionUID = -8663566321865575514L;
	
	private int idServicio;
	private String nombreServicio = ""; //Nombre del Usuario el del eventual login
	
	public ServicioModel() {
		super();
	}
	
	public ServicioModel(int idServicio, String nombreServicio) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	
}
