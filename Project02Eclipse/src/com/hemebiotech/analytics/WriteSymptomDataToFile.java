package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(ISymptomReader readSymptom) {

		// Récupération de la liste des symptomes qu'on a lu à partir de la classe
		// ReadSymptomReader
		List<String> symptoms = readSymptom.GetSymptoms();

		// Création du compteur à partir de la classe qui sert à compter les symptomes
		CounterSymptom symptomCounter = new CounterSymptom();
		Map<String, Integer> symptomCountMap = symptomCounter.countSymptoms(symptoms);

		// Ecrire les symptomes et leurs quantités dans le même fichier result.out
		try (
				// Création d'un BufferedWriter pour lire depuis le fichier d'entrée
				BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))) {

			for (Map.Entry<String, Integer> entry : symptomCountMap.entrySet()) {
				writer.write(entry.getKey() + " : " + entry.getValue());
				writer.newLine();
			}
			System.out.println("Symptoms and number of them successsfully add to file.");
		} catch (IOException e) {
			System.err.println("TEST ERREUR");
			e.printStackTrace();
		}
	}
}
