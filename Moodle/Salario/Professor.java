public class Professor extends Funcionario
{
    protected String classe;
    
    Professor(String nome, String classe)
    {
        super(nome);
        this.classe = classe;
        maxDiarias = 2;
    }
    
    public String getClasse()
    {
        return classe;
    }
    
    @Override
    public int getSalario()
    {
        int extra = 100 * diarias + bonus;
        
        if (classe.equals("A"))
        {
            return 3000 + extra;
        }
        
        if (classe.equals("B"))
        {
            return 5000 + extra;
        }
        
        if (classe.equals("C"))
        {
            return 7000 + extra;
        }
        
        if (classe.equals("D"))
        {
            return 9000 + extra;
        }
        
        if (classe.equals("E"))
        {
            return 11000 + extra;
        }
        
        return -1;
    }
    
    @Override
    public String toString()
    {
        return "prof:"+nome+":"+classe+":"+getSalario();
    }
}