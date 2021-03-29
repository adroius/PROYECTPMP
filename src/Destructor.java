import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Destructor extends TipoDeNave{
    List<Arma> conjuntoDeArmas;
    List<Defensa> conjuntoDefensa;
    Defensa defensa;
    Propulsion prop;

    public Destructor(){
        super();
        this.prop= new Propulsion();
        this.conjuntoDeArmas=conjuntoDeArmas();
    }
    public Destructor(int Defensa , Propulsion p){
        super();
        this.prop= p;
        this.conjuntoDeArmas= conjuntoDeArmas();
    }
    public Defensa getDefensa() {
        return defensa;
    }

    @Override

    public String toString() {
        return "Destructor:" + "\nDefensa = " + conjuntoDefensa.toString() + "\nArmas: " +conjuntoDeArmas.toString()+ "\nPropulsion: "+prop.toString();
    }

    public List<Defensa> conjuntoDefensa(){
        List<Defensa> armas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que defensas tiene?");
        int e = sc.nextInt();
        while (e>2){
            System.out.println("Solo puede tener dos defensas, ¿Cuantas posee?(1 o 2)");
            e = sc.nextInt();
        }
        do{
            Defensa d=new Defensa();
            Defensa.add(d);
            e=e-1;
        } while (e!=0);
        return Defensa;
    }



}
