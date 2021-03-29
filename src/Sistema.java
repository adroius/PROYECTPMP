import java.util.Scanner;

public class Sistema {
    public Sistema() {
    }

    public void getSistema() {
        boolean f;
        do {
            System.out.println("Bienvenido al concesionario espacial");
            System.out.println("¿Que es lo que desea realizar?");
            System.out.println("0) Ingresar cliente");
            System.out.println("1) Registrarse nuevo cliente");
            System.out.println("2) Ver ofertas");
            System.out.println("3) Salir");
            f=finalizar();
        }while(!f);
    }
    public boolean finalizar(){
        boolean finalizar;
        Scanner sc = new Scanner(System.in);
            System.out.println("¿Desea continuar?");
            System.out.println("1) SI");
            System.out.println("2) NO");
            int s = sc.nextInt();
            switch (s) {
                case 1 -> finalizar = false;
                case 2 -> finalizar = true;
                default -> throw new IllegalStateException("Unexpected value: " + s);
            }
        return finalizar;
    }
}
