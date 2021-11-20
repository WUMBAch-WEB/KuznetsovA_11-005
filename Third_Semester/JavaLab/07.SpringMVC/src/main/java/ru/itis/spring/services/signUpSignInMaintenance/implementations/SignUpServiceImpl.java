package ru.itis.spring.services.signUpSignInMaintenance.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.spring.dto.signUpSignInMaintenance.SignUpForm;
import ru.itis.spring.models.Account;
import ru.itis.spring.repositories.AccountsRepository;
import ru.itis.spring.services.signUpSignInMaintenance.SignUpService;
import ru.itis.spring.util.EmailUtil;
import ru.itis.spring.util.MailsGenerator;

import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    private AccountsRepository accountsRepository;
    private MailsGenerator mailsGenerator;
    private EmailUtil emailUtil;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpServiceImpl(AccountsRepository accountsRepository, MailsGenerator mailsGenerator,
                             EmailUtil emailUtil, PasswordEncoder passwordEncoder) {
        this.accountsRepository = accountsRepository;
        this.mailsGenerator = mailsGenerator;
        this.emailUtil = emailUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Value("${server.url}")
    private String serverUrl;

    @Value("${email.theme}")
    private String emailTheme;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void signUp(SignUpForm form) {
        Account account = Account.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .nickname(form.getNickname())
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .confirmCode(UUID.randomUUID().toString())
                .build();

        accountsRepository.save(account);

//        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, account.getConfirmCode());
//
//        emailUtil.sendMail(account.getEmail(), emailTheme, from, confirmMail);
    }

}
