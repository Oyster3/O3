package de.speutel.oyster.fingerprint;

import java.util.Arrays;

import org.phash.AudioHash;
import org.phash.Hash;

public class Fingerprint {

	private Hash hash;

	public void setHash(Hash hash) {
		this.hash = hash;
	}

	public Hash getHash() {
		return hash;
	}

	public String toString() {
		if ( hash instanceof AudioHash ) { return Arrays.toString(((AudioHash) hash).hash); }
		return super.toString();
	}

}
