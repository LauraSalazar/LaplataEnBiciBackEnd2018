package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.type.CustomType;

import com.fasterxml.jackson.annotation.JsonProperty;

import dbaccess.dao.impl.BicicletaDAO;
import dbaccess.dao.impl.PrestamoDAO;
import model.Persona;

@Entity(name="Usuario")
public class Usuario extends Persona {

	@Column(name="HABILITADO")
	private String habilitado;
	
	@OneToMany
	private List<Bicicleta> bicicletas =  new ArrayList<Bicicleta>();

	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(List<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}
	
	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	

	public Usuario(String dni, String apellido, String nombres, String domicilio, String fechaNac, String sexo, String mail, String habilitado){
		super();
		this.setDni(dni);
		this.setApellido(apellido);
		this.setDomicilio(domicilio);
		this.setNombres(nombres);
		this.setFechaNac(fechaNac);
		this.setSexo(sexo);
		this.setMail(mail);
		this.setHabilitado(habilitado);
	}
	
	public Usuario(){
		
	}
	
	public void retirarBicicleta(String fechaInicio, String fechaFin, Bicicleta bici){
		BicicletaDAO bicicletaDAO = new BicicletaDAO(); 
		Integer cantidadLibres = bicicletaDAO.getBicicletasLibres(bici.getUbicacionActual());
		if(cantidadLibres>0){
		Prestamo prestamo = new Prestamo(fechaInicio,fechaFin,this, bici);
		PrestamoDAO prestamoDAO = new PrestamoDAO();
		prestamoDAO.create(prestamo);
		
		}
	}

}