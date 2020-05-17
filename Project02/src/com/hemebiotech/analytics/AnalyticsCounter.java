package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) {

		SymptomReader reader = new SymptomReader(new ReadSymptomDataFromFile("symptoms.txt"));

		List<String> data = new ArrayList<>(reader.getData());

	}
}
