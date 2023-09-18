public class Client
{
    private String fone;
    private String id;

    Client(String id, String fone)
    {
        this.id = id;
        this.fone = fone;
    }

    public String show()
    {
        String str = id;

        if (fone != null)
        {
            str += ":" + fone;
        }
        
        return str;
    }

    public String getFone() 
    {
        return fone;
    }

    public String getId() 
    {
        return id;
    }

    public void setFone(String fone) 
    {
        this.fone = fone;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
