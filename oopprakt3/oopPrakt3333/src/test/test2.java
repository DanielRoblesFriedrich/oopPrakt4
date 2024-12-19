package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Cafe;

class Test2 {

    private Cafe cafe;

    @BeforeEach
    void setUp() throws Exception {
        String[] kaffeeProdukte = {"Milchkaffee, Espresso"};
        cafe = new Cafe("CafeOle", "Bochum", "Klein", "Ja", kaffeeProdukte);
        assertNotNull(cafe);
    }

    @AfterEach
    void tearDown() throws Exception {
        cafe = null; 
    }

    @Test
    void testIstBaeckerei() {
      
        assertEquals("Ja", cafe.getIsBaeckerei(), "Cafe sollte eine Bäckerei haben");
    }
}

