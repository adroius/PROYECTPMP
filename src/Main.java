import java.io.File;
import java.io.FileWriter;

//Nave n=NaveBuilder.CrearNave();
public class Main {
    public static void main(String[] args) {
        String saludo="Hola";

        try
        {
//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir=new FileWriter("texto.txt",true);

//Escribimos en el archivo con el metodo write
            escribir.write(saludo);

//Cerramos la conexion
            escribir.close();
        }

//Si existe un problema al escribir cae aqui
        catch(Exception e)
        {
            System.out.println("Error al escribir");
        }
        new Sistema();
    }
}
