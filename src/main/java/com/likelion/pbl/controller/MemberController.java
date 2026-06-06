package com.likelion.pbl.controller;

import com.likelion.pbl.domain.role.Lion;
import com.likelion.pbl.domain.role.Role;
import com.likelion.pbl.domain.role.Staff;
import com.likelion.pbl.dto.*;
import com.likelion.pbl.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest req) {
        LionResponse response = memberService.createLion(req);
        if (response == null) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest req) {
        StaffResponse response = memberService.createStaff(req);
        if (response == null) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Optional<Role> found = memberService.findByName(name);
        if (found.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Role member = found.get();
        if (member instanceof Lion lion) {
            return ResponseEntity.ok(LionResponse.from(lion));
        } else if (member instanceof Staff staff) {
            return ResponseEntity.ok(StaffResponse.from(staff));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest req) {
        LionResponse response = memberService.updateLion(name, req);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest req) {
        StaffResponse response = memberService.updateStaff(name, req);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean deleted = memberService.deleteMember(name);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
