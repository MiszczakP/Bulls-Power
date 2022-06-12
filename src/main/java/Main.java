import userInterface.Starter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try {
            String function = args[0];
            String[] arguments = Arrays.copyOfRange(args, 1, args.length);

            Starter starter = new Starter(function, arguments);

            starter.run();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie podano argumentów");
        }
    }
}

