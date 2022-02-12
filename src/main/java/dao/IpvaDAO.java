package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Ipva;
import utilidades.Conexao;



public class IpvaDAO {
	
	
	public IpvaDAO() {
		
	}
	
	public void addIpva(Ipva newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into ipva (ano) values (?)");
			preStat.setDouble(1, newUser.getAno());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		
	public ArrayList<Ipva> getListIpva(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Ipva> lista = new ArrayList<Ipva>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from ipva");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id_ipva");
				String ano = resultSet.getString("ano");
				Ipva ipva = new Ipva(Integer.parseInt(ano));
				ipva.setId(id2);
				lista.add(ipva);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void updateIpva(Ipva updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update ipva set ano = ? where id_ipva = ?");
			preStat.setDouble(1, updateUser.getAno());
			preStat.setInt(2, updateUser.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public Ipva buscarIpva(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Ipva ipva = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from ipva where id_ipva = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer ida = resultSet.getInt("id_ipva");
				String ano = resultSet.getString("ano");
				ipva = new Ipva(Integer.parseInt(ano));
				ipva.setId(ida);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ipva;
	}
	
}