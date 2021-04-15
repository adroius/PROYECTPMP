import java.io.*;
import java.util.*;

//Clase Oferta

public class Oferta {
    String nIdentificacion; //Numero de identificacion de Oferta
    int valoracion;
    String comentario;
    int precio = 0;

//    private String usuarioContraseña(String nombreContraseña) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
//        boolean encontrado = false;
//        String linea = "";
//        String nombre = "";
//        while ((linea = br.readLine()) != null && (!encontrado)) {
//            if (linea.contains(nombreContraseña)) {
//                nombre = linea;
//                encontrado = true;
//            }
//        }
//        if (!encontrado) {
//            System.out.println("Error en los datos introducidos.");
//        }
//        return nombre;
//    }

    //Constructor Oferta
    public Oferta() {
        this.nIdentificacion = numaleatorios();
    }

    private String numaleatorios() {
        int numero = (int) (Math.random() * 10000 + 1000);
        return String.valueOf(Math.abs(numero));
    }

    public void buscadorDeOfertas() throws IOException {
        System.out.println("Que tipo de nave esta buscando:");
        System.out.println("1) Caza");
        System.out.println("2) Destructor");
        System.out.println("3) Carguero");
        System.out.println("4) Estacion espacial");
        System.out.println("5) Buscar a traves de numero de oferta");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String seleccion = "";
        boolean hayOferta;
        switch (s) {
            case 1: {
                System.out.println("Ha seleccionada Caza");
                seleccion = "Caza";
                hayOferta = listaDeOfertas(seleccion);
                break;
            }
            case 2: {
                System.out.println("Ha seleccionada Destructor");
                seleccion = "Destructor";
                hayOferta = listaDeOfertas(seleccion);
                break;
            }
            case 3: {
                System.out.println("Ha seleccionada Carguero");
                seleccion = "Carguero";
                hayOferta = listaDeOfertas(seleccion);
                break;
            }
            case 4: {
                System.out.println("Ha seleccionada Estacion Espacial");
                seleccion = "Estacion Espacial";
                hayOferta = listaDeOfertas(seleccion);
                break;
            }
            case 5: {
                System.out.println("Inserte numero de oferta");
                String st = sc.next();
                hayOferta = buscarOfertaEspecifica(st);
                break;
            }
            //Valor introducido incorrecto
            default:
                throw new IllegalStateException("Unexpected value: " + s); //Ha introducido un numero incorrecto
        }
        if (hayOferta) {
            System.out.println("Desea realizar alguna compra:");
            System.out.println("1) si");
            System.out.println("2) no");
            s = sc.nextInt();
            if (s == 1)
                new Registro();
        } else {
            System.out.println("No se han encontrado ofertas");
        }
    }

    public boolean listaDeOfertas(String c) throws IOException {
        boolean encontrado = false;
        List<String> fichero = new ArrayList<>();
        List<String> naves = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(c)) {
                encontrado = true;
                naves.add(fichero.get(i));
                while (!fichero.get(i).contains("Numero de Identificacion")) {
                    i++;
                }
                naves.add(fichero.get(i));
                i++;
                naves.add(fichero.get(i));
            }
        }
        for (int i = 0; i < naves.size(); i++) {
            System.out.println(naves.get(i));
        }
        return encontrado;
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
        precio = sc.nextInt();//ya tenemos el precio que queremos
        System.out.println("Introduzca la fecha limite en la que caducará la oferta dd/MM/yyyy");
        String d = sc.next();
        List<String> lecturaOfertas = new ArrayList<>();
        br = new BufferedReader(new FileReader("userOfertas.txt"));
        String lineas;
        while ((lineas = br.readLine()) != null) {
            lecturaOfertas.add(lineas);
        }
        min = 0;
        max = lecturaOfertas.size();
        boolean found = false;
        if (Sistema.pertenece(usuarioAmeter)) {
            if (max != 0) {
                while (!found && max != 0) {
                    if (usuarioAmeter.equals(lecturaOfertas.get(min))) {
                        min = min + 1;
                        for (int i = 0; i < naves.size(); i++) {
                            lecturaOfertas.add(min, naves.get(i));
                            min = min + 1;
                        }
                        lecturaOfertas.add(min, "Numero de oferta: " + this.nIdentificacion);
                        min = min + 1;
                        lecturaOfertas.add(min, "Precio de la nave: " + s);
                        min = min + 1;
                        lecturaOfertas.add(min, "Fecha Limite " + d);
                        min = min + 1;
                        lecturaOfertas.add(min, "-");
                        found = true;
                    } else {
                        min = min + 1;
                        max = max - 1;
                    }
                }
            }
            if (!found) {
                lecturaOfertas.add(usuarioAmeter);
                for (int i = 0; i < naves.size(); i++) {
                    lecturaOfertas.add(naves.get(i));
                }
                lecturaOfertas.add("Numero de oferta: " + this.nIdentificacion);
                lecturaOfertas.add("Precio de la nave: " + precio);
                lecturaOfertas.add("Fecha Limite " + d);
                lecturaOfertas.add("-");
                lecturaOfertas.add("*");
            }
            PrintWriter escritura;
            boolean validez = Administrador.ofertaValida(nIdentificacion, usuarioEntrar);
            if (validez) {
                FileWriter fw = new FileWriter("userOfertas.txt");
                escritura = new PrintWriter(fw);
                for (int i = 0; i < lecturaOfertas.size(); i++) {
                    escritura.println(lecturaOfertas.get(i));
                }
                escritura.close();
            }
        }
    }


    public int PrecioOfertaTotal(int c) {

        return c;
    }

    public int ProteccionTotal(int c) {

        return c;
    }


    public void votar(int c, Scanner sc) {
        System.out.println("¿Cual es su valoración?");
        c = sc.nextInt();
        this.valoracion = c;
        try {
            FileWriter escribir = new FileWriter("usuarioInfo.txt");
            escribir.write(this.valoracion);
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error en la valoracion");
        }
    }

    public void comentar(Scanner sc) {
        boolean exit = false;
        System.out.println("¿Desea realizar un comentario?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int c = sc.nextInt();
        switch (c) {
            case 1: {
                exit = false;
                System.out.println("¿Que comentario desea realizar?");
                String s = sc.next();
                this.comentario = s;
                try {
                    FileWriter escribir = new FileWriter("usuarioInfo.txt");
                    escribir.write(this.comentario);
                    escribir.close();
                } catch (Exception e) {
                    System.out.println("Error escribiendo el comentario");
                }
                break;
            }
            case 2: {
                exit = true;
                break;
            }
            default:
                throw new IllegalStateException("Valor no valido");
        }
        while (!exit) ;
    }

    public boolean buscarOfertaEspecifica(String numOferta) throws IOException {
        boolean encontrado = false;
        List<String> fichero = new ArrayList<>();
        List<String> nave = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(numOferta)) {
                encontrado = true;
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
        for (int i = 0; i < nave.size(); i++) {
            System.out.println(nave.get(i));
        }
        return encontrado;
    }
}