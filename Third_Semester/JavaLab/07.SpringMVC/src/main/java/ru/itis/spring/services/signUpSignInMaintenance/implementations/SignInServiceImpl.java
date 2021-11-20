package ru.itis.spring.services.signUpSignInMaintenance.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.spring.dto.signUpSignInMaintenance.SignInForm;
import ru.itis.spring.models.Account;
import ru.itis.spring.repositories.AccountsRepository;
import ru.itis.spring.services.signUpSignInMaintenance.SignInService;

import java.util.Optional;

@Service
public class SignInServiceImpl implements SignInService {

    private static final Logger logger = LoggerFactory.getLogger(SignInServiceImpl.class);
    private final AccountsRepository accountsRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SignInServiceImpl(AccountsRepository accountsRepository, PasswordEncoder passwordEncoder) {
        this.accountsRepository = accountsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean signIn(SignInForm signInForm) {
        Optional<Account> accountOptional = accountsRepository.findByEmail(signInForm.getEmail());

        if (!accountOptional.isPresent()){
            return false;
        }

        Account account = accountOptional.get();
        logger.info("Successful login in " + account);

        return passwordEncoder.matches(signInForm.getPassword(), account.getPassword());
    }
}
