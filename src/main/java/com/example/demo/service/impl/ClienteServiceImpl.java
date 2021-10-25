package com.example.demo.service.impl;

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
}
