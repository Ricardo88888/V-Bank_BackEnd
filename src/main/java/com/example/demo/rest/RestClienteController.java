package com.example.demo.rest;

import com.example.demo.model.Cliente;
import com.example.demo.service.IClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wscliente")
public class RestClienteController {
	
    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public List<Cliente> listarCliente() {
        return clienteService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Cliente obtenerCliente(@PathVariable("id") Integer id) {
        return clienteService.get(id);
    }

    @PostMapping
    public void insertarCliente(@RequestBody Cliente c) {
        clienteService.save(c);
    }

    @PutMapping
    public void modificarClientar(@RequestBody Cliente c) {
        clienteService.save(c);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminarCliente(@PathVariable("id") Integer id) {
        clienteService.delete(id);
    }
}
