package weather;

/*
 * Sub-Class of Cloud, does not have the ability to rain.
 */
public class CirrusCloud extends Cloud {

	/*
	 * Constructor of CirrusCloud object
	 * 
	 * @see weather.Cloud
	 */
	public CirrusCloud(float bottom, float top) {
		super(bottom, top);
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Override
	 * 
	 * @return I cannot make rain instead of I can make rain
	 */
	public String rain() {
		return "I cannot make rain";
	}

}
