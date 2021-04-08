import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private int intentospermitidos = 2;
    String usuarioEntrar="";

    //Constructor Sistema
    public Sistema() throws FileNotFoundException {
        boolean f = false;
        Scanner sc = new Scanner(System.in);
        //Menu del sistema
        do {
            System.out.println("Bienvenido al concesionario espacial");
            System.out.println("1) Ingresar nuevo cliente");
            System.out.println("2) Iniciar Sesion");
            System.out.println("3) Salir");
            int s = sc.nextInt();
            switch (s) {
                //Registrar Nuevo Cliente
                case 1: {
                    registrarNuevoCliente();
                    f = true;
                    break;
                }
                //Inciar Sesion en el Sistema
                case 2: {
                    if (iniciarSesion()) {
                        menu();
                    }
                    f = true;
                    break;
                }
                case 3: {
                    f = true;
                    break;
                }
                //Valor introducido incorrecto
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }

    //Menu
    public void menu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean f = false;
        do {
            System.out.println("¿Que es lo que quiere realizar?");
            System.out.println("1) Registrar nave");
            System.out.println("2) Crear Oferta");
            System.out.println("3) Ver ofertas");
            System.out.println("4) Salir");
            int s = sc.nextInt();
            switch (s) {
                case 1 -> {
                    insertarNave();
                    break;
                }
                //case 2 -> Buscador();
                case 4 -> {
                    f = true;
                    break;
                }
                default-> throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }

    public void insertarNave() throws FileNotFoundException{
        List<String> fichero=new ArrayList<>();
        boolean encontrado=false;
        String usuarioAmeter=usuarioEntrar;
        new File("userNaves.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader("userNaves.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                fichero.add(line);
            }
            int max = fichero.size();
            int min=0;
            if (fichero.size()!=0) {
                do{
                    if (usuarioAmeter.equals(fichero.get(min))) {
                        Nave n = NaveBuilder.CrearNave();
                        String s = n.toString();
                        fichero.add(min + 1, s);
                        encontrado = true;
                    } else {
                        min = min + 1;
                        max = max - 1;
                    }
                }
                while (!encontrado || max <= 0) ;
            }
            FileWriter fw = new FileWriter("userNaves.txt");
            PrintWriter escritura = new PrintWriter(fw);
            for(int i=0;i<fichero.size();i++){
                escritura.println(fichero.get(i));
            }
            escritura.close();
            try {
                FileWriter escribir = new FileWriter("userNaves.txt");
                Nave n= NaveBuilder.CrearNave();
                escribir.write(usuarioAmeter);
                escribir.write("\n");
                escribir.write(n.toString());
                escribir.write("\n");
                escribir.close();
            } catch (Exception e) {
                System.out.println("Error al escribir");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    
    //Registrar Nuevo Cliente
    public Usuario registrarNuevoCliente() {
        Usuario u = new Usuario();
        try {
            FileWriter escribir = new FileWriter("usercontraseña.txt");
            escribir.write(u.user);
            escribir.write(u.contraseña);
            escribir.write("\n");
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
        u.usuario.escribirInfo();
        return u;
    }

    //Inciar Sesion
    public boolean iniciarSesion() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
        System.out.println("Introduzca usuario");
        String use = sc.next();
        System.out.println("Introduzca contraseña");
        use += sc.next();
        switch (use) {
            case "dani1234":
            case "pauli1234":
            case "jani1234":
            case "hectori1234":
            case "adri1234":
                menuAdministrador();
                encontrado = false;
                break;
            default:
                try {
                    do {
                        intentospermitidos = intentospermitidos - 1;
                        BufferedReader br = new BufferedReader(new FileReader("usercontraseña.txt"));
                        String linea = "";
                        while ((linea = br.readLine()) != null) {
                            if (linea.equalsIgnoreCase(use)) {
                                encontrado = true;
                                usuarioEntrar=use;
                                break;
                            }
                        }
                        if (!encontrado && intentospermitidos >= 0) {
                            System.out.println("Error en los datos introducidos.");
                            encontrado = iniciarSesion();
                        } else if (!encontrado && intentospermitidos < 0) {
                            break;
                        }
                    } while (intentospermitidos >= 0 || !encontrado);
                } catch (IOException e) {
                    System.out.println("Error");
                }
                break;
        }
        return encontrado;
    }

    private void menuAdministrador() {
        Scanner sc = new Scanner(System.in);
        boolean f = false;
        do {
            System.out.println("¿Que es lo que quiere realizar?");
            System.out.println("1) Editar informacion Cliente");
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
