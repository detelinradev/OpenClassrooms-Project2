package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * <h1>SymptomReaderFromSource</h1> The SymptomReaderFromSource interface is
 * used as a bridge between the types of getting data classes that all
 * implements the interface and the actual class that is used to represent the
 * source data at runtime to the user. This is implementation of the Strategy
 * Pattern, where an instantiable class should be used to represent the
 * interface containing the method that groups several classes implementing the
 * interface and the method with different implementations.
 * <p>
 * It contains just one method for acquiring the data from the source.
 * 
 * @author Detelin Radev
 * @version 1.0
 *
 */
public interface ISymptomReader {

	/**
	 * The method reads data from various locations depends of the class
	 * implementing it, and write it in a list.
	 * 
	 * @return List<String> with all the symptoms from the file.It may return empty
	 *         list on some conditions
	 * @exception IOException On input error
	 * @see IOException
	 */
	List<String> getSymptoms();
}
