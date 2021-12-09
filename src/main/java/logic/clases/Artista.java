package logic.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("A")
public class Artista extends Usuario{
	private String descripcion;
	private String link;
	private String biografia;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Funcion> funciones = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Espectaculo> espectaculos = new ArrayList<>();
	
	public Artista() {
		super();
	}

	public Artista(String nickname, String nombre, String apellido, String correo, Date fechaNac, String descripcion, String link, String biografia) {
		super(nickname, nombre, apellido, correo, fechaNac);
		this.descripcion = descripcion;
		this.link = link;
		this.biografia = biografia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public void agregarParticipacionDeFuncion(Funcion funcion) {
		this.funciones.add(funcion);
	}
	
	public void agregarEspectaculo(Espectaculo espectaculo) {
		this.espectaculos.add(espectaculo);
	}

}
