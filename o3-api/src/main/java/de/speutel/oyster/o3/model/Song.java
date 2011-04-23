package de.speutel.oyster.o3.model;

public class Song {

	private String source;

	private String title;
	private String year;

	private Artist artist;
	private Album album;

	private Object extra;

	private Object indexInfo;

	public Object getIndexInfo() {
		return indexInfo;
	}

	public void setIndexInfo(Object indexInfo) {
		this.indexInfo = indexInfo;
	}

	/**
	 * URI
	 */
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}
}
