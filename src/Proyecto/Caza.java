package Proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Caza hereda de NaveBuilder
public class Caza extends NaveBuilder {
    int tripulantesTotales; //Caza solo puede tener 1 tripulante
    List<Defensa> defensa; //Caza solo puede tener 1 defensa
    List<Arma> conjuntoDeArmas; //Caza tiene 2 armas
    List<Propulsion> prop; //Caza tiene 1 o 2 tipos de propulsion
    int numDefensas = numeroDeDefensasMax(); //Max 1
    int potencia = 0; //Potencia Total de las Armas del Caza
    int defensaTotal = 0; //Danio que Absobe total del Caza

    //Constructor de Caza introduciendo datos por pantalla
    public Caza() {
        super();
        //Cantidad de tripulantes de Caza (1)
        this.tripulantesTotales = tripulantesTotales(1);

        //Sistema de Defensa de Caza (Tiene 1 tipo de Defensa)
        int var = sistemaDefensaMenu();
        int def;
        if (var == 1) {
            def = EscudoMenu();
        }else {
            def = BlindajeMenu();
        }
        this.defensa = sistemaDeDefensa(var, def);

        //Sistema de Propulsion de Caza (1 o 2)
        var = conjuntoDePropulsionCantidadMenu();
        int tipoProp[] = new int[2];
        for (int i = 0; i < var; i++){
            tipoProp[i] = conjuntoDePropulsionTipomenu();
        }
        this.prop = conjuntoDePropulsion(var, tipoProp);

        //Conjunto de Armas de Caza (2)
        int cantidadArmas = 2;
        int tipoArma[] = new int[2];
        for (int i = 0; i < cantidadArmas; i++) {
            tipoArma[i] = ArmasMenu();
        }
        this.conjuntoDeArmas = conjuntoDeArmas(cantidadArmas, tipoArma);
    }

    //Constructor de Caza sin introducir datos por pantalla
    public Caza(int cantidadDef, int tipoDef, int cantidadProp,
                int tipoProp[], int tipoArma[]){
        this.tripulantesTotales = tripulantesTotales(1);
        this.defensa = sistemaDeDefensa(cantidadDef, tipoDef);
        this.prop = conjuntoDePropulsion(cantidadProp, tipoProp);
        this.conjuntoDeArmas = conjuntoDeArmas(2, tipoArma);
    }


    //Cantidad de tripulantes (Caza solo puede tener 1 tripulante)
    public int tripulantesTotales(int tripulantes) {
        System.out.println("La capacidad es de solo un tripulante.");
        return tripulantes;
    }

    public int sistemaDefensaMenu(){
        int var = 0;
        for (int i = 1; i <= numDefensas; i++) {
            System.out.println("Introduzca el tipo de defensa: ");
            System.out.println("1) Escudo");
            System.out.println("2) Blindaje");
            var = numeroIntroducido();
            //Comprobar si el valor introducido es correcto
            while (var > 2 || var < 1) {
                System.out.println("Valor introducido incorrecto: ");
                System.out.println("Vuelva a introducirlo: ");
                System.out.println("1) Escudo");
                System.out.println("2) Blindaje");
                var = numeroIntroducido();
            }
        }
        return var;
    }

    public int EscudoMenu(){
        System.out.println("¿Que energia quiere que su escudo consuma?");
        System.out.println("'Cuanto mas consuma mas daño soportará'");
        int energia = numeroIntroducido();
        System.out.println("La energia de su escudo para funcionar sera de "+ energia);

        return energia;
    }

    public int BlindajeMenu(){
        int material = 0;
        System.out.println("Que blindaje quiere elegir:");
        System.out.println("0) Adamantium");
        System.out.println("1) Hierro");
        System.out.println("2) Plata");
        System.out.println("3) Platino");
        System.out.println("4) Oro");
        System.out.println("5) Diamante");
        material = numeroIntroducido();
        String nombre;
        while (material < 0 || material > 5){
            System.out.println("El valor introducido es incorrecto.");
            System.out.println("Vuelva a introducir el valor:");
            System.out.println("0) Adamantium");
            System.out.println("1) Hierro");
            System.out.println("2) Plata");
            System.out.println("3) Platino");
            System.out.println("4) Oro");
            System.out.println("5) Diamante");
            material = numeroIntroducido();
        }
        return material;
    }

