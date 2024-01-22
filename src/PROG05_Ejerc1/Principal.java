/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG05_Ejerc1;

import PROG05_Ejerc1_util.Validaciones;
import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Joseme
 */
public class Principal {
    public static Vehiculo vehiculo = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> nuevoVehiculo(scanner);
                case 2 -> actualizarKilometros(scanner);
                case 3 -> verAntiguedad();
                case 4 -> mostrarDatosCompletos();
                case 5 -> {
                    System.out.println("¡Hasta luego!");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Nuevo Vehículo");
        System.out.println("2. Actualizar Kilómetros");
        System.out.println("3. Ver matrícula y años de antigüedad");
        System.out.println("4. Mostrar datos completos del vehículo");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void nuevoVehiculo(Scanner scanner) {
        System.out.print("Ingrese la marca: ");
        String marca = scanner.next();

        System.out.print("Ingrese la matrícula: ");
        String matricula = scanner.next();

        System.out.print("Ingrese el número de kilómetros: ");
        int numKilometros = scanner.nextInt();

        System.out.print("Ingrese la fecha de matriculación (formato aaaa-mm-dd): ");
        String fechaMatriculacionStr = scanner.next();
        LocalDate fechaMatriculacion = LocalDate.parse(fechaMatriculacionStr, ISO_LOCAL_DATE);

        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese el DNI del propietario: ");
        String dniPropietario = scanner.next();

        System.out.print("Ingrese el nombre del propietario: ");
        String nombrePropietario = scanner.next();

        try {
            // Validaciones
            if (!Validaciones.validarFecha(fechaMatriculacionStr)) {
                throw new Exception("Fecha de matriculación inválida. Formato: aaaa-mm-dd");
            }

            if (numKilometros <= 0) {
                throw new Exception("Número de kilómetros debe ser mayor que 0");
            }

            if (!Validaciones.validarDNI(dniPropietario)) {
                throw new Exception("DNI del propietario inválido");
            }

            vehiculo = new Vehiculo(marca, matricula, numKilometros, fechaMatriculacion,
                    precio, dniPropietario, nombrePropietario);

            System.out.println("Nuevo vehículo registrado con éxito.");
        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha incorrecto.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void actualizarKilometros(Scanner scanner) {
        if (vehiculo == null) {
            System.out.println("Error: No se ha registrado un vehículo.");
            return;
        }

        System.out.print("Ingrese la cantidad de nuevos kilómetros: ");
        int nuevosKilometros = scanner.nextInt();

        try {
            // Validaciones
            if (!Validaciones.validarKilometros(nuevosKilometros, vehiculo.getNumKilometros())) {
                throw new Exception("La cantidad de kilómetros debe ser superior a los actuales");
            }

            vehiculo.setNumKilometros(nuevosKilometros);
            System.out.println("Kilómetros actualizados con éxito.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void verAntiguedad() {
        if (vehiculo == null) {
            System.out.println("Error: No se ha registrado un vehículo.");
            return;
        }

        System.out.println("Matrícula: " + vehiculo.getMatricula());
        System.out.println("Años de antigüedad: " + vehiculo.getAnios());
    }

    private static void mostrarDatosCompletos() {
        if (vehiculo == null) {
            System.out.println("Error: No se ha registrado un vehículo.");
            return;
        }

        System.out.println(vehiculo.toString());
    }
}
