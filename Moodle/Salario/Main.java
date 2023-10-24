import java.util.*;

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String[] userInput;
    private static UFC ufc = new UFC();
    
    public static void main (String[] args) 
    {
        while (true)
        {
            String line = input();
            System.out.println("$" + line);
            userInput = line.split(" ");
            
            try 
            {
                menu();
            } 
            
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static void menu() throws Exception
    {
        if (command("end"))
        {
            System.exit(0);
        }
        
        if (command("addProf"))
        {
            ufc.addFuncionario(new Professor(userInput[1], userInput[2]));
        }
        
        if (command("addSta"))
        {
            ufc.addFuncionario(new STA(userInput[1], toInt(userInput[2])));
        }
        
        if (command("addTer"))
        {
            ufc.addFuncionario(new Tercerizado(userInput[1], toInt(userInput[2]), userInput[3]));
        }
        
        if (command("showAll"))
        {
            System.out.println(ufc);
        }
        
        if (command("rm"))
        {
            ufc.rmFuncionario(userInput[1]);
        }
        
        if (command("show"))
        {
            System.out.println(ufc.showIndiv(userInput[1]));
        }
        
        if (command("addDiaria"))
        {
            ufc.addDiaria(userInput[1]);
        }
        
        if (command("setBonus"))
        {
            ufc.setBonus(toInt(userInput[1]));
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