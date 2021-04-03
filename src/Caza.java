import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Caza extends NaveBuilder {
    int tripulantesMax; //
    List<Defensa> defensa;
    List<Arma> conjuntoDeArmas;
    List<Propulsion> prop;
    int numDefensas=numeroDeDefensasMax();

    public Caza() {
        super();
        this.tripulantesMax = tripulantes();
        this.defensa = tipoDeDefensa();
        this.prop = conjuntoDePropulsion();
        this.conjuntoDeArmas = conjuntoDeArmas();
    }

    public int tripulantes() {
        System.out.println("La capacidad es de solo un tripulante.");
        int s = 1;
        return s;
    }

    @Override
    public String toString() {
        return "Caza{" +
                "tripulantesMax=" + tripulantesMax +
                ", defensa=" + defensa +
                ", conjuntoDeArmas=" + conjuntoDeArmas +
                ", prop=" + prop +
                ", numDefensas=" + numDefensas +
                ", numidentificacion=" + numReg +
                '}';
    }

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

    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas armas va a querer?");
        int i = sc.nextInt();
        while (i > 2 || i <= 0) {
            System.out.println("La capacidad del caza para portar armas es limitada");
            System.out.println("¿Cuantas armas va a querer(1 o 2)?");
            i = sc.nextInt();
        }
        do {
            Arma a = new Arma();
            armas.add(a);
            i = i - 1;
        } while (i != 0);
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
}
