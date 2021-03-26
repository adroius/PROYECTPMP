import java.util.Scanner;

public class Destructor extends TipoDeNave{
        int tripulantesMax=0;
        int cargaMax=0;
        Defensa defensa;

    public Destructor(){
        this.tripulantesMax = tripulantes();
        this.cargaMax = carga();
        this.defensa= new Defensa();
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
