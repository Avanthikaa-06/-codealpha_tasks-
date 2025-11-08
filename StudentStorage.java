package org.grade;
import java.util.*;

public class StudentStorage {
	private ArrayList<String> studentNames;
	private ArrayList<ArrayList<Double>> studentMarks;
	private ArrayList<Double> studentAverages;
	private int numSubjects;
	
	public StudentStorage(int numSubjects) {
		this.numSubjects=numSubjects;
		studentNames = new ArrayList<>();
		studentMarks=new ArrayList<>();
		studentAverages = new ArrayList<>();
		
		
		}
	public void addStudent(String name,ArrayList<Double> marks) {
		studentNames.add(name);
		studentMarks.add(marks);
		 
		double total=0;
		for(double mark:marks) {
			total+=mark;
			
		}
		double average=total/numSubjects;
		studentAverages.add(average);
	}
	
	public void displaySummary() {
		if(studentNames.isEmpty()) {
			System.out.println("NO students have been added");
			return;
		}
		System.out.println("===============================");
		System.out.println("     STUDENT GRADE REPORT      ");
		System.out.println("===============================");
		System.out.printf("%-15s", "Student");
		 
		for(int j=0; j<numSubjects; j++) {
			System.out.printf("Sub%-6d", (j + 1));
			
		}
		System.out.printf("Average%n");
		
		for (int i=0;i<studentNames.size();i++) {
			 System.out.printf("%-15s", studentNames.get(i));
			 ArrayList<Double> marks = studentMarks.get(i);
			 for(double mark: marks) {
				 System.out.printf("%-8.2f", mark);
				 
			 }
			 System.out.printf("%.2f%n", studentAverages.get(i));
			 
			
		}
		displayClassStatistics();
		
}
	private void displayClassStatistics() {
		double highest = studentAverages.get(0);
		double lowest = studentAverages.get(0);
		int highIndex =0;
		int lowIndex=0;
		double totalAvg = 0;
		
		for(int i=0 ; i<studentAverages.size();i++) {
			double avg=studentAverages.get(i);
			totalAvg+=avg;
			if(avg>highest) {
				highest=avg;
				highIndex=i;
			}
			if (avg < lowest) {
                lowest = avg;
                lowIndex = i;
            }
		}
		double classAverage=totalAvg/studentAverages.size();
		
		System.out.println("\nClass Average: " + String.format("%.2f", classAverage));
        System.out.println("Highest Average: " + String.format("%.2f", highest) + " (" + studentNames.get(highIndex) + ")");
        System.out.println("Lowest Average : " + String.format("%.2f", lowest) + " (" + studentNames.get(lowIndex) + ")");
		
	}
}
