package de.speutel.oyster.fingerprint;

import java.io.File;

public interface Fingerprinter {

	Fingerprint fingerprint(File file);

}
