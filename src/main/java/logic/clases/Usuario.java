	package logic.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity(name = "usuario")
@javax.persistence.Table(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	@Id
	private String nickname;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fechaNac;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Compra> compras = new ArrayList<Compra>();
	
	public Usuario() {
		super();
	}

	public Usuario(String nickname, String nombre, String apellido, String correo, Date fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac = fechaNac;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	//public void agregarCompra(Compra compra) {
		//this.compras.add(compra);
	//}

}
