import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    List<Usuario> users = new ArrayList<>();
    //Builder Sistema
    public Sistema() {
        boolean f = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Bienvenido al concesionario espacial");
            System.out.println("1) Ingresar nuevo cliente");
            System.out.println("2) Registrarse");
            System.out.println("3) Salir");
            int s = sc.nextInt();
            switch (s) {
                case 1 -> {
                    users.add(registrarNuevoCliente());
                }
                case 2 -> iniciarSesion();
                case 3 -> f = true;
                default -> throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }

    //Registrar Nuevo Cliente
    public Usuario registrarNuevoCliente() {
        Usuario u= new Usuario();
        return u;
    }
    //Inciar Sesion
    public boolean iniciarSesion() {
        boolean ingresado = false;
        return ingresado;
    }
}
