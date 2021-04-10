import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Destructor hereda de NaveBuilder
public class Destructor extends NaveBuilder {
    List<Arma> conjuntoDeArmas; //Destructor tiene como minimo 1 Arma
    List<Defensa> conjuntoDefensa; //Destructor tiene 1 o 2 Defensas
    List<Propulsion> prop; //Destructor tiene 1 o 2 tipos de Propulsion
    int tripulantesTotales;
    int numDefensas = numeroDeDefensasMax(); //Max 2
    int potencia = 0;

    //Constructor Destructor
    public Destructor() {
        super();
        this.tripulantesTotales = tripulantesTotales();
        this.prop = conjuntoDePropulsion(); //
        this.conjuntoDeArmas = conjuntoDeArmas();
        this.conjuntoDefensa = sistemaDeDefensa();
    }

    //Cantidad de tripulantes
    @Override
    public int tripulantesTotales() {
        System.out.println("¿Cual es la capacidad de tripulantes del Destructor?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return (s);
    }


    @Override
    //Lista de Defensas del Destructor (Destructor puede tener 1 o 2 defensas)
    public List<Defensa> sistemaDeDefensa() {
        List<Defensa> defensa = new ArrayList<>();
        //Escoger numero de Defensas de Destructor
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas defensas tiene?");
        int e = sc.nextInt();
        //Comprobar que el numero de Defensas es correcto
        while (e > numeroDeDefensasMax() || e < 1) {
            System.out.println("Puede tener como maximo dos defensas, ¿Cuantas posee?(1 o 2)");
            e = sc.nextInt();
        }
        Defensa d;
        //Escoger los tipos de defensas de Destructor
        //Hay que hacer un bucle para asegurar que el valor introducido es correcto
        for (int i = 1; i < e; i++) {
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Escudo");
            System.out.println("2) Blindaje");
            int ef = sc.nextInt();
            while (ef < 1 || ef > 2) {
                System.out.println("El valor es incorrecto.");
                System.out.println("Vuelva a introducir el valor: ");
                System.out.println("1) Escudo");
                System.out.println("2) Blindaje");
                ef = sc.nextInt();
            }
            switch (ef) {
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
        }
        return defensa;
    }

    //Lista de Armas del Destructor (Destructor solo tiene 1 Arma)
    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = new ArrayList<>();
        int arm = 1; //Destructor solo tiene 1 Arma
        //Escoger el tipo de Arma
        for (int i = 1; i <= arm; i++) {
            Arma a = new Arma();
            armas.add(a);
            potencia += a.potencia();
        }
        return armas;
    }

    @Override
    public int potenciaDeAtaque() {
        return potencia;
    }

    //Lista de tipos de Propulsion del Destructor (1 o 2)
    @Override
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        //Preguntar cuantos tipos de Propulsion tiene el Destructor (1 o 2)
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones va a querer?");
        int p = sc.nextInt();
        //Comprobar que el numero de tipos de Propulsion es correcto
        while (p > 2 || p < 1) {
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer(1 o 2)?");
            p = sc.nextInt();
        }
        //Añadir los tipos de Propulsion
        for (int i = 1; i <= p; i++) {
            Propulsion a = new Propulsion(); //Constructor Propulsion
            prop.add(a);
        }
        return prop;
    }

    //El número máximo de Defensas de Destructor es 2
    private final int numeroDeDefensasMax() {
        return 2;
    }

    @Override
    public String toString() {
        return "Destructor: " +
                "\nNumero de Tripulantes" + tripulantesTotales +
                "\nNumero de Defensas" + numDefensas +
                "\nDefensas = " + conjuntoDefensa +
                "\nArmas = " + conjuntoDeArmas +
                "\nPotencia total = " + potencia +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg;
    }
}
