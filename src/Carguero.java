import java.util.Scanner;

public class Carguero extends TipoDeNave{
    int tripulantesMax=0;
    int cargaMax=0;
    String defensa="";

    public Carguero(){
        this.tripulantesMax = tripulantes();
        this.cargaMax = carga();
        this.defensa= seleccionDefensa();
    }
    public int tripulantes(){
        System.out.println("¿?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return  (s);
    }
    public int carga(){
        System.out.println("carga");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        return (c);
    }
    public String seleccionDefensa(){
        Defensa e = new Defensa();
        return e.toString();
    }

}
