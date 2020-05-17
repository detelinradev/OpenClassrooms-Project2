package com.hemebiotech.analytics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.concreteStrategies.GroupSymptomsAndCountOccurrences;
import com.hemebiotech.analytics.concreteStrategies.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.concreteStrategies.WriteOutputToFile;
import com.hemebiotech.analytics.contexts.DataAnalysis;
import com.hemebiotech.analytics.contexts.SymptomReader;
import com.hemebiotech.analytics.contexts.WriteOutput;

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

		DataAnalysis analysisTool = new DataAnalysis(new GroupSymptomsAndCountOccurrences(data));

		File result = analysisTool.analyze();

		WriteOutput writeTool = new WriteOutput(new WriteOutputToFile(result));

	}
}
