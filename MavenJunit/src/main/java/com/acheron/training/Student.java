package com.acheron.training;

import com.student.exception.ExceedingMarksException;
import com.student.exception.InvalidNumberException;
import com.student.exception.NegValueException;

public class Student {
	public int totalMarks(int marks1, int marks2, int marks3) throws NegValueException, ExceedingMarksException {
		if (marks1 < 0 || marks2 < 0 || marks3 < 0)
			throw new NegValueException("Negative");
		if (marks1 > 100 || marks2 > 100 || marks3 > 100)
			throw new ExceedingMarksException("Greater than 100");
		return marks1 + marks2 + marks3;
	}

	public String getGrade(int[] marks) throws InvalidNumberException {
		int sum = 0;
		if(marks!=null) {
		for (int mark : marks) {
			if (mark < 0 || mark > 100)
				throw new InvalidNumberException("Invalid number");
			sum += mark;
		}
		int avg = sum / marks.length;
		if (avg >= 90)
			return "A";
		else if (avg >= 80 && avg < 90)
			return "B";
		else if (avg >= 70 && avg < 80)
			return "C";
		else if (avg >= 60 && avg < 70)
			return "D";
		else if (avg >= 50 && avg < 60)
			return "E";
		else if (avg < 50)
			return "Fails";
		}
		return "marks not initialized";

	}

}
