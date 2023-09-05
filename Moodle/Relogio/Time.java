public class Time 
{
    private int hour;
    private int minute;
    private int second;

    Time(int hour, int minute, int second)
    {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public void show()
    {
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
        
    }

    public void nextSecond()
    {
        if (second == 59)
        {
            second = 0;
            if (minute == 59)
            {
                minute = 0;
                if (hour == 23)
                {
                    hour = 0;
                    return;
                }
                hour++;
                return;
            }
            minute++;
            return;
        }
        second++;
    }

    public int getHour() { return hour; }
    public void setHour(int hour) 
    {
        if (hour >= 0 && hour <= 23)
        {
            this.hour = hour;
            return;
        }
        System.out.println("fail: hora invalida");
    }
    public int getMinute() { return minute; }
    public void setMinute(int minute) 
    {
        if (minute >= 0 && minute <= 59)
        {
            this.minute = minute;
            return;
        }
        System.out.println("fail: minuto invalido");
    }
    public int getSecond() { return second; }
    public void setSecond(int second) 
    {
        if (second >= 0 && second <= 59)
        {
            this.second = second;
            return;
        }
        System.out.println("fail: segundo invalido");
    }
}