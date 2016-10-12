package dna;

import java.io.*;

/*
 * Reads from a BufferedReader and creates a FastqReader
 */

public class FastqReader {
	private BufferedReader theBufferedReader;

	public FastqReader(BufferedReader theBufferedReader) {
		this.theBufferedReader = theBufferedReader;
	}

	/*
	 * Returns next record in the file, or null if EOF.
	 */
	public FastqRecord readRecord() throws IOException, FastqException {
		// If null, indicating end of file.
		String defline = theBufferedReader.readLine();
		if (defline == null) {
			return null;
		}
		// Read the next 3 lines from the buffered reader. Construct and return
		// a FastqRecord.
		String sequence = theBufferedReader.readLine();
		String plus = theBufferedReader.readLine();
		String quality = theBufferedReader.readLine();

		return new FastqRecord(defline, sequence, quality);
	}
}
