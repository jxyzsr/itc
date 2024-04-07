package com.jzlw.itc.controller;

import com.jzlw.itc.domain.Headpicture;
import com.jzlw.itc.service.impl.HeadpictureServiceimpl;
import com.jzlw.itc.service.impl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@SessionAttributes({"id","username","password"})
public class Headpicturecontroller {
    @Autowired
    private HeadpictureServiceimpl service;
    @Autowired
    private UserServiceimpl userservice;

    //头像上传页面
    @GetMapping("/updateheadpicture")
    public String updateheadpicture(){
        return "forward:/WEB-INF/views/my/updateheadpicture.html";
    }
    @PostMapping("/add")
    public String oneFileUpload(
            @RequestParam("file") CommonsMultipartFile file,
            HttpServletRequest request, ModelMap model, @ModelAttribute("id") Integer id) throws IOException {

        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);
        // 新文件名
        String newFileName = id.toString() + ".jpg";
        String path = "E:/document/智能系统与大数据课堂代码/java-project/itc/target/itc-1.0-SNAPSHOT/static/headpicture";
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + '/' + newFileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("上传图片到:" + path + '/' + newFileName);
        path = "/static/headpicture/" + newFileName;
        if (userservice.selectuserattribute(id).getHeadpicture() == null){
            service.insertahp(id,path);
        }
        return "forward:/WEB-INF/views/my/updateheadpicture.html";
    }
}
