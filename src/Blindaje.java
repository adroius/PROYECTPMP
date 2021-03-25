import java.util.Random;

public class Blindaje extends Defensa{
    private Random number = new Random();
    @Override
    public int dañoQueAbsorbe() {
        return number.nextInt();
    }

    public String nombreMaterial(){
        String nombre = "";
        int valorObtenido = number.nextInt(6);
        switch (valorObtenido){
            case 0: nombre="Cobre";
                break;
            case 1: nombre="Hierro";
                break;
            case 2: nombre="Plata";
                break;
            case 3: nombre="Plástico";
                break;
            case 4: nombre="Oro";
                break;
            case 5: nombre="Diamante";
                break;
        }
        return nombre;
    }
}
