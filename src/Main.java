import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

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
