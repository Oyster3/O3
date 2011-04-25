package de.speutel.oyster.fingerprint;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

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
	public void testFingerprint() throws IOException {
		File f = new File("src/test/resources/test.mp3");
		File g = new File("src/test/resources/test.ogg");
		File h = new File("src/test/resources/music.mp3");
		File i = new File("src/test/resources/music.ogg");

		assertTrue(f.exists());
		assertTrue(g.exists());
		assertTrue(h.exists());
		assertTrue(i.exists());

		Fingerprint fHash = new PHashFingerprinter().fingerprint(f);
		Fingerprint gHash = new PHashFingerprinter().fingerprint(g);
		Fingerprint hHash = new PHashFingerprinter().fingerprint(h);
		Fingerprint iHash = new PHashFingerprinter().fingerprint(i);

		assertTrue(fHash.distance(fHash) > 0.99);
		assertTrue(fHash.distance(gHash) > 0.98);
		assertTrue(gHash.distance(fHash) > 0.98);
		assertTrue(hHash.distance(iHash) > 0.98);
		assertTrue(iHash.distance(hHash) > 0.98);

		assertTrue(fHash.distance(hHash) < 0.3);
		assertTrue(fHash.distance(iHash) < 0.3);
		assertTrue(hHash.distance(fHash) < 0.3);
		assertTrue(hHash.distance(gHash) < 0.3);
	}

}
