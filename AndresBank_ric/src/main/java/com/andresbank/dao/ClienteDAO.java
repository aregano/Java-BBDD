package com.andresbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.andresbank.models.Cliente;

public class ClienteDAO {

	private static ClienteDAO instance = null;
	
	public static ClienteDAO getInstance() throws Exception {
		if (instance==null) instance=new ClienteDAO();
		
		return instance;
	}
	
	private ClienteDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
	}
	
	public Cliente getUserByDNIAndPass(String dnirec, String passrec) throws SQLException {
		Cliente resCliente=null;
		
		String url = "jdbc:mysql://localhost/cliente";
		
// 		Crear driver
		
		Connection conn = DriverManager.getConnection(url, "root", "root");
				
//		java.sql establecer que statements poner dentro del driver. Especificar los campos en SELECT para saber encontrarlos
		
		String sql = "SELECT uid, nombre, dni, pin, nomina FROM cliente WHERE dni=? AND pin=?";
		
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, dnirec);
		psmt.setString(2, passrec);
		
		ResultSet rs = psmt.executeQuery();
		
		System.out.println("ResultSet; "+rs);
		
//		usamos un while porque desconocemos el tamaño de los datos que vamos a recibir, y pedimos los campos con getInt/getString etc.
		
		while(rs.next()) {
			System.out.println("ResultSet:"+rs.getInt(1)+": "+rs.getString(2));
			resCliente = new Cliente(
					rs.getInt(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getString(4));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
		return resCliente;

	}

	public Cliente getUserByDNI(String dnisess) throws SQLException {
		
		Cliente resCliente=null;
		
		String url = "jdbc:mysql://localhost/cliente";
			
		Connection conn = DriverManager.getConnection(url, "root", "root");
					
		String sql = "SELECT uid, nombre, dni, pin, nomina FROM cliente WHERE dni=?";
		
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, dnisess);
		
		ResultSet rs = psmt.executeQuery();
		
		System.out.println("ResultSet; "+rs);
			
		if(rs.next()) {
			System.out.println("ResultSet:"+rs.getInt(1)+": "+rs.getString(2));
			resCliente = new Cliente(
					rs.getInt(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getString(4)
					);
			
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
		return resCliente;

	}
		
}
