package com.tread;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class lambda {

	public static void main(String[] args) {
		System.out.println("hi");

		List<Student> students = new ArrayList<>();
		Student student = new Student();
		student.setAge(10);

		Student student1 = new Student();
		student1.setAge(15);

		students.add(student1);
		students.add(student);

		IntSummaryStatistics x = students.stream().collect( Collectors.summarizingInt(Student::getAge));
		

	}

}
