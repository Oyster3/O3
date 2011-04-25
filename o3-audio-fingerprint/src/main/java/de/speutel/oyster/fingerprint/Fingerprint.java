package de.speutel.oyster.fingerprint;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.iharder.Base64;
import net.iharder.Base64.OutputStream;

import org.phash.AudioHash;
import org.phash.pHash;

public class Fingerprint {

	private String hash;
	private AudioHash audioHash;

	public Fingerprint(AudioHash hash) throws IOException {
		Base64EncoderStream out = new Base64EncoderStream();
		for ( int i : hash.hash ) {
			out.writeInt(i);
		}
		this.hash = out.toString();
		this.audioHash = hash;
	}

	public double distance(Fingerprint fp) {
		return pHash.audioDistance(this.audioHash, fp.getAudioHash());
	}

	private AudioHash getAudioHash() {
		return audioHash;
	}

	public Fingerprint(long[] hash) throws IOException {
		Base64EncoderStream out = new Base64EncoderStream();
		for ( long l : hash ) {
			out.writeLong(l);
		}
		this.hash = out.toString();

	}

	public Fingerprint(byte[] hash) throws IOException {
		Base64EncoderStream out = new Base64EncoderStream();
		for ( byte b : hash ) {
			out.writeByte(b);
		}
		this.hash = out.toString();
	}

	public String toString() {
		return hash;
	}

	private class Base64EncoderStream {

		private ByteArrayOutputStream bArrayStream = new ByteArrayOutputStream();
		private OutputStream b64stream = new Base64.OutputStream(bArrayStream);
		private DataOutputStream dataStream = new DataOutputStream(b64stream);

		@Override
		public String toString() {
			try {
				return new String(bArrayStream.toByteArray(), "us-ascii");
			} catch (UnsupportedEncodingException e) {
				throw new IllegalStateException("Weird VM, no us-ascii charset");
			}
		}

		public final void writeByte(int v) throws IOException {
			dataStream.writeByte(v);
		}

		public final void writeInt(int v) throws IOException {
			dataStream.writeInt(v);
		}

		public final void writeLong(long v) throws IOException {
			dataStream.writeLong(v);
		}

	}
}
