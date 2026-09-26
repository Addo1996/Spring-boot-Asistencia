package com.krakedev.asistencias.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.krakedev.asistencias.entidades.Asistencia;

@Service
public class ServicioAsistencia {

	private ArrayList<RegistroAsistencia> registros = new ArrayList<>();

	private final ServicioEstudiantes servicioEstudiantes;

	public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}

	// Registra la asistencia de un estudiante
	public RegistroAsistencia registrarAsistencia(String cedula) {

		Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);

		if (estudiante == null) {
			return null;
		}

		// Crea la asistencia con la fecha, hora actual y estado presente
		Asistencia asistencia = new Asistencia(LocalDate.now(), LocalDateTime.now(), "P");

		// Crea el registro relacionando al estudiante con su asistencia y lo guarda
		RegistroAsistencia registro = new RegistroAsistencia(estudiante, asistencia);

		registros.add(registro);
		return registro;

	}

	// Consulta todas las asistencias de un estudiante
	public ArrayList<Asistencia> consultarAsistencia(String cedula) {

		ArrayList<Asistencia> asistencias = new ArrayList<>();

		for (RegistroAsistencia registro : registros) {

			if (registro.getEstudiante().getCedula().equals(cedula)) {
				asistencias.add(registro.getAsistencia());

			}

		}
		return asistencias;

	}

}
