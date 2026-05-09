package org.example.model;

public class Course {
    private String courseCode;
    private String courseTitle;
    private int creditUnits;

    public Course(String code, String title, int units) {
        this.courseCode = code;
        this.courseTitle = title;
        this.creditUnits = units;
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseTitle() { return courseTitle; }
    public int getCreditUnits() { return creditUnits; }
    public void setCourseTitle(String courseTitle) { this.courseTitle = courseTitle;}
    public void setCreditUnits(int creditUnits) { this.creditUnits = creditUnits;
    }
}