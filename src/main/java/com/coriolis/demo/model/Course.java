package com.coriolis.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")
public class Course {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

	/*
	 * @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
	 * CascadeType.MERGE }, mappedBy = "course")
	 * 
	 * @JsonIgnore private Set<Student> students = new HashSet<>();
	 */
    
    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	/*
	 * public Set<Student> getStudents() { return students; }
	 * 
	 * public void setStudents(Set<Student> students) { this.students = students; }
	 */

}
