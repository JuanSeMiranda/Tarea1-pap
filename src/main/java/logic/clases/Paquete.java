package logic.clases;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtPaquete;
import datatypes.DtVigencia;

@Entity(name = "paquete")
@javax.persistence.Table(name = "paquete")
public class Paquete {
	@Id
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private float descuento;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Espectaculo> espectaculos = new ArrayList<Espectaculo>();
	
	public Paquete() {
		super();
	}

	public Paquete(String nombre, String descripcion, Date fechaInicio, Date fechaFin, float descuento) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}
	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	//methods

	//Se busca si la lista de espectaculos tiene al espectaculo nombreEspectaculo
	public boolean paqueteEspectaculo(String nombreEspectaculo) {
		Iterator<Espectaculo> iterator = espectaculos.iterator();
		Espectaculo show = espectaculos.get(0);

		while (iterator.hasNext() && !show.getNombre().equals(nombreEspectaculo)) {
			show = iterator.next();
		}

		if (iterator.hasNext()) {
			return true;
		}

		return false;
	}


	public DtPaquete getData() {

		//DtPaquete newDtPaquete = new DtPaquete(nombre, descripcion, vigencia, descuento);

		return null;

	}
	
}
