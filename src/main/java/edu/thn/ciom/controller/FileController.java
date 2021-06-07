package edu.thn.ciom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/file")
public class FileController {

    @PostMapping("/{id}")
    public void upload(@RequestParam("file")MultipartFile file) {

    }

    @GetMapping("/{id}/{name}")
    public void download(@PathVariable String id, @PathVariable String name, HttpServletResponse response) {

    }
}
