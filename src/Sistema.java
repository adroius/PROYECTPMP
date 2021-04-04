import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private int intentospermitidos = 2;
    //Constructor Sistema
    public Sistema() throws FileNotFoundException {
        boolean f = false;
        Scanner sc = new Scanner(System.in);
        //Menu del sistema
        do {
            System.out.println("Bienvenido al concesionario espacial");
            System.out.println("1) Ingresar nuevo cliente");
            System.out.println("2) Iniciar Sesion");
            System.out.println("3) Salir");
            int s = sc.nextInt();
            switch (s) {
                case 1: {
                    registrarNuevoCliente();
                    f = true;
                    break;
                }
                case 2: {
                    if (iniciarSesion()) {
                        menu();
                    }
                    f = true;
                    break;
                }
                case 3:{
                    f = true;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
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
                //case 2 -> Buscador();
                case 3:{
                    f = true;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }

    //Registrar Nuevo Cliente
    public Usuario registrarNuevoCliente() {
        Usuario u = new Usuario();
        try {
            FileWriter escribir = new FileWriter("usercontraseña.txt", true);
            escribir.write(u.user);
            escribir.write(u.contraseña);
            u.usuario.escribirInfo();
            escribir.write("\n");
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
        return u;
    }

    //Inciar Sesion
    public boolean iniciarSesion() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
        System.out.println("Introduzca usuario");
        String use = sc.next();
        System.out.println("Introduzca contraseña");
        use += sc.next();
        try {
            do {
                intentospermitidos = intentospermitidos - 1;
                BufferedReader br = new BufferedReader(new FileReader("usercontraseña.txt"));
                String linea = "";
                while ((linea = br.readLine()) != null) {
                    if (linea.equalsIgnoreCase(use)) {
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado && intentospermitidos >= 0) {
                    System.out.println("Error en los datos introducidos.");
                     encontrado=iniciarSesion();
                } else if (!encontrado && intentospermitidos < 0){
                    break;
                }
            } while (intentospermitidos >= 0 || !encontrado);
        } catch (IOException e) {
            System.out.println("Error");
        }
        return encontrado;
    }
}
