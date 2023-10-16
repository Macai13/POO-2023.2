import java.util.*;
import java.io.*;
import java.math.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main
{
    private static File file = new File("test.txt");
    private static Scanner in = new Scanner(System.in);
    private static boolean isTest = true;
    private static String[] userInput;
    private static ArrayList<Shape> shapes = new ArrayList<>();

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

            if (command("rect"))
            {
                Point2D P1 = new Point2D(toDouble(userInput[1]), toDouble(userInput[2]));
                Point2D P2 = new Point2D(toDouble(userInput[3]), toDouble(userInput[4]));

                shapes.add(new Rectangle(P1, P2));
            }

            if (command("circle"))
            {
                Point2D P1 = new Point2D(toDouble(userInput[1]), toDouble(userInput[2]));
                double radius = toDouble(userInput[3]);    

                shapes.add(new Circle(P1, radius));
            }

            if (command("show"))
            {
                for (Shape i : shapes)
                {
                    System.out.println(i);
                }
            }

            if (command("info"))
            {
                for (Shape i : shapes)
                {
                    String area = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US)).format(i.getArea());
                    String perimeter = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US)).format(i.getPerimeter());
                    String printLine = i.getName() + ": A=" + area + " P=" + perimeter;

                    System.out.println(printLine);
                }
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

    private static double toDouble(String num)
    {
        return Double.parseDouble(num);
    }
}