import java.util.Scanner;

//Clase Propulsion
public class Propulsion {
    String nombre;
    int velocidad;  //Velocidad sublumínica  Miles de Km/h

    //Constructor Propulsion
    public Propulsion() {
        this.nombre = nombre();
        this.velocidad = velSubLuminicaMax();
    }

    public String getNombre() {

        return nombre;
    }

    public int getVelocidad() {

        return velocidad;
    }

    @Override
    public String toString() {
        return " Nombre = " + nombre +
                " Velocidad = " + velocidad ;
    }

    //Escoger el tipo de Propulsion de la nave
    public String nombre(){
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.println("Que propulsion quiere elegir:");
        System.out.println("0) Compresor de Traza");
        System.out.println("1) Motor FTL");
        System.out.println("2) Vela Solar");
        System.out.println("3) MotorCurvatura");
        System.out.println("4) Motor Ionico");
        int modelo = sc.nextInt();

        //Deberiamos hacer un bucle para comprobar que el valor introducido es correcto
        switch (modelo) {
            case 0 -> {
                nombre = "Compresor de Traza";
            }
            case 1 -> {
                nombre = "Motor FTL";
            }
            case 2 -> {
                nombre = "Vela Solar";
            }
            case 3 -> {
                nombre = "Motor Curvatura";
            }
            case 4 -> {
                nombre = "Motor Ionico";
            }
            //Valor introducido erroneo
            default -> throw new IllegalStateException("Unexpected value: " + modelo);
        }
        System.out.println("¡Ha elegido " + nombre + "!");
        return nombre;
    }

    //Introducir la velocidad sublumínica en Miles de Km / hora
    public int velSubLuminicaMax(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la velocidad sublumínica maxima de la nave: ");
        int v = sc.nextInt();
        System.out.println("¡La velocidad maxima sera " + v + " miles de km/hora!");
        return v;
    }
}
