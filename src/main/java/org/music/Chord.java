package org.music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.music.Note.*;

public class Chord {
    public static final float HALF_STEP = 0.5f;
    public static final float WHOLE_STEP = 1.0f;

    // calculate note numbers from root node

    // major/minor/dim/4th chord

    /*
    a  half
    a# half
    b  whole
    c  half
    c# half
    d  half
    d# half
    e  whole
    f  half
    f# half
    g  half
    g# half
    a
    */

    // major scale
    int[] notes = new int[]    {A,         A_SHARP,   B,          C,         C_SHARP,   D,         D_SHARP,   E,         F,          F_SHARP,   G,         G_SHARP};
    float[] steps = new float[]{HALF_STEP, HALF_STEP, WHOLE_STEP, HALF_STEP, HALF_STEP, HALF_STEP, HALF_STEP, HALF_STEP, WHOLE_STEP, HALF_STEP, HALF_STEP, HALF_STEP};

    public List<Integer> majorScale(int root){
        int position = root;
        // whole step, whole step, half step, whole step, whole step, whole step, half step
        List<Float> intervals = Arrays.asList(1.0f, 1.0f, 0.5f, 1.0f, 1.0f, 1.0f, 0.5f);
        List<Integer> scale = new ArrayList<>();
        float sum = 0.0f;
        for (Float interval : intervals) {
            while (sum < interval) {
                sum += steps[position];
                position = next(position);
            }
            scale.add(notes[position]);
            sum = 0f;
        }
        return scale;
    }

    public List<Integer> majorChord(int root){
        List<Integer> notes = Arrays.asList(0, 2, 4);
        List<Integer> majorScale = majorScale(root);
        List<Integer> output = new ArrayList();
        for (int note : notes){
            output.add(majorScale.get(note));
        }
        return output;
    }

    private int next(int i){
        if (i == 11)
            return 0;
        else
            return i + 1;
    }
}
