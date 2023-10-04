import java.util.*;
import java.math.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String[] userInput;
    private static Agiota agiota = new Agiota();

    public static void main(String[] args)
    {
        while (true)
        {
            String line = input();
            System.out.println("$" + line);
            userInput = line.split(" ");

            if (command("end"))
            {
                System.exit(0);
            }

            if (command("init"))
            {
                agiota = new Agiota();
            }

            if (command("addCli"))
            {
                agiota.addClient(userInput[1], toInt(userInput[2]));
            }
            
            if (command("give"))
            {
                agiota.give(userInput[1], toInt(userInput[2]));
            }
            
            if (command("show"))
            {
                System.out.println(agiota);
            }
            
            if (command("take"))
            {
                agiota.take(userInput[1], toInt(userInput[2]));
            }
            
            if (command("showCli"))
            {
                System.out.println(agiota.getClient(userInput[1]));
            }
            
            if (command("kill"))
            {
                agiota.kill(userInput[1]);
            }
            
            if (command("plus"))
            {
                agiota.plus();
            }
        }
    }

    private static String input()
    {
        return in.nextLine();
    }

    private static boolean command(String command)
    {
        if (command.equals(userInput[0]))
        {
            return true;
        }

        return false;
    }

    private static int toInt(String num)
    {
        return Integer.parseInt(num);
    }
}