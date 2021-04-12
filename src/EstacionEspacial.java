import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Clase EstacionEspacial hereda NaveBuilder
public class EstacionEspacial extends NaveBuilder{
    int tripulantesTotales;
    List<Defensa> defensa; //EstacionEspacial tiene 1, 2 o 3 Defensas además de las de las naves que contiene
    List<Arma> conjuntoDeArmas; //Conjunto de Armas de las naves que contiene la EstacionEspacial
    List<Nave> conjuntoDeNaves; //Naves que contiene la EstacionEspacial (Numero Indeterminado)
    List<Propulsion> prop; //EstacionEspacial puede tener 1 o 2 tipos de propulsion
    int numDefensas;
    int numPasajerosMax;
    int potencia;

    //Constructor EstacionEspacial
    public EstacionEspacial() {
        this.tripulantesTotales = tripulantesTotales();
        this.numPasajerosMax = pasajerosMax();
        this.defensa= sistemaDeDefensa();
        this.prop= conjuntoDePropulsion();
        this.conjuntoDeArmas=conjuntoDeArmas();
        this.conjuntoDeNaves=conjuntoNaves();
    }

    //Cantidad de tripulantes
    @Override
    public int tripulantesTotales() {
        System.out.println("¿Cuantos tripulantes hay en la Estacion Espacial?");
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        int tripulantes = sc.nextInt();
        while (!exit) {
            if (tripulantes <= pasajerosMax()) {
                exit = true;
            }
            else{
                exit = false;
                System.out.print("No es posible que haya mas tripulantes que capacidad en la estacion espacial");
            }
        }
        return tripulantes;
    }

    public int pasajerosMax(){
        System.out.println("¿Cual es la capacidad de tripulantes de la Estacion Espacial?");
        Scanner sc = new Scanner(System.in);
        int pasajeros = sc.nextInt();
        return pasajeros;
    }

    //Lista de Defensas de la EstacionEspacial (Por si sola puede tener 1, 2 o 3)
    //No debería añadir también las Defensas de las naves que contiene?
    @Override
    public List<Defensa> sistemaDeDefensa() {
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
    private int numeroDeDefensasMax() {
        return 3;
    }

    @Override
    public int potenciaDeAtaque(){
        return potencia;
    }

    //Esto tiene que devolver Null???
    public List<Nave> conjuntoNaves() {
        List<Nave> conjuntoDeNaves = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas naves tiene la estacion espacial?");
        int i = sc.nextInt();
        do {
            i -= 1;
            Nave n = NaveBuilder.CrearNave();
            conjuntoDeNaves.add(n);
            potencia += n.potenciaDeAtaque();
        } while (i!=0);
        return conjuntoDeNaves;
    }

    @Override
    public String toString() {
        return "Estacion Espacial: " +
                "\nNumero de Tripulantes = " + tripulantesTotales +
                "\nNumero de Pasajeros Máximo" + numPasajerosMax +
                "\nNumero de Defensas = " + numDefensas +
                "\nDefensas = " + defensa +
                "\nArmas = " + conjuntoDeArmas +
                "\nPotencia total del conjunto de naves = " + potencia +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg +
                "\nNaves = " + conjuntoDeNaves;
    }

}
