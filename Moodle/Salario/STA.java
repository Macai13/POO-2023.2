public class STA extends Funcionario
{
    protected int nivel;
    
    STA(String nome, int nivel)
    {
        super(nome);
        this.nivel = nivel;
        maxDiarias = 1;
    }
    
    public int getNivel()
    {
        return nivel;
    }
    
    @Override
    public int getSalario()
    {
        return 3000 + 300 * nivel + 100 * diarias + bonus;
    }
    
    @Override
    public String toString()
    {
        return "sta:"+nome+":"+nivel+":"+getSalario();
    }
}