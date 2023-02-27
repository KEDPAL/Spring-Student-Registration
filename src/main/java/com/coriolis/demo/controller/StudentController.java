package com.coriolis.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coriolis.demo.dao.CourseRepository;
import com.coriolis.demo.dao.StudentRepository;
import com.coriolis.demo.model.Course;
import com.coriolis.demo.model.Student;
import com.coriolis.demo.util.CommonUtil;

@RestController
@RequestMapping("/v1/api")
public class StudentController {

	@Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/student")
    public ResponseEntity<?> getAll() {
        try {
            List<Student> students = studentRepository.findAll();

            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        Optional<Student> studentData = studentRepository.findById(id);

        if (studentData.isPresent()) {
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/student")
    public ResponseEntity<?> create(@RequestBody Student student) {
        try {
            Student _student = studentRepository.save(
                    new Student(student.getFirstName(), student.getLastName()));
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Student student) {
        Optional<Student> studentData = studentRepository.findById(id);

        if (studentData.isPresent()) {
            Student _student = studentData.get();
            _student.setFirstName(student.getFirstName());
            _student.setLastName(student.getLastName());
            return new ResponseEntity<>(studentRepository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/student")
    public ResponseEntity<?> deleteAll() {
        try {
            studentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/student/{id}/register/{course_id}", method = RequestMethod.POST)
    public ResponseEntity<?> register(@PathVariable("id") long id, @PathVariable("course_id") long course_id) {
        Optional<Student> studentData = studentRepository.findById(id);
        Optional<Course> courseData = courseRepository.findById(course_id);

        if (studentData.isPresent() && courseData.isPresent()) {
            Student _student = studentData.get();
            Course _course = courseData.get();
            
			/*
			 * if (_student.getCourses().size() < CommonUtil.COURSES_LIMIT &&
			 * _course.getStudents().size() < CommonUtil.STUDENTS_LIMIT) {
			 * 
			 * _student.getCourses().add(_course); return new
			 * ResponseEntity<>(studentRepository.save(_student), HttpStatus.OK); } else { return
			 * new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
			 */
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
