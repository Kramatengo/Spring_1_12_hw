package ru.alexander_kramarenko.java_web_shop.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexander_kramarenko.java_web_shop.model.User;

@NoArgsConstructor
@Data
public class UserRegRequest {
    private String username;
    private String password;
    private String email;

    public UserRegRequest(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
