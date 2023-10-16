import java.util.*;
import java.math.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Point2D
{
    private double x;
    private double y;

    Point2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX() 
    {
        return x;
    }

    public double getY() 
    {
        return y;
    }

    @Override
    public String toString()
    {
        String x = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US)).format(this.x);
        String y = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US)).format(this.y);

        return x + ", " + y;
    }
}