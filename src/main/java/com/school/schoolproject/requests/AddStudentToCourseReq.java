package com.school.schoolproject.requests;

import lombok.Data;

@Data
public class AddStudentToCourseReq {
    private int studentId;
    private int courseId;
}
