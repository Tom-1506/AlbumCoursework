import java.io.*;

public class AlbumDatabase
{
    //Instance variables for a new album collection and a new album
    private static AlbumCollection newAlbumCollection = new AlbumCollection();
    private static Album newAlbum = new Album();

    //Method used for reading in the album collection from a text file
    private static void DBRead()
    {
        String fileName = "albumCollection.txt";

        String line;

        //Try catch for catching exceptions
        try
        {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null)
            {
                //Check if the first character in the line is a letter
                if (Character.isLetter(line.charAt(0)))
                {
                    String[] inAlbum = line.split(" : ");
                    String inArtist = inAlbum[0];
                    String inAlbumName = inAlbum[1];

                    newAlbum = new Album(inArtist, inAlbumName);
                    newAlbumCollection.albumArray.add(newAlbum);
                }
                //Check if the first character in the line is a number
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

    //Main method carries out all required operations
    public static void main(String[] args)
    {
        DBRead();
        System.out.println("Sorted Album Collection:");
        newAlbumCollection.printArray(newAlbumCollection);
        System.out.println("\nTotal of Pink Floyd Tracks:");
        System.out.println(newAlbumCollection.totalOfTracks("Pink Floyd"));
        System.out.println("\nAlbum With Most Tracks:");
        System.out.println(newAlbumCollection.mostTracks());
        System.out.println("\nDetails of Longest Track:");
        newAlbumCollection.longestTrack();
    }
}
