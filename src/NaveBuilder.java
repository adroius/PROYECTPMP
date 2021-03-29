import java.util.Scanner;

public class NaveBuilder extends Nave{

    public NaveBuilder() {

    }

    public Nave seleccionarTipoDeNave(){
        Nave n;
        System.out.println("Que nave desea construir:");
        System.out.println("1)Caza");
        System.out.println("2)Destructor");
        System.out.println("3)Carguero");
        System.out.println("4)Estacion espacial");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        switch (s){
            case 1:
                n=new Caza();
                break;
            case 2:
                n=new Destructor();
                break;
            case 3:
                n=new Carguero();
                break;
            case 4:
                n=new EstacionEspacial();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
        return n;
    }
}
