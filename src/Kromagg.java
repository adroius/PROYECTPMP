import java.util.Scanner;

//Clase Kromagg hereda de Cliente
public class Kromagg extends Cliente {
    boolean licencia; //LicenciaEspecial de los Kromagg

    public Kromagg() {
        KromaggNave();
        this.licencia = licencia();
    }

    //Comprobar si tiene licencia
    //Esto no tiene ningun tipo de seguridad...
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

    //Crear nave para Kromagg
    public NaveBuilder KromaggNave() {
        NaveBuilder n = null;
        boolean license = licencia();
        if (license) {
            n.CrearNave(); //Con Licencia puede comprar cualquier nave
        } else {
            n.CrearNaveEspecial(); //Sin Licencia solo pueden comprar Cargueros y Cazas
        }
        return n;
    }
}
