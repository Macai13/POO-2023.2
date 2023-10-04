import java.util.*;
import java.math.*;

public class Agiota 
{
    private ArrayList<Client> alive_list;
    private ArrayList<Client> death_list;
    private ArrayList<Operation> alive_oper;
    private ArrayList<Operation> death_oper;
    private int nextOpId;

    private int searchClient(String name)
    {
        int index = -1;

        for (Client i : alive_list) 
        {
            if (i.getName().equals(name))
            {
                return alive_list.indexOf(i);
            }
        }

        return index;
    }

    Agiota()
    {
        this.alive_list = new ArrayList<>();
        this.alive_oper = new ArrayList<>();
        this.death_list = new ArrayList<>();
        this.death_oper = new ArrayList<>();
    }

    public String getClient(String name)
    {
        int index = searchClient(name);
        Client client = null;

        try
        {
            client = alive_list.get(index);
        }
        
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("fail: cliente nao existe");

            return null;
        }

        ArrayList<Operation> temp = client.getOperations(name, alive_oper);

        return client + operListToString(temp, '\u0000');
    }

    public void addClient(String name, int limite)
    {
        if (searchClient(name) != -1)
        {
            System.out.println("fail: cliente ja existe");

            return;
        }
        
        alive_list.add(new Client(name, limite));
    }

    public void give(String name, int value)
    {
        int index = searchClient(name);
        Client client;

        try
        {
            client = alive_list.get(index);
        }
        
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("fail: cliente nao existe");

            return;
        }

        if (client.getLimite() <= client.clientBalance() + value)
        {
            System.out.println("fail: limite excedido");

            return;
        }

        client.addOperations(new Operation(nextOpId, name, Label.GIVE, value));
        alive_oper.add(new Operation(nextOpId, name, Label.GIVE, value));

        nextOpId++;
    }

    public void take(String name, int value)
    {
        int index = searchClient(name);
        Client client;

        try
        {
            client = alive_list.get(index);
        }
        
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("fail: cliente nao existe");

            return;
        }

        /* if (client.getLimite() <= Integer.parseInt(client.clientBalance()) + value)
        {
            System.out.println("fail: limite excedido");

            return;
        } */

        client.addOperations(new Operation(nextOpId, name, Label.TAKE, value));
        alive_oper.add(new Operation(nextOpId, name, Label.TAKE, value));

        nextOpId++;
    }

    public void kill(String name)
    {
        int index = searchClient(name);
        Client client = null;

        try 
        {
            client = alive_list.get(index);

        }

        catch (IndexOutOfBoundsException e)
        {
            System.out.println("fail: cliente nao existe");
        }
        
        death_list.add(client);
        alive_list.remove(client);

        for (Operation i : client.getOperations(name, alive_oper))
        {
            death_oper.add(i);
            alive_oper.remove(i);
        }
    }

    public void plus()
    {
        ArrayList<Client> temp = new ArrayList<>(alive_list);

        for (Client i : temp)
        {
            double tax = i.clientBalance()*0.1;
            int taxInt = (int)Math.ceil(tax);

            int j = alive_list.indexOf(i);

            alive_list.get(j).addOperations(new Operation(nextOpId, i.getName(), Label.PLUS, taxInt));
            alive_oper.add(new Operation(nextOpId, i.getName(), Label.PLUS, taxInt));

            if (i.clientBalance() >= i.getLimite())
            {
                kill(i.getName());
            }

            nextOpId++;
        }
    }

    @Override
    public String toString()
    {
        Collections.sort(alive_list, new Comparator<Client>() 
        {
            @Override
            public int compare(Client item, Client t1) 
            {
                String s1 = item.getName();
                String s2 = t1.getName();
                return s1.compareToIgnoreCase(s2);
            }
        });
        
        return clientListToString(alive_list, ":)") + operListToString(alive_oper, '+')
           + clientListToString(death_list, ":(") + operListToString(death_oper, '-');
    }

    private String operListToString(ArrayList<Operation> oper, char symbol)
    {
        String str = "";

        if (!oper.isEmpty())
        {
            str += "\n";
        }

        for (Operation i : oper)
        {
            if (symbol != '\u0000')
            {
                str += symbol + " ";
            }

            if (!i.equals(oper.get(oper.size() - 1)))
            {
                str += i + "\n"; 

                continue;
            }

            str += i;
        }

        return str;
    }

    private String clientListToString(ArrayList<Client> client, String symbol)
    {
        String str = "";

        if (symbol == ":(" && !client.isEmpty())
        {
            str += "\n";
        }

        for (Client i : client)
        {
            str += symbol + " ";
        
            if (!i.equals(client.get(client.size() - 1)))
            {
                str += i + "\n"; 

                continue;
            }
                
            str += i; 
        }
        return str;
    }
}