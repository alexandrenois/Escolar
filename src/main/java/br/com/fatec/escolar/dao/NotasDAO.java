package br.com.fatec.escolar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.escolar.domain.Aluno;
import br.com.fatec.escolar.domain.Notas;

public class NotasDAO {
	@SuppressWarnings("unchecked")
	public List<Notas> listar() throws SQLException{
	
		Connection con = JDBC.getInstance().getConnection();
		PreparedStatement pstmt = con.prepareStatement("SELECT ra_aluno, nome_aluno,N1,N2,Trabalho,Exame,mediaFinal,situacao FROM fn_notas(4203010) ORDER BY nome_aluno");
		ResultSet rs = pstmt.executeQuery();
		List<Notas> notas = new ArrayList<Notas>();
		while(rs.next()) { 
			Notas n = new Notas();
			Aluno a= new Aluno();
			a.setCodigo(rs.getInt("ra_aluno"));
			a.setNome(rs.getString("nome_aluno"));
			n.setAluno(a);
			n.setExame(rs.getDouble("Exame"));
			n.setN1(rs.getDouble("N1"));
			n.setN2(rs.getDouble("N2"));
			n.setMediaFinal(rs.getDouble("mediaFinal"));
			n.setSituacao(rs.getString("situacao"));
			n.setTrabalho(rs.getDouble( "trabalho"));

			
			
			//n.setCodigo(rs.getInt("id") );
			//n.getAluno().setCodigo(rs.getInt("idAluno") );
			//n.getAvaliacao().setCodigo(rs.getInt("idAvaliacao") );
			//n.setNota(rs.getDouble("nota"));
			
			
			notas.add(n);
			
		}
		return notas;
	}
//	public void inserir(Notas n) throws SQLException {
//		Connection con = JDBC.getInstance().getConnection();
//		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM fn_nota_aoc_bd_lw(4203010) ORDER BY nome_aluno");
//		pstmt.setLong(1, n.getCodigo());
//		pstmt.setLong(2, n.getAluno().getCodigo());
//		pstmt.setLong(3, n.getAvaliacao().getCodigo());
//		pstmt.setDouble(4, n.getNota());
//		pstmt.executeUpdate();
//	}

}
