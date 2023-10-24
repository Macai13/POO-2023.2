import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class Account 
{
    protected double balance;
    protected int accId;
    protected String clientId;
    protected String typeId;

    Account(int accId, String clienteId, String typeId)
    {
        this.accId = accId;
        this.clientId = clienteId;
        this.typeId = typeId;
    }

    public void deposit(double value)
    {

    }

    public void withdraw(double value)
    {

    }

    public void transfer(Account other, double value)
    {

    }

    @Override
    public String toString()
    {
        return accId + ":" + clientId + ":" + new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US)).format(getBalance()) + ":" + typeId;
    }

    public double getBalance() 
    {
        return balance;
    }

    public int getId() 
    {
        return accId;
    }

    public String getClientId() 
    {
        return clientId;
    }

    public String getTypeId() 
    {
        return typeId;
    }
}