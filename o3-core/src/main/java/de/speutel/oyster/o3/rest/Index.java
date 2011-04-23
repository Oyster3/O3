package de.speutel.oyster.o3.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.sitebricks.At;
import com.google.sitebricks.client.transport.Text;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;

import de.speutel.oyster.o3.Indexer;

@At("/index")
@Service
@Named
public class Index {

	private List<Indexer> indexers;

	@Inject
	public Index(List<Indexer> indexers) {
		this.indexers = indexers;
	}

	@Get
	public Reply<?> getAvailableIndexer() {
		return Reply.with(indexers).as(Text.class);
	}

	@Post
	public void indexUri(Request request) {
		URI uri = request.read(URI.class).as(Text.class);
		for ( Indexer indexer : indexers ) {
			if ( indexer.add(uri) ) break;
		}
	}
}
