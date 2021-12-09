package logic.clases;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "compra")
public class Compra {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date fecha;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nombre_paquete", referencedColumnName = "nombre")
	private Paquete paquete;

	public Compra() {
		super();
	}

	public Compra(Date fecha) {
		super();
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
	
}