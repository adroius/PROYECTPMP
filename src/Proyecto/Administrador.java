package Proyecto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Proyecto.Administrador
public class Administrador extends Usuario {
    boolean isCorrecto = false;


    public Administrador() throws IOException {
        this.ofertaValida();
    }

    //Comprobar si el precio de las ofertas es valido
    /*
    Caza <= 1000
    Carguero <=500
    Destructor <= 1500
    Estacion Espacial <= 2000
     */
    private static boolean ofertaComprobar() throws IOException {
        boolean valido;
        BufferedReader br = new BufferedReader(new FileReader("userComprobar.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("userComprobar.txt"));
        Scanner sc = new Scanner(System.in);
        String line;
        List<String> fichero = new ArrayList<>();
        while ((line = br.readLine()) != "-"){
            System.out.println(line);
        }
        System.out.println("¿La oferta es válida?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int respuesta = sc.nextInt();
        switch (respuesta) {
            case 1: {
                valido = true;
                BufferedReader br3 = new BufferedReader(new FileReader("userOferta.txt"));
                while (br3.readLine() != null){
                }
                if (br3.readLine() == null){
                    while ((line = br2.readLine()) != "-"){
                        fichero.remove(line);
                    }
                    FileWriter fw = new FileWriter("userOfertas.txt");
                    PrintWriter escritura = new PrintWriter(fw);
                    for (int i = 0; i < fichero.size(); i++) {
                        escritura.println(fichero.get(i));
                    }
                    escritura.close();
                }
                break;
            }
            case 2: {
                valido = false;
                break;
            }
            default:
                throw new IllegalStateException("Valor no valido: ");
        }
        return valido;
    }

    //Comprobar que la oferta es valida
    //Valida -> Permite mostrarla a los clientes
    //Na valida -> Borra la oferta y se manda una advertencia al vendedor
    public static boolean ofertaValida() throws IOException {
        boolean visible = true;
        String user = "";
            if (!ofertaComprobar()) {
                user = eliminarOferta();
                notificarVendedorConAdvertencia(user);
                visible = false;
            }
        return visible;
    }

    private static void notificarVendedorConAdvertencia(String nUser) {
        Cliente c = null;
        c.numeroIdentificacion = nUser;
        System.out.println("Su oferta no cumple los parametros establecidos");
        c.nAdvertencias += 1;
        c.numeroAdvertencias(nUser);
    }
    
    private static String eliminarOferta() throws IOException {
        List<String> fichero2 = new ArrayList<>();
        BufferedReader br2 = new BufferedReader(new FileReader("userComprobar.txt"));
        int i = 0;
        String user = "";
        String line;
        while ((line = br2.readLine()) != "-") {
            if (!line.equals("*")){
                i++;
                if (i == 1){
                    user = line;
                }
            }
            fichero2.remove(line);
        }
        return user;
    }
}