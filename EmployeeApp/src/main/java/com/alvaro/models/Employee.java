package com.alvaro.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(name="FirstName")
		private String nombre;
		@Column(name="LastName")
		private String apellido;
		
//		@OneToMany(mappedBy="employee")
//		private List<Role> roles;
		
		@ManyToMany (cascade = { CascadeType.ALL})
		@JoinTable(
				name = "employees_rol",
				joinColumns = { @JoinColumn(name = "employee_id")},
				inverseJoinColumns = {@JoinColumn(name = "role_id")}
				)
		List<Role> roles;
		

		

		public Employee (){}
		
		public Employee(int id, String nombre, String apellido) {
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public List<Role> getRoles() {
			return roles;
		}

		public void setRoles(List<Role> roles) {
			this.roles = roles;
		}


		
		
//		public List<Role> getRoles() {
//			return roles;
//		}
//
//		public void setRoles(List<Role> roles) {
//			this.roles = roles;
//		}
		
		

}
