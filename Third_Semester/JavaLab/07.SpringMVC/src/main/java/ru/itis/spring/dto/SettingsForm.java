package ru.itis.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SettingsForm {
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private String password;
    private String info;
    private Integer age;
    private String avatarUUID;
}
