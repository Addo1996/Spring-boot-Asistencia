package com.krakedev.asistencias.controladores;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.RegistroAsistencia;
import com.krakedev.asistencias.servicios.ServicioAsistencia;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorAsistencia {

    private final ServicioAsistencia servicioAsistencia;

    // Recibe el servicio de asistencias mediante inyección de dependencias
    public ControladorAsistencia(ServicioAsistencia servicioAsistencia) {
        this.servicioAsistencia = servicioAsistencia;
    }
    
 // Registra la asistencia de un estudiante
    @PostMapping("/asistencias/{cedula}")
    public RegistroAsistencia registrarAsistencia(@PathVariable String cedula) {
        return servicioAsistencia.registrarAsistencia(cedula);
    }
    
 // Consulta las asistencias de un estudiante
    @GetMapping("/asistencias/{cedula}")
    public ArrayList<Asistencia> consultarAsistencia(@PathVariable String cedula) {
        return servicioAsistencia.consultarAsistencia(cedula);
    }
    
    
    

}