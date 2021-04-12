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

  /*  public boolean suscribirseAUnaOferta(String nOferta) {
        boolean suscribirse = false;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        Sistema sistem = null;
        if (sistem.comprobarNOferta(nOferta)) {
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
*/
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

  /*  public boolean modificarOferta(String nIdentificacion, String nOferta) {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Pon su numero de identificacion");
        nIdentificacion = sc.next();
        if (comprobarNIdentificacion(nIdentificacion)) {
            System.out.print("Pon el numero de identificacion de la oferta que deseas modificar");
            nOferta = sc.next();
            Sistema sistem = null;
            if (sistem.comprobarNOferta(nOferta)) {
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
*/

    //Escribe por pantalla el numero de Advertencias del cliente y si tiene 2 impide que entre en el Sistema
    public int numeroAdvertencias(String nIdentificacion) {
        boolean encontrado = comprobarNIdentificacion(nIdentificacion);
        if (encontrado) {
            System.out.println("Llevas " + nAdvertencias + " advertencias");
        }
        if (nAdvertencias==2){
            noEntrarAlSistemaPorAdvertencias();
        }
        return nAdvertencias;
    }

    //Comprobar que el Numero de Identificacion pertenece a un Cliente
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

    //Comprobar si el Cliente es de la especie Kromagg
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
            noEntrarAlSistema();
        }
        return is;
    }

    //Menu de compra de los Sospechosos de Pirateria (Solo pueden comprar Cargueros)
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

    //No deja entrar al Sistema durante 5 días
    private boolean noEntrarAlSistemaPorAdvertencias() {
        nAdvertencias = 0; //Reinicia el conteo de advertencias
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

    //No permite entrar en el Sistema si eres Sospechoso de Fraude
    private boolean noEntrarAlSistema() {
        boolean bloqueoFinalizado = true;
        while (isFraude) {
            bloqueoFinalizado = false;
            System.out.println("No puedes entrar al sistema");
        }
        return bloqueoFinalizado;
    }

    @Override
    public String toString() {
        return "Cliente: " + "\nNombre= " + Nombre + "\nPlanetaOrigen= " + PlanetaOrigen + "\nEspecie= " + Especie + "\nNumero Identificacion= " + numeroIdentificacion + "\nNaves En Propiedad=" + NavesEnPropiedad + "\nNick=" + Nick + "\nEmail='" + email;
    }
}
