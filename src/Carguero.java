import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Carguero hereda de NaveBuilder
public class Carguero extends NaveBuilder {
    int tripulantesMax = 0;
    int carga = 0;
    List<Defensa> defensa;
    List<Propulsion> prop;
    int numDefensas=numeroDeDefensasMax();

    //Constructor Carguero
    public Carguero() {
        this.tripulantesMax = tripulantes();
        this.carga = carga();
        this.defensa = tipoDeDefensa();
        this.prop = conjuntoDePropulsion();
    }

    //Cantidad de tripulantes
    @Override
    public int tripulantes() {
        System.out.println("¿Cuanto va a ser la capacidad maxima de tripulantes del carguero?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return s;
    }

    //Lista de defensa
    @Override
    public List<Defensa> tipoDeDefensa() {
        int def=numDefensas;
        List<Defensa> defensa = new ArrayList<>();
        do {
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Escudo");
            System.out.println("2) Blindaje");
            Scanner sc = new Scanner(System.in);
            int e = sc.nextInt();
            Defensa d;
            switch (e) {
                case 1:
                    d = new Escudo();
                    defensa.add(d);
                    break;
                case 2:
                    d = new Blindaje();
                    defensa.add(d);
                    break;
                default:
                    throw new IllegalStateException("Valor incorrecto: " + e);
            }
            def=def-1;
        } while (def!=0);
        return defensa;
    }

    @Override
    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = new ArrayList<>();
        Arma a = new Arma();
        armas.add(a);
        return armas;
    }

    @Override
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones va a querer?");
        int i = sc.nextInt();
        while (i > 2 || i <= 0) {
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer(1 o 2)?");
            i = sc.nextInt();
        }
        do {
            Propulsion a = new Propulsion();
            prop.add(a);
            i = i - 1;
        } while (i != 0);
        return prop;
    }

    @Override
    public int numeroDeDefensasMax() {
        return 1;
    }

    @Override
    public String toString() {
        return "Carguero{" +
                "tripulantesMax=" + tripulantesMax +
                ", carga=" + carga +
                ", defensa=" + defensa +
                ", prop=" + prop +
                ", numDefensas=" + numDefensas +
                ", numidentificacion=" + numReg +
                '}';
    }

    public int carga() {
        System.out.println("Introduzca la carga maxima: ");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        return c;
    }
}
