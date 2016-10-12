package dna;

public class FastaRecord implements Comparable<FastaRecord>, DNARecord {
	private String defline;
	private String sequence;

	/*
	 * Constructor of FastaRecord Throws FastqException when the first char is
	 * not '>'
	 * 
	 * @param defline the first line of the fasta record
	 * 
	 * @param sequence the second like of the fasta record
	 */
	public FastaRecord(String defline, String sequence) throws FastqException {
		if (defline.charAt(0) != '>') {
			throw new FastqException(
					"Bad 1st char in defline in fasta record: saw " + defline.charAt(0) + ", expected >");
		}
		this.defline = defline;
		this.sequence = sequence;
	}

	/*
	 * @param fastqRec the Fastq record file Constructor of FastaRecord
	 */
	public FastaRecord(FastqRecord fastqRec) {
		this.defline = '>'+fastqRec.getDefline().substring(1, fastqRec.getDefline().length());
		this.sequence = fastqRec.getSequence();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dna.DNARecord#getDefline()
	 */
	@Override
	public String getDefline() {
		// TODO Auto-generated method stub
		return defline;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dna.DNARecord#getSequence()
	 */
	@Override
	public String getSequence() {
		// TODO Auto-generated method stub
		return sequence;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object x) {
		FastaRecord that = (FastaRecord) x;
		return this.compareTo(that) == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return defline + "\n" + sequence + "\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(FastaRecord o) {
		if (this.defline.equals(o.defline)) {
			if (this.sequence.equals(o.sequence)) {
				return 0;
			} else {
				return this.sequence.compareTo(o.sequence);
			}
		} else {
			return this.defline.compareTo(o.defline);
		}
	}

	//
	// Provide a hashCode() method that returns the sum of the hashcodes of
	// defline and sequence.
	//
	public int hashCode() {
		return defline.hashCode() + sequence.hashCode();
	}
}
