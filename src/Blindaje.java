import java.util.Random;
import java.util.*;
public class Blindaje extends Defensa{

    private Random number = new Random();

    public int dañoQueAbsorbe() {
        return number.nextInt();
    }

    public String nombreMaterial(){
        String nombre = "";
        int valorObtenido = number.nextInt(6);
        switch (valorObtenido){
            case 0: nombre="Adamantium";
                break;
            case 1: nombre="Hierro";
                break;
            case 2: nombre="Plata";
                break;
            case 3: nombre="Platino";
                break;
            case 4: nombre="Oro";
                break;
            case 5: nombre="Diamante";
                break;
        }
        return nombre;
    }
}
