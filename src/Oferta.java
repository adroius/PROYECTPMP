import java.io.*;
import java.util.*;

//Clase Oferta
public class Oferta {
    String nIdentificacion; //Numero de identificacion de Oferta
    int valoracion;
    String comentario;
    int precio = 0;

    //Constructor Oferta
    public Oferta() {
        this.nIdentificacion = numaleatorios();
    }

    public static void modificarOferta(String id) throws IOException {
        List<String> fichero = new ArrayList<>();
        List<String> nave = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        int min = 0;
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(id)) {

                while (!(fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial"))) {
                    i--;
                }
                min = i;
                while (!fichero.get(i).equals("-")) {
                    nave.add(fichero.get(i));
                    i++;
                }
                i = fichero.size();
            }
        }
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println("Modifique cada valor debajo de su valor original:");
        min++;
        for (int i = 1; i < nave.size(); i++) {
            if (nave.get(i).contains("Precio de la nave")) {
                System.out.println(nave.get(i));
                s = sc.next();
                nave.set(i, "Precio de la nave " + s);
                fichero.set(min, nave.get(i));
            } else if (nave.get(i).contains("Fecha Limite")) {
                System.out.println(nave.get(i));
                s = sc.next();
                nave.set(i, "Fecha Limite " + s);
                fichero.set(min, nave.get(i));
            }
            min++;
        }
        FileWriter fw = new FileWriter("userOfertas.txt");
        PrintWriter escritura = new PrintWriter(fw);
        for (int i = 0; i < fichero.size(); i++) {
            escritura.println(fichero.get(i));
        }
        escritura.close();
    }

    //Crea el nIdentificacion de la oferta
    private String numaleatorios() {
        int numero = (int) (Math.random() * 10000 + 1000);
        return String.valueOf(Math.abs(numero));
    }

    //Buscador de Ofertas para Kromagg sin Licencia
    //Buscador de Cazas, Cargueros u Ofertas Especificas
    public void buscadorDeOfertasKromggSinLicencia() throws IOException {
        System.out.println("Que tipo de nave esta buscando:");
        System.out.println("1) Caza");
        System.out.println("2) Carguero");
        System.out.println("3) Buscar a traves de numero de oferta");
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
                System.out.println("Ha seleccionada Carguero");
                seleccion = "Carguero";
                hayOferta = listaDeOfertas(seleccion);
                break;
            }
            case 3: {
                System.out.println("Inserte numero de oferta");
                String st = sc.next();
                hayOferta = buscarOfertaEspecifica(st);
                break;
            }
            //Valor introducido incorrecto
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
        if (hayOferta) {
            System.out.println("Desea realizar alguna compra:");
            System.out.println("1) si");
            System.out.println("2) no");
            s = sc.nextInt();
            if (s == 1)
                new Registro().crearCarritoDeNaves();
        } else {
            System.out.println("No se han encontrado ofertas");
        }
    }

    //Buscador de Ofertas para todas las naves y Ofertas Especificas
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
                throw new IllegalStateException("Unexpected value: " + s);
        }
        if (hayOferta) {
            System.out.println("Desea realizar alguna compra:");
            System.out.println("1) si");
            System.out.println("2) no");
            s = sc.nextInt();
            if (s == 1)
                new Registro().crearCarritoDeNaves();
        } else {
            System.out.println("No se han encontrado ofertas");
        }
    }

    //Muestra las ofertas guardadas en registro
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
                while (!fichero.get(i).equals("-")) {
                    naves.add(fichero.get(i));
                    i++;
                }
            }
        }
        for (int i = 0; i < naves.size(); i++) {
            System.out.println(naves.get(i));
        }
        return encontrado;
    }

    //Crea una Oferta de Naves registradas por el Cliente
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
        String naveElegida = "";
        boolean found = false;
        if (Sistema.pertenece(usuarioAmeter)) {
            if (max != 0) {
                while (!found && max != 0) {
                    if (usuarioAmeter.equals(lecturaOfertas.get(min))) {
                        min = min + 1;
                        naveElegida = naves.get(0);
                        for (int i = 0; i < naves.size(); i++) {
                            lecturaOfertas.add(min, naves.get(i));
                            min = min + 1;
                        }
                        lecturaOfertas.add(min, "Numero de oferta: " + this.nIdentificacion);
                        min = min + 1;
                        lecturaOfertas.add(min, "Precio de la nave: " + precio);
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
                naveElegida = naves.get(0);
                for (int i = 0; i < naves.size(); i++) {
                    lecturaOfertas.add(naves.get(i));
                }
                lecturaOfertas.add("Numero de oferta: " + this.nIdentificacion);
                lecturaOfertas.add("Precio de la nave: " + precio);
                lecturaOfertas.add("Fecha Limite " + d);
                lecturaOfertas.add("-");
                lecturaOfertas.add("*");
            }
            boolean validez = Administrador.ofertaValida(nIdentificacion, usuarioEntrar, precio, naveElegida);
            if (validez) {
                FileWriter fw = new FileWriter("userOfertas.txt");
                PrintWriter escritura = new PrintWriter(fw);
                for (int i = 0; i < lecturaOfertas.size(); i++) {
                    escritura.println(lecturaOfertas.get(i));
                }
                escritura.close();
            } else {
                System.out.println("No se permite insertar esa nave.");
            }
        }
    }

    //Guarda la valoracion echa por el comprador
    public void votar(int c, Scanner sc) {
        System.out.println("¿Cual es su valoración?");
        c = sc.nextInt();
        this.valoracion = c;
        try {
            FileWriter escribir = new FileWriter("userInfo.txt");
            escribir.write(this.valoracion);
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error en la valoracion");
        }
    }

    //Guarda el comentario echo por el comprador
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
                    FileWriter escribir = new FileWriter("userInfo.txt");
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

    //Busca una Oferta especifica a partir del Numero de Identificacion de la Oferta
    public static boolean buscarOfertaEspecifica(String numOferta) throws IOException {
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

    //Borra una Oferta del Registro
    public static void borrarOferta(String numOferta) throws IOException {
        List<String> fichero = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(numOferta)) {
                while (!(fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial"))) {
                    i--;
                }
                while (!fichero.get(i).equals("-")) {
                    fichero.remove(i);
                }
                fichero.remove(i);
                i = fichero.size();
            }
        }
        FileWriter fw = new FileWriter("userOfertas.txt");
        PrintWriter escritura = new PrintWriter(fw);
        for (int i = 0; i < fichero.size(); i++) {
            escritura.println(fichero.get(i));
        }
        escritura.close();

    }

}