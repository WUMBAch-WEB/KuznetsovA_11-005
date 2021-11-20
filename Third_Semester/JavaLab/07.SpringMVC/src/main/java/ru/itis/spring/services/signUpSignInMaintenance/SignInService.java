package ru.itis.spring.services.signUpSignInMaintenance;

import ru.itis.spring.dto.signUpSignInMaintenance.SignInForm;

public interface SignInService {

    boolean signIn(SignInForm signInForm);

}
