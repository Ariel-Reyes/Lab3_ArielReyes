/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_arielreyes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ariel
 */
public class cliente extends personas {

    static Scanner leer = new Scanner(System.in);
    double dinero;
    ArrayList<productos> compras;

    public cliente(double dinero, ArrayList<productos> compras, String id, String usuario, String nombre) {
        super(id, usuario, nombre);
        this.dinero = dinero;
        this.compras = compras;
    }

    public cliente() {
        super();
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        if (dinero <= 0) {
            System.out.println("Se ha quedado sin dinero (vaya al banco y regresa :) )");
        } else {
            this.dinero = dinero;
        }
    }

    public ArrayList<productos> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<productos> compras) {

        this.compras = compras;
    }

    @Override
    public String toString() {
        return super.toString() + "cliente{" + "dinero=" + dinero + ", compras=" + compras + '}';
    }

}
