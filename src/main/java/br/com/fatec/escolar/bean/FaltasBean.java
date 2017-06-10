package br.com.fatec.escolar.bean;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fatec.escolar.dao.FaltasDAO;
import br.com.fatec.escolar.domain.Faltas;
import br.com.fatec.escolar.domain.Notas;
import br.com.fatec.escolar.relatorio.RelatorioNotas;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped


public class FaltasBean implements Serializable{
	private Faltas falta;
	List <Faltas> faltas;
	

	public Faltas getFalta() {
		return falta;
	}


	public void setFalta(Faltas falta) {
		this.falta = falta;
	}


	public List<Faltas> getFaltas() {
		return faltas;
	}


	public void setFaltas(List<Faltas> faltas) {
		this.faltas = faltas;
	}


	@PostConstruct

	public void listar(){
		
		try {
			FaltasDAO faltasDAO=new FaltasDAO();
			faltas=faltasDAO.listar();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	public void novo(){
		Faltas n =new Faltas();
	}
	public void salvar(){
		
		try {
			
	    FaltasDAO faltasDAO=new FaltasDAO();
	    //faltasDAO.inserir(falta);
		novo();
		faltas=faltasDAO.listar();
//		Messages.addGlobalInfo("Registro Salvo");
		
		
			
		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro salvar registro");
			e.printStackTrace();
		}
	}
	public void editar(ActionEvent evento){
		falta=(Faltas) evento.getComponent().getAttributes().get("notaSelecionado");
		
	}
	public void getRelatorio() {
		
		
	}
	
}
