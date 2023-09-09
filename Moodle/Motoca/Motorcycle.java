public class Motorcycle 
{
    private Person person;
    private int power;
    private int time;

    Motorcycle(int power)
    {
        this.power = power;
    }

    public void insertPerson(Person person)
    {
        if (this.person == null)
        {
            this.person = person;
            
            return;
        }
        
        System.out.println("fail: busy motorcycle");
    }

    public void remove()
    {
        if (person != null)
        {
            System.out.println(person.getName() + ":" + person.getAge());
            
            person = null;

            return;
        }
        
        System.out.println("fail: empty motorcycle");
    }

    public void buyTime(int time)
    {
        this.time += time;
    }

    public void drive(int drive)
    {
        if (time == 0)
        {
            System.out.println("fail: buy time first");
            return;
        }
        
        if (person == null)
        {
            System.out.println("fail: empty motorcycle");
            return;
        }
        
        if (person.getAge() > 10)
        {
            System.out.println("fail: too old to drive");
            return;
        }

        time -= drive;

        if (time < 0)
        {
            int timeFinish = time + drive;
            System.out.println("fail: time finished after "+timeFinish+" minutes");
            time = 0;
        }
    }

    public void honk()
    {
        String honk = "P";

        for (int i = 0; i < power; i++)
        {
            honk = honk + "e";
        }

        honk = honk + "m";

        System.out.println(honk);
    }

    public Person getPerson() 
    {
        return person;
    }

    public int getPower() 
    {
        return power;
    }

    public int getTime() 
    {
        return time;
    }

    public String show()
    {
        if (person != null)
        {
            return "power:" + power + ", time:" + time + ", person:" + person.show();
        }
        
        return "power:" + power + ", time:" + time + ", person:(empty)";
    }
}