package datatypes;

import java.util.Date;
import java.util.List;

public class DtFuncion {

    private String nombre;
	private Date fecha;
	private int horaInicio;
	private Date fechaRegistro;
	private List<String> artistas;

    public DtFuncion() {}

    public DtFuncion(String nombre, Date fecha, int horaInicio, Date fechaRegistro, List<String> artistas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.fechaRegistro = fechaRegistro;
        this.artistas = artistas;
    }


    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public List<String> getArtistas() {
    	return this.artistas;
    }
}
