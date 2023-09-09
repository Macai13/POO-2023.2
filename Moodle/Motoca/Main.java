import java.util.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String[] args;
    private static Motorcycle motoca = new Motorcycle(1);
    
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
            
            if (userInput("init"))
            {
                motoca = new Motorcycle(toInt(args[1]));
            }

            if (userInput("show"))
            {
                System.out.println(motoca.show());
            }

            if (userInput("enter"))
            {
                Person person = new Person(args[1], toInt(args[2]));
                motoca.insertPerson(person);
            }

            if (userInput("honk"))
            {
                motoca.honk();
            }

            if (userInput("drive"))
            {
                motoca.drive(toInt(args[1]));
            }

            if (userInput("leave"))
            {
                motoca.remove();
            }

            if (userInput("buy"))
            {
                motoca.buyTime(toInt(args[1]));
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

    private static int toInt(String num)
    {
        return Integer.parseInt(num);
    }
}