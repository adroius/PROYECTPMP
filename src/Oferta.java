import java.io.*;
import java.util.*;

//Clase Oferta

public class Oferta {
    String nIdentificacion; //Numero de identificacion de Oferta

    //Constructor Oferta
    public Oferta() {
        this.nIdentificacion = numaleatorios();
    }

    private String numaleatorios(){
        int numero = (int)(Math.random()*10000+1000);
        return String.valueOf(Math.abs(numero));
    }

    private void menuOfertas() {

    }

    public void listaDeOfertas() throws IOException {
        List<String> fichero = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial")) {
                System.out.println(fichero.get(i));
            } else if (fichero.get(i).contains("Numero de Identificacion")) {
                System.out.println(fichero.get(i));
            } else if(fichero.get(i).contains("Precio de la nave")){
                System.out.println(fichero.get(i));
            }
        }
    }

    public void construirOferta(String usuarioEntrar) throws IOException {
        String usuarioAmeter = usuarioEntrar;
        List<String> fichero = new ArrayList<>();
        List<String> naves = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userNaves.txt"));
        String line;
        boolean encontrado = false;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        int min = 0;
        int max = fichero.size() - 1;
        String tope = "*";
        if (max != 0 && Sistema.pertenece(usuarioAmeter)) {
            while (!encontrado && max != 0) {
                if (usuarioAmeter.equals(fichero.get(min))) {
                    min = min + 1;
                    while (!(fichero.get(min).equals(tope))) {
                        naves.add(fichero.get(min));
                        min = min + 1;
                    }
                    encontrado = true;
                }
                min = min + 1;
                max = max - 1;
            }
        }
        System.out.println("Que nave desea poner en venta:");
        for (int i = 0; i < naves.size(); i++) {
            if (naves.get(i).contains("Caza") || naves.get(i).contains("Carguero") || naves.get(i).contains("Destructor") || naves.get(i).contains("Estacion Espacial"))
                System.out.println(naves.get(i));
            else if (naves.get(i).contains("Numero de Identificacion")) {
                System.out.println(naves.get(i));
            }
        }
        System.out.println("Introduzca la matricula de la nave que quiera poner en venta:");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();//ya tenemos la nave que queremos
        naves = Sistema.cogerNave(naves, s);
        System.out.println("Introduzca el precio de la nave que va a poner en venta:");
        s = sc.next();//ya tenemos el precio que queremos
        List<String> lecturaOfertas = new ArrayList<>();
        br = new BufferedReader(new FileReader("userOfertas.txt"));
        String lineas;
        while ((lineas = br.readLine()) != null) {
            lecturaOfertas.add(lineas);
        }
        min = 0;
        max = lecturaOfertas.size();
        boolean found=false;
        if (Sistema.pertenece(usuarioAmeter)) {
            if (max != 0) {
                while (!found && max != 0) {
                    if (usuarioAmeter.equals(lecturaOfertas.get(min))) {
                        min=min+1;
                        lecturaOfertas.add(min,"Numero de oferta: "+this.nIdentificacion);
                        min=min+1;
                        lecturaOfertas.add(min,"Precio de la nave: "+s);
                        min=min+1;
                        for (int i = 0; i < naves.size(); i++) {
                            lecturaOfertas.add(min, naves.get(i));
                            min=min+1;
                        }
                        lecturaOfertas.add(min, "-");
                        found = true;
                    } else {
                        min = min + 1;
                        max = max - 1;
                    }
                }
            }
            if (!found){
                lecturaOfertas.add(usuarioAmeter);
                lecturaOfertas.add("Numero de oferta: "+this.nIdentificacion);
                lecturaOfertas.add("Precio de la nave: "+s);
                for (int i = 0; i < naves.size(); i++) {
                    lecturaOfertas.add(naves.get(i));
                }
                lecturaOfertas.add("-");
                lecturaOfertas.add("*");
            }
            FileWriter fw = new FileWriter("userOfertas.txt");
            PrintWriter escritura = new PrintWriter(fw);
            for (int i = 0; i < lecturaOfertas.size(); i++) {
                escritura.println(lecturaOfertas.get(i));
            }
            escritura.close();
        }
    }

    public Date fechaLimite(int c) {
        Date fecha = new Date();
        return fecha;
    }

    public int PrecioOfertaTotal(int c) {

        return c;
    }

    public int ProteccionTotal(int c) {

        return c;
    }

    public int crearVotacion(int c, int d) {

        return c;
    }

    public String crearComentario(int c, int d) {
        String comentario = "";
        return comentario;
    }


}