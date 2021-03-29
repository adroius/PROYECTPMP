import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Destructor extends NaveBuilder{
    List<Arma> conjuntoDeArmas;
    List<Defensa> conjuntoDefensa;
    Propulsion prop;

    public Destructor(){
        super();
        this.prop= new Propulsion();
        this.conjuntoDeArmas=conjuntoDeArmas();
        this.conjuntoDefensa=tipoDeDefensa();
    }

    @Override
    public int tripulantes() {
        return 0;
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
    public List<Arma> conjuntoDeArmas() {
        return null;
    }


    @Override

    public String toString() {
        return "Destructor:" + "\nDefensa = " + conjuntoDefensa.toString() + "\nArmas: " +conjuntoDeArmas.toString()+ "\nPropulsion: "+prop.toString();
    }

}
