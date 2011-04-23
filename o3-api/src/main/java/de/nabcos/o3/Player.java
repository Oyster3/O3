package de.nabcos.o3;

import de.nabcos.o3.model.Song;

public interface Player {

	void play(Song song);

	void stop();

	void pause();

}
