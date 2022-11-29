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
    public void constucture(){
        Colour colour = new Colour(.1f,.2f,.4f);
        assertEquals(.1f,colour.getRed());
        assertEquals(.2f,colour.getBlue());
        assertEquals(.4f,colour.getGreen());

    }
    @Test
    public void illegalArgumentTest(){
        Executable testConstructor = () -> new Colour(5F,.1F,.1F);
        assertThrows(IllegalArgumentException.class ,testConstructor ) ;
        Executable testSetter1 = () -> colour1.setRed(5);
        assertThrows(IllegalArgumentException.class, testSetter1);
        Executable testSetter2 = () -> colour1.setBlue(5);
        assertThrows(IllegalArgumentException.class, testSetter2);
        Executable testSetter3 = () -> colour1.setGreen(5);
        assertThrows(IllegalArgumentException.class, testSetter3);

    }
    public void setterTest(){

    }
}