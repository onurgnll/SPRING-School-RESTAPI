package com.school.schoolproject.rest;

import com.school.schoolproject.exceptions.TeacherNotFoundEx;
import com.school.schoolproject.requests.CreateTeacherReq;
import com.school.schoolproject.responses.ResponseHandler;
import com.school.schoolproject.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllTeachers(){

        return ResponseHandler.generateResponse(200, teacherService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> createTeacher(@RequestBody CreateTeacherReq createTeacherReq){
        try {
            return ResponseHandler.generateResponse(200, teacherService.createTeacher(createTeacherReq));


        }catch (Exception e){
            return ResponseHandler.generateResponse(500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTeacher(@RequestBody CreateTeacherReq createTeacherReq, @PathVariable int id){
        try {
            return ResponseHandler.generateResponse(200, teacherService.updateTeacher(createTeacherReq , id));


        }catch (Exception e){
            return ResponseHandler.generateResponse(500, e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTeacher(@PathVariable int id){
        try {
            teacherService.deleteById(id);
            return ResponseHandler.generateResponse(200);

        }catch (Exception e){
            return ResponseHandler.generateResponse(500, e.getMessage());
        }

    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id){
        try {
            return ResponseHandler.generateResponse(200, teacherService.findOneById(id));

        }catch (TeacherNotFoundEx ex){
            return ResponseHandler.generateResponse(404, ex.getMessage());
        }
        catch (Exception e){
            return ResponseHandler.generateResponse(500, e.getMessage());
        }
    }

}
