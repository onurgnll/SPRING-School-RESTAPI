package com.school.schoolproject.rest;

import com.school.schoolproject.entity.Course;
import com.school.schoolproject.entity.Student;
import com.school.schoolproject.requests.AddStudentToCourseReq;
import com.school.schoolproject.requests.CreateCourseReq;
import com.school.schoolproject.responses.ResponseHandler;
import com.school.schoolproject.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllCourses() {
        return ResponseHandler.generateResponse(200, courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable int id) {
        return ResponseHandler.generateResponse(200, courseService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Object> createCourse(@RequestBody CreateCourseReq createCourseReq) {
        return ResponseHandler.generateResponse(200, courseService.createCourse(createCourseReq));
    }


    @PostMapping("/add")
    public ResponseEntity<Object> addStudentToCourse(@RequestBody AddStudentToCourseReq addStudentToCourseReq) {

        Course course = courseService.addStudentToCourse(addStudentToCourseReq);

        return ResponseHandler.generateResponse(200, course);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<Object> getAllStudents(@PathVariable int id) {
        return ResponseHandler.generateResponse(200, courseService.findAllStudentsById(id));
    }


}
