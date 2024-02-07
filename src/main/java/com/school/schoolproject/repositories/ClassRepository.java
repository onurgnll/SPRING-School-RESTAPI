package com.school.schoolproject.repositories;

import com.school.schoolproject.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class , Integer> {

    Class findByName(String name);
}
