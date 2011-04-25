package de.speutel.oyster.fingerprint;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.phash.AudioHash;
import org.phash.pHash;

public class PHashFingerprinter implements Fingerprinter {

	private List<String> audioExtensions = Arrays.asList("mp3", "ogg", "flac");

	public Fingerprint fingerprint(File file) throws IOException {

		int extPos = file.getName().lastIndexOf(".") + 1;
		String ext = file.getName().substring(extPos);

		System.err.println(ext);

		if ( audioExtensions.contains(ext) ) {
			AudioHash hash = pHash.audioHash(file.getAbsolutePath());
			return new Fingerprint(hash);
		}

		return null;
	}
}
