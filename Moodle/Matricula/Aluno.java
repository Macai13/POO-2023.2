import java.util.*;

public class Aluno 
{
    private String id;
    private HashMap<String, Discp> discps;

    Aluno(String id)
    {
        this.id = id;
        discps = new HashMap<>();
    }

    public String getId()
    {
        return id;
    }

    public HashMap<String, Discp> getDiscps() 
    {
        return discps;
    }

    @Override
    public String toString()
    {
        return id + " " + discps.keySet();
    }

    public void addDiscp(Discp discp)
    {
        discps.put(discp.getId(), discp);
    }

    public void rmDiscp(String idDiscp)
    {
        discps.remove(idDiscp);
    }
}
