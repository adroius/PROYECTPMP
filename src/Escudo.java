import java.util.Random;
import java.util.*;
public class Escudo extends Defensa{

    private Random number = new Random();

    public int energiaRequerida(){
        return number.nextInt();
    }

    public int dañoQueAbsorbe() {
        return number.nextInt();
    }
}
