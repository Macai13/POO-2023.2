public class Animal 
{
    private String especie;
    private String barulho;
    private int idade;

    Animal(String especie, String barulho)
    {
        this.especie = especie;
        this.barulho = barulho;
    }

    public String fazerBarulho()
    {
        if (idade == 0)   
        {
            return "---";
        } 
        if (idade > 3)
        {
            return "RIP";
        }
        
        return barulho; 
    }

    public void envelhecer(int num)
    {
        if (idade < 4)
        {
            idade+=num;
        }

        if (idade >= 4)
        {
            System.out.println("warning: "+especie+" morreu");

            idade = 4;
        }
    }

    public String show()
    {
        return especie+":"+idade+":"+barulho;
    }
}