package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import utilidades.Conexao;

public class Ipva {
	private Integer id;
	private Integer ano;

	
	public Ipva(Integer ano) {
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String ComIpva() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		int comIpva = 0;
		String qntRetorno = "";
		try {
			PreparedStatement preStat = connection.prepareStatement("select carros.ano "
					+ "from carros "
					+ "join ipva "
					+ "on carros.ano <= ipva.ano");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				comIpva++;
				 qntRetorno = String.valueOf(comIpva);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qntRetorno;
		
	}
	
	public String SemIpva() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		int semIpva = 0;
		String qntRetorno = "";
		try {
			PreparedStatement preStat = connection.prepareStatement("select carros.ano "
					+ "from carros "
					+ "join ipva "
					+ "on carros.ano > ipva.ano");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				semIpva++;
				 qntRetorno = String.valueOf(semIpva);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qntRetorno;

	}
	
	public String retornaAno(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		String ano = "";
		try {
			PreparedStatement preStat = connection.prepareStatement("select ipva.ano from ipva");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				ano = resultSet.getString("ano");
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ano;
	}

}
