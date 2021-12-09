package logic.clases;

import java.util.Date;

public class Registro {
	private Date fecha;
	private boolean pertenecePaquete;
	private float costo;
	private Registro registro;
	private Funcion funcion;
	
	public Registro() {
		super();
	}

	public Registro(Date fecha, boolean pertenecePaquete, float costo, Registro registro, Funcion funcion) {
		super();
		this.fecha = fecha;
		this.pertenecePaquete = pertenecePaquete;
		this.costo = costo;
		this.registro = registro;
		this.funcion = funcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isPertenecePaquete() {
		return pertenecePaquete;
	}

	public void setPertenecePaquete(boolean pertenecePaquete) {
		this.pertenecePaquete = pertenecePaquete;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}	
	
	
}
