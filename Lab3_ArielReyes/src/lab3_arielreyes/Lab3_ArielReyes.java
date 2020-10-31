/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_arielreyes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ariel
 */
public class Lab3_ArielReyes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<productos> f = new ArrayList(); 
        Date d = new Date();
        f.add(new comida(d, "bebida", "algo rico", "fetuchonio", 0));
        System.out.println(f);
    }
    
}
