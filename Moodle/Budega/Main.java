import java.util.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String[] args;
    private static Mercantil mercantil = new Mercantil(0);

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

            if (command("show"))
            {
                System.out.println(mercantil.show());
            }

            if (command("init"))
            {
                mercantil = new Mercantil(Integer.parseInt(args[1]));               
            }

            if (command("call"))
            {
                mercantil.chamar(Integer.parseInt(args[1]));
            }

            if (command("finish"))
            {
                mercantil.finalizar(Integer.parseInt(args[1]));
            }

            if (command("arrive"))
            {
                mercantil.chegar(new Pessoa(args[1]));
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