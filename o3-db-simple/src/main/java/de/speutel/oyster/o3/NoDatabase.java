package de.speutel.oyster.o3;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import de.speutel.oyster.o3.Database;
import de.speutel.oyster.o3.Order;
import de.speutel.oyster.o3.model.Song;

@Named
@Singleton
public class NoDatabase implements Database {

	private List<Song> songs = new LinkedList<Song>();

	@Inject
	public NoDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Song> getSongs() {
		return songs;
	}

	public List<Song> getSongs(Order order) {
		// NOTIMPLEMENTED Database#getSongs
		if ( true ) throw new RuntimeException("Database#getSongs not yet implemented");
		return null;
	}

	public List<Song> filterSongs(String term) {
		List<Song> ret = new LinkedList<Song>();
		for ( Song song : songs ) {
			if ( song.getTitle().contains(term) || song.getSource().contains(term) ) {
				ret.add(song);
			}
		}
		return ret;
	}

	public List<Song> filterSongs(String term, Order order) {
		// NOTIMPLEMENTED Database#filterSongs
		if ( true ) throw new RuntimeException("Database#filterSongs not yet implemented");
		return null;
	}

	public void addSongs(Collection<Song> songs) {
		this.songs.addAll(songs);
	}

	public void addSong(Song song) {
		this.songs.add(song);
	}
}
