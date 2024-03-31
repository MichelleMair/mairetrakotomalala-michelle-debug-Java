package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	String inputFile = "result.out";
	String outputFile = "listOfSymptoms.txt";

	@Override
	public void writeSymptoms(Map<String, Integer> counterOfSymptoms) {
		counterOfSymptoms = new HashMap<>();

		try {
			// read symptoms file
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String line;

			while ((line = reader.readLine()) != null) {
				// Diviser la ligne en mots en utilisant la virgule comme délimiteur
				String[] symptoms = line.split(",");

				// Parcourir les mots de la ligne et mettre à jour le compteur
				for (String symptom : symptoms) {
					counterOfSymptoms.put(symptom, counterOfSymptoms.getOrDefault(symptom, 0) + 1);
					System.out.println("TEST 2 boucle for    "
							+ counterOfSymptoms.put(symptom, counterOfSymptoms.getOrDefault(symptom, 0) + 1));
				}

			}
			reader.close();

			// write symptoms in the output file
			FileWriter writer = new FileWriter(outputFile);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			// write results of the map count in the output file
			for (Map.Entry<String, Integer> entry : counterOfSymptoms.entrySet()) {
				bufferedWriter.write(entry.getKey() + ": " + entry.getValue());
				// go to a new line
				bufferedWriter.newLine();
			}
			// Fermeture du BufferedWriter
			System.out.println("Number of symptoms has been saved in the output file.");
			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println("TEST ERREUR");
			e.printStackTrace();
		}
	}

}
