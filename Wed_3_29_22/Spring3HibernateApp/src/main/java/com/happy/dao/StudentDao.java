
package com.happy.dao;

import java.util.List;

import com.happy.bean.Student;

public interface StudentDao {

	public void addStudent(Student student);

	public List<Student> listStudents();

	public Student getStudent(int id);

	public void deleteStudent(Student student);

}
