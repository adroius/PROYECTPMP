import java.util.List;

public class Cliente {
    String Nombre;
    String PlanetaOrigen;
    String Especie;
    int numeroIdentificacion;
    List<Nave> NavesEnPropiedad;
    String Nick;
    String email;
    boolean Kromagg;

    @Override
    public String toString() {
        return "Cliente: " + "\nNombre= " + Nombre + "\nPlanetaOrigen= " + PlanetaOrigen + "\nEspecie= " + Especie +"\nNumero Identificacion= " + numeroIdentificacion + "\nNaves En Propiedad=" + NavesEnPropiedad + "\nNick=" + Nick + "\nEmail='" + email + "\nKromagg=" + Kromagg ;
    }

    public Cliente (String Nombre, String PlanetaOrigen, String Especie, int numeroIdentificacion, List<Nave> NavesEnPropiedad, String Nick, String email){
        this.Nombre = Nombre;
        this.PlanetaOrigen = PlanetaOrigen;
        this.Especie = Especie;
        this.numeroIdentificacion = numeroIdentificacion;
        this.NavesEnPropiedad = NavesEnPropiedad;
        this.Nick = Nick;
        this.email = email;
        this.Kromagg = isKromagg();
    }
    public boolean isKromagg(){
        boolean is=false;
        if (this.Especie=="Kromagg" || this.Especie=="kromagg"){
            is=true;
        }
        return is;
    }
}
