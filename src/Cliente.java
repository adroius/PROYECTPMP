import java.util.List;
import java.util.Scanner;

public class Cliente {
    protected String Nombre;
    protected String PlanetaOrigen;
    protected String Especie;
    protected String numeroIdentificacion;
    List<Nave> NavesEnPropiedad;
    private String Nick;
    private String email;
    boolean Kromagg;
    boolean isKromagg=false;
    boolean isPirata=false;
    boolean isFraude=false;

    //Builder Cliente
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
        this.Kromagg = isKromagg();
    }

    //Builder Cliente
    public void getCliente(String Nombre, String PlanetaOrigen, String Especie, String numeroIdentificacion, List<Nave> NavesEnPropiedad, String Nick, String email) {
        this.Nombre = Nombre;
        this.PlanetaOrigen = PlanetaOrigen;
        this.Especie = Especie;
        this.numeroIdentificacion = numeroIdentificacion;
        this.NavesEnPropiedad = NavesEnPropiedad;
        this.Nick = Nick;
        this.email = email;
        this.Kromagg = isKromagg();
    }

    //Comprobar si es de la especie Kromagg
    private boolean isKromagg() {
        boolean is = false;
        if (this.Especie == "Kromagg" || this.Especie == "kromagg") {
            is = true;
        }
        return is;
    }

    private boolean isPirata() {
        boolean is = false;
        if (this.Especie == "Kromagg" || this.Especie == "kromagg") {
            is = true;
        }
        return is;
    }

    private boolean isFraude() {
        boolean is = false;
        if (this.Especie == "Kromagg" || this.Especie == "kromagg") {
            is = true;
        }
        return is;
    }

    @Override
    public String toString() {
        return "Cliente: " + "\nNombre= " + Nombre + "\nPlanetaOrigen= " + PlanetaOrigen + "\nEspecie= " + Especie + "\nNumero Identificacion= " + numeroIdentificacion + "\nNaves En Propiedad=" + NavesEnPropiedad + "\nNick=" + Nick + "\nEmail='" + email + "\nKromagg=" + Kromagg;
    }
}
