import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Caza{
    int tripulantesMax=1;
    Defensa defensa;

    public Caza(){
        this.tripulantesMax = tripulantesMax();
        this.defensa= new Defensa();;
    }

    public List<Arma> conjuntoDeArmas(){
        List<Arma> armas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int i;
        do{
            for (Arma a:armas){
                a.nombre();
                a.potencia();
                armas.add(a);
            }
            System.out.println("Quieres continuar?");
            System.out.println("0 = salir");
            System.out.println("1 = continuar");
            i = sc.nextInt();
        } while (i!=0);
        return armas;
    }

    public int tripulantesMax(){
        System.out.println("¿Cuantos tripulantes caben?");
        return tripulantesMax;
    }
}
