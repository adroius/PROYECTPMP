import java.util.Scanner;

public class Kromagg extends Cliente {
    boolean licencia;

    private boolean licencia() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tienes licencia?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int s = sc.nextInt();
        switch (s) {
            case 1: {
                licencia = true;
                break;
            }
            case 2: {
                licencia = false;
                break;
            }
        }
        return licencia;
    }

    public Kromagg() {
        if (isKromagg()) {
            if (licencia()) {
                NaveBuilder.CrearNave();
            } else {
                NaveBuilder.CrearNaveEspecial();
            }
        }
    }
}
