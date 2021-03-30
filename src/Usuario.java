import java.util.Scanner;
import java.util.Random;

public class Usuario {
    Cliente usuario;
    String user;
    String contraseña;
    boolean isKromagg=usuario.Kromagg;
    int licenciaEspecial;

    public Usuario() {
        this.usuario = new Cliente();
        this.user = user();
        this.contraseña = contraseña();
    }

    private String user() {
        System.out.println("Introduzca usuario");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        return s;
    }

    private String contraseña() {
        System.out.println("Introduzca contraseña");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        return s;
    }
    private void ifIsKromagg(){
        if (this.isKromagg){
            System.out.println("Necesitara una licencia especial según un decreto de la Federación Intergaláctica");
            Random number = new Random();
            int valorObtenido = number.nextInt(100000);
            this.licenciaEspecial=valorObtenido;
        }
    }
}
