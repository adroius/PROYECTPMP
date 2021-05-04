package Proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Clase EstacionEspacial hereda NaveBuilder
public class EstacionEspacial extends NaveBuilder{
    int tripulantesTotales;
    List<Defensa> defensa; //EstacionEspacial tiene 1, 2 o 3 Defensas
    List<Nave> conjuntoDeNaves; //Naves que contiene la EstacionEspacial (Numero Indeterminado)
    List<Propulsion> prop; //EstacionEspacial puede tener 1 o 2 tipos de propulsion
    int defensaTotal = 0;
    int numDefensas; //Numero de Defensas de la Estacion Espacial
    int numPasajerosMax; //Numero de Pasajeros Maximo de la Estacion Espacial
    int potencia = 0; //Potencia total de las armas de la Estacion Espacial

    //Constructor EstacionEspacial introduciendo datos por pantalla
    public EstacionEspacial() {
        //Capacidad de pasajeros de la Estacion Espacial
        System.out.println("¿Cual es la capacidad de pasajeros de la Estacion Espacial?");
        int var = numeroIntroducido();
        this.numPasajerosMax = pasajerosMax(var);

        //Cantidad de tripulacion de la Estacion Espacial
        System.out.println("¿Cuantos tripulantes hay en la Estacion Espacial?");
        var = numeroIntroducido();
        this.tripulantesTotales = tripulantesTotales(var);

        //Sistema de defensa de la Estacion Espacial (De 1 a 3)
        int cantidad = cantidadDefensaMenu();
        numDefensas = cantidad;
        for (int i = 0; i < cantidad; i++){
            var = sistemaDefensaMenu();
            int def;
            if (var == 1) {
                def = EscudoMenu();
            }else {
                def = BlindajeMenu();
            }
            this.defensa = sistemaDeDefensa(var, def);
        }

        //Sistema de Propulsion de la Estacion Espacial (1 o 2)
        var = conjuntoDePropulsionCantidadMenu();
        int tipoProp[] = new int[2];
        for (int i = 0; i < var; i++){
            tipoProp[i] = conjuntoDePropulsionTipomenu();
        }
        this.prop = conjuntoDePropulsion(var, tipoProp);

        this.conjuntoDeNaves=conjuntoNaves();
    }

    //Constructor EstacionEspacial sin introducir datos por pantalla
    public EstacionEspacial(int tripulantes, int pasajerosMaximos, int cantidadDef,
                            int tipoDef, int cantidadProp, int tipoProp[]){

        this.numPasajerosMax = pasajerosMax(pasajerosMaximos);
        this.tripulantesTotales = tripulantesTotales(tripulantes);
        this.defensa= sistemaDeDefensa(cantidadDef, tipoDef);
        this.prop= conjuntoDePropulsion(cantidadProp, tipoProp);
        this.conjuntoDeNaves=conjuntoNaves();
    }
    //Introducir la cantidad de tripulantes de la Estacion Espacial
    @Override
    public int tripulantesTotales(int tripulantes) {
        return tripulantes;
    }

    //Introducir la cantidad de Pasajeros Maximos puede llevar la Estacion Espacial
    public int pasajerosMax(int maximo){
        return maximo;
    }

    //Sistema de Defensas de la Estacion Espacial
    //Introducir la cantidad de Defensas (1, 2 o 3)
    public int cantidadDefensaMenu(){
        //Escoger numero de Defensas de Destructor
        System.out.println("¿Cuantas defensas tiene?");
        int cantidad = numeroIntroducido();
        //Comprobar que el numero de Defensas es correcto
        while (cantidad > numeroDeDefensasMax() || cantidad < 1) {
            System.out.println("Puede tener como maximo" + numeroDeDefensasMax() + "defensas, ¿Cuantas posee?");
            cantidad = numeroIntroducido();
        }
        return cantidad;
    }
    //Introducir el tipo de Defensa
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
    //Introducir energía del Escudo
    public int EscudoMenu(){
        System.out.println("¿Que energia quiere que su escudo consuma?");
        System.out.println("'Cuanto mas consuma mas daño soportará'");
        int energia = numeroIntroducido();
        return energia;
    }
    //Introducir material del Blindaje
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
    //Lista de Defensas de la Estacion Espacial (1, 2 o 3)
    public List<Defensa> sistemaDeDefensa(int tipoDef, int varIntroducir) {
        List<Defensa> defensa = new ArrayList<>();
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


    //Estacion Espacial no tiene Armas
    public List<Arma> conjuntoDeArmas(int numeroArmas, int tipoArmas[]) {
        return null;
    }

    //Sistema de Propulsion de Estacion Espacial (1 o 2)
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
    //Lista de tipos de Propulsion del Destructor (1 o 2)
    @Override
    public List<Propulsion> conjuntoDePropulsion(int cantidadProp, int tipoProp[]) {
        List<Propulsion> prop = new ArrayList<>();
        for(int i = 0; i < cantidadProp; i++) {
            Propulsion a = new Propulsion(tipoProp[i]);
            prop.add(a);
        }
        return prop;
    }


    //El numero máximo de Defensas de la Estacion Espacial es 3
    private int numeroDeDefensasMax() {
        return 3;
    }


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
                "\nPotencia total del conjunto de naves = " + potencia +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg +
                "\nNaves = " + conjuntoDeNaves;
    }

}
