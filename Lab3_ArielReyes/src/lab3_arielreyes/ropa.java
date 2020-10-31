/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_arielreyes;

/**
 *
 * @author Ariel
 */
public class ropa extends productos {

    String genero_prenda;
    float talla;

    public ropa(String genero_prenda, float talla, String descripcion, String nombre, double precio) {
        super(descripcion, nombre, precio);
        this.genero_prenda = genero_prenda;
        this.talla = talla;
    }

    public ropa() {
        super();
    }

    public String getGenero_prenda() {
        return genero_prenda;
    }

    public void setGenero_prenda(String genero_prenda) {
        this.genero_prenda = genero_prenda;
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return super.toString() + "ropa{" + "genero_prenda=" + genero_prenda + ", talla=" + talla + '}';
    }

}
