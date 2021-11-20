package ru.itis.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring.models.FileModel;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileModel, Integer> {
    Optional<FileModel> findByFileUuid(String UUID);
}