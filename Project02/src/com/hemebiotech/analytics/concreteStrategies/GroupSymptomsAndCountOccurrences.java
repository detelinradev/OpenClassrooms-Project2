
package com.hemebiotech.analytics.concreteStrategies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.strategies.IDataAnalysis;

/**
 * <h1>GroupSymptomsAndCountOccurrences</h1> The class
 * GroupSymptomsAndCountOccurrences is the actual implementation of the way
 * chosen on runtime for analyzing the data from the source.
 * <p>
 * It contains one method to analyze the data from a file.
 * 
 * @author Detelin Radev
 * @version 1.0
 *
 */
public class GroupSymptomsAndCountOccurrences implements IDataAnalysis {

	private List<String> source;

	/**
	 * This constructor stores List with strings for the symptoms
	 * 
	 * @param source A List with strings for the symptoms
	 */
	public GroupSymptomsAndCountOccurrences(List<String> source) {
		this.source = source;
	}

	/**
	 * The method reads the raw data from a List and write it in a tree map data
	 * structure with the symptom as a key and the number of occurrences as a value.
	 * Then it returns it as a result.
	 * 
	 * @return TreeMap with all the symptoms from the List grouped by the number of
	 *         occurrences and alphabetically ordered. If the List is empty or null,
	 *         method returns TreeMap with single record "No data proceeded".
	 * @exception IOException On input error
	 * @see IOException
	 */
	@Override
	public Map<String, Integer> proceedData() {

		Map<String, Integer> result = new TreeMap<>();

		if (source != null && !source.isEmpty()) {

			for (String symptom : source) {

				if (result.containsKey(symptom)) {

					result.put(symptom, result.get(symptom) + 1);

				} else {

					result.put(symptom, 1);
				}
			}
			System.out.println("Analytics application analyzed the data.");
		}

		return result;
	}

	private File writeOutputToFile(Map<String, Integer> result) {

		File output = new File("proceededData.txt");

		try (FileWriter writer = new FileWriter(output)) {

			if (!result.isEmpty()) {

				for (String symptom : result.keySet()) {

					writer.write(symptom + " : " + result.get(symptom) + "\n");
				}

			} else {

				writer.write("No data proceeded");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		return output;
	}

}
