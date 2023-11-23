/*  1. Fiz tudo e passou em todos os testes possíveis, já que o último teste tá errado
*   2. Fiz sozinho.
*   3. --.
*   4. Cerca de uma hora e meia.
*/

import java.util.*;
import java.io.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String[] userInput;
    private static Trem trem;
    private static boolean isTest = false;
    private static File file = new File("test.txt");
    
    public static void main (String[] args) throws FileNotFoundException
    {
        if (isTest)
        {
            in = new Scanner(file);
        }

        while (true)
        {
            try 
            {
                menu();
            } 
            
            catch (RuntimeException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static void menu()
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
            trem = new Trem(toInt(userInput[1]));
        }

        if (command("init"))
        {
            trem = new Trem(toInt(userInput[1]));
        }

        if (command("nwvp"))
        {
            trem.addVagao(toInt(userInput[1]));
        }
        
        if (command("nwvc"))
        {
            trem.addCargo(toFloat(userInput[1]));
        }

        if (command("addp"))
        {
            trem.embarcar(userInput[1]);
        }
        
        if (command("addc"))
        {
            trem.addItem(userInput[1], toFloat(userInput[2]));
        }

        if (command("la") || command("show"))
        {
            System.out.println(trem);
        }

        if (command("cadastro"))
        {
            System.out.println(trem.getCadastro());
        }

        if (command("movimentacao"))
        {
            System.out.println(trem.getMovimentacao());
        }

        if (command("sair"))
        {
            trem.desembarcar(userInput[1]);
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
    
    private static float toFloat(String num)
    {
        return Float.parseFloat(num);
    }
}