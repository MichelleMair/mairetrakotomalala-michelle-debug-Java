package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadSymptomDataFromFile implements the ISymptomReader abstract method
 * GetSymptoms() which read the input file and get symptoms in this file
 */
public class SymptomReader implements ISymptomReader {

	private String filepath = "C:/Users/miche/git/mairetrakotomalala-michelle-debug-Java/symptoms.txt";

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public SymptomReader(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * This method reads symptoms form an input file specified by the "filepath"
	 * variable The "BufferedReader" allows it to read the file line by line Each
	 * line, which representing a symptom, i added to an ArrayList called "result"
	 * It continues reading until there are no more lines in the file it returns the
	 * list of symptoms read from the file
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line;

				while ((line = reader.readLine()) != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				System.out.println("Symptoms were successfully read and imported into file");

			} catch (IOException e) {
				System.err.println("Error trying to read symptoms from the input file: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return result;
	}
}