package com.hemebiotech.analytics.concreteStrategies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

	private File input;

	/**
	 * This constructor stores a File
	 * 
	 * @param input a File have to be provided for constructing the object
	 */
	public WriteOutputToFile(File input) {
		this.input = input;
	}

	/**
	 * This method reads the data from the file that holds the result and writes it
	 * to a file in the output destination. If the file is empty or contains: No
	 * data proceeded, method returns a File with single record "No data proceeded".
	 * 
	 * @exception IOException On output error
	 * @see IOException
	 */
	@Override
	public void write() {

		File output = new File("result.out");

		try (BufferedReader reader = new BufferedReader(new java.io.FileReader(input));
				FileWriter writer = new FileWriter(output)) {

			String line = reader.readLine(); // get first symptom

			if (!line.equals("No data proceeded") && line != null) {

				while (line != null) {

					writer.write(line + "\n");
					line = reader.readLine(); // get next symptom
				}

			} else {

				writer.write("No data proceeded"); // in case input file is empty or has no data
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
