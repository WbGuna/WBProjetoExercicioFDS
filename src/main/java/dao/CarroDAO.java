package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Carro;
import utilidades.Conexao;



public class CarroDAO {
	
	
	public CarroDAO() {
		
	}
	
	public void addCarro(Carro newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into carros (modelo, cor, ano) values (?,?,?)");
			preStat.setString(1, newUser.getModelo());
			preStat.setString(2, newUser.getCor());
			preStat.setDouble(3, newUser.getAno());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		
	public ArrayList<Carro> getListCarro(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Carro> lista = new ArrayList<Carro>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from carros");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id");
				String modelo = resultSet.getString("modelo");
				String cor = resultSet.getString("cor");
				String ano = resultSet.getString("ano");
				Carro carro = new Carro(modelo, cor, Integer.parseInt(ano));
				carro.setId(id2);
				lista.add(carro);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
		
	public void removeCarro(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from carros where id = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCarro(Carro updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update carros set modelo = ?, cor = ?, ano = ? where id = ?");
			preStat.setString(1, updateUser.getModelo());
			preStat.setString(2, updateUser.getCor());
			preStat.setDouble(3, updateUser.getAno());
			preStat.setInt(4, updateUser.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public Carro buscarCarro(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Carro carro = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from carros where id = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				
				Integer ida = resultSet.getInt("id");
				String modelo = resultSet.getString("modelo");
				String cor = resultSet.getString("cor");
				String ano = resultSet.getString("ano");
				carro = new Carro(modelo, cor, Integer.parseInt(ano));
				carro.setId(ida);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return carro;
	}
	
	public String Quantidade() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		int carros = 0;
		String qntRetorno = "";
		try {
			PreparedStatement preStat = connection.prepareStatement("select carros.id from carros");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				carros++;
				 qntRetorno = String.valueOf(carros);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qntRetorno;
		
	}
	
}
