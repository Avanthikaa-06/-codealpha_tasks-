package org.grade;
import java.util.*;

public class StudentGradeTracker {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("=====STUDENT GRADE TRACKER=====");
	System.out.println("Enter number of subjects:");
	int numSubjects = sc.nextInt();
	 
	StudentStorage storage= new StudentStorage(numSubjects);
	while(true) {
		System.out.println("\n---MENU----");
		System.out.println("1.Add Student");
		System.out.println("2.View Summary Report");
		System.out.println("3.Exit");
		System.out.println("Enter your choice:");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			addStudent(storage,sc,numSubjects);
			break;
			
		case 2:
			 storage.displaySummary();
             break;
             
		case 3:
			 System.out.println("Exiting program... Goodbye!");
             sc.close();
             return;
		default:
            System.out.println("Invalid choice! Please try again.");
            
	}
	}
	
		
	}
	 private static void addStudent(StudentStorage storage, Scanner sc, int numSubjects) {
	        System.out.print("\nEnter student name: ");
	        String name = sc.next();

	        ArrayList<Double> marks = new ArrayList<>();
	        for (int i = 0; i < numSubjects; i++) {
	            System.out.print("Enter marks for subject " + (i + 1) + ": ");
	            double mark = sc.nextDouble();
	            marks.add(mark);
	        }

	        storage.addStudent(name, marks);
	        System.out.println("Student added successfully!");
	    }
	}


