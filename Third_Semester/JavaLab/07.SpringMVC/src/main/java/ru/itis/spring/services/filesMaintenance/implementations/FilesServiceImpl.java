package ru.itis.spring.services.filesMaintenance.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.spring.models.Account;
import ru.itis.spring.models.FileModel;
import ru.itis.spring.repositories.AccountsRepository;
import ru.itis.spring.repositories.FileRepository;
import ru.itis.spring.services.filesMaintenance.FilesService;
import ru.itis.spring.services.signUpSignInMaintenance.AccountService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
@PropertySource("classpath:application.properties")
public class FilesServiceImpl implements FilesService {

    @Value("${storage.path}")
    private String storagePath;

    @Value("${web.resources.storage.path}")
    private String webResourcesStoragePath;

    private FileRepository fileRepository;
    private AccountsRepository accountsRepository;
    private AccountService accountService;

    @Autowired
    public FilesServiceImpl(FileRepository fileRepository, AccountsRepository accountsRepository, AccountService accountService) {
        this.fileRepository = fileRepository;
        this.accountsRepository = accountsRepository;
        this.accountService = accountService;
    }

    @Override
    public void uploadFile(FileModel fileModel) {
        try {
            Files.copy(fileModel.getInputStream(), Paths.get(storagePath + fileModel.getFileUuid()));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public FileModel download(String fileName) {
        Optional<FileModel> fileOptional = fileRepository.findByFileUuid(fileName);

        if (!fileOptional.isPresent()) {
            return null;
        }

        return fileOptional.get();
    }

    @Override
    public void responseWithFile(String fileName, String fileType, OutputStream outputStream) {
        try {
            Files.copy(Paths.get(storagePath + fileName), outputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public FileModel save(MultipartFile multipartFile) {
        FileModel fileModel = null;
        try {
            fileModel = FileModel.builder()
                    .fileSize(multipartFile.getSize())
                    .fileName(multipartFile.getOriginalFilename())
                    .fileUuid(UUID.randomUUID().toString() + "." + multipartFile.getContentType().split("/")[1])
                    .fileMimeType(multipartFile.getContentType())
                    .inputStream(multipartFile.getInputStream())
                    .build();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        fileRepository.save(fileModel);
        return fileModel;
    }

    @Override
    public void updateAvatar(FileModel fileModel, Integer id, HttpServletRequest request) {
        Account account = accountsRepository.findById(id).get();
        account.setAvatarUUID(fileModel.getFileUuid());
        accountsRepository.save(account);
        accountService.updateSession(account.getEmail(), request);
        try {
            Files.copy(fileModel.getInputStream(), Paths.get(storagePath + fileModel.getFileUuid()));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
