package ru.alexander_kramarenko.java_web_shop.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexander_kramarenko.java_web_shop.model.Role;

@NoArgsConstructor
@Data
public class RoleDto {

    private Long id;
    private String name;

    public RoleDto(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }

}
