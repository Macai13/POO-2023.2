public class Kid 
{
    private int age;
    private String name;

    Kid(String name, int age)
    {
        this.name = name;
        setAge(age);
    }

    public String show()
    {
        return name + ":" + age;
    }

    public int getAge() 
    {
        return age;
    }

    public String getName() 
    {
        return name;
    }

    public void setAge(int age) {
        if (age < 0)
        {
            this.age = 0;

            return;
        }
        this.age = age;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
}