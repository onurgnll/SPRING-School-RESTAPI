package com.school.schoolproject.service;

import com.school.schoolproject.entity.Class;
import com.school.schoolproject.repositories.ClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<Class> findAll(){
        return classRepository.findAll();
    }

    @Transactional
    public Class save(Class clas){
        return classRepository.save(clas);
    }


    public Class findById(int id){
        Class clas = null;
        Optional optional = classRepository.findById(id);
        if (optional.isPresent()){
            clas = (Class) optional.get();
        }
        return clas;
    }

    @Transactional
    public void deleteById(int id){
        classRepository.deleteById(id);
    }




}
