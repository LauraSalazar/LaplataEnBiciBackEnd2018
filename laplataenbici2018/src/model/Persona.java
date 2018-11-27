package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity(name="Persona")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {

	@Column(name="DNI")
	private String dni;
	
	@Column(name="APELLIDO")
	private String apellido;
	
	@Column(name="NOMBRES")
	private String nombres;
	
	@Column(name="DOMICILIO")
	private String domicilio;
	
	@Column(name="FECHA_NAC")
	private String fechaNac;
	
	@Column(name="SEXO")
	private String sexo;
	
	@Column(name="MAIL")
	private String mail;
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	
	@Column(name="ID_PERSONA")
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Persona(){
       super();
	}

}