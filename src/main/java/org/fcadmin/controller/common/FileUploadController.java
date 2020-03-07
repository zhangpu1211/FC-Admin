package org.fcadmin.controller.common;
import org.fcadmin.utils.RespBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/file")
public class FileUploadController {

    public final static String IMG_PATH_PREFIX = "src/main/resources/static/upload";

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @PostMapping("/upload")
    public RespBean upload(MultipartFile file, HttpServletRequest req) {
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/upload/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            file.transferTo(new File(folder, newName));
            String url =  "/upload/img" + format + newName;
            return RespBean.ok("上传成功",url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return RespBean.error("上传失败");
    }

    @PostMapping("/uploads")
    public RespBean uploads(MultipartFile[] files, HttpServletRequest req) {
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/img") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String oldName = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
            try {
                file.transferTo(new File(folder, newName));
                String url = "/img" + format + newName;
//                String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/img" + format + newName;
                list.add(url);
                System.out.println(url);
                return RespBean.ok("上传成功",list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return RespBean.error("上传失败");
    }
}

