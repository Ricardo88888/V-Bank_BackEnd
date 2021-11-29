package com.example.service;

import java.util.List;

import com.example.model.Cliente;

public interface IClienteService {
	
	//Para Crud
	public abstract List<Cliente> listaPorNombre(String nombre);
	public abstract List<Cliente> listaPorNombreLike(String nombre);
	public abstract List<Cliente> listaPorApellidoPaterno(String apellido_paterno);
	public abstract List<Cliente> listaPorApellidoMaterno(String apellido_materno);
	public abstract List<Cliente> listaPorDni(String dni);
	public abstract List<Cliente> listaPorCorreo(String correo);
	public abstract List<Cliente> listaPorCelular(String celular);
	
	public abstract List<Cliente> listaTodos();
	public abstract Cliente insertaActualizaCliente(Cliente obj);
	public abstract List<Cliente> listaClientePorId();

	
}
