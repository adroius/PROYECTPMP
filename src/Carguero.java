import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Carguero hereda de NaveBuilder
public class Carguero extends NaveBuilder {
    int tripulantesTotales = 0; //Inicializar la variable
    int carga = 0; //Inicializar la variable
    List<Defensa> defensa; //Carguero solo puede tener 1 defensa
    List<Propulsion> prop; //Carguero tiene 1 o 2 tipos de propulsion
    int numDefensas=numeroDeDefensasMax(); // Max de 1

    //Constructor Carguero
    public Carguero() {
        this.tripulantesTotales = tripulantesTotales();
        this.carga = carga();
        this.defensa = sistemaDeDefensa();
        this.prop = conjuntoDePropulsion();
    }

    //Cantidad de tripulantes
    @Override
    public int tripulantesTotales() {
        System.out.println("¿Cual es la capacidad de tripulantes del carguero?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return s;
    }

    //Lista de defensas del Carguero (Carguero solo puede tener una defensa)
    @Override
    public List<Defensa> sistemaDeDefensa() {
        List<Defensa> defensa = new ArrayList<>();
        //Escoger el tipo de Defensa del Carguero
        for (int i = 1; i <= numDefensas; i++){
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Escudo");
            System.out.println("2) Blindaje");
            Scanner sc = new Scanner(System.in);
            int e = sc.nextInt();
            //Comprobar si el valor introducido es correcto
            while (e > 2 ||e < 1){
                System.out.println("Valor introducido incorrecto: ");
                System.out.println("Vuelva a introducirlo: ");
                System.out.println("1) Escudo");
                System.out.println("2) Blindaje");
                e = sc.nextInt();
            }
            Defensa d;
            switch (e) {
                case 1: {
                    d = new Escudo(); //Constructor Escudo
                    defensa.add(d);
                    break;
                }
                case 2: {
                    d = new Blindaje(); //Constructor Blindaje
                    defensa.add(d);
                    break;
                }
                //El dato introducido es incorrecto
                default:{ throw new IllegalStateException("Valor incorrecto: " + e);}
            }
        }
        return defensa;
    }

    @Override
    public int potenciaDeAtaque() {
        return 0;
    }

    //Cargueros no tiene armas
    public List<Arma> conjuntoDeArmas() {
        return null;
    }

    @Override
    //Lista de tipos de Propulsion del Carguero (1 o 2)
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        //Preguntar cuantos tipos de Propulsion tiene la nave (1 o 2)
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones va a querer?");
        int p = sc.nextInt();
        //Comprobar que el numero de tipos de Propulsion es correcto
        while (p > 2 || p <= 0) {
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer (1 o 2)?");
            p = sc.nextInt();
        }
        //Añadir los tipos de Propulsion
        for (int i = 1; i <= p; i++) {
            Propulsion a = new Propulsion(); //Constructor Propulsion
            prop.add(a);
        }
        return prop;
    }

    //El número de Defensas maximo de Carguero es 1
    private final int numeroDeDefensasMax() {
        return 1;
    }

    //Capacidad de maxima de carga del Carguero
    public int carga() {
        System.out.println("Introduzca la carga maxima en toneladas: ");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        return c;
    }

    @Override
    public String toString() {
        return "Carguero:" +
                "\nNumero de Tripulantes = " + tripulantesTotales +
                "\nCarga Máxima = " + carga +
                "\nNumero de Defensas = " + numDefensas +
                "\nDefensas = " + defensa +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg;
    }

}