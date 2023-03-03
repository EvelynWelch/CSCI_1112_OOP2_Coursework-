// author: Evie Welch
// date:  03/02/23

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Excersize17_14_15 {

	public static void encrypter(String inFile, String outFile) throws Exception {
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(inFile));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outFile));
		int r;
		while ((r = input.read()) != -1) {
			output.write(r);
			output.write((byte) 5);
		}

		input.close();
		output.close();
		System.out.printf("file: %s, encrypted to file: %s %n", inFile, outFile);
	}

	public static void dec(String inFile, String outFile) throws Exception {
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(inFile));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outFile));
		int r;
		while ((r = input.read()) != -1) {
			output.write(r);
		}
		System.out.printf("encrypted file: %s, decrypted to file: %s", inFile, outFile);
		input.close();
		output.close();
	}

	public static void main(String[] args) {
		String inFile = "preEncryptedFile.txt";
		String encFile = "encryptedFile.dat";
		String deEncFile = "decryptedFile.txt";
		try {
			encrypter(inFile, encFile);
			dec(encFile, deEncFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
