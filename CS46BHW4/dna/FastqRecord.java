package dna;

/*
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
*/

public class FastqRecord implements Comparable<FastqRecord>, DNARecord {
	private String defline;
	private String sequence;
	private String quality;

	/*
	 * Throws FastqException if the format of the file is incorrect. Constructs
	 * the FastqRecord Object
	 * 
	 * @param defline first line of the fastq
	 * 
	 * @param sequence second line of the fastq
	 * 
	 * @param quality fourth line of the fastq
	 */
	public FastqRecord(String defline, String sequence, String quality) throws FastqException {
		if (defline.charAt(0) != '@') {
			throw new FastqException(
					"Bad 1st char in defline in fastq record: saw " + defline.charAt(0) + ", expected @");
		}
		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;
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

		FastqRecord that = (FastqRecord) x;

		return this.compareTo(that) == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(FastqRecord x) {
		if (this.defline.compareTo(x.defline) == 0) {
			if (this.sequence.compareTo(x.sequence) == 0) {
				if (this.quality.compareTo(x.quality) == 0) {
					return 0;
				} else {
					return this.quality.compareTo(x.quality);
				}
			} else {
				return this.sequence.compareTo(x.sequence);
			}
		} else {
			return this.defline.compareTo(x.defline);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}

	//
	// Complete this. Return true if the first char of quality is '!'.
	//
	/*
	 * Returns true if the first char of quality is '!'
	 * 
	 * @return true if the first char of quality is '!'
	 */
	public boolean qualityIsHigh() {
		if (quality.charAt(0) == '!') {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return defline + "\n" + sequence + "\n+\n" + quality + "\n";
	}

}
