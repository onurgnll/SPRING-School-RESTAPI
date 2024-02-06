package com.school.schoolproject.rest;

import com.school.schoolproject.entity.Class;
import com.school.schoolproject.responses.ResponseHandler;
import com.school.schoolproject.service.ClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {

    ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllClass(){
        return ResponseHandler.generateResponse(200, classService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> createClass(@RequestBody Class clas){
        try {

            Class classs = classService.save(clas);

            return ResponseHandler.generateResponse(200, classs);


        }catch (Exception e){
            return ResponseHandler.generateResponse(500, e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findClassById(@PathVariable int id) {

        try {
            return ResponseHandler.generateResponse(200, classService.findById(id));

        }catch (Exception e){
            return ResponseHandler.generateResponse(500, e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClassById(@PathVariable int id){

        try {
            classService.deleteById(id);

            return ResponseHandler.generateResponse(200);

        }catch (Exception e){

            return ResponseHandler.generateResponse(500, e.getMessage());
        }


    }

}
