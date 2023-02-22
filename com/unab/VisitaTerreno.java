package com.unab;

import java.time.LocalDate;
import java.time.LocalTime;
/*
 - Identificador de la visita en terreno * (N° Interno por la compañia)
- RUT Cliente* 
- Día: (Fecha del accidente) (DD/MM/AAAA)
- Hora (HH:MM - 0 a 23 y 0 a 59)
- Lugar* (min 10, max 50 car)
- Comentarios: (max 100 car)

/**
 * Esta clase representa una visita en terreno realizada a un cliente.
 * Contiene información como el identificador de la visita, el cliente que fue visitado,
 * la fecha y hora de la visita, el lugar donde se realizó y los comentarios de la visita.
 */


public class VisitaTerreno extends Evento{
    private String idVisita; // Identificador de la visita
    private Cliente cliente; // Cliente visitado
    private LocalDate fecha; // Fecha de la visita
    private LocalTime hora; // Hora de la visita
    private String lugar; // Lugar donde se realizó la visita
    private String comentarios; // Comentarios de la visita
    
    // Constructor que inicializa los atributos
    public VisitaTerreno(String idVisita, Cliente cliente, LocalDate fecha, LocalTime hora, String lugar, String comentarios) {
        super();
		this.idVisita = idVisita;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.comentarios = comentarios;
    }
    
    // Métodos de acceso y modificación de los atributos
    
    public String getIdVisita() {
        return idVisita;
    }
    
    public void setIdVisita(String idVisita) {
        this.idVisita = idVisita;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public LocalTime getHora() {
        return hora;
    }
    
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public String getLugar() {
        return lugar;
    }
    
    public void setLugar(String lugar) {
        // Verificar que el lugar tenga al menos 10 caracteres y no más de 50
        if (lugar.length() < 10 || lugar.length() > 50) {
            throw new IllegalArgumentException("El lugar debe tener entre 10 y 50 caracteres");
        }
        this.lugar = lugar;
    }
    
    public String getComentarios() {
        return comentarios;
    }
    
    public void setComentarios(String comentarios) {
        // Verificar que los comentarios no sean nulos o estén vacíos
        if (comentarios == null || comentarios.trim().isEmpty()) {
            throw new IllegalArgumentException("Los comentarios no pueden estar vacíos");
        }
        // Verificar que los comentarios no superen los 100 caracteres
        if (comentarios.length() > 100) {
            throw new IllegalArgumentException("Los comentarios no pueden tener más de 100 caracteres");
        }
        this.comentarios = comentarios;
    }
}
