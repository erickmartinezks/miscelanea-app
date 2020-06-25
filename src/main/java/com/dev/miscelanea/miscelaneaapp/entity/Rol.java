package com.dev.miscelanea.miscelaneaapp.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name = "usuarios_roles",
		joinColumns = @JoinColumn(name = "id_rol"),
		inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	private Collection<Usuario> users;
	
	public Rol() {
		
	}

	public Rol(int id, String nombre, Collection<Usuario> users) {
		this.id = id;
		this.nombre = nombre;
		this.users = users;
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

	@Override
	public String toString() {
		return "Role [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
