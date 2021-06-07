package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.ShaoChuPojo;
import edu.thn.ciom.pojo.ShujuPojo;
import edu.thn.ciom.service.FileService;
import edu.thn.ciom.service.ShaochuService;
import edu.thn.ciom.service.ShujuService;
import edu.thn.ciom.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    private final String directory = "/files";
    @Autowired
    private FileService fileService;
    @Autowired
    private ShujuService shujuService;
    @Autowired
    private ShaochuService shaochuService;


    @PostMapping("/{type}/{id}")
    public void upload(HttpServletRequest request,
                       HttpServletResponse response,
                       @PathVariable("type") String type,
                       @PathVariable("id") Integer id,
                       MultipartFile file) throws IOException {
        String targetDirectory = request.getSession().getServletContext().getRealPath(directory);
        // save file to local folder
        String filePath = fileService.upload(targetDirectory, file);
        // write data to db
        updateImageInfo(type, id, filePath);
        // response
        JSONObject result = new JSONObject();
        result.put("success", "true");
        try {
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateImageInfo(String type, Integer id, String file) {
        if (type.equalsIgnoreCase("shuju")) {
            ShujuPojo shuju = shujuService.getShuju(id);
            if (shuju != null) {
                shuju.setShujuimg(file);
                shuju.setShujuimgname(StringUtils.getFilename(file));
            }
            shujuService.modifyShuju(shuju);
        } else if (type.equalsIgnoreCase("shaochu")) {
            ShaoChuPojo sjshaochu = shaochuService.getSjshaochu(id);
            if (sjshaochu != null) {
                sjshaochu.setSjshaochuimg(file);
                sjshaochu.setSjshaochuimgname(StringUtils.getFilename(file));
            }
            shaochuService.modifySjshaochu(sjshaochu);
        }
    }

    @GetMapping("/{id}/{name}")
    public void download(@PathVariable String id, @PathVariable String name, HttpServletResponse response) {
        fileService.getFile(id, name);
    }
}
