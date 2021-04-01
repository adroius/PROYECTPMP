import java.util.Scanner;

//Clase NaveBuilder hereda de Nave
public abstract class NaveBuilder extends Nave{

    //Escoger que clase de nave se va a crear
    public static Nave CrearNave(){
        Nave n;
        System.out.println("Que nave desea registrar:");
        System.out.println("1) Caza");
        System.out.println("2) Destructor");
        System.out.println("3) Carguero");
        System.out.println("4) Estacion espacial");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        switch (s) {
            case 1 -> {
                System.out.println("Ha seleccionada Caza");
                n = new Caza(); //Constructor de Caza
            }
            case 2 -> {
                System.out.println("Ha seleccionada Destructor");
                n = new Destructor(); //Constructor de Destructor
            }
            case 3 -> {
                System.out.println("Ha seleccionada Carguero");
                n = new Carguero(); //Constructor de Carguero
            }
            case 4 -> {
                System.out.println("Ha seleccionada Estacion Espacial");
                n = new EstacionEspacial(); //Constructor de EstacionEspacial
            }
            default -> throw new IllegalStateException("Unexpected value: " + s); //Ha introducido un numero incorrecto
        }
        return n;
    }
}
