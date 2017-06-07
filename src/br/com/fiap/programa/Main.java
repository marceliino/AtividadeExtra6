package br.com.fiap.programa;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;
import br.com.fiap.helper.Helper;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtividadeExtra6");

		EntityManager em = emf.createEntityManager();
		incluirCliente(em);
		em = emf.createEntityManager();
		listarClientes(em);
		buscarCliente(em, 1);
		em.close();
		System.exit(1);
	}
	
	
	private static void incluirCliente(EntityManager em){ 
		Helper dao = new Helper(em);
		Cliente cliente = new Cliente();
		cliente.setNome("Marcelo SiLva");
		cliente.setEmail("marceliino1@gmail.com");
		
		//1
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setData(new Date());
		pedido.setDescricao("Capacete Shark");
		pedido.setValor(3500);
		cliente.getPedidos().add(pedido);
		
		//2
		Pedido pedido2 = new Pedido();
		pedido2.setCliente(cliente);
		pedido2.setData(new Date());
		pedido2.setDescricao("Jaqueta ");
		pedido2.setValor(2300);	
		cliente.getPedidos().add(pedido2);
		
		try {
			dao.salvar(cliente);
			System.out.println("Cliente " + cliente.getNome() + " inserido com sucesso!"); 
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void listarClientes(EntityManager em){ 
		Helper dao = new Helper(em);
		List<Cliente> clientes = dao.listarClientes(); 
		for (Cliente cliente : clientes) {
			System.out.println("Listando o cliente: " + cliente.getNome() + " - " + cliente.getEmail());
			Iterator<Pedido> iterador = cliente.getPedidos().iterator();
			System.out.println("*** Pedidos do Cliente ****:");
			while (iterador.hasNext()) {
				Pedido pedido = iterador.next();
				System.out.println(pedido.getDescricao());
			}
			System.out.println("*** --------------------- ****:");
		}
	}

	private static void buscarCliente(EntityManager em, Integer idCliente){ 
		Helper dao = new Helper(em);
		Cliente cliente = dao.buscarCliente(idCliente); 
		System.out.println("Buscando o cliente de id: " + cliente.getId() + " - "  + cliente.getNome() + ": " + cliente.getEmail());
	} 
}