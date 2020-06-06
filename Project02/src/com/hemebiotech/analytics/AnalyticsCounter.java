package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.concreteStrategies.GroupSymptomsAndCountOccurrences;
import com.hemebiotech.analytics.concreteStrategies.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.concreteStrategies.WriteOutputToFile;
import com.hemebiotech.analytics.contexts.DataAnalysis;
import com.hemebiotech.analytics.contexts.SymptomReader;
import com.hemebiotech.analytics.contexts.WriteOutput;

/**
 * <h1>AnalyticsCounter</h1> The AnalyticsCounter class is the base class where
 * we receive a String with a path to the source data and instantiate the
 * classes that are part of the application and holds the processing methods
 * that reads symptoms from a file, one symptom per line, analyze all the data,
 * and write it in data structure by given requirements.
 * <p>
 *
 * @author Detelin Radev
 * @version 1.0
 */
public class AnalyticsCounter {

	private String filepath;

	/**
	 * This constructor stores string with a path to the file with symptoms
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public AnalyticsCounter(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * This is the method where we instantiate the classes used for reading,
	 * processing and writing the data from the source file with the symptoms, as
	 * well as the data structures used for communication between modules. It
	 * creates messages to the console with appropriate content for the application
	 * status.
	 * 
	 */
	public void analyzeData() {
		System.out.println("Analytics application is started!");

		SymptomReader reader = new SymptomReader(new ReadSymptomDataFromFile(filepath));

		List<String> data = new ArrayList<>(reader.getData());

		DataAnalysis analysisTool = new DataAnalysis(new GroupSymptomsAndCountOccurrences(data));

		Map<String, Integer> result = new TreeMap<>(analysisTool.analyze());

		WriteOutput writeTool = new WriteOutput(new WriteOutputToFile(result));

		writeTool.writeOutput();

		System.out.println("Analytics application is closed!");

	}
}
