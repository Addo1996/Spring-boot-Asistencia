package com.krakedev.asistencias.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {

	private ArrayList<Estudiante> estudiantes = new ArrayList<>();

	public void agregar(Estudiante estudiante) {

		// Verifica que no exista otro estudiante con la misma cédula
		Estudiante existente = buscarPorCedula(estudiante.getCedula());

		if (existente == null) {
			estudiantes.add(estudiante);
		}
	}

	// Busca un estudiante por su número de cédula
	public Estudiante buscarPorCedula(String cedula) {

		for (Estudiante estudiante : estudiantes) {
			if (estudiante.getCedula().equals(cedula)) {
				return estudiante;
			}
		}
		return null;
	}

	// Elimina un estudiante por su número de cédula
	public void eliminar(String cedula) {

		Estudiante estudiante = buscarPorCedula(cedula);

		if (estudiante != null) {
			estudiantes.remove(estudiante);
		}

	}

	// Actualiza los datos de un estudiante que ya existe
	public void actualizar(String cedula, Estudiante nuevo) {

		Estudiante estudiante = buscarPorCedula(cedula);

		if (estudiante != null) {
			estudiante.setNombre(nuevo.getNombre());
			estudiante.setApellido(nuevo.getApellido());

		}

	}

	// Retorna la lista de estudiantes registrados
	public ArrayList<Estudiante> listar() {

		return estudiantes;
	}

}
