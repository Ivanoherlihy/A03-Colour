import static java.lang.Math.pow;

/**
 * A representation of colour using three float point numbers
 * Each number corresponds to red green and blue
 */
public class Colour {


    private float red;
    private float blue;
    private float green;

    /**
     * Takes three Floating point numbers for red green and blue
     * @param red float between 0 and 1
     * @param blue float between 0 and 1
     * @param green float between 0 and 1
     */
    public Colour(float red, float blue, float green) {
        if (red > 1 || blue > 1 || green > 1 || red < 0 || blue < 0 || green < 0) {
            throw new IllegalArgumentException();

        } else {
            this.red = red;
            this.blue = blue;
            this.green = green;
        }
    }



    /**
     * The string is separated into 3 8 byte sections for each colour
     * Bits 16-24 inclusive represent red
     * Bits 8-15 inclusive represent green
     * bits 0-7 inclusive represent blue
     * if all bits are set to 1 for one section the result will be set to 1
     * otherwise each bit represents 1/2^n for each position
     * e.g. 111111110101010110000000 would lead to
     * Red = .5 , Green = .33203125 and Blue = 1
     * @param colours  string of 24 1s and 0s
     */

    public Colour(String colours) {

        if (colours.length()!=24)
            throw new IllegalArgumentException();
        for (Character bit : colours.toCharArray()){

            if (!(bit.equals('0')||bit.equals('1')))
                throw new IllegalArgumentException();

        }


        String red = colours.substring(16, 24);
        String green = colours.substring(8, 16);
        String blue = colours.substring(0, 8);
        this.red = convertByte(red);
        this.green = convertByte(green);
        this.blue = convertByte(blue);

    }

    private float convertByte(String Byte) {
        float out = 0;
        if (Byte.equals("11111111"))
            out = 1f;
        else {
            for (int i = 0; i < 8; i++) {
                out += (1f / (pow(2, i + 1))) * Integer.parseInt(Byte.substring(i, i + 1));

            }
        }
        return out;
    }
    /**
     *
     * @return Float = to red
     */
    public float getRed() {
        return red;
    }
    /**
     *
     * @param red float between 0 and 1
     */
    public void setRed(float red) {
        if (red > 1 || red < 0)
            throw new IllegalArgumentException();
        else
            this.red = red;
    }
    /**
     *
     * @return float = to Blue
     */
    public float getBlue() {
        return blue;
    }

    /**
     * @param blue float between 0 and 1
     */

    public void setBlue(float blue) {
        if (blue > 1 || blue < 0)
            throw new IllegalArgumentException();
        else
            this.blue = red;
    }

    /**
     *
     * @return float = to Green
     */
    public float getGreen() {
        return green;
    }

    /**
     * @param green float between 0 and 1
     */
    public void setGreen(float green) {
        if (green > 1 || green < 0)
            throw new IllegalArgumentException();
        else
            this.green = green;
    }

    /**
     *
     * @param inColour must be of Colour class
     * @return True if equal else false
     */
    @Override
    public boolean equals(Object inColour){
        if (inColour.getClass() != Colour.class)
            throw new IllegalArgumentException();
        Colour colour = (Colour) inColour;
        return this.red == colour.getRed() && this.green == colour.getGreen() && this.blue == colour.getBlue();

    }


}
