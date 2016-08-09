package org.music;

import javax.sound.midi.*;
import java.util.List;
import java.util.stream.Collectors;

public class synth {

    public static final int TEMPO = 180;

    public static void main(String[] args) {
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            MidiChannel[] mc = synthesizer.getChannels();
            Instrument[] instruments = synthesizer.getDefaultSoundbank().getInstruments();

            synthesizer.loadInstrument(instruments[90]);

            SongReader songReader = new SongReader();
            Song badMoonRising = songReader.read("/home/gsoulages/dev/f-plus/songs/bad-moon-rising.txt");

            List<List<Integer>> audibleNotes = badMoonRising.notes().stream()
                    .map(l -> l.stream().map(i -> i + 57).collect(Collectors.toList()))
                    .collect(Collectors.toList());

            GenericSong audibleSong = new GenericSong(audibleNotes, badMoonRising.duration());

            PlayerImpl player = new PlayerImpl(TEMPO, mc[0]);
            player.play(audibleSong);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
