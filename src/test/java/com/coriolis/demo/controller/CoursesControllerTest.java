package com.coriolis.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import com.coriolis.demo.model.Course;

@ExtendWith(MockitoExtension.class)
public class CoursesControllerTest {

	private MockMvc mockMvc;
	
    @InjectMocks
    private CourseController courseController;
    @Mock
    private CourseRepository courseRepository;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(courseController)
                .build();
    }
    
    @Test
    public void getAll() throws Exception {
        List<Course> courses = Arrays.asList(new Course("TestCourse"),new Course("TestCourse2"),
        		new Course("TestCourse3"),new Course("TestCourse4"));
        Mockito.when(courseRepository.findAll()).thenReturn(courses);
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/course"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void getById() throws Exception {
        Optional<Course> course = Optional.of(new Course("TestCourse"));
        Mockito.when(courseRepository.findById(1l)).thenReturn(course);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/course/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/api/course/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
