package de.speutel.oyster.fingerprint;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class PHashFingerprinterTest {

	@Before
	public void setUp() throws Exception {
		File libdir = new File("src/main/native");
		assertTrue(libdir.exists());
		System.setProperty("java.library.path", libdir.getAbsolutePath());
	}

	@Test
	public void testFingerprint() {
		File f = new File("src/test/resources/test.mp3");

		Fingerprint fingerprint = new PHashFingerprinter().fingerprint(f);

		System.err.println(fingerprint);

	}
}
