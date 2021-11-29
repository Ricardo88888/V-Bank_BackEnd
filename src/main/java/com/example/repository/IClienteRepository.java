package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {


	// Para Consulta
	@Query("select d from Cliente d where "
			+ "( :p_nom is '' or d.nombre like :p_nom ) and "
			+ "( :p_ape_pat is '' or d.apellido_paterno = :p_ape_pat ) and "
			+ "( :p_ape_mat is '' or d.apellido_materno = :p_ape_mat ) and "
			+ "( :p_dni is '' or d.dni = :p_dni ) and "
			+ "( :p_corr is '' or d.correo = :p_corr ) and "
			+ "( :p_cel is ''  or d.celular = :p_cel ) ")
	public abstract List<Cliente> listaDocentePorDniNombreUbigeo(
									@Param("p_nom") String nombre,
									@Param("p_ape_pat") String apellido_paterno,
									@Param("p_ape_mat") String apellido_materno,
								 	@Param("p_dni") String dni, 
								 	@Param("p_corr") String correo,
								 	@Param("p_cel") String celular);
	
	
	public List<Cliente> findByNombre(String nombre);
	public List<Cliente> findByNombreLike(String nombre);
	public List<Cliente> findByApellido_paterno(String apellido_paterno);
	public List<Cliente> findByApellido_materno(String apellido_materno);
	public List<Cliente> findByDni(String dni);
	public List<Cliente> findByCorreo(String correo);
	public List<Cliente> findByCelular(String celular);
	

}
