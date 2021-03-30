import java.util.Scanner;

public class Sistema {
    public Sistema() {
    }

    public void getSistema() {
        boolean f = false;
        Scanner sc = new Scanner(System.in);
        do {
            int s = sc.nextInt();
            System.out.println("Bienvenido al concesionario espacial");
            System.out.println("¿Que es lo que desea realizar?");
            System.out.println("1) Ingresar nuevo cliente");
            System.out.println("2) Registrarse cliente");
            System.out.println("3) Salir");
            switch (s) {
                case 1:
                    registrarNuevoCliente();
                    break;
                case 2:
                

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

    public void registrarNuevoCliente() {
        Usuario u = new Usuario();
    }

    public boolean iniciarSesion(String user, String contraseña) {
        boolean ingresado = false;
        return ingresado;
    }
}
