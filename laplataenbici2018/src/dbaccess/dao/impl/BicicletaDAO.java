package dbaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import dbaccess.dto.BicicletaDTO;
import dbaccess.dto.EstacionDTO;
import model.Bicicleta;
import model.Estacion;

public class BicicletaDAO extends GenericDAO{

	public Integer create(Bicicleta bici){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().persist(bici);
		this.getEntityManager().getTransaction().commit();
		return bici.getId();

	} 
	
	public BicicletaDTO getBicicleta(Integer id){
		Bicicleta bicicleta = null;
		BicicletaDTO bicicletaDTO = null;
		System.out.println("valor de id antes de la query: " + id);
		String query = "from Bicicleta a where a.id = :id ";
		if (!this.getEntityManager().createQuery(query).setParameter("id", id).getResultList().isEmpty()){
		bicicleta = (Bicicleta)this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		}
		if (bicicleta != null){
			 bicicletaDTO = new BicicletaDTO(bicicleta);
					}
		System.out.println("valor de nombre de bicicletaDTO despues de la query" + bicicletaDTO.getNumeroCuadro());
		return bicicletaDTO;
		
	}
	
	public Bicicleta findById(Integer id){	
		String query = "from Bicicleta a where a.id = :id ";
		Bicicleta bici = (Bicicleta) this.getEntityManager().createQuery(query).setParameter("id", id).getSingleResult();
		return bici;
	}
	
	public void update(Bicicleta bici){	
		this.getEntityManager().getTransaction().begin();
		Bicicleta biciTemp = this.findById(bici.getId());
		this.getEntityManager().refresh(biciTemp);
		this.getEntityManager().getTransaction().commit();

	}
	
	public void delete(Bicicleta bici){
		this.getEntityManager().getTransaction().begin();
		this.getEntityManager().remove(bici);
		this.getEntityManager().getTransaction().commit();
	}
	
	public Integer getBicicletasLibres(Estacion estacion){
		String query = "select count (b.id) from Bicicleta b where b.ubicacionActual.nombre  = :nombre ";
		Integer cantidadLibres = estacion.getCantidadBicicletasMax() - Integer.valueOf((this.getEntityManager().createQuery(query).setParameter("nombre", estacion.getNombre()).getSingleResult()).toString()) ;  
		return cantidadLibres;
		
	}

	public List<BicicletaDTO> getAll(){
		String query = "from Bicicleta ";
		@SuppressWarnings("unchecked")
		List<Bicicleta> bicis = (List<Bicicleta>)this.getEntityManager().createQuery(query).getResultList();
		List<BicicletaDTO> bicisDTO = new ArrayList<BicicletaDTO>();
		for(Bicicleta a : bicis){
			bicisDTO.add(new BicicletaDTO(a));
		}
		return bicisDTO;
	}
}
