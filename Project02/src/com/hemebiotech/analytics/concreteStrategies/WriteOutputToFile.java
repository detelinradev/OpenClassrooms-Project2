package com.hemebiotech.analytics.concreteStrategies;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.hemebiotech.analytics.strategies.IWriteOutput;

/**
 * <h1>WriteOutputToFile</h1> The class WriteOutputToFile is the actual
 * implementation of the way chosen on runtime for writing the output to the
 * user.
 * <p>
 * It contains one method to write the result in a file.
 * 
 * @author Detelin Radev
 * @version 1.0
 */
public class WriteOutputToFile implements IWriteOutput {

	private Map<String, Integer> input;

	/**
	 * This constructor stores a Map
	 * 
	 * @param input a Map have to be provided for constructing the object
	 */
	public WriteOutputToFile(Map<String, Integer> input) {
		this.input = input;
	}

	/**
	 * This method reads the data from the Map that holds the result and writes it
	 * to a file in the output destination. If the Map is empty method returns a
	 * File with single record "No data proceeded".
	 * 
	 * @exception IOException On output error
	 * @see IOException
	 */
	@Override
	public void write() {

		File result = new File("result.out");

		try (FileWriter writer = new FileWriter(result)) {

			if (!input.isEmpty()) {

				for (String symptom : input.keySet()) {

					writer.write(symptom + " : " + input.get(symptom) + "\n");
				}
				System.out.println("Analytics application wrote the proceeded data to a file.");

			} else {

				writer.write("No data proceeded");

				System.out.println("No data proceeded");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
