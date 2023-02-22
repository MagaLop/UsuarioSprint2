package com.unab;

import static java.lang.System.out;

import java.time.Duration;
import java.util.Scanner;

public class Capacitacion extends Evento {
    private String tema;
    private Duration duracion;

    // Constructor que inicializa el scanner para ingresar datos por teclado
    public Capacitacion(Duration duracion2) {
        super();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Retorna el tema de la capacitación
     * @return String con el tema de la capacitación
     */
    public String getTema() {
        return tema;
    }

    /**
     * Asigna el tema de la capacitación ingresado por teclado, valida que el tema no esté vacío
     */
    public void setTema() {
        boolean temaValido = false;
        while (!temaValido) {
            out.print("Ingrese el tema: ");
            String temaIngresado = scanner.nextLine();
            // Validamos que el tema no esté vacío
            if (temaIngresado != null && !temaIngresado.isEmpty()) {
                this.tema = temaIngresado;
                temaValido = true;
            } else {
                out.println("El tema no puede estar vacío, por favor inténtelo de nuevo.");
            }
        }
    }

    /**
     * Retorna la duración de la capacitación
     * @return Duration con la duración de la capacitación
     */
    public Duration getDuracion() {
        return duracion;
    }

    /**
     * Asigna la duración de la capacitación ingresada por teclado, valida que la duración sea un número entero positivo
     */
    public void setDuracion() {
        boolean duracionValida = false;
        while (!duracionValida) {
            out.print("Ingrese la duración (en minutos): ");
            String duracionIngresada = scanner.nextLine();
            // Validamos que la duración sea un número entero positivo
            try {
                int duracionValidada = Integer.parseInt(duracionIngresada);
                if (duracionValidada > 0) {
                    this.duracion = Duration.ofMinutes(duracionValidada);
                    duracionValida = true;
                } else {
                    out.println("La duración debe ser un número entero positivo, por favor inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                out.println("La duración debe ser un número entero positivo, por favor inténtelo de nuevo.");
            }
        }
    }

    /**
     * Método que llama a los métodos para ingresar los datos de la capacitación por teclado
     */
    public void crearCapacitacion() {
        setFecha();
        setHora();
        setLugar();
        setIdentificador();
        setTema();
        setDuracion();
    }

    public String getAsistentes() {
        return null;
    }
  
}
