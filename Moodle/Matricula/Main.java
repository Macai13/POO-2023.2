import java.util.*;
import java.io.*;

public class Main
{
    private static File testFile = new File("test.txt");
    private static Scanner in = new Scanner(System.in);
    private static String[] userInput;
    private static Sistema sys = new Sistema();
    private static boolean isTest = true;

    public static void main(String[] args) throws FileNotFoundException
    {
        if (isTest)
        {
            in = new Scanner(testFile);
        }

        while (true)
        {
            String line = input();
            System.out.println("$"+line);
            userInput = line.split(" ");

            if (command("end"))
            {
                System.exit(0);
            }

            if (command("nwdis"))
            {
                for (int i = 1; i < userInput.length; i++)
                {
                    sys.addDiscp(userInput[i]);
                }
            }

            if (command("nwalu"))
            {
                for (int i = 1; i < userInput.length; i++)
                {
                    sys.addAluno(userInput[i]);
                }
            }

            if (command("tie"))
            {
                for (int i = 2; i < userInput.length; i++)
                {
                    sys.matricular(userInput[1], userInput[i]);
                }
            }

            if (command("untie"))
            {
                for (int i = 2; i < userInput.length; i++)
                {
                    sys.desmatricular(userInput[1], userInput[i]);
                }
            }

            if (command("rmalu"))
            {
                sys.removerAluno(userInput[1]);
            }

            if (command("rmdisc"))
            {
                sys.removerDiscp(userInput[1]);
            }

            if (command("show"))
            {
                System.out.println(sys);
            }
        }
    }

    private static boolean command(String command)
    {
        if (command.equals(userInput[0]))
        {
            return true;
        }

        return false;
    }

    private static String input()
    {
        return in.nextLine();
    }
}