package Test;

import Proyecto.Kromagg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class KromaggTest {
    Kromagg kromagg;

    @BeforeEach
    void serUp(){
        kromagg = new Kromagg(1);
    }

    @Test
    void licencia() {
        assertTrue(kromagg.licencia(1));
        assertFalse(kromagg.licencia(2));
    }

    @Test
    void licenciaMenorUno(){
        assertThrows(IllegalStateException.class, ()->{
           kromagg.licencia(0);
        });
    }

    @Test
    void licenciaMayorDos(){
        assertThrows(IllegalStateException.class, ()->{
            kromagg.licencia(3);
        });
    }

    @Test
    void kromaggNave() {
    }

}