package com.school.schoolproject.requests;

import lombok.Data;

import java.util.Date;

@Data
public class CreateCourseReq {
    private String title;

    private Date createDate;
    private int teacherId;
    private int classId;

}
