public class Pass 
{
    private int age;
    private String name;

    Pass(String name, int age)
    {
        this.age = age;
        this.name = name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getName() 
    {
        return name;
    }

    /*public boolean isPriority()
    {

    }*/

    public void setAge(int age) 
    {
        this.age = age;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String show()
    {
        if (age == 0)
        {
            return name;
        }

        return name + ":" + age;
    }
}