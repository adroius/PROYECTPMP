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

    private String Comprador() {
        return Sistema.usuarioEntrar;
    }

    public String Vendedor() throws IOException {
        List<String> fichero = new ArrayList<>();
        List<String> matriculas = new ArrayList<>();
        String usuarios = "";
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("carritoDeLaCompra.txt"));
        String line;
        String line2;
        while ((line2 = br2.readLine()) != null) {
            if (line2.contains("Numero de Identificacion =")) {
                matriculas.add(line2);
            }
        }
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int j = 0; j < matriculas.size(); j++) {
            for (int i = 0; i < fichero.size(); i++) {
                if (fichero.get(i).contains(matriculas.get(j))) {
                    while (!(fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial"))) {
                        i--;
                    }
                    i--;
                    usuarios += fichero.get(i);
                    usuarios += " - ";
                    usuarios += matriculas.get(j);
                    usuarios += "\n";
                    while (!fichero.get(i).equals("*")) {
                        i++;
                    }
                    i = fichero.size();
                }
            }
        }
        return usuarios;
    }

    public void crearCarritoDeNaves() throws IOException {
        String matricula = "";
        System.out.println("Inserte la matricula de la nave que desea comprar:");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        matricula = s;
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

    public String DefensaTotal() throws IOException {
        List<String> carrito = new ArrayList<>();
        int defensaTotal = 0;
        BufferedReader br = new BufferedReader(new FileReader("carritoDeLaCompra.txt"));
        String carrilista;
        while ((carrilista = br.readLine()) != null) {
            carrito.add(carrilista);
        }
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).equals(Comprador())) {
                while (!carrito.get(i).equals("*") && !carrito.get(i).equals(null)) {
                    if (carrito.get(i).contains("DaÃ±o Absorbido= ")) {
                        String potencia = carrito.get(i);
                        String[] parts = potencia.split("= ");
                        String[] part = parts[1].split("]");
                        String part2 = part[0];
                        defensaTotal += Integer.parseInt(part2);
                    }
                    i++;
                }
            }

        }
        String line = "Su defensa total es " + defensaTotal;
        return line;
    }


    public String PrecioTotal() throws IOException {
        List<String> carrito = new ArrayList<>();
        int precioTotal = 0;
        BufferedReader br = new BufferedReader(new FileReader("carritoDeLaCompra.txt"));
        String carrilista;
        while ((carrilista = br.readLine()) != null) {
            carrito.add(carrilista);
        }
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).equals(Comprador())) {
                while (!carrito.get(i).equals("*") && !carrito.get(i).equals(null)) {
                    if (carrito.get(i).contains("Precio de la nave ")) {
                        String potencia = carrito.get(i);
                        String[] parts = potencia.split("nave ");
                        String part2 = parts[1];
                        precioTotal += Integer.parseInt(part2);
                    }
                    i++;
                }
            }

        }
        String line = "Su precio total es " + precioTotal;
        return line;
    }


    public String DanyoTotal() throws IOException {
        List<String> carrito = new ArrayList<>();
        int danyoTotal = 0;
        BufferedReader br = new BufferedReader(new FileReader("carritoDeLaCompra.txt"));
        String carrilista;
        while ((carrilista = br.readLine()) != null) {
            carrito.add(carrilista);
        }
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).equals(Comprador())) {
                while (!carrito.get(i).equals("*") && !carrito.get(i).equals(null)) {
                    if (carrito.get(i).contains("Potencia total =")) {
                        String potencia = carrito.get(i);
                        String[] parts = potencia.split("= ");
                        String part2 = parts[1];
                        danyoTotal += Integer.parseInt(part2);
                    }
                    i++;
                }
            }
        }
        String line = "Su potencia total es " + danyoTotal;
        return line;
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
                int borrador = i;
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
                if (fichero.get(e).contains(Comprador())) {
                    found = true;
                    e++;
                    for (int i = 0; i < carritoIndividual.size(); i++) {
                        fichero.add(e, carritoIndividual.get(i));
                        e++;
                    }
                    fichero.add(PrecioTotal());
                    fichero.add(DefensaTotal());
                    fichero.add(DanyoTotal());
                    fichero.add(Vendedor());
                    fichero.add("-");
                    e = fichero.size();
                }
            }
            if (!found) {
                fichero.add(Comprador());
                for (int e = 0; e < carritoIndividual.size(); e++) {
                    fichero.add(carritoIndividual.get(e));
                }
                fichero.add(PrecioTotal());
                fichero.add(DefensaTotal());
                fichero.add(DanyoTotal());
                fichero.add(Vendedor());
                fichero.add("-");
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
        System.out.println("¿Desea realizar una votacion?");
        System.out.println("1) Si");
        System.out.println("2) No");
        Scanner sc=new Scanner(System.in);
        int e=sc.nextInt();
        if (e == 1) {
            Oferta.votar();
        }
        System.out.println("¿Desea realizar una comentario?");
        System.out.println("1) Si");
        System.out.println("2) No");
        e=sc.nextInt();
        if (e == 1) {
            Oferta.comentar();
        }

    }
}