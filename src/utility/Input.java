package utility;

import java.util.Scanner;

public class Input {

    public static int getIntegerInputInRange (int minimum, int maximum) {
        int input;

        Scanner scanner = new Scanner (System.in);

        do {
            while (!scanner.hasNextInt ()) {
                System.out.println ("Invalid input!");
                scanner.next ();
            }
            input = scanner.nextInt ();
        } while (!(input >= minimum && input <= maximum));

        return input;
    }
}
