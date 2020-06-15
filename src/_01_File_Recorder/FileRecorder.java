package _01_File_Recorder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Write a message");
		
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/test.txt");
			fw.write(message);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader("src/_01_File_Recorder/test.txt");
			int counter = fr.read();
			while(counter != -1){
				System.out.print((char)counter);
				counter = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
