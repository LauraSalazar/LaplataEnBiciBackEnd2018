package web.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioXml {
	
	@XmlElement
	private Integer Id;
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@XmlElement
	private String habilitado;
	
	@XmlElement
	private String dni;
	
	@XmlElement
	private String apellido;
	
	@XmlElement
	private String nombres;
	
	@XmlElement
	private String domicilio;
	
	@XmlElement
	private String fechaNac;
	
	@XmlElement
	private String sexo;
	
	@XmlElement
	private String mail;

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public UsuarioXml(){}
	
	public UsuarioXml(Integer id, String dni, String apellido, String nombres, String domicilio, String fechaNac, String sexo, String mail, String habilitado){
		super();
		this.setId(id);
		this.setDni(dni);
		this.setApellido(apellido);
		this.setDomicilio(domicilio);
		this.setNombres(nombres);
		this.setFechaNac(fechaNac);
		this.setSexo(sexo);
		this.setMail(mail);
		this.setHabilitado(habilitado);
	}
	
}
