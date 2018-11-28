package com.ricardo.models;

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
@Table(name = "equipo")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;

	@Column
	private String nombre;

	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "team_employee", 
        joinColumns = { @JoinColumn(name = "team_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "employee_id") }
    )	
	private List<Employee> miembros;
	
	public Team() {		
	}

	public Team(int tid, String nombre, List<Employee> miembros) {		
		this.tid = tid;
		this.nombre = nombre;
		this.miembros = miembros;
	}

	/**
	 * @return the tid
	 */
	public int getTid() {
		return tid;
	}

	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the miembros
	 */
	public List<Employee> getMiembros() {
		return miembros;
	}

	/**
	 * @param miembros the miembros to set
	 */
	public void setMiembros(List<Employee> miembros) {
		this.miembros = miembros;
	}
	
	
	

}
