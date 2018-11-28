package com.ricardo.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ricardo.models.Role;

public class RoleManagerTest {

	@Test
	public void testInputNull() {
		Role unRol=null;
		try {
			int idr = RoleManager.getInstance().createRole(unRol);
			assertEquals(idr, 0);
		} catch (Exception e) {
			fail("Exception:"+e.getMessage());
		}
	}

}
