package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	JFrame frame;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	JPanel panel;

	ArrayList<String> tasks = new ArrayList<String>();

	public ToDoList() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.add(panel);

		add = new JButton("add task");
		view = new JButton("view tasks");
		remove = new JButton("remove task");
		save = new JButton("save list");
		load = new JButton("load list");

		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);

		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);

		frame.setVisible(true);
		frame.pack();

		autoLoad();
	}

	public static void main(String[] args) {
		ToDoList t = new ToDoList();
	}

	public void autoLoad() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/list"));

			String line = br.readLine();
			tasks.add(line);
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					tasks.add(line);
				}
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add() {
		String ans = JOptionPane.showInputDialog("Enter a task");
		tasks.add(ans);
	}

	public void view() {
		String viewList = "";
		for (String s : tasks) {
			if (s != null) {
				viewList += s + '\n';
			}
		}

		if (viewList.equals("")) {
			JOptionPane.showMessageDialog(frame, "No tasks added");
		} else {
			JOptionPane.showMessageDialog(frame, viewList);
		}
	}

	public void remove() {
		Object[] options = tasks.toArray();

		if (options.length > 0) {
			int removeTask = JOptionPane.showConfirmDialog(panel, "Which task would you like to remove?", "Remove",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			tasks.remove(removeTask);
		} else {
			JOptionPane.showMessageDialog(frame, "No tasks to remove");
		}

	}

	public void save() {
		try {
			FileWriter fw = new FileWriter("src/_03_To_Do_List/list", true);
			for (String s : tasks) {
				fw.write(s);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		String fileName = "";
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			String line = br.readLine();
			tasks.add(line);
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					tasks.add(line);
				}
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			add();
		} else if (e.getSource() == view) {
			view();
		} else if (e.getSource() == remove) {
			remove();
		} else if (e.getSource() == save) {
			save();
		} else if (e.getSource() == load) {
			load();
		}
	}

}
