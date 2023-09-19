import java.util.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String[] args;
    private static Topic topic = new Topic(0, 0);

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

            if (command("in"))
            {
                topic.insert(new Pass(args[1], Integer.parseInt(args[2])));
            }

            if (command("init"))
            {
                topic = new Topic(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            }

            if (command("out"))
            {
                topic.remove(args[1]);
            }

            if (command("show"))
            {
                System.out.println(topic.show());
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