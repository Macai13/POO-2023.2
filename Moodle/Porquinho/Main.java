import java.util.*;
import java.io.*;

public class Main
{
    private static File file = new File("test.txt");
    private static Scanner in = new Scanner(System.in);
    private static String[] userInput;
    private static Pig pig;
    private static boolean isTest = false; //mude para testar com o .txt
    
    public static void main(String[] args) throws FileNotFoundException
    {
        if (isTest)
        {
            in = new Scanner(file);
        }

        while (true)
        {            
            String line = input();
            System.out.printf("$%s\n", line);
            userInput = line.split(" ");
            
            try 
            {
                if (command("end"))
                {
                    System.exit(0);
                }

                if (command("init"))
                {
                    pig = new Pig(toInt(userInput[1]));
                }

                if (command("addItem"))
                {
                    pig.addItem(new Item(userInput[1], toInt(userInput[2])));
                }

                if (command("addCoin"))
                {
                    Coin coin = null;

                    if (userInput[1].equals("10"))
                    {
                        coin = Coin.C10;
                    }

                    if (userInput[1].equals("25"))
                    {
                        coin = Coin.C25;
                    }

                    if (userInput[1].equals("50"))
                    {
                        coin = Coin.C50;
                    }

                    if (userInput[1].equals("100"))
                    {
                        coin = Coin.C100;
                    }

                    pig.addCoin(coin);
                }
                
                if (command("extractItems"))
                {
                    try
                    {
                        System.out.println(pig.extractItems());
                    }

                    catch (Exception e)
                    {
                        System.out.println(e.getMessage()+"\n[]");
                    }
                }

                if (command("extractCoins"))
                {
                    try
                    {
                        System.out.println(pig.extractCoins());
                    }
                    
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage()+"\n[]");
                    }
                }

                if (command("break"))
                {
                    pig.breakPig();
                }

                if (command("show"))
                {
                    System.out.println(pig);
                }
            }

            catch (Exception e)
            {
                System.out.println(e.getMessage());
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

    private static int toInt(String num)
    {
        return Integer.parseInt(num);
    }
}