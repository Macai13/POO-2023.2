public class Lead 
{
    private float thickness;
    private String hardness;
    private int size;

    Lead(float thickness, String hardness, int size)
    {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public int usagePerSheet()
    {
        if (hardness.equals("HB")) { return 1; }
        if (hardness.equals("2B")) { return 2; }
        if (hardness.equals("4B")) { return 4; }
        if (hardness.equals("6B")) { return 6; }
        return 0;
    }

    public String getHardness() 
    {
        return hardness;
    }
    public int getSize() 
    {
        return size;
    }
    public float getThickness() 
    {
        return thickness;
    }
    public void setSize(int size) 
    {
        this.size = size;
    }

    public String show()
    {
        return "[" + thickness + ":" + hardness + ":" +
            size + "]";
    }
}
