package _05_Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Complete this class so that it can be serialized.
 */
public class SaveData implements Serializable{
	public final String name;
	public final int age;
	private static final String DATA_FILE = "src/_04_Serialization/data";

	public SaveData(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}
//Copyright © 2020 Aryahi Gupta