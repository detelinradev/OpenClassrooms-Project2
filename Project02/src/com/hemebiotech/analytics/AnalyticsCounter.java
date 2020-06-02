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
	 * This is the main method where we instantiate the classes used for reading,
	 * processing and writing the data from the source file with the symptoms.
	 * 
	 */
	public void analyzeData() {

		SymptomReader reader = new SymptomReader(new ReadSymptomDataFromFile(filepath));

		List<String> data = new ArrayList<>(reader.getData());

		DataAnalysis analysisTool = new DataAnalysis(new GroupSymptomsAndCountOccurrences(data));

		File result = analysisTool.analyze();

		WriteOutput writeTool = new WriteOutput(new WriteOutputToFile(result));

		writeTool.writeOutput();

	}
}
