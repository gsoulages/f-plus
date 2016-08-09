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

            PlayerImpl player = new PlayerImpl(60, mc[0]);
            player.play(badMoonRising);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
