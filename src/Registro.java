import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {
    String nIdentificacion;

    public Registro() {
        this.nIdentificacion = numaleatorios();
    }

    private String numaleatorios() {
        int numero = (int) (Math.random() * 10000 + 1000);
        return String.valueOf(Math.abs(numero));
    }

    public void crearCarritoDeNaves() throws IOException {
        System.out.println("Inserte la matricula de la nave que desea comprar:");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
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
        boolean encontrado=false;
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).contains(Sistema.usuarioEntrar)) {
                encontrado=true;
                i++;
                while (!carrito.get(i).contains("*")) {
                    carritoIndividual.add(carrito.get(i));
                    i++;
                }
                i = fichero.size();
            }
        }
        if (!encontrado){
            System.out.println("Su carrito esta vacio");
        }
        boolean found=false;
        if (encontrado){
            for (int e = 0; e < fichero.size(); e++) {
                if (fichero.get(e).contains(Sistema.usuarioEntrar)) {
                    found=true;
                    e++;
                    for (int i = 0; i < carritoIndividual.size(); i++) {
                        fichero.add(e, carritoIndividual.get(i));
                        e++;
                    }
                    e = fichero.size();
                }
            }
            if (!found){
                fichero.add(Sistema.usuarioEntrar);
                for (int e = 0; e < carritoIndividual.size(); e++) {
                    fichero.add(carritoIndividual.get(e));
                }
                fichero.add("*");
            }
        }
        FileWriter fw = new FileWriter("registroVentas.txt");
        PrintWriter escritura = new PrintWriter(fw);
        for (int i = 0; i < fichero.size(); i++) {
            escritura.println(fichero.get(i));
        }
        escritura.close();
    }
}