import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carguero extends NaveBuilder{
    int tripulantesMax=0;
    int carga=0;
    List<Defensa> defensa;
    List<Propulsion> prop;

    public Carguero(){
        this.tripulantesMax = tripulantes();
        this.carga = carga();
        this.defensa= tipoDeDefensa();
        this.prop=conjuntoDePropulsion();
    }

    @Override
    public int tripulantes(){
        System.out.println("¿Cuanto va a ser la capacidad maxima de tripulantes del carguero?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return  (s);
    }

    @Override
    public List<Defensa> tipoDeDefensa() {
        List<Defensa> defensa = new ArrayList<>();
        System.out.println("Introduzca el tipo de defensa: ");
        System.out.println("1) Escudo");
        System.out.println("2) Blindaje");
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        switch (e) {
            case 1:
                Defensa d = new Escudo();
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

    @Override
    public List<Arma> conjuntoDeArmas() {
        List<Arma> armas = new ArrayList<>();
            Arma a=new Arma();
            armas.add(a);
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

    public int carga(){
            System.out.println("Introduzca la carga maxima: ");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        return c;
    }
}
