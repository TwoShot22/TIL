package LinkedList_Example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AttendantsMain {
	public static void main(String[] args) {
		MyLinkedList me = new MyLinkedList();
		
		Scanner keyboard;
		keyboard = new Scanner(System.in);
		
		while(true) {
			System.out.print("\n command?");
			String command = keyboard.next();
			if(command.equals("f")) {
				try {
					Scanner inFile = new Scanner(new File("input.txt"));
					while(inFile.hasNext()) {
						String str = inFile.next();
						me.add(str);
					}
					inFile.close();
				} catch (FileNotFoundException e) {
					System.out.println(" >>> Input File not Found");
				}
			} else if(command.equals("i")) {
				String name = keyboard.next();
				// insert name
				me.add(name);
			} else if(command.equals("d")) {
				String name = keyboard.next();
				// delete the name
				boolean result = me.remove(name);
				System.out.println("Delete : "+result);
			} else if(command.equals("h")) {
				// print out the number of student
				System.out.println("Number of Student : "+me.size());
			} else if(command.equals("a")) {
				String name = keyboard.next();
				// check the name in the list
				int result = me.indexOf(name);
				System.out.println("Search Result : "+result);
			} else if(command.equals("p")) {
				// print the list
				System.out.println("[ Attendant List ] ");
				System.out.println(me.toString());
			} else if(command.equals("x")) {
				break;
			} else {
				System.out.println("\n Wrong Command... Try Again!");
			}
		}
		keyboard.close();
	}
}
