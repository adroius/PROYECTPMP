import java.io.FileNotFoundException;
//Nave n=NaveBuilder.CrearNave();

public class Main {
    public static void main(String[] args){
        try {
            new Sistema();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
