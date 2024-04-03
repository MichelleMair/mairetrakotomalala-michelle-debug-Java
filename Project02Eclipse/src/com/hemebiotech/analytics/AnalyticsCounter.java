package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public ISymptomReader reader;
	public ISymptomWriter writer;

	// Mon constructeur
	public void AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/*
	 * lecture du fichier d'entrée avec la méthode de la classe de lecture =>
	 * retourne un tableau ou une liste
	 */
	public List<String> GetSymptoms() {
		return reader.GetSymptoms();
	}

	/*
	 * countSymptoms est une méthode qui récupère le tableau de symptomes, compte
	 * les occurences des symptomes et retourne un Map
	 **/
	public Map<String, Integer> countSymptoms() {
		Map<String, Integer> symptomCountMap = new HashMap<>();
		List<String> symptoms = GetSymptoms();

		for (String symptom : symptoms) {
			symptomCountMap.put(symptom, symptomCountMap.getOrDefault(symptom, 0) + 1);
		}

		return symptomCountMap;
	}

	/*
	 * Méthode qui va trier par ordre alphabétique le Map reçu en entrée Cette
	 * méthode va se servir des clés donc des symptomes pour faire le tri
	 * 
	 **/
	public Map<String, Integer> sortMapByKey(Map<String, Integer> map) {
		Map<String, Integer> sortedSymptomCountMap = new TreeMap<>(map);
		return sortedSymptomCountMap;
	}

	/*
	 * Appel de la méthode writeSymptoms pour écrire dans le fichier de sortie
	 */
	public void writeSymptoms() {
		Map<String, Integer> symptomCountMap = countSymptoms();
		Map<String, Integer> sortedSymptomCountMap = sortMapByKey(symptomCountMap);
		writer.writeSymptoms(sortedSymptomCountMap);
	}

}
