/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_arielreyes;

import java.util.ArrayList;

/**
 *
 * @author Ariel
 */
public class locales {
    String nombre_local;
    ArrayList<personas> empleados; 
    ArrayList<productos> lista_producto; 

    public locales() {
    }

    public locales(String nombre_local, ArrayList<personas> empleados, ArrayList<productos> lista_producto) {
        this.nombre_local = nombre_local;
        this.empleados = empleados;
        this.lista_producto = lista_producto;
    }

    public String getNombre_local() {
        return nombre_local;
    }

    public void setNombre_local(String nombre_local) {
        this.nombre_local = nombre_local;
    }

    public ArrayList<personas> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<personas> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<productos> getLista_producto() {
        return lista_producto;
    }

    public void setLista_producto(ArrayList<productos> lista_producto) {
        this.lista_producto = lista_producto;
    }

    @Override
    public String toString() {
        return "locales{" + "nombre_local=" + nombre_local + ", empleados=" + empleados + ", lista_producto=" + lista_producto + '}';
    }

}
