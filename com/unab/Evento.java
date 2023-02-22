package com.unab;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase para representar un evento con una fecha, hora, lugar e identificador.
 */
public class Evento {
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private String identificador;
    protected Scanner scanner;


//Los Getters y settes están separados por una cuestion de orden porque se implementarion todas las validaciones en los setters

    /**
     * Método para establecer la fecha del evento.
     * Muestra un mensaje para pedir al usuario que ingrese la fecha con un formato específico (dd/mm/aaaa).
     * Valida que la fecha ingresada sea válida y la establece como fecha del evento.
     * Si la fecha no es válida, muestra un mensaje de error y pide que se vuelva a intentar.
     */
    public void setFecha() {
        boolean fechaValida = false;
        while (!fechaValida) {
            System.out.print("Ingrese la fecha (dd/mm/aaaa): ");
            String fechaIngresada = scanner.nextLine();
            // Validamos la fecha con un formato específico
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaValidada = LocalDate.parse(fechaIngresada, formatter);
                this.fecha = fechaValidada;
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("La fecha ingresada es inválida, por favor inténtelo de nuevo.");
            }
        }
    }

    /**
     * Método para establecer la hora del evento.
     * Muestra un mensaje para pedir al usuario que ingrese la hora con un formato específico (hh:mm - 0 a 23 y 0 a 59).
     * Valida que la hora ingresada sea válida y la establece como hora del evento.
     * Si la hora no es válida, muestra un mensaje de error y pide que se vuelva a intentar.
     */
    public void setHora() {
        boolean horaValida = false;
        while (!horaValida) {
            System.out.print("Ingrese la hora (hh:mm - 0 a 23 y 0 a 59): ");
            String horaIngresada = scanner.nextLine();
            // Validamos la hora con un formato específico
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime horaValidada = LocalTime.parse(horaIngresada, formatter);
                this.hora = horaValidada;
                horaValida = true;
            } catch (Exception e) {
                System.out.println("La hora ingresada es inválida, por favor inténtelo de nuevo.");
            }
        }
    }

    /**
     * Método para establecer el lugar del evento.
     * Muestra un mensaje para pedir al usuario que ingrese el lugar (entre 10 y 50 caracteres).
     * Valida que el lugar ingresado tenga entre 10 y 50 caracteres y lo establece como lugar del evento.
     * Si el lugar no cumple con la longitud requerida, muestra un mensaje de error y pide que se vuelva a intentar.
     */
    public void setLugar() {
        boolean lugarValido = false;
        while (!lugarValido) {
            System.out.print("Ingrese el lugar (entre 10 y 50 caracteres): ");
            String lugarIngresado = scanner.nextLine();
            // Validamos que el lugar tenga entre 10 y 50 caracteres
            if (lugarIngresado.length() >= 10 && lugarIngresado.length() <= 50) {
                this.lugar = lugarIngresado;
                lugarValido = true;
            } else {
                System.out.println("El lugar ingresado no cumple con la longitud requerida, por favor inténtelo de nuevo.");
            }
        }
    }

    /**
    * Actualiza el identificador del evento.
    * Este método solicita al usuario que ingrese un identificador para el evento y lo valida antes de asignarlo. El identificador
    * no puede estar vacío, y se continuará solicitando un nuevo identificador hasta que se proporcione uno válido. El método
    * actualiza el identificador del evento con el valor proporcionado.
    */
    public void setIdentificador() {
        boolean identificadorValido = false;
        while (!identificadorValido) {
            System.out.print("Ingrese el identificador: ");
            String identificadorIngresado = scanner.nextLine();
            // Validamos que el identificador no esté vacío
            if (identificadorIngresado != null && !identificadorIngresado.isEmpty()) {
                this.identificador = identificadorIngresado;
                identificadorValido = true;
            } else {
                System.out.println("El identificador no puede estar vacío, por favor inténtelo de nuevo.");
            }
        }
    }


        //Todos los getters juntos

        public LocalDate getFecha() {
            return fecha;
        }
    
        public LocalTime getHora() {
            return hora;
        }
    
        public String getLugar() {
            return lugar;
        }
    
        public String getIdentificador() {
            return identificador;
        }
    
}