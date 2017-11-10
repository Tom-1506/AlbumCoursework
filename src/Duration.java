import java.text.DecimalFormat;

public class Duration
{
    private int hours;
    private int minutes;
    private int seconds;

    private DecimalFormat display = new DecimalFormat("00");

    private Duration()
    {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    private Duration(int inHours, int inMinutes, int inSeconds)
    {
        hours = inHours;
        minutes = inMinutes;
        seconds = inSeconds;
    }

    private Duration(String time)
    {
        String timeArray[] = time.split(":");
        hours = Integer.parseInt(timeArray[0]);
        minutes = Integer.parseInt(timeArray[1]);
        seconds = Integer.parseInt(timeArray[2]);
    }

    public String add (Duration d2)
    {
        hours = hours + d2.hours;
        minutes = minutes + d2.minutes;
        seconds = seconds + d2.seconds;

        return addFormat();
    }

    private String addFormat()
    {
        seconds = seconds + (minutes * 60) + (hours * 60 * 60);

        if (seconds > 0)
        {
            minutes = seconds / 60;
            seconds = seconds % 60;
            hours = minutes / 60;
            minutes = minutes % 60;
        }
        else
        {
            seconds = 0;
            minutes = 0;
            hours = 0;
        }

        return this.toString();
    }

    public String toString()
    {
        return(display.format(hours) + ":" + display.format(minutes) + ":" + display.format(seconds));
    }

    public int getHours()
    {
        return hours;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int getSeconds()
    {
        return seconds;
    }
}
