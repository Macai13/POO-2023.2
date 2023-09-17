public class Car 
{
    private int pass, passMax = 2;
    private int gas, gasMax = 100;
    private int km;

    public String show()
    {
        return "pass: " + pass + ", gas: " +
        gas + ", km: " + km;
    }

    public void enter()
    {
        if (pass < passMax) { pass++; }
        else { System.out.println("fail: limite de pessoas atingido"); }
    }

    public void leave()
    {
        if (pass > 0) { pass--; }
        else { System.out.println("fail: nao ha ninguem no carro"); }
    }

    public void drive(int value)
    {
        if (gas > 0) 
        {
            if (pass > 0) 
            {
                int gasTemp = gas;
                gas-= value; km+= value; 
                if (gas < 0)
                {
                    System.out.println("fail: tanque vazio apos andar "+gasTemp+" km");
                    km += gas;
                    gas = 0;
                }
            }
            else { System.out.println("fail: nao ha ninguem no carro"); } 
            
        }
        else { System.out.println("fail: tanque vazio"); } 
    }

    public void fuel(int value)
    {
        if (gas < gasMax) 
        {
            gas += value; 
            if (gas > gasMax) { gas = gasMax; }
        }
        else { System.out.println("fail: tanque cheio");}
    }
}
