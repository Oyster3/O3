package de.speutel.oyster.o3.indexer.file;

import java.io.File;
import java.net.URI;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.speutel.oyster.o3.Database;
import de.speutel.oyster.o3.Indexer;
import de.speutel.oyster.o3.model.Song;

@Named
public class FileIndexer implements Indexer {

	private static Logger log = LoggerFactory.getLogger(FileIndexer.class);

	private Database db;

	@Inject
	public FileIndexer(Database db) {
		this.db = db;
	}

	public boolean add(URI uri) {
		File file;
		try {
			file = new File(uri);
		} catch (IllegalArgumentException e) {
			log.trace("Could not create file from URI", e);
			return false;
		}

		if ( !file.exists() ) return false;

		if ( file.isDirectory() ) {
			for ( File child : file.listFiles() ) {
				add(child.toURI());
			}
		} else if ( file.isFile() ) {
			Song song = new Song();
			song.setSource(uri.toString());
			song.setTitle(file.getName());
			db.addSong(song);
		}
		return true;
	}

	public void reindex(URI uri) {
		// NOTIMPLEMENTED FileIndexer#reindex
		if ( true ) throw new RuntimeException("FileIndexer#reindex not yet implemented");

	}

}
