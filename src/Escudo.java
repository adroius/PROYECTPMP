import java.util.Random;

public class Escudo extends Defensa{
    private Random number = new Random();

    public int energiaRequerida(){
        return number.nextInt();
    }

    public int dañoQueAbsorbe() {
        return number.nextInt();
    }
}
