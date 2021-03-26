import java.util.Random;

public class Blindaje extends Defensa{
    String material;
    int dañoAbsorbe;

    private Random number = new Random();

    public Blindaje() {
        this.material= nombreMaterial();
        this.dañoAbsorbe=dañoQueAbsorbe();
    }

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
