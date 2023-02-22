package com.unab;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Profesional extends Usuario {

  
    /**
     *
     */
    private static final DateTimeFormatter OF_PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // Establecer datos del profesional
    private String tituloProfesional;
    private LocalDate fechaIngreso;

    // Constructor con atributos como parámetros
 
   

    // Generar Getter and Setter

    public Profesional(String nombre1, String nacimiento, String rut2, String tituloProfesional2,
            String fechaIngreso2) {
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        if (tituloProfesional.length() >= 10 && tituloProfesional.length() <= 50) {
            this.tituloProfesional = tituloProfesional;
        } else {
            throw new IllegalArgumentException("El título debe tener entre 10 y 50 caracteres.");
        }
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        DateTimeFormatter formatter = OF_PATTERN;
        try {
            this.fechaIngreso = LocalDate.parse(fechaIngreso, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("La fecha de ingreso debe tener el formato DD/MM/AAAA.");
        }
    }

    // Método
    /**
     * @return
     */
    public void analizarProfesional() {
        super.analizarUsuario();
        DateTimeFormatter formatter = OF_PATTERN;
        System.out.println("Profesional " + tituloProfesional);
        System.out.println("Fecha de ingreso " + fechaIngreso.format(formatter));
    }

    public String toString() {
        DateTimeFormatter formatter = OF_PATTERN;
        return "Profesional " + tituloProfesional + ", Fecha de ingreso " + fechaIngreso.format(formatter);
    }
}
