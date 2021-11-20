package ru.itis.spring.dto.signUpSignInMaintenance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.spring.validation.ValidNames;
import ru.itis.spring.validation.ValidPassword;

import javax.validation.constraints.Email;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ValidNames (
        message = "{errors.invalid.names}",
        name = "firstName",
        surname = "lastName"
)
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String nickname;
    @Email(message = "{errors.incorrect.email}")
    private String email;
    @ValidPassword(message = "{errors.invalid.password}")
    private String password;
}
