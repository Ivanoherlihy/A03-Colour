

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
    public float getRed() {
        return red;
    }

    public void setRed(float red) {
        if (red>1 || red<0)
            throw new IllegalArgumentException();
        else
            this.red = red;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(float blue) {
        if (blue>1 || blue<0)
            throw new IllegalArgumentException();
        else
            this.blue = red;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        if (green>1 || green<0)
            throw new IllegalArgumentException();
        else
            this.green = green;
    }
}