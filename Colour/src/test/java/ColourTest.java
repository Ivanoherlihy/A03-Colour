import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ColourTest {
    private  Colour colour1;
    private Colour colour2;
    @BeforeEach
    public void setup(){
         colour1 = new Colour(.1f,.2f,.4f);
         colour2 = new Colour(.2f,.3f,.1f);
    }
    @Test
    public void floatConstructor (){

        assertEquals(.1f,colour1.getRed());
        assertEquals(.2f,colour1.getBlue());
        assertEquals(.4f,colour1.getGreen());

    }
    @Test
    public  void binaryConstuctor(){
        Colour colour = new Colour("111111110000000010000000") ;
        assertEquals(1, colour.getBlue());
        assertEquals(0,colour.getGreen());
        assertEquals(.5f,colour.getRed());

    }

    @Test
    public void illegalArgumentTest(){
        Executable testConstructor1 = () -> new Colour(5F,.1F,.1F);
        assertThrows(IllegalArgumentException.class ,testConstructor1 ) ;
        Executable testConstructor2 = () -> new Colour("");
        assertThrows(IllegalArgumentException.class ,testConstructor2 ) ;
        Executable testConstructor3 = () -> new Colour("0000000000000000000000000");
        assertThrows(IllegalArgumentException.class ,testConstructor3 ) ;
        Executable testConstructor4 = () -> new Colour("123456781234567812345678");
        assertThrows(IllegalArgumentException.class ,testConstructor4 ) ;
        Executable testSetter1 = () -> colour1.setRed(5);
        assertThrows(IllegalArgumentException.class, testSetter1);
        Executable testSetter2 = () -> colour1.setBlue(5);
        assertThrows(IllegalArgumentException.class, testSetter2);
        Executable testSetter3 = () -> colour1.setGreen(5);
        assertThrows(IllegalArgumentException.class, testSetter3);


    }

}