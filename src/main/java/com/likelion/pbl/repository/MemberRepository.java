package com.likelion.pbl.repository;

import com.likelion.pbl.domain.role.Role;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void           save(Role member);
    List<Role>     findAll();
    Optional<Role> findByName(String name);
    boolean        existsByName(String name);
    void           updateByName(String name, Role updated);
    boolean        deleteByName(String name);
}
