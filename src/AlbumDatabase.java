import java.io.*;

public class AlbumDatabase
{
    private static AlbumCollection newAlbumCollection = new AlbumCollection();
    private static Album newAlbum = new Album();

    private static void DBRead()
    {
        String fileName = "albumCollection.txt";

        String line;

        try
        {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null)
            {
                if (Character.isLetter(line.charAt(0)))
                {
                    String[] inAlbum = line.split(" : ");
                    String inArtist = inAlbum[0];
                    String inAlbumName = inAlbum[1];

                    newAlbum = new Album(inArtist, inAlbumName);
                    newAlbumCollection.albumArray.add(newAlbum);
                }
                else if (Character.isDigit(line.charAt(0)))
                {
                    String[] inTrack = line.split(" - ");
                    String inTime = inTrack[0];
                    String inTrackName = inTrack[1];

                    Track newTrack = new Track(inTime, inTrackName);
                    newAlbum.trackArray.add(newTrack);
                }
            }

            bufferedReader.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch (IOException ex)
        {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public static void main(String[] args)
    {
        DBRead();
        //newAlbumCollection.printArray(newAlbumCollection);
        //System.out.println(newAlbumCollection.totalOfTracks("Pink Floyd"));
        newAlbumCollection.numberOfTracks();
        System.out.println(newAlbumCollection.mostTracks());
    }
}
