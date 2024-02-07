package com.school.schoolproject.repositories;

import com.school.schoolproject.entity.Course;
import com.school.schoolproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {

    @Query("SELECT DISTINCT c FROM Student s JOIN s.courses c WHERE s.id = :id")
    List<Course> findCoursesByStudentId(int id);

    Student findByEmail(String email);
}
