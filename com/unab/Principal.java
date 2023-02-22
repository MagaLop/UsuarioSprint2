package com.unab;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contenedor contenedor = new Contenedor();
        int opcion = 0;

        // Mostrar menú

        while (opcion != 9) {
            System.out.println("==== Menú Principal ====");
            System.out.println("1. Almacenar cliente");
            System.out.println("2. Almacenar profesional");
            System.out.println("3. Almacenar administrativo");
            System.out.println("4. Almacenar capacitación");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Listar usuarios");
            System.out.println("7. Listar usuarios por tipo");
            System.out.println("8. Listar capacitaciones");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opción: ");
             try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("La opción ingresada no es válida, por favor inténtelo de nuevo.");
                return;
            }
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre y apellido del Cliente: ");
                    String nombre = sc.nextLine();
                    if (nombre.length() < 10 || nombre.length() > 50) {
                    // Corrección: mostrar mensaje de error si el nombre es inválido
                    System.out.println("Nombre inválido, por favor vuelve a ingresar tu nombre.");
                    return;
                    }
                           
                    System.out.print("Ingrese la fecha de nacimiento del Cliente (DD/MM/AAAA): ");
                    String nacimiento = sc.nextLine();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaNacimiento = LocalDate.parse(nacimiento, formato);
                    LocalDate fechaActual = LocalDate.now();
                    int edad = fechaActual.getYear() - fechaNacimiento.getYear();
                    if (fechaNacimiento.plusYears(edad).isAfter(fechaActual)) {
                        edad--;
                    }
                    if (edad < 0 || edad > 150) {
                        // Corrección: mostrar mensaje de error si la edad es inválida
                        System.out.println("Edad inválida, por favor ingrese una edad válida.");
                        return;
                    }
                    System.out.print("Ingrese el Rut del Cliente (xx.xxx.xxx-x): ");
                    String rut = sc.nextLine();
                    while (!rut.matches("[0-9]{1,2}.[0-9]{3}.[0-9]{3}-[0-9,kK]")) {
                        // Corrección: mostrar mensaje de error si el RUT ingresado no es válido
                        System.out.println("El RUT ingresado no es válido. Por favor, ingrese un RUT válido.");
                        System.out.print("Ingrese el RUT: ");
                        rut = sc.nextLine();
                    }
                    System.out.print("Ingrese el número de teléfono del Cliente (8 dígitos): +56 9");
                    String telefono = sc.nextLine();
                    while (telefono.length() != 8) {
                        // Corrección: mostrar mensaje de error si el número de teléfono no es válido
                        System.out.println("El número ingresado no es válido. Por favor, ingrese un número de 8 dígitos.");
                        System.out.print("Ingrese el número de teléfono del Cliente (8 dígitos): +56 9");
                        telefono = sc.nextLine();
                    }
                    System.out.print("Ingrese la AFP del Cliente (mínimo 4 caracteres, máximo 30): ");
                    String afp = sc.nextLine();
                    if (afp.length() < 4 || afp.length() > 30) {
                    System.out.println("AFP inválida, por favor ingrese una AFP válida.");
                    return;
                    }
                    System.out.print("Ingrese el Sistema de Salud del Cliente (1-Fonasa / 2- Isapre): ");
                    int sistemaSalud = sc.nextInt();
                    sc.nextLine();
                    if (sistemaSalud == 1) {
                    System.out.println("Sistema de Salud: Fonasa");
                    } else if (sistemaSalud == 2) {
                    System.out.println("Sistema de Salud: Isapre");
                    } else {
                    // Si el valor no es 1 ni 2, lanza una excepción con un mensaje indicando el
                    // error
                    throw new IllegalArgumentException("Valor incorrecto para sistema de salud");
                    }
                     while (sistemaSalud != 1 && sistemaSalud != 2) {
                    // Si no es 1 ni 2, solicita al usuario que ingrese un valor válido
                    System.out.println("Ingrese un valor válido para sistema de salud (1 para Fonasa, 2 para Isapre): ");
                    sistemaSalud = sc.nextInt();
                    sc.nextLine();
                    }   
                    System.out.println("Ingrese la dirección del Cliente: ");
                    String direccion = sc.nextLine();
                    if (direccion == null) {
                    throw new IllegalArgumentException("La dirección no puede ser nula");
                    }
            
                    // Verificar si la dirección es nula o si supera los 70 caracteres
                    if (direccion.trim().isEmpty()) {
                        throw new IllegalArgumentException("La dirección no puede estar vacía");
                    } else if (direccion.trim().length() > 70) {
                    throw new IllegalArgumentException("La dirección no puede superar los 70 caracteres");
                    }
                    System.out.println("Ingrese la comuna del Cliente: ");
                    String comuna = sc.nextLine();

                    if (comuna == null) {
                    throw new IllegalArgumentException("La comuna no puede ser nula");
                    }
                        // Verificar si la comuna es nula o si supera los 70 caracteres
                    if (comuna.trim().isEmpty()) {
                    throw new IllegalArgumentException("La comuna no puede estar vacía");
                    } else if (comuna.trim().length() > 50) {
                    throw new IllegalArgumentException("La comuna no puede superar los 70 caracteres");
                    }

                    int edad1;
                    do {
                    // Pedir la edad
                    System.out.println("Ingrese la edad del Cliente (mayor o igual a cero, menor a 150): ");
                        String input = sc.nextLine();
        
                    // Verificar si la entrada es un número
                    try {
                         edad = Integer.parseInt(input);
                     } catch (NumberFormatException f) {
                            System.out.println("Debe ingresar un número entero.");
                         continue;
                     }
                                
                    // Verificar si la edad está dentro del rango adecuado
                    } while(edad < 0 || edad >= 150); 
                    contenedor.almacenarCliente(null); 
                    break;           
                 
                case 2:
                    System.out.print("Ingrese el nombre y apellido del Profesional: ");
                    String nombre1 = sc.nextLine();
                    if (nombre1.length() < 10 || nombre1.length() > 50) {
                        System.out.println("Nombre inválido, por favor vuelve a ingresar tu nombre.");
                        continue;
                    }
                    System.out.print("Ingrese la fecha de nacimiento del Profesional (DD/MM/AAAA): ");
                    String nacimiento1 = sc.nextLine();
                    DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaNacimiento1 = null;
                    try {
                        fechaNacimiento = LocalDate.parse(nacimiento1, formato1);
                    } catch (Exception f) {
                        System.out.println("Fecha inválida, por favor ingresar una fecha válida.");
                        return;
                    }
                    System.out.print("Ingrese el Rut del Profesional (xx.xxx.xxx-x): ");
                    String rut2 = sc.nextLine();
                    while (!rut2.matches("[0-9]{1,2}.[0-9]{3}.[0-9]{3}-[0-9,kK]")) {
                        // Corrección: mostrar mensaje de error si el RUT ingresado no es válido
                        System.out.println("El RUT ingresado no es válido. Por favor, ingrese un RUT válido.");
                        System.out.print("Ingrese el RUT: ");
                        rut = sc.nextLine();
                    }
                    System.out.println("Ingrese el título del Profesional: ");
                    String tituloProfesional = sc.nextLine();
                    if (tituloProfesional.length() < 10 || tituloProfesional.length() > 50) {
                        throw new IllegalArgumentException("El título debe tener entre 10 y 50 caracteres.");
                    }

                    System.out.println("Ingrese la fecha de ingreso del Profesional (DD/MM/AAAA): ");
                    String fechaIngreso = sc.nextLine();
                    LocalDate fechaIngresoProf = null;
                    try {
                        fechaIngresoProf = LocalDate.parse(fechaIngreso, formato1);
                    } catch (Exception f) {
                        throw new IllegalArgumentException("La fecha de ingreso debe tener el formato DD/MM/AAAA.");
                    }
                    contenedor.almacenarProfesional(new Profesional(nombre1, nacimiento1, rut2, tituloProfesional, fechaIngreso));
                    break;
                case 3:    
                    System.out.print("Ingrese el nombre y apellido del Administrativo: ");
                    String nombre2 = sc.nextLine();
                    if (nombre2.length() < 10 || nombre2.length() > 50) {
                        System.out.println("Nombre inválido, por favor vuelve a ingresar tu nombre.");
                        return;
                    }
                    System.out.print("Ingrese la fecha de nacimiento del Administrativo: (DD/MM/AAAA): ");
                    String nacimiento2 = sc.nextLine();
                    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaNacimiento2;
                    try {
                        fechaNacimiento2 = LocalDate.parse(nacimiento2, formato2);
                    } catch (Exception f){
                        System.out.println("Fecha inválida, por favor ingresar una fecha válida.");
                        return;
                    }
                    System.out.print("Ingrese el Rut del Administrativo (xx.xxx.xxx-x): ");
                    String rut3 = sc.nextLine();
                    while (!rut3.matches("[0-9]{1,2}.[0-9]{3}.[0-9]{3}-[0-9,kK]")) {
                        // Corrección: mostrar mensaje de error si el RUT ingresado no es válido
                        System.out.println("El RUT ingresado no es válido. Por favor, ingrese un RUT válido.");
                        System.out.print("Ingrese el RUT: ");
                        rut = sc.nextLine();
                    }
                    System.out.print("Ingrese el área de trabajo del Administrativo: ");
                    String areaTrabajo = sc.nextLine();
                    if (areaTrabajo.length() < 5 || areaTrabajo.length() > 20) {
                        throw new IllegalArgumentException("El área debe tener entre 5 y 20 caracteres.");
                    }

                    System.out.println("Ingrese la experiencia del Administrativo: ");
                    String experiencia = sc.nextLine();
                    if (experiencia.length() > 100) {
                        throw new IllegalArgumentException("La experiencia debe tener máximo 100 caracteres.");
                    }
                    contenedor.almacenarAdministrativo(new Administrativo(nombre2, fechaNacimiento2, rut3, areaTrabajo, experiencia));
                    break;

                case 4:
               
                    boolean identificadorValido = false;
                        String identificador = null;
                        while (!identificadorValido) {
                            System.out.print("Ingrese el Identificador de la capacitación: ");
                            String identificadorIngresado = sc.nextLine();
                            // Validamos que el identificador no esté vacío
                            if (identificadorIngresado != null && !identificadorIngresado.isEmpty()) {
                                identificador = identificadorIngresado;
                                identificadorValido = true;
                            } else {
                                System.out.println("El identificador no puede estar vacío, por favor inténtelo de nuevo.");
                            }
                        }

                    boolean fechaValida = false;
                    LocalDate fecha = null;
                    while (!fechaValida) {
                        System.out.print("Ingrese la fecha de la capacitación (dd/mm/aaaa): ");
                        String fechaIngresada = sc.nextLine();
                        // Validamos la fecha con un formato específico
                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            fecha = LocalDate.parse(fechaIngresada, formatter);
                            fechaValida = true;
                        } catch (Exception r) {
                            System.out.println("La fecha ingresada es inválida, por favor inténtelo de nuevo.");
                        }
                    }
                    boolean horaValida = false;
                    while (!horaValida) {
                        System.out.print("Ingrese la hora de la capacitación (hh:mm - 0 a 23 y 0 a 59): ");
                        String horaIngresada = sc.nextLine();
                        // Validamos la hora con un formato específico
                        try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // Corregido
                    LocalTime horaValidada = LocalTime.parse(horaIngresada, formatter);
                    LocalTime hora = horaValidada;
                    horaValida = true;
                        } catch (Exception r) {
                            System.out.println("La hora ingresada es inválida, por favor inténtelo de nuevo.");
                        }
                    }
                    boolean lugarValido = false;
                    String lugar = ""; // Corregido
                    while (!lugarValido) {
                        System.out.print("Ingrese el lugar de la capacitación (entre 10 y 50 caracteres): ");
                        String lugarIngresado = sc.nextLine();
                        // Validamos que el lugar tenga entre 10 y 50 caracteres
                        if (lugarIngresado.length() >= 10 && lugarIngresado.length() <= 50) {
                            lugar = lugarIngresado;
                            lugarValido = true;
                        } else {
                            System.out.println("El lugar ingresado no cumple con la longitud requerida, por favor inténtelo de nuevo.");
                        }
                    }
                    boolean duracionValida = false;
                    while (!duracionValida) {
                        System.out.print("Ingrese la duración de la capacitación (en minutos): ");
                        String duracionIngresada = sc.nextLine();
                        // Validamos que la duración sea un número entero positivo
                        try {
                            int duracionValidada = Integer.parseInt(duracionIngresada);
                            if (duracionValidada > 0) {
                                Duration duracion = Duration.ofMinutes(duracionValidada);
                                Capacitacion capacitacion = new Capacitacion(duracion);
                                contenedor.almacenarCapacitacion(capacitacion);
                                duracionValida = true;
                            } else {
                                System.out.println("La duración debe ser un número entero positivo, por favor inténtelo de nuevo.");
                            }
                        } catch (NumberFormatException g) {
                            System.out.println("La duración debe ser un número entero positivo, por favor inténtelo de nuevo.");
                        }
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el rut del usuario a eliminar: ");
                    String rut4 = sc.nextLine();
                    contenedor.eliminarUsuario(rut4);
                    opcion = 0; 
                    break;
                case 6:
                    contenedor.listarUsuarios();
                    System.out.println("Lista de Usuarios: ");
                    Asesoria[] asesorias = null;
                    for (Asesoria asesoria : asesorias) {
                        if (asesoria instanceof Usuario) {
                            System.out.println(asesoria.toString());
                        }
                    }
                    break;
                case 7:
                    System.out.print("Ingrese el tipo de usuario a listar (1 para cliente, 2 para profesional, 3 para administrativo): ");
                    Object tipoUsuario = null;
                    Asesoria[] asesorias1 = null;
                    for (Asesoria asesoria : asesorias1) {
                        if (!(asesoria instanceof Cliente) || !tipoUsuario.equals("Cliente")) {
                            System.out.println(((Cliente) asesoria).toString());
                        }
                        if (asesoria instanceof Administrativo && tipoUsuario.equals("Administrativo")) {
                            System.out.println(((Administrativo) asesoria).toString());
                        }
                        if (asesoria instanceof Profesional && tipoUsuario.equals("Profesional")) {
                            System.out.println(((Profesional) asesoria).toString());
                        }
                    }
                     break;
                case 8:
                    System.out.println("Lista de capacitaciones: ");
                            Capacitacion[] capacitaciones = null;
                            for (Capacitacion capacitacion : capacitaciones){
                        contenedor.listarCapacitaciones();
                        break;
                    // Corrección: faltaba cerrar la llave del for y del case
                    }
                    break;
                case 9:
                    System.out.println("Muchas gracias por confiar en nosotros.");
                    break;
                default:
                    System.out.println("Opción incorrecta, vuelva a ingresar su opción.");
                    // Corrección: eliminar línea innecesaria
                     
        }    
          } 
         }
        }
