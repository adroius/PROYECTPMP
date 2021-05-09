package Proyecto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Clase Administrador
public class Administrador extends Usuario {

    public Administrador() throws IOException {
    }
//Comprobar que la oferta es valida
    //Valida -> Permite mostrarla a los clientes
    //Na valida -> Borra la oferta y se manda una advertencia al vendedor

    public static boolean ofertaValida() throws IOException {
        boolean visible = true;
        String user;
        boolean comprobar = ofertaComprobar();
        if (!comprobar) {
            user = eliminarOferta();
            notificarVendedorConAdvertencia(user);
            visible = false;
        }
        return visible;
    }

    //Comprobar si las ofertas son validas
    //Comprobar si las ofertas son validas
    private static boolean ofertaComprobar() throws IOException {
        boolean valido;
        BufferedReader br = new BufferedReader(new FileReader("userComprobar.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("userComprobar.txt"));
        Scanner sc = new Scanner(System.in);
        String line;
        String line2;
        String tipoNave = "";
        List<String> fichero = new ArrayList<>();
        while ((line = br.readLine()) != null && line != "-") {
            System.out.println(line);
            fichero.add(line);
            if (line.contains("Caza") || line.contains("Carguero") || line.contains("Destructor") || line.contains("Estacion Espacial")){
                tipoNave = line;
            }
        }
        System.out.println("¿La oferta es válida?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int respuesta = sc.nextInt();
        switch (respuesta) {
            case 1: {
                valido = true;
                BufferedReader br3 = new BufferedReader(new FileReader("userOfertas.txt"));
                while (br3.readLine() != null) ;
                if (br3.readLine() == null) {
                    FileWriter fw = new FileWriter("userOfertas.txt");
                    PrintWriter escritura = new PrintWriter(fw);
                    for (int i = 0; i < fichero.size(); i++) {
                        escritura.println(fichero.get(i));
                    }
                    escritura.close();
                }
                for(int i = 0; i < fichero.size(); i++) {
                    fichero.remove(i);
                }
                while ((line2 = br2.readLine()) != null && line2 != "-") {
                    FileWriter fw2 = new FileWriter("userComprobar.txt");
                    PrintWriter escritura2 = new PrintWriter(fw2);
                    for (int i = 0; i < fichero.size(); i++) {
                        escritura2.println(fichero.get(i));
                    }
                    escritura2.close();
                }
                mandarNotificaciones(tipoNave);
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

    private static String eliminarOferta() throws IOException {
        List<String> fichero = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userComprobar.txt"));

        String user = "";
        String line;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        for (int i = 0; i <= fichero.size(); i++) {
            if ((fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor")  || fichero.get(i).contains("Estacion Espacial"))) {
                i--;
                user = fichero.get(i);
                break;
            }
        }
        for (int i = 0; i <= fichero.size(); i++) {
            if ((fichero.get(i).contains("Caza") || fichero.get(i).contains("Carguero") || fichero.get(i).contains("Destructor") || fichero.get(i).contains("Estacion Espacial"))) {
                int k=i-1;
                while (!fichero.get(i).equals("-")) {
                    fichero.remove(i);
                }
                break;
            }
        }
        FileWriter fw2 = new FileWriter("userComprobar.txt");
        PrintWriter escritura2 = new PrintWriter(fw2);
        for (int i = 0; i < fichero.size(); i++) {
            escritura2.println(fichero.get(i));
        }
        escritura2.close();
        return user;
    }

    private static void notificarVendedorConAdvertencia(String nUser) throws IOException {
        List<String> f = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
        String line2 = "";
        int numeroAdvertencia = 0;
        while ((line2 = br.readLine()) != null) {
            f.add(line2);
        }
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i).contains(nUser)) {
                numeroAdvertencia = Integer.parseInt(f.get(i + 3));
                numeroAdvertencia++;
                f.set(i + 3, String.valueOf(numeroAdvertencia));
                break;
            }
        }
        FileWriter fw = new FileWriter("usuarioInfo.txt");
        PrintWriter escrit = new PrintWriter(fw);
        for (int i = 0; i < f.size(); i++) {
            escrit.println(f.get(i));
        }
        escrit.close();
        BufferedReader br2 = new BufferedReader(new FileReader("usernotificaciones.txt"));
        f.clear();
        String line3;
        while ((line3 = br2.readLine()) != null) {
            f.add(line3);
        }
        String line = "Su oferta no cumple los parametros establecidos";
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i).equals(nUser)) {
                f.add(i++, line);
            }
        }
        fw = new FileWriter("usernotificaciones.txt");
        escrit = new PrintWriter(fw);
        for (int i = 0; i < f.size(); i++) {
            escrit.println(f.get(i));
        }
        escrit.close();
        System.out.println("Llevas " + numeroAdvertencia + " advertencias.");
        Cliente.comprobarAdvertencias(String.valueOf(numeroAdvertencia));
    }
    public static void mandarNotificaciones(String tipoNave) throws IOException{
        String line;
        String line2;
        List<String> fichero = new ArrayList<>();
        BufferedReader br3 = new BufferedReader(new FileReader("usernotificaciones.txt"));
        while((line = br3.readLine()) != null){
            fichero.add(line);
        }


        BufferedReader br = new BufferedReader(new FileReader("suscriptoresOferta.txt"));
        while ( (line = br.readLine())  != null){
            if(line.equals(tipoNave)){

                while ((line = br.readLine())  != null && !line.equals("*")){
                    BufferedReader br2 = new BufferedReader(new FileReader("usernotificaciones.txt"));
                    while ( (line2 = br2.readLine())  != null){
                        for (int i=0 ; i< fichero.size(); i++){
                            if(line2.equals(fichero.get(i))){
                               fichero.add(i+1,"Nueva oferta de "+tipoNave);
                            }
                        }

                    }
                    br.readLine();
                }
            }


        }
        FileWriter fw = new FileWriter("usernotificaciones.txt");
        PrintWriter escrit = new PrintWriter(fw);
        for (int i = 0; i < fichero.size(); i++) {
            escrit.println(fichero.get(i));
        }
        escrit.close();
    }
}