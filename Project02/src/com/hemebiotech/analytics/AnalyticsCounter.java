package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.concreteStrategies.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.contexts.SymptomReader;

/**
 * <h1>AnalyticsCounter</h1> The AnalyticsCounter program implements an
 * application that reads symptoms from a file, one symptom per line, and write
 * it in data structure by given requirements.
 * <p>
 *
 * @author Detelin Radev
 * @version 1.0
 */
public class AnalyticsCounter {

	/**
	 * This is the main method where we instantiate the classes used for reading,
	 * processing and writing the data from the source file with the symptoms.
	 * 
	 * @param args Unused.
	 */
	public static void main(String args[]) {

		SymptomReader reader = new SymptomReader(new ReadSymptomDataFromFile("symptoms.txt"));

		List<String> data = new ArrayList<>(reader.getData());

	}
}
