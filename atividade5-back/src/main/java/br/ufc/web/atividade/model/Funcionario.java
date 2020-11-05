package br.ufc.web.atividade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue
	int id;
	String nome;
	String cargo;
	String nascimento;
	String data;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Funcionario(int id, String nome, String cargo, String nascimento, String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.nascimento = nascimento;
		this.data = data;
	}
	
	public Funcionario(String nome, String cargo, String nascimento, String data) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.nascimento = nascimento;
		this.data = data;
	}
	public Funcionario() {
	}
	
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cargo=" + cargo + ", nascimento=" + nascimento
				+ ", data=" + data + "]";
	}
	
	
}
