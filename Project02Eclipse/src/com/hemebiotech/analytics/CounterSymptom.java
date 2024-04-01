package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CounterSymptom {

	public static Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCountMap = new HashMap<>();

		for (String symptom : symptoms) {
			symptomCountMap.put(symptom, symptomCountMap.getOrDefault(symptom, 0) + 1);
		}

		return symptomCountMap;
	}

}
