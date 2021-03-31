import java.util.Scanner;
import java.util.Random;

public class Usuario{
    Cliente usuario;
    String user;
    String contraseña;
    boolean isKromagg=false;
    boolean isPirata=false;
    boolean isFraude=false;
    int licenciaEspecial;

    public Usuario() {
        this.usuario = client();
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

    private Cliente client() {
        Cliente s = new Cliente();
        return s;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario=" + usuario +
                ", user='" + user + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", isKromagg=" + isKromagg +
                ", isPirata=" + isPirata +
                ", isFraude=" + isFraude +
                ", licenciaEspecial=" + licenciaEspecial +
                '}';
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
