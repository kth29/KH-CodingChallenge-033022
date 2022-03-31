package com.happy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.happy.bean.Student;
import com.happy.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("command") Student studentBean, 
			BindingResult result) {
		Student student = prepareModel(studentBean);
		studentService.addStudent(student);
		return new ModelAndView("redirect:/addStudent.html");
	}

	@RequestMapping(value="/students", method = RequestMethod.GET)
	public ModelAndView listStudents() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students",  prepareListofBean(studentService.listStudents()));
		return new ModelAndView("studentList", model);
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ModelAndView addStudent(@ModelAttribute("command")  Student studentBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students",  prepareListofBean(studentService.listStudents()));
		return new ModelAndView("addStudent", model);
	}
	
	@RequestMapping(value = "/indexStudents", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("indexStudents");
	}
	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@ModelAttribute("command")  Student studentBean,
			BindingResult result) {
		studentService.deleteStudent(prepareModel(studentBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", null);
		model.put("students",  prepareListofBean(studentService.listStudents()));
		return new ModelAndView("addStudent", model);
	}
	
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public ModelAndView editStudent(@ModelAttribute("command")  Student StudentBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", prepareStudentBean(studentService.getStudent(StudentBean.getId())));
		model.put("students",  prepareListofBean(studentService.listStudents()));
		return new ModelAndView("addStudent", model);
	}
	
	private Student prepareModel(Student studentBean){
		Student Student = new Student();
		Student.setName(studentBean.getName());
		Student.setEmail(studentBean.getEmail());
		Student.setId(studentBean.getId());
		studentBean.setId(null);
		return Student;
	}
	
	private List<Student> prepareListofBean(List<Student> students){
		List<Student> beans = null;
		if(students != null && !students.isEmpty()){
			beans = new ArrayList<Student>();
			Student bean = null;
			for(Student student : students){
				bean = new Student();
				bean.setName(student.getName());
				bean.setId(student.getId());
				bean.setEmail(student.getEmail());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private Student prepareStudentBean(Student student){
		Student bean = new Student();
		bean.setName(student.getName());
		bean.setEmail(student.getEmail());
		bean.setId(student.getId());
		return bean;
	}
}


