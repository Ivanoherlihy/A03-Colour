import static java.lang.Math.pow;

public class Colour {


    private float red;
    private float blue;
    private float green;

    public Colour(float red, float blue, float green) {
        if (red > 1 || blue > 1 || green > 1 || red < 0 || blue < 0 || green < 0) {
            throw new IllegalArgumentException();

        } else {
            this.red = red;
            this.blue = blue;
            this.green = green;
        }
    }

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


    public float getRed() {
        return red;
    }

    public void setRed(float red) {
        if (red > 1 || red < 0)
            throw new IllegalArgumentException();
        else
            this.red = red;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(float blue) {
        if (blue > 1 || blue < 0)
            throw new IllegalArgumentException();
        else
            this.blue = red;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        if (green > 1 || green < 0)
            throw new IllegalArgumentException();
        else
            this.green = green;
    }
}
