import java.io.*;
import java.util.Scanner;

//Clase Usuario
public class Usuario {
    Cliente usuario;
    String user;
    String contraseña;

    //Constructor Usuario
    public Usuario() {
        this.usuario = client();
        this.user = user();
        this.contraseña = contraseña();
    }

    //Introducir Usuario
    private String user() {
        System.out.println("Introduzca usuario");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        return s;
    }

    //Introducir contraseña
    private String contraseña() {
        System.out.println("Introduzca contraseña");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        return s;
    }

    //Crear nuevo Cliente
    private Cliente client() {
        Cliente s = new Cliente();
        return s;
    }

    @Override
    public String toString() {
        return "Usuario {" + usuario +
                ", User ='" + user + '\'' +
                ", Contraseña ='" + contraseña + '\'' +
                '}';
    }

    public static void modificarInformacionUsuario(String id) {
        boolean encontrado = false;
        try {
            do {
                BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
                String line;
                String input = "";
                while ((line = br.readLine()) != null) {
                    if (line.contains(id)) {
                        String ls = br.readLine();
                        System.out.println(ls);
                        Scanner sc = new Scanner(System.in);
                        System.out.println("¿Cual es su nombre?");
                        String s = sc.next();
                        System.out.println("¿Cual es su Planeta de Origen?");
                        s += sc.next();
                        System.out.println("¿Cual es su Especie?");
                        s += sc.next();
                        System.out.println("¿Cual es su numero de identificacion?");
                        s += sc.next();
                        System.out.println("¿Cual es su Nick?");
                        s += sc.next();
                        System.out.println("¿Cual es su email?");
                        s += sc.next();
                        System.out.println(sc);
                        System.out.println(s);
                        input = line.replaceAll(id, s);
                        break;
                    } else
                        input = line + "Error";
                    break;
                }
                FileOutputStream fileOut = new FileOutputStream("usuarioInfo.txt");
                fileOut.write(input.getBytes());
                fileOut.close();
                if (!encontrado) {
                    System.out.println("Error en los datos introducidos.");
                    break;
                }
            } while (!encontrado);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
