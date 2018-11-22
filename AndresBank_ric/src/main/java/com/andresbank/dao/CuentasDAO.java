package com.andresbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.andresbank.ddbb.DDBB;
import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;

public class CuentasDAO {


		private static CuentasDAO instance = null;

		public static CuentasDAO getInstance() throws Exception {
			if (instance == null)
				instance = new CuentasDAO();

			return instance;
		}

		private CuentasDAO() throws Exception {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
		}
		
		public ArrayList<Cuenta> getCuentasByDni(String dni) throws SQLException{
			ArrayList<Cuenta> resCuentas= new ArrayList<Cuenta>();
					
			String url = "jdbc:mysql://localhost/cliente";
		
			Connection conn = DriverManager.getConnection(url, "root", "root");

			String sql = "SELECT c.cid, c.nombre, c.numero, c.saldo FROM cuenta c, cliente_cuenta cc, cliente cl WHERE cc.cliente=cl.uid AND c.cid=cc.cuenta AND cl.dni=?";

			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dni);
			
			ResultSet rs = psmt.executeQuery();
			
			System.out.println("ResultSet; "+rs);
			
//			usamos un while porque desconocemos el tamaño de los datos que vamos a recibir, y pedimos los campos con getInt/getString etc.
			
			while(rs.next()) {
				System.out.println("ResultSet: "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4));
				resCuentas.add(new Cuenta(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4)));
			}
			
			System.out.println("ArrayList Resultante: "+resCuentas);
			
			rs.close();
			psmt.close();
			conn.close();
			
			return resCuentas;

			
			
		}
	

}
