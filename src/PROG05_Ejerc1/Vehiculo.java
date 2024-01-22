/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG05_Ejerc1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Joseme
 */
public class Vehiculo {
    private String marca;
    private String matricula;
    private int numKilometros;
    private LocalDate fechaMatriculacion;
    private double precio;
    private String dniPropietario;
    private String nombrePropietario;

    public Vehiculo(String marca, String matricula, int numKilometros, LocalDate fechaMatriculacion,
                    double precio, String dniPropietario, String nombrePropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKilometros = numKilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.precio = precio;
        this.dniPropietario = dniPropietario;
        this.nombrePropietario = nombrePropietario;
    }

    // Métodos get y set

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumKilometros() {
        return numKilometros;
    }

    public void setNumKilometros(int numKilometros) {
        this.numKilometros = numKilometros;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
    

    public int getAnios() {
        Period period = Period.between(fechaMatriculacion, LocalDate.now());
        return period.getYears();
    }

    @Override
    public String toString() {
        return "Vehiculo {" + '\n' +
                "Marca = " + marca + '\n' +
                "Matricula = " + matricula + '\n' +
                "Kilometros = " + numKilometros + '\n' +
                "Fecha de matriculacion = " + fechaMatriculacion + '\n' +
                "Precio = " + precio + '\n' +
                "DNI del propietario = " + dniPropietario + '\n' +
                "Nombre del propietario = " + nombrePropietario +
                "\n}";
    }
}