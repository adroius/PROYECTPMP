import java.util.Scanner;
//Clase Blindaje hereda de Defensa
public class Blindaje extends Defensa {
    private String material;
    private int danioAbsorbe;
    private int peso;

    //Constructor Blindaje
    public Blindaje() {
        super();
        this.material = nombreMaterial();
        this.danioAbsorbe = danioQueAbsorbe();
        this.peso = peso();
    }

    //Indicar material del Blindaje
    private int materialEscogido() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que blindaje quiere elegir:");
        System.out.println("0) Adamantium");
        System.out.println("1) Hierro");
        System.out.println("2) Plata");
        System.out.println("3) Platino");
        System.out.println("4) Oro");
        System.out.println("5) Diamante");
        int valorObtenido = sc.nextInt(6);
        return valorObtenido;
    }

    //Asignar peso del Blindaje
    public int peso() {
        int p = 0;
        switch (materialEscogido()) {
            case 0 -> {
                p = 1832732;
            }
            case 1 -> {
                p = 329473;
            }
            case 2 -> {
                p = 7324823;
            }
            case 3 -> {
                p = 321091;
            }
            case 4 -> {
                p = 4398453;
            }
            case 5 -> {
                p = 74910132;
            }
        }
        return p;
    }

    //Asignar danio que Absorbe el blindaje
    @Override
    public int danioQueAbsorbe() {
        int d = 0;
        switch (materialEscogido()) {
            case 0 -> {
                d = 10000;
            }
            case 1 -> {
                d = 375;
            }
            case 2 -> {
                d = 15;
            }
            case 3 -> {
                d = 1000;
            }
            case 4 -> {
                d = 175;
            }
            case 5 -> {
                d = 5000;
            }
        }
        return d;
    }

    //Asignar el nombre del material del Blindaje
    public String nombreMaterial() {
        String nombre = "";
        switch (materialEscogido()) {
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
        }
        System.out.println("Ha sido seleccionado: " + nombre);
        return nombre;
    }

    //Devuleve el material y el danio que Absorbe el Blindaje
    @Override
    public String toString() {
        return ("Blindaje: " + "Material='" + material + ", danioAbsorbe=" + danioAbsorbe);
    }
}
