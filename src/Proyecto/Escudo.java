package Proyecto;

//Clase Escudo hereda de Defensa
public class Escudo extends Defensa{
    private int energiaR; //Energia necesaria para el Escudo
    private int danioQueAb; //Danio que Absobe el Escudo

    //Constructor Escudo
    public Escudo(int energia) {
        this.energiaR = energiaRequerida(energia);
        this.danioQueAb= danioQueAbsorbe();
    }

    //Energía Requerida para el Escudo
    public int energiaRequerida(int energia){
        //Preguntar la Energía Requerida
        return energia;
    }

    //Danio que Absorbe el Escudo
    public int danioQueAbsorbe() {
        int energia = this.energiaR*10;
        System.out.println("La energia que conseguira repeler sera de "+ energia);
        return energia;
    }
    public int getDanioQueAbsorbe(){
        return this.danioQueAb;
    }

    @Override
    public String toString() {
        return "Escudo: Energia requerida = " + energiaR +
                "\nDaño Absorbido = " + danioQueAb;
    }

}
