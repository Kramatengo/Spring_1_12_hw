package ru.alexander_kramarenko.java_web_shop.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRoleDto {

    private Long userId;
    private Long roleId;

    public UserRoleDto(UserRoleDto userRoleDto) {
        this.userId = userRoleDto.getUserId();
        this.roleId = userRoleDto.getRoleId();
    }
}
