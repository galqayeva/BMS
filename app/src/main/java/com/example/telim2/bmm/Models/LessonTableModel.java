package com.example.telim2.bmm.Models;

/**
 * Created by telim2 on 23.09.2017.
 */

public class LessonTableModel {

    private  String subjectName;
    private String subjectGrade;


    public LessonTableModel(String subjectName, String subjectGrade) {
        this.subjectName = subjectName;
        this.subjectGrade = subjectGrade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectGrade() {
        return subjectGrade;
    }

    public void setSubjectGrade(String subjectGrade) {
        this.subjectGrade = subjectGrade;
    }
}
