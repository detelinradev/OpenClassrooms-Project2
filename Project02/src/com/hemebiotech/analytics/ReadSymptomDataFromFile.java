package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filepath));) {
				String line = reader.readLine();

				if (line != null) {
					while (line != null) {
						result.add(line);
						line = reader.readLine();
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

		return result;
	}

}
