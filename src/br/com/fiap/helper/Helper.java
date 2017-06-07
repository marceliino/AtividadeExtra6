package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Cliente;

public class Helper {
	private EntityManager em;

	public Helper(EntityManager em){
		this.em = em;
	}

	public void salvar(Cliente cliente) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(cliente); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			throw e;
		} finally { 
			em.close();
		} 
	}

	public List<Cliente> listarClientes(){
		TypedQuery<Cliente> tQuery = em.createQuery("select c from Cliente c", Cliente.class); 
		return tQuery.getResultList();
	}

	public Cliente buscarCliente(Integer idCliente){
		TypedQuery<Cliente> tQuery = em.createQuery("select c from Cliente c where id = :id", Cliente.class);
		tQuery.setParameter("id", idCliente); 
		return tQuery.getSingleResult(); 
	}
}