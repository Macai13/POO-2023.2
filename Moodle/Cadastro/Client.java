import java.util.*;

public class Client
{
    protected String clientId;
    protected ArrayList<Account> accounts;

    Client(String clientId)
    {
        this.clientId = clientId;
        accounts = new ArrayList<>();
    }

    public void addAcount(Account acc)
    {

    }

    public ArrayList<Account> geAccounts()
    {
        return accounts;
    }

    public String getClientId() 
    {
        return clientId;
    }

    @Override
    public String toString()
    {
        return clientId;
    }
}