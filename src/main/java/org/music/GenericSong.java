package org.music;

import java.util.List;

/**
 * Created by gsoulages on 8/8/16.
 */
public class GenericSong implements Song {

    List<List<Integer>> notes;
    List<Integer> duration;

    public GenericSong(List<List<Integer>> notes, List<Integer> duration) {
        this.notes = notes;
        this.duration = duration;
    }

    @Override
    public List<List<Integer>> notes() {
        return notes;
    }

    @Override
    public List<Integer> duration() {
        return duration;
    }
}
