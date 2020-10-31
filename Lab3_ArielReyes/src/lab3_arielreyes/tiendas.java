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
public class tiendas extends locales {

    public tiendas() {
        super(); 
    }

    public tiendas(String nombre_local, ArrayList<personas> empleados, ArrayList<productos> lista_producto) {
        super(nombre_local, empleados, lista_producto);
    }
    
    

    public ArrayList<productos> getLista_producto() {
        return lista_producto;
    }

    public void setLista_producto(ArrayList<productos> lista_producto) {

        this.lista_producto = lista_producto;
    }

    @Override
    public String toString() {
        return super.toString() + "tiendas{" + '}';
    }



}
