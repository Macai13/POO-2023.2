import java.util.*;

public class Client 
{
    private String name;
    private int limite;
    private ArrayList<Operation> operations;

    Client(String name, int limite)
    {
        this.name = name;
        this.limite = limite;
        this.operations = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        return this.name + " " + clientBalance() + "/" + this.limite;
    }

    public int clientBalance()
    {
        int balance = 0;
    
        for (Operation i : this.operations)
        {
            Label label = i.getLabel();

            if (label.equals(Label.GIVE) || label.equals(Label.PLUS))
            {
                balance += i.getValue();
            }

            if (label.equals(Label.TAKE))
            {
                balance -= i.getValue();
            }
        }

        return balance;
    }

    public String getName() 
    {
        return this.name;
    }

    public int getLimite() 
    {
        return this.limite;
    }

    public ArrayList<Operation> getOperations(String name, ArrayList<Operation> oper) 
    {
        ArrayList<Operation> returningOperations = new ArrayList<>();

        for (Operation i : oper)
        {
            if (i.getName().equals(name))
            {
                returningOperations.add(i);
            }
        }

        return returningOperations;
    }

    public void addOperations(Operation newOperation)
    {
        this.operations.add(newOperation);
    }
}
