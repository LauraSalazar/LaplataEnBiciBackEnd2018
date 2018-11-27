package web.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BicicletaXml {
	
	@XmlElement
	private Integer id;
	@XmlElement
	private String fechaIngreso;
	@XmlElement
	private String estado;
	@XmlElement
	private String numeroCuadro;

	@XmlElement
	//Nombre de la estacion donde se encuentra la bicicleta
	private String ubicacionActual;
	
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroCuadro() {
		return numeroCuadro;
	}
	public void setNumeroCuadro(String numeroCuadro) {
		this.numeroCuadro = numeroCuadro;
	}

	public BicicletaXml(){}
	
	public BicicletaXml(Integer id, String fechaIngreso, String estado, String estacionNombre){
		super();
		this.setId(id);
		this.setFechaIngreso(fechaIngreso);
		this.setEstado(estado);
		this.setUbicacionActual(estacionNombre);

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUbicacionActual() {
		return ubicacionActual;
	}
	public void setUbicacionActual(String ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}

}
