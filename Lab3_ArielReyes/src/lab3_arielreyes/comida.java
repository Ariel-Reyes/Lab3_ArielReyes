/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_arielreyes;

import java.util.Date;

/**
 *
 * @author Ariel
 */
public class comida extends productos {

    Date vence;
    String tipo_comida;

    public comida(Date vence, String tipo_comida, String descripcion, String nombre, double precio) {
        super(descripcion, nombre, precio);
        this.vence = vence;
        this.tipo_comida = tipo_comida;
    }

    public Date getVence() {
        return vence;
    }

    public void setVence(Date vence) {
        this.vence = vence;
    }

    public String getTipo_comida() {
        return tipo_comida;
    }

    public void setTipo_comida(String tipo_comida) {
        this.tipo_comida = tipo_comida;
    }

    @Override
    public String toString() {
        return super.toString() + "comida{" + "vence=" + vence + ", tipo_comida=" + tipo_comida + '}';
    }

}
