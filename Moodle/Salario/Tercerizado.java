public class Tercerizado extends Funcionario
{
    protected int horas;
    protected String isSalubre;
    
    Tercerizado(String nome, int horas, String isSalubre)
    {
        super(nome);
        this.horas = horas;
        this.isSalubre = isSalubre;
    }
    
    @Override
    public int getSalario()
    {
        int acr = 0;
        
        if (isSalubre.equals("sim"))
        {
            acr = 500;
        }
        
        return 4 * horas + acr + bonus;
    }
    
    @Override
    public void addDiaria() throws Exception
    {
        throw new Exception("fail: terc nao pode receber diaria");
    }
    
    @Override
    public String toString()
    {
        return "ter:"+nome+":"+horas+":"+isSalubre+":"+getSalario();
    }
}