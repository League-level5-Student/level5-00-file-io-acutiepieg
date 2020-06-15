package _02_File_Encrypt_Decrypt;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("What do you want to decrypt. Enter letters only.");
		String keyS = JOptionPane.showInputDialog("Enter the key for the shift. Must be a number");
		int key = Integer.parseInt(keyS);

		decryptor(key, message);
	}

	private static String decryptor(int key, String message) {
		String s = "";
		for (int i = 0; i < message.length(); i++) {
			int c = (int) message.charAt(i);
			if (Character.isLetter(message.charAt(i))) {
				if (Character.isUpperCase(message.charAt(i))) {
					s += (char) (((c - key - 'Z') % 26) + 'Z');
				} else {
					s += (char) (((c - key - 'z') % 26) + 'z');
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


