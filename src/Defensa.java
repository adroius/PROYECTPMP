import java.util.Scanner;

public class Defensa {
    String nombre="";

    public Defensa() {
        this.nombre=tipoDeDefensa();
        select();
    }

    public String getNombre() {
        return nombre;
    }

    public String tipoDeDefensa(){
        String nombre="";
        System.out.println("Introduzca el tipo de defensa: ");
        System.out.println("1) Escudo");
        System.out.println("2) Blindaje");
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        boolean seleccionado=false;
            switch (d) {
                case 1:
                    nombre = "Escudo";
                    seleccionado=true;
                    break;
                case 2:
                    nombre = "Blindaje";
                    seleccionado=true;
                    break;
            }
        System.out.println("Ha seleccionado "+nombre);
        return nombre;
    }
    public void select(){
        if (this.nombre=="Escudo"){
            Escudo e=new Escudo();
            e.toString();
        } else {
            Blindaje b=new Blindaje();
            b.toString();
        }
    }
}
