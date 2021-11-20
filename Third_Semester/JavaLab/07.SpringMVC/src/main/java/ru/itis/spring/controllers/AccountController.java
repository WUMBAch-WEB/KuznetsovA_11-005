package ru.itis.spring.controllers;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.spring.dto.AccountDto;
import ru.itis.spring.dto.SettingsForm;
import ru.itis.spring.models.Account;
import ru.itis.spring.repositories.AccountsRepository;
import ru.itis.spring.services.signUpSignInMaintenance.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static ru.itis.spring.dto.AccountDto.to;

@Controller
@AllArgsConstructor
public class AccountController {

    private AccountsRepository accountsRepository;
    private AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);


//    @Autowired
//    public AccountController(AccountsRepository accountsRepository){
//        this.accountsRepository = accountsRepository;
//    }

    @RequestMapping(value = "/accountPage")
    public String getAccountInPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        Account account = (Account) session.getAttribute("accountData");
        model.addAttribute("account", account);
        return "personalPage";
    }

    @RequestMapping(value = "/usersTable")
    public String getUsersTable(Model model) {
        List<Account> usersTable = accountsRepository.findAll();
        model.addAttribute("usersList", usersTable);
        return "usersTable";
    }

    @GetMapping(value = "/account/{account-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AccountDto getAccountDto(@PathVariable("account-id") Integer accountId) {
        return accountService.getAccountDto(accountId);
    }

    @GetMapping(value = "/account/settings")
    public String getSettingsPage() {
        return "settings";
    }

    @PostMapping(value = "/account/settings")
    public String settings(SettingsForm form, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Account account = (Account) session.getAttribute("accountData");
        if (accountService.settings(account, form)) {
            accountService.updateSession(account.getEmail(), request);
            return "redirect:/accountPage?Update=Done";
        }
        return "redirect:/accountPage?Update=Error";
    }
}
