package com.example.Lab09.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseProgramId implements Serializable {

    private String courseId;
    private Integer programId;

    public CourseProgramId() {}

    public CourseProgramId(String courseId, Integer programId) {
        this.courseId = courseId;
        this.programId = programId;
    }

    // Getters and setters
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseProgramId that = (CourseProgramId) o;
        return courseId.equals(that.courseId) && programId.equals(that.programId);
    }

    @Override
    public int hashCode() {
        return 31 * courseId.hashCode() + programId.hashCode();
    }
}
