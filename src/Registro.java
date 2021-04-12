import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {
    String nIdentificacion;

    public Registro(){
        this.nIdentificacion = numaleatorios();
        menu();
    }

    public void menu() throws IOException {
        System.out.println("1) Añadir al carrito");
        System.out.println("2) Comprar directamente");
        Scanner sc=new Scanner(System.in);
        int s= sc.nextInt();
        switch (s){
            case 1-> {
                crearCarritoDeNaves();
            }
            case 2-> {
                ejecutarCompra();
            }
        }

    }

    private String numaleatorios(){
        int numero = (int)(Math.random()*10000+1000);
        return String.valueOf(Math.abs(numero));
    }

    public void crearCarritoDeNaves() throws IOException {
        System.out.println("Inserte la matricula de la nave que desea comprar:");
        Scanner sc=new Scanner(System.in);
        String s= sc.next();
        List<String> fichero = new ArrayList<>();
        List<String> nave = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(s)) {
                while (!(fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial"))){
                    i--;
                }
                while (!fichero.get(i).equals("-")){
                    nave.add(fichero.get(i));
                    i++;
                }
                i = fichero.size();
            }
        }
    }

    public void ejecutarCompra() throws IOException {
        List<String> fichero = new ArrayList<>();
        List<String> carrito = new ArrayList<>();
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

    }
}
