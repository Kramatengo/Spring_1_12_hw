package ru.alexander_kramarenko.java_web_shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexander_kramarenko.java_web_shop.model.UserRole;
import ru.alexander_kramarenko.java_web_shop.repositories.UserRoleRepository;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

}
