import java.util.Scanner;

public class Propulsion {
    public String nombre(){
        String nombre="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Que arma quiere elegir:");
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
                break;
            case 2 : nombre ="Vela Solar";
                break;
            case 3 : nombre ="MotorCurvatura";
                break;
            case 4 : nombre ="Motor Ionico";
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
    public boolean isCompresorTraza(String s){
        return s=="Compresor de Traza";
    }
    public boolean isMotorFTL(String s){
        return s=="Motor FTL";
    }
    public boolean isVelaSolar(String s){
        return s=="Vela Solar";
    }
    public boolean isMotorCurvatura(String s){
        return s=="Curvatura";
    }
    public boolean isMotorIonico(String s){
        return s=="Motor Ionico";
    }
}
