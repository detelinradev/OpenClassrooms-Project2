package com.hemebiotech.analytics.concreteStrategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hemebiotech.analytics.strategies.ISymptomReader;

/**
 * <h1>ReadSymptomDataFromFile</h1> The class ReadSymptomDataFromFile is the
 * actual implementation of the way chosen on runtime for reading the data from
 * the source.
 * <p>
 * It contains one method to get the data from a file.
 * 
 * @author Detelin Radev
 * @version 1.0
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * This constructor stores string with a path to the file with symptoms
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * The method reads data from a file with given location and write it in an
	 * array list data structure.
	 * 
	 * @return List<String> with all the symptoms from the file, or empty list if
	 *         there is no data on the file or if the file location is null
	 * @exception IOException On input error
	 * @see IOException
	 */
	@Override
	public List<String> getSymptoms() {

		ArrayList<String> symptoms = new ArrayList<String>();

		if (filepath != null) {

			try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filepath));) {

				String line = reader.readLine(); // get first symptom

				if (line != null) {

					while (line != null) {

						symptoms.add(line);
						line = reader.readLine(); // get next symptom
					}

				} else {

					return Collections.emptyList();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		} else {

			return Collections.emptyList();
		}

		return symptoms;
	}

}
