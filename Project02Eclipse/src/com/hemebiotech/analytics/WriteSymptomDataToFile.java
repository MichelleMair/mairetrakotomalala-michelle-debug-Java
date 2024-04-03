package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * WriteSymptomDataToFile class implements the interface ISymptomWriter It
 * defines the method writeSymptoms() for writing symptoms and their occurrences
 * to a file
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	/*
	 * This method receives a Map as input Keys: symptoms - Value: their occurrences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (
				// to write into the file named result.out
				BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))) {

			/*
			 * Each entry in the symptoms Map is iterated using a for-each loop And for each
			 * entry, it writes the key and its count (value) to the file And then moves to
			 * the newt line using "newLine()
			 */
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + " : " + entry.getValue());
				writer.newLine();
			}
			System.out.println("Symptoms and their counts were successsfully add to file.");
		} catch (IOException e) {
			System.err.println("Error trying to write symptoms to file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
