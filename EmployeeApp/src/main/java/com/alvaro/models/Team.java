package com.alvaro.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Team {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int tid;
		
		@Column(name="nombre")
		private String nombre;
		
		@Column(name="miembros")
	
		
//		@OneToMany(mappedBy="employee")
//		private List<Role> roles;
		
		@ManyToMany (cascade = { CascadeType.ALL})
		@JoinTable(
				name = "team_employee",
				joinColumns = { @JoinColumn(name = "team_id")},
				inverseJoinColumns = {@JoinColumn(name = "employee_id")}
				)
		List<Employee> miembros;

		public Team(int tid, String nombre, List<Employee> miembros) {
			super();
			this.tid = tid;
			this.nombre = nombre;
			this.miembros = miembros;
		}

		public int getTid() {
			return tid;
		}

		public void setTid(int tid) {
			this.tid = tid;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public List<Employee> getMiembros() {
			return miembros;
		}

		public void setMiembros(List<Employee> miembros) {
			this.miembros = miembros;
		}
		
		

}