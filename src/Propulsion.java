import java.util.Scanner;

public class Propulsion {
    String nombre="";
    int velocidad=0;

    public Propulsion() {
        this.nombre = nombre();
        this.velocidad= velSubLuminicaMax();
    }

    public String getNombre() {
        return nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String nombre(){
        String nombre="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Que propulsion quiere elegir:");
        System.out.println("0) Compresor de Traza");
        System.out.println("1) Motor FTL");
        System.out.println("2) Vela Solar");
        System.out.println("3) MotorCurvatura");
        System.out.println("4) Motor Ionico");
        int modelo = sc.nextInt();
        switch (modelo){
            case 0 : nombre ="Compresor de Traza";
                isCompresorTraza(nombre);
                break;
            case 1 : nombre ="Motor FTL";
                isMotorFTL(nombre);
                break;
            case 2 : nombre ="Vela Solar";
                isVelaSolar(nombre);
                break;
            case 3 : nombre ="Motor Curvatura";
                isMotorCurvatura(nombre);
                break;
            case 4 : nombre ="Motor Ionico";
                isMotorIonico(nombre);
                break;
        }
        System.out.println("¡Ha elegido " + nombre + "!");
        return nombre;
    }
    public int velSubLuminicaMax(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la velocidad maxima de la nave: ");
        int v = sc.nextInt();
        System.out.println("¡La velocidad maxima sera " + v + " km/seg!");
        return v;
    }
    private boolean isCompresorTraza(String s){
        return s=="Compresor de Traza";
    }
    private boolean isMotorFTL(String s){
        return s=="Motor FTL";
    }
    private boolean isVelaSolar(String s){
        return s=="Vela Solar";
    }
    private boolean isMotorCurvatura(String s){
        return s=="Motor Curvatura";
    }
    private boolean isMotorIonico(String s){
        return s=="Motor Ionico";
    }
}
