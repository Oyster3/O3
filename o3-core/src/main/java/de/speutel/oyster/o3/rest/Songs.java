package de.speutel.oyster.o3.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.sitebricks.At;
import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.client.transport.Text;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;

import de.speutel.oyster.o3.Database;
import de.speutel.oyster.o3.model.Song;

@At("/songs")
@Service
@Named
public class Songs {

	private Database db;

	@Inject
	public Songs(Database db) {
		this.db = db;
	}

	@Get
	public Reply<?> getAllSongs() {
		return Reply.with(db.getSongs()).as(Json.class);
	}

	@Post
	public Reply<?> getFilteredSongs(Request request) {
		String keyword = request.read(String.class).as(Text.class);
		List<Song> songs = db.filterSongs(keyword);
		return Reply.with(songs).as(Json.class);
	}
}
