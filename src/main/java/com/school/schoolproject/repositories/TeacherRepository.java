package com.school.schoolproject.repositories;

import com.school.schoolproject.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher , Integer> {


    Teacher findByEmail(String email);

}
