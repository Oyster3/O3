package de.speutel.oyster.fingerprint;

import java.io.File;
import java.io.IOException;

public interface Fingerprinter {

	Fingerprint fingerprint(File file) throws IOException;

}
