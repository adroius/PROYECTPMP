import java.util.Scanner;

public class Defensa {
    String nombre="";
    Defensa objeto;

    public Defensa() {
        this.nombre=tipoDeDefensa();
        if (nombre=="Escudo"){
            this.objeto=new Escudo();
        } else {
            this.objeto=new Blindaje();
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Defensa{" + "nombre='" + nombre + '}';
    }

    public String tipoDeDefensa(){
        String nombre="";
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el tipo de defensa: ");
        System.out.println("1) Escudo");
        System.out.println("2) Blindaje");
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        switch (d){
            case 1:
                nombre = "Escudo";
                break;
            case 2:
                nombre = "Blindaje";
                break;
        }
        return nombre;
    }
}
