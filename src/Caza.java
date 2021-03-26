import java.util.Scanner;

public class Caza extends TipoDeNave{
    int tripulantesMax=0;
    String defensa="";

    public Caza(){
        this.tripulantesMax = tripulantes();
        this.defensa= seleccionDefensa();
    }
    public int tripulantes(){
        System.out.println("¿Cuantos tripulantes van a caber?");
        Scanner sc = new Scanner(System.in);
        return  (int s = sc.nextInt());
    }
    public String seleccionDefensa(){
        Defensa d = new Defensa();
        return d.toString();
    }
}
