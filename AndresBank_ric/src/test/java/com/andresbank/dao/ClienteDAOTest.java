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

	@Test
	public void getUserByDNIAndPassDNI(){

		String dni = "12345678P";
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
	
	@Test
	public void getUserByDNIAndPassDNIPass(){

		String dni = "12345678R";
		String pass ="0000";
		
		Cliente clienteEncontrado;
		try {
			clienteEncontrado = ClienteDAO.getInstance().getUserByDNIAndPass(dni, pass);
			assertTrue(clienteEncontrado.getDni().equals(dni) && clienteEncontrado.getPin().equals(pass));
			
			

		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		


	}
	
	@Test
	public void getUserByDNIAndPassPass(){

		String dni = "12345678P";
		String pass ="xxx";
		
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
