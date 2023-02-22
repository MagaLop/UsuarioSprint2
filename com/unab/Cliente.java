package com.unab;

/**

La clase Cliente representa a un usuario que es cliente de la empresa.
Contiene información personal del usuario, como su nombre, dirección y edad,
así como información específica del cliente, como su número de teléfono,
sistema de salud y AFP. También incluye métodos para establecer y obtener
la información del usuario y para analizar la información del cliente.
*/
import java.util.Scanner;

public class Cliente extends Usuario {

    Scanner sc = new Scanner(System.in);

    // atributos

    private static String rut; // RUT del cliente
    private String nombres; // Nombres del cliente
    private String apellidos; // Apellidos del cliente
    private String telefono; // Teléfono del cliente
    private String afp; // AFP del cliente
    private int sistemaSalud; // Tipo de sistema de salud (1-Fonasa o 2-Isapre)
    private String direccion; // Dirección del cliente
    private String comuna; // Comuna del cliente
    private int edad; // Edad del cliente

    /**
     * Crea un nuevo objeto Cliente con la información personal y de contacto del
     * usuario.
     * 
     * @param nombre       el nombre del cliente
     * @param apellidos    los apellidos del cliente
     * @param rut          el RUT del cliente (debe tener entre 0 y 10 dígitos)
     * @param telefono     el número de teléfono del cliente
     * @param afp          la AFP del cliente
     * @param sistemaSalud el sistema de salud del cliente (1 para Isapre, 2 para
     *                     Fonasa, otro número para desconocido)
     * @param direccion    la dirección del cliente
     * @param comuna       la comuna del cliente
     * @param edad         la edad del cliente (se puede establecer más tarde...)
     */
    /**
     * constructor vacio
     */

    // Constructor de la clase Cliente
    public Cliente(String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad,
            Cliente cliente) {

        super();

        cliente.nombres = nombres;
        cliente.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    // Método para obtener el nombre completo
    public String obtenerNombre() {
        return nombre + " " + apellidos;
    }

    // Getters and setters
    // Getter para obtener los nombres del cliente
    public String getNombres() {
        return nombres;
    }

    // Setter para establecer los nombres del cliente
    public void setNombres(String nombres) {
        if (nombres.length() >= 5 && nombres.length() <= 30) {
            this.nombres = nombres;
        } else {
            System.out.println("Error: Los nombres deben tener entre 5 y 30 caracteres.");
        }
    }

    // Getter para obtener los apellidos del cliente
    public String getApellidos() {
        return apellidos;
    }

    // Setter para establecer los apellidos del cliente
    public void setApellidos(String apellidos) {
        if (apellidos.length() >= 5 && apellidos.length() <= 30) {
            this.apellidos = apellidos;
        } else {
            System.out.println("Error: Los apellidos deben tener entre 5 y 30 caracteres");
        }
    }

    /*
     * Getter para obtener el rut del cliente
     * Verifica si el RUT ingresado es válido y lo asigna como valor de la propiedad
     * "rut".
     * Si el RUT no es válido, se muestra un mensaje de error y se solicita al
     * usuario que ingrese el RUT nuevamente.
     * 
     * @param rut el RUT a verificar y asignar
     */

    public String getRut() {
        return rut;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.unab.Usuario#setRut(java.lang.String)
     */

    public void setRut(String rut) {
        if (rut.matches("[0-9, kK-]{6,10}")) {
            Cliente.rut = rut;
        } else {
            System.out.println("El RUT ingresado no es válido. Por favor, ingrese un RUT válido.");
            do {
                System.out.print("Ingrese el RUT: ");
                rut = sc.nextLine();
            } while (!rut.matches("[0-9, kK-]{6,10}"));
            Cliente.rut = rut;
        }
    }
    /*
     * verifica si los datos telefono han sido ingresados, sino los vuelve a pedir
     */

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String string, Cliente cliente) {
        do {
            System.out.print("Ingrese su número de teléfono (8 dígitos): +56 9");
            telefono = sc.nextLine();
        } while (telefono.length() != 8);

        System.out.println("Número de teléfono ingresado: +56 9 " + telefono);
        cliente.telefono = telefono;
    }

    /*
     * verifica si los datos AFP han sido ingresados, sino los vuelve a pedir
     */
    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        do {
            System.out.print("Ingrese su AFP (mínimo 4 caracteres, máximo 30): ");
            afp = sc.nextLine();
        } while (afp.length() < 4 || afp.length() > 30);

        System.out.println("AFP ingresada: " + afp);

        this.afp = afp;
    }

