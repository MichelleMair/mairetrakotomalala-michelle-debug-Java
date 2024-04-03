package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		// Ecrire les symptomes et leurs quantités dans le même fichier result.out
		try (
				// Création d'un BufferedWriter pour écrire dans le fichier result.out
				BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))) {

			/*
			 * Boucle qui parcourt chaque entrée du map et écrit chaque symptome et son
			 * nombres d'occurences dans le ficier de sortie, puis passe à la ligne suivante
			 * avec newLine()
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
