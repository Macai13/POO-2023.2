/*  1. Fiz tudo e passou em todos os testes.
*   2. Fiz sozinho.
*   3. Melhorei na utilização do solver sem precisar de referências.
*   4. Cerca de quatro horas, separadas em dias diferentes.
*/

import java.util.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String input()    {        return in.nextLine();    }
    private static Pet tamagochi = new Pet(0, 0, 0);
    public static void main(String[] argsMain)
    {
        while (true)
        {    
            String line = input();
            System.out.println("$" + line);
            String[] args = line.split(" ");
                      
            if (args[0].equals("end")) { System.exit(0); }
            if (args[0].equals("init")) 
            { 
                tamagochi = new Pet(Integer.parseInt(args[1]), Integer.parseInt(args[2]),
                    Integer.parseInt(args[3]));
            }
            if (args[0].equals("play")) { tamagochi.play(); }
            if (args[0].equals("eat")) { tamagochi.eat(); }
            if (args[0].equals("shower")) { tamagochi.shower(); }
            if (args[0].equals("sleep")) { tamagochi.sleep(); }
            if (args[0].equals("show")) { System.out.println(tamagochi.show()); } 
        }
    }
}