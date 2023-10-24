import java.util.*;

public class UFC
{
    private ArrayList<Funcionario> funcionarios;
    
    UFC()
    {
        funcionarios = new ArrayList<>();
    }
    
    public void addFuncionario(Funcionario funcionario)
    {
        funcionarios.add(funcionario);
    }
    
    public Funcionario getFuncionario(String nome)
    {
        return null;
    }
    
    public void rmFuncionario(String nome)
    {
        for (Funcionario i : funcionarios)
        {
            if (i.getNome().equals(nome))
            {
                funcionarios.remove(i);
                
                break;
            }
        }
    }
    
    public void setBonus(int bonus)
    {
        for (Funcionario i : funcionarios)
        {
            funcionarios.get(funcionarios.indexOf(i)).setBonus(bonus / funcionarios.size());
        }
    }
    
    public void addDiaria(String nome) throws Exception
    {
        for (Funcionario i : funcionarios)
        {
            if (i.getNome().equals(nome))
            {
                funcionarios.get(funcionarios.indexOf(i)).addDiaria();
            }
        }
    }
    
    @Override
    public String toString()
    {
        String str = "";
        
        for (Funcionario i : funcionarios)
        {
            str += i;
            
            if (!funcionarios.get(funcionarios.size() - 1).equals(i))
            {
                str += "\n";
            }
        }
        
        return str;
    }
    
    public Funcionario showIndiv(String nome)
    {
        for (Funcionario i : funcionarios)
        {
            if (i.getNome().equals(nome))
            {
                return i;
            }
        }
        
        return null;
    }
}