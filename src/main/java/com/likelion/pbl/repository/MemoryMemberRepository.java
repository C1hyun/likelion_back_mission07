package com.likelion.pbl.repository;

import com.likelion.pbl.domain.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private final List<Role> store = new ArrayList<>();

    @Override
    public void save(Role member) {
        store.add(member);
    }

    @Override
    public List<Role> findAll() {
        return List.copyOf(store);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return store.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst();
    }

    @Override
    public boolean existsByName(String name) {
        return store.stream()
                .anyMatch(m -> m.getName().equals(name));
    }

    @Override
    public void updateByName(String name, Role updated) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getName().equals(name)) {
                store.set(i, updated);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return store.removeIf(m -> m.getName().equals(name));
    }
}
