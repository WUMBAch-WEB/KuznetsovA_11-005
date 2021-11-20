package ru.itis.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.spring.models.FileModel;
import ru.itis.spring.services.filesMaintenance.FilesService;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@MultipartConfig
@AllArgsConstructor
public class FilesController {

    private FilesService filesService;
//    private static final Logger logger = LoggerFactory.getLogger(FilesController.class);

//    @Autowired
//    public FilesController(FilesService filesService, FileRepository fileRepository) {
//        this.fileRepository = fileRepository;
//        this.filesService = filesService;
//    }

    @RequestMapping(value = "/filesHandler")
    public String getFilesHandlerPage() {
        return "filesHandler";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        filesService.uploadFile(filesService.save(multipartFile));
        return "redirect: /filesHandler?Upload=Done";
    }

    @PostMapping(value = "/account/updateAvatar")
    public String updateAvatar(@RequestParam("file") MultipartFile multipartFile,
                               @RequestParam("id") String id,
                               HttpServletRequest request) {
        filesService.updateAvatar(filesService.save(multipartFile), Integer.parseInt(id), request);
        return "redirect: /accountPage";
    }

    @RequestMapping(value = "/fileDownload")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("fileName");
        FileModel fileModel = filesService.download(fileName);
        try {
            if (fileModel != null) {
//                logger.info("successful downloading of " + fileModel);
                response.setContentType(fileModel.getFileMimeType());
                response.setContentLengthLong(fileModel.getFileSize());
                response.setHeader("Content-Disposition", "filename=\"" + fileModel.getFileName() + "\"");
                filesService.responseWithFile(fileName, fileModel.getFileMimeType().split("/")[1], response.getOutputStream());
            } else {
//                logger.info("file with filename: " + fileName + " - not found");
                response.setStatus(400);
                response.getWriter().println("File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
