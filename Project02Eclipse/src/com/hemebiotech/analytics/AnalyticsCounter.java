package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		// Read Data file and provide a list of symptoms
		ISymptomReader readSymptom = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = readSymptom.GetSymptoms();

		// Write number of symptoms from data file
		ISymptomWriter writeSymptom = new WriteSymptomDataToFile();
		writeSymptom.writeSymptoms(readSymptom);

	}

}
