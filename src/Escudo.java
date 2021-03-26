import java.util.Random;
import java.util.Scanner;

public class Escudo extends Defensa{
    int energiaR=0;
    int dañoQueAb=0;

    public Escudo() {
        this.energiaR = energiaRequerida();
        this.dañoQueAb= dañoQueAbsorbe();
    }

    @Override
    public String toString() {
        return "Escudo: Energia requerida= " + energiaR + ", Daño absorbido= " + dañoQueAb;
    }

    public int energiaRequerida(){
        System.out.println("¿Que energia quiere que su escudo consuma?");
        System.out.println("'Cuanto mas consuma mas energia soportará'");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println("La energia de su escudo para funcionar sera de "+ s);
        return s;
    }

    public int dañoQueAbsorbe() {
        int e=this.energiaR*10;
        System.out.println("La energia que conseguira repeler sera de "+ e);
        return e;
    }
}
