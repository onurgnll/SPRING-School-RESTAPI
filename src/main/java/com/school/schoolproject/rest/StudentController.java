package com.school.schoolproject.rest;

import com.school.schoolproject.repositories.StudentRepository;
import com.school.schoolproject.requests.CreateStudentReq;
import com.school.schoolproject.responses.ResponseHandler;
import com.school.schoolproject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllStudents(){
        return ResponseHandler.generateResponse(200, studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestBody CreateStudentReq createStudentReq){
        try {
            return ResponseHandler.generateResponse(200, studentService.createStudent(createStudentReq));
        }catch (Exception ex){
            return ResponseHandler.generateResponse(500 , ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id){
            return ResponseHandler.generateResponse(200, studentService.findById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudentByid(@PathVariable int id){
        studentService.deleteById(id);
        return ResponseHandler.generateResponse(200 );
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<Object> getCoursesByStudentId(@PathVariable int id){

        return ResponseHandler.generateResponse(200, studentService.findAllCoursesByStudentId(id));

    }


}
