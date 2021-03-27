import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Caza extends TipoDeNave{
    int tripulantesMax;
    Defensa defensa;
    List<Arma> conjuntoDeArmas;
    Propulsion prop;

    public Caza(){
        super();
        this.tripulantesMax = tripulantes();
        this.defensa= tipoDeDefensa();
        this.prop= new Propulsion();
        this.conjuntoDeArmas=conjuntoDeArmas();
    }
    public Caza(int e,Defensa d, Propulsion p){
        super();
        this.tripulantesMax = e;
        this.defensa= d;
        this.prop= p;
        this.conjuntoDeArmas=conjuntoDeArmas();
    }

    public int tripulantes(){
        System.out.println("¿Cuantos tripulantes van a caber?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        while (s>2){
            System.out.println("La capacidad del caza es insuficiente");
            System.out.println("¿Cuantos tripulantes van a caber?");
            s = sc.nextInt();
        }
        return  (s);
    }

    public int getTripulantesMax() {
        return tripulantesMax;
    }

    public Defensa getDefensa() {
        return defensa;
    }

    @Override
    public String toString() {
        return "Caza:" + "\nTripulacion = " + tripulantesMax + "\nDefensa = " + defensa.toString() + "\nArmas: " +conjuntoDeArmas.toString()+ "\nPropulsion: "+prop.toString();
    }

    public Defensa tipoDeDefensa(){
        System.out.println("Introduzca el tipo de defensa: ");
        System.out.println("1) Escudo");
        System.out.println("2) Blindaje");
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        switch (e) {
            case 1:
                Defensa d = new Escudo();
                return d;
            case 2:
                d = new Blindaje();
                return d;
            default:
                throw new IllegalStateException("Valor incorrecto: " + e);
        }
    }

    public List<Arma> conjuntoDeArmas(){
        List<Arma> armas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas armas va a querer(1 o 2)?");
        int i = sc.nextInt();
        while (i<2){
            System.out.println("La capacidad del caza para portar armas es limitada");
            System.out.println("¿Cuantas armas va a querer(1 o 2)?");
            i = sc.nextInt();
        }
        do{
                Arma a=new Arma();
                armas.add(a);
                i=i-1;
        } while (i!=0);
        return armas;
    }
}
