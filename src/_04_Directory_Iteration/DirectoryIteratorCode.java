package _04_Directory_Iteration;

import java.io.File;

import javax.swing.JFileChooser;

public class DirectoryIteratorCode {
	
	public static void main(String[] args) {
	
	}
	
	public static void fileChooser(File file) {
		JFileChooser jfc = new JFileChooser();
	
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();
			if(files != null) {
				for(File f : files) {
				  if(f.isDirectory()) {
					 fileChooser(f);
				  }
				}
			}
		}
	}
}
