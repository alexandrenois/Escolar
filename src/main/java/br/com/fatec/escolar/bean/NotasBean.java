                      package br.com.fatec.escolar.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.fatec.escolar.dao.NotasDAO;
import br.com.fatec.escolar.domain.Notas;
import br.com.fatec.escolar.relatorio.RelatorioNotas;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class NotasBean implements Serializable {

	private Connection con;
	private Notas nota;

	public Notas getNota() {
		return nota;
	}

	public void setNota(Notas nota) {
		this.nota = nota;
	}

	public List<Notas> getNotas() {
		return notas;
	}

	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}

	List<Notas> notas;

	public void novo() {
		Notas n = new Notas();
	}

	@PostConstruct
	public void listar() {

		try {
			NotasDAO notasDAO = new NotasDAO();
			notas = notasDAO.listar();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// public void salvar(){
	//
	// try {
	//
	// NotasDAO notasDAO=new NotasDAO();
	// notasDAO.inserir(nota);
	// novo();
	// notas=notasDAO.listar();
	//// Messages.addGlobalInfo("Registro Salvo");
	//
	//
	//
	// } catch (Exception e) {
	// Messages.addGlobalError("Ocorreu um erro salvar registro");
	// e.printStackTrace();
	// }
	// }
	public void editar(ActionEvent evento) {
		nota = (Notas) evento.getComponent().getAttributes().get("medicamentoSelecionado");

	}

	public void getRelatorio() {

		 RelatorioNotas<Notas> report = new RelatorioNotas<Notas>();
		 if (notas.size() > 0) {
		 report.getRelatorioNotas(notas);
		 }else{
		 FacesContext.getCurrentInstance().addMessage(null, new
		 FacesMessage("Não há registros!"));
		 }
//		try {
//			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
//
//			Map<String, Object> filtros=tabela.getFilters();
//			Map<String, Object> parameters = new HashMap<>();
//			String path = Faces.getRealPath("/report/Notas.jasper");
//			JasperFillManager.fillReport(path, parameters, getConexao());
//
//		} catch (JRException e) {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao gerar o relatorio!"));
//			e.printStackTrace();
//		}

	}

	private Connection getConexao() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Escola", "alexandre", "123456");
			return con;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}