import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstacionEspacial extends Nave{
    int tripulantesMax;
    List<Defensa> defensa;
    List<Arma> conjuntoDeArmas;
    List<Nave> conjuntoDeNaves;
    Propulsion prop;

    public EstacionEspacial() {
        this.tripulantesMax = tripulantes();
        this.defensa= tipoDeDefensa();
        this.prop= new Propulsion();
        this.conjuntoDeArmas=conjuntoDeArmas();
        this.conjuntoDeNaves=conjuntoDeNaves();
    }

    @Override
    public String toString() {
        return "EstacionEspacial{" +
                "tripulantesMax=" + tripulantesMax +
                ", defensa=" + defensa +
                ", conjuntoDeArmas=" + conjuntoDeArmas +
                ", conjuntoDeNaves=" + conjuntoDeNaves +
                ", prop=" + prop +
                '}';
    }

    @Override
    public int tripulantes() {
        return 0;
    }

    @Override
    public List<Defensa>  tipoDeDefensa() {
        List<Defensa> defensa = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas defensas tiene?");
        int e = sc.nextInt();
        while (e>3){
            System.out.println("Solo puede tener dos defensas, ¿Cuantas posee?(1 o 3)");
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
    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas armas va a querer?");
        int i = sc.nextInt();
        while (i>3){
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

    public List<Nave> conjuntoDeNaves() {
        return null;
    }
}
