class Pet 
{
    //private boolean alive;
    private int clean;
    private int cleanMax;
    private int energy;
    private int energyMax;
    private int hungry;
    private int hungryMax;
    private int age;
    private int diamonds;

    private boolean testAlive()
    {       
        if (energy <= 0 || hungry <= 0 || clean <= 0)
        {
            return false;
        }
        return true;
    }

    Pet(int energyMax, int hungryMax, int cleanMax)
    {
        this.energyMax = energyMax;
        this.hungryMax = hungryMax;
        this.cleanMax = cleanMax;
        this.energy = energyMax;
        this.hungry = hungryMax;
        this.clean = cleanMax;
    }

    public String show()
    {
        return "E:" + energy + "/" + energyMax + ", S:" + hungry + "/" + hungryMax + ", L:"
        + clean + "/" + cleanMax +", D:" + diamonds + ", I:" + age;
    }
    
    public void eat()
    {
        if (testAlive())
        {
            if (hungry <= hungryMax)
            {
                energy--;
                hungry+=4;
                clean-=2;
                age++;
                if (hungry > hungryMax) {hungry = hungryMax;}
            }
            if (!testAlive())
            {
                System.out.println("fail: pet morreu de sujeira");
            }
            return;
        }
        System.out.println("fail: pet esta morto");
    }

    public void play()
    {
        if (testAlive())
        {
            if (energy > 0)
            {
                energy-=2;
                hungry--;
                clean-=3;
                age++;
                diamonds++;
                if (energy < 0) { energy = 0; }
            }
            if (!testAlive())
            {
                if (clean == 0)
                {
                    System.out.println("fail: pet morreu de sujeira");
                }
                else if (energy == 0)
                {
                    System.out.println("fail: pet morreu de fraqueza");
                }
                else
                {
                    System.out.println("fail: pet morreu de fome");
                }
            }
            return;
        }
        System.out.println("fail: pet esta morto");
    }

    public void shower()
    {
        if (testAlive())
        {
            if (clean < cleanMax)
            {
                energy-=3;
                hungry--;
                clean = cleanMax;
                age+=2;
            }
            if (!testAlive())
            {
                System.out.println("fail: pet morreu de fraqueza");
            }
            return;
        }
        System.out.println("fail: pet esta morto");
    }

    public void sleep()
    {
        if (testAlive() && energy >= 5 && energy < energyMax - 3)
        {
            energy = energyMax;
            hungry--;
            age+=5;
            if (!testAlive())
            {
                System.out.println("fail: pet morreu de fome");
            }
            return;
        }
        if (!testAlive()) { System.out.println("fail: pet esta morto"); return; }
        System.out.println("fail: nao esta com sono");

    }

    public int getClean() {
        return clean;
    }public int getCleanMax() {
        return cleanMax;
    }public int getEnergy() {
        return energy;
    }public int getEnergyMax() {
        return energyMax;
    }public int getHungry() {
        return hungry;
    }public int getHungryMax() {
        return hungryMax;
    }public void setClean(int clean) {
        this.clean = clean;
    }public void setEnergy(int energy) {
        this.energy = energy;
    }public void setHungry(int hungry) {
        this.hungry = hungry;
    }
}
