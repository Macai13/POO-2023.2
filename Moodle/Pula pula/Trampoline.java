import java.util.*;

public class Trampoline
{
    private ArrayList<Kid> kidsPlaying = new ArrayList<>();
    private ArrayList<Kid> kidsWaiting = new ArrayList<>();

    private void removeKid(String name)
    {
        for (Kid i : kidsPlaying)
        {
            if (i.getName().equals(name))
            {
                kidsPlaying.remove(i);
            } 
        }

        for (Kid i : kidsWaiting)
        {
            if (i.getName().equals(name))
            {
                kidsWaiting.remove(i);
            } 
        }
    }

    public String show()
    {
        if (kidsPlaying != null && kidsWaiting != null)
        {
            return "[" + showFor(kidsWaiting) + "] => [" + showFor(kidsPlaying) + "]";
        }
        if (kidsPlaying != null && kidsWaiting == null)
        {
            return "[] => [" + showFor(kidsPlaying) + "]";
        }
        if (kidsPlaying == null && kidsWaiting != null)
        {
            return "[" + showFor(kidsWaiting) + "] => []";
        }

        return "[] => []";

    }

    private String showFor(ArrayList<Kid> kids)
    {
        String list = "";

        for (Kid i : kids)
        {
            list += i.show();
            if (!kids.get(kids.size() - 1).equals(i))
            {
                list += ", ";
            }
        }

        return list;
    }

    public void remove(String name)
    {
        try 
        {
            removeKid(name);
        } 
        catch (Exception e) 
        {
            return;
        }
    }

    public void arrive(Kid kid)
    {
        kidsWaiting.add(0, kid);
    }

    public void enter()
    {
        try 
        {
            Kid firstKid = kidsWaiting.get(kidsWaiting.size() - 1);
            
            kidsPlaying.add(0, firstKid);
            kidsWaiting.remove(firstKid);
        } 
        catch (Exception e) 
        {
            return;
        }
    }

    public void leave()
    {
        try 
        {
            Kid firstKid = kidsPlaying.get(kidsPlaying.size() - 1);

            kidsWaiting.add(0, firstKid);
            kidsPlaying.remove(firstKid);
        } 
        catch (Exception e) 
        {
            return;
        }
    }
}