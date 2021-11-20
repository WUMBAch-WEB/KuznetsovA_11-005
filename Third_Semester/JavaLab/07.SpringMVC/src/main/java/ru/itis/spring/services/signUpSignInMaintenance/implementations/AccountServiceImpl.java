package ru.itis.spring.services.signUpSignInMaintenance.implementations;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.spring.dto.AccountDto;
import ru.itis.spring.dto.SettingsForm;
import ru.itis.spring.models.Account;
import ru.itis.spring.repositories.AccountsRepository;
import ru.itis.spring.services.signUpSignInMaintenance.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountsRepository accountsRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountDto getAccountDto(Integer accountId) {
        return AccountDto.from(accountsRepository.findById(accountId).orElse(null));
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return AccountDto.from(accountsRepository.findAll());
    }

    @Override
    public void addAccount(AccountDto accountDto) {
        accountsRepository.save(Account.builder()
                .firstName(accountDto.getFirstName())
                .lastName(accountDto.getLastName())
                .email(accountDto.getEmail())
                .age(accountDto.getAge())
                .password(accountDto.getPassword())
                .build());
    }

    @Override
    public boolean settings(Account account, SettingsForm form) {
        System.out.println(form);
        if (!passwordEncoder.matches(form.getConfirmPassword(), account.getPassword())) return false;
        if (form.getFirstName() != "") account.setFirstName(form.getFirstName());
        if (form.getLastName() != "") account.setLastName(form.getLastName());
        if (form.getEmail() != "") account.setEmail(form.getEmail());
        if (form.getPassword() != "") account.setPassword(passwordEncoder.encode(form.getPassword()));
        if (form.getNickname() != "") account.setNickname(form.getNickname());
        if (form.getAge() != null) account.setAge(form.getAge());
        if (form.getInfo() != "") account.setInfo(form.getInfo());
        if (form.getAvatarUUID() != "") account.setAvatarUUID(form.getAvatarUUID());
        accountsRepository.save(account);
        return true;
    }

    @Override
    public void updateSession(String email, HttpServletRequest request) {
        Account account = accountsRepository.findByEmail(email).get();
        HttpSession session = request.getSession(true);
        session.setAttribute("isAuthenticated", "true");
        session.setAttribute("accountData", account);
    }

}
