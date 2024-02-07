package com.school.schoolproject.rest;

import com.school.schoolproject.requests.CreateTeacherReq;
import com.school.schoolproject.responses.ResponseHandler;
import com.school.schoolproject.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllTeachers() {

        return ResponseHandler.generateResponse(200, teacherService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> createTeacher(@RequestBody CreateTeacherReq createTeacherReq) {

        return ResponseHandler.generateResponse(200, teacherService.createTeacher(createTeacherReq));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTeacher(@RequestBody CreateTeacherReq createTeacherReq, @PathVariable int id) {
        return ResponseHandler.generateResponse(200, teacherService.updateTeacher(createTeacherReq, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTeacher(@PathVariable int id) {
        teacherService.deleteById(id);
        return ResponseHandler.generateResponse(200);


    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        return ResponseHandler.generateResponse(200, teacherService.findOneById(id));

    }


    @GetMapping("/{id}/courses")
    public ResponseEntity<Object> findCoursesByTeacherId(@PathVariable int id) {
        return ResponseHandler.generateResponse(200, teacherService.findCoursesById(id));

    }
}
