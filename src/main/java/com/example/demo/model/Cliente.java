package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "persona_id", unique = true, nullable = false)
	private int id;

	@Column(name = "persona_nombre", nullable = false)
	@NotNull
	private String nombre;

	@Column(name = "persona_apellido_paterno", nullable = false)
	@NotEmpty
	private String apellido_paterno;

	@Column(name = "persona_apellido_materno", nullable = false)
	@NotEmpty
	private String apellido_materno;

	@Column(name = "persona_dni", nullable = false)
	@NotEmpty
	private String dni;

	@Column(name = "persona_correo", nullable = false, unique = true)
	@NotEmpty
	@Email
	private String correo;

	@Column(name = "persona_celular", nullable = false, unique = true)
	@NotEmpty
	@Pattern(regexp = "[0-9]{9}")
	private String celular;

	
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

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
