package _02_File_Encrypt_Decrypt;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("What do you want to encrypt. Enter letters only.");
		String keyS = JOptionPane.showInputDialog("Enter the key for the shift. Must be a number");
		int key = Integer.parseInt(keyS);

		encryptor(key, message);
	}

	public static String encryptor(int key, String message) {
		String s = "";
		for (int i = 0; i < message.length(); i++) {
			int c = (int) message.charAt(i);
			if (Character.isLetter(message.charAt(i))) {
				if (Character.isUpperCase(message.charAt(i))) {
					s += (char) (((c + key - 'A') % 26) + 'A');
				} else {
					s += (char) (((c + key - 'a') % 26) + 'a');
				}
			} else {
				s += message.charAt(i);
			}
		}
		System.out.println(message);
		System.out.println(s);
		return s;
	}

}
//Copyright © 2020 Aryahi Gupta