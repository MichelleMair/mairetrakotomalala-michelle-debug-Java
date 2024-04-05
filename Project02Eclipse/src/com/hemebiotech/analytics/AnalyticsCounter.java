package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * AnalyticsCounter class serves as a controller for analyzing symptoms data
 */
public class AnalyticsCounter {

	public ISymptomReader reader;
	public ISymptomWriter writer;
	private List<String> symptomsList;

	/**
	 * Constructor
	 * 
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Read an input file and store the list in a variable (symptomsList)
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	public List<String> getSymptoms() {
		if (symptomsList == null) {
			symptomsList = reader.getSymptoms();
		}
		return symptomsList;
	}

	/**
	 * This method count the occurrences of each symptom from a list of symptoms
	 * (using symptomsList) and stores the count in a Map
	 * 
	 * @return a map with symptoms and their count
	 */
	public Map<String, Integer> countSymptoms() {
		Map<String, Integer> symptomCountMap = new HashMap<>();
		List<String> symptoms = symptomsList;

		for (String symptom : symptoms) {
			symptomCountMap.put(symptom, symptomCountMap.getOrDefault(symptom, 0) + 1);
		}

		return symptomCountMap;
	}

	/**
	 * This method sorts the Map passed as a parameter by alphabetical order of keys
	 * (which are symptoms) and returns the sorted Map. It uses a TreeMap to perfom
	 * the sorting
	 * 
	 * @param map
	 * @return a treeMap
	 */
	public Map<String, Integer> sortMapByKey(Map<String, Integer> map) {
		Map<String, Integer> sortedSymptomCountMap = new TreeMap<>(map);
		return sortedSymptomCountMap;
	}

	/**
	 * This method writeSymptoms() retrieves the occurrences of each symptom from
	 * the countSymptoms() method Then sorts these occurrences alphabetically using
	 * the sortMapByKey() method And finally writes the sorted symptoms and their
	 * occurrences to an output file (result.out)
	 */
	public void writeSymptoms() {
		Map<String, Integer> symptomCountMap = countSymptoms();
		Map<String, Integer> sortedSymptomCountMap = sortMapByKey(symptomCountMap);
		writer.writeSymptoms(sortedSymptomCountMap);
	}

}
