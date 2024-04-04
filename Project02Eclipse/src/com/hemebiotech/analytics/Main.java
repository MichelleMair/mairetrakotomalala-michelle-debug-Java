package com.hemebiotech.analytics;

/**
 * Java main class This class is the entry point for the execution of the app
 * 
 */
public class Main {

	/**
	 * This is the method where the program begins to run
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Instantiation of the interface: ISymptomReader
		ISymptomReader reader = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");

		// Instantiation of the interface: ISymptomWriter
		ISymptomWriter writer = new WriteSymptomDataToFile();

		// Instantiation of the class: AnalyticsCounter
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		// Launching the reader to read the input file
		analyticsCounter.getSymptoms();

		/*
		 * Launching the writer method to write into the result.out file Which uses the
		 * countSymptoms() method and the sortMapByKey() method to have symptoms and
		 * their occurrences sorted alphabetically
		 */
		analyticsCounter.writeSymptoms();
	}

}
