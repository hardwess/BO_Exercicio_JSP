package edu.curso.entidades;

import java.io.Serializable;
import java.util.Date;

public class BO implements Serializable {
	private static final long serialVersionUID = 8607665563728340816L;
	
	private long id;
	private String numero = "";
	private String rg = "";
	private String nome = "";
	private String tipo = "";
	private Date dataOcorrencia = new Date();
	private String local = "";
	private String descricao = "";
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}
	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("BO : "  + getNumero() + "\n");
		sb.append("Nome : "  + getNome());
		return sb.toString();
	}
}
