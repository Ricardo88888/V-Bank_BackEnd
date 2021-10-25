package com.example.demo.dao;

import com.example.demo.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente, Integer> {

}
