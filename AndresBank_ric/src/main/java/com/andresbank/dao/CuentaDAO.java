package com.andresbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;
import com.mysql.jdbc.Statement;

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
		
		String url = "jdbc:mysql://localhost/cliente";
		
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

	public int crearCuenta(Cuenta cuenta, Cliente cliente) throws SQLException {
		int cidres = 0;
		
		String url = "jdbc:mysql://localhost/cliente";

		Connection conn = DriverManager.getConnection(url, "root", "root");
		
		String sql = "INSERT INTO `cuenta` ( `nombre`, `numero`, `saldo`) VALUES (?, ?, ?)";
//	Para que te devuelva las claves generadas de la base de datos
		PreparedStatement psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		psmt.setString(1, cuenta.getNombre());
		psmt.setString(2, cuenta.getNumero());
		psmt.setDouble(3, cuenta.getSaldo());
		
		
		psmt.executeUpdate();
		
			
		ResultSet rs = psmt.getGeneratedKeys();
		
		if(rs.next()) {
			cidres = rs.getInt(1);
		}
		
		psmt.close();
		rs.close();
		
//	INSERTAR CLIENTE-CUENTA
		String sql1 = "INSERT INTO `cliente_cuenta` ( `cliente`, `cuenta`) VALUES (?, ?)";
		psmt = conn.prepareStatement(sql1);
		psmt.setInt(1,  cliente.getUid());
		psmt.setInt(2, cidres);
		
		psmt.executeUpdate();
		psmt.close();
		
		conn.close();
		
		System.out.println("ResultSet; "+rs);
		
		return cidres;
		
	}
}
