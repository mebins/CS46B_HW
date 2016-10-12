package weather;

import java.util.ArrayList;

/*
 * OLD OBJECT, USE SKY2 INSTEAD.
 */
public class Sky {

	private ArrayList<Cloud> clouds;

	/*
	 * Constructor of the Sky Object
	 */
	public Sky() {
		clouds = new ArrayList<Cloud>(100);
	}

	/*
	 * @param c used to add a Cloud object to the ArrayList clouds.
	 */
	public boolean add(Cloud c) {
		clouds.add(c);
		return true;
	}

	/*
	 * Returns the mean Height of all clouds in the ArrayList clouds.
	 * 
	 * @return a float that is the average of all clouds
	 */
	public float getMeanHeight() {
		float averageSum = 0;
		for (Cloud element : clouds) {
			averageSum += element.getHeight();
		}
		if (clouds.size() > 0) {
			averageSum /= clouds.size();
		}
		return averageSum;
	}

	/*
	 * Main Function
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
		Sky sky = new Sky();
		sky.add(strat);
		sky.add(cumu);
		sky.add(cirr);
		float mean = sky.getMeanHeight();
		if (mean < 1799 || mean > 1801)
			System.out.println("Bad mean height: expected 1800, saw " + mean);
		System.out.println("Everything (else) is ok");
	}
}
