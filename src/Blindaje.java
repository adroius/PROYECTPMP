import java.util.Random;

public class Blindaje extends Defensa{
    String material;
    int danioAbsorbe;
    int dureza;

    private Random number = new Random();

    public Blindaje() {
        super();
        this.material= nombreMaterial();
        this.danioAbsorbe=danioQueAbsorbe();
    }

    public int danioQueAbsorbe() {
        int e=this.dureza;
        System.out.println("La energia que conseguira repeler sera de "+ e);
        return e;
    }

    @Override
    public String toString() {
        return ("Blindaje: " + "Material='" + material + ", danioAbsorbe=" + danioAbsorbe);
    }

    public String nombreMaterial(){
        String nombre = "";
        int valorObtenido = number.nextInt(6);
        switch (valorObtenido) {
            case 0 -> {
                nombre = "Adamantium";
                this.dureza = 10000;
            }
            case 1 -> {
                nombre = "Hierro";
                this.dureza = 375;
            }
            case 2 -> {
                nombre = "Plata";
                this.dureza = 15;
            }
            case 3 -> {
                nombre = "Platino";
                this.dureza = 1000;
            }
            case 4 -> {
                nombre = "Oro";
                this.dureza = 175;
            }
            case 5 -> {
                nombre = "Diamante";
                this.dureza = 5000;
            }
        }
        System.out.println("Ha sido seleccionado: "+ nombre);
        return nombre;
    }

}
