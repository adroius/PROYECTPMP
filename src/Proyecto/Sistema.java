package Proyecto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Sistema
public class Sistema {
    private int intentospermitidos = 2; //Se permiten dos intentos para poner bien el usuario y la contraseña
    public static String usuarioEntrar = "";
    public static String usuarioSolo = "";//Guardar el Cliente que a entrado
    boolean isKromagg = false;

    //Constructor Sistema
    public Sistema() throws IOException {
        boolean f = false;
        Scanner sc = new Scanner(System.in);
        //Registrarse como nuevo Cliente o Iniciar Sesion
        do {
            System.out.println("Bienvenido al Concesionario Espacial");
            System.out.println("1) Ingresar nuevo cliente");
            System.out.println("2) Iniciar Sesion");
            System.out.println("3) Salir");
            int s = sc.nextInt();
            switch (s) {
                //Registrar Nuevo Cliente
                case 1: {
                    registrarNuevoCliente();
                    f = false;
                    break;
                }
                //Inciar Sesion en el Sistema
                case 2: {
                    if (iniciarSesion()) {
                        if (comprobarAd()){
                            menu();
                        }
                    }
                    f = true;
                    break;
                }
                //Salir del Sistema
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

    public boolean comprobarAd() throws IOException {
        List<String> fi = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
        String line2 = "";
        int numeroAdvertencia = 0;
        while ((line2 = br.readLine()) != null) {
            fi.add(line2);
        }
        for (int i = 0; i < fi.size(); i++) {
            if (fi.get(i).contains(usuarioEntrar)) {
                numeroAdvertencia = Integer.parseInt(fi.get(i + 2));
                break;
            }
        }
        if (numeroAdvertencia >= 2){
            System.out.println("Ha excedido en el numero de advertencias.");
            Cliente.noEntrarAlSistemaPorAdvertencias();
            return false;
        } else{
            return true;
        }
    }

    //Menu una vez has ingresado como Cliente
    public void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean f = false;
        do {
            System.out.println("¿Que es lo que quiere realizar?");
            System.out.println("1) Registrar nave");
            System.out.println("2) Crear Oferta");
            System.out.println("3) Ver ofertas");
            System.out.println("4) Realizar compra");
            System.out.println("5) Ver notificaciones");
            System.out.println("6) Salir");
            int s = sc.nextInt();
            switch (s) {
                //Ingresar una nueva nave propiedad del Cliente
                case 1: {
                    insertarNave();
                    break;
                }
                //Crear una oferta con las naves que posee el Cliente
                case 2: {
                    crearOferta();
                    break;
                }
                //Ver las ofertas publicadas en la pagina web
                case 3: {
                    if (buscarSiUserIsKromagg(usuarioEntrar) && !Kromagg.licencia(Kromagg.licenciaMenu())) {
                        new Oferta().buscadorDeOfertasKromaggSinLicencia();
                    } else {
                        new Oferta().buscadorDeOfertas();
                    }
                    break;
                }
                //Salir del Sistema
                case 4: {
                    new Registro().ejecutarCompra();
                    break;
                }
                case 5: {
                    new Cliente();
                    Cliente.verNotificaciones(cogerUsuario(usuarioEntrar));
                    break;
                }
                case 6: {
                    f = true;
                    break;
                }
                //Valor introducido incorrecto
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }

    //Crear oferta con las naves que posee el Cliente
    public void crearOferta() throws IOException {
        new Oferta().construirOferta(usuarioEntrar);
    }

    public void insertarNave() {
        List<String> fichero = new ArrayList<>();
        boolean encontrado = false;
        String usuarioAmeter = usuarioEntrar;
        try {
            BufferedReader br = new BufferedReader(new FileReader("userNaves.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                fichero.add(line);
            }
            Nave n = NaveBuilder.CrearNave();
            int min = 0;
            int max = fichero.size() - 1;
            if (max != 0 && pertenece(usuarioAmeter)) {
                while (!encontrado && max != 0) {
                    if (usuarioAmeter.equals(fichero.get(min))) {
                        fichero.add(min + 1, n.toString());
                        fichero.add(min + 2, "-");
                        encontrado = true;
                    }
                    min = min + 1;
                    max = max - 1;
                }
            } else {
                fichero.add(usuarioAmeter);
                fichero.add(n.toString());
                fichero.add("-");
                fichero.add("*");
            }
            FileWriter fw = new FileWriter("userNaves.txt");
            PrintWriter escritura = new PrintWriter(fw);
            for (int i = 0; i < fichero.size(); i++) {
                escritura.println(fichero.get(i));
            }
            escritura.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static List<String> cogerNave(List<String> naves, String matricula) {
        List<String> devolucion = new ArrayList<>();
        int i = 0;
        boolean encontrado = false;
        while (!encontrado) {
            if (naves.get(i).contains("Caza") || naves.get(i).contains("Carguero") || naves.get(i).contains("Destructor") || naves.get(i).contains("Estacion Espacial")) {
                while (!(naves.get(i).equals("-"))) {
                    devolucion.add(naves.get(i));
                    i++;
                }
                int last = devolucion.size();
                String r = devolucion.get(last - 1);
                String resultado = "Numero de Identificacion = " + matricula;
                if (!(r.equals(resultado))) {
                    encontrado = false;
                    devolucion.clear();
                } else {
                    encontrado = true;
                }
            } else {
                i++;
            }
        }
        return devolucion;
    }

    public static boolean pertenece(String use) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("userNaves.txt"));
        String linea = "";
        boolean encontrado = false;
        while ((linea = br.readLine()) != null) {
            if (linea.equalsIgnoreCase(use)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    //Registrar Nuevo Cliente
    public Usuario registrarNuevoCliente() throws IOException {
        List<String> ficheroContraseña = new ArrayList<>();
        List<String> ficheroInfo = new ArrayList<>();
        List<String> ficheroInfoAux = new ArrayList<>();
        Usuario u = new Usuario();
        try {
            BufferedReader br = new BufferedReader(new FileReader("usercontraseña.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                ficheroContraseña.add(line);
            }
            br = new BufferedReader(new FileReader("usuarioInfo.txt"));
            while ((line = br.readLine()) != null) {
                ficheroInfo.add(line);
            }
            String s = u.user + u.contrasena;
            ficheroContraseña.add(s);
            FileWriter fw = new FileWriter("usercontraseña.txt");
            PrintWriter escritura = new PrintWriter(fw);
            for (int i = 0; i < ficheroContraseña.size(); i++) {
                escritura.println(ficheroContraseña.get(i));
            }
            escritura.close();
            fw = new FileWriter("usuarioInfo.txt");
            escritura = new PrintWriter(fw);
            for (int i = 0; i < ficheroInfo.size(); i++) {
                escritura.println(ficheroInfo.get(i));
            }
            escritura.write(u.usuario.numeroIdentificacion);
            escritura.write("\n");
            escritura.write(s);
            escritura.write("\n");
            escritura.write(u.usuario.Nombre);
            escritura.write("-");
            escritura.write(u.usuario.PlanetaOrigen);
            escritura.write("-");
            escritura.write(u.usuario.Especie);
            escritura.write("-");
            escritura.write("No tiene licencia especial");
            escritura.write("-");
            escritura.write(u.usuario.Nick);
            escritura.write("-");
            escritura.write(u.usuario.email);
            escritura.write("\n");
            escritura.println(u.usuario.nAdvertencias);
            escritura.println("*");
            escritura.close();
            String linea;
            BufferedReader br2 = new BufferedReader(new FileReader("usuarioInfo.txt"));
            while ((linea = br2.readLine()) != null) {
                ficheroInfoAux.add(linea);
            }
            if (buscarSiUserIsKromagg(s)){
                int i=1;
                for(int j=0;j<=ficheroInfoAux.size();j++) {
                    if (ficheroInfoAux.get(j).contains(s)) {
                        if (ficheroInfoAux.get(j+1).contains("Kromagg") || ficheroInfoAux.get(j+1).contains("kromagg")) {
                            String[] palabras = ficheroInfoAux.get(j+1).split("-");
                            palabras[3]=Nave.numaleatorios();
                            String aux=(palabras[0]+"-"+palabras[1]+"-"+palabras[2]+"-"+palabras[3]+"-"+palabras[4]+"-"+palabras[5]);
                            ficheroInfoAux.set(i, aux);
                            break;
                        }
                    }
                    i++;
                }
            }
            FileWriter fw2 = new FileWriter("usuarioInfo.txt");
            PrintWriter escritura2 = new PrintWriter(fw2);
            for (int i = 0; i < ficheroInfoAux.size(); i++) {
                escritura2.println(ficheroInfoAux.get(i));
            }
            escritura2.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
        return u;
    }

    public static String cogerUsuario(String usuario) throws IOException {
        String infouser="";
        String usuarioSoloEso = "";
        String user="";
        BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            if (linea.contains(usuario)) {
                linea = br.readLine();
                usuarioSoloEso=linea;
            }
        }
        String[] arrSplit_2 = usuarioSoloEso.split("-");
        user=arrSplit_2[0];
        return user;
    }

    //Inciar Sesion
    public boolean iniciarSesion() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
        System.out.println("Introduzca usuario");
        String user = sc.next();
        System.out.println("Introduzca contraseña");
        user += sc.next();
        switch (user) {
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
                            if (linea.equalsIgnoreCase(user)) {
                                encontrado = true;
                                usuarioEntrar = user; //Guardar el Cliente que esta utilizando el Sistema
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

    //Menu de Administrador (Editar Clientes y Ofertas)
    private void menuAdministrador() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean f = false;
        do {
            System.out.println("¿Que es lo que quiere realizar?");
            System.out.println("1) Editar informacion Cliente");
            System.out.println("2) Editar informacion Ofertas");
            System.out.println("3) Validar ofertas");
            System.out.println("4) Salir");
            int s = sc.nextInt();
            switch (s) {
                case 1: {
                    System.out.println("¿PUsuario a editar?");
                    String mod = sc.next();
                    Usuario.modificarInformacionUsuario(mod);
                    break;
                }
                case 2: {
                    System.out.println("¿Oferta a editar(numero de oferta)?");
                    String id = sc.next();
                    Oferta.modificarOferta(id);
                    break;
                }
                case 3: {
                    new Administrador();
                    break;
                }
                case 4: {
                    f = true;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }

    //Busca en fichero si el Cliente es de la especie Kromagg
    public boolean buscarSiUserIsKromagg(String user) throws IOException {
        boolean encontrado = false;
        BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            if (linea.contains(user)) {
                linea = br.readLine();
                if (linea.contains("Kromagg") || linea.contains("kromagg")) {
                    encontrado = true; //Comprobar si el Cliente tiene Licencia
                    break;
                } else {
                    encontrado = false;
                    break;
                }
            }
        }
        return encontrado;
    }


    public void getSistema() throws IOException {
        new Sistema();
    }
}
