package ru.alexander_kramarenko.java_web_shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexander_kramarenko.java_web_shop.model.Role;
import ru.alexander_kramarenko.java_web_shop.repositories.RoleRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Optional<Role> findById(Long Id) {
        return roleRepository.findById(Id);
    }

    public Optional<Role> findByRoleName(String rolename) {
        return roleRepository.findByRoleName(rolename);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

}
