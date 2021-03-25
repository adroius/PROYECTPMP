import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public abstract class Defensa {
    public String tipoDeDefensa() throws IOException {
        Reader i = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(i);
        String s = br.readLine();
        return s;
    }
}
