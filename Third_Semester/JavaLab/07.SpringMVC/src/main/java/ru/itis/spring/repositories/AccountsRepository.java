package ru.itis.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmail(String email);

    Optional<Account> findById(Integer id);
}