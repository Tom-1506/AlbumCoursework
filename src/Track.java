public class Track
{
    private String trackName = new String();
    private Duration trackDuration = new Duration();

    public Track()
    {
        trackName = ("");
        Duration trackDuration = new Duration("00:00:00");
    }

    public Track(String inTrackName, String time)
    {
        trackName = inTrackName;
        Duration trackDuration = new Duration(time);
    }
}
