public class Pencil 
{
    private float thickness;
    private Lead tip;

    Pencil(float thickness)
    {
        this.thickness = thickness;
    }

    public boolean hasGrafite()
    {
        if (tip == null) {return false;}
        if (tip.getSize() > 10) {return true;}
        return false;
    } 

    public void insert(Lead lead)
    {
        if (tip != null)
        {
            System.out.println("fail: ja existe grafite");
            return;
        }
        if (lead.getThickness() == thickness)
        {
            tip = lead;
            return;
        }
        System.out.println("fail: calibre incompativel");
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
            System.err.println("fail: nao existe grafite");
        } catch (Exception e) {
            System.err.println("fail: nao existe grafite");
            return;
        }
    }
    
    public String show()
    {
        if (tip != null)
        {
            return "calibre: " + thickness + ", grafite: " +
                tip.show();
        }
        return "calibre: " + thickness + ", grafite: null";
    }
}
