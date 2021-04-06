import java.util.Scanner;

//Clase Blindaje hereda de Defensa
public class Blindaje extends Defensa {
    private String material; //Material del Blindaje
    private int danioAbsorbe; //Danio que Absorbe el Blindaje
    private int peso; //Peso del Blindaje

    //Constructor Blindaje
    public Blindaje() {
        super();
        this.material = materialEscogido();
        this.danioAbsorbe = danioQueAbsorbe();
        this.peso = danioQueAbsorbe() * 10; //El peso es igual al daño que Absorbe * 10
    }

    @Override
    public int danioQueAbsorbe() {
        int dqa;
        //Dependiendo del material del Blindaje absorbera una cantidad de danio
        switch (material) {
            case "Adamantium": {
                dqa = 1832732;
                break;
            }
            case "Hierro": {
                dqa = 329473;
                break;
            }
            case "Plata": {
                dqa = 7324823;
                break;
            }
            case "Platino": {
                dqa = 321091;
                break;
            }
            case "Oro": {
                dqa = 4398453;
                break;
            }
            case "Diamante": {
                dqa = 74910132;
                break;
            }
            //Si el valor recogido es incorrecto
            default:
                throw new IllegalStateException("Unexpected value: " + materialEscogido());

        }
        return dqa;
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
        while (valorObtenido < 0 || valorObtenido > 5){
            System.out.println("El valor introducido es incorrecto.");
            System.out.println("Vuelva a introducir el valor:");
            System.out.println("0) Adamantium");
            System.out.println("1) Hierro");
            System.out.println("2) Plata");
            System.out.println("3) Platino");
            System.out.println("4) Oro");
            System.out.println("5) Diamante");
            valorObtenido = sc.nextInt();
        }
        switch (valorObtenido) {
            case 0: {
                nombre = "Adamantium";
                break;
            }
            case 1: {
                nombre = "Hierro";
                break;
            }
            case 2: {
                nombre = "Plata";
                break;
            }
            case 3: {
                nombre = "Platino";
                break;
            }
            case 4: {
                nombre = "Oro";
                break;
            }
            case 5: {
                nombre = "Diamante";
                break;
            }
            //El valor introducido es incorrecto
            default:
                throw new IllegalStateException("Unexpected value: " + valorObtenido);
        }
        return nombre;
    }

    //Devuleve el material y el danio que Absorbe el Blindaje
    @Override
    public String toString() {

        return ("Blindaje: " +
                "\nMaterial='" + material +
                "\nDanio Que Absorbe=" + danioAbsorbe);
    }
}
