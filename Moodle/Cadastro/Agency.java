import java.util.*;

public class Agency
{
    private ArrayList<Account> accounts;
    private ArrayList<Client> clients;
    private int nextAccountId;

    Agency()
    {
        accounts = new ArrayList<>();
        clients = new ArrayList<>();
    }

    private Account getAccount() 
    {
        return null;
    }

    public void addCli(String clientId)
    {
        clients.add(new Client(clientId));
        accounts.add(new Account(nextAccountId, clientId, "CC"));
        nextAccountId++;
        accounts.add(new Account(nextAccountId, clientId, "CP"));
        nextAccountId++;
    }

    public void deposit(int accId, double value) throws IndexOutOfBoundsException
    {
        accounts.get(accId).balance += value;
    }

    public void withdraw(int accId, double value) throws IndexOutOfBoundsException, NegativeBalance
    {
        if (accounts.get(accId).balance - value < 0)
        {
            throw new NegativeBalance();
        }

        accounts.get(accId).balance -= value;
    }

    public void transfer(int fromAccId, int toAccId, double value) throws IndexOutOfBoundsException, NegativeBalance
    {
        if (accounts.get(fromAccId).balance - value < 0)
        {
            throw new NegativeBalance();
        }

        accounts.get(toAccId).balance += value;
        accounts.get(fromAccId).balance -= value;
    }

    public void updateMonthly()
    {
        for (Account i : accounts)
        {
            if (accounts.indexOf(i) % 2 == 0)
            {
                accounts.get(accounts.indexOf(i)).balance -= 20;

                continue;
            }

            accounts.get(accounts.indexOf(i)).balance += accounts.get(accounts.indexOf(i)).balance*0.01;
        }
    }

    @Override
    public String toString()
    {
        String toPrint = "- Clients\n";
        int j = 0;

        for (Client i : clients)
        {
            toPrint += i + " [" + (clients.indexOf(i) + j) + ", " + (clients.indexOf(i) + 1 + j) + "]\n";
            j++;
        }

        toPrint += "- Accounts\n";

        for (Account i : accounts)
        {
            if (!accounts.get(accounts.size() - 1).equals(i))
            {
                toPrint += i + "\n";
            }
            else
            {
                toPrint += i;
            }
        }

        return toPrint;
    }
}