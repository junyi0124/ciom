package edu.thn.ciom.controller;

import edu.thn.ciom.pojo.DuochuPojo;
import edu.thn.ciom.pojo.ShaoChuPojo;
import edu.thn.ciom.pojo.ShujuPojo;
import edu.thn.ciom.service.FileService;
import edu.thn.ciom.service.OfferService;
import edu.thn.ciom.service.ShaochuService;
import edu.thn.ciom.service.ShujuService;
import edu.thn.ciom.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;

@Controller
@RequestMapping("/files")
public class FileController {

    private final String directory = "/files";
    @Autowired
    private FileService fileService;
    @Autowired
    private ShujuService shujuService;
    @Autowired
    private ShaochuService shaochuService;
    @Autowired
    private OfferService offerService;


    @PostMapping("/{type}/{id}")
    public void upload(HttpServletRequest request,
                       HttpServletResponse response,
                       @PathVariable("type") String type,
                       @PathVariable("id") Integer id,
                       @RequestParam("uploadFile") MultipartFile file) throws IOException {
        String baseDir = request.getSession().getServletContext().getRealPath(directory);
        String filename = file.getOriginalFilename();
        // generate real file path of attachment file
        String folderAndFile = generateFilePath(type, id, filename);
        // save file to local folder
        String filePath = fileService.upload(baseDir, folderAndFile, file);
        // write data to db
        updateImageInfo(type, id, "files\\" + filePath, filename);
        // response
        JSONObject result = new JSONObject();
        result.put("success", "true");
        try {
            ResponseUtil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String generateFilePath(String type, Integer id, String filename) {
        //StringBuffer sb = new StringBuffer(type);
        return Path.of(type, id.toString(), filename).toString();
    }

    private void updateImageInfo(String type, Integer id, String filePath, String name) {
        if (type.equalsIgnoreCase("shuju")) {
            ShujuPojo shuju = shujuService.getShuju(id);
            if (shuju != null) {
                shuju.setShujuimg(filePath);
                shuju.setShujuimgname(name);
            }
            shujuService.modifyShuju(shuju);
        } else if (type.equalsIgnoreCase("shaochu")) {
            ShaoChuPojo sjshaochu = shaochuService.getSjshaochu(id);
            if (sjshaochu != null) {
                sjshaochu.setSjshaochuimg(filePath);
                sjshaochu.setSjshaochuimgname(name);
            }
            shaochuService.modifySjshaochu(sjshaochu);
        } else if (type.equalsIgnoreCase("duochu")) {
            DuochuPojo duochu = offerService.getSjduochu(id);
            if (duochu != null) {
                duochu.setSjduochuimg(filePath);
                duochu.setSjduochuimgname(name);
            }
            offerService.modifySjduochu(duochu);
        }
    }

    @GetMapping("/{type}/{id}/{name}")
    public void download(@PathVariable String type, @PathVariable Integer id,
                         HttpServletRequest request, HttpServletResponse response) {
        //fileService.getFile(type, id);
        String name = "", path = "";
        if (type.equalsIgnoreCase("shuju")) {
            ShujuPojo shuju = shujuService.getShuju(id);
            if (shuju != null) {
                name = shuju.getShujuimgname();
            }
        } else if (type.equalsIgnoreCase("shaochu")) {
            ShaoChuPojo sjshaochu = shaochuService.getSjshaochu(id);
            if (sjshaochu != null) {
                name = sjshaochu.getSjshaochuimgname();
            }
        }
        else if (type.equalsIgnoreCase("duochu")) {
            DuochuPojo sjduochu = offerService.getSjduochu(id);
            if (sjduochu != null) {
                name = sjduochu.getSjduochuimgname();
            }
        }
        String s = generateFilePath(type, id, name);
        String baseDir = request.getSession().getServletContext().getRealPath(directory);
        File file = new File(baseDir, s);

        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + name);

        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