    /*
     * verifica si los datos del Sistema de salud han sido ingresados.
     * Sino devuelve el sistema de salud del cliente.
     * 
     * @throws IllegalArgumentException si el valor del atributo sistemaSalud no es
     * 1 ni 2
     */
    public void getSistemaSalud() {
        // Verifica si el valor del atributo sistemaSalud es 1 o 2
        if (sistemaSalud == 1) {
            System.out.println("Sistema de Salud: Fonasa");
        } else if (sistemaSalud == 2) {
            System.out.println("Sistema de Salud: Isapre");
        } else {
            // Si el valor no es 1 ni 2, lanza una excepción con un mensaje indicando el
            // error
            throw new IllegalArgumentException("Valor incorrecto para sistema de salud");
        }
        
    }
    /**
     * Establece el sistema de salud del cliente.
     * 
     * @param sistemaSalud el sistema de salud del cliente, debe ser 1 (Fonasa) o 2
     *                     (Isapre)
     * @throws IllegalArgumentException si el valor de sistemaSalud no es 1 ni 2
     */
    public void setSistemaSalud(int sistemaSalud) {
        // Verifica si el valor del parámetro sistemaSalud es 1 o 2
        while (sistemaSalud != 1 && sistemaSalud != 2) {
            // Si no es 1 ni 2, solicita al usuario que ingrese un valor válido
            System.out.println("Ingrese un valor válido para sistema de salud (1 para Fonasa, 2 para Isapre): ");
            sistemaSalud = sc.nextInt();
        }
        // Si es así, asigna el valor al atributo sistemaSalud
        this.sistemaSalud = sistemaSalud;
    }

    public String getDireccion() {
        return comuna;
    }

    /**
     * Obtiene la dirección del cliente.
     * 
     * @return la dirección del cliente
     */
    public void setDireccion(String direccion) {
        // Validación de que la dirección no es nula
        if (direccion == null) {
            throw new IllegalArgumentException("La dirección no puede ser nula");
        }

        // Verificar si la dirección es nula o si supera los 70 caracteres
        if (direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        } else if (direccion.trim().length() > 70) {
            throw new IllegalArgumentException("La dirección no puede superar los 70 caracteres");
        }

        // Asignar la dirección al atributo correspondiente
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    /**
     * Obtiene la comuna del cliente.
     * 
     * @return la comuna del cliente
     */
    public void setComuna(String comuna) {
        // Validación de que la comuna no es nula
        if (comuna == null) {
            throw new IllegalArgumentException("La comuna no puede ser nula");
        }
        // Verificar si la comuna es nula o si supera los 70 caracteres
        if (comuna.trim().isEmpty()) {
            throw new IllegalArgumentException("La comuna no puede estar vacía");
        } else if (comuna.trim().length() > 50) {
            throw new IllegalArgumentException("La comuna no puede superar los 70 caracteres");
        }

        // Asignar la comuna al atributo correspondiente
        this.comuna = comuna;
    }

    /**
     * Obtiene la edad del cliente.
     * 
     * @return la edad del cliente
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del paciente.
     * 
     * @throws IllegalArgumentException si la edad es menor que cero o mayor que 150
     */
    public void setEdad(int i, Cliente cliente) {
        // Bucle do-while para pedir la edad y verificar si está dentro del rango
        // adecuado
        do {
            // Pedir la edad
            System.out.println("Ingrese la edad (mayor o igual a cero, menor a 150): ");
            String input = sc.nextLine();

            // Verificar si la entrada es un número
            try {
                edad = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
                continue;
            }

            // Verificar si la edad está dentro del rango adecuado
            if (edad < 0 || edad >= 150) {
                System.out.println("La edad debe ser mayor o igual a cero y menor a 150.");
            }
        } while (edad < 0 || edad >= 150);

        // Asignar la edad al atributo correspondiente

        cliente.edad = edad;
    }

    // metodo analizar usuario
    public String analizarCliente() {
        analizarUsuario();

        return "Cliente [Teléfono: " + telefono + "\nAFP: " + afp + "\nSistema de salud: " + sistemaSalud
                + "\nDirección: " + direccion + "\nComuna: " + comuna + "\nEdad: " + edad + "]";
    }

}