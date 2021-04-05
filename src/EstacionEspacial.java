import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstacionEspacial extends NaveBuilder{
    int tripulantesMax;
    List<Defensa> defensa; //EstacionEspacial tiene 1, 2 o 3 Defensas además de las de las naves que contiene
    List<Arma> conjuntoDeArmas; //Conjunto de Armas de las naves que contiene la EstacionEspacial
    List<Nave> conjuntoDeNaves; //Naves que contiene la EstacionEspacial (Numero Indeterminado)
    List<Propulsion> prop; //EstacionEspacial puede tener 1 o 2 tipos de propulsion
    int numDefensas = numeroDeDefensasMax(); //Por si sola las Defensas maximas son 3
    int numPasajerosMax;
    //Falta el numero máximo de pasajeros


    //Constructor EstacionEspacial
    public EstacionEspacial() {
        this.tripulantesMax = tripulantes();
        this.defensa= tipoDeDefensa();
        this.prop= conjuntoDePropulsion();
        this.conjuntoDeArmas=conjuntoDeArmas();
        this.conjuntoDeNaves=conjuntoDeNaves();
        this.numPasajerosMax=numPasajerosMax();
    }

    //Cantidad de tripulantes
    @Override
    public int tripulantes() {
        System.out.println("¿Cual es la capacidad de tripulantes de la Estacion Espacial?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return s;
    }

    //Numero máximo de pasajeros
    public int numPasajerosMax() {
        System.out.println("¿Cual es la capacidad de pasajeros de la Estacion Espacial?");
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
        int e = sc.nextInt();
        //Comprobar que el numero de Defensas es correcto
        while (e>3){
            System.out.println("Puede tener 1, 2 o 3 defensas, ¿Cuantas posee?");
            e = sc.nextInt();
        }
        Defensa d;
        //Escoger el tipo de Defensa que tiene EstacionEspacial
        //Hay que hacer un bucle para asegurarse de que el valor introducido es correcto
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

    //El numero máximo de Defensas por si sola de EstacionEspacial es 3
    @Override
    public int numeroDeDefensasMax() {

        return 3;
    }


    //Esto tiene que devolver Null???
    public List<Nave> conjuntoDeNaves() {

        return null;
    }

    @Override
    public String toString() {
        return "Estacion Espacial {" +
                "\nNumero de Tripulantes = " + tripulantesMax +
                "\nNumero de Defensas = " + numDefensas +
                "\nDefensas = " + defensa +
                "\nArmas = " + conjuntoDeArmas +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg +
                "\nNaves = " + conjuntoDeNaves +
                '}';
    }

}
