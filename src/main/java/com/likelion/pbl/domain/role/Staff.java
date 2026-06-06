package com.likelion.pbl.domain.role;

import com.likelion.pbl.policy.StaffSubmissionPolicy;
import com.likelion.pbl.policy.SubmissionPolicy;

public class Staff extends Role {

    private final String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public String getPosition() { return position; }

    @Override public SubmissionPolicy getSubmissionPolicy() { return new StaffSubmissionPolicy(); }
    @Override public String getRoleName() { return "운영진"; }
}
