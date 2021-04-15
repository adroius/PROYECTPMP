import java.util.Scanner;

//Clase Kromagg hereda de Cliente
public class Kromagg{
    boolean licencia; //LicenciaEspecial de los Kromagg

    public Kromagg() {
        this.licencia=licencia();
    }

    //Comprobar si tiene licencia
    //Esto no tiene ningun tipo de seguridad...
    protected static boolean licencia() {
        boolean l;
        Scanner sc = new Scanner(System.in);
        System.out.println("Tienes licencia?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int s = sc.nextInt();
        switch (s) {
            case 1: {
                l= true;
            }
            case 2: {
                l= false;
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
        
        return l;
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
