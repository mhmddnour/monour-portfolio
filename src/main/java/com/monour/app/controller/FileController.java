package com.monour.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileController {

    @Value("${cv.folder.path}")
    String cvFolderPath;

    @GetMapping("cv/download")
    public void downloadFile(HttpServletResponse response) throws IOException {
        Path file = Paths.get(cvFolderPath);

        if (Files.exists(file)){
            response.setContentType("application/pdf");
//            response.addHeader("Content-Disposition", "attachment; filename=" + );

            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                response.getOutputStream().close();
            }
        }
    }
}
