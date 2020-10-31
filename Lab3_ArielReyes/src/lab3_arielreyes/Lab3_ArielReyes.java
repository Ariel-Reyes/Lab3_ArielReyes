/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_arielreyes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Ariel
 */
public class Lab3_ArielReyes {

    static String sudo = "SUDO";
    static String sudo_contra = "clau123";
    //arreglos para las clases
    static ArrayList<personas> persona = new ArrayList();
    static ArrayList<productos> producto = new ArrayList(); // 
    static ArrayList<locales> local = new ArrayList();

    static String acum_usuarios = ""; // variable para almacear los usuarios
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\033[34m---Bienvenido al BLACKFRIDAY----"); // vreacion del menu
            System.out.println("1) creacion de usuario: ");
            System.out.println("2) Menu de sudo");
            System.out.println("3) sing in usuarios");
            System.out.println("4) salir");
            System.out.println("Ingrese la opcion que desea: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1: // menu principal
                    System.out.println("Ingrese su nombre de usuario: ");
                    String nombre_usu = leer.next();
                    System.out.println("Ingrese la contraseña: ");
                    String contra = leer.next();
                    System.out.println("Ingrese su nombre completo: ");
                    leer.nextLine();
                    String nombre_completo = leer.nextLine();
                    System.out.println("Ingrese su numero de identidad: ");
                    String id = leer.next();

                    personas person = new personas(id, nombre_usu, nombre_completo);
                    persona.add(person);

                    while (acum_usuarios.contains(nombre_usu)) {
                        System.out.println("Ese nombre de usurio ya existe");
                        System.out.println("Ingrese su nombre de usuario: ");
                        nombre_usu = leer.next();
                    }
                    while (acum_usuarios.contains(contra)) {
                        System.out.println("Esa contraseña de usurio ya existe");
                        System.out.println("Ingrese otra contraseña: ");
                        contra = leer.next();
                    }
                    while (acum_usuarios.contains(id)) {
                        System.out.println("Esa id es de otra persona");
                        System.out.println("Ingrese su verdadero id: ");
                        id = leer.next();
                    }

                    acum_usuarios += person + "," + contra;

                    break;
                case 2:

                    System.out.println("------SUDO-----"); // verificar a sudo
                    System.out.println("Para verificar que es el ingrese el nombre de usuario: ");
                    nombre_usu = leer.next();
                    System.out.println("Ingrese la contraseña: ");
                    contra = leer.next();
                    int op = 0;
                    if (nombre_usu.equals("SUDO") && contra.equals("clau123")) { // confirmacion
                        while (op != 6) {
                            System.out.println("BIENVENIDO OH! MARAVILLOSO SUDO ");
                            System.out.println("----MENU SUDO----"); // menu sudo 
                            System.out.println("1) Agregar persona");
                            System.out.println("2) Agregar Producto");
                            System.out.println("3) Llenar locales");
                            System.out.println("4)Modificar ");
                            System.out.println("5) borrar");
                            System.out.println("6) salir");

                            System.out.println("Ingrese la opcion que desea: ");
                            op = leer.nextInt();
                            switch (op) {
                                case 1:

                                    System.out.println("Ingrese el nombre de la persona: ");
                                    leer.nextLine();
                                    String nombre = leer.nextLine();
                                    System.out.println("Ingrese el id de la persona: ");
                                    id = leer.next();
                                    System.out.println("Ingrese el nombre de usuario que tendra en el sistema: ");
                                    nombre_usu = leer.next();
                                    System.out.println("Ingrese la contraseña que tendra el usuario:  ");
                                    contra = leer.next();
                                    System.out.println("Ingrese la cantidad de dinero que tiene: ");
                                    double dinero = leer.nextDouble();
                                    String list_producto = "";
                                    ArrayList<productos> prod = new ArrayList();
                                    if (producto.size() == 0) {
                                        System.out.println("Aun no hay productos");
                                    } else {

                                        for (int i = 0; i < producto.size(); i++) {
                                            list_producto += i + ")" + producto.get(i) + "\n";
                                        }
                                        System.out.println(list_producto);
                                        System.out.println("Seleccione el producto que desea extraer: ");
                                        int indice = leer.nextInt();
                                        productos produc = ((productos) producto.get(indice));

                                        prod.add(produc);
                                        System.out.println("Desea seguir extrayendo productos 1) si 2) no: ");

                                        int seguir = leer.nextInt();

                                        while (seguir != 2) {
                                            System.out.println("Seleccione el producto que desea extraer: ");
                                            indice = leer.nextInt();
                                            produc = ((productos) producto.get(indice));
                                            prod.add(produc);
                                            System.out.println("Desea seguir extrayendo productos 1) si 2) no: ");
                                            seguir = leer.nextInt();
                                        }
                                    }

                                    cliente client = new cliente(dinero, prod, id, nombre_usu, nombre);
                                    persona.add(client);

                                    acum_usuarios += nombre_usu + "," + contra;

                                    break;
                                case 2:
                                    System.out.println("---Agregar producto---");
                                    System.out.println("Que tipo de producto sera 1) Comida 2) ropa: ");
                                    int tipo = leer.nextInt();
                                    if (tipo == 1) {
                                        System.out.println("Usted selecciono la comida");
                                        System.out.println("Ingrese el nombre del platillo: ");
                                        nombre = leer.next();
                                        System.out.println("Ingrese una descripcion: ");
                                        leer.nextLine();
                                        String descripcion = leer.nextLine();
                                        System.out.println("Ingrese el precio que tendra el platillo " + nombre + ": ");
                                        double precio = leer.nextDouble();
                                        System.out.println("Ingrese si sera (bebida o comida solida): ");
                                        String tipo_comidaa = leer.next().toLowerCase();
                                        System.out.println("Ingrese la fecha de vencimiento(yyyy/MM/dd): ");
                                        String vence = leer.next();
                                        Date caduce = new Date(vence);
                                        comida comi = new comida(caduce, tipo_comidaa, descripcion, nombre, precio);
                                        producto.add(comi);
                                    }
                                    if (tipo == 2) {
                                        System.out.println("Ingrese el nombre de la prenda: ");
                                        nombre = leer.next();
                                        System.out.println("Ingrese una descripcion: ");
                                        leer.nextLine();
                                        String descripcion = leer.nextLine();
                                        System.out.println("Ingrese el precio que tendra la prenda" + nombre + ": ");
                                        double precio = leer.nextDouble();
                                        System.out.println("Ingrese el genero de prenda (masculino o femenino): ");
                                        String genero_prenda = leer.next().toUpperCase();
                                        System.out.println("Ingrese la talla de la prenda: ");
                                        float talla = (float) leer.nextFloat();
                                        ropa rope = new ropa(genero_prenda, talla, descripcion, nombre, precio);
                                        producto.add(rope);

                                    }

                                    break;
                                case 3:
                                    System.out.println(" --- Llenar los locales :3 --- ");

                                    if (persona.size() == 0 || producto.size() == 0) {
                                        System.out.println("Tienen que haber personas y productos para poder llenar los locales :'v ");
                                    } else {

                                        System.out.println("Que tipo de local desea generar 1)tiendas 2) restaurantes");

                                        int type = leer.nextInt();
                                        if (type == 1) {
                                            System.out.println("Ingrese el nombre del local: ");
                                            String nombre_local = leer.next();
                                            String ac = "";
                                            for (int i = 0; i < persona.size(); i++) {
                                                ac += i + ")" + persona.get(i) + "\n";
                                            }
                                            System.out.println(ac);
                                            System.out.println("Ingrese el indice de la persona que desea añadir: ");
                                            int indice = leer.nextInt();
                                            personas per = persona.get(indice);
                                            ArrayList<personas> perso = new ArrayList();
                                            perso.add(per);
                                            System.out.println("Desea añadir a otra persona en el local s == si / n==no: ");
                                            char deci = leer.next().charAt(0);
                                            while (deci == 's' || deci == 'S') {
                                                System.out.println(ac);
                                                System.out.println("Ingrese el indice de la persona que desea añadir: ");
                                                indice = leer.nextInt();
                                                per = persona.get(indice);
                                                perso.add(per);
                                                System.out.println("desea continuar s==si / n == no: ");
                                                deci = leer.next().charAt(0);
                                            }
                                            ac = "";
                                            for (int i = 0; i < producto.size(); i++) {
                                                ac += i + ")" + producto.get(i) + "\n";
                                            }
                                            System.out.println(ac);
                                            System.out.println("Ingrese el indice del producto que desea meter al local: ");
                                            indice = leer.nextInt();
                                            productos perr = producto.get(indice);
                                            ArrayList<productos> produ = new ArrayList<>();

                                            produ.add(perr);
                                            System.out.println("Desea añadir a otra persona en el local s == si / n==no: ");
                                            char dec = leer.next().charAt(0);
                                            while (dec == 's' || dec == 'S') {
                                                System.out.println(ac);
                                                System.out.println("Ingrese el indice del producto que desea meter al local: ");
                                                indice = leer.nextInt();
                                                perr = producto.get(indice);
                                                produ.add(perr);
                                                System.out.println("Desea añadir mas productos al local? s == si / n == no");
                                                dec = leer.next().charAt(0);

                                            }
                                            tiendas tien = new tiendas(nombre_local, perso, produ);
                                            local.add(tien);

                                        }
                                        if (type == 2) {

                                            System.out.println("Ingrese el nombre del local: ");
                                            String nombre_local = leer.next();
                                            String ac = "";
                                            for (int i = 0; i < persona.size(); i++) {
                                                ac += i + ")" + persona.get(i) + "\n";
                                            }
                                            System.out.println(ac);
                                            System.out.println("Ingrese el indice de la persona que desea añadir: ");
                                            int indice = leer.nextInt();
                                            personas per = persona.get(indice);
                                            ArrayList<personas> perso = new ArrayList();
                                            perso.add(per);
                                            System.out.println("Desea añadir a otra persona en el local s == si / n==no: ");
                                            char deci = leer.next().charAt(0);
                                            while (deci == 's' || deci == 'S') {
                                                System.out.println(ac);
                                                System.out.println("Ingrese el indice de la persona que desea añadir: ");
                                                indice = leer.nextInt();
                                                per = persona.get(indice);
                                                perso.add(per);
                                                System.out.println("desea continuar s==si / n == no: ");
                                                deci = leer.next().charAt(0);
                                            }

                                            ac = "";
                                            for (int i = 0; i < producto.size(); i++) {
                                                ac += i + ")" + producto.get(i) + "\n";
                                            }
                                            System.out.println(ac);
                                            System.out.println("Ingrese el indice del producto que desea meter al local: ");
                                            indice = leer.nextInt();
                                            productos perr = producto.get(indice);
                                            ArrayList<productos> produ = new ArrayList<>();

                                            produ.add(perr);
                                            System.out.println("Desea añadir a otra persona en el local s == si / n==no: ");
                                            char dec = leer.next().charAt(0);
                                            while (dec == 's' || dec == 'S') {
                                                System.out.println(ac);
                                                System.out.println("Ingrese el indice del producto que desea meter al local: ");
                                                indice = leer.nextInt();
                                                perr = producto.get(indice);
                                                produ.add(perr);
                                                System.out.println("Desea añadir mas productos al local? s == si / n == no");
                                                dec = leer.next().charAt(0);

                                            }
                                            restaurantes resta = new restaurantes(nombre_local, perso, produ);
                                            local.add(resta);

                                        }

                                    }
                                    break;
                                case 4:
                                    // modificacion 
                                    if (persona.size() == 0 || producto.size() == 0 || local.size() == 0) {
                                        System.out.println("TODOS LAS LISTAS DEBEN ESTAR LLENAS PARA PODER MODIFICAR MR.SUDO ");
                                    } else {

                                        System.out.println("Que desea modificar " + "\n" + "1) personas" + "\n" + "2) producto" + "\n" + "3) locales" + "\n" + "Ingrese lo que desea modificar: ");
                                        int modificar = leer.nextInt();
                                        switch (modificar) {
                                            case 1:
                                                String ac = "";
                                                System.out.println("-----Moficar personas---");
                                                for (int i = 0; i < persona.size(); i++) {
                                                    ac += i + ")" + persona.get(i) + "\n";
                                                }
                                                System.out.println(ac);
                                                int index = leer.nextInt();
                                                System.out.println("Ingrese el nombre de la persona: ");
                                                leer.nextLine();
                                                nombre = leer.nextLine();
                                                ((personas) persona.get(index)).setNombre(nombre);
                                                System.out.println("Ingrese el id de la persona: ");
                                                id = leer.next();
                                                ((personas) persona.get(index)).setId(id);

                                                System.out.println("Ingrese el nombre de usuario que tendra en el sistema: ");
                                                nombre_usu = leer.next();
                                                ((personas) persona.get(index)).setUsuario(nombre_usu);

                                                System.out.println("Ingrese la contraseña que tendra el usuario:  ");
                                                contra = leer.next();
                                                System.out.println("Ingrese la cantidad de dinero que tiene: ");
                                                dinero = leer.nextDouble();
                                                ((cliente) persona.get(index)).setDinero(dinero);
                                                System.out.println("El nuevo nombre de usuario: ");
                                                nombre_usu = leer.next();
                                                ((cliente) persona.get(index)).setUsuario(nombre_usu);

                                                System.out.println(persona);
                                                break;
                                            case 2:
                                                System.out.println("-----Moficar producto---");
                                                String g = "";

                                                System.out.println("Que tipo de producto sera 1) Comida 2) ropa: ");
                                                tipo = leer.nextInt();
                                                if (tipo == 1) {

                                                    for (int i = 0; i < producto.size(); i++) {
                                                        g += i + ")" + producto.get(i) + "\n";
                                                    }
                                                    System.out.println(g);
                                                    int indice = leer.nextInt();
                                                    System.out.println(g);
                                                    System.out.println("Usted selecciono la comida");
                                                    System.out.println("Ingrese el nombre del platillo: ");
                                                    nombre = leer.next();
                                                    ((productos) producto.get(indice)).setNombre(nombre);
                                                    System.out.println("Ingrese una descripcion: ");
                                                    leer.nextLine();
                                                    String descripcion = leer.nextLine();
                                                    ((productos) producto.get(indice)).setDescripcion(descripcion);

                                                    System.out.println("Ingrese el precio que tendra el platillo " + nombre + ": ");
                                                    double precio = leer.nextDouble();
                                                    ((productos) producto.get(indice)).setPrecio(precio);

                                                    System.out.println("Ingrese si sera (bebida o comida solida): ");
                                                    String tipo_comidaa = leer.next().toLowerCase();
                                                    ((comida) producto.get(indice)).setTipo_comida(tipo_comidaa);

                                                    System.out.println("Ingrese la fecha de vencimiento(yyyy/MM/dd): ");
                                                    String vence = leer.next();
                                                    Date caduce = new Date(vence);
                                                    ((comida) producto.get(indice)).setVence(caduce);

                                                }
                                                if (tipo == 2) {
                                                    for (int i = 0; i < producto.size(); i++) {
                                                        g += i + ")" + producto.get(i) + "\n";
                                                    }
                                                    System.out.println(g);
                                                    int indice = leer.nextInt();
                                                    System.out.println(g);
                                                    System.out.println("Ingrese el nombre de la prenda: ");
                                                    nombre = leer.next();
                                                    ((productos) producto.get(indice)).setNombre(nombre);

                                                    System.out.println("Ingrese una descripcion: ");
                                                    leer.nextLine();
                                                    String descripcion = leer.nextLine();
                                                    ((productos) producto.get(indice)).setDescripcion(descripcion);

                                                    System.out.println("Ingrese el precio que tendra la prenda" + nombre + ": ");
                                                    double precio = leer.nextDouble();
                                                    ((productos) producto.get(indice)).setPrecio(precio);

                                                    System.out.println("Ingrese el genero de prenda (masculino o femenino): ");
                                                    String genero_prenda = leer.next().toUpperCase();
                                                    ((ropa) producto.get(indice)).setGenero_prenda(genero_prenda);

                                                    System.out.println("Ingrese la talla de la prenda: ");
                                                    float talla = (float) leer.nextFloat();
                                                    ((ropa) producto.get(indice)).setTalla(talla);

                                                }

                                                break;
                                            case 3:
                                                String f = "";
                                                for (int i = 0; i < local.size(); i++) {
                                                    f = i + ")" + local.get(i) + "\n";
                                                }
                                                System.out.println(f);
                                                System.out.println("Ingrese el indice que desea modificar : ");
                                                int ind = leer.nextInt();
                                                System.out.println("Ingrese un nuevo nombre para el local: ");
                                                ((locales) local.get(ind)).setNombre_local(nombre_usu);
                                                f = "";
                                                for (int i = 0; i < producto.size(); i++) {
                                                    f = i + ")" + producto.get(i) + "\n";

                                                }

                                                ac = "";
                                                for (int i = 0; i < persona.size(); i++) {
                                                    ac += i + ")" + persona.get(i) + "\n";
                                                }
                                                System.out.println(ac);
                                                System.out.println("Ingrese el indice de la persona que desea añadir: ");
                                                int indice = leer.nextInt();
                                                personas per = persona.get(indice);
                                                ArrayList<personas> perso = new ArrayList();
                                                perso.add(per);
                                                System.out.println("Desea añadir a otra persona en el local s == si / n==no: ");
                                                char deci = leer.next().charAt(0);
                                                while (deci == 's' || deci == 'S') {
                                                    System.out.println(ac);
                                                    System.out.println("Ingrese el indice de la persona que desea añadir: ");
                                                    indice = leer.nextInt();
                                                    per = persona.get(indice);
                                                    perso.add(per);
                                                    System.out.println("desea continuar s==si / n == no: ");
                                                    deci = leer.next().charAt(0);
                                                }
                                                ac = "";
                                                ac = "";
                                                for (int i = 0; i < producto.size(); i++) {
                                                    ac += i + ")" + producto.get(i) + "\n";
                                                }
                                                System.out.println(ac);
                                                System.out.println("Ingrese el indice del producto que desea meter al local: ");
                                                indice = leer.nextInt();
                                                productos perr = producto.get(indice);
                                                ArrayList<productos> produ = new ArrayList<>();

                                                produ.add(perr);
                                                System.out.println("Desea añadir a otra persona en el local s == si / n==no: ");
                                                char dec = leer.next().charAt(0);
                                                while (dec == 's' || dec == 'S') {
                                                    System.out.println(ac);
                                                    System.out.println("Ingrese el indice del producto que desea meter al local: ");
                                                    indice = leer.nextInt();
                                                    perr = producto.get(indice);
                                                    produ.add(perr);
                                                    System.out.println("Desea añadir mas productos al local? s == si / n == no");
                                                    dec = leer.next().charAt(0);

                                                }
                                                ((locales) local.get(ind)).setEmpleados(perso);
                                                ((locales) local.get(ind)).setLista_producto(produ);

                                                break;
                                        }

                                    }

                                    break;
                                case 5:
                                    // borrar
                                    if (persona.size() == 0 || producto.size() == 0 || local.size() == 0) {
                                        System.out.println("DEBEN DE ESTAR TODAS LAAS LISTAS LLENAS SUDO");
                                    } else {
                                        System.out.println("Ingrese que desea borrar " + "\n" + "1) personas" + "\n" + "2) producto" + "\n" + "3) local" + "\n" + "Ingrese que eliminara: ");
                                        int indice = leer.nextInt();

                                        switch (indice) {
                                            case 1:
                                                String ac = "";
                                                for (int i = 0; i < persona.size(); i++) {
                                                    ac += i + ")" + persona.get(i) + "\n";
                                                }
                                                System.out.println(ac);
                                                System.out.println("INDICE A MODIFICAR ");

                                                int index = leer.nextInt();
                                                persona.remove(index);
                                                break;
                                            case 2:
                                                ac = "";
                                                for (int i = 0; i < producto.size(); i++) {
                                                    ac += i + ")" + producto.get(i) + "\n";
                                                }
                                                System.out.println(ac);
                                                System.out.println("INDICE A MODIFICAR ");
                                                index = leer.nextInt();
                                                producto.remove(index);
                                                break;
                                            case 3:
                                                ac = "";
                                                for (int i = 0; i < local.size(); i++) {
                                                    ac += i + ")" + local.get(i) + "\n";
                                                }
                                                System.out.println(ac);
                                                System.out.println("INDICE A MODIFICAR ");

                                                index = leer.nextInt();
                                                local.remove(index);
                                                break;
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                    break;
                case 3: // log in
                    System.out.println("-BIENVENIDO ESTIMADO CLIENTE-");
                    System.out.println("Ingrese su Usuario: ");
                    String nombre = leer.next();
                    System.out.println("Ingrese su contraseña: ");
                    String contr = leer.next();

                    if (acum_usuarios.contains(nombre) && acum_usuarios.contains(contr)) {
                        if (local.size() == 0) {
                            System.out.println("Lo sentimos aun no hay tiendas disponibles ");

                        } else {
                            String d = "";
                            for (int i = 0; i < local.size(); i++) {
                                d += i + ")" + local.get(i) + "\n ";
                            }
                            System.out.println(d);
                            System.out.println("Seleccione a que tienda desea entrar: ");
                            int entrar = leer.nextInt();
                            String s = "";
                            ((locales) local.get(entrar)).getLista_producto();
                            for (int i = 0; i < ((locales) local.get(entrar)).getLista_producto().size();
                                    i++) {
                                s += ((locales) local.get(entrar)).getLista_producto() + "\n";

                            }
                            System.out.println(s);

                            int indi = persona.indexOf(nombre);
                            double dine_cliente = ((cliente) persona.get(indi)).getDinero();

                        }

                    } else {
                        System.out.println("Usuario o contraseña incorrecta");
                    }

                    break;
            }
        }

    }

}
// fin
