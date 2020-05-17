/**
 * 
 */
package com.hemebiotech.analytics.contexts;

import java.io.File;
import java.util.List;

import com.hemebiotech.analytics.strategies.IDataAnalysis;

/**
 * <h1>DataAnalysis</h1> The DataAnalysis class is the actual class that is used
 * to represent the analyzed data at runtime to the user. This is implementation
 * of the Strategy Pattern, where an instantiable class should be used to
 * represent the interface containing the method that groups several classes
 * implementing the interface and the method with different implementations.
 * <p>
 * It contains a method which make use of the proceedData method of the
 * interface IDataAnalysis and returns a File with the result.
 * 
 * It holds IDataAnalysis variable what is used to create dependency with the
 * method hold in the IDataAnalysis interface
 * 
 * @author Detelin Radev
 * @version 1.0
 *
 */
public class DataAnalysis {

	private IDataAnalysis data;

	/**
	 * This constructor stores reference to IDataAnalysis class
	 * 
	 * @param data it is reference to IDataAnalysis class
	 */
	public DataAnalysis(IDataAnalysis data) {
		this.data = data;
	}

	/**
	 * This method make use of the proceedData method of IDataAnalysis and returns a
	 * File with the result.
	 * 
	 * @param rawData receives a List with raw data
	 * @return File returns a File with analyzed data
	 */
	public File analyze(List<String> rawData) {
		return data.proceedData(rawData);
	}

}
