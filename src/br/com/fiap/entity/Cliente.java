package br.com.fiap.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "cliente", catalog = "SCJPER2", uniqueConstraints = {
		@UniqueConstraint(columnNames = "idcliente")
})
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcliente", unique=true, nullable=false)
	private int id;
	@Column(name="nome", unique=false, nullable=false, length=45)
	private String nome;
	@Column(name="email", unique=false, nullable=false, length=45)
	private String email;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Pedido> pedidos = new HashSet<Pedido>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}