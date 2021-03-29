import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente c=new Cliente("adri","tierra","kromagg",1234567890,null,"adroius","adroius.email.tierra");
        System.out.println(c.toString());
        //Nave n=NaveBuilder.CrearNave();
        Sistema sistema = new Sistema();
        sistema.getSistema();
    }
}
