import java.util.*;
import java.util.Map.Entry;

public class Sistema 
{
    private HashMap<String, Discp> discps;
    private HashMap<String, Aluno> alunos;

    Sistema()
    {
        discps = new HashMap<>();
        alunos = new HashMap<>();
    }

    @Override
    public String toString()
    {
        return showAlunos() + "\n" + showDiscp();
    }

    private String showAlunos()
    {
        String str = "- alunos";
        
        for (Entry<String, Aluno> pair : alunos.entrySet()) 
        {
            str += "\n" + pair.getValue();
        }

        return str;
    }

    private String showDiscp()
    {
        String str = "- discps";
        
        for (Entry<String, Discp> pair : discps.entrySet()) 
        {
            str += "\n" + pair.getValue();
        }

        return str;
    }

    public void addAluno(String id)
    {
        alunos.put(id, new Aluno(id));
    }

    public void addDiscp(String id)
    {
        discps.put(id, new Discp(id));
    }

    public HashMap<String, Aluno> getAlunos() 
    {
        return alunos;
    }

    public HashMap<String, Discp> getDiscps() 
    {
        return discps;
    }

    public void matricular(String idAluno, String idDiscp)
    {
        alunos.get(idAluno).addDiscp(new Discp(idDiscp));
        discps.get(idDiscp).addAluno(new Aluno(idAluno));
    }

    public void desmatricular(String idAluno, Set<String> keys)
    {
        for (String idDiscp : keys)
        {
            System.out.println(alunos.get(idAluno));
            alunos.get(idAluno).rmDiscp(idDiscp);
            discps.get(idDiscp).rmAluno(idAluno);
        }
    }

    public void desmatricular(Set<String> keys, String idDiscp)
    {
        for (String idAluno : keys)
        {
            System.out.println(alunos.get(idAluno));
            alunos.get(idAluno).rmDiscp(idDiscp);
            discps.get(idDiscp).rmAluno(idAluno);
        }
    }

    public void desmatricular(String idAluno, String idDiscp)
    {
        alunos.get(idAluno).rmDiscp(idDiscp);
        discps.get(idDiscp).rmAluno(idAluno);
    }

    public void removerAluno(String id)
    {        
        try 
        {
            desmatricular(id, discps.keySet());
        } 
        
        catch (NullPointerException e) 
        {
            System.out.println(e.getMessage());
        }

        alunos.remove(id);
    }

    public void removerDiscp(String id)
    {
        desmatricular(discps.get(id).getAlunos().keySet(), id);

        discps.remove(id);
    }
}
