import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Perro> lstPerrosDisponibles = new ArrayList<>();
    private static List<Persona> lstUsuarios = new ArrayList<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        Perro firu = new Perro("156", "Firulais", "pubg", 7, "Pequeño");
        Perro luc = new Perro("258", "Lucas", "Pastor Aleman", 10, "Grande");
        Perro spark = new Perro ("357", "Sparkie", "Cooker Spanish", 10, "Mediano");
        lstPerrosDisponibles.add(firu);
        lstPerrosDisponibles.add(luc);
        lstPerrosDisponibles.add(spark);
        Persona p1 = new Persona("1234", "Felipe", "Garcia", 18);
        Persona p2 = new Persona("4567", "Luis", "Gomez", 20);
        mostrarMenu();
    }

    private static void mostrarMenu() throws InterruptedException {
        System.out.println("\nSistema de Adopción." +
                "\nQue desea hacer?" +
                "\n1. Registrar un Usuario." +
                "\n2. Registrar un Perrito." +
                "\n3. Ver Usuarios Registrados." +
                "\n4. Ver Perritos Disponibles" +
                "\n5. Adoptar Perrito." +
                "\n6. Consultar Perrito Mas Viejo De Un Usuario." +
                "\n7. Salir Del Programa.");
        int opc = teclado.nextInt();
        switch (opc) {
            case 1 -> registrar(0);
            case 2 -> registrar(1);
            case 3 -> verDatos(0);
            case 4 -> verDatos(1);
            case 5 -> adoptar();
            case 6 -> verDatos(2);
            case 7 -> {
                System.out.println("Gracias por usar el programa.");
                Thread.sleep(2000);
            }
        }
    }

    private static void registrar(int registro) throws InterruptedException {
        if (registro == 0) {
            String nombre, apellido, documento;
            int edad;
            teclado.nextLine();
            System.out.print("Vamos a registrar tu usuario." +
                    "\nIngrese su documento de identidad: \n= ");
            documento = teclado.nextLine();
            for (Persona p : lstUsuarios) {
                if (documento.equals(p.getDocumento()) && !lstUsuarios.isEmpty()) {
                    System.out.println("Ya hay una persona registrada con ese documento.");
                    Thread.sleep(2000);
                    mostrarMenu();
                }
            }
            System.out.print("Ingrese su nombre: \n= ");
            nombre = teclado.nextLine();
            System.out.print("Ingrese su apellido: \n= ");
            apellido = teclado.nextLine();
            System.out.print("Ingrese su edad: \n= ");
            edad = teclado.nextInt();
            Persona usuarioNuevo = new Persona(documento, nombre, apellido, edad);
            lstUsuarios.add(usuarioNuevo);
            System.out.println("Su usuario ha sido registrado.");
            Thread.sleep(2000);
            mostrarMenu();
        } else if (registro == 1) {
            String placa, nombre, raza, tamanio = "";
            int edad;
            teclado.nextLine();
            System.out.print("Vamos a registrar al perrito." +
                    "\nIngrese el numero de placa: \n= ");
            placa = teclado.nextLine();
            System.out.print("Ingrese el nombre: \n= ");
            nombre = teclado.nextLine();
            System.out.print("Ingrese la raza: \n= ");
            raza = teclado.nextLine();
            System.out.print("Que tamaño tiene?" +
                    "\n1. Pequeño" +
                    "\n2. Mediano" +
                    "\n3. Grande \n= ");
            int opc = teclado.nextInt();
            switch (opc) {
                case 1 -> tamanio = "Pequeño";
                case 2 -> tamanio = "Mediano";
                case 3 -> tamanio = "Grande";
            }
            System.out.print("Ingrese la edad (En años): \n= ");
            edad = teclado.nextInt();
            Perro perritoNuevo = new Perro(placa, nombre, raza, edad, tamanio);
            lstPerrosDisponibles.add(perritoNuevo);
            System.out.println("El perrito ha sido registrado.");
            Thread.sleep(2000);
            mostrarMenu();
        }
    }

    private static void verDatos(int eleccion) throws InterruptedException {
        switch (eleccion) {
            case 0 -> {
                if (lstUsuarios.isEmpty()) {
                    System.out.println("Aún no hay usuarios registrados.");
                    Thread.sleep(2000);
                    mostrarMenu();
                } else {
                    for (Persona p : lstUsuarios) {
                        System.out.println(p.toString());
                    }
                    Thread.sleep(2000);
                    mostrarMenu();
                }
            }
            case 1 -> {
                if (lstPerrosDisponibles.isEmpty()) {
                    System.out.println("No hay perritos disponibles.");
                    Thread.sleep(2000);
                    mostrarMenu();
                } else {
                    for (Perro p : lstPerrosDisponibles) {
                        System.out.println(p.toString());
                    }
                    Thread.sleep(2000);
                    mostrarMenu();
                }
            }
            case 2 -> {
                if (!lstUsuarios.isEmpty()) {
                    teclado.nextLine();
                    System.out.print("Ingrese su cédula o documento con el que se registró.\n= ");
                    String doc = teclado.nextLine();
                    for (Persona p : lstUsuarios) {
                        if (doc.equals(p.getDocumento())) {
                            p.perroMasGrande();
                        } else {
                            System.out.println("No hay usuario registrado con ese documento." +
                                    "\nRegistrese e intente nuevamente.\n");
                            mostrarMenu();
                        }
                    }
                } else {
                    System.out.println("Aún no hay usuarios registrados.");
                    Thread.sleep(2000);
                    mostrarMenu();
                }
            }
        }
    }

    private static void adoptar() throws InterruptedException {
        if (lstPerrosDisponibles.isEmpty()) {
            System.out.println("No hay perritos disponibles.");
            Thread.sleep(2000);
            mostrarMenu();
        } else {
            teclado.nextLine();
            System.out.print("Ingrese su numero de documento con el que fue registrado.\n= ");
            String doc = teclado.nextLine();
            for (Persona p : lstUsuarios) {
                if (doc.equals(p.getDocumento())) {
                    System.out.println("Que perrito desea adoptar?");
                    int i = 1;
                    for (Perro d : lstPerrosDisponibles) {
                        System.out.println(i + ". " + d.toString());
                        i++;
                    }
                    int eleccion = teclado.nextInt();
                    Perro perritoSeleccionado = lstPerrosDisponibles.get(eleccion - 1);
                    lstPerrosDisponibles.remove(eleccion-1);
                    p.adoptarPerro(perritoSeleccionado);
                    Thread.sleep(2000);
                    mostrarMenu();
                } else {
                    System.out.println("No hay un usuario registrado con ese documento." +
                            "\nIntente nuevamente.");
                    Thread.sleep(2000);
                    mostrarMenu();
                }
            }
        }
    }
}