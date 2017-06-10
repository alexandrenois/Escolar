package br.com.fatec.escolar.relatorio;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;


import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;


public class RelatorioFaltas <T>{
	
	private HttpServletResponse response;
	private FacesContext context;
	private Connection con;
	
	public RelatorioFaltas() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) this.context.getExternalContext().getResponse();
	}
	public void getRelatorioNotas(List<T> lista){
		try{
			
			InputStream stream = this.getClass().getResourceAsStream("/resources/Faltas2.jasper");
			
			Map<String, Object> params = new HashMap<String, Object>();
			
			ByteArrayOutputStream baos= new ByteArrayOutputStream();
			
			JRBeanCollectionDataSource datasrc = new JRBeanCollectionDataSource(lista);
			
			JasperReport jasper = (JasperReport) JRLoader.loadObject(stream);
			
			//para usar JavaBeanDataSource define 'datasrc' como datasource
			JasperPrint print = JasperFillManager.fillReport(jasper, params, getConexao());
			
			JasperExportManager.exportReportToPdfStream(print, baos);
			
			response.reset();
			
			response.setContentType("application/pdf");
			
			response.setContentLength(baos.size());
			
			response.setHeader("Content-disposition","inline; filename=relatorioNotas.pdf");
			
			response.getOutputStream().write(baos.toByteArray());
			
			response.getOutputStream().flush();
			
			response.getOutputStream().close();
			
			context.responseComplete();
			
			closeConnection();
			
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro ao gerar o relatorio!"));
			e.printStackTrace();
		}
		
		
	}
	private Connection getConexao(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433/Escola", "host", "host");
			return con;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	private void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	


}
