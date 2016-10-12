package dna;

import java.io.*;
import java.util.*;

/*
 * This class is where the conversion occurs from fastq to fasta.
 */
public class FileConverter {
	private File fastq;
	private File fasta;

	/*
	 * Constructor for FileConverter
	 * 
	 * @param fastq the fastq pathway
	 * 
	 * @param fasta the fasta pathway
	 */
	public FileConverter(File fastq, File fasta) {
		this.fastq = fastq;
		this.fasta = fasta;
	}

	/*
	 * // Writes a fasta file consisting of conversion of all records from the
	 * // fastq with sufficient quality and unique defline.
	 */
	public void convert() throws IOException, FastqException {
		HashSet<String> uniqueDeflines = new HashSet<String>();
		// Build chain of readers aka Input Stream
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);
		FastqRecord nextRec;

		// Build chain of writers aka Output Stream
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		boolean finished = false;

		// Reads the files from the Fastq file and converts only the high
		// quality correct records into fasta format
		while (!finished) {
			try {
				nextRec = fqr.readRecord();
				while (nextRec != null) {

					if (nextRec.getDefline().charAt(0) == '@') {
						boolean match = false;
						for (String s : uniqueDeflines) {
							if (nextRec.getDefline().equals(s)) {
								match = true;
							}
						}
						// writes into fasta format into the fasta file
						if (!match) {
							uniqueDeflines.add(nextRec.getDefline());
							System.out.println(nextRec.getDefline());
							if (nextRec.qualityIsHigh()) {
								FastaRecord rec = new FastaRecord(nextRec);
								faw.writeRecord(rec);
							}
						}
					}
					// reads next record
					nextRec = fqr.readRecord();
				}
				// all records have been read
				finished = true;
			} catch (FastqException x) {
			}
		}
		// Closes the writers and printers in reverse order in which it was
		// created
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}

	public static void main(String[] args) throws FastqException {
		System.out.println("Starting");
		try {
			File fastq = new File("data/HW3.fastq");
			assert fastq.exists() : "Can't find input file " + fastq.getAbsolutePath();
			File fasta = new File("data/HW3.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
