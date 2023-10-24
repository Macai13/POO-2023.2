public abstract class Funcionario
{
    protected int bonus;
    protected int diarias = 0;
    protected int maxDiarias;
    protected String nome;
    
    Funcionario(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void addDiaria() throws Exception
    {
        if (maxDiarias > diarias)
        {
            diarias++;
            
            return;
        }
        
        throw new Exception("fail: limite de diarias atingido");
    }
    
    public abstract int getSalario();
    
    public void setBonus(int bonus)
    {
        this.bonus = bonus;
    }
}