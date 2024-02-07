package com.school.schoolproject.service;

import com.school.schoolproject.entity.Course;
import com.school.schoolproject.entity.Student;
import com.school.schoolproject.exceptions.AlreadyExistException;
import com.school.schoolproject.exceptions.NotFoundException;
import com.school.schoolproject.exceptions.NotValidException;
import com.school.schoolproject.matcher.RegexMatcher;
import com.school.schoolproject.repositories.StudentRepository;
import com.school.schoolproject.requests.CreateStudentReq;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Böyle bir öğrenci Bulunmadı"));

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
            throw new NotValidException("provide a valid email");
        }
        if(studentRepository.findByEmail(createStudentReq.getEmail()) != null){
            throw new AlreadyExistException("Böyle Bir Öğrenci Zaten Var");
        }
        Student student = new Student();

        student.setName(createStudentReq.getName());
        student.setEmail(createStudentReq.getEmail());

        return save(student);


    }
    public List<Course> findAllCoursesByStudentId(int id){
        findById(id);
        return studentRepository.findCoursesByStudentId(id);


    }

}
