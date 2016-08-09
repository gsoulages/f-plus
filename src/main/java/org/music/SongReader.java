package org.music;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by gsoulages on 8/8/16.
 */
public class SongReader {

    public Song read(String file) throws Exception {
        List<List<Integer>> chords = new ArrayList();
        List<Integer> duration = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get(file));
        for(String line : lines){
            Iterator<Wrapper> wrapperIterator = toIterator(line.toCharArray());
            while(wrapperIterator.hasNext()){
                Wrapper chord = wrapperIterator.next();
                chords.add(chord.chords);
                duration.add(chord.duration);
            }
        }
        return new GenericSong(chords, duration);
    }

    Iterator<Wrapper> toIterator(char[] chars){
        return new Iterator<Wrapper>() {
            char[] cars = chars;
            int i = 0;
            char c = '-';
            @Override
            public boolean hasNext() {
                return i < cars.length;
            }

            @Override
            public Wrapper next() {
                int duration = 1;
                char root = cars[i];
                i++;
                while(i < cars.length && cars[i] == '-'){
                    duration += 1;
                    i++;
                }
                List<Integer> chord = getChord(root);
                return new Wrapper(chord, duration);
            }
        };
    }

    List<Integer> getChord(Character c){
        Chord chord = new Chord();
        switch (c) {
            case 'a': return chord.majorChord(Note.A);
            case 'd': return chord.majorChord(Note.D);
            case 'g': return chord.majorChord(Note.G);
            default: throw new RuntimeException("Couldn't find char" + c);
        }
    }

    private class Wrapper {
        List<Integer> chords;
        Integer duration;

        Wrapper(List<Integer> chords, Integer duration) {
            this.chords = chords;
            this.duration = duration;
        }
    }
}
