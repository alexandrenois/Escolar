package br.com.fatec.escolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.escolar.domain.Aluno;
import br.com.fatec.escolar.domain.Faltas;


public class FaltasDAO {
//	
	public FaltasDAO() throws SQLException {
		listar();
	}
	
	@SuppressWarnings("unchecked")
	public List<Faltas> listar() throws SQLException{
		
		List datas; 		
		Connection con = JDBC.getInstance().getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM fn_presenca_4(4203010,4)");
		ResultSet rs = pstmt.executeQuery();
		List<Faltas> faltas = new ArrayList<Faltas>();
		while(rs.next()) { 
			Faltas f= new Faltas();
			Aluno a= new Aluno();
			
			a.setCodigo(rs.getInt("ra_aluno"));
			a.setNome(rs.getString("nome_aluno"));

			//f.setCodigo(rs.getInt("ra_aluno"));
			f.setAluno(a);
			//f.getAluno().setNome(rs.getString("nome_aluno"));
			//f.setData(rs.getDate("data"));
			//f.getDisciplina().setCodigo(rs.getLong("idDisciplina"));
			//f.setPresenca(rs.getString("presenca"));
			f.setData1(setFaltas(rs.getDouble("data1")));
			f.setData2(setFaltas(rs.getInt("data2")));
			f.setData3(setFaltas(rs.getInt("data3")));
			f.setData4(setFaltas(rs.getInt("data4")));
			f.setData5(setFaltas(rs.getInt("data5")));
			f.setData6(setFaltas(rs.getInt("data6")));
			f.setData7(setFaltas(rs.getInt("data7")));
			f.setData8(setFaltas(rs.getInt("data8")));
			f.setData9(setFaltas(rs.getInt("data9")));
			f.setData10(setFaltas(rs.getInt("data10")));
			f.setData11(setFaltas(rs.getInt("data11")));
			f.setData12(setFaltas(rs.getInt("data12")));
			f.setData13(setFaltas(rs.getInt("data13")));
			f.setData14(setFaltas(rs.getInt("data14")));
			f.setData15(setFaltas(rs.getInt("data15")));
			f.setData16(setFaltas(rs.getInt("data16")));
			f.setData17(setFaltas(rs.getInt("data17")));
			f.setData18(setFaltas(rs.getInt("data18")));
			f.setData19(setFaltas(rs.getInt("data19")));
			f.setData20(setFaltas(rs.getInt("data20")));
			f.setData21(setFaltas(rs.getInt("data21")));
			f.setData22(setFaltas(rs.getInt("data22")));
			f.setTotalFaltas(rs.getInt("totalFaltas"));
			
			
			faltas.add(f);
		}
		//System.out.println(faltas.size());
		return faltas;
	}
	public String setFaltas(double data){
		
		
		if(data==1){
			return "FFFP";

		}else if(data==2){
			return "FFPP";
		}else if(data==3){
			return "FPPP";
		}else if(data==4){
			return "PPPP";
			
		}else{
			return "FFFF";
		}		
		
		
	}
	
	public String getDatas(String datas) throws SQLException{
		Connection con = JDBC.getInstance().getConnection();
		PreparedStatement pstmt = con.prepareStatement("select distinct data from faltas where codigo_disciplina = 4203010 order by data");
		ResultSet rs = pstmt.executeQuery();
		List<Faltas> faltas = new ArrayList<Faltas>();
		while(rs.next()) {
			
			
		}
		return null;
	}
//	public void inserir(Faltas f) throws SQLException {
//		Connection con = JDBC.getInstance().getConnection();
//		PreparedStatement pstmt = con.prepareStatement("INSERT INTO produto (id, nome, descricao, validade) " +
//														" VALUES (?, ?, ?, ?)");
//		pstmt.setLong(1, f.getCodigo());
//		pstmt.setLong(2, f.getAluno().getCodigo());
//		pstmt.setLong(3, f.getDisciplina().getCodigo());
//		pstmt.setString(4, f.getPresenca());
//		pstmt.setDate(5, (Date) f.getData());
//
//		
//		pstmt.executeUpdate();
//	}
	
	public static void main(String[] args) throws SQLException {
		new FaltasDAO();
	}

}
