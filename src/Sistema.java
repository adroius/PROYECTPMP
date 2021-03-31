import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    List<Usuario> users = new ArrayList<>();
    //Constructor Sistema
    public Sistema() {
        boolean f = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Bienvenido al concesionario espacial");
            System.out.println("1) Ingresar nuevo cliente");
            System.out.println("2) Registrarse cliente");
            System.out.println("3) Salir");
            int s = sc.nextInt();
            switch (s) {
                case 1:
                    users.add(registrarNuevoCliente());
                    System.out.println(users.toString());
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    f = finalizar();
                    break;
            }
        } while (!f);
    }

    private boolean finalizar() {
        boolean finalizar;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Desea Salir?");
        System.out.println("1) SI");
        System.out.println("2) NO");
        int s = sc.nextInt();
        switch (s) {
            case 1 -> finalizar = true;
            case 2 -> finalizar = false;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        }
        return finalizar;
    }
    //Registrar Nuevo Cliente
    public Usuario registrarNuevoCliente() {
        return new Usuario();
    }
    //Inciar Sesion
    public boolean iniciarSesion() {
        boolean ingresado = false;

        return ingresado;
    }
}
