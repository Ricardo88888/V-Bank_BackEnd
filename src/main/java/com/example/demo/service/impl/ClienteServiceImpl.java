package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.common.GenericServiceImpl;
import com.example.demo.dao.IClienteDao;
import com.example.demo.model.Cliente;
import com.example.demo.service.IClienteService;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements IClienteService {
	
	@Autowired
	private IClienteDao clienteDao;
	
	
	@Override
	public JpaRepository<Cliente, Integer> getDao() {
		return clienteDao;
	}

	@Override
	public List<Cliente> listaPorDni(String dni) {
		return clienteDao.findByDni(dni);
	}
	@Override
	public List<Cliente> listaPorNombre(String nombre) {
		return clienteDao.findByNombre(nombre);
	}
	@Override
	public List<Cliente> listaPorNombreLike(String nombre) {
		return clienteDao.findByNombreLike(nombre);
	}
	@Override
	public List<Cliente> listaTodos() {
		return clienteDao.findAll();
	}
	@Override
	public List<Cliente> listaPorApellidoPaterno(String apellido_paterno) {
		return clienteDao.findByApellido_paterno(apellido_paterno);
	}
	@Override
	public List<Cliente> listaPorApellidoMaterno(String apellido_materno) {
		return clienteDao.findByApellido_materno(apellido_materno);
	}
	@Override
	public List<Cliente> listaPorCorreo(String correo) {
		return clienteDao.findByCorreo(correo);
	}

	@Override
	public Cliente insertaActualizaCliente(Cliente obj) {
		return clienteDao.save(obj);
	}

	
}
