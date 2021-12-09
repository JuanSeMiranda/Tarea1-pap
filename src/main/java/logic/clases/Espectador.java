package logic.clases;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("E")
public class Espectador extends Usuario {
	//@OneToMany(cascade = CascadeType.ALL)
	//private List<Registro> registros = new ArrayList<>();

	public Espectador() {
		super();
	}

	public Espectador(String nickname, String nombre, String apellido, String correo, Date fechaNac) {
		super(nickname, nombre, apellido, correo, fechaNac);
	}
	
	//public void agregarRegistro(Registro registro) {
		//this.registros.add(registro);
	//}
	
}