import java.util.Scanner;

public abstract class Defensa {
    public String tipoDeDefensa(){
        String nombre;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el tipo de defensa: ");
        nombre = teclado.nextLine();
        return nombre;
    }

    public abstract int dañoQueAbsorbe();
}
