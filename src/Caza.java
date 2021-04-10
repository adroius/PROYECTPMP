import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Caza hereda de NaveBuilder
public class Caza extends NaveBuilder {
    int tripulantesMax; //Caza solo puede tener 1 tripulante
    List<Defensa> defensa; //Caza solo puede tener 1 defensa
    List<Arma> conjuntoDeArmas; //Caza tiene 2 armas
    List<Propulsion> prop; //Caza tiene 1 o 2 tipos de propulsion
    int numDefensas = numeroDeDefensasMax(); //Max 1

    //Constructor de Caza
    public Caza() {
        super();
        this.tripulantesMax = tripulantes();
        this.defensa = tipoDeDefensa();
        this.prop = conjuntoDePropulsion();
        this.conjuntoDeArmas = conjuntoDeArmas();
    }

    //Cantidad de tripulantes (Caza solo puede tener 1 tripulante)
    public int tripulantes() {
        System.out.println("La capacidad es de solo un tripulante.");
        return 1;
    }

    //Lista de defensas del Caza (Caza solo puede tener 1 defensa)
    public List<Defensa> tipoDeDefensa() {
        int def = numDefensas;
        List<Defensa> defensa = new ArrayList<>();
        //Escoger el tipo de Defensa del Caza
        for (int i = 1; i <= numDefensas; i++) {
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Escudo");
            System.out.println("2) Blindaje");
            Scanner sc = new Scanner(System.in);
            int e = sc.nextInt();
            //Comprobar que el valor introducido es correcto
            while (e > 2 || e < 1) {
                System.out.println("El valor introducido es incorrecto.");
                System.out.println("Vuelva a introducir el valor: ");
                System.out.println("1) Escudo");
                System.out.println("2) Blindaje");
                e = sc.nextInt();
            }
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
                //El valor introducido no es correcto
                default:
                    throw new IllegalStateException("Valor incorrecto: " + e);
            }
        }
        return defensa;
    }

    //Lista de Armas del Caza (Caza tiene 2 tipos de Armas)
    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = new ArrayList<>();
        int def = 2; //Caza tiene 2 armas
        //Escoger el tipo de Armas
        for (int i = 1; i <= def; i++) {
            Arma a = new Arma(); //Constructor Armas
            armas.add(a);//Añadir el arma creada a la lista de Armas
        }
        return armas;
    }

    //Lista de tipos de Propulsion del Caza (1 o 2)
    @Override
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        //Preguntar cuantos tipos de Propulsion tiene el Caza (1 o 2)
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones va a querer?");
        int p = sc.nextInt();
        //Comprobar que el numero de tipos de Propulsion es correcto
        while (p > 2 || p < 0) {
            System.out.println("La capacidad de la nave para portar propulsiones es limitada.");
            System.out.println("¿Cuantas propulsiones va a querer (1 o 2)?");
            p = sc.nextInt();
        }
        //Añadir los tipos de Propulsion
        for (int i = 1; i <= p; i++) {
            Propulsion a = new Propulsion();
            prop.add(a);
        }
        return prop;
    }

    //El numero máximo de Defensas de Caza es 1
    @Override
    public int numeroDeDefensasMax() {
        return 1;
    }

    @Override
    public List<Nave> conjuntoDeNaves() {
        return null;
    }

    @Override
    public String toString() {
        return "Caza" +
                "\nNumero de Tripulantes = " + tripulantesMax +
                "\nNumero de Defensas = " + numDefensas +
                "\nDefensas = " + defensa +
                "\nArmas = " + conjuntoDeArmas +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg +
                '}';
    }
}
