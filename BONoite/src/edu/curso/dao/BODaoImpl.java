package edu.curso.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.curso.entidades.BO;

public class BODaoImpl implements BODao {
	
	private Connection getConnection() {
		try {
			// Obtain our environment naming context
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			// Look up our data source
			DataSource ds = (DataSource) envCtx.lookup("jdbc/DelegaciaDB");
			return ds.getConnection();		
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void adicionar(BO b) {
		Connection con = getConnection();
		String sql = "INSERT INTO bo "
				+ "(id, numero, rg, nome, tipo, data_ocorrencia, local, descricao) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1,  b.getId());
			stmt.setString(2,  b.getNumero());
			stmt.setString(3,  b.getRg());
			stmt.setString(4,  b.getNome());
			stmt.setString(5,  b.getTipo());
			long mili = b.getDataOcorrencia().getTime();
			Date d = new java.sql.Date(mili);
			stmt.setDate(6, d);
			stmt.setString(7,  b.getLocal());
			stmt.setString(8,  b.getDescricao());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BO> pesquisarPorNome(String nome) {
		Connection con = getConnection();
		List<BO> lista = new ArrayList<>();
		String sql = "SELECT * FROM bo WHERE nome like ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				BO b = new BO();
				b.setId( rs.getLong("id") );
				b.setNumero( rs.getString("numero") );
				b.setNome( rs.getString("nome") );
				b.setRg( rs.getString("rg") );
				b.setTipo( rs.getString("tipo") );
				b.setDataOcorrencia( rs.getDate("data_ocorrencia") );
				b.setLocal( rs.getString("local") );
				b.setDescricao( rs.getString("descricao") );
				lista.add( b );
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
