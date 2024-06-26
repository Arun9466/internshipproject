package com.firststep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firststep.dto.SemesterRequest;
import com.firststep.entity.Course;
import com.firststep.entity.Semester;
import com.firststep.repo.CourseRepository;
import com.firststep.repo.SemesterRepository;

@Service
public class SemesterService {
	@Autowired
	private SemesterRepository semesterRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public Semester getSemesterById(int semesterId) {
        Semester existingSemester = semesterRepository.findById(semesterId).orElse(null);
        
        if (existingSemester != null) {
            return existingSemester;
        } else {
            throw new RuntimeException("Semester not found with ID: " + semesterId);
        }
    }

    public Semester addSemester(int course_id, SemesterRequest semesterRequest) {
        Course course = courseRepository.findById(course_id).orElse(null);
        if (course == null) {
            throw new RuntimeException("Course not found with ID: " + course_id);
        }
        Semester sem = new Semester(); 
        sem.setSem((int)semesterRequest.getSem()); 
        sem.setCourse(course);
        course.getSemesters().add(sem);
        courseRepository.save(course);
        semesterRepository.save(sem);
        return sem;
    }


    public Semester updateSemester(int semesterId, SemesterRequest updatedSemester) {
    	Semester existingSemester = semesterRepository.findById(semesterId).orElse(null);
        
        if (existingSemester != null) {
            existingSemester.setSem(updatedSemester.getSem());
            return semesterRepository.save(existingSemester);
        } else {
            throw new RuntimeException("Semester not found with ID: " + semesterId);
        }
    }

    public void deleteSemester(int semesterId) {
        boolean existingSemester = semesterRepository.existsById(semesterId);
        
        if (existingSemester) {
            semesterRepository.deleteById(semesterId);
        } else {
            throw new RuntimeException("Semester not found with ID: " + semesterId);
        }
    }
    
    public List<Semester> addAllSemesters(SemesterRequest semesterRequest){
    	List<Semester> sems = (List<Semester>) Semester.build(0, semesterRequest.getSem(),null,null,null);
    	return semesterRepository.saveAll(sems);
    }
}
