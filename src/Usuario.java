import java.io.IOException;
import java.util.Scanner;


public class Usuario{
    Cliente usuario;
    int user;
    String contraseña;
    int licenciaEspecial;

    public Usuario() {
        this.usuario = client();
        this.user = user();
        this.contraseña = contraseña();
    }

    private int user(){
        System.out.println("Introduzca usuario en numeros");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        return s;
    }

    private String contraseña() {
        System.out.println("Introduzca contraseña");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        return s;
    }

    private Cliente client() {
        Cliente s = new Cliente();
        return s;
    }

    @Override
    public String toString() {
        return "Usuario{" + usuario +
                ", user='" + user + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", licenciaEspecial=" + licenciaEspecial +
                '}';
    }

}
