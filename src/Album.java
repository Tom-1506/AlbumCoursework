import java.util.ArrayList;

public class Album
{
    //Instance variables for the artist name, album name and list of tracks on the album
    private String artist;
    private String albumName;
    public ArrayList<Track> trackArray = new ArrayList<>();

    //No input constructor
    public Album()
    {
        artist = ("");
        albumName = ("");
    }

    //Constructor that takes in the artist name and album name as strings
    public Album(String inArtist, String inAlbumName)
    {
        artist = inArtist;
        albumName = inAlbumName;
    }

    //Return method for returning the number of tracks in this album
    public int getNumberOfTracks()
    {
        int count = 0;

        for (Track track : trackArray)
        {
            count += 1;
        }

        return count;
    }

    //toString override for use in other methods
    public String toString()
    {
        return (artist + " : " + albumName);
    }

    //Return method for returning the album artist
    public String getArtist()
    {
        return this.artist;
    }

    //Return method for returning the album name
    public String getAlbumName()
    {
        return this.albumName;
    }
}
