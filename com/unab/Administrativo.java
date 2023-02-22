package com.unab;

import java.time.LocalDate;

public class Administrativo extends Usuario {

    // Establecer datos del administrativo
    private String areaTrabajo;
    private String experiencia;

    // Constructor vacio
   
    // Constructor con atributos como parámetros
    /**
     * @param areaTrabajo
     * @param fechaNacimiento2
     * @param experiencia
     * @param experiencia2
     * @param areaTrabajo2
     */
    public Administrativo(String areaTrabajo, LocalDate fechaNacimiento2, String experiencia, String areaTrabajo2, String experiencia2) {
        this.areaTrabajo = areaTrabajo;
        this.experiencia = experiencia;
    }

    // Generar Getter and Setter
    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    /**
     * @param AreaTrabajo , Condición de carácteres máximos en el área de trabajo
     */
    public void setareaTrabajo(String areaTrabajo) {
        if (areaTrabajo.length() >= 5 && areaTrabajo.length() == 20) {
            this.areaTrabajo = areaTrabajo;
        } else {
            throw new IllegalArgumentException("El área debe tener entre 5 y 20 caracteres.");
        }
    }

    public String getExperiencia(String experiencia) {
        return experiencia;
    }

    /**
     * @param experiencia, Condición de carácteres máximos en la experiencia
     */
    public void setExperiencia(String experiencia) {
        if (experiencia.length() <= 100) {
            this.experiencia = experiencia;
        } else {
            throw new IllegalArgumentException("El área debe tener maximo 100 caracteres");
        }
    }

    // metodo
    /**
     * @return
     */

    public void crearAccidente() {
        setareaTrabajo(areaTrabajo);
        setExperiencia(experiencia);
        setNombre(areaTrabajo);
        setNacimiento(getNacimiento());
        setRut(areaTrabajo);
    }
}