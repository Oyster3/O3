package de.speutel.oyster.o3;

import java.net.URI;

public interface Indexer {

	/**
	 * 
	 * @param uri
	 * @return true if file was indexed here, false otherwise.
	 */
	boolean add(URI uri);

	void reindex(URI uri);

}
