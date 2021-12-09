package logic.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import datatypes.DtFuncion;
import logic.manejadores.ManejadorUsuario;

@Entity(name = "funcion")
@javax.persistence.Table(name = "funcion")
public class Funcion {
	@Id
	private String nombre;
	private Date fecha;
	private int horaInicio;
	private Date fechaRegistro;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Artista> artistas = new ArrayList<>();
	
	public Funcion() {
		super();
	}

	public Funcion(String nombre, Date fecha, int horaInicio, Date fechaRegistro) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public void agregarArtista(String nomArtista) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Artista artista;
		if(mu.esArtista(nomArtista)) {
			artista = (Artista) mu.buscarUsuario(nomArtista);
			this.artistas.add(artista);
		}
	}
	
	public List<String> listarNicksArtistas() {
		List<String> listaResultado = new ArrayList<>();
		
		for(Artista artista: this.artistas) {
			listaResultado.add(artista.getNickname());
		}
		
		return listaResultado;
	}
	
	//methods

    //devuelve los datos en forma de Dt de la Funcion

    public DtFuncion getData() {

		DtFuncion newDtFuncion = new DtFuncion(nombre, fecha, horaInicio, fechaRegistro, this.listarNicksArtistas());

        return newDtFuncion;
    }

}
