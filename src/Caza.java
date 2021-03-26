import java.util.Scanner;

public class Caza{
    int tripulantesMax=0;
    Defensa defensa;

    public Caza(){
        this.tripulantesMax = tripulantes();
        this.defensa= tipoDeDefensa();
    }
    public int tripulantes(){
        System.out.println("¿Cuantos tripulantes van a caber?");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return  (s);
    }

    public int getTripulantesMax() {
        return tripulantesMax;
    }

    public Defensa getDefensa() {
        return defensa;
    }

    @Override
    public String toString() {
        return "Caza:" + "\nTripulacion = " + tripulantesMax + "\nDefensa = " + defensa.toString();
    }

    public Defensa tipoDeDefensa(){
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
