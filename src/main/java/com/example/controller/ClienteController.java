package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cliente;
import com.example.service.IClienteService;
import com.example.util.Constantes;


@RestController
@RequestMapping("/wscliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping
	public List<Cliente> listarCliente() {
		return clienteService.listaTodos();
	}

	@GetMapping(value = "/{id}")
	public Cliente obtenerCliente(@PathVariable("id") Integer id) {
		return clienteService.
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaModalidad(@RequestBody Cliente obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Cliente objCliente = clienteService.insertaActualizaCliente(obj);
			if (objCliente == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	//@PostMapping
	/*public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente c) {
		Cliente obj = clienteService.save(c);
		if (obj != null) {
			return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
		} else {
			return new ResponseEntity<Cliente>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

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