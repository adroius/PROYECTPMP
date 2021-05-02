package Proyecto;

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
    int defensaTotal = 0;

    //Constructor Carguero
    public Carguero() {
        this.tripulantesTotales = tripulantesTotales();
        this.carga = carga();
        int c=sistemaDeDefensamenu();
        int def = 0;
        if (c==1){
            def=EscudoMenu();
        } else {
            def=blindajeMenu();
        }
        this.defensa = sistemaDeDefensa(c,def);
        c=conjuntoDePropulsionCantidadmenu();
        int d=conjuntoDePropulsionTipomenu();
        this.prop = conjuntoDePropulsion(c,d);
    }


    public Carguero(int tripulantes, int carga,int cantidadDef,int tipodef,int cantidadProp,int tipoProp) {
        this.tripulantesTotales = tripulantes;
        this.carga = carga;
        this.defensa = sistemaDeDefensa(cantidadDef,tipodef);
        this.prop = conjuntoDePropulsion(cantidadProp,tipoProp);
    }

    private int conjuntoDePropulsionTipomenu() {
        int c=0;
        System.out.println("Que propulsion quiere elegir:");
        System.out.println("0) Compresor de Traza");
        System.out.println("1) Motor FTL");
        System.out.println("2) Vela Solar");
        System.out.println("3) MotorCurvatura");
        System.out.println("4) Motor Ionico");
        c=numeroIntroducido();
        return c;
    }

    //Cantidad de tripulantes
    @Override
    public int tripulantesTotales() {
        System.out.println("¿Cual es la capacidad de tripulantes del carguero?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public int sistemaDeDefensamenu() {
        int c = 0;
        for (int i = 1; i <= numDefensas; i++) {
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Escudo");
            System.out.println("2) Blindaje");
            c = numeroIntroducido();
            //Comprobar si el valor introducido es correcto
            while (c > 2 || c < 1) {
                System.out.println("Valor introducido incorrecto: ");
                System.out.println("Vuelva a introducirlo: ");
                System.out.println("1) Escudo");
                System.out.println("2) Blindaje");
                c = numeroIntroducido();
            }
        }
        return c;
    }
    public int EscudoMenu(){
        int c=numeroIntroducido();
        System.out.println("¿Que energia quiere que su escudo consuma?");
        System.out.println("'Cuanto mas consuma mas daño soportará'");
        System.out.println("La energia de su escudo para funcionar sera de "+ c);
        return c;
    }

    public int blindajeMenu(){
        int c=0;
        System.out.println("Que blindaje quiere elegir:");
        System.out.println("0) Adamantium");
        System.out.println("1) Hierro");
        System.out.println("2) Plata");
        System.out.println("3) Platino");
        System.out.println("4) Oro");
        System.out.println("5) Diamante");
        c=numeroIntroducido();
        String nombre;
        while (c < 0 || c > 5){
            System.out.println("El valor introducido es incorrecto.");
            System.out.println("Vuelva a introducir el valor:");
            System.out.println("0) Adamantium");
            System.out.println("1) Hierro");
            System.out.println("2) Plata");
            System.out.println("3) Platino");
            System.out.println("4) Oro");
            System.out.println("5) Diamante");
            //falta poner aqui otra vez la c
        }
        return c;
    }

    //Lista de defensas del Carguero (Carguero solo puede tener una defensa)
        public List<Defensa> sistemaDeDefensa(int e,int c) {
        List<Defensa> defensa = new ArrayList<>();
        //Escoger el tipo de Defensa del Carguero
            Defensa d;
            switch (e) {
                case 1: {
                    d = new Escudo(c); //Constructor Escudo
                    defensa.add(d);
                    defensaTotal += d.danioQueAbsorbe();
                    break;
                }
                case 2: {
                    d = new Blindaje(c); //Constructor Blindaje
                    defensa.add(d);
                    defensaTotal += d.danioQueAbsorbe();
                    break;
                }
                //El dato introducido es incorrecto
                default:{ throw new IllegalStateException("Valor incorrecto: " + e);}
            }
            return defensa;
        }

    @Override
    public int getDefensaTotal(){
        return defensaTotal;
    }

    //Cargueros no tiene armas
    public List<Arma> conjuntoDeArmas() {
        return null;
    }

    //Carguero no tiene armas, por lo que no tiene potencia de ataque
    @Override
    public int potenciaDeAtaque() {
        return 0;
    }

    @Override
    public List<Propulsion> conjuntoDePropulsion() {
        return null;
    }

    public int conjuntoDePropulsionCantidadmenu(){
        System.out.println("¿Cuantas propulsiones va a querer?");
        int p=numeroIntroducido();
        //Comprobar que el numero de tipos de Propulsion es correcto
        while (p > 2 || p <= 0) {
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer (1 o 2)?");
        }
        return p;
    }

    //Lista de tipos de Propulsion del Carguero (1 o 2)
    public List<Propulsion> conjuntoDePropulsion(int p,int d) {
        List<Propulsion> prop = new ArrayList<>();
        //Preguntar cuantos tipos de Propulsion tiene la nave (1 o 2)
        //Añadir los tipos de Propulsion
        for (int i = 1; i <= p; i++) {
            Propulsion a = new Propulsion(d); //Constructor Propulsion
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
        return "   Carguero" +
                "\nNumero de Tripulantes = " + tripulantesTotales +
                "\nCarga Máxima = " + carga +
                "\nNumero de Defensas = " + numDefensas +
                "\nDefensas = " + defensa +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg;
    }

}