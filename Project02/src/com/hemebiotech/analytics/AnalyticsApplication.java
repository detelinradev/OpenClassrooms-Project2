package com.hemebiotech.analytics;

/**
 * <h1>AnalyticsApplication</h1> The AnalyticsApplication program implements an
 * application that reads symptoms from a file, one symptom per line, and write
 * it in data structure by given requirements.
 * <p>
 *
 * @author Detelin Radev
 * @version 1.0
 */
public class AnalyticsApplication {

	/**
	 * This is the main method where we instantiate the AnalyticsCounter class which
	 * represents all classes used for reading, processing and writing the data from
	 * the source file with the symptoms.
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {

		AnalyticsCounter counter = new AnalyticsCounter("symptoms.txt");
		counter.analyzeData();

	}

}
