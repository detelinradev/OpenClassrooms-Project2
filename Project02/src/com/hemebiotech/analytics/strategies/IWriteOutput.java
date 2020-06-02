
package com.hemebiotech.analytics.strategies;

import java.io.IOException;

/**
 * <h1>IWriteOutput</h1> The IWriteOutput interface is used as a connection
 * between the types of writing data classes that all implements the interface
 * and the actual class that is used to receive the processed data at runtime
 * from the SymptomReader object and write it as an output for the user. This is
 * implementation of the Design Pattern, where a concrete class should be used
 * to represent the interface containing the method that groups several classes
 * implementing the interface and the method with different implementations.
 * <p>
 * It contains just one method for writing the data to the output destination.
 * 
 * @author Detelin Radev
 * @version 1.0
 */
public interface IWriteOutput {

	/**
	 * The method writes data to output destination in various ways depends of the
	 * class implementing it.
	 * 
	 * @exception IOException On input error
	 * @see IOException
	 */
	void write();

}
