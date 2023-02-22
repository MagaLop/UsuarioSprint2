package com.unab;

import java.util.Scanner;

public class Accidente extends Evento {

    // Establecer datos del accidente
    private String rutCliente;
    private String origenAccidente;
    private String consecuenciasAccidente;
    protected Scanner scanner;
    private String identificador;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    // Constructor vacio
    public Accidente() {
        super();
    }

    // Constructor con atributos como parámetros
    public Accidente(String rutCliente, String origenAccidente, String consecuenciasAccidente) {
        this.rutCliente = rutCliente;
        this.origenAccidente = origenAccidente;
        this.consecuenciasAccidente = consecuenciasAccidente;
    }

    // Generar Condiciones

    // Condición Rut
    public void setRutCliente(String rutCliente) {
        boolean identificadorValido = false;
        while (!identificadorValido) {
            String identificadorIngresado = scanner.nextLine();
            System.out.println("Ingrese el Rut del Cliente:");
            if (identificadorIngresado != null && !identificadorIngresado.isEmpty()) {
                this.identificador = identificadorIngresado;
                identificadorValido = true;
            } else {
                System.out.println("El identificador no puede estar vacío, por favor inténtelo de nuevo.");
            }
        }
    }

    // Condición de máximo de carácteres en Origen del Accidente (Máximo 100
    // caracteres)
    public void setOrigenAccidente(String origenAccidente) {
        boolean valid = false;
        while (!valid) {
            System.out.print("Ingrese el lugar (entre 10 y 100 caracteres): ");
            String lugarIngresado = scanner.nextLine();
            // Validamos que el lugar tenga entre 10 y 100 caracteres
            if (lugarIngresado.length() >= 10 && lugarIngresado.length() <= 100) {
                this.origenAccidente = lugarIngresado;
                valid = true;
            } else {
                System.out.println(
                        "El lugar ingresado no cumple con la longitud requerida, por favor inténtelo de nuevo.");
            }
        }
    }

    // Condición de máximo de caracteres en Consecuencias del Accidente (Máximo 100
    // caracteres)
    public void setConsecuenciasAccidente(String consecuenciasAccidente) {
        boolean valid = false;
        while (!valid) {
            System.out.print("Ingrese las consecuencias del accidente (entre 10 y 100 caracteres): ");
            consecuenciasAccidente = scanner.nextLine();
            // Validamos que el lugar tenga entre 10 y 100 caracteres
            if (consecuenciasAccidente.length() >= 10 && consecuenciasAccidente.length() <= 100) {
                this.consecuenciasAccidente = consecuenciasAccidente;
                valid = true;
            } else {
                System.out.println("No cumple con la longitud requerida, por favor inténtelo de nuevo.");
            }
        }
    }

    // Todos los getters Juntos
    public String getRutCliente() {
        return rutCliente;
    }

    public String getOrigenAccidente() {
        return origenAccidente;
    }

    public String getConsecuenciasAccidente() {
        return consecuenciasAccidente;
    }

    /**
     * Método que llama a los métodos para ingresar los datos de la capacitación por
     * teclado
     */
    public void crearAccidente() {
        setIdentificador();
        setRutCliente(consecuenciasAccidente);
        setFecha();
        setHora();
        setLugar();
        setConsecuenciasAccidente(consecuenciasAccidente);
        setOrigenAccidente(consecuenciasAccidente);
    }
}
