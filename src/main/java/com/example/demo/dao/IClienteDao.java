package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer> {


	public List<Cliente> findByNombre(String nombre);
	public List<Cliente> findByNombreLike(String nombre);
	public List<Cliente> findByApellido_paterno(String apellido_paterno);
	public List<Cliente> findByApellido_materno(String apellido_materno);
	public List<Cliente> findByDni(String dni);
	public List<Cliente> findByCorreo(String correo);
	

}
