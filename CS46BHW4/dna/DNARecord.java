package dna;

/*
*FastqRecord and FastaRecord should implement this.
*Remember that in implementing classes, the methods
* listed in the interface have to be public.
*/

public interface DNARecord {
	/*
	 * Returns Defline of the Record
	 */
	String getDefline();

	/*
	 * Returns Sequence of the Record
	 */
	String getSequence();
}
