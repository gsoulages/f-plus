package org.music;

import javax.sound.midi.MidiChannel;
import java.util.List;

/**
 * Created by gsoulages on 8/8/16.
 */
public class PlayerImpl implements Player {

    private int tempo = 60; // bpm
    private MidiChannel mc;

    public PlayerImpl(int tempo, MidiChannel mc) {
        this.tempo = tempo;
        this.mc = mc;
    }

    @Override
    public void play(Song song) throws Exception {
        List<Integer> d = song.duration();
        List<List<Integer>> n = song.notes();
        for (int i=0; i < n.size(); i++) {
            List<Integer> notes = n.get(i);
            long duration = d.get(i);
            playNotes(notes, duration);
        }
    }

    private void playNotes(List<Integer> notes, long duration) throws Exception {
        for (Integer note : notes) {
            mc.noteOn(note, 600);
        }
        Thread.sleep(duration * 1000 * 60 / tempo); // 60k ms / bpm = beat length
        for (Integer note : notes) {
            mc.noteOff(note, 600);
        }
    }
}
