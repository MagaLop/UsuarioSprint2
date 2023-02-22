package com.unab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Contenedor {
   
 //Atributos
 ArrayList <Asesoria> asesorias= new ArrayList<>();
 ArrayList <Capacitacion> capacitaciones= new ArrayList<>();

 //Contenedor vacio

    public Contenedor() {
        
    }

    public Contenedor(List<Asesoria> asesorias, List<Capacitacion> capacitaciones) {
        this.asesorias = (ArrayList<Asesoria>) asesorias;
        this.capacitaciones = (ArrayList<Capacitacion>) capacitaciones;
    }

    public List<Asesoria> getAsesorias() {
        return this.asesorias;
    }

    public void setAsesorias(List<Asesoria> asesorias) {
        this.asesorias = (ArrayList<Asesoria>) asesorias;
    }

    public List<Capacitacion> getCapacitaciones() {
        return this.capacitaciones;
    }

    public void setCapacitaciones(List<Capacitacion> capacitaciones) {
        this.capacitaciones = (ArrayList<Capacitacion>) capacitaciones;
    }
 
//Métodos
public void almacenarCliente(Cliente cliente) {
    asesorias.add(cliente);
}
public void almacenarProfesional(Profesional profesional) {
    asesorias.add(profesional);
}
public void almacenarAdministrativo(Administrativo administrativo) {
    asesorias.add(administrativo);
}

public void almacenarCapacitacion(Capacitacion capacitacion) {
    capacitaciones.add(capacitacion);
}
public void eliminarUsuario(String rut) {
    Iterator<Asesoria> iter = asesorias.iterator();
    while (iter.hasNext()) {
    Asesoria asesoria = iter.next();
    if (asesoria.getRut().equals(rut)) {
    iter.remove();
    }
    }
    }
    
    public void listarUsuarios() {
        System.out.println("Lista de Usuarios: ");
        for (Asesoria asesoria : asesorias) {
            if (asesoria instanceof Usuario) {
                System.out.println(asesoria.toString());
            }
        }
    }
public void listarUsuariosPorTipo(String tipoUsuario) {
    for (Asesoria asesoria : asesorias) {
        if (asesoria instanceof Cliente && tipoUsuario.equals("Cliente")) {
            System.out.println(((Cliente) asesoria).toString());
        }
        if (asesoria instanceof Administrativo && tipoUsuario.equals("Administrativo")) {
            System.out.println(((Administrativo) asesoria).toString());
        }
        if (asesoria instanceof Profesional && tipoUsuario.equals("Profesional")) {
            System.out.println(((Profesional) asesoria).toString());
        }
    }
}
    public void listarCapacitaciones(){
        System.out.println("Lista de capacitaciones: ");
        for (Capacitacion capacitacion : capacitaciones){
        
            System.out.println ("Identificador: " + capacitacion.getIdentificador() + "\nRut: " + ((Asesoria) capacitacion).getRut() + "\nFecha: " + capacitacion.getFecha() + "\nHora: " + capacitacion.getHora() + "\nLugar: " + capacitacion.getLugar() + "\nDuración: " + capacitacion.getDuracion() + "\nCantidad de asistentes: " + capacitacion.getAsistentes());
            
    }

            }

    

        }
    