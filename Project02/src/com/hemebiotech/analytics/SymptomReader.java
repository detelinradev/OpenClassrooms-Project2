package com.hemebiotech.analytics;

import java.util.List;

/**
 * <h1>SymptomReader</h1> The SymptomReader class is the actual class that is
 * used to represent the source data at runtime to the user. This is
 * implementation of the Design Pattern, where an instantiable class should be
 * used to represent the interface containing the method that groups several
 * classes implementing the interface and the method with different
 * implementations.
 * <p>
 * It contains a method which make use of the getSymptoms method of the
 * interface ISymptomReader and returns a list with the result.
 * 
 * It holds ISymptomReader variable what is used to create dependency with the
 * method hold in the ISymptomReader interface
 * 
 * @author Detelin Radev
 * @version 1.0
 */
public class SymptomReader {

	private ISymptomReader data;

	/**
	 * This constructor stores reference to ISymptomReader class
	 * 
	 * @param data is reference to ISymptomReader class
	 */
	public SymptomReader(ISymptomReader data) {
		this.data = data;
	}

	/**
	 * This method make use of the getData method of SymptomReaderFromSource and
	 * returns a map with the result.
	 * 
	 * @return List<String> with the data read from the source
	 */
	public List<String> getData() {
		return data.getSymptoms();
	}
}
