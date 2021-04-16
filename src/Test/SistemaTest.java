package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class SistemaTest {

    private Sistema s;

    @BeforeEach
    void setUp() throws IOException {
        s=new Sistema();
        System.out.println("Comienza la ejecucion...");
    }

    @Test
    void menuConValorBasura() {
        try {
            s.menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@Test
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

    @Test
    void getSistema() {
    }*/
}