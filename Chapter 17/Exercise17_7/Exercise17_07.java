// Author: Evie Welch
// date: 03/02/23

import java.io.*;
import java.util.ArrayList;

public class Exercise17_07 {

	public static void outputData() throws Exception {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
		ArrayList<Loan> loans = new ArrayList<>();
		try {
			while (true) {
				Loan loan = (Loan) input.readObject();
				loans.add(loan);
			}
		} catch (EOFException e) {
			double total = 0;
			for (int i = 0; i < loans.size(); i++) {
				double amount = loans.get(i).getLoanAmount();
				System.out.println("Loan " + (i + 1) + " amount: " + amount);
				total += amount;
			}
			System.out.println("Total amount of all loans: " + total);
		}
	}

	public static void main(String[] args) throws Exception {
		Loan loan1 = new Loan();
		Loan loan2 = new Loan(1.8, 10, 10000);

		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));) {
			output.writeObject(loan1);
			output.writeObject(loan2);
		} catch (IOException ex) {
			System.out.println("File could not be opened");
		}
		outputData();
	}
}
