import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private int intentospermitidos = 2;
    String usuarioEntrar = "";

    //Constructor Sistema
    public Sistema() throws IOException {
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
    public void menu() throws IOException {
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
                case 2 -> {
                    crearOferta();
                    break;
                }
                case 4 -> {
                    f = true;
                    break;
                }
                default -> throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }

    public void crearOferta() throws IOException {
        String usuarioAmeter = usuarioEntrar;
        List<String> fichero = new ArrayList<>();
        List<String> naves = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("userNaves.txt"));
        String line;
        boolean encontrado = false;
        while ((line = br.readLine()) != null) {
            fichero.add(line);
        }
        int min = 0;
        int max = fichero.size() - 1;
        String tope = "*";
        if (max != 0 && pertenece(usuarioAmeter)) {
            while (!encontrado && max != 0) {
                if (usuarioAmeter.equals(fichero.get(min))) {
                    min = min + 1;
                    while (!(fichero.get(min).equals(tope))) {
                        naves.add(fichero.get(min));
                        min = min + 1;
                    }
                    encontrado = true;
                }
                min = min + 1;
                max = max - 1;
            }
        }
        System.out.println("Que nave desea poner en venta:");
        for (int i = 0; i < naves.size(); i++) {
            if (naves.get(i).contains("Caza") || naves.get(i).contains("Carguero") || naves.get(i).contains("Destructor") || naves.get(i).contains("Estacion Espacial"))
                System.out.println(naves.get(i));
            else if (naves.get(i).contains("Numero de Identificacion")) {
                System.out.println(naves.get(i));
            }
        }
        System.out.println("Introduzca la matricula de la nave que quiera poner en venta:");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        naves = cogerNave(naves, s);
        List<String> lecturaOfertas = new ArrayList<>();
        br = new BufferedReader(new FileReader("userOfertas.txt"));
        String lineas;
        while ((lineas = br.readLine()) != null) {
            lecturaOfertas.add(lineas);
        }
        for (int i = 0; i < naves.size(); i++) {
            lecturaOfertas.add(naves.get(i));
        }
        FileWriter fw = new FileWriter("userOfertas.txt");
        PrintWriter escritura = new PrintWriter(fw);
        escritura.println(usuarioEntrar);
        for (int i = 0; i < lecturaOfertas.size(); i++) {
            escritura.println(lecturaOfertas.get(i));
        }
        escritura.println("*");
        escritura.close();
    }

    public void insertarNave() throws FileNotFoundException {
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

    public List<String> cogerNave(List<String> naves, String matricula) {
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

    public boolean pertenece(String use) throws IOException {
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
            String s = u.user + u.contraseña;
            fichero.add(s);
            FileWriter fw = new FileWriter("usercontraseña.txt");
            PrintWriter escritura = new PrintWriter(fw);
            for (int i = 0; i < fichero.size(); i++) {
                escritura.println(fichero.get(i));
            }
            escritura.close();
            u.usuario.escribirInfo();
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
                                usuarioEntrar = use;
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
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!f);
    }
}
