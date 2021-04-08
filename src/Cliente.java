import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Cliente {
    protected String Nombre;
    protected String PlanetaOrigen;
    protected String Especie;
    protected String numeroIdentificacion;
    List<Nave> NavesEnPropiedad;
    private String Nick;
    private String email;
    boolean isKromagg;
    boolean isPirata; //Sospechoso de Pirateria
    boolean isFraude; //Sospechoso de Fraude
    int nAdvertencias = 0;

    //Constructor Cliente
    public Cliente() {
        //Introducir la informacion del cliente
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cual es su nombre?");
        String s = sc.next();
        this.Nombre = s;
        System.out.println("¿Cual es su Planeta de Origen?");
        s = sc.next();
        this.PlanetaOrigen = s;
        System.out.println("¿Cual es su Especie?");
        s = sc.next();
        this.Especie = s;
        System.out.println("¿Cual es su numero de identificacion?");
        s = sc.next();
        this.numeroIdentificacion = s;
        this.NavesEnPropiedad = null;
        System.out.println("¿Cual es su Nick?");
        s = sc.next();
        this.Nick = s;
        System.out.println("¿Cual es su email?");
        s = sc.next();
        this.email = s;
        this.isKromagg = isKromagg();
        this.isPirata = isPirata();
        this.isFraude = isFraude();
    }


    //Hay que hacer este metodo
    public List<Nave> navesEnVenta(){
        return null;
    }

    //Crear una oferta de naves
    /*public Oferta crearOferta() throws FileNotFoundException {
        Registro oferta;
        oferta = new Registro();
        Sistema s = new Sistema();
        int numBid = s.numOferta(); //Hay que llamar a la clase Oferta, ¿no?
        return null;
    }*/

    //Suscribirse una oferta
    //No se supone que tiene que suscribirse para que le notifiquen todas las ofertas que se hagan con un tipo de nave??
    public boolean suscribirseAUnaOferta(int nOferta){
        boolean suscribirse = false;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        if(comprobarNOferta(nOferta)){
            System.out.println("¿Quieres suscribirte a esta oferta?");
            System.out.println("1) Si");
            System.out.println("2) No");
            int s = sc.nextInt();
            switch (s) {
                case 1: {
                    suscribirse = true;
                    exit = true;
                    break;
                }
                case 2: {
                    suscribirse = false;
                    exit = true;
                    break;
                }
                //Valor obtenido incorrecto
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
        } while (!exit);
        return suscribirse;
    }

    private boolean comprobarNOferta(int nOferta) {
        Scanner sc = new Scanner(System.in);
        nOferta = sc.nextInt();
        String idenOferta = String.valueOf(nOferta);
        boolean encontrado = false;
        try {
            do {
                BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
                String linea = "";
                while ((linea = br.readLine()) != null) {
                    if (linea.equalsIgnoreCase(idenOferta)) {
                        BufferedReader file = new BufferedReader(new FileReader("./Archivo.txt"));
                        String line;
                        String input = "";
                        while ((line = file.readLine()) != null) {
                            if (line.contains("Usuario_1"))
                                input += line.replaceAll("Activo", "NO Activo \r\n");
                            else
                                input += line + "\r\n";
                        }
                        FileOutputStream fileOut = new FileOutputStream("./Archivo.txt");
                        fileOut.write(input.getBytes());
                        fileOut.close();
                    }
                }
                if (!encontrado) {
                    System.out.println("Error en los datos introducidos.");
                    break;
                }
            } while (!encontrado);
        } catch (IOException e) {
            System.out.println("Error");
        }
        return encontrado;
    }


    public void escribirInfo(){
        try {
            FileWriter escribir = new FileWriter("usuarioInfo.txt");
            escribir.write(this.numeroIdentificacion);
            escribir.write("\n");
            escribir.write(this.Nombre);
            escribir.write("-");
            escribir.write(this.PlanetaOrigen);
            escribir.write("-");
            escribir.write(this.Especie);
            escribir.write("-");
            escribir.write(this.Nick);
            escribir.write("-");
            escribir.write(this.email);
            escribir.write("\n");
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    /*public Oferta modificarOferta(String nIdentificacion) {
        boolean encontrado = comprobarNIdentificacion();
        if (encontrado) {
            System.out.println("¿Que quieres modificar?");
            System.out.println("¿Que quieres modificar?");
            System.out.println("¿Que quieres modificar?");
            System.out.println("¿Que quieres modificar?");
        }
        return null;
    }*/


    //Contador del numero de advertencias dadas al cliente
    public int numeroAdvertencias(String nIdentificacion) {
        boolean encontrado = comprobarNIdentificacion();
        if (encontrado) {
            System.out.println("Llevas " + nAdvertencias + " advertencias");
        }
        return nAdvertencias;
    }


    private boolean comprobarNIdentificacion() {
        String nIdentificacion;
        Scanner sc = new Scanner(System.in);
        nIdentificacion = sc.next();
        boolean encontrado = false;
        try {
            do {
                BufferedReader br = new BufferedReader(new FileReader("usuarioInfo.txt"));
                String linea = "";
                while ((linea = br.readLine()) != null) {
                    if (linea.contains(nIdentificacion)) {
                        BufferedReader file = new BufferedReader(new FileReader("./Archivo.txt"));
                        String line;
                        String input = "";
                        while ((line = file.readLine()) != null) {
                            if (line.contains("Usuario_1"))
                                input += line.replaceAll("Activo", "NO Activo \r\n");
                            else
                                input += line + "\r\n";
                        }
                        FileOutputStream fileOut = new FileOutputStream("./Archivo.txt",true);
                        fileOut.write(input.getBytes());
                        fileOut.close();
                    }
                }
                if (!encontrado) {
                    System.out.println("Error en los datos introducidos.");
                    break;
                }
            } while (!encontrado);
        } catch (IOException e) {
            System.out.println("Error");
        }
        return encontrado;
    }

    //Comprobar si el cliente es de la especie Kromagg
    protected boolean isKromagg() {
        boolean is = false;
        if (this.Especie == "Kromagg" || this.Especie == "kromagg") {
            is = true;
            Kromagg p = new Kromagg();
            p.KromaggNave();
        }
        return is;
    }

    //Comprobar si es Sospechoso de Pirateria
    private boolean isPirata() {
        boolean is = false;
        if (this.isPirata) {
            is = true;
            comprarNave();
        }
        return is;
    }

    //Comprobar si es Sospechoso de Fraude
    private boolean isFraude() {
        boolean is = false;
        if (this.isFraude) {
            noEntrarAlSistemaFraude(); //Tiene que ir a una sin timer
            is = true;
        }
        return is;
    }

    //Comprar nave si eres sospechoso de Pirateria (Solo pueden comprar cargueros)
    private boolean comprarNave() {
        Nave n;
        boolean compra;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres comprar un carguero?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int s = sc.nextInt();
        switch (s) {
            case 1: {
                n = new Carguero(); //Constructor Carguero
                compra = true;
                break;
            }
            case 2: {
                compra = false;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
        return compra;
    }

    //Impide entrar al sistema si tienes 2 advertencias
    private boolean noEntrarAlSistema() {
        Timer timer = new Timer();
        int seconds = 432000;
        boolean bloqueoFinalizado = (seconds != 0);
        TimerTask bloqueo = new TimerTask() {
            @Override
            public void run() {
                System.out.println("No puedes entrar al sistema");
            }
        };
        while (bloqueoFinalizado) {
            seconds -= 1;
            timer.schedule(bloqueo, 0, 1000);

        }
        return bloqueoFinalizado;
    }

    //Impide entrar al sistema si eres sospechoso de Fraude
    //No terminado
    private boolean noEntrarAlSistemaFraude () {
        System.out.println("No puedes entrar al sistema");
        return true;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "\nNombre= " + Nombre +
                "\nPlanetaOrigen= " + PlanetaOrigen +
                "\nEspecie= " + Especie +
                "\nNumero Identificacion= " + numeroIdentificacion +
                "\nNick=" + Nick +
                "\nEmail='" + email +
                "\nNaves En Propiedad=" + NavesEnPropiedad;
    }
}
