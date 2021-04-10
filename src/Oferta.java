/*import java.io.*;
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

    }
    public void getOferta () {

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


}
*/