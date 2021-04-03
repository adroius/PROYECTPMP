import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Destructor hereda de NaveBuilder
public class Destructor extends NaveBuilder{
    List<Arma> conjuntoDeArmas; //Destructor tiene como minimo 1 Arma
    List<Defensa> conjuntoDefensa; //Destructor tiene 1 o 2 Defensas
    List<Propulsion> prop; //Destructor tiene 1 o 2 tipos de Propulsion
    int tripulantesMax;
    int numDefensas = numeroDeDefensasMax(); //Max 2

    //Constructor Destructor
    public Destructor(){
        super();
        this.tripulantesMax = tripulantes();
        this.prop= conjuntoDePropulsion(); //
        this.conjuntoDeArmas=conjuntoDeArmas();
        this.conjuntoDefensa=tipoDeDefensa();
    }

    //Cantidad de tripulantes
    @Override
    public int tripulantes() {
        System.out.println("¿Cual es la capacidad de tripulantes del Destructor?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return  (s);
    }


    @Override
    //Lista de Defensas del Destructor (Destructor puede tener 1 o 2 defensas)
    public List<Defensa> tipoDeDefensa() {
        List<Defensa> defensa = new ArrayList<>();
        //Escoger numero de Defensas de Destructor
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas defensas tiene?");
        int e = sc.nextInt();
        //Comprobar que el numero de Defensas es correcto
        while (e>2){
            System.out.println("Puede tener como maximo dos defensas, ¿Cuantas posee?(1 o 2)");
            e = sc.nextInt();
        }
        Defensa d;
        //Escoger los tipos de defensas de Destructor
        //Hay que hacer un bucle para asegurar que el valor introducido es correcto
        //Tiene más sentido hacer un bucle for
        do{
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Escudo");
            System.out.println("2) Blindaje");
            int ef = sc.nextInt();
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
            e=e-1;
        } while (e!=0);
        return defensa;
    }

    //Lista de Armas del Destructor (Destructor solo tiene 1 Arma)
    @Override
    public List<Arma> conjuntoDeArmas(){
        List<Arma> armas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int i = 1; //Destructor solo tiene 1 Arma
        //Escoger el tipo de Arma

        //Tiene más sentido hacer un bucle for o no hacer un bucle
        do {
            Arma a = new Arma();
            armas.add(a);
            i=i-1;
        }while (i!=0);
        return armas;
    }

    //Lista de tipos de Propulsion del Destructor (1 o 2)
    @Override
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        //Preguntar cuantos tipos de Propulsion tiene el Destructor (1 o 2)
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones va a querer?");
        int i = sc.nextInt();
        //Comprobar que el numero de tipos de Propulsion es correcto
        while (i>2){
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer(1 o 2)?");
            i = sc.nextInt();
        }
        //Añadir los tipos de Propulsion
        //Tiene más sentido hacer un bucle for
        do{
            Propulsion a=new Propulsion();
            prop.add(a);
            i=i-1;
        } while (i!=0);
        return prop;
    }

    //El número máximo de Defensas de Destructor es 2
    @Override
    public int numeroDeDefensasMax() {

        return 2;
    }



    @Override
    public String toString() {
        return "Destructor { " +
                " Numero de Tripulantes" + tripulantesMax +
                " Numero de Defensas" + numDefensas +
                " Defensas = " + conjuntoDefensa +
                " Armas = " + conjuntoDeArmas +
                " Propulsion = " + prop +
                " Numero de Identificacion = " + numReg +
                '}';
    }
}
