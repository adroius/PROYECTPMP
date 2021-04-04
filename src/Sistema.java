import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    List<Usuario> users = new ArrayList<>();

    //Constructor Sistema
    public Sistema() {
        boolean f = false;
        Scanner sc = new Scanner(System.in);
        //Menu del sistema
        do {
            System.out.println("Bienvenido al concesionario espacial");
            System.out.println("1) Ingresar nuevo cliente");
            System.out.println("2) Registrarse");
            System.out.println("3) Salir");
            int s = sc.nextInt();
            switch (s) {
                case 1 -> {
                    users.add(registrarNuevoCliente());
                    menu();
                    f = true;
                }
                case 2 -> {
                    if (iniciarSesion()) {
                        menu();
                        f = true;
                    }
                }
                case 3 -> f = true;
                default -> throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }

    //Menu
    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean f = false;
        do {
            System.out.println("¿Que es lo que quiere realizar?");
            System.out.println("1) Registrar nave");
            System.out.println("2) Ver ofertas");
            System.out.println("3) Salir");
            int s = sc.nextInt();
            switch (s) {
                //case 1 -> ;
                //case 2 -> ;
                case 3 -> f = true;
                default -> throw new IllegalStateException("Unexpected value: " + s);
            }
        } while(!f);
    }

    //Registrar Nuevo Cliente
    public Usuario registrarNuevoCliente() {
        Usuario u = new Usuario();
        try
        {
            FileWriter escribir=new FileWriter("usercontraseña.txt",true);
            escribir.write(u.user);
            escribir.write(u.contraseña);
            escribir.write("\n");
            escribir.close();
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir");
        }
        return u;
    }

    //Inciar Sesion
    public boolean iniciarSesion() {
        boolean ingresado = false;
        return ingresado;
    }
}
