import java.util.Scanner;
//Clase Blindaje hereda de Defensa
public class Blindaje extends Defensa {
    private String material;
    private int danioAbsorbe;
    private int peso;

    //Constructor Blindaje
    public Blindaje() {
        super();
        this.material = materialEscogido();
        this.danioAbsorbe = peso()%10;
        this.peso = peso();
    }

    //Indicar material del Blindaje
    private String materialEscogido() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que blindaje quiere elegir:");
        System.out.println("0) Adamantium");
        System.out.println("1) Hierro");
        System.out.println("2) Plata");
        System.out.println("3) Platino");
        System.out.println("4) Oro");
        System.out.println("5) Diamante");
        int valorObtenido = sc.nextInt();
        String nombre;
        switch (valorObtenido) {
            case 0 -> {
                nombre = "Adamantium";
            }
            case 1 -> {
                nombre = "Hierro";
            }
            case 2 -> {
                nombre = "Plata";
            }
            case 3 -> {
                nombre = "Platino";
            }
            case 4 -> {
                nombre = "Oro";
            }
            case 5 -> {
                nombre = "Diamante";
            }
            default -> throw new IllegalStateException("Unexpected value: " + valorObtenido);
        }
        return nombre;
    }

    //Asignar peso del Blindaje
    public int peso() {
        int p = 0;
        switch (materialEscogido()) {
            case "Adamantium" -> {
                p = 1832732;
            }
            case "Hierro" -> {
                p = 329473;
            }
            case  "Plata" -> {
                p = 7324823;
            }
            case "Platino" -> {
                p = 321091;
            }
            case "Oro" -> {
                p = 4398453;
            }
            case "Diamante" -> {
                p = 74910132;
            }
        }
        return p;
    }

    //Devuleve el material y el danio que Absorbe el Blindaje
    @Override
    public String toString() {
        return ("Blindaje: " + "Material='" + material + ", danioAbsorbe=" + danioAbsorbe);
    }
}
