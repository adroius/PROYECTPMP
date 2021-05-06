package Proyecto;

import java.util.ArrayList;
import java.util.List;

//Clase Carguero hereda de NaveBuilder
public class Carguero extends NaveBuilder {
    int tripulantesTotales = 0; //Inicializar la variable
    int carga = 0; //Inicializar la variable
    List<Defensa> defensa; //Carguero solo puede tener 1 defensa
    List<Propulsion> prop; //Carguero tiene 1 o 2 tipos de propulsion
    int numDefensas = numeroDeDefensasMax(); // Max de 1
    int defensaTotal = 0;

    //Constructor Carguero introduciendo datos por pantalla
    public Carguero() {
        //Capacidad de tripulantes de Carguero
        System.out.println("¿Cual es la capacidad de tripulantes del carguero?");
        int var = numeroIntroducido();
        this.tripulantesTotales = tripulantesTotales(var);

        //Capacidad de carga de Carguero
        System.out.println("Introduzca la carga maxima en toneladas: ");
        var = numeroIntroducido();
        this.carga = carga(var);

        //Sistemas de Defensa de Carguero (1 Defensa)
        var = sistemaDeDefensamenu();
        int def = 0;
        if (var==1){
            def=EscudoMenu();
        } else {
            def=blindajeMenu();
        }
        this.defensa = sistemaDeDefensa(var,def);

        //Sistema de Propulsion de Carguero
        var = cantidadPropulsionMenu();
        int tipoProp[] = new int[2];
        for (int i = 0; i < var; i++){
            tipoProp[i] = tipoPropulsionMenu();
        }
        this.prop = conjuntoDePropulsion(var,tipoProp);
    }

    //Constructor Carguero sin introducir datos por pantalla
    public Carguero(int tripulantes, int carga,int tipoDef ,int varIntroDef,
                    int cantidadProp,int tipoProp[]) {

        this.tripulantesTotales = tripulantesTotales(tripulantes);
        this.carga = carga(carga);
        this.defensa = sistemaDeDefensa(tipoDef, varIntroDef);
        this.prop = conjuntoDePropulsion(cantidadProp,tipoProp);
    }


    //Cantidad de tripulantes
    @Override
    public int tripulantesTotales(int tripulantes) {
        return tripulantes;
    }

    //Escoger sistema de Defensa
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
        System.out.println("¿Que energia quiere que su escudo consuma?");
        System.out.println("'Cuanto mas consuma mas daño soportará'");
        int energia = numeroIntroducido();
        return energia;
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
            blindajeMenu();
        }
        return c;
    }

    //Lista de defensas del Carguero (Carguero solo puede tener una defensa)
        public List<Defensa> sistemaDeDefensa(int tipoDef,int varIntroducir) {
        List<Defensa> defensa = new ArrayList<>();
        //Escoger el tipo de Defensa del Carguero
            Defensa d;
            switch (tipoDef) {
                case 1: {
                    d = new Escudo(varIntroducir); //Constructor Escudo
                    defensa.add(d);
                    defensaTotal += d.getDanioQueAbsorbe();
                    break;
                }
                case 2: {
                    d = new Blindaje(varIntroducir); //Constructor Blindaje
                    defensa.add(d);
                    defensaTotal += d.getDanioQueAbsorbe();
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

    //Cargueros no tiene armas
    public List<Arma> conjuntoDeArmas(int numeroArmas, int tipoArma[], int potenciaArmas[]) {
        return null;
    }

    //Carguero no tiene armas, por lo que no tiene potencia de ataque
    @Override
    public int potenciaDeAtaque() {
        return 0;
    }

    //Escoger el tipo de Propulsion
    private int tipoPropulsionMenu() {
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

    public int cantidadPropulsionMenu(){
        System.out.println("¿Cuantas propulsiones va a querer?");
        int cantidad = numeroIntroducido();
        //Comprobar que el numero de tipos de Propulsion es correcto
        while (cantidad > 2 || cantidad <= 0) {
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer (1 o 2)?");
        }
        return cantidad;
    }

    //Lista de tipos de Propulsion del Carguero (1 o 2)
    public List<Propulsion> conjuntoDePropulsion(int cantidadProp, int tipoPropArray[]) {
        List<Propulsion> prop = new ArrayList<>();
        //Añadir los tipos de Propulsion
        for (int i = 0; i < cantidadProp; i++) {
            Propulsion a = new Propulsion(tipoPropArray[i]);
            prop.add(a);
        }
        return prop;
    }

    //El número de Defensas maximo de Carguero es 1
    private final int numeroDeDefensasMax() {
        return 1;
    }

    //Capacidad de maxima de carga del Carguero
    public int carga(int carga) {
        return carga;
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