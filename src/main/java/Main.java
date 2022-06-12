import userInterface.InputReader;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        try {
            String function = args[0];
            String[] arguments = Arrays.copyOfRange(args, 1, args.length);

            InputReader inputReader = new InputReader(function, arguments);

            inputReader.run();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie podano argumentów");
        }
    }
}

