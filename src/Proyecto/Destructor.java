package Proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Destructor hereda de NaveBuilder
public class Destructor extends NaveBuilder {
    List<Arma> conjuntoDeArmas; //Destructor tiene como minimo 1 Arma
    List<Defensa> conjuntoDefensa; //Destructor tiene 1 o 2 Defensas
    List<Propulsion> prop; //Destructor tiene 1 o 2 tipos de Propulsion
    int tripulantesTotales;
    int numDefensas; //Max 2
    int potencia = 0;
    int defensaTotal = 0;

    //Constructor Destructor introduciendo datos por pantalla
    public Destructor() {
        super();
        //Capacidad de tripulantes de Destructor
        System.out.println("¿Cual es la capacidad de tripulantes del Destructor?");
        int var = numeroIntroducido();
        this.tripulantesTotales = tripulantesTotales(var);

        //Sistema de Defensa de Destructor (1 o 2)
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
            this.conjuntoDefensa = sistemaDeDefensa(var, def);
        }

        //Sistema de Propulsion de Destructor (1 o 2)
        var = conjuntoDePropulsionCantidadMenu();
        int tipoProp[] = new int[2];
        for (int i = 0; i < var; i++){
            tipoProp[i] = conjuntoDePropulsionTipomenu();
        }
        this.prop = conjuntoDePropulsion(var, tipoProp);

        //Conjunto de Armas de Destructor (Min 1)
        int cantidadArmas = cantidadArmasMenu();
        int tipoArma[] = new int[cantidadArmas];
        int potenciaArma[] = new int[cantidadArmas];
        for (int i = 0; i < cantidadArmas; i++) {
            tipoArma[i] = ArmasMenu();
            potenciaArma[i] = potenciaArmaMenu();
        }
        this.conjuntoDeArmas = conjuntoDeArmas(cantidadArmas, tipoArma, potenciaArma);
    }

    //Constructor Destructor sin introducir datos por pantalla
    public Destructor(int tripulantes, int cantidadDef, int tipoDef, int cantidadProp,
                      int tipoProp[], int cantidadArmas, int tipoArma[], int potenciaArmas[]) {
        this.tripulantesTotales = tripulantesTotales(tripulantes);
        this.conjuntoDefensa = sistemaDeDefensa(cantidadDef, tipoDef);
        this.prop = conjuntoDePropulsion(cantidadProp, tipoProp);
        this.conjuntoDeArmas = conjuntoDeArmas(cantidadArmas, tipoArma, potenciaArmas);
    }

    //Cantidad de tripulantes
    @Override
    public int tripulantesTotales(int tripulantes) {
        return tripulantes;
    }

    //Sistema de Defensas de Destructor (1 o 2)
    //Introducir la cantidad de Defensas
    public int cantidadDefensaMenu(){
        //Escoger numero de Defensas de Destructor
        System.out.println("¿Cuantas defensas tiene?");
        int cantidad = numeroIntroducido();
        //Comprobar que el numero de Defensas es correcto
        while (cantidad > numeroDeDefensasMax() || cantidad < 1) {
            System.out.println("Puede tener como maximo dos defensas, ¿Cuantas posee?(1 o 2)");
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
    //Lista de Defensas del Destructor (Destructor puede tener 1 o 2 defensas)
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
    //Danio total que absorbe la defensa de Destructor
    @Override
    public int getDefensaTotal(){
        return defensaTotal;
    }

    //Conjunto de Armas de Destructor
    //Introducir la cantidad de Armas de Destructor (Min 1)
    public int cantidadArmasMenu() {
        System.out.println("¿Cuantas Armas va a querer?");
        int cantidad = numeroIntroducido();
        //Comprobar que el numero de Armas es correcto
        while (cantidad < 1) {
            System.out.println("El Destructor tiene que tener al menos un arma.");
            System.out.println("¿Cuantas Armas va a querer?");
        }
        return cantidad;
    }
    public int ArmasMenu(){
        System.out.println("Que arma quiere elegir:");
        System.out.println("0) PEM");
        System.out.println("1) Misil Termonuclear");
        System.out.println("2) Rayo Laser");
        System.out.println("3) Cañon de plasma");
        int modelo = numeroIntroducido();
        return modelo;
    }
    public static int potenciaArmaMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la potencia del arma: ");
        int danio = sc.nextInt();
        System.out.println("¡La potencia de su arma será " + danio + " !");
        return danio;
    }
    //Lista de Armas del Destructor (Destructor solo tiene 1 Arma)
    public List<Arma> conjuntoDeArmas(int numeroArmas, int tipoArma[], int potenciaArma[]) {
        List<Arma> armas = new ArrayList<>();
        if (numeroArmas<1)
            throw new IllegalStateException("Unexpected value: ");
        for (int i = 0; i < numeroArmas; i++) {
            //Escoger el tipo de Arma
            Arma a = new Arma(tipoArma[i], potenciaArma[i]);
            armas.add(a);//Añadir el arma creada a la lista de Armas
            potencia += a.potencia; //Sumar la potencia de todas las armas del Caza
        }
        return armas;

    }
    @Override
    public int potenciaDeAtaque() {
        return potencia;
    }

    //Sistema de Propulsion de Destructor (1 o 2)
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

    //El número máximo de Defensas de Destructor es 2
    private final int numeroDeDefensasMax() {
        return 2;
    }

    @Override
    public String toString() {
        return "Destructor" +
                "\nNumero de Tripulantes" + tripulantesTotales +
                "\nNumero de Defensas" + numDefensas +
                "\nDefensas = " + conjuntoDefensa +
                "\nArmas = " + conjuntoDeArmas +
                "\nPotencia total = " + potencia +
                "\nPropulsion = " + prop +
                "\nNumero de Identificacion = " + numReg;
    }
}
