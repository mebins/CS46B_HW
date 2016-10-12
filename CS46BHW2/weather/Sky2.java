package weather;

import java.util.ArrayList;

/*
 * Since primary purpose of the Sky object is to store an ArrayList, it therefore makes sense to
 * Extends an ArrayList. 
 */
public class Sky2 extends ArrayList<Cloud> {

	/*
	 * Constructor of Sky2 Uses super Method to construct an ArrayList of 100
	 * spaces.
	 */
	public Sky2() {
		super(100);
	}

	/*
	 * Returns the mean Height of all clouds in the ArrayList clouds. this is
	 * used instead because Sky2 is an arrayList.
	 * 
	 * @returns a float that is the average of all clouds
	 */
	public float getMeanHeight() {
		float averageSum = 0;
		for (Cloud element : this) {
			averageSum += element.getHeight();
		}
		if (this.size() > 0) {
			averageSum /= this.size();
		}
		return averageSum;
	}

	/*
	 * MAIN FUNCTION
	 */
	public static void main(String[] args) {
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");
		CumulusCloud cumu = new CumulusCloud(200, 2000);
		if (!cumu.rain().startsWith("It is raining"))
			System.out.println("Bad CumulusCloud::rain");
		CirrusCloud cirr = new CirrusCloud(300, 3000);
		if (!cirr.rain().startsWith("I cannot make"))
			System.out.println("Bad CirrusCloud::rain");
		Sky2 sky = new Sky2();
		sky.add(strat);
		sky.add(cumu);
		sky.add(cirr);
		float mean = sky.getMeanHeight();
		if (mean < 1799 || mean > 1801)
			System.out.println("Bad mean height: expected 1800, saw " + mean);
		System.out.println("Everything (else) is ok");
	}
}
