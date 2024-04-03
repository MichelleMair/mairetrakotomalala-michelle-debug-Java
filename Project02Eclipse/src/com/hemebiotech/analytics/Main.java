package com.hemebiotech.analytics;

public class Main {

	public static void main(String[] args) {
		// Instanciation de l'interface ISymptomReader
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

		// Instanciation de l'interface ISymptomWriter
		ISymptomWriter writer = new WriteSymptomDataToFile();

		// Instanciation de la classe AnalyticsCounter
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();

		// Appel du reader pour lire le fichier en input
		analyticsCounter.AnalyticsCounter(reader, writer);

		/*
		 * Appel du writer pour écrire dans le fichier result.out qui va faire appelle à
		 * la méthode countSymptoms() et à la méthode sotMapByKey() pour sortir les
		 * symptomes et leurs occurrences triés par odre alphabétique
		 * 
		 */
		analyticsCounter.writeSymptoms();
	}

}
