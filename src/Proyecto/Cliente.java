package Proyecto;

import java.io.*;
import java.util.*;

public class Cliente {
    protected String Nombre;
    protected String PlanetaOrigen;
    protected String Especie;
    protected String numeroIdentificacion;
    List<Nave> NavesEnPropiedad;
    protected String Nick;
    protected String email;
    boolean isKromagg;
    boolean isPirata;
    boolean isFraude;
    static int nAdvertencias = 0;

    //Constructor Cliente
    public Cliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cual es su nombre?");
        String s = sc.next();
        this.Nombre = s;
        System.out.println("¿Cual es su Planeta de Origen?");
        s = sc.next();
        this.PlanetaOrigen = s;
        System.out.println("¿Cual es su Especie?");
        s = sc.next();
        this.Especie = s;
        System.out.println("¿Cual es su numero de identificacion?");
        s = sc.next();
        this.numeroIdentificacion = s;
        this.NavesEnPropiedad = null;
        System.out.println("¿Cual es su Nick?");
        s = sc.next();
        this.Nick = s;
        System.out.println("¿Cual es su email?");
        s = sc.next();
        this.email = s;
        this.isKromagg = isKromagg();
        this.isPirata = isPirata();
        this.isFraude = isFraude();
    }

    //Suscribirse a una Oferta Especifica
    public static boolean suscribirseAUnaOferta(String tipoNave) throws IOException {
        boolean suscribirse;
        Scanner sc = new Scanner(System.in);
        System.out.println("Â¿Quieres suscribirte a esta oferta?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int s = sc.nextInt();
        switch (s) {
            case 1: {
                suscribirse = true;
                try {
                    BufferedReader br = new BufferedReader(new FileReader("suscriptoresOferta.txt"));
                    List<String> fichero = new ArrayList<>();
                    boolean encontrado = false;
                    boolean ofertaEnElFichero = false;
                    String line;
                    while ((line = br.readLine()) != null){
                        fichero.add(line);
                    }
                    while (br.readLine() != null && !ofertaEnElFichero) {
                        ofertaEnElFichero = (br.readLine() == tipoNave);
                    }
                    if (!ofertaEnElFichero) {
                        fichero.add(tipoNave);
                        fichero.add(Sistema.usuarioEntrar);
                        fichero.add("-");
                    } else {
                        while (br.readLine() != "-" && !encontrado) {
                            encontrado = (br.readLine() == Sistema.usuarioEntrar);
                        }
                        if (encontrado) {
                            System.out.print("Ya estas suscrito a esta oferta");
                        } else {
                            fichero.add(Sistema.usuarioEntrar);
                            fichero.add("-");
                        }
                        FileWriter fw = new FileWriter("suscriptoresOferta.txt");
                        PrintWriter escribir = new PrintWriter(fw);
                        for (int i = 0; i < fichero.size(); i++) {
                            escribir.println(fichero.get(i));
                        }
                        escribir.close();
                    }
                } catch (Exception e) {
                    System.out.println("Error al suscribirte");
                }
                break;
            }
            case 2: {
                suscribirse = false;
                break;
            }
            default:
                throw new IllegalStateException("Valor no valido");
        }
        return suscribirse;
    }

    //Escribe en pantalla el numero de Advertencias del Cliente

    public static void comprobarAdvertencias(String ad) {
            if (Integer.parseInt(ad)>= 2) {
                noEntrarAlSistemaPorAdvertencias();
            }
    }

    //Queda pasarle el usuario y poco más
    public static void verNotificaciones(String user) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("usernotificaciones.txt"));
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.println("¿Deseas ver una notificación?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int respuesta = sc.nextInt();
        switch (respuesta) {
            case 1: {
                while (br.readLine() != user && br.readLine() != null) {
                }
                FileWriter fw = new FileWriter("usernotificaciones.txt");
                PrintWriter escribir = new PrintWriter(fw);
                if(br.readLine()== null){
                    System.out.println("No tienes notificaciones");
                } else {
                    while ((line = br.readLine()) != "-" && line != null) {
                        System.out.println(line);
                        escribir.println("");
                    }
                }
                escribir.close();
            }
            break;
            case 2: {
                break;
            }
            default:
                throw new IllegalStateException("Valor no valido: ");
        }
    }
    //Comprobar si es de la especie Kromagg
    protected boolean isKromagg() {
        boolean is = false;
        if (this.Especie.contains("Kromagg") || this.Especie.contains("kromagg")) {
            is = true;
            new Kromagg();
        }
        return is;
    }

    //Comprobar si es Sospechoso de Pirateria
    private boolean isPirata() {
        boolean is = this.isPirata;
        if (is) {
            comprarNavePirata();
        }
        return is;
    }

    //Comprobar si es Sospechoso de Fraude
    private boolean isFraude() {
        boolean is = this.isFraude;
        if (is) {
            noEntrarAlSistemaFraude();
        }
        return is;
    }

    //Menu de Compra para los Sospechosos de Pirateria (Solo pueden comprar Cargueros)
    private boolean comprarNavePirata() {
        Nave n;
        boolean compra;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres comprar un carguero?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int s = sc.nextInt();
        switch (s) {
            case 1: {
                n = new Carguero();
                compra = true;
                break;
            }
            case 2: {
                compra = false;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
        return compra;
    }

    //Impide entrar al Sistema durante 5 días si el Cliente tiene 2 advertencias
    public static boolean noEntrarAlSistemaPorAdvertencias() {
        Timer timer = new Timer();
        int seconds = 432000;
        boolean bloqueoFinalizado = (seconds != 0);
        TimerTask bloqueo = new TimerTask() {
            @Override
            public void run() {
                System.out.println("No puedes entrar al sistema");
            }
        };
        while (bloqueoFinalizado) {
            seconds -= 1;
            timer.schedule(bloqueo, 0, 1000);
        }
        nAdvertencias = 0; //Devuelve el numero de Advertencias a 0
        return bloqueoFinalizado;
    }

    //Impide entrar al Sistema mientras el Cliente sea Sospechoso de Pirateria
    private boolean noEntrarAlSistemaFraude() {
        boolean bloqueoFinalizado = true;
        while (isFraude == true) {
            bloqueoFinalizado = false;
            System.out.println("No puedes entrar al sistema");
        }
        return bloqueoFinalizado;
    }

    @Override
    public String toString() {
        return "Cliente: " + "\nNombre= " + Nombre +
                "\nPlanetaOrigen= " + PlanetaOrigen +
                "\nEspecie= " + Especie +
                "\nNumero Identificacion= " + numeroIdentificacion +
                "\nNaves En Propiedad=" + NavesEnPropiedad +
                "\nNick=" + Nick +
                "\nEmail='" + email;
    }
}

