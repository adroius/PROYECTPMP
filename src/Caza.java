import java.util.Scanner;

public class Caza{
    int tripulantesMax=0;
    Defensa defensa;

    public Caza(){
        this.tripulantesMax = tripulantes();
        this.defensa= new Defensa();
    }
    public int tripulantes(){
        System.out.println("¿Cuantos tripulantes van a caber?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return  (s);
    }
}
