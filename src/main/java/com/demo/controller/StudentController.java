package com.demo.controller; 

import com.demo.entity.Student; 
import com.demo.service.StudentService; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*; 

@Controller
@RequestMapping("/students") 
public class StudentController { 
	@Autowired private StudentService studentService; 

	@GetMapping public String listStudents(Model model) 
	{ 
		List<Student> students 
			= studentService.getAllStudents(); 
		model.addAttribute("students", students); 
		return "student/list"; // This should match with the actual template path 
	} 

	@GetMapping("/add") 
	public String showAddForm(Model model) 
	{ 
		model.addAttribute("student", new Student()); 
		return "student/add"; 
	} 

	@PostMapping("/add") 
	public String 
	addStudent(@ModelAttribute("student") Student student) 
	{ 
		studentService.saveStudent(student); 
		return "redirect:/students"; 
	} 

	@GetMapping("/edit/{id}") 
	public String showEditForm(@PathVariable Long id, 
							Model model) 
	{ 
		Student student = studentService.getStudentById(id); 
		model.addAttribute("student", student); 
		return "student/edit"; 
	} 

	@PostMapping("/edit/{id}") 
	public String 
	editStudent(@PathVariable Long id, 
				@ModelAttribute("student") Student student) 
	{ 
		studentService.saveStudent(student); 
		return "redirect:/students"; 
	} 

	@GetMapping("/delete/{id}") 
	public String deleteStudent(@PathVariable Long id) 
	{ 
		studentService.deleteStudent(id); 
		return "redirect:/students"; 
	} 
}
