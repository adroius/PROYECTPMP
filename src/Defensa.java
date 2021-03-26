import java.util.Scanner;

public class Defensa {
    String nombre="";
    public Defensa() {
        this.nombre=tipoDeDefensa();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Defensa{" + "nombre='" + nombre + '}';
    }

    public String tipoDeDefensa(){
        String nombre;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el tipo de defensa: ");
        System.out.println("1) Escudo");
        System.out.println("2) Blindaje");
        Scanner sc = new Scanner(System.in);
        return  (int s = sc.nextInt());
        switch (s){
            case 1:
                return "Escudo";
                new Escudo();
                break;
            case 2:
                return "Blindaje";
                new Blindaje();
                break;
        }
    }
}
