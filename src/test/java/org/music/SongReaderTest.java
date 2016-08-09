package org.music;

/**
 * Created by gsoulages on 8/8/16.
 */
public class SongReaderTest {

    public static void main(String... args){
        try {

            SongReader songReader = new SongReader();
            Song song = songReader.read("/home/gsoulages/dev/f-plus/songs/bad-moon-rising.txt");
            System.out.println(SongWriter.write(song));

        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
