package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadSymptomDataFromFile implémente l'interface ISymptomReader Méthode
 * abstraite GetSymptoms() qui lit le fichier d'entrée et qui permet de
 * récupérer les symptomes
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath = "symptoms.txt";

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */

	// réupération du chemin d'accès au fichier à lire
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				// permet de lirer le fichier input
				BufferedReader reader = new BufferedReader(new FileReader(filepath));

				String line;

				// tant que le fichier contient des lignes,le résultat de la ligne va être
				// ajouté au fichier de sortie
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