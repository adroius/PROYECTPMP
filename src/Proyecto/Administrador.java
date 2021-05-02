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
        while ((line = br.readLine()) != "-") {
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
                while (br3.readLine() != null) {
                }
                if (br3.readLine() == null) {
                    while ((line = br2.readLine()) != "-") {
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
            eliminarOferta();
            notificarVendedorConAdvertencia(user);
            visible = false;
        }
        return visible;
    }

    private static void notificarVendedorConAdvertencia(String nUser) throws IOException {
        List<String> f = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
        String line2 = "";
        while ((line2 = br.readLine()) != null) {
            f.add(line2);
        }
        for (int i=0;i<=f.size();i++){
            if (f.get(i).contains(nUser)){
                f.set(i+2,f.get(i+2)+1);
            }
        }
        FileWriter fw = new FileWriter("usuarioInfo.txt");
        PrintWriter escrit = new PrintWriter(fw);
        for (int i=0;i<=f.size();i++){
            escrit.write(f.get(i));
        }
        escrit.close();
        BufferedReader br2 = new BufferedReader(new FileReader("usernotificaciones.txt"));
        f.clear();
        String line3;
        while ((line3 = br2.readLine()) != null) {
            f.add(line3);
        }
        String line = "Su oferta no cumple los parametros establecidos";
        for (int i=0;i<=f.size();i++){
            if (f.get(i).contains(nUser)){
                f.add(i+1,line);
            }
        }
        fw = new FileWriter("usernotificaciones.txt");
        escrit = new PrintWriter(fw);
        for (int i=0;i<=f.size();i++){
            escrit.write(f.get(i));
        }
        escrit.close();
    }

    private static void eliminarOferta(String numOferta) throws IOException {
        List<String> fichero = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userComprobar.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i < fichero.size(); i++) {
            if (fichero.get(i).contains(numOferta)) {
                while (!(fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial"))) {
                    i--;
                }
                while (!fichero.get(i).equals("-")) {
                    fichero.remove(i);
                }
                fichero.remove(i);
                i = fichero.size();
            }
        }
        FileWriter fw = new FileWriter("userComprobar.txt");
        PrintWriter escritura = new PrintWriter(fw);
        for (int i = 0; i < fichero.size(); i++) {
            escritura.println(fichero.get(i));
        }
        escritura.close();
    }
}