package weather;

public class Cloud {
	private float bottom;
	private float top;

	/*
	 * Constructor of Cloud Object.
	 * 
	 * @param bottom the bottom of the Cloud object
	 * 
	 * @param top the top of the Cloud object
	 */
	public Cloud(float bottom, float top) {
		this.bottom = bottom;
		this.top = top;
	}

	/*
	 * Returns a float of the height of Cloud.
	 * 
	 * @return a float of the height of Cloud
	 */
	public float getHeight() {
		return top - bottom;
	}

	/*
	 * Returns a string that says It is raining.
	 * 
	 * @return a String, It is raining
	 */
	public String rain() {
		return "It is raining";
	}
}
