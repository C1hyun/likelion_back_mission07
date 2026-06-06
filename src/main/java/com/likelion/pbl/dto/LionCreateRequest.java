package com.likelion.pbl.dto;

public class LionCreateRequest {
    private String name;
    private String major;
    private int    generation;
    private String part;
    private String studentId;

    public LionCreateRequest() {}

    public String getName()       { return name; }
    public String getMajor()      { return major; }
    public int    getGeneration() { return generation; }
    public String getPart()       { return part; }
    public String getStudentId()  { return studentId; }

    public void setName(String name)             { this.name = name; }
    public void setMajor(String major)           { this.major = major; }
    public void setGeneration(int generation)    { this.generation = generation; }
    public void setPart(String part)             { this.part = part; }
    public void setStudentId(String studentId)   { this.studentId = studentId; }
}
