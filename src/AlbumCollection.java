import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlbumCollection
{
    public ArrayList<Album> albumArray = new ArrayList<>();

    public AlbumCollection()
    {

    }

    public void printArray(AlbumCollection albums)
    {
        sortAlbumCollection();
        for (int i = 0 ; i < albumArray.size(); i++)
        {
            System.out.println(albumArray.get(i));
        }
    }

    private void sortAlbumCollection()
    {
        Collections.sort(albumArray, new Comparator<Album>()
        {
            public int compare(final Album object1, final Album object2)
            {
                int  check = object1.getArtist().compareTo(object2.getArtist());

                if (check != 0)
                {
                    return check;
                }
                else
                {
                    return object1.getAlbumName().compareTo(object2.getAlbumName());
                }
            }
        });
    }

    public String totalOfTracks(String artistName)
    {
        Duration totalTrackDuration = new Duration();
        Album checkAlbum;

        for (int i = 0 ; i < albumArray.size(); i++)
        {
            checkAlbum = albumArray.get(i);

            if (checkAlbum.getArtist() == artistName)
            {
                for (int j = 0; j < checkAlbum.trackArray.size(); j++)
                {
                    totalTrackDuration.add(checkAlbum.trackArray.get(j).getTrackDuration());
                }
            }
        }
        return totalTrackDuration.toString();
    }
}
