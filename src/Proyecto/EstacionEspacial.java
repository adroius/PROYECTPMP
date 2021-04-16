package Proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Clase Proyecto.EstacionEspacial hereda Proyecto.NaveBuilder
public class EstacionEspacial extends NaveBuilder{
    int tripulantesTotales;
    List<Defensa> defensa; //Proyecto.EstacionEspacial tiene 1, 2 o 3 Defensas además de las de las naves que contiene
    List<Arma> conjuntoDeArmas; //Conjunto de Armas de las naves que contiene la Proyecto.EstacionEspacial
    List<Nave> conjuntoDeNaves; //Naves que contiene la Proyecto.EstacionEspacial (Numero Indeterminado)
    List<Propulsion> prop; //Proyecto.EstacionEspacial puede tener 1 o 2 tipos de propulsion
    int defensaTotal = 0;
    int numDefensas; //Numero de Defensas de la Estacion Espacial
    int numPasajerosMax; //Numero de Pasajeros Maximo de la Estacion Espacial
    int potencia = 0; //Potencia total de las armas de la Estacion Espacial

    //Constructor Proyecto.EstacionEspacial
    public EstacionEspacial() {
        this.tripulantesTotales = tripulantesTotales();
        this.numPasajerosMax = pasajerosMax();
        this.defensa= sistemaDeDefensa();
        this.prop= conjuntoDePropulsion();
        this.conjuntoDeArmas=conjuntoDeArmas();
        this.conjuntoDeNaves=conjuntoNaves();
    }

    //Introducir la cantidad de tripulantes de la Estacion Espacial
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

    //Introducir la cantidad de Pasajeros Maximos puede llevar la Estacion Espacial
    public int pasajerosMax(){
        System.out.println("¿Cual es la capacidad de pasajeros de la Estacion Espacial?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    //Lista de Defensas de la Estacion Espacial (Por si sola puede tener 1, 2 o 3)
    @Override
    public List<Defensa> sistemaDeDefensa() {
        List<Defensa> defensa = new ArrayList<>();
        //Preguntar cuantas Defensas tiene Proyecto.EstacionEspacial
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
        //Escoger el tipo de Proyecto.Defensa que tiene Proyecto.EstacionEspacial
        for (int i = 1; i <= numDefensas; i++){
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Proyecto.Escudo");
            System.out.println("2) Proyecto.Blindaje");
            int ef = sc.nextInt();
            //Comprobar que el valor introducido es correcto
            while (ef < 1 || ef > 2 )
                {
                   System.out.println ("El valor es incorrecto");
                   System.out.println ("Vuelva a introducir el valor:");
                    System.out.println("1) Proyecto.Escudo");
                    System.out.println("2) Proyecto.Blindaje");
                    ef = sc.nextInt();
                }
            switch (ef) {
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
                //El dato introducido es incorrecto
                default:
                    throw new IllegalStateException("Valor incorrecto: " + def);
            }
        }
        return defensa;
    }

    //Proyecto.EstacionEspacial por si sola no tiene Armas
    //Deberiamos poner las Armas de las naves que contiene??
    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = null;
        return armas;
    }

    //Lista de tipos de Proyecto.Propulsion de Estacion Espacial (1 o 2)
    @Override
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        //Preguntar cuantos tipos de Proyecto.Propulsion tiene la Proyecto.EstacionEspacial (1 o 2)
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones tiene la Estacion Espacial?");
        int p = sc.nextInt();
        //Comprobar que el numero de tipos de Proyecto.Propulsion es correcto
        while (p > 2 || p < 1){
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones tiene la Estacion Espacial (1 o 2)?");
            p = sc.nextInt();
        }
        //Añadir los tipos de Proyecto.Propulsion
        for (int i = 1; i <= p; i++){
            Propulsion a=new Propulsion();
            prop.add(a);
        }
        return prop;
    }

    //El numero máximo de Defensas por si sola de la Estacion Espacial es 3
    private int numeroDeDefensasMax() {
        return 3;
    }

    /*Devuelve la Potencia de Ataque de la Estacion Espacial
    (Potencia Total de las naves que contiene la Estacion Espacial)*/
    @Override
    public int getDefensaTotal(){
        return defensaTotal;
    }

    @Override
    public int potenciaDeAtaque(){
        return potencia;
    }

    //Crear las naves que contiene la Estacion Espacial
    public List<Nave> conjuntoNaves() {
        List<Nave> conjuntoDeNaves = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas naves tiene la Estacion Espacial?");
        int nNaves = sc.nextInt();
        for (int i = 1; i <= nNaves; i++) {
            Nave nave = NaveBuilder.CrearNave();
            conjuntoDeNaves.add(nave);
            //Añadir la potencia de ataque de las naves a la potencia de Ataque de la Estacion Espacial
            potencia += nave.potenciaDeAtaque();
        }
        return conjuntoDeNaves;
    }

    @Override
    public String toString() {
        return "Estacion Espacial" +
                "\nNumero de Tripulantes = " + tripulantesTotales +
                "\nNumero de Pasajeros Máximo" + numPasajerosMax +
                "\nNumero de Defensas = " + numDefensas +
                "\nDefensas = " + defensa +
                "\nArmas = " + conjuntoDeArmas +
                "\nPotencia total del conjunto de naves = " + potencia +
                "\nProyecto.Propulsion = " + prop +
                "\nNumero de Identificacion = " + numReg +
                "\nNaves = " + conjuntoDeNaves;
    }

}
