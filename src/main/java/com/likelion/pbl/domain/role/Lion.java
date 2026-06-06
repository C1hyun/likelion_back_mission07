package com.likelion.pbl.domain.role;

import com.likelion.pbl.policy.LionSubmissionPolicy;
import com.likelion.pbl.policy.SubmissionPolicy;

public class Lion extends Role {

    private final String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }

    @Override public SubmissionPolicy getSubmissionPolicy() { return new LionSubmissionPolicy(); }
    @Override public String getRoleName() { return "아기사자"; }
}
