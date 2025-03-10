import main.Main;
import org.junit.jupiter.api.*;

class PruebaTest {

    @Test
    public void test1(){
        String palabra1 = "espada";
        String palabra2 = "pesada";

        boolean resultado = Main.getAnagramaHash(palabra1, palabra2);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void test2(){
        String palabra1 = "hola";
        String palabra2 = "cola";

        boolean resultado = Main.getAnagramaHash(palabra1, palabra2);
        Assertions.assertFalse(resultado);
    }

    @Test
    public void test3(){
        String palabra1 = "roma";
        String palabra2 = "amor";

        boolean resultado = Main.getAnagramaHash(palabra1, palabra2);
        Assertions.assertTrue(resultado);
    }
}
