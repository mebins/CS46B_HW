package dna;

import java.io.*;

//
// Writes a fasta record to a print writer.
//

public class FastaWriter {
	private PrintWriter thePrintWriter;

	public FastaWriter(PrintWriter thePrintWriter) {
		this.thePrintWriter = thePrintWriter;
	}

	// Write the rec as 2 separate lines: first the defline, then the sequence.
	// To write something on a separate line, use the println() method of
	// PrintWriter.
	public void writeRecord(FastaRecord nextRec) throws IOException {
		thePrintWriter.println(">" + nextRec.getDefline().substring(1, nextRec.getDefline().length()));
		thePrintWriter.println(nextRec.getSequence());
	}
}
