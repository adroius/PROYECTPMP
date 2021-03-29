import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Nave n=NaveBuilder.CrearNave();
        System.out.println(n.toString());
        Sistema sistema = new Sistema();
        sistema.getSistema();
    }
}
