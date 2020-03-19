package org.fcadmin.controller.common;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fcadmin.utils.RespBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
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
@Api(tags={"文件上传接口"})
public class FileUploadController {
    @Value("${upload.resourceHandler}")
    private String resourceHandler;
    @Value("${upload.location}")
    private String location;

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @PostMapping("/upload")
    @ApiOperation(value = "单文件上传", httpMethod = "POST")
    public RespBean upload(MultipartFile file, HttpServletRequest req) {
        String format = sdf.format(new Date());
        //String realPath = req.getServletContext().getRealPath("/upload/img") + format;
        String realPath = location + format;
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
    @ApiOperation(value = "多文件上传", httpMethod = "POST")
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

