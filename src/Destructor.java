import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Destructor extends NaveBuilder{
    List<Arma> conjuntoDeArmas;
    List<Defensa> conjuntoDefensa;
    List<Propulsion> prop;

    //Constructor Destructor
    public Destructor(){
        super();
        this.prop= conjuntoDePropulsion(); //
        this.conjuntoDeArmas=conjuntoDeArmas();
        this.conjuntoDefensa=tipoDeDefensa();
    }

    //Capacidad de tripulantes
    @Override
    public int tripulantes() {
        System.out.println("¿Cuanto va a ser la capacidad maxima del carguero?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return  (s);
    }

    @Override
    public List<Defensa> tipoDeDefensa() {
        List<Defensa> defensa = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas defensas tiene?");
        int e = sc.nextInt();
        while (e>2){
            System.out.println("Solo puede tener dos defensas, ¿Cuantas posee?(1 o 2)");
            e = sc.nextInt();
        }
        Defensa d;
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

    @Override
    public List<Arma> conjuntoDeArmas(){
        List<Arma> armas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("La capacidad del destructor para portar armas es ilimitada");
        System.out.println("¿Cuantas armas tiene el destructor?");
        int i = sc.nextInt();
        do {
            Arma a = new Arma();
            armas.add(a);
            i=i-1;
        }while (i!=0);
        return armas;
    }

    @Override
    public List<Propulsion> conjuntoDePropulsion() {
        List<Propulsion> prop = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas propulsiones va a querer?");
        int i = sc.nextInt();
        while (i>2){
            System.out.println("La capacidad de la nave para portar propulsiones es limitada");
            System.out.println("¿Cuantas propulsiones va a querer(1 o 2)?");
            i = sc.nextInt();
        }
        do{
            Propulsion a=new Propulsion();
            prop.add(a);
            i=i-1;
        } while (i!=0);
        return prop;
    }

    @Override
    public int numeroDeDefensasMax() {
        return 2;
    }

    //Devuelve el tipo de defensas, armas y propulsion del destructor
    @Override
    public String toString() {
        return "Destructor:" + "\nDefensa = " + conjuntoDefensa.toString() + "\nArmas: " +conjuntoDeArmas.toString()+ "\nPropulsion: "+prop.toString();
    }

}
