import java.util.Scanner;

public class Destructor extends TipoDeNave{
        int tripulantesMax=0;
        int cargaMax=0;
        Defensa defensa;

    public Destructor(){
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
    public Defensa seleccionDefensa(){
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
}
