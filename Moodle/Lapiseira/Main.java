/*  1. Fiz tudo e passou em todos os testes.
*   2. Fiz sozinho.
*   3. Nada de novo.
*   4. Cerca de meia hora.
*/

import java.util.*; 

public class Main 
{
    private static Scanner in = new Scanner(System.in);
    private static String input() { return in.nextLine(); }
    private static Pencil grafite = new Pencil(0);
    public static void main(String[] args) 
    {
        while (true)
        {
            String line = input();
            System.out.println("$"+line);
            String[] a = line.split(" ");

            if (a[0].equals("end")) 
            { 
                System.exit(0); 
            }
            
            if (a[0].equals("insert")) 
            {
                grafite.insert(new Lead(Float.parseFloat(a[1]), a[2],
                    Integer.parseInt(a[3])));
            }
            
            if (a[0].equals("show")) 
            {
                System.out.println(grafite.show());
            }
            
            if (a[0].equals("write")) 
            {
                grafite.writePage();
            }
            
            if (a[0].equals("init")) 
            {
                grafite = new Pencil(Float.parseFloat(a[1]));
            }
            
            if (a[0].equals("remove")) 
            { 
                grafite.remove(); 
            }

            if (a[0].equals("pull"))
            {
                grafite.pull();
            }

        }
    }
}