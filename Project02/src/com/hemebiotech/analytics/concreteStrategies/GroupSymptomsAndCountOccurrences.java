/**
 * 
 */
package com.hemebiotech.analytics.concreteStrategies;

import java.io.File;
import java.util.List;

import com.hemebiotech.analytics.strategies.IDataAnalysis;

/**
 * <h1>GroupSymptomsAndCountOccurrences</h1> The class GroupSymptomsAndCountOccurrences
 * is the actual implementation of the way chosen on runtime for analyzing the data from
 * the source.
 * <p>
 * It contains one method to analyze the data from a file.
 * 
 * @author Detelin Radev
 * @version 1.0
 *
 */
public class GroupSymptomsAndCountOccurrences implements IDataAnalysis {
	
	private List<String> source;

	/**
	 * This constructor stores List with strings for the symptoms
	 *  
	 * @param source A List with strings for the symptoms
	 */
	public GroupSymptomsAndCountOccurrences(List<String> source) {
		this.source = source;
	}

	@Override
	public File proceedData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
