import java.text.DecimalFormat;

public class Duration
{
    //Instance variables for hours, minutes and seconds
    private int hours;
    private int minutes;
    private int seconds;

    //Create format for displaying the duration correctly
    private DecimalFormat display = new DecimalFormat("00");

    //No input constructor
    public Duration()
    {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    //Constructor that takes integers
    public Duration(int inHours, int inMinutes, int inSeconds)
    {
        hours = inHours;
        minutes = inMinutes;
        seconds = inSeconds;
    }

    //Constructor that takes a string
    public Duration(String time)
    {
        String timeArray[] = time.split(":");
        hours = Integer.parseInt(timeArray[0]);
        minutes = Integer.parseInt(timeArray[1]);
        seconds = Integer.parseInt(timeArray[2]);
    }

    //Adds durations
    public String add (Duration d2)
    {
        hours = hours + d2.hours;
        minutes = minutes + d2.minutes;
        seconds = seconds + d2.seconds;

        return addFormat();
    }

    //Formats the added duration so that counters don't go over 59 seconds or minutes
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


    //toString override for use in other methods
    public String toString()
    {
        return(display.format(hours) + ":" + display.format(minutes) + ":" + display.format(seconds));
    }

    //Return method for returning the hours in a duration object
    public int getHours()
    {
        return hours;
    }

    //Return method for returning the minutes in a duration object
    public int getMinutes()
    {
        return minutes;
    }

    //Return method for returning the seconds in a duration object
    public int getSeconds()
    {
        return seconds;
    }
}