    //Lista de defensas del Caza (Caza solo puede tener 1 defensa)
    public List<Defensa> sistemaDeDefensa(int tipoDef, int varIntroducir) {
        List<Defensa> defensa = new ArrayList<>();
        //Escoger el tipo de Defensa del Carguero
        Defensa d;
        switch (tipoDef) {
            case 1: {
                d = new Escudo(varIntroducir); //Constructor Escudo
                defensa.add(d);
                defensaTotal += d.danioQueAbsorbe();
                break;
            }
            case 2: {
                d = new Blindaje(varIntroducir); //Constructor Blindaje
                defensa.add(d);
                defensaTotal += d.danioQueAbsorbe();
                break;
            }
            //El dato introducido es incorrecto
            default:{ throw new IllegalStateException("Valor incorrecto: " + tipoDef);}
        }
        return defensa;
    }

    @Override
    public int getDefensaTotal(){
        return defensaTotal;
    }


    public int ArmasMenu() {
        System.out.println("Que arma quiere elegir:");
        System.out.println("0) PEM");
        System.out.println("1) Misil Termonuclear");
        System.out.println("2) Rayo Laser");
        System.out.println("3) Cañon de plasma");
        int modelo = numeroIntroducido();
        return modelo;
    }
    //Lista de Armas del Caza (Caza tiene 2 tipos de Armas)
    public List<Arma> conjuntoDeArmas(int numeroArmas, int tipoArma[]) {
        List<Arma> armas = new ArrayList<>();
        //Escoger el tipo de Armas
        for (int i = 0; i < numeroArmas; i++) {
            //Escoger el tipo de Arma
            Arma a = new Arma(tipoArma[i]);
            armas.add(a);//Añadir el arma creada a la lista de Armas
            potencia += a.potencia; //Sumar la potencia de todas las armas del Caza
        }
        return armas;
    }


    @Override
    public int potenciaDeAtaque() {
        return potencia;
    }

    //Sistema de Propulsion de Caza (1 o 2)
    //Cantidad de tipos de Propulsion
    private int conjuntoDePropulsionCantidadMenu(){
        System.out.println("¿Cuantas propulsiones va a querer?");
        int cantidad = numeroIntroducido();
        //Comprobar que el numero de tipos de Propulsion es correcto
        while (cantidad > 2 || cantidad <= 0) {
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer (1 o 2)?");
        }
        return cantidad;
    }
    //Escoger el tipo de Propulsion
    private int conjuntoDePropulsionTipomenu() {
        int tipoprop = 0;
        System.out.println("Que propulsion quiere elegir:");
        System.out.println("0) Compresor de Traza");
        System.out.println("1) Motor FTL");
        System.out.println("2) Vela Solar");
        System.out.println("3) MotorCurvatura");
        System.out.println("4) Motor Ionico");
        tipoprop = numeroIntroducido();
        return tipoprop;
    }
    //Lista de tipos de Propulsion del Caza (1 o 2)
    @Override
    public List<Propulsion> conjuntoDePropulsion(int cantidadProp, int tipoProp[]) {
        List<Propulsion> prop = new ArrayList<>();
        //Añadir los tipos de Propulsion
        for (int i = 0; i < cantidadProp; i++) {
            Propulsion a = new Propulsion(tipoProp[i]);
            prop.add(a);
        }
        return prop;
    }

    //El numero máximo de Defensas de Caza es 1
    private final int numeroDeDefensasMax() {
        return 1;
    }


    @Override
    public String toString() {
        return "   Caza" +
                "\nNumero de Tripulantes = " + tripulantesTotales +
                "\nNumero de Defensas = " + numDefensas +
                "\nDefensas = " + defensa +
                "\nArmas = " + conjuntoDeArmas +
                "\nPotencia total = " + potencia +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg;
    }
}
