import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Carguero hereda de NaveBuilder
public class Carguero extends NaveBuilder {
    int tripulantesMax = 0; //Inicializar la variable
    int carga = 0; //Inicializar la variable
    List<Defensa> defensa; //Carguero solo puede tener 1 defensa
    List<Propulsion> prop; //Carguero tiene 1 o 2 tipos de propulsion
    int numDefensas=numeroDeDefensasMax(); //Carguero tiene un Maximo de 1

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

    //Lista de defensas del Carguero (Carguero solo puede tener una defensa)
    @Override
    public List<Defensa> tipoDeDefensa() {
        int def = numDefensas;
        List<Defensa> defensa = new ArrayList<>();
        //Escoger el tipo de Defensa del Carguero

        //Hay que hacer un bucle para asegurarse de que el valor introducido es correcto
        //Tiene más sentido hacer un bucle for
        do {
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Escudo");
            System.out.println("2) Blindaje");
            Scanner sc = new Scanner(System.in);
            int e = sc.nextInt();
            Defensa d;
            switch (e) {
                case 1:
                    d = new Escudo(); //Constructor Escudo
                    defensa.add(d);
                    break;
                case 2:
                    d = new Blindaje(); //Constructor Blindaje
                    defensa.add(d);
                    break;
                //Si el valor introducido no es correcto
                default:
                    throw new IllegalStateException("Valor incorrecto: " + e);
            }
            def = def - 1;
        } while (def != 0);
        return defensa;
    }

    @Override
    //Cargueros no tiene armas
    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = null;
        return armas;
    }

    @Override
    //Lista de tipos de Propulsion (1 o 2)
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones va a querer?");
        int i = sc.nextInt();
        //Preguntar cuantos tipos de Propulsion tiene la nave (1 o 2)
        while (i > 2 || i <= 0) {
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer(1 o 2)?");
            i = sc.nextInt();
        }
        //Añadir Propulsion
        //Tiene más sentido hacer un bucle for
        do {
            Propulsion a = new Propulsion(); //Constructor Propulsion
            prop.add(a);
            i = i - 1;
        } while (i != 0);
        return prop;
    }

    @Override
    //Carguero solo puede tener 1 defensa
    public int numeroDeDefensasMax() {
        return 1;
    }

    //Capacidad de maxima de carga del Carguero
    public int carga() {
        System.out.println("Introduzca la carga maxima: ");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        return c;
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

}
