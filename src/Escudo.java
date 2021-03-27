import java.util.Random;
import java.util.Scanner;

public class Escudo extends Defensa{
    int energiaR;
    int danioQueAb;

    public Escudo() {
        this.energiaR = energiaRequerida();
        this.danioQueAb= danioQueAbsorbe();
    }

    @Override
    public String toString() {
        return "Escudo: Energia requerida= " + energiaR + ", Daño absorbido= " + danioQueAb;
    }

    public int energiaRequerida(){
        System.out.println("¿Que energia quiere que su escudo consuma?");
        System.out.println("'Cuanto mas consuma mas energia soportará'");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println("La energia de su escudo para funcionar sera de "+ s);
        return s;
    }

    public int danioQueAbsorbe() {
        int e=this.energiaR*10;
        System.out.println("La energia que conseguira repeler sera de "+ e);
        return e;
    }
}
