
package com.hemebiotech.analytics.contexts;

import com.hemebiotech.analytics.strategies.IWriteOutput;

/**
 * <h1>WriteOutput</h1> The WriteOutput class is the actual class that is used
 * to receive the processed data at runtime from the WriteOutputToDestination
 * object and write it as an output for the user. This is implementation of the
 * Design Pattern, where an instantiable class should be used to represent the
 * interface containing the method that groups several classes implementing the
 * interface and the method with different implementations.
 * <p>
 * It contains just one method which make use of the write method of
 * WriteOutputToDestination and returns a file with the result.
 * 
 * It holds WriteOutputToDestination variable what is used to create dependency
 * with the method hold in the WriteOutputToDestination interface
 * 
 * @author Detelin Radev
 * @version 1.0
 */
public class WriteOutput {

	private IWriteOutput writeOutput;

	/**
	 * This constructor stores reference to WriteOutputToDestination class
	 * 
	 * @param writeOutput reference to WriteOutputToDestination class
	 */
	public WriteOutput(IWriteOutput writeOutput) {

		this.writeOutput = writeOutput;
	}

	/**
	 * This method make use of the write method of WriteOutputToDestination and
	 * write the result to chosen destination in chosen way.
	 * 
	 */
	public void writeOutput() {
		writeOutput.write();
	}

}
