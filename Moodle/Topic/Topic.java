import java.util.*;

public class Topic 
{
    private ArrayList<Pass> normalSeats = new ArrayList<>();
    private ArrayList<Pass> prioritySeats = new ArrayList<>();
    private boolean foi = false;

    private int findFree(ArrayList<Pass> list)
    {
        for (Pass i : list)
        {
            if (i.getName().equals("=") || i.getName().equals("@"))
            {
                return list.indexOf(i);
            }
        }

        return -1;
    }

    private boolean findName(ArrayList<Pass> list, Pass pass)
    {
        for (Pass i : list)
        {
            if (i.getName().equals("="+pass.getName()) || i.getName().equals("@"+pass.getName()))
            {
                System.out.println("fail: "+pass.getName()+" ja esta na topic");

                return true;
            }
        }
        
        for (Pass i : prioritySeats)
        {
            if (i.getName().equals("="+pass.getName()) || i.getName().equals("@"+pass.getName()))
            {
                System.out.println("fail: "+pass.getName()+" ja esta na topic");

                return true;
            }
        }

        return false;
    }

    private void insert(ArrayList<Pass> list, Pass pass)
    {
        int index = findFree(list);

        if (findName(list, pass))
        {
            //System.out.println("exec3");
            
            return;
        }

        if (index == -1)
        {         
            if (list.equals(normalSeats) && findFree(prioritySeats) != -1)
            {
                index = findFree(prioritySeats);
                prioritySeats.set(index, new Pass("@"+pass.getName(), pass.getAge()));
                //System.out.println("exec1");

                return;
            }
            if (list.equals(prioritySeats) && findFree(normalSeats) != -1)
            {
                index = findFree(normalSeats);
                normalSeats.set(index, new Pass("="+pass.getName(), pass.getAge()));
                //System.out.println("exec2");

                return;
            }

            System.out.println("fail: topic lotada");

            return;
        }

        if (pass.getAge() >= 60)
        {            
            //System.out.println("exec4");
            
            if (list.get(index).getName().equals("@"))
            {
                //System.out.println("exec5");
                prioritySeats.set(index, new Pass("@"+pass.getName(), pass.getAge()));
            }

            return;
        }

        if (list.get(index).getName().equals("="))
        {
            //System.out.println("exec6");
            normalSeats.set(index, new Pass("="+pass.getName(), pass.getAge()));
        }
    }

    Topic(int capacity, int qtdPriority)
    {
        for (int i = 0; i < capacity - qtdPriority; i++)
        {
            normalSeats.add(new Pass("=", 0));
        }

        for (int i = 0; i < qtdPriority; i++)
        {
            prioritySeats.add(new Pass("@", 0));
        }
    }
  
    public void insert(Pass pass)
    {
        if (pass.getAge() >= 60)
        {
            insert(prioritySeats, pass);

            return;
        }

        insert(normalSeats, pass);  
    }

    private void tryRemove(String name)
    {        
        for (ListIterator<Pass> it = normalSeats.listIterator(); it.hasNext();)
        {
            if (it.next().getName().equals("="+name))
            {
                int index = normalSeats.indexOf(it.next()) - 1;
                normalSeats.remove(index);
                normalSeats.add(index, new Pass("=", 0));

                foi = true;

                break;
            }
        }
        
        for (Pass i : prioritySeats)
        {
            if (i.getName().equals("@"+name))
            {
                int index = prioritySeats.indexOf(i);
                prioritySeats.remove(i);
                prioritySeats.add(index, new Pass("@", 0));

                foi = true;
            }
        }
    }

    public void remove(String name)
    {
        tryRemove(name);

        if (!foi)
        {
            System.out.println("fail: "+name+" nao esta na topic");
        }

        foi = false;
    }

    public String show()
    {
        if (prioritySeats.isEmpty())
        {
            return "[]";
        }
        
        return "[" + showFor(prioritySeats) + " " + showFor(normalSeats) + "]";
    }

    public String showFor(ArrayList<Pass> pass)
    {
        String list = "";

        for (Pass i : pass)
        {
            list += i.show();
            if (!pass.get(pass.size() - 1).equals(i))   //Vê qual o último
            {
                list += " ";
            }
        }

        return list;
    }
}