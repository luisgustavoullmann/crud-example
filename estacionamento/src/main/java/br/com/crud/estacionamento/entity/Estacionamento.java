package br.com.crud.estacionamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ESTACIONAMENTO")
public class Estacionamento {
	
	@Id
	@Column(name="cd_estacionamento")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estacionamento")
	@SequenceGenerator(name="estacionamento", sequenceName="SQ_T_ESTACIONAMENTO", allocationSize = 1)
	private int id;
	
	@Column(name="nm_estacionamento", nullable=false, length=100)
	private  String nome;
	
	@Column(name="ds_endereco", nullable=false)
	private String endereco;
	
	@Column(name="nr_vaga")
	private int vagas;
	
	@Column(name="vl_estacionamento")
	private double preco;

	public Estacionamento() {}

	public Estacionamento(int id, String nome, String endereco, int vagas, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.vagas = vagas;
		this.preco = preco;
	}

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + vagas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (vagas != other.vagas)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estacionamento [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", vagas=" + vagas
				+ ", preco=" + preco + "]";
	}
	
	
	
}
