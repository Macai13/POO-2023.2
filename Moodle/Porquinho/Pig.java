import java.util.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Pig 
{
    private boolean broken = false;
    private ArrayList<Coin> coins;
    private ArrayList<Item> items;
    private int volumeMax;

    Pig(int volumeMax)
    {
        coins = new ArrayList<>();
        items = new ArrayList<>();  
        this.volumeMax = volumeMax;
    }

    public boolean addCoin(Coin coin) throws Exception
    {
        if (isBroken())
        {
            throw new Exception("fail: the pig is broken");
        }

        if (getVolume() + coin.getVolume() >= volumeMax)
        {
            throw new Exception("fail: the pig is full");
        }

        coins.add(coin);

        return true;
    }

    public boolean addItem(Item item) throws Exception
    {
        if (isBroken())
        {
            throw new Exception("fail: the pig is broken");
        }

        if (getVolume() + item.getVolume() >= volumeMax)
        {
            throw new Exception("fail: the pig is full");
        }

        items.add(item);

        return true;
    }

    public boolean breakPig()
    {
        if (!isBroken())
        {
            broken = true;

            return true;
        }

        return false;
    }

    public ArrayList<String> extractCoins() throws Exception
    {
        if (!isBroken())
        {
            throw new Exception("fail: you must break the pig first");
        }

        ArrayList<String> coins = new ArrayList<>();

        for (Coin i : this.coins)
        {
            coins.add(i.toString());
        }

        this.coins = new ArrayList<>();

        return coins;
    }

    public ArrayList<String> extractItems() throws Exception
    {
        if (!isBroken())
        {
            throw new Exception("fail: you must break the pig first");
        }

        ArrayList<String> items = new ArrayList<>();

        for (Item i : this.items)
        {
            items.add(i.toString());
        }

        this.items = new ArrayList<>();

        return items;
    }

    @Override
    public String toString()
    {
        String state = "intact";

        if (broken)
        {
            state = "broken";
        }

        return "state="+state+" : "+"coins=["+toStringArrayCoin(coins)+"] : items=["+toStringArrayItem(items)+
            "] : value="+new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US)).format(getValue())+
            " : volume="+getVolume()+"/"+volumeMax;
    }

    private String toStringArrayCoin(ArrayList<Coin> list)
    {
        String str = "";

        for (Coin i : list)
        {
            str += i;

            if (!list.get(list.size() - 1).equals(i))
            {
                str += ", ";
            }
        }

        return str;
    }

    private String toStringArrayItem(ArrayList<Item> list)
    {
        String str = "";

        for (Item i : list)
        {
            str += i;

            if (!list.get(list.size() - 1).equals(i))
            {
                str += ", ";
            }
        }

        return str;
    }

    public int getVolumeMax() 
    {
        return volumeMax;
    }

    private double getValue()
    {
        double value = 0;

        for (Coin i : coins)
        {
            value += i.getValue();
        }

        return value;
    }

    public int getVolume()
    {
        if (isBroken())
        {
            return 0;
        }
        
        int volume = 0;

        for (Coin i : coins)
        {
            volume += i.getVolume();
        }

        for (Item i : items)
        {
            volume += i.getVolume();
        }

        return volume;
    }

    public boolean isBroken()
    {
        if (broken)
        {
            return true;
        }

        return false;
    }
}