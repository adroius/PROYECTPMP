import java.io.FileWriter;
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
        System.out.println("Introduzca usuario en numeros");
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

}
