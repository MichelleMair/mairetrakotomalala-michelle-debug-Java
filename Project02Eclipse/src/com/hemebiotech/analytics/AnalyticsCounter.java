package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) throws Exception {

		try {
			// Create a file fileReader to read symptoms.txt
			FileReader fileReader = new FileReader("./Project02Eclipse/symptoms.txt");

			// Create a bufferedReader which use fileReader
			BufferedReader reader = new BufferedReader(fileReader);

			String line = reader.readLine();

			int i = 0; // set i to 0
			while (line != null) {
				i++;

				// reading the line
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				} else if (line.equals("rush")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				}

				line = reader.readLine(); // get another symptom
			}
			reader.close();
			// next generate output
			FileWriter writer = new FileWriter("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dilated pupils: " + pupilCount + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
