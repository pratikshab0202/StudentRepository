package com.demo.dao; 
  
import com.demo.entity.Student; 
import org.springframework.data.jpa.repository.JpaRepository; 
public interface StudentDao 
    extends JpaRepository<Student, Long> { 
}