package de.speutel.oyster.fingerprint;

import java.io.File;

import org.phash.AudioHash;
import org.phash.pHash;

public class PHashFingerprinter implements Fingerprinter {

	public Fingerprint fingerprint(File file) {
		Fingerprint fp = new Fingerprint();

		if ( file.getName().endsWith("mp3") ) {
			AudioHash hash = pHash.audioHash(file.getAbsolutePath());
			fp.setHash(hash);
		}

		return fp;
	}

}
