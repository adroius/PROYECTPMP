import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Clase EstacionEspacial hereda NaveBuilder
public class EstacionEspacial extends NaveBuilder{
    int tripulantesMax;
    List<Defensa> defensa; //EstacionEspacial tiene 1, 2 o 3 Defensas además de las de las naves que contiene
    List<Arma> conjuntoDeArmas; //Conjunto de Armas de las naves que contiene la EstacionEspacial
    List<Nave> conjuntoDeNaves; //Naves que contiene la EstacionEspacial (Numero Indeterminado)
    List<Propulsion> prop; //EstacionEspacial puede tener 1 o 2 tipos de propulsion
    int numDefensas;
    int numPasajerosMax;

    //Constructor EstacionEspacial
    public EstacionEspacial() {
        this.tripulantesMax = tripulantes();
        this.defensa= tipoDeDefensa();
        this.prop= conjuntoDePropulsion();
        this.conjuntoDeArmas=conjuntoDeArmas();
        this.conjuntoDeNaves=conjuntoDeNaves();
    }

    //Cantidad de tripulantes
    @Override
    public int tripulantes() {
        System.out.println("¿Cual es la capacidad de tripulantes de la Estacion Espacial?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return s;
    }
    //Lista de Defensas de la EstacionEspacial (Por si sola puede tener 1, 2 o 3)
    //No debería añadir también las Defensas de las naves que contiene?
    @Override
    public List<Defensa>  tipoDeDefensa() {
        List<Defensa> defensa = new ArrayList<>();
        //Preguntar cuantas Defensas tiene EstacionEspacial
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas defensas tiene?");
        int def = sc.nextInt();
        //Comprobar que el numero de Defensas es correcto
        while (def > numeroDeDefensasMax() || def < 1){
            System.out.println("Solo puede tener 1, 2 o 3 defensas, ¿Cuantas posee?");
            def = sc.nextInt();
        }
        numDefensas = def;
        Defensa d;
        //Escoger el tipo de Defensa que tiene EstacionEspacial
        for (int i = 1; i <= numDefensas; i++){
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Escudo");
            System.out.println("2) Blindaje");
            int ef = sc.nextInt();
            //Comprobar que el valor introducido es correcto
            while (ef < 1 || ef > 2 )
                {
                   System.out.println ("El valor es incorrecto");
                   System.out.println ("Vuelva a introducir el valor:");
                    System.out.println("1) Escudo");
                    System.out.println("2) Blindaje");
                    ef = sc.nextInt();
                }
            switch (ef) {
                case 1:
                    d = new Escudo(); //Constructor Escudo
                    defensa.add(d);
                    break;
                case 2:
                    d = new Blindaje(); //Constructor Blindaje
                    defensa.add(d);
                    break;
                //El dato introducido es incorrecto
                default:
                    throw new IllegalStateException("Valor incorrecto: " + def);
            }
        }
        return defensa;
    }

    //EstacionEspacial por si sola no tiene Armas
    //Deberiamos poner las Armas de las naves que contiene??
    @Override
    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = null;
        return armas;
    }

    //Lista de tipos de Propulsion de EstacionEspacial (1 o 2)
    @Override
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        //Preguntar cuantos tipos de Propulsion tiene la EstacionEspacial (1 o 2)
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones va a querer?");
        int p = sc.nextInt();
        //Comprobar que el numero de tipos de Propulsion es correcto
        while (p > 2 || p < 1){
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer (1 o 2)?");
            p = sc.nextInt();
        }
        //Añadir los tipos de Propulsion
        for (int i = 1; i <= p; i++){
            Propulsion a=new Propulsion();
            prop.add(a);
        }
        return prop;
    }

    //El numero máximo de Defensas por si sola de EstacionEspacial es 3
    @Override
    public int numeroDeDefensasMax() {

        return 3;
    }

    //Esto tiene que devolver Null???
    @Override
    public List<Nave> conjuntoDeNaves() {
        List<Nave> conjuntoDeNaves = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas naves tiene la estacion espacial?");
        int n = sc.nextInt();
        int i;
        do {
            i = n - 1;
                NaveBuilder.CrearNave();
            }
            while (i!=0);
        return null;
    }

    @Override
    public String toString() {
        return "Estacion Espacial {" +
                "\nNumero de Tripulantes = " + tripulantesMax +
                "\nNumero de Pasajeros Máximo" + numPasajerosMax +
                "\nNumero de Defensas = " + numDefensas +
                "\nDefensas = " + defensa +
                "\nArmas = " + conjuntoDeArmas +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg +
                "\nNaves = " + conjuntoDeNaves +
                "}";
    }

}
