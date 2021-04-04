import java.util.Random;
import java.util.Scanner;

//Clase Escudo hereda de Defensa
public class Escudo extends Defensa{
    int energiaR; //Energia necesaria para el Escudo
    int danioQueAb; //Danio que Absobe el Escudo

    //Constructor Escudo
    public Escudo() {
        this.energiaR = energiaRequerida();
        this.danioQueAb= danioQueAbsorbe();
    }

    //Energía Requerida para el Escudo
    public int energiaRequerida(){
        //Preguntar la Energía Requerida
        System.out.println("¿Que energia quiere que su escudo consuma?");
        System.out.println("'Cuanto mas consuma mas daño soportará'");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println("La energia de su escudo para funcionar sera de "+ s);
        return s;
    }

    //Danio que Absorbe el Escudo
    public int danioQueAbsorbe() {
        int e=this.energiaR*10;
        System.out.println("La energia que conseguira repeler sera de "+ e);
        return e;
    }

    @Override
    public String toString() {
        return "Escudo: Energia requerida= " + energiaR +
                ", Daño Absorbido= " + danioQueAb;
    }

}
