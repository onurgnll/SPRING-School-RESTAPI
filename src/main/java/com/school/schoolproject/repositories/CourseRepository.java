package com.school.schoolproject.repositories;

import com.school.schoolproject.entity.Course;
import com.school.schoolproject.entity.Student;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course , Integer> {

    List<Course> findAllByTeacherId(int teacherId);

    @Query("SELECT DISTINCT s FROM Course c JOIN c.students s WHERE c.id IN :id")
    List<Student> findStudentsById(int id);
}
