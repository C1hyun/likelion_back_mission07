package com.likelion.pbl.service;

import com.likelion.pbl.domain.role.Lion;
import com.likelion.pbl.domain.role.Role;
import com.likelion.pbl.domain.role.Staff;
import com.likelion.pbl.dto.*;
import com.likelion.pbl.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public LionResponse createLion(LionCreateRequest req) {
        if (repository.existsByName(req.getName())) return null;
        Lion lion = new Lion(
                req.getName(), req.getMajor(), req.getGeneration(),
                req.getPart(), req.getStudentId());
        repository.save(lion);
        return LionResponse.from(lion);
    }

    public StaffResponse createStaff(StaffCreateRequest req) {
        if (repository.existsByName(req.getName())) return null;
        Staff staff = new Staff(
                req.getName(), req.getMajor(), req.getGeneration(),
                req.getPart(), req.getPosition());
        repository.save(staff);
        return StaffResponse.from(staff);
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Optional<Role> findByName(String name) {
        return repository.findByName(name);
    }

    public LionResponse updateLion(String name, LionUpdateRequest req) {
        Optional<Role> found = repository.findByName(name);
        if (found.isEmpty()) return null;

        Lion updated = new Lion(
                name, req.getMajor(), req.getGeneration(),
                req.getPart(), req.getStudentId());
        repository.updateByName(name, updated);
        return LionResponse.from(updated);
    }

    public StaffResponse updateStaff(String name, StaffUpdateRequest req) {
        Optional<Role> found = repository.findByName(name);
        if (found.isEmpty()) return null;

        Staff updated = new Staff(
                name, req.getMajor(), req.getGeneration(),
                req.getPart(), req.getPosition());
        repository.updateByName(name, updated);
        return StaffResponse.from(updated);
    }

    public boolean deleteMember(String name) {
        return repository.deleteByName(name);
    }
}
