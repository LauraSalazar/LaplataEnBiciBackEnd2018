package web.service;

import java.util.List;

import dbaccess.dao.impl.UsuarioDAO;
import dbaccess.dto.UsuarioDTO;
import model.Usuario;

public class UsuarioService {

	UsuarioDAO usuarioDAO;
	
	public UsuarioService(){
		super();
		usuarioDAO = new UsuarioDAO();
	}
	
	public UsuarioDTO getUsuario(Integer id){
		return (usuarioDAO.getUsuario(id));
	}
	
	public List<UsuarioDTO> getAll(){
		List<UsuarioDTO> usuariosDTO = usuarioDAO.getAll();
		return (usuariosDTO);
	}
	
	public void delete (Integer id){
		Usuario usuario = usuarioDAO.findById(id);
		usuarioDAO.delete(usuario);
	}
	
	public Integer create(String dni,String apellido,String nombres,String domicilio,String fechaNacimiento,String sexo,String mail, String habilitado){
		return usuarioDAO.create(new Usuario(dni,apellido,nombres,domicilio,fechaNacimiento,sexo,mail,habilitado));
	}
	
	public void update(Integer id,String dni,String apellido,String nombres,String domicilio,String fechaNacimiento, String sexo, String mail, String habilitado){
		
		Usuario usuario = usuarioDAO.findById(id); 
		usuario.setApellido(apellido);
		usuario.setDni(dni);
		usuario.setDomicilio(domicilio);
		usuario.setMail(mail);
		usuario.setNombres(nombres);
		usuario.setSexo(sexo);
		usuario.setFechaNac(fechaNacimiento);
		usuario.setHabilitado(habilitado);
		usuarioDAO.update(usuario);
	}
}
