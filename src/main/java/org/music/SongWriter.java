package org.music;

public class SongWriter {

    public static String write(Song song){

        StringBuilder sb = new StringBuilder();

        for (int i=0; i < song.notes().size(); i++){
            Integer rootNote = song.notes().get(i).get(0);
            sb.append(note(rootNote));
            Integer duration = song.duration().get(i);
            for (int j=0; j < duration - 1; j++){
                sb.append("-");
            }
        }
        return sb.toString();
    }

    private static String note(int i){
        switch (i) {
            case 0: return "a";
            case 5: return "d";
            case 10: return "g";
            default: throw new RuntimeException("Unrecognized note " + i);
        }
    }

}
