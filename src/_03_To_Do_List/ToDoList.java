package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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

	}

	public static void main(String[] args) {
		ToDoList t = new ToDoList();
	}

	public void add() {
		String ans = JOptionPane.showInputDialog("Enter a task");
		tasks.add(ans);
	}

	public void view() {
		String viewList = "";
		for(String s: tasks) {
			viewList += s + '\n';
		}
		
		JOptionPane.showMessageDialog(frame, viewList );
	}

	public void remove() {
		// create jop with buttons of each list
		// whichever button is pressed will be removed
	}

	public void save() {

	}

	public void load() {

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
