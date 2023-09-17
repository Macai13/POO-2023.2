import java.util.*;

public class Mercantil 
{
    private ArrayList<Pessoa> caixas = new ArrayList<Pessoa>();
    private ArrayList<Pessoa> esperando = new ArrayList<Pessoa>();

    private boolean validarIndice(int index)
    {
        if (index >= 0)
        {
            return true;
        }

        return false;
    }

    Mercantil(int qtdCaixas)
    {
        if (!validarIndice(qtdCaixas))
        {
            return;
        }
        
        for (int i = 0; i < qtdCaixas; i++)
        {
            caixas.add(0, new Pessoa("-----"));
        }
    }

    public void chegar(Pessoa pessoa)
    {
        esperando.add(pessoa);
    }

    public void chamar(int index)
    {
        if (!validarIndice(index))
        {
            return;
        }

        try 
        {
            esperando.get(0);
        } 
        
        catch (IndexOutOfBoundsException e) 
        {
            System.out.println("fail: sem clientes");
            
            return;
        }

        if (caixas.get(index).getNome() != "-----")
        {
            System.out.println("fail: caixa ocupado");
            
            return;
        }

        caixas.set(index, esperando.get(0));
        esperando.remove(0);
    }

    public void finalizar(int index)
    {
        if (!validarIndice(index))
        {
            return;
        }

        try 
        {
            if (caixas.get(index).getNome() == "-----")
            {
                System.out.println("fail: caixa vazio");
            }
            
            caixas.set(index, new Pessoa("-----"));
        } 
        
        catch (IndexOutOfBoundsException e) 
        {
            System.out.println("fail: caixa inexistente");
        }
    }

    public String show()
    {
        return "Caixas: [" + showFor(caixas) + "]\nEspera: [" + showFor(esperando) + "]";
    }

    public String showFor(ArrayList<Pessoa> pessoa)
    {
        String list = "";

        for (Pessoa i : pessoa)
        {
            list += i.show();
            if (!pessoa.get(pessoa.size() - 1).equals(i))
            {
                list += ", ";
            }
        }

        return list;
    }
}