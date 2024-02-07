package com.school.schoolproject.service;

import com.school.schoolproject.entity.Class;
import com.school.schoolproject.exceptions.AlreadyExistException;
import com.school.schoolproject.exceptions.NotFoundException;
import com.school.schoolproject.repositories.ClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        if(classRepository.findByName(clas.getName()) != null){

            throw new AlreadyExistException("Bu isimde bir sınıf zaten bulunuyor");
        }

        return classRepository.save(clas);
    }


    public Class findById(int id){
        return classRepository.findById(id).orElseThrow(() -> new NotFoundException("Böyle Bir Sınıf Bulunmadı"));

    }

    @Transactional
    public void deleteById(int id){
        findById(id);
        classRepository.deleteById(id);
    }




}
