package Proyecto;

//Clase Escudo hereda de Defensa
public class Escudo extends Defensa{
    int energiaR; //Energia necesaria para el Escudo
    int danioQueAb; //Danio que Absobe el Escudo

    //Constructor Escudo
    public Escudo(int e) {
        this.energiaR = energiaRequerida(e);
        this.danioQueAb= danioQueAbsorbe();
    }

    //Energía Requerida para el Escudo
    public int energiaRequerida(int e){
        //Preguntar la Energía Requerida
        return e;
    }

    //Danio que Absorbe el Escudo
    public int danioQueAbsorbe() {
        int e=this.energiaR*10;
        System.out.println("La energia que conseguira repeler sera de "+ e);
        return e;
    }

    @Override
    public String toString() {
        return "Escudo: Energia requerida= " + energiaR +
                "\nDaño Absorbido= " + danioQueAb;
    }

}
