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

    /*public List<Nave> navesEnVenta() {

    }*/

    public void crearOferta() throws FileNotFoundException {
        Registro oferta;
        oferta = new Registro();
        Scanner sc = new Scanner(System.in);
        int numBid = sc.nextInt();
    }

    public boolean suscribirseAUnaOferta(int nOferta) {
        boolean suscribirse = false;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        if (comprobarNOferta(nOferta)) {
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
        return suscribirse;
    }

    private boolean comprobarNOferta(int nOferta) {
        Scanner sc = new Scanner(System.in);
        nOferta = sc.nextInt();
        String idenOferta = String.valueOf(nOferta);
        boolean encontrado = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("ofertaInfo.txt"));
            String linea = "";
            while (((linea = br.readLine()) != null) && (!encontrado)) {
                if (linea.equalsIgnoreCase(idenOferta)) {
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

    public void escribirInfo() {
        try {
            FileWriter escribir = new FileWriter("usuarioInfo.txt");
            escribir.write(this.numeroIdentificacion);
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

    public boolean modificarOferta(String nIdentificacion, int nOferta) {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Pon su numero de identificacion");
        nIdentificacion = sc.next();
        if (comprobarNIdentificacion(nIdentificacion)) {
            System.out.print("Pon su numero de identificacion");
            nOferta = sc.nextInt();
            if (comprobarNOferta(nOferta)) {
                System.out.println("¿Quieres modificar esta oferta?");
                System.out.println("1) Si");
                System.out.println("2) No");
                int s = sc.nextInt();
                switch (s) {
                    case 1: {
                        exit = true;
                        break;
                    }
                    case 2: {
                        exit = true;
                        break;
                    }
                    default:
                        throw new IllegalStateException("Numero no valido, ponga otro numero " + s);
                }
            }
            while (!exit) ;
        }
        return exit;
    }


    public int numeroAdvertencias(String nIdentificacion) {
        boolean encontrado = comprobarNIdentificacion(nIdentificacion);
        if (encontrado) {
            System.out.println("Llevas " + nAdvertencias + " advertencias");
        }
        return nAdvertencias;
    }

    private boolean comprobarNIdentificacion(String nIdentificacion) {
        Scanner sc = new Scanner(System.in);
        nIdentificacion = sc.next();
        boolean encontrado = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
            String linea = "";
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
        if (this.Especie == "Kromagg" || this.Especie == "kromagg") {
            is = true;
            Kromagg p = new Kromagg();
            p.KromaggNave();
        }
        return is;
    }

    //Comprobar si es Sospechoso de Pirateria
    //Hay que hacer este metodo cuando hagamos la base de datos
    private boolean isPirata() {
        boolean is = false;
        if (this.isPirata) {
            is = true;
            comprarNavePirata();
        }
        return is;
    }

    //Comprobar si es Sospechoso de Fraude
    //Hay que hacer este metodo cuando hagamos la base de datos
    private boolean isFraude() {
        boolean is = false;
        if (this.isFraude) {
            noEntrarAlSistema();
            is = true;
        }
        return is;
    }

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

    private boolean noEntrarAlSistema() {
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
        return bloqueoFinalizado;
    }

    @Override
    public String toString() {
        return "Cliente: " + "\nNombre= " + Nombre + "\nPlanetaOrigen= " + PlanetaOrigen + "\nEspecie= " + Especie + "\nNumero Identificacion= " + numeroIdentificacion + "\nNaves En Propiedad=" + NavesEnPropiedad + "\nNick=" + Nick + "\nEmail='" + email;
    }
}
