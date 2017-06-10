package br.com.fatec.escolar.domain;
import javax.persistence.Entity;
@Entity
public class Aluno extends GenericDomain{
	
	
	private String nome;	
	private int raAluno;
	
	public int getRaAluno() {
		return raAluno;
	}

	public void setRaAluno(int raAluno) {
		this.raAluno = raAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
