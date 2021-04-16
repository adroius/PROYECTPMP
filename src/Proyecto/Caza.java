package Proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Proyecto.Caza hereda de Proyecto.NaveBuilder
public class Caza extends NaveBuilder {
    int tripulantesTotales; //Proyecto.Caza solo puede tener 1 tripulante
    List<Defensa> defensa; //Proyecto.Caza solo puede tener 1 defensa
    List<Arma> conjuntoDeArmas; //Proyecto.Caza tiene 2 armas
    List<Propulsion> prop; //Proyecto.Caza tiene 1 o 2 tipos de propulsion
    int numDefensas = numeroDeDefensasMax(); //Max 1
    int potencia = 0; //Potencia Total de las Armas del Proyecto.Caza
    int defensaTotal = 0; //Danio que Absobe total del Proyecto.Caza

    //Constructor de Proyecto.Caza
    public Caza() {
        super();
        this.tripulantesTotales = tripulantesTotales();
        this.defensa = sistemaDeDefensa();
        this.prop = conjuntoDePropulsion();
        this.conjuntoDeArmas = conjuntoDeArmas();
    }

    //Cantidad de tripulantes (Proyecto.Caza solo puede tener 1 tripulante)
    public int tripulantesTotales() {
        System.out.println("La capacidad es de solo un tripulante.");
        return 1;
    }

    //Lista de defensas del Proyecto.Caza (Proyecto.Caza solo puede tener 1 defensa)
    public List<Defensa> sistemaDeDefensa() {
        int def = numDefensas;
        List<Defensa> defensa = new ArrayList<>();
        //Escoger el tipo de Proyecto.Defensa del Proyecto.Caza
        for (int i = 1; i <= numDefensas; i++) {
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Proyecto.Escudo");
            System.out.println("2) Proyecto.Blindaje");
            Scanner sc = new Scanner(System.in);
            int e = sc.nextInt();
            //Comprobar que el valor introducido es correcto
            while (e > 2 || e < 1) {
                System.out.println("El valor introducido es incorrecto.");
                System.out.println("Vuelva a introducir el valor: ");
                System.out.println("1) Proyecto.Escudo");
                System.out.println("2) Proyecto.Blindaje");
                e = sc.nextInt();
            }
            Defensa d;
            switch (e) {
                case 1:
                    d = new Escudo(); //Constructor Proyecto.Escudo
                    defensa.add(d);
                    defensaTotal += d.danioQueAbsorbe();
                    break;
                case 2:
                    d = new Blindaje(); //Constructor Proyecto.Blindaje
                    defensa.add(d);
                    defensaTotal += d.danioQueAbsorbe();
                    break;
                //El valor introducido no es correcto
                default:
                    throw new IllegalStateException("Valor incorrecto: " + e);
            }
        }
        return defensa;
    }


    //Lista de Armas del Proyecto.Caza (Proyecto.Caza tiene 2 tipos de Armas)
    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = new ArrayList<>();
        int def = 2;//Proyecto.Caza tiene 2 armas
        //Escoger el tipo de Armas
        for (int i = 1; i <= def; i++) {
            //Escoger el tipo de Proyecto.Arma
            Arma a = new Arma();
            armas.add(a);//Añadir el arma creada a la lista de Armas
            potencia += a.potencia; //Sumar la potencia de todas las armas del Proyecto.Caza
        }
        return armas;
    }

    @Override
    public int getDefensaTotal(){
        return defensaTotal;
    }

    @Override
    public int potenciaDeAtaque() {
        return potencia;
    }

    //Lista de tipos de Proyecto.Propulsion del Proyecto.Caza (1 o 2)
    @Override
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        //Preguntar cuantos tipos de Proyecto.Propulsion tiene el Proyecto.Caza (1 o 2)
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones va a querer?");
        int p = sc.nextInt();
        //Comprobar que el numero de tipos de Proyecto.Propulsion es correcto
        while (p > 2 || p < 0) {
            System.out.println("La capacidad de la nave para portar propulsiones es limitada.");
            System.out.println("¿Cuantas propulsiones va a querer (1 o 2)?");
            p = sc.nextInt();
        }
        //Añadir los tipos de Proyecto.Propulsion
        for (int i = 1; i <= p; i++) {
            Propulsion a = new Propulsion();
            prop.add(a);
        }
        return prop;
    }

    //El numero máximo de Defensas de Proyecto.Caza es 1
    private final int numeroDeDefensasMax() {
        return 1;
    }


    @Override
    public String toString() {
        return "Proyecto.Caza" +
                "\nNumero de Tripulantes = " + tripulantesTotales +
                "\nNumero de Defensas = " + numDefensas +
                "\nDefensas = " + defensa +
                "\nArmas = " + conjuntoDeArmas +
                "\nPotencia total = " + potencia +
                "\nProyecto.Propulsion = " + prop +
                "\nNumero de Identificacion = " + numReg;
    }
}
