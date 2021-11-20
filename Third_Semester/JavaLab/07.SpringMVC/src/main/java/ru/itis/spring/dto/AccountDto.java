package ru.itis.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.spring.models.Account;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer age;

    public static AccountDto from(Account account) {
        if (account == null) return null;
        return AccountDto.builder()
                .id(account.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .email(account.getEmail())
                .age(account.getAge())
                .build();
    }

    public static List<AccountDto> from(List<Account> accounts){
        return accounts.stream()
                .map(AccountDto::from).collect(Collectors.toList());
    }

    public static Account to(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId())
                .firstName(accountDto.getFirstName())
                .lastName(accountDto.getLastName())
                .email(accountDto.getEmail())
                .age(accountDto.getAge())
                .build();
    }
}
