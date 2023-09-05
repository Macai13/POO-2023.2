/*  1. Fiz tudo e passou em todos os testes.
*   2. Fiz sozinho.
*   3. Aprendi a usar o "%02d" pra mostrar duas casas inteiras e entendi melhor a instaciação de objetos.
*   4. Pouco menos de duas horas.
*/

import java.util.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String input() { return in.nextLine(); }
    private static Time time = new Time(0, 0, 0);

    public static void main(String[] a)
    {
        while (true)
        {
            String line = input();
            System.out.println("$"+line);
            String[] args = line.split(" ");

            if (args[0].equals("end")) { System.exit(0); }
            if (args[0].equals("show")) { time.show(); }
            if (args[0].equals("set"))
            {
                time.setHour(Integer.parseInt(args[1]));
                time.setMinute(Integer.parseInt(args[2]));
                time.setSecond(Integer.parseInt(args[3]));
            }
            if (args[0].equals("init"))
            {
                time = new Time(Integer.parseInt(args[1]), Integer.parseInt(args[2]), 
                    Integer.parseInt(args[3]));
            }
            if (args[0].equals("next")) { time.nextSecond(); }
        }
    }
}