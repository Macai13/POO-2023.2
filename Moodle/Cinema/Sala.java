import java.util.*;

public class Sala
{
    private ArrayList<Client> cadeiras = new ArrayList<>();
    
    private int procurar(String nome)
    {
        for (Client i : cadeiras)
        {
            if (i.getId().equals(nome))
            {
                return cadeiras.indexOf(i);
            }
        }

        return -1;
    }

    private boolean verificarIndice(int index)
    {
        if (index < 2)
        {
            return false;
        } 

        return true;
    }

    Sala(int capacidade)
    {
        if (!verificarIndice(capacidade))
        {
            return;
        }

        for (int i = 0; i < capacidade; i++)
        {
            cadeiras.add(new Client("-", null));
        }
    }

    public void reservar(String id, String fone, int index)
    {
        if (cadeiras.size() - 1 < index)
        {
            System.out.println("fail: cadeira nao existe");

            return;
        }

        for (Client i : cadeiras)
        {            
            if (i.getId().equals(id))
            {
                System.out.println("fail: cliente ja esta no cinema");

                return;
            }
        }

        if (!cadeiras.get(index).getId().equals("-"))
        {
            System.out.println("fail: cadeira ja esta ocupada");

            return;
        }
        
        cadeiras.set(index, new Client(id, fone));
    }

    public void cancelar(String id)
    {
        int index = procurar(id);
        
        if (index == -1)
        {
            System.out.println("fail: cliente nao esta no cinema");
            
            return;
        }

        cadeiras.remove(index);
        cadeiras.add(index, new Client("-", null));
    }

    public String show()
    {
        return "[" + showFor(cadeiras) + "]";
    }

    public String showFor(ArrayList<Client> client)
    {
        String list = "";

        for (Client i : client)
        {
            list += i.show();
            if (!client.get(client.size() - 1).equals(i))   //Vê qual o último
            {
                list += " ";
            }
        }

        return list;
    }

    public ArrayList<Client> getCadeiras() 
    {
        return cadeiras;
    }
}