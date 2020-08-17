package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIteratorCode {

	public static void main(String[] args) {
		fileChooser(null);
	}

	public static void fileChooser(File file) {
		JFileChooser jfc;
		if (file == null) {
			jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File directory = jfc.getSelectedFile();
				File[] files = directory.listFiles();
				if (files != null) {
					for (File f : files) {
						if (f.isDirectory()) {
							fileChooser(f);
						} else if (f.getName().endsWith(".java")) {
							fileWriter(f);
						}
					}
				}
			}
		} else {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					if (f.isDirectory()) {
						fileChooser(f);
					} else if (f.getName().endsWith(".java")) {
						fileWriter(f);
					}
				}
			}
		}
	}
	
	public static void fileWriter(File f) {
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.append("//Copyright © 2020 Aryahi Gupta");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
//Copyright © 2020 Aryahi Gupta