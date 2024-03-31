package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		// Map<String, Integer> countSymptoms = new HashMap<>();
		WriteSymptomDataToFile writeSymptom = new WriteSymptomDataToFile();

		ReadSymptomDataFromFile readSymptom = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = readSymptom.GetSymptoms();
		// writeSymptom.writeSymptoms(countSymptoms);
	}

}
