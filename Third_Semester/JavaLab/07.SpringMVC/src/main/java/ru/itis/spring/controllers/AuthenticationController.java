package ru.itis.spring.controllers;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itis.spring.dto.AccountDto;
import ru.itis.spring.dto.signUpSignInMaintenance.SignInForm;
import ru.itis.spring.dto.signUpSignInMaintenance.SignUpForm;
import ru.itis.spring.models.Account;
import ru.itis.spring.repositories.AccountsRepository;
import ru.itis.spring.services.signUpSignInMaintenance.AccountService;
import ru.itis.spring.services.signUpSignInMaintenance.SignInService;
import ru.itis.spring.services.signUpSignInMaintenance.SignUpService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@Controller
@AllArgsConstructor
public class AuthenticationController {

    private SignInService signInService;
    private AccountsRepository accountsRepository;
    private AccountService accountService;
    private SignUpService signUpService;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);


//    @Autowired
//    public AuthenticationController(SignInService signInService, AccountsRepository accountsRepository, SignUpService signUpService) {
//        this.signInService = signInService;
//        this.accountsRepository = accountsRepository;
//        this.signUpService = signUpService;
//    }

    @RequestMapping(value = "/signIn")
    public String getSignInPage() {
        return "signIn";
    }

    @RequestMapping(value = "/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(SignInForm form, HttpServletRequest request) {
        if (signInService.signIn(form)) {
            accountService.updateSession(form.getEmail(), request);
            return "redirect:/accountPage";
        } else {
            return "redirect:/signIn?Error";
        }
    }

    @PostMapping(value = "/signUp")
    public String signUp(@Valid SignUpForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
                if (Objects.requireNonNull(error.getCodes())[0].equals("signUpForm.ValidNames")) {
                    model.addAttribute("namesErrorMessage", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("signUpForm", form);
            return "signUp";
        }
        if (accountsRepository.findByEmail(form.getEmail()).isEmpty()) {
            signUpService.signUp(form);
            logger.info("Created new account" + form);
            return "redirect: /signIn?signUp=Done";
        } else {
            return "redirect: /signUp?Email=occupied";
        }
    }

    @RequestMapping(value = "/signUp/json", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AccountDto> addAccountFromJson(@RequestBody AccountDto accountDto) {
        accountService.addAccount(accountDto);
        return accountService.getAllAccounts();
    }
}
