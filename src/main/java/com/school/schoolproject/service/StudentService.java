package com.school.schoolproject.service;

import com.school.schoolproject.entity.Course;
import com.school.schoolproject.entity.Student;
import com.school.schoolproject.exceptions.StudentNotFoundEx;
import com.school.schoolproject.matcher.RegexMatcher;
import com.school.schoolproject.repositories.StudentRepository;
import com.school.schoolproject.requests.CreateStudentReq;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
       return studentRepository.findAll();
    }

    public Student findById(int id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundEx("Student Bulunmadı"));

        return student;
    }

    @Transactional
    public void deleteById(int id){
        studentRepository.deleteById(id);
    }

    @Transactional
    public Student save(Student student){
        return studentRepository.save(student);
    }


    public Student createStudent(CreateStudentReq createStudentReq) {

        if(!RegexMatcher.matchEmail(createStudentReq.getEmail())){
            throw new RuntimeException("provide a valid email");
        }

        Student student = new Student();

        student.setName(createStudentReq.getName());
        student.setEmail(createStudentReq.getEmail());

        return save(student);


    }
    public List<Course> findAllCoursesByStudentId(int id){

        return studentRepository.findCoursesByStudentId(id);


    }

}
