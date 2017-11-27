import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlbumCollection
{
    //Instance variable for the list of albums
    public ArrayList<Album> albumArray = new ArrayList<>();

    //No input constructor
    public AlbumCollection(){}

    //Method that prints the album collection
    public void printArray(AlbumCollection albums)
    {
        sortAlbumCollection();
        for (int i = 0 ; i < albumArray.size(); i++)
        {
            System.out.println(albumArray.get(i));
        }
    }

    //Method used for sorting albums
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

    //Method used for outputting total duration of all tracks in the album collection
    public String totalOfTracks(String artistName)
    {
        Duration totalTrackDuration = new Duration();
        Album checkAlbum;

        for (int i = 0 ; i < albumArray.size(); i++)
        {
            checkAlbum = albumArray.get(i);

            if (checkAlbum.getArtist().equals(artistName))
            {
                for (int j = 0; j < checkAlbum.trackArray.size(); j++)
                {
                    totalTrackDuration.add(checkAlbum.trackArray.get(j).getTrackDuration());
                }
            }
        }
        return totalTrackDuration.toString();
    }

    //Method used for outputting the album with the most tracks
    public String mostTracks()
    {
        String most = albumArray.get(0).toString();
        int count = albumArray.get(0).getNumberOfTracks();

        for (int i = 1 ; i < albumArray.size(); i++)
        {
            if (albumArray.get(i).getNumberOfTracks() > count)
            {
                most = albumArray.get(i).toString();
                count = albumArray.get(i).getNumberOfTracks();
            }
        }
        return most;
    }

    //Method used for showing the number of tracks in an album (used for checking mostTracks())
    public void numberOfTracks()
    {
        for (int i = 0 ; i < albumArray.size(); i++)
        {
            System.out.println(albumArray.get(i).toString());
            System.out.println(albumArray.get(i).getNumberOfTracks());
        }
    }

    //Method used for outputting the longest track in the album collection
    public void longestTrack()
    {
        Track longest = new Track();

        for (int i = 1 ; i < albumArray.size(); i++)
        {
            for (int j = 1; j < albumArray.get(i).trackArray.size(); j++)
            {
                if (compareTrackLarger(longest, albumArray.get(i).trackArray.get(j)))
                {
                    longest = albumArray.get(i).trackArray.get(j);
                }
            }
        }
        System.out.println(longest);
    }

    //Method used for checking if the duration of track b is larger than track a
    private Boolean compareTrackLarger(Track a, Track b)
    {
        Duration aDuration = a.getTrackDuration();
        Duration bDuration = b.getTrackDuration();

        int aTotalSeconds = aDuration.getSeconds() + (aDuration.getMinutes() * 60) + (aDuration.getHours() * 60 * 60);
        int bTotalSeconds = bDuration.getSeconds() + (bDuration.getMinutes() * 60) + (bDuration.getHours() * 60 * 60);

        if (bTotalSeconds > aTotalSeconds)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
