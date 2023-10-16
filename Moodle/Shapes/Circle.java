import java.util.*;
import java.math.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Circle extends Shape
{
    private Point2D center;
    private double radius;

    Circle(Point2D center, double radius)
    {
        super("Circ");
        this.center = center;
        this.radius = radius;
    }

    @Override
    double getArea() 
    {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    double getPerimeter() 
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString()
    {
        String radius = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US)).format(this.radius);

        return name + ": C=(" + center + "), R=" + radius;
    }
}