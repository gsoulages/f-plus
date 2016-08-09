package org.music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.music.Note.*;

/**
 * Created by gsoulages on 8/4/16.
 */
public class BadMoonRising implements Song {

    List<List<Integer>> allNotes;
    Chord chord = new Chord();

    public BadMoonRising() {
        List<Integer> d = chord.majorChord(D);
        List<Integer> a = chord.majorChord(A);
        List<Integer> g = chord.majorChord(G);
        allNotes = Arrays.asList(d, d, a, g, d, d);
        allNotes = allNotes.stream()
                .map(l -> l.stream().map(i -> i + 57).collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(allNotes);
    }

    @Override
    public List<List<Integer>> notes() {
        return allNotes;
    }

    @Override
    public List<Integer> duration() {
        return Arrays.asList(1, 3, 2, 2, 1, 3);
    }

    private List<List<Integer>> copy(List<List<Integer>> a, int numCopies){
        List<List<Integer>> output = new ArrayList<>(a);
        for(int i=0; i < numCopies - 1; i++){
            ArrayList<List<Integer>> copy = new ArrayList<>(a);
            output.addAll(copy);
        }
        return output;
    }
}
