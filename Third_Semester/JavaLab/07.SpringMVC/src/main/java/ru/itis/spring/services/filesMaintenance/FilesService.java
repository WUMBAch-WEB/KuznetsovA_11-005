package ru.itis.spring.services.filesMaintenance;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.spring.models.FileModel;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.OutputStream;

public interface FilesService {
    void uploadFile(FileModel fileModel);
    FileModel download(String fileName);
    void responseWithFile(String fileName, String fileType, OutputStream outputStream);
    FileModel save(MultipartFile multipartFile);
    void updateAvatar(FileModel fileModel, Integer id, HttpServletRequest request);
}
