package com.andresbank.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.andresbank.models.Cliente;

public class ClienteDAOTest extends TestAndres{
	
	@BeforeClass	
	public static void setUpClass() {
		setUpContext();
	}

	@Test
	public void getUserByDNIAndPassVoid(){
		String dni = "";
		String pass ="";
		
		Cliente clienteEncontrado;
		try {
			clienteEncontrado = ClienteDAO.getInstance().getUserByDNIAndPass(dni, pass);
			assertNull(clienteEncontrado);
			

		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		


	}

}
