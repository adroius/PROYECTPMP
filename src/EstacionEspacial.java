import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstacionEspacial extends Nave{
    int tripulantesMax;
    Defensa defensa;
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
    public Defensa tipoDeDefensa() {
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
