package Test;

import Proyecto.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
class SistemaTest {

    //private Proyecto.Sistema s=null;

    @BeforeEach
    void setUp() throws IOException {
        //s=new Proyecto.Sistema();
        System.out.println("Comienza la ejecucion...");
    }

    @Test
    void getSistema() {
        try {
            Sistema s=new Sistema();
            System.out.println(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void menuConValorBasura() {

    }

    @Test
    void verOfertas() {
    }

    @Test
    void crearOferta() {
    }

    @Test
    void insertarNave() {
    }

    @Test
    void cogerNave() {
    }

    @Test
    void pertenece() {
    }

    @Test
    void registrarNuevoCliente() {
    }


    @Test
    void iniciarSesion() {
    }

    @Test
    void buscarSiUserIsKromagg() {
    }

}