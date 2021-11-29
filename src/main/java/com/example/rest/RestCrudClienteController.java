package com.example.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@RequestMapping("/crudCliente")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
public class RestCrudClienteController {

	private Logger log = LoggerFactory.getLogger(RestCrudClienteController.class);

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listaClientePorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Cliente>> listaClientePorNombreLike(@PathVariable("nom") String nom) {
		log.info("==> listaClientePorNombreLike ==> nom : " + nom);

		List<Cliente> lista = null;
		try {
			if (nom.equals("todos")) {
				lista = clienteService.listaTodos();
			}else {
				lista = clienteService.listaPorNombreLike(nom + "%");	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaCliente(@RequestBody Cliente obj) {
		log.info("==> insertaCliente ==> ID : " + obj.getId());
		log.info("==> insertaCliente ==> Nombre : " + obj.getNombre());
		log.info("==> insertaCliente ==> Apellido Paterno : " + obj.getApellido_paterno());
		log.info("==> insertaCliente ==> Apellido Materno : " + obj.getApellido_materno());
		log.info("==> insertaCliente ==> DNI : " + obj.getDni());
		log.info("==> insertaCliente ==> Correo : " + obj.getCorreo());
		
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getId() != 0) {
				salida.put("mensaje", "El ID del Cliente debe ser cero");
				return ResponseEntity.ok(salida);
			}

			List<Cliente> lista = null;

			lista = clienteService.listaPorNombre(obj.getNombre());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El Nombre ya existe : " + obj.getNombre());
				return ResponseEntity.ok(salida);
			}
			lista = clienteService.listaPorApellidoPaterno(obj.getApellido_paterno());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El Apellido Paterno ya existe : " + obj.getApellido_paterno());
				return ResponseEntity.ok(salida);
			}
			lista = clienteService.listaPorApellidoMaterno(obj.getApellido_materno());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El Apellido Materno ya existe : " + obj.getApellido_materno());
				return ResponseEntity.ok(salida);
			}
			lista = clienteService.listaPorDni(obj.getDni());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El DNI ya existe : " + obj.getDni());
				return ResponseEntity.ok(salida);
			}
			lista = clienteService.listaPorCorreo(obj.getCorreo());
			if (!CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El Correo ya existe : " + obj.getCorreo());
				return ResponseEntity.ok(salida);
			}
			

			Cliente objSalida = clienteService.insertaActualizaCliente(obj);
			if (objSalida == null) {
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
	
	@PutMapping("/actualizaCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaDocente(@RequestBody Cliente obj) {
		log.info("==> actualizaCliente ==> ID : " + obj.getId());
		log.info("==> actualizaCliente ==> Nombre : " + obj.getNombre());
		log.info("==> actualizaCliente ==> Apellido Paterno : " + obj.getApellido_paterno());
		log.info("==> actualizaCliente ==> Apellido Materno : " + obj.getApellido_materno());
		log.info("==> actualizaCliente ==> DNI : " + obj.getDni());
		log.info("==> actualizaCliente ==> Correo : " + obj.getCorreo());
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getId() == 0) {
				salida.put("mensaje", "El ID del Cliente debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Cliente objSalida = clienteService.insertaActualizaCliente(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
