public class Track
{
    private String trackName;
    private Duration trackDuration = new Duration();

    public Track()
    {
        trackName = ("");
        trackDuration = new Duration("00:00:00");
    }

    public Track(String inTime, String inTrackName)
    {
        trackName = inTrackName;
        trackDuration = new Duration(inTime);
    }

    public String toString()
    {
        return (trackDuration + " - " + trackName);
    }
}
