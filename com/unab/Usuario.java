package com.unab;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Usuario implements Asesoria {

    // Atributos
    protected static String nombre;
    private LocalDate nacimiento;
    private String rut;

    // Constructor vacio

    public Usuario() {
    }
    Scanner sc = new Scanner(System.in);
    // Contructor con parámetros
    public Usuario(String nombre, LocalDate nacimiento, String rut, LocalDate fechaActual) {
        Usuario.nombre = nombre;
        this.nacimiento = nacimiento;
        this.rut = rut;
    }
       

    // Getters and Setters
    public String getNombre() {
        return Usuario.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() < 10 || nombre.length() > 50) {
            System.out.println("Nombre inválido, por favor vuelve a ingresar tu nombre.");
            return;
        }
        Usuario.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return this.nacimiento;
    }

    /**
     * @param nacimiento
     */
    public void setNacimiento(LocalDate nacimiento) {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formato);
        System.out.println(fechaFormateada);

        if (nacimiento == null) {
            System.out.println("Fecha inválida, por favor ingresar una fecha válida.");
            return;
        }
        this.nacimiento = nacimiento;
    }

    public String getRut() {
		return rut;
	}

public void setRut(String rut) {
    if (rut.matches("[0-9, kK-]{6,10}")) {
        this.rut = rut;
    } else {
        System.out.println("El RUT ingresado no es válido. Por favor, ingrese un RUT válido.");
        do {
            System.out.print("Ingrese el RUT: ");
            rut = sc.nextLine();
        } while (!rut.matches("[0-9, kK-]{6,10}"));
        this.rut = rut;
    }
}

    // Metodos.
    public void mostrarEdad() {
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(nacimiento, fechaActual).getYears();
        System.out.println("El usuario tiene" + edad + "años");
    }

    public void analizarUsuario() {
        System.out.println("Nombre: " + Usuario.nombre);
        System.out.println("RUT: " + this.rut);
    }

    public String toString() {
        return "Nombre: " + Usuario.nombre + "\nFecha de nacimiento: " + this.nacimiento + "\nRUT> " + this.rut;

    }
}
