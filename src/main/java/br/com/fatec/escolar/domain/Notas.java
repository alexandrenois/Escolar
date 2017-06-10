package br.com.fatec.escolar.domain;

public class Notas extends GenericDomain{
	
	private Aluno aluno;
	//private Disciplina disciplina;
	//private Avaliacao avaliacao;
	//private Double nota;
	private Double N1;
	private Double N2;
	private Double trabalho;
	private Double exame;
	private Double mediaFinal;
	private String situacao;
	
	
	public Double getN1() {
		return N1;
	}
	public void setN1(Double n1) {
		N1 = n1;
	}
	public Double getN2() {
		return N2;
	}
	public void setN2(Double n2) {
		N2 = n2;
	}
	public Double getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(Double trabalho) {
		this.trabalho = trabalho;
	}
	public Double getExame() {
		return exame;
	}
	public void setExame(Double exame) {
		this.exame = exame;
	}
	public Double getMediaFinal() {
		return mediaFinal;
	}
	public void setMediaFinal(Double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
//	public Disciplina getDisciplina() {
//		return disciplina;
//	}
//	public void setDisciplina(Disciplina disciplina) {
//		this.disciplina = disciplina;
//	}
//	public Avaliacao getAvaliacao() {
//		return avaliacao;
//	}
//	public void setAvaliacao(Avaliacao avaliacao) {
//		this.avaliacao = avaliacao;
//	}
//	public Double getNota() {
//		return nota;
//	}
//	public void setNota(Double nota) {
//		this.nota = nota;
//	}	

}
