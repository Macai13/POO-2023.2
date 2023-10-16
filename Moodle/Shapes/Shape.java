import java.util.*;
import java.math.*;

public abstract class Shape
{
    protected String name;

    Shape(String name)
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public boolean inside(Point2D point)
    {
        return false;
    }

    abstract double getArea();
    abstract double getPerimeter();
}