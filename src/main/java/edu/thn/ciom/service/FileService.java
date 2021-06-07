package edu.thn.ciom.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    public String upload(String fileDir, MultipartFile file) {

        String fileName = file.getOriginalFilename();
        File dir = new File(fileDir, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        try {
            file.transferTo(dir);
            return file.getName();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    public void getFile(String id, String name) {
    }
}
