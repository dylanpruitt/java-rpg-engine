package utility;

public class randomGenerator {

    public static int random (int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random () * range) + min;
    }
}