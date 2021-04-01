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
        this.danioAbsorbe = danioQueAbsorbe();
        this.peso = danioQueAbsorbe() * 10;
    }

    @Override
    public int danioQueAbsorbe() {
        int p = 0;
        switch (material) {
            case "Adamantium" -> {
                p = 1832732;
                break;
            }
            case "Hierro" -> {
                p = 329473;
                break;
            }
            case "Plata" -> {
                p = 7324823;
                break;
            }
            case "Platino" -> {
                p = 321091;
                break;
            }
            case "Oro" -> {
                p = 4398453;
                break;
            }
            case "Diamante" -> {
                p = 74910132;
                break;
            }
            default -> throw new IllegalStateException("Unexpected value: " + materialEscogido());
        }
        return p;
    }

    //Indicar material del Blindaje
    public String materialEscogido() {
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
                break;
            }
            case 1 -> {
                nombre = "Hierro";
                break;
            }
            case 2 -> {
                nombre = "Plata";
                break;
            }
            case 3 -> {
                nombre = "Platino";
                break;
            }
            case 4 -> {
                nombre = "Oro";
                break;
            }
            case 5 -> {
                nombre = "Diamante";
                break;
            }
            default -> throw new IllegalStateException("Unexpected value: " + valorObtenido);
        }
        return nombre;
    }

    //Devuleve el material y el danio que Absorbe el Blindaje
    @Override
    public String toString() {
        return ("Blindaje: " + "Material='" + material + ", danioAbsorbe=" + danioAbsorbe);
    }
}
