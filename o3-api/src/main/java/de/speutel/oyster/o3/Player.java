package de.speutel.oyster.o3;

import de.speutel.oyster.o3.model.Song;

public interface Player {

	void play(Song song);

	void stop();

	void pause();

}
