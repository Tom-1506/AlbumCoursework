import java.util.ArrayList;

public class Album
{
    private String artist;
    private String albumName;
    public ArrayList<Track> trackArray = new ArrayList<>();

    public Album()
    {
        artist = ("");
        albumName = ("");
    }

    public Album(String inArtist, String inAlbumName)
    {
        artist = inArtist;
        albumName = inAlbumName;
    }

    public String toString()
    {
        return (artist + " : " + albumName);
    }

    public String getArtist()
    {
        return this.artist;
    }

    public String getAlbumName()
    {
        return this.albumName;
    }
}
