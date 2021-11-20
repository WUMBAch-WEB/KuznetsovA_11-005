package ru.itis.spring.services.signUpSignInMaintenance;

import ru.itis.spring.dto.AccountDto;
import ru.itis.spring.dto.SettingsForm;
import ru.itis.spring.models.Account;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

public interface AccountService {

    AccountDto getAccountDto(Integer accountId);
    List<AccountDto> getAllAccounts();
    void addAccount(AccountDto accountDto);
    boolean settings(Account account, SettingsForm form);
    void updateSession(String email, HttpServletRequest request);
}
