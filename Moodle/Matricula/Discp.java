import java.util.*;

public class Discp 
{
    private String id;
    private HashMap<String, Aluno> alunos;

    Discp(String id)
    {
        this.id = id;
        alunos = new HashMap<>();
    }

    public HashMap<String, Aluno> getAlunos() 
    {
        return alunos;
    }

    public String getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return id + " " + alunos.keySet();
    }

    public void addAluno(Aluno aluno)
    {
        alunos.put(aluno.getId(), aluno);
    }

    public void rmAluno(String id)
    {
        alunos.remove(id);
    }
}
