package Proyecto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Usuario
public class Usuario {
    Cliente usuario;
    String user;
    String contrasena;

    //Constructor Usuario
    public Usuario() {
        this.usuario = client();
        this.user = user();
        this.contrasena = contrasena();
    }

    //Introducir Usuario
    private String user() {
        System.out.println("Introduzca usuario");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public String getUser(){
        return this.user;
    }

    //Introducir contraseña
    private String contrasena() {
        System.out.println("Introduzca contraseña");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    //Crear nuevo Cliente
    private Cliente client() {
        return new Cliente();
    }

    //Modificar Informacion del Usuario
    public static void modificarInformacionUsuario(String id) {
        boolean encontrado = false;
        List<String> fichero = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                fichero.add(line);
            }
            int max = fichero.size() - 1;
            int min = 0;
            //Guardar la informacion del Cliente modificada
            do {
                if (id.equals(fichero.get(min))) {
                    String[] palabras = fichero.get(min + 2).split("-");
                    System.out.println(fichero.get(min + 2));
                    Scanner sc = new Scanner(System.in);
                    System.out.println("¿Cual es su nombre?");
                    palabras[0] = sc.next();
                    System.out.println("¿Cual es su Planeta de Origen?");
                    palabras[1] = sc.next();
                    System.out.println("¿Cual es su Especie?");
                    palabras[2] = sc.next();
                    System.out.println("¿Cual es su Nick?");
                    palabras[4] = sc.next();
                    System.out.println("¿Cual es su email?");
                    palabras[5] = sc.next();
                    String aux = (palabras[0] + "-" + palabras[1] + "-" + palabras[2] + "-" + palabras[3] + "-" + palabras[4] + "-" + palabras[5]);
                    fichero.set(min + 2, aux);
                    System.out.println(aux);
                    encontrado = true;
                } else {
                    min = min + 1;
                    max = max - 1;
                }
            } while (!encontrado || max <= 0);
            FileWriter fw = new FileWriter("usuarioInfo.txt");
            PrintWriter escritura = new PrintWriter(fw);
            for (int i = 0; i < fichero.size(); i++) {
                escritura.println(fichero.get(i));
            }
            escritura.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @Override
    public String toString() {
        return "   Usuario:" + usuario +
                "\nUser = " + user +
                "\nContraseña = " + contrasena;
    }
}
