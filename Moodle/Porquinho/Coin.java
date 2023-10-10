public enum Coin
{
    C10(0.10, 1, "0.10:1"),
    C25(0.25, 2, "0.25:2"),
    C50(0.50, 3, "0.50:3"),
    C100(1, 4, "1.00:4");

    private int volume;
    private double value;
    private String label;

    Coin(double value, int volume, String label)
    {
        this.value = value;
        this.volume = volume;
        this.label = label;
    }

    public double getValue() 
    {
        return value;
    }
    
    public int getVolume() 
    {
        return volume;
    }
    
    @Override
    public String toString()
    {
        return label;
    }
}