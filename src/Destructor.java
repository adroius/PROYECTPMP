import java.util.Scanner;

public class Destructor extends TipoDeNave{
        int tripulantesMax=0;
        int cargaMax=0;
        String defensa="";

        public Carguero(){
            this.tripulantesMax = tripulantes();
            this.cargaMax = carga();
            this.defensa= seleccionDefensa();
        }
        public int tripulantes(){
            System.out.println("¿?");
            Scanner sc = new Scanner(System.in);
            return  (int s = sc.nextInt());
        }
        public int carga(){
            System.out.println("carga");
            Scanner sc = new Scanner(System.in);
            return (int c = sc.nextInt());
        }
        public String seleccionDefensa(){
            defensa e = new defensa();
            return d.toString();
        }
}
