package com.andresbank.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	
//	protected solo permite usar las variables en los archivos que se encuentran en los mismos paquetes
	
	protected String driverclass = "com.mysql.jdbc.Driver";
	protected String url = "jdbc:mysql://localhost/cliente";
	protected DataSource datasource = null;
	

	protected DAO() throws Exception {
		Class.forName(driverclass).newInstance();
		
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		datasource = (DataSource) envContext.lookup("jdbc/andresbbdd");
		

	}
}
