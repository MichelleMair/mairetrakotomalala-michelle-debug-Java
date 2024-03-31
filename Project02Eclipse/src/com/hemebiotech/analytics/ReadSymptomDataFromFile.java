package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadSymptomDataFromFile implémente l'interface ISymptomReader Méthode
 * abstraite GetSymptoms() qui permet de récupérer les symptomes
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath = "symptoms.txt";

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
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
				e.printStackTrace();
				System.out.println("TEST ERREUR  ");
			}
		}
		System.out.println("RESULTATS: " + result);
		return result;
	}
}