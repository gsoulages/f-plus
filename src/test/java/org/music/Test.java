package org.music;

import java.util.List;

import static org.music.Note.*;

/**
 * Created by gsoulages on 8/4/16.
 */
public class Test {

    public static void main(String... args){

        Chord chord = new Chord();

        List<Integer> aScale = chord.majorScale(A);
        List<Integer> aChord = chord.majorChord(A);

        System.out.println(aScale);
        System.out.println(aChord);

    }
}
