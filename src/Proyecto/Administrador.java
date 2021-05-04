package Proyecto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Administrador
public class Administrador extends Usuario {

    //Comprobar que la oferta es valida
    //Valida -> Permite mostrarla a los clientes
    //Na valida -> Borra la oferta y se manda una advertencia al vendedor
    public boolean ofertaValida() throws IOException {
        boolean visible = true;
        String user = "";
        boolean comprobar = ofertaComprobar();
        if (!comprobar) {
            user = eliminarOferta();
            notificarVendedorConAdvertencia(user);
            visible = false;
        }
        return visible;
    }

    //Comprobar si las ofertas son validas
    private boolean ofertaComprobar() throws IOException {
        boolean valido;
        BufferedReader br = new BufferedReader(new FileReader("userComprobar.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("userComprobar.txt"));
        Scanner sc = new Scanner(System.in);
        String line;
        String line2;
        List<String> fichero = new ArrayList<>();
        while ((line = br.readLine()) != null && line != "-") {
            System.out.println(line);
            fichero.add(line);
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
                while ((line2 = br2.readLine()) != null && line2 != "-") {
                    FileWriter fw2 = new FileWriter("userComprobar.txt");
                    PrintWriter escritura2 = new PrintWriter(fw2);
                    for (int i = 0; i < fichero.size(); i++) {
                        escritura2.println("");
                    }
                    escritura2.close();
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

    private String eliminarOferta() throws IOException {
        List<String> fichero = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userComprobar.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("userComprobar.txt"));
        String user = "";
        String line;
        String line2;
        int i = 0;
        while ((line = br.readLine()) != null && line != "-") {
            fichero.add(line);
        }
        while ((line2 = br2.readLine()) != null && line2 != "-") {
            FileWriter fw2 = new FileWriter("userComprobar.txt");
            PrintWriter escritura2 = new PrintWriter(fw2);
            i++;
            if (i == 0 && !line2.equals("*")) {
                user = fichero.get(i);
            } else if (i == 0 && line2.equals("*")) {
                i++;
                if (i == 1) {
                    user = fichero.get(i);
                }
            }
//                escritura2.println("");
            escritura2.close();
        }
        return user;
    }

    private void notificarVendedorConAdvertencia(String nUser) throws IOException {
        List<String> f = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
        String line2 = "";
        while ((line2 = br.readLine()) != null) {
            f.add(line2);
        }
        for (int i = 0; i < f.size(); i++) {
            if (f.get(i).contains(nUser)) {
                f.set(i + 2, f.get(i + 2) + 1);
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
        Cliente.numeroAdvertencias(nUser);
    }


}