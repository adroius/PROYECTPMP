package Proyecto;

//Clase Blindaje hereda de Defensa
public class Blindaje extends Defensa {
    private String material; //Material del Blindaje
    private int danioAbsorbe; //Danio que Absorbe el Blindaje
    private int peso; //Peso del Blindaje

    //Constructor Blindaje
    public Blindaje(int material) {
        super();
        this.material = materialEscogido(material);
        this.danioAbsorbe = danioQueAbsorbe();
        this.peso = danioQueAbsorbe() * 10; //El peso es igual al daño que Absorbe * 10
    }

    //Obtener el danio que absorbe el Blindaje a partir del material del Blindaje
    @Override
    public int danioQueAbsorbe() {
        int dqa;
        //Dependiendo del material del Blindaje absorbera una cantidad de danio
        switch (material) {
            case "Adamantium": {
                dqa = 1832732;
                break;
            }
            case "Hierro": {
                dqa = 329473;
                break;
            }
            case "Plata": {
                dqa = 7324823;
                break;
            }
            case "Platino": {
                dqa = 321091;
                break;
            }
            case "Oro": {
                dqa = 4398453;
                break;
            }
            case "Diamante": {
                dqa = 74910132;
                break;
            }
            //Si el valor recogido es incorrecto
            default:
                throw new IllegalStateException("Unexpected value: ");
        }
        return dqa;
    }

    public int getDanioQueAbsorbe(){
        return danioAbsorbe;
    }

    //Indicar material del Blindaje
    public String materialEscogido(int numero) {
        String nombre;
        switch (numero) {
            case 0: {
                nombre = "Adamantium";
                break;
            }
            case 1: {
                nombre = "Hierro";
                break;
            }
            case 2: {
                nombre = "Plata";
                break;
            }
            case 3: {
                nombre = "Platino";
                break;
            }
            case 4: {
                nombre = "Oro";
                break;
            }
            case 5: {
                nombre = "Diamante";
                break;
            }
            //El valor introducido es incorrecto
            default:
                throw new IllegalStateException("Unexpected value: " + numero);
        }
        return nombre;
    }

    @Override
    public String toString() {

        return ("  Blindaje: " +
                "\nMaterial ='" + material +
                "\nDanio Que Absorbe =" + danioAbsorbe +
                "\nPeso = " + peso);
    }
}
