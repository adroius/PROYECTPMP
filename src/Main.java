import java.io.FileNotFoundException;
import java.io.IOException;
//Nave n= NaveBuilder.CrearNave();

public class Main {
    public static void main(String[] args) {
        try {
            new Sistema();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
