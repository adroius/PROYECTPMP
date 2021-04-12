/*import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Clase Administrador
public class Administrador extends Usuario {

    boolean isCorrecto = false;

    //Constructor Administrador
    public Administrador() {
        this.isCorrecto = ofertaComprobar();
    }

    private String obtenerNombreNave(String nOferta) throws IOException {
        List<String> fichero = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userOfertas.txt"));
        String nombre = "";
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(nOferta)) {
                while (!(fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial"))) {
                    i--;
                }
                i = fichero.size();
                nombre = br.readLine();
            }
        }
        return nombre;
    }

    private boolean ofertaComprobar(String nOferta, Oferta offer) throws IOException {
        boolean valido = false;
        switch (obtenerNombreNave(nOferta)) {
            case "Caza":
                if (offer.precio <= 1000) {
                    valido = true;
                }
                break;
            case "Carguero":
                if (offer.precio <= 500) {
                    valido = true;
                }
                break;
            case "Destructor":
                if (offer.precio <= 1500) {
                    valido = true;
                }
                break;
            case "Estacion Espacial":
                if (offer.precio <= 1000) {
                    valido = true;
                }
                break;
        }
        return valido;
    }

    public boolean ofertaValida(String nOferta, String nUser, Cliente User) throws IOException {
        Oferta offer = null;
        Sistema sistem = null;
        boolean visible = true;
        if (sistem.comprobarNOferta(nOferta)) {
            if (!ofertaComprobar(nOferta, offer)) {
                eliminarOferta(nOferta, offer);
                notificarVendedorConAdvertencia(nUser, User);
                visible = false;
            }
        }
        return visible;
    }

    private void notificarVendedorConAdvertencia(String nUser, Cliente User) {
        User.numeroIdentificacion = nUser;
        System.out.println("Su oferta no cumple los parametros establecidos");
        User.nAdvertencias += 1;
    }

    /*private void eliminarOferta(String nOferta, Oferta offer) throws IOException {
        offer.buscarOfertaEspecifica(nOferta);
        BufferedReader br = new BufferedReader(new FileReader("userOferta.txt"));
        String linea=br.readLine();
        while (!linea = ){

        }
    }
}*/