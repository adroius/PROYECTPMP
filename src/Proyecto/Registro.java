package Proyecto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {
    String nIdentificacion;

    //Constructor Registro
    public Registro() {
        this.nIdentificacion = numaleatorios();
    }

    private String numaleatorios() {
        int numero = (int) (Math.random() * 10000 + 1000);
        return String.valueOf(Math.abs(numero));
    }

    /*private Cliente Comprador(String nUser){
        Cliente c = (Comprador(nUser).numeroIdentificacion.equals(nUser));
        return Comprador(nUser);
    }

    private Cliente Vendedor(String nUser) throws IOException {
        List<String> fichero = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(s)) {
                while (!(fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial"))) {
                    i--;
                }
                while (!fichero.get(i).equals("-")) {
                    nave.add(fichero.get(i));
                    i++;
                }
                i = fichero.size();
            }
        }
        return v;
    }   */

    public void crearCarritoDeNaves() throws IOException {
        String matricula="";
        System.out.println("Inserte la matricula de la nave que desea comprar:");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        matricula=s;
        List<String> fichero = new ArrayList<>();
        List<String> nave = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(s)) {
                while (!(fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial"))) {
                    i--;
                }
                while (!fichero.get(i).equals("-")) {
                    nave.add(fichero.get(i));
                    i++;
                }
                i = fichero.size();
            }
        }
        br = new BufferedReader(new FileReader("carritoDeLaCompra.txt"));
        String l;
        fichero.clear();
        while ((l = br.readLine()) != null) {
            fichero.add(l);
        }
        boolean insertado = false;
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(Sistema.usuarioEntrar)) {
                insertado = true;
                int min = i + 1;
                for (int e = 0; e < nave.size(); e++) {
                    fichero.add(min, nave.get(e));
                    min++;
                }
                fichero.add(min, "-");
                i = fichero.size();
            }
        }
        if (!insertado) {
            fichero.add(Sistema.usuarioEntrar);
            for (int e = 0; e < nave.size(); e++) {
                fichero.add(nave.get(e));
            }
            fichero.add("-");
            fichero.add("*");
        }
        FileWriter fw = new FileWriter("carritoDeLaCompra.txt");
        PrintWriter escritura = new PrintWriter(fw);
        for (int i = 0; i < fichero.size(); i++) {
            escritura.println(fichero.get(i));
        }
        escritura.close();
        Oferta.borrarOfertaNave(matricula);
    }

    public int DefensaTotal() throws IOException {
        List<String> fichero = new ArrayList<>();
        List<String> carrito = new ArrayList<>();
        int defensaTotal = 0;
        Nave n= null;
        BufferedReader br = new BufferedReader(new FileReader("carritoDeLaCompra.txt"));
        String carrilista;
        while ((carrilista = br.readLine()) != null) {
            carrito.add(carrilista);
        }
        boolean encontrado = false;
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).contains(Sistema.usuarioEntrar)) {
                carrito.set(i, "");
                encontrado = true;
                i++;
                while (!(carrito.get(i).contains("*"))) {
                    carrito.set(i, "");
                    if ((carrito.get(i).contains("Defensa de la nave:"))) {
                        defensaTotal += n.getDefensaTotal();
                    }
                    i++;
                }
                carrito.set(i, "");
                i = fichero.size();
            }
        }
        System.out.print("Su aguante total es " + defensaTotal);
        return defensaTotal;
    }

    public int PrecioTotal() throws IOException {
        List<String> fichero = new ArrayList<>();
        List<String> carrito = new ArrayList<>();
        int precioTotal = 0;
        Oferta offer= null;
        BufferedReader br = new BufferedReader(new FileReader("carritoDeLaCompra.txt"));
        String carrilista;
        while ((carrilista = br.readLine()) != null) {
            carrito.add(carrilista);
        }
        boolean encontrado = false;
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).contains(Sistema.usuarioEntrar)) {
                carrito.set(i, "");
                encontrado = true;
                i++;
                while (!(carrito.get(i).contains("*"))) {
                    carrito.set(i, "");
                    if ((carrito.get(i).contains("Precio de la nave:"))) {
                        precioTotal += offer.precio;
                    }
                    i++;
                }
                carrito.set(i, "");
                i = fichero.size();
            }
        }
        System.out.print("Su precio total es " + precioTotal);
        return precioTotal;
    }

    public int DanyoTotal() throws IOException {
        List<String> fichero = new ArrayList<>();
        List<String> carrito = new ArrayList<>();
        int danyoTotal = 0;
        Nave n = null;
        BufferedReader br = new BufferedReader(new FileReader("carritoDeLaCompra.txt"));
        String carrilista;
        while ((carrilista = br.readLine()) != null) {
            carrito.add(carrilista);
        }
        boolean encontrado = false;
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).contains(Sistema.usuarioEntrar)) {
                carrito.set(i, "");
                encontrado = true;
                i++;
                while (!(carrito.get(i).contains("*"))) {
                    carrito.set(i, "");
                    if ((carrito.get(i).contains("Potencia total"))) {
                        danyoTotal += n.potenciaDeAtaque();
                    }
                    i++;
                }
                carrito.set(i, "");
                i = fichero.size();
            }
        }
        System.out.print("Su potencia total es " + danyoTotal);
        return danyoTotal;
    }

    public void ejecutarCompra() throws IOException {
        List<String> fichero = new ArrayList<>();
        List<String> carrito = new ArrayList<>();
        List<String> carritoIndividual = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("registroVentas.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        br = new BufferedReader(new FileReader("carritoDeLaCompra.txt"));
        String carrilista;
        while ((carrilista = br.readLine()) != null) {
            carrito.add(carrilista);
        }
        boolean encontrado = false;
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).contains(Sistema.usuarioEntrar)) {
                carrito.remove(i);
                int borrador=i;
                encontrado = true;
                while (!(carrito.get(borrador).contains("*"))) {
                    carritoIndividual.add(carrito.get(borrador));
                    carrito.remove(borrador);
                }
                carrito.remove(borrador);
                i = fichero.size();
            }
        }
        if (!encontrado) {
            System.out.println("Su carrito esta vacio");
        }
        String id;
        boolean found = false;
        if (encontrado) {
            for (int e = 0; e < fichero.size(); e++) {
                if (fichero.get(e).contains(Sistema.usuarioEntrar)) {
                    found = true;
                    e++;
                    for (int i = 0; i < carritoIndividual.size(); i++) {
                        fichero.add(e, carritoIndividual.get(i));
                        e++;
                    }
                    e = fichero.size();
                }
            }
            if (!found) {
                fichero.add(Sistema.usuarioEntrar);
                for (int e = 0; e < carritoIndividual.size(); e++) {
                    fichero.add(carritoIndividual.get(e));
                }
                fichero.add("*");
            }
        }
        FileWriter fw = new FileWriter("carritoDeLaCompra.txt");
        PrintWriter escritura = new PrintWriter(fw);
        for (int i = 0; i < carrito.size(); i++) {
            escritura.println(carrito.get(i));
        }
        escritura.close();

        fw = new FileWriter("registroVentas.txt");
        escritura = new PrintWriter(fw);
        for (int i = 0; i < fichero.size(); i++) {
            escritura.println(fichero.get(i));
        }
        escritura.close();
    }
}