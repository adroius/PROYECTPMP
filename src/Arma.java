import java.util.Scanner;
//Clase Arma
public class Arma {
    String nombre="";
    int potencia=0;
    //Builder Arma
    public Arma() {
        this.nombre = nombre();
        this.potencia= potencia();
    }

    @Override

    public String toString() {
        return "Nombre= " + nombre + ", Potencia = " + potencia;
    }
    public String getNombre() {
        return nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public String nombre(){
        String nombre="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Que arma quiere elegir:");
        System.out.println("0) PEM");
        System.out.println("1) Misil Termonuclear");
        System.out.println("2) Rayo Laser");
        System.out.println("3) Cañon de plasma");
        int modelo = sc.nextInt();
        switch (modelo){
            case 0 : nombre ="PEM";
                isPEM(nombre);
                break;
            case 1 : nombre ="Misil Termonuclear";
                isMisilTermonuclear(nombre);
                break;
            case 2 : nombre ="Rayo Laser";
                isRayoLaser(nombre);
                break;
            case 3 : nombre ="Cañon de plasma";
                isCañonPlasma(nombre);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + modelo);
        }
        System.out.println("¡Ha elegido " + nombre + "!");
        return nombre;
    }
    public int potencia(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la potencia del arma: ");
        int v = sc.nextInt();
        System.out.println("¡La potencia de su "+ this.nombre+" será " + v + " !");
        return v;
    }
    private boolean isPEM(String s){
        return s=="PEM";
    }
    private boolean isMisilTermonuclear(String s){
        return s=="Misil Termonuclear";
    }
    private boolean isRayoLaser(String s){
        return s=="Rayo Laser";
    }
    private boolean isCañonPlasma(String s){
        return s=="Cañon de plasma";
    }
}
