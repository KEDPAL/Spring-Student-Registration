package com.coriolis.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.coriolis.demo.dao.CourseRepository;
import com.coriolis.demo.dao.StudentRepository;
import com.coriolis.demo.model.Course;
import com.coriolis.demo.model.Student;

@ExtendWith(MockitoExtension.class)
public class StudentsControllerTest {
	
    private MockMvc mockMvc;
    
    @InjectMocks
    private StudentController studentsController;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private CourseRepository courseRepository;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(studentsController)
                .build();
    }
    
    @Test
    public void getAll() throws Exception {
        List<Student> students = Arrays.asList(new Student("Amit", "Shinde"));
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/student"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void getById() throws Exception {
        Optional<Student> student = Optional.of(new Student("Amit", "Shinde"));
        Mockito.when(studentRepository.findById(1l)).thenReturn(student);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/student/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/api/student/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }
    
    @Test
    public void register() throws Exception {
        Optional<Student> student = Optional.of(new Student("Amit", "Shinde"));
        Mockito.when(studentRepository.findById(1l)).thenReturn(student);
        Optional<Course> course = Optional.of(new Course("Test course"));
        Mockito.when(courseRepository.findById(1l)).thenReturn(course);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/student/1/register/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}