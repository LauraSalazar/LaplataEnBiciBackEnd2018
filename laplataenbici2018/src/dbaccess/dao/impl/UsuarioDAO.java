package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import dbaccess.dto.UsuarioDTO;
import model.Usuario;

public class UsuarioDAO extends GenericDAO{

	public Integer create(Usuario usuario){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(usuario);
		this.getEntityManager().getTransaction().commit();
        return usuario.getId();
	} 
	
	public UsuarioDTO getUsuario(Integer id){
		Usuario usuario = null;
		UsuarioDTO usuarioDTO = null;
		String query = "from Usuario a where a.id = :id ";
		if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()){
		usuario = (Usuario)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		if (usuario != null){
			 usuarioDTO = new UsuarioDTO(usuario);
					}
		return usuarioDTO;
		
	}
	
	public void update(Usuario usuario){
		
		this.getEntityManager().getTransaction().begin();
		Usuario usuarioTemp = this.findById(usuario.getId());
		this.getEntityManager().refresh(usuarioTemp);
		this.getEntityManager().getTransaction().commit();

	}
	
	public void delete(Usuario usuario){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(usuario);
		this.getEntityManager().getTransaction().commit();
	}
	
	public Usuario findById(Integer id){
		String query = "from Usuario a where a.id = :id ";
		Usuario usuario = (Usuario)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		return usuario;	
	}
	

	public List<UsuarioDTO> getAll(){
		String query = "from Usuario";
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) this.getEntityManager().createQuery(query).getResultList();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		for(Usuario a : usuarios){
			usuariosDTO.add(new UsuarioDTO(a));
		}
		return usuariosDTO;
	}


}
