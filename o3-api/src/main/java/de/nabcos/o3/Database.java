package de.nabcos.o3;

import java.util.Collection;
import java.util.List;

import de.nabcos.o3.model.Song;

public interface Database {

	List<Song> getSongs();

	List<Song> getSongs(Order order);

	List<Song> filterSongs(String term);

	List<Song> filterSongs(String term, Order order);

	void addSongs(Collection<Song> songs);

	void addSong(Song song);
}
