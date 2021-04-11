import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Usuario
public class Usuario {
    Cliente usuario;
    String user;
    String contraseña;

    //Constructor Usuario
    public Usuario() {
        this.usuario = client();
        this.user = user();
        this.contraseña = contraseña();
    }

    //Introducir Usuario
    private String user() {
        System.out.println("Introduzca usuario");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        return s;
    }

    //Introducir contraseña
    private String contraseña() {
        System.out.println("Introduzca contraseña");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        return s;
    }

    //Crear nuevo Cliente
    private Cliente client() {
        Cliente s = new Cliente();
        return s;
    }

    @Override
    public String toString() {
        return "Usuario {" + usuario +
                "User ='" + user + '\'' +
                "Contraseña ='" + contraseña + '\'' +
                '}';
    }

    //Modificar Informacion del Usuario
    public static void modificarInformacionUsuario(String id) {
        boolean encontrado = false;
        List<String> fichero=new ArrayList<>();
        try {
                BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
                String line;
                while ((line = br.readLine()) != null) {
                    fichero.add(line);
                }
                int max = fichero.size()-1;
                int min=0;
                do{
                    if (id.equals(fichero.get(min))){
                        System.out.println(fichero.get(min+1));
                        Scanner sc = new Scanner(System.in);
                        System.out.println("¿Cual es su nombre?");
                        String s = sc.next();
                        s += ("-");
                        System.out.println("¿Cual es su Planeta de Origen?");
                        s += sc.next();
                        s += ("-");
                        System.out.println("¿Cual es su Especie?");
                        s += sc.next();
                        s += ("-");
                        System.out.println("¿Cual es su Nick?");
                        s += sc.next();
                        s += ("-");
                        System.out.println("¿Cual es su email?");
                        s += sc.next();
                        fichero.set(min+1,s);
                        encontrado=true;
                    } else {
                        min = min + 1;
                        max = max - 1;
                    }
                } while(!encontrado || max<=0);
            FileWriter fw = new FileWriter("usuarioInfo.txt");
            PrintWriter escritura = new PrintWriter(fw);
            for(int i=0;i<fichero.size();i++){
                escritura.println(fichero.get(i));
            }
            escritura.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
