package com.demo.service; 
import com.demo.entity.Student; 
import com.demo.dao.StudentDao; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service
public class StudentServiceImpl implements StudentService { 
	@Autowired private StudentDao studentDao; 

	@Override public List<Student> getAllStudents() 
	{ 
		return studentDao.findAll(); 
	} 

	@Override public Student getStudentById(Long id) 
	{ 
		return studentDao.findById(id).orElse(null); 
	} 

	@Override public void saveStudent(Student student) 
	{ 
		studentDao.save(student); 
	} 

	@Override public void deleteStudent(Long id) 
	{ 
		studentDao.deleteById(id); 
	} 
}
