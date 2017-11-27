public class Track
{
    //Instance variables for name and duration of the track
    private String trackName;
    private Duration trackDuration;

    //No input constructor
    public Track()
    {
        trackName = ("");
        trackDuration = new Duration("00:00:00");
    }

    //Constructor that takes the duration and track name as strings
    public Track(String inTime, String inTrackName)
    {
        trackName = inTrackName;
        trackDuration = new Duration(inTime);
    }

    //toString override for use in other methods
    public String toString()
    {
        return (trackDuration + " - " + trackName);
    }

    //Return method for returning duration of the track
    public Duration getTrackDuration()
    {
        return trackDuration;
    }

    //Return method for returning the name of the track
    public String getTrackName()
    {
        return trackName;
    }
}
