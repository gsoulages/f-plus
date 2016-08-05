package org.music;

import javax.sound.midi.*;
import java.util.List;

public class synth {

    public static final int NOTE_LENGTH = 500;

    public static void main(String[] args) {
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            MidiChannel[] mc = synthesizer.getChannels();
            Instrument[] instruments = synthesizer.getDefaultSoundbank().getInstruments();

            synthesizer.loadInstrument(instruments[90]);

            Song badMoonRising = new BadMoonRising();

            play(badMoonRising, mc[0]);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static void play(Song song, MidiChannel mc) throws Exception {
        int dur = 0;
        int repeat = 5;
        while (repeat > 0){
            for (List<Integer> notes : song.notes()) {
                for (Integer note : notes) {
                    mc.noteOn(note, 600);
                }
                Thread.sleep(NOTE_LENGTH * song.duration().get(dur));
                for (Integer note : notes) {
                    mc.noteOff(note, 600);
                }
                dur++;
            }
            dur = 0;
            repeat--;
        }
    }
}
