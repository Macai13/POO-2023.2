import java.util.*;

public class Pencil 
{
    private float thickness;
    private Lead tip;
    private ArrayList<Lead> barrel = new ArrayList<Lead>();

    Pencil(float thickness)
    {
        this.thickness = thickness;
    }

    public boolean hasGrafite()
    {
        if (tip == null) 
        {
            return false;
        }

        if (tip.getSize() > 10) 
        {
            return true;
        }

        return false;
    } 

    public void pull()
    {
        if (tip == null)
        {
            tip = barrel.get(0);
            barrel.remove(0);
            
            return;
        }

        System.out.println("fail: ja existe grafite no bico");
    }

    public void insert(Lead lead)
    {
        if (lead.getThickness() != thickness)
        {
            System.out.println("fail: calibre incompatível");
            
            return;
        }
        
        barrel.add(lead);
    }

    public void remove()
    {
        if (tip != null)
        {
            tip = null;
        }
    }

    public void writePage()
    {
        if (hasGrafite() && tip.getSize() - tip.usagePerSheet() >= 10){tip.setSize(tip.getSize() - tip.usagePerSheet()); return;}
        try {
            if (tip.getSize() <= 10){System.out.println("fail: tamanho insuficiente");return;}
            if (tip.getSize() - tip.usagePerSheet()<=10){System.out.println("fail: folha incompleta");tip.setSize(10);;return;}
            System.err.println("fail: nao existe grafite no bico");
        } catch (Exception e) {
            System.err.println("fail: nao existe grafite no bico");
            return;
        }
    }
    
    public String show()
    {
        if (tip == null && barrel != null)
        {
            return "calibre: " + thickness + ", bico: []" + ", tambor: {" + barrelPrint() + "}";
        }
        if (tip == null && barrel == null)
        {
            return "calibre: " + thickness + ", bico: []" + ", tambor: {}";
        }
        if (tip != null && barrel != null)   
        {
            return "calibre: " + thickness + ", bico: " + tip.show() + ", tambor: {" + barrelPrint() + "}";
        } 

        return "calibre: " + thickness + ", bico: " + tip.show() + ", tambor: {}";
    }

    public String barrelPrint()
    {
        String print = "";
        
        for (Lead i : barrel)
        {
            print += i.show();
        }

        return print;
    }    
}