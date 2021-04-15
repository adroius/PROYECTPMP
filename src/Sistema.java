import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Clase Sistema
public class Sistema {
    private int intentospermitidos = 2; //Se permiten dos intentos para poner bien el usuario y la contraseña
    public static String usuarioEntrar = ""; //Guardar el Cliente que a entrado
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
            int elec = sc.nextInt();
            switch (elec) {
                //Registrar Nuevo Cliente
                case 1: {
                    registrarNuevoCliente();
                    f = false;
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
                //Salir del Sistema
                case 3: {
                    f = true;
                    break;
                }
                //Valor introducido incorrecto
                default:
                    throw new IllegalStateException("Unexpected value: " + elec);
            }
        } while (!f);
    }

    //Menu una vez has ingresado como Cliente
    public void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.println("¿Que es lo que quiere realizar?");
            System.out.println("1) Registrar nave");
            System.out.println("2) Crear Oferta");
            System.out.println("3) Ver ofertas");
            System.out.println("4) Realizar compra");
            System.out.println("5) Salir");
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
                    if (buscarSiUserIsKromagg(usuarioEntrar)) {
                        new Oferta().buscadorDeOfertasKromggSinLicencia();
                    } else {
                        new Oferta().buscadorDeOfertas();
                    }
                    break;
                }
                //Comprar una nave
                case 4: {
                    new Registro().ejecutarCompra();
                    break;
                }
                //Salir del Sistema
                case 5: {
                    salir = true;
                    break;
                }
                //Valor introducido incorrecto
                default: throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!salir);
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
                    i = i + 1;
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
                i = i + 1;
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
    public Usuario registrarNuevoCliente() {
        List<String> fichero = new ArrayList<>();
        Usuario u = new Usuario();
        try {
            BufferedReader br = new BufferedReader(new FileReader("usercontraseña.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                fichero.add(line);
            }
            String s = u.user + u.contrasena;
            fichero.add(s);
            FileWriter fw = new FileWriter("usercontraseña.txt");
            PrintWriter escritura = new PrintWriter(fw);
            for (int i = 0; i < fichero.size(); i++) {
                escritura.println(fichero.get(i));
            }
            escritura.close();
            u.usuario.escribirInfo(u.user, u.contrasena);
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
        return u;
    }

    //Inciar Sesion
    public boolean iniciarSesion() throws FileNotFoundException {
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

    //Menu de los Administradores
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
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }

    public boolean buscarSiUserIsKromagg(String user) throws IOException {
        boolean encontrado = false;
        BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            if (linea.contains(user)) {
                linea = br.readLine();
                if (linea.contains("Kromagg") || linea.contains("kromagg")) {
                    encontrado =Kromagg.licencia();
                    break;
                }
            }
        }
        if (encontrado) {
            return false;
        } else {
            return true;
        }
    }
}
