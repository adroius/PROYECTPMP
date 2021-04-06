import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

//Clase Oferta
public class Oferta{
    String nIdentificacion; //Numero de identificacion de Oferta
    List<Oferta> Ofertas;


    //Constructor Oferta
    public Oferta (){
        this.Ofertas = Ofertas();

    }
    //comprobar oferta
    public boolean comprobarOferta() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
        System.out.println("Introduzca ID de la Oferta");
        int ofer = sc.nextInt();
        switch (ofer) {
            case "123":
                menuOfertas();
                encontrado = false;
                break;
            default:
                try {
                    do {
                        BufferedReader br = new BufferedReader(new FileReader("oferta.txt"));
                        String linea = "";
                        while ((linea = br.readLine()) != null) {
                            if (linea.equalsIgnoreCase(ofer)) {
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Error en los datos introducidos.");
                            encontrado = comprobarOferta();
                        }
                break;
        return encontrado;

    private void menuOfertas() {
        Scanner sc = new Scanner(System.in);
        boolean f = false;
        do {
            System.out.println("¿Que es lo que desea?");
            System.out.println("1) Editar Oferta");
            System.out.println("2) Editar informacion Ofertas");
            System.out.println("3) Salir");
            int s = sc.nextInt();
            switch (s) {
                case 1: {
                    System.out.println("¿Usuario a editar?");
                    String mod = sc.next();
                    Usuario.modificarInformacionUsuario(mod);
                    break;
                }
                //case 2 -> Buscador();
                case 3: {
                    f = true;
                    break;
                }
                default: throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }
}

    /*public void getOferta () {

    }

    public List<Nave> ofertaNave (int c ) {

    }

    public Date fechaLimite (int c) {


    }

    public int PrecioOfertaTotal (int c) {

    }

    public int ProteccionTotal (int c) {

    }

    public int crearVotacion (int c , int d) {

    }

    public String crearComentario (int c, int d) {

    }

*/
}
