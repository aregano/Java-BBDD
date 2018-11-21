package com.andresbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;

public class CuentaDAO {

	private static CuentaDAO instance = null;

	public static CuentaDAO getInstance() throws Exception {
		if (instance == null)
			instance = new CuentaDAO();

		return instance;
	}

	private CuentaDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
	}
	
	public Cuenta getCuentaByCid(int cidrec) throws SQLException {
		Cuenta resCuenta=null;
		
		String url = "jdbc:mysql://localhost/cuenta";
		
// 		Crear driver
		
		Connection conn = DriverManager.getConnection(url, "root", "root");
				
//		java.sql establecer que statements poner dentro del driver. Especificar los campos en SELECT para saber encontrarlos
		
		String sql = "SELECT cid, nombre, numero, saldo FROM cuenta WHERE cid=?";
		
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1, cidrec);
		
		ResultSet rs = psmt.executeQuery();
		
		System.out.println("ResultSet; "+rs);
		
//		usamos un while porque desconocemos el tamaño de los datos que vamos a recibir, y pedimos los campos con getInt/getString etc.
		
		while(rs.next()) {
			System.out.println("ResultSet:"+rs.getInt(1));
			resCuenta = new Cuenta(
					rs.getInt(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getDouble(4));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
		return resCuenta;

	}
}
