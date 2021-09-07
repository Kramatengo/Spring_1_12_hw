package ru.alexander_kramarenko.java_web_shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.alexander_kramarenko.java_web_shop.dtos.UserRegRequest;
import ru.alexander_kramarenko.java_web_shop.exceptions.DataValidationException;
import ru.alexander_kramarenko.java_web_shop.model.User;
import ru.alexander_kramarenko.java_web_shop.model.UserRole;
import ru.alexander_kramarenko.java_web_shop.services.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reg_user")
@RequiredArgsConstructor
public class UserRegController {

    private final String INITIAL_USER_ROLE = "ROLE_USER";

    private final ProductService productService;
    private final UserService userService;
    private final RoleService roleService;
    private final UserRoleService userRoleService;
    private final CategoryService categoryService;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    public UserRegRequest save(@RequestBody @Validated UserRegRequest userRegRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataValidationException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        User user = new User();
        user.setUsername(userRegRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userRegRequest.getPassword()));
        user.setEmail(userRegRequest.getEmail());
        userService.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleService.findByRoleName(INITIAL_USER_ROLE).stream().map(role -> role.getId()).collect(Collectors.toList()).get(0));
        userRoleService.save(userRole);

        return new UserRegRequest(user);
    }
}
