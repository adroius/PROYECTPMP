import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Caza extends Nave{
    int tripulantesMax;
    List<Defensa> defensa;
    List<Arma> conjuntoDeArmas;
    Propulsion prop;

    public Caza(){
        super();
        this.tripulantesMax = tripulantes();
        this.defensa= tipoDeDefensa();
        this.prop= new Propulsion();
        this.conjuntoDeArmas=conjuntoDeArmas();
    }
    public Caza(int e,List<Defensa> d, Propulsion p){
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

    @Override
    public String toString() {
        return "Caza:" + "\nTripulacion = " + tripulantesMax + "\nDefensa = " + defensa.toString() + "\nArmas: " +conjuntoDeArmas.toString()+ "\nPropulsion: "+prop.toString();
    }

    public List<Defensa> tipoDeDefensa(){
        List<Defensa> defensa = new ArrayList<>();
        System.out.println("Introduzca el tipo de defensa: ");
        System.out.println("1) Escudo");
        System.out.println("2) Blindaje");
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        Defensa d;
        switch (e) {
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
        return defensa;
    }

    public List<Arma> conjuntoDeArmas(){
        List<Arma> armas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas armas va a querer?");
        int i = sc.nextInt();
        while (i>2){
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
