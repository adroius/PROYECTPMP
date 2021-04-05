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
    boolean isPirata;
    boolean isFraude;

    //Constructor Cliente
    public Cliente() {
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

    //Comprobar si es de la especie Kromagg
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
    //Hay que hacer este metodo cuando hagamos la base de datos
    private boolean isPirata() {
        boolean is = false;
        if (this.isPirata) {
            is = true;
            comprarNave();
        }
        return is;
    }

    //Comprobar si es Sospechoso de Fraude
    //Hay que hacer este metodo cuando hagamos la base de datos
    private boolean isFraude() {
        boolean is = false;
        if (this.isFraude) {
            noEntrarAlSistema();
            is = true;
        }
        return is;
    }

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
                n = new Carguero();
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

    @Override
    public String toString() {
        return "Cliente: " + "\nNombre= " + Nombre + "\nPlanetaOrigen= " + PlanetaOrigen + "\nEspecie= " + Especie + "\nNumero Identificacion= " + numeroIdentificacion + "\nNaves En Propiedad=" + NavesEnPropiedad + "\nNick=" + Nick + "\nEmail='" + email;
    }
}
