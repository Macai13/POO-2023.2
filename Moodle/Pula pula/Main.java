import java.util.*;

public class Main
{
    private static Scanner in = new Scanner(System.in);
    private static String[] args;
    private static Trampoline tramp = new Trampoline();

    public static void main(String[] a) 
    {
        while (true)
        {
            String line = input();
            System.out.println("$"+line);
            args = line.split(" ");

            if (command("end"))
            {
                System.exit(0);
            }

            if (command("remove"))
            {
                tramp.remove(args[1]);
            }

            if (command("arrive"))
            {
                Kid kid = new Kid(args[1], Integer.parseInt(args[2]));

                tramp.arrive(kid);
            }

            if (command("show"))
            {
                System.out.println(tramp.show());
            }

            if (command("enter"))
            {
                tramp.enter();
            }

            if (command("leave"))
            {
                tramp.leave();
            }
        }
    }

    private static String input()
    {
        return in.nextLine();
    }

    private static boolean command(String c)
    {
        if (args[0].equals(c))
        {
            return true;
        }

        return false;
    }
}
