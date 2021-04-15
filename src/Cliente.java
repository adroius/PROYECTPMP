import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Cliente {
    protected String Nombre;
    protected String PlanetaOrigen;
    protected String Especie;
    protected String numeroIdentificacion;
    List<Nave> NavesEnPropiedad;
    private String Nick;
    private String email;
    boolean isKromagg;
    boolean isPirata;
    boolean isFraude;
    int nAdvertencias = 0;

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


    public boolean suscribirseAUnaOferta() throws IOException {
        String nOferta = "";
        boolean suscribirse = false;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        Oferta offer = null;
        System.out.println("Digame el numero de identificacion de la oferta a la que deseas suscribirte, si no deseas suscribirte a ninguna oferta escriba 'No'. ");
        nOferta = sc.next();
        if (nOferta.equals("No") || nOferta.equals("no") || nOferta.equals("NO")){
            suscribirse=false;
        } else{
            if (offer.buscarOfertaEspecifica(nOferta)) {
                System.out.println("¿Quieres suscribirte a esta oferta?");
                System.out.println("1) Si");
                System.out.println("2) No");
                int s = sc.nextInt();
                switch (s) {
                    case 1: {
                        suscribirse = true;
                        exit = true;
                        break;
                    }
                    case 2: {
                        suscribirse = false;
                        exit = true;
                        break;
                    }
                    default:
                        throw new IllegalStateException("Valor no valido");
                }
            }
            while (!exit) ;
        }
        return suscribirse;
    }

    //Escribir la Informacion del Cliente
    public void escribirInfo(String u,String c) {
        try {
            FileWriter escribir = new FileWriter("usuarioInfo.txt");
            escribir.write(this.numeroIdentificacion);
            escribir.write("\n");
            escribir.write(u+c);
            escribir.write("\n");
            escribir.write(this.Nombre);
            escribir.write("-");
            escribir.write(this.PlanetaOrigen);
            escribir.write("-");
            escribir.write(this.Especie);
            escribir.write("-");
            escribir.write(this.Nick);
            escribir.write("-");
            escribir.write(this.email);
            escribir.write("\n");
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    //Escribe en pantalla el numero de Advertencias del Cliente
    public void numeroAdvertencias(String nIdentificacion) {
        boolean encontrado = comprobarNIdentificacion(nIdentificacion);
        if (encontrado) {
            System.out.println("Llevas " + nAdvertencias + " advertencias");
        }
        if (nAdvertencias==2){
            noEntrarAlSistemaPorAdvertencias();
        }
    }

    //Comprueba que uno de los Clientes registrados tiene el Numero de Identificacion introducido
    private boolean comprobarNIdentificacion(String nIdentificacion) {
        boolean encontrado = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
            String linea;
            while ((linea = br.readLine()) != null && (!encontrado)) {
                if (linea.contains(nIdentificacion)) {
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Error en los datos introducidos.");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return encontrado;
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
    //Hay que hacer este metodo cuando hagamos la base de datos
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
    private boolean noEntrarAlSistemaPorAdvertencias() {
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
        while (isFraude==true) {
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
