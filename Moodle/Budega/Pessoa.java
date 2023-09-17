public class Pessoa 
{
    private String nome;

    Pessoa(String nome)
    {
        this.nome = nome;
    }

    public String show()
    {
        if (nome == null)
        {
            return "";
        }    
        
        return nome;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
}