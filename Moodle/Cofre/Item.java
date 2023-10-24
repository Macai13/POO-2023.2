import java.math.BigDecimal;

public class Item 
{
    private String label;
    private float value;
    private int volume;

    Item(String label, float value, int volume)
    {
        this.label = label;
        this.value = value;
        this.volume = volume;
    }

    public String getLabel() 
    {
        return label;
    }

    public int getVolume() 
    {
        return volume;
    }

    public void setLabel(String label) 
    {
        this.label = label;
    }

    public void setVolume(int volume) 
    {
        this.volume = volume;
    }

    public float getValue() 
    {
        return value;
    }

    @Override
    public String toString()
    {
        return label + ":" + new BigDecimal(value).setScale(2) + ":" + volume;
    }
}