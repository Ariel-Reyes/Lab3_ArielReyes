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
public class restaurantes extends locales {

    int cont = 1;

    public restaurantes(String nombre_local, ArrayList<personas> empleados, ArrayList<productos> lista_producto) {
        super(nombre_local, empleados, lista_producto);
    }

    public restaurantes() {
        super();
    }

    public ArrayList<personas> getEmpleados() {

        return empleados;
    }

    public void setEmpleados(ArrayList<personas> empleados) {
        cont += 1;
        if (cont < 4) {
            this.empleados = empleados;
        } else {
            System.out.println("Ya estan llenos los empleados");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "restaurantes{" + "Empleados en restaurante=" + empleados + '}';
    }

}
