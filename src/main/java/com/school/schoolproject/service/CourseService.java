package com.school.schoolproject.service;

import com.school.schoolproject.entity.Class;
import com.school.schoolproject.entity.Course;
import com.school.schoolproject.entity.Student;
import com.school.schoolproject.entity.Teacher;
import com.school.schoolproject.exceptions.CourseNotFoundEx;
import com.school.schoolproject.repositories.CourseRepository;
import com.school.schoolproject.requests.AddStudentToCourseReq;
import com.school.schoolproject.requests.CreateCourseReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    CourseRepository courseRepository;
    TeacherService teacherService;
    ClassService classService;
    StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService){this.studentService = studentService;}

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public CourseService(CourseRepository courseRepository, ClassService classService) {
        this.courseRepository = courseRepository;
        this.classService = classService;
    }

    public List<Course> findAll(){

        return courseRepository.findAll();
    }

    public Course findById(int id){
        return courseRepository.findById(id).orElseThrow(()->new CourseNotFoundEx("Course Not Found"));
    }

    @Transactional
    public void deleteById(int id){
        Course course = findById(id);

        courseRepository.deleteById(id);

    }

    @Transactional
    public Course save(Course course){
        return courseRepository.save(course);
    }

    @Transactional
    public Course createCourse(CreateCourseReq createCourseReq){

        Teacher teacher = teacherService.findOneById(createCourseReq.getTeacherId()) ;
        Class aclass = classService.findById(createCourseReq.getClassId());

        Course course = new Course();
        course.setTitle(createCourseReq.getTitle());
        course.setCreateDate(createCourseReq.getCreateDate());
        course.setTeacher(teacher);
        course.setAClass(aclass);

        return save(course);
    }

    public List<Course> findAllByTeacherId(int id) {
        return courseRepository.findAllByTeacherId(id);

    }


    public Course addStudentToCourse(AddStudentToCourseReq addStudentToCourseReq) {

        Student student = studentService.findById(addStudentToCourseReq.getStudentId());

        Course course = findById(addStudentToCourseReq.getCourseId());

        course.getStudents().add(student);
        //System.out.println(course);

        return  save(course);

    }

    public List<Student> findAllStudentsById(int id) {
        return courseRepository.findStudentsById(id);
    }
}
