import java.util.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String[] args;
    private static Animal animal = new Animal(null, null);

    public static void main(String[] a)
    {
        while (true)
        {
            String line = input();
            System.out.println("$"+line);
            args = line.split(" ");

            if (userInput("end"))
            {
                System.exit(0);
            }
            
            if (userInput("show"))
            {
                System.out.println(animal.show());
            }

            if (userInput("init"))
            {
                animal = new Animal(args[1], args[2]);
            }

            if (userInput("grow"))
            {
                animal.envelhecer(Integer.parseInt(args[1]));
            }

            if (userInput("noise"))
            {
                System.out.println(animal.fazerBarulho());
            }
        }
    }

    private static String input()
    {
        return in.nextLine();
    }

    private static boolean userInput(String command)
    {
        if (args[0].equals(command))
        {
            return true;
        }

        return false;
    }
}
