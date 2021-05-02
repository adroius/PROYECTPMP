package Proyecto;

//Clase Propulsion
public class Propulsion {
    String nombre;
    int velocidad;  //Velocidad sublumínica  Miles de Km/h

    //Constructor Propulsion
    public Propulsion(int e) {
        this.nombre = nombre(e);
        this.velocidad = velSubLuminicaMax();
    }

    //Devuelve el nombre del Tipo de Propulsion
    public String getNombre() {
        return nombre;
    }

    //Devuelve la velocidad sublumínica de la Propulsion
    public int getVelocidad() {
        return velocidad;
    }

    //Escoger el tipo de Propulsion de la nave
    public String nombre(int e){
        String nombre;
        //Deberiamos hacer un bucle para comprobar que el valor introducido es correcto
        switch (e) {
            case 0: {
                nombre = "Compresor de Traza";
                break;
            }
            case 1: {
                nombre = "Motor FTL";
                break;
            }
            case 2: {
                nombre = "Vela Solar";
                break;
            }
            case 3: {
                nombre = "Motor Curvatura";
                break;
            }
            case 4: {
                nombre = "Motor Ionico";
                break;
            }
            //Valor introducido erroneo
            default: throw new IllegalStateException("Unexpected value: " + e);
        }
        return nombre;
    }

    //Introducir la velocidad sublumínica en Miles de Km / hora
    public int velSubLuminicaMax(){
        int numero = (int)(Math.random()*10000+1000);
        System.out.println("¡La velocidad maxima sera " +  numero + " miles de km/hora!");
        return numero;
    }

    @Override
    public String toString() {
        return " Nombre = " + getNombre() +
                "\nVelocidad = " + getVelocidad() ;
    }
}
