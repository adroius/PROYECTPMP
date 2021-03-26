import java.util.Scanner;

public class Main extends Caza{
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.getSistema();
        boolean finalizar = false;
        Scanner sc = new Scanner(System.in);
        do {
            Caza c = new Caza();
            System.out.println("¿Desea continuar?");
            System.out.println("1) SI");
            System.out.println("2) NO");
            int s = sc.nextInt();
            switch (s) {
                case 1:
                    finalizar = false;
                    break;
                case 2:
                    finalizar = true;
                    break;
            }
        } while (!finalizar);
    }
}
