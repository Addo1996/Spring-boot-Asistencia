package com.krakedev.asistencias.controladores;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.servicios.ServicioEstudiantes;

@RestController
public class ControladorEstudiantes {
	
	private final ServicioEstudiantes servicioEstudiantes;
	
	public ControladorEstudiantes(ServicioEstudiantes servicioEstudiantes) {
	    this.servicioEstudiantes = servicioEstudiantes;
	}
	
	// Registra un estudiante
	@PostMapping("/estudiantes")
	public void agregar(@RequestBody Estudiante estudiante) {
	    servicioEstudiantes.agregar(estudiante);
	}
	
	// Lista todos los estudiantes registrados
	@GetMapping("/estudiantes")
	public ArrayList<Estudiante> listar() {

	    return servicioEstudiantes.listar();
	}
	
	// Busca un estudiante por su número de cédula
	@GetMapping("/estudiantes/{cedula}")
	public Estudiante buscarPorCedula(@PathVariable String cedula) {

	    return servicioEstudiantes.buscarPorCedula(cedula);
	}
	
	// Elimina un estudiante por su número de cédula
	@DeleteMapping("/estudiantes/{cedula}")
	public void eliminar(@PathVariable String cedula) {
	    servicioEstudiantes.eliminar(cedula);
	}
	
	// Actualiza los datos de un estudiante
	@PutMapping("/estudiantes/{cedula}")
	public void actualizar(@PathVariable String cedula, @RequestBody Estudiante nuevo) {
	    servicioEstudiantes.actualizar(cedula, nuevo);
	}

}
