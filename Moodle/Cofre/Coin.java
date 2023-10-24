public enum Coin
{
    M10(0.10, 1, "M10:0.10:1"),
    M25(0.25, 2, "M25:0.25:2"),
    M50(0.50, 3, "M50:0.50:3"),
    M100(1, 4, "M100:1.00:4");

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