/*  1. Fiz tudo e passou em todos os testes (apesar de que não usei muita coisa do diagrama).
*   2. Fiz sozinho.
*   3. Aprendi a criar custom exceptions.
*   4. Cerca de duas horas.
*/


import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main
{
    private static File file = new File("test.txt");
    private static Scanner in = new Scanner(System.in);
    private static Agency bank = new Agency();
    private static boolean isTest = false;
    private static String[] userInput;

    public static void main(String[] args) throws FileNotFoundException
    {
        if (isTest)
        {
            in = new Scanner(file);
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

            if (command("addCli"))
            {
                bank.addCli(userInput[1]);
            }

            try
            {
                if (command("deposito"))
                {
                    bank.deposit(Integer.parseInt(userInput[1]), Double.parseDouble(userInput[2]));
                }

                if (command("transf"))
                {
                    bank.transfer(Integer.parseInt(userInput[1]), Integer.parseInt(userInput[2]), Double.parseDouble(userInput[3]));
                }
                
                if (command("saque"))
                {
                    bank.withdraw(Integer.parseInt(userInput[1]), Double.parseDouble(userInput[2]));
                }
            }

            catch (IndexOutOfBoundsException e) 
            {
                System.err.println("fail: conta nao encontrada");
            }

            catch (NegativeBalance e) 
            {
                System.err.println(e.getMessage());
            }

            if (command("update"))
            {
                bank.updateMonthly();
            }

            if (command("show"))
            {
                System.out.println(bank);
            }
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
}