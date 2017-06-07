package br.com.fiap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="pedido", catalog="SCJPER2", uniqueConstraints =
{
		@UniqueConstraint(columnNames="idpedido")
})

public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="idpedido", unique=true, nullable=false)
	private int idCliente;
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "idcliente") 
	private Cliente cliente;
	@Column(name="data", unique=false, nullable=false, length=45) 
	private Date data;
	@Column(name="descricao", unique=false, nullable=false, length=45) 
	private String descricao;
	@Column(name="valor", unique=false, nullable=false) 
	private double valor;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}