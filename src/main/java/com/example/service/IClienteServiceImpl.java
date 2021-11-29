package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Cliente;
import com.example.repository.IClienteRepository;

@Service
public class IClienteServiceImpl  implements IClienteService {
	
	@Autowired
	private IClienteRepository clienteRepository;
	

	@Override
	public List<Cliente> listaPorDni(String dni) {
		return clienteRepository.findByDni(dni);
	}
	@Override
	public List<Cliente> listaPorNombre(String nombre) {
		return clienteRepository.findByNombre(nombre);
	}
	@Override
	public List<Cliente> listaPorNombreLike(String nombre) {
		return clienteRepository.findByNombreLike(nombre);
	}
	@Override
	public List<Cliente> listaTodos() {
		return clienteRepository.findAll();
	}
	@Override
	public List<Cliente> listaPorApellidoPaterno(String apellido_paterno) {
		return clienteRepository.findByApellido_paterno(apellido_paterno);
	}
	@Override
	public List<Cliente> listaPorApellidoMaterno(String apellido_materno) {
		return clienteRepository.findByApellido_materno(apellido_materno);
	}
	@Override
	public List<Cliente> listaPorCorreo(String correo) {
		return clienteRepository.findByCorreo(correo);
	}

	@Override
	public Cliente insertaActualizaCliente(Cliente obj) {
		return clienteRepository.save(obj);
	}

	@Override
	public List<Cliente> listaPorCelular(String celular) {
		return clienteRepository.findByCelular(celular);
	}
	@Override
	public List<Cliente> listaClientePorId() {
		
		return clienteRepository.findAllById(null);
	}
	
	
}
