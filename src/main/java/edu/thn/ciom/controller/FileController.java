package edu.thn.ciom.controller;

import edu.thn.ciom.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/{id}")
    public void upload(@RequestParam("file")MultipartFile file) {
        fileService.upload(file);

    }

    @GetMapping("/{id}/{name}")
    public void download(@PathVariable String id, @PathVariable String name, HttpServletResponse response) {
        fileService.getFile(file);
    }
}
