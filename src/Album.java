public class Album
{
    private String artist = new String();
    private String albumName = new String();
    private Track trackArray[] = new Track[] {};

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
}
