package com.school.schoolproject.service;

import com.school.schoolproject.entity.Course;
import com.school.schoolproject.entity.Teacher;
import com.school.schoolproject.exceptions.TeacherNotFoundEx;
import com.school.schoolproject.matcher.RegexMatcher;
import com.school.schoolproject.repositories.TeacherRepository;
import com.school.schoolproject.requests.CreateTeacherReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    TeacherRepository teacherRepository;
    CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher findOneById(int id){
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new TeacherNotFoundEx("Teacher Not Found"));
        return teacher;
    }


    public void deleteById(int id){
        teacherRepository.deleteById(id);
    }



    public Teacher createTeacher(CreateTeacherReq createTeacherReq) {
        boolean isValidEmail = RegexMatcher.matchEmail(createTeacherReq.getEmail());

        if(!isValidEmail){
            throw new RuntimeException("Provide a valid email");
        }
        Teacher teacher = new Teacher();
        teacher.setEmail(createTeacherReq.getEmail());
        teacher.setName(createTeacherReq.getName());

        return save(teacher);

    }

    public Teacher updateTeacher(CreateTeacherReq createTeacherReq, int id) {

        if(!RegexMatcher.matchEmail(createTeacherReq.getEmail())){
            throw new RuntimeException("Provide a valid email");
        }
        Teacher teacher = findOneById(id);

        teacher.setName(createTeacherReq.getName());
        teacher.setEmail(createTeacherReq.getEmail());

        return save(teacher);

    }



    public List<Course> findCoursesById(int id){
        return courseService.findAllByTeacherId(id);
    }


}
