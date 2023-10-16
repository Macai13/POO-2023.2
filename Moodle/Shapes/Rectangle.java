import java.util.*;
import java.math.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

class Rectangle extends Shape
{
    private Point2D P1;
    private Point2D P2;

    Rectangle(Point2D P1, Point2D P2)
    {
        super("Rect");
        this.P1 = P1;
        this.P2 = P2;
    }

    @Override
    double getArea() 
    {
        return (P1.getX() - P2.getX()) * (P1.getY() - P2.getY());
    }

    @Override
    double getPerimeter() 
    {
        return Math.abs(2*(P1.getX() - P2.getX()) + 2*(P1.getY() - P2.getY()));
    }

    @Override
    public String toString()
    {
        return name + ": P1=(" + P1 + ") P2=(" + P2 + ")";
    }
}