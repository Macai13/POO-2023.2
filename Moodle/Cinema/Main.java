import java.util.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String[] args;
    private static Sala sala = new Sala(0);

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
                System.out.println(sala.show());
            }

            if (command("init"))
            {
                sala = new Sala(Integer.parseInt(args[1]));
            }

            if (command("reservar"))
            {
                sala.reservar(args[1], args[2], Integer.parseInt(args[3]));
            }

            if (command("cancelar"))
            {
                sala.cancelar(args[1]);
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