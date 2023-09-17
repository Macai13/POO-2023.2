/*  1. Fiz tudo e passou em todos os testes.
*   2. Fiz sozinho.
*   3. Aprendi um pouco mais sobre o modificador "static".
*   4. Cerca de uma hora.
*/

import java.util.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String input() { return in.nextLine(); }
    private static Car car = new Car();
    static String[] a;
    public static void main(String[] args) 
    {
        while (true)
        {
            String line = input();
            System.out.println("$"+line);
            a = line.split(" ");

            if (userInput("end")) { System.exit(0); }
            if (userInput("show")) { System.out.println(car.show()); }
            if (userInput("enter")) { car.enter(); }
            if (userInput("leave")) { car.leave(); }
            if (userInput("drive")) { car.drive(Integer.parseInt(a[1])); }
            if (userInput("fuel")) { car.fuel(Integer.parseInt(a[1])); }
        }
    }

    public static boolean userInput(String command)
    {
        if (a[0].equals(command)) { return true; }
        return false;
    }
}