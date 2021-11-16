package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.service.IClienteService;

@RestController
@RequestMapping("/wscliente")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
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
	public ResponseEntity<Cliente> insertarCliente(Cliente c) {
		Cliente obj = clienteService.save(c);
		if (obj != null) {
			return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
		} else {
			return new ResponseEntity<Cliente>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<Cliente> modificarClientar(@RequestBody Cliente c) {
		Cliente obj = clienteService.save(c);
		if (obj != null) {
			return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
		} else {
			return new ResponseEntity<Cliente>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Cliente> eliminarCliente(@PathVariable("id") Integer id) {
		Cliente obj = clienteService.get(id);
		if (obj != null) {
			clienteService.delete(id);
			return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
		} else {
			return new ResponseEntity<Cliente>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
