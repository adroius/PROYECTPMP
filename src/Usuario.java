import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Clase Usuario
public class Usuario{
    Cliente usuario;
    String user;
    String contraseña;
    int licenciaEspecial; //Esto tiene que estar aquí?? No debería estar en Cliente??

    //Constructor Usuario
    public Usuario() {
        this.usuario = client();
        this.user = user();
        this.contraseña = contraseña();
    }

    //Introducir Usuario
    private String  user(){
        System.out.println("Introduzca usuario");
        Scanner sc = new Scanner(System.in);
        String  s = sc.next();
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
                ", Licencia Especial =" + licenciaEspecial +
                '}';
    }
    public void modificarInformacionUsuario(String id){
        boolean encontrado=false;
        try {
            do {
                BufferedReader br = new BufferedReader(new FileReader("usercontraseña.txt"));
                String linea = "";
                while ((linea = br.readLine()) != null) {
                    if (linea.equalsIgnoreCase(id)) {
                        encontrado=true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Error en los datos introducidos.");
                } else if (!encontrado){
                    break;
                }
            } while (!encontrado);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
