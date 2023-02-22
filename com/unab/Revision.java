package com.unab;

public class Revision {
    private String idRevision; // Identificador de la revisión
    private VisitaTerreno visita; // IdVisita a la que se asocia la revisión
    private String nombreAlusivo; // Nombre alusivo a la revisión
    private String detalle; // Detalle para revisar
    private int estado; // Estado: 1-sin problemas, 2-con observaciones, 3-no aprueba
    
    // Constructor que inicializa los atributos
    public Revision(String idRevision, VisitaTerreno visita, String nombreAlusivo, String detalle, int estado) {
        this.idRevision = idRevision;
        this.visita = visita;
        this.nombreAlusivo = nombreAlusivo;
        this.detalle = detalle;
        this.estado = estado;
    }
    
    // Métodos de acceso y modificación de los atributos
    
    public String getIdRevision() {
        return idRevision;
    }
    
    public void setIdRevision(String idRevision) {
        this.idRevision = idRevision;
    }
    
    public VisitaTerreno getVisita() {
        return visita;
    }
    
    public void setVisita(VisitaTerreno visita) {
        this.visita = visita;
    }
    
    public String getNombreAlusivo() {
        return nombreAlusivo;
    }
    
    public void setNombreAlusivo(String nombreAlusivo) {
        // Verificar que el nombre alusivo tenga al menos 10 caracteres y no más de 50
        if (nombreAlusivo.length() < 10 || nombreAlusivo.length() > 50) {
            throw new IllegalArgumentException("El nombre alusivo debe tener entre 10 y 50 caracteres");
        }
        this.nombreAlusivo = nombreAlusivo;
    }
    
    public String getDetalle() {
        return detalle;
    }
    
    public void setDetalle(String detalle) {
        // Verificar que los detalles no superen los 100 caracteres
        if (detalle.length() > 100) {
            throw new IllegalArgumentException("Los detalles no pueden tener más de 100 caracteres");
        }
        this.detalle = detalle;
    }
    
    public int getEstado() {
        return estado;
    }
    
    public void setEstado(int estado) {
        switch (estado) {
            case 1:
                this.estado = estado;
                System.out.println("El estado ha sido establecido como 'sin problemas'");
                break;
            case 2:
                this.estado = estado;
                System.out.println("El estado ha sido establecido como 'con observaciones'");
                break;
            case 3:
                this.estado = estado;
                System.out.println("El estado ha sido establecido como 'no aprueba'");
                break;
            default:
                throw new IllegalArgumentException("El estado debe ser 1, 2 o 3");
        }
    }
}