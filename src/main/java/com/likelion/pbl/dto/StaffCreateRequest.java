package com.likelion.pbl.dto;

public class StaffCreateRequest {
    private String name;
    private String major;
    private int    generation;
    private String part;
    private String position;

    public StaffCreateRequest() {}

    public String getName()       { return name; }
    public String getMajor()      { return major; }
    public int    getGeneration() { return generation; }
    public String getPart()       { return part; }
    public String getPosition()   { return position; }

    public void setName(String name)           { this.name = name; }
    public void setMajor(String major)         { this.major = major; }
    public void setGeneration(int generation)  { this.generation = generation; }
    public void setPart(String part)           { this.part = part; }
    public void setPosition(String position)   { this.position = position; }
}
