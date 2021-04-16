package Proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Clase Proyecto.Administrador
public class Administrador extends Usuario {
    boolean isCorrecto = false;


    private static String obtenerNombreNave(String nOferta) throws IOException {
        List<String> fichero = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String nombre = "";
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(nOferta)) {
                while (!(fichero.get(i).contains("Proyecto.Caza") || fichero.get(i).contains("Proyecto.Carguero") || fichero.get(i).contains("Proyecto.Destructor") || fichero.get(i).contains("Estacion Espacial"))) {
                    i--;
                }
                i = fichero.size();
                nombre = br.readLine();
            }
        }
        return nombre;
    }

    //Comprobar si el precio de las ofertas es valido
    /*
    Proyecto.Caza <= 1000
    Proyecto.Carguero <=500
    Proyecto.Destructor <= 1500
    Estacion Espacial <= 2000
     */
    private static boolean ofertaComprobar(String nOferta, int precio, String nave) throws IOException {
        boolean valido = false;
        switch (nave) {
            case "Proyecto.Caza":
                if (precio <= 1000) {
                    valido = true;
                }
                break;
            case "Proyecto.Carguero":
                if (precio <= 500) {
                    valido = true;
                }
                break;
            case "Proyecto.Destructor":
                if (precio <= 1500) {
                    valido = true;
                }
                break;
            case "Estacion Espacial":
                if (precio <= 2000) {
                    valido = true;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + nave + nOferta);
        }
        return valido;
    }

    //Comprobar que la oferta es valida
    //Valida -> Permite mostrarla a los clientes
    //Na valida -> Borra la oferta y se manda una advertencia al vendedor
    public static boolean ofertaValida(String nOferta, String nUser, int precio, String nave) throws IOException {
        boolean visible = true;
            if (!ofertaComprobar(nOferta, precio,nave)) {
                eliminarOferta(nOferta);
                //notificarVendedorConAdvertencia(nUser);
                visible = false;
            }
        return visible;
    }

    /*private static void notificarVendedorConAdvertencia(String nUser) {
        Proyecto.Cliente c = null;
        c.numeroIdentificacion = nUser;
        System.out.println("Su oferta no cumple los parametros establecidos");
        c.nAdvertencias += 1;
        c.numeroAdvertencias(nUser);
    }*/
    
    private static void eliminarOferta(String nOferta) throws IOException {
        Oferta.borrarOferta(nOferta);
    }
}