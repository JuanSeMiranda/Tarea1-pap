package datatypes;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class DtEspectaculo {
      
	private String nombre;
	private String descripcion;
	private int duracionMin;
	private int cantMinEspectadores;
	private int cantMaxEspectadores;
	private String url;
	private float costo;
	private Date fechaRegistro;
	private List<DtFuncion> funciones = new ArrayList<DtFuncion>();
	

      public DtEspectaculo() {
            super();
      }

      public DtEspectaculo(String nombre, String descripcion, int duracionMin, int cantMinEspectadores,
			int cantMaxEspectadores, String url, float costo, Date fechaRegistro, ArrayList<DtFuncion> funciones) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionMin = duracionMin;
		this.cantMinEspectadores = cantMinEspectadores;
		this.cantMaxEspectadores = cantMaxEspectadores;
		this.url = url;
		this.costo = costo;
		this.fechaRegistro = fechaRegistro;
        this.funciones = funciones;
	}
      

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return int return the duracionMin
     */
    public int getDuracionMin() {
        return duracionMin;
    }

    /**
     * @return int return the cantMinEspectadores
     */
    public int getCantMinEspectadores() {
        return cantMinEspectadores;
    }

    /**
     * @return int return the cantMaxEspectadores
     */
    public int getCantMaxEspectadores() {
        return cantMaxEspectadores;
    }

    /**
     * @return String return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return float return the costo
     */
    public float getCosto() {
        return costo;
    }

    /**
     * @return Date return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @return ArrayList<String> return the funciones
     */
    public List<DtFuncion> getFunciones() {
        return funciones;
    }

}
