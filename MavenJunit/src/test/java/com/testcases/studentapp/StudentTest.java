package com.testcases.studentapp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.acheron.training.Student;
import com.student.exception.ExceedingMarksException;
import com.student.exception.InvalidNumberException;
import com.student.exception.NegValueException;

class StudentTest {
	Student student=null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student = new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student = null;
	}

	@Test
	@DisplayName("testing positive value")
	void testTotalMarks() throws NegValueException, ExceedingMarksException {
		assertEquals(270, student.totalMarks(90, 90, 90));
	}
	@Test
	@DisplayName("Testing negative value")
	void testNegativeMarks() {
		assertThrows(NegValueException.class,()->student.totalMarks(78, -9, 9) );
	}
	@Test
	@DisplayName("testing exceeding marks")
	void testGreaterMarks() {
		assertThrows(ExceedingMarksException.class,()->student.totalMarks(105, 89, 90));
	}
	
	@Test
	@DisplayName("Test Grade A")
	void testGradeA() throws InvalidNumberException {
		int marks[] = {90,90,90};
		String grade = student.getGrade(marks);
		assertEquals("A", grade);
	}
	@Test
	@DisplayName("Test Grade B")
	void testGradeB() throws InvalidNumberException {
		int marks[] = {90,80,86};
		String grade = student.getGrade(marks);
		assertEquals("B", grade);
	}
	@Test
	@DisplayName("Test Grade C")
	void testGradeC() throws InvalidNumberException {
		int marks[] = {75,75,76};
		String grade = student.getGrade(marks);
		assertEquals("C", grade);
	}
	@Test
	@DisplayName("Test Grade D")
	void testGradeD() throws InvalidNumberException {
		int marks[] = {70,70,60};
		String grade = student.getGrade(marks);
		assertEquals("D", grade);
	}
	@Test
	@DisplayName("Test Grade E")
	void testGradeE() throws InvalidNumberException {
		int marks[] = {60,55,55};
		String grade = student.getGrade(marks);
		assertEquals("E", grade);
	}
	@Test
	@DisplayName("Test fails")
	void testFails() throws InvalidNumberException {
		int marks[] = {50,45,45};
		String grade = student.getGrade(marks);
		assertEquals("Fails", grade);
	}
	@Test
	@DisplayName("Testing Negative Grade")
	void testNegGrade() {
		int marks[] = {45,70,-39};
		assertThrows(InvalidNumberException.class,()->student.getGrade(marks));
	}
	@Test
	@DisplayName("Test grade greter than 100")
	void testExceedingGrade() {
		int marks[] = {109,156,100};
		assertThrows(InvalidNumberException.class,()->student.getGrade(marks));
		
	}
	@Test
	@DisplayName("test Grade NULL")
	void testGradeNull() {
		int marks[] =null;
		assertEquals("marks not initialized", student.getGrade(marks));
	}
	
}
 