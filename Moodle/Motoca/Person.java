public class Person 
{
    private int age;
    private String name;

    Person(String name, int age)
    {
        this.name = name;
        if (age >= 0)
        {
            this.age = age;
            
            return;
        }
        
        this.age = 0;
    }

    public int getAge() 
    {
        return age;
    }

    public String getName() 
    {
        return name;
    }

    public String show()
    {
        return "("+name+":"+age+")";
    }
}
