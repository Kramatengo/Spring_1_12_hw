package ru.alexander_kramarenko.java_web_shop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users_roles")
public class UserRole {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

}
