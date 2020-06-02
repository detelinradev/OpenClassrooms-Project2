package com.hemebiotech.analytics.strategies;

import java.util.Map;

/**
 * <h1>IDataAnalysis</h1> The IDataAnalysis interface is used as a bridge
 * between the types of proceeding data classes, that all implements this
 * interface, and the actual class that is used to represent the proceeded data
 * to the user.This is implementation of the Strategy Pattern, where an concrete
 * class should be used to represent the interface containing the method that
 * groups several classes implementing the interface and the method with
 * different implementations.
 * <p>
 * It contains a method for analyzing the data from the source.
 * 
 * @author Detelin Radev
 * @version 1.0
 */
public interface IDataAnalysis {

	/**
	 * The method analyze the data in various ways depends of the class implementing
	 * it and writes the result in a file.
	 * 
	 * @return file - file with analyzed data
	 */
	Map<String, Integer> proceedData();

}
