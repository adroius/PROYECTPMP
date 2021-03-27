import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.getSistema();
        boolean finalizar;
        Scanner sc = new Scanner(System.in);
        Caza c=new Caza();
        Caza d=new Caza();

        do {
            System.out.println("¿Desea continuar?");
            System.out.println("1) SI");
            System.out.println("2) NO");
            int s = sc.nextInt();
            switch (s) {
                case 1 -> finalizar = false;
                case 2 -> finalizar = true;
                default -> throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!finalizar);
    }
}
