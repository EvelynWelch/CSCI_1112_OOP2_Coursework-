// author: Evie Welch
// date 01/03/23

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class Exercise17_01 {	
	public static void main(String[] args) {	
		final String FILE_PATH_STRING = "Exercise17_01.txt";
		try {
			// Create the file if it doesn't exist
			File f = new File(FILE_PATH_STRING);
			f.createNewFile();
			try {
				// Open the file to write.
				FileWriter fw = new FileWriter(FILE_PATH_STRING, true);
				// Randomly generate numbers and append them to a StringBuilder
				StringBuilder numbers = new StringBuilder();
				for(int i = 0; i < 100; i++) {
					numbers.append(String.valueOf((int)(Math.random() * 100)) + " ");
				}
				// Add the numbers to the file
				fw.append(numbers.toString());
				
				fw.close();
			} catch (FileNotFoundException e) {
				// Catch if FileWriters doesn't find the file, The code shouldn't be able to get here.
				e.printStackTrace();
			}
		} catch (IOException e) {
			// Catch if File encounters and IOException
			e.printStackTrace();
		}		
		
	}

}
