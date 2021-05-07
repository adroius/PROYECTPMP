import Proyecto.Administrador;
import Proyecto.Sistema;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        String s="a1234";
//        System.out.println(Sistema.cogerUsuario(s));
        Administrador a = new Administrador();
        a.ofertaValida();
    }
}
