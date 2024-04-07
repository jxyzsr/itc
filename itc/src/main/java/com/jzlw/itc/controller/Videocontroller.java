package com.jzlw.itc.controller;


import com.jzlw.itc.domain.FileEntity;
import com.jzlw.itc.domain.User;
import com.jzlw.itc.service.impl.*;
import com.jzlw.itc.util.FileUploadTool;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

@Controller
@SessionAttributes({"id","fileId","uuid"})
public class Videocontroller {
    @Autowired
    private FileServiceimpl service;
    @Autowired
    private UserServiceimpl userservice;
    @Autowired
    private GoodvServiceimpl gvservice;
    @Autowired
    private CollectionvServiceimpl cvservice;
    @Autowired
    private CommentServiceimpl commentservice;

    @RequestMapping(value = "/uploadVideo")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
                         HttpServletRequest request, @ModelAttribute("id")Integer id,Model model) {
        FileEntity entity = new FileEntity();
        String logoPathDir = request.getParameter("shipin");
        FileUploadTool fileUploadTool = new FileUploadTool();
        try {
            entity = fileUploadTool.createFile(logoPathDir, multipartFile, request,id);
            if (entity != null) {
                service.saveFile(entity);
                model.addAttribute("uuid",entity.getTitleAlter());
                System.out.println("上传成功");
            } else {
                System.out.println("上传失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "victory";
    }
    @GetMapping(value = "/addvideo")
    public String addvideo(){
        return "forward:/WEB-INF/views/my/addvideo.html";
    }
    @PostMapping(value = "/addcover",params = {"title"})
    public String oneFileUpload(
            @RequestParam("file") CommonsMultipartFile file,
            HttpServletRequest request, ModelMap model, @ModelAttribute("uuid") String uuid,String title) throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);
        // 新文件名
        String newFileName = uuid + ".jpg";
        String path = "E:/document/智能系统与大数据课堂代码/java-project/itc/target/itc-1.0-SNAPSHOT/static/video/cover";
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
        path = "/static/video/cover/" + newFileName;
        System.out.println("上传图片到:" + path + '/' + newFileName);
        service.updatecover(title,path,uuid);
        return "forward:/WEB-INF/views/my/addvideo.html";
    }
    //用于主页面的显示返回一些视频
    @PostMapping("/displayvideo")
    @ResponseBody
    public List<FileEntity> displayvideo(){
        return service.selectvideo();
    }
    //接收参数，并且把视频id保留到session中,并且渲染播放页面
    @GetMapping(value = "/loadid",params = {"fileId"})
    public String loadid(String fileId, Model model){
        model.addAttribute("fileId",fileId);
        return "forward:/WEB-INF/views/playvideo.html";
    }
    //从session中得到刚才的id并且返回一个视频json
    @PostMapping(value = "/getvideo")
    @ResponseBody
    public FileEntity getvideo(@ModelAttribute("fileId") String fileId){
        FileEntity video = service.findByid(Long.parseLong(fileId));
        return video;
    }
    //测试传递的json
    @PostMapping(value = "/getvideo2")
    @ResponseBody
    public FileEntity getvideo2(){
        String fileId ="1";
        FileEntity video = service.findByid(Long.parseLong(fileId));
        return video;
    }
    //删除帖子,从网页段前来的id是视频的id
    @PostMapping(path = "/deletevideo",params = {"id","filename"})
    public String deletevideo(Long id,String filename,@ModelAttribute("id")Integer userid){
        service.deletevideo(id,userid);
        //删除和帖子相关的所有的收藏和点赞
        gvservice.degoodvforv(id.intValue());
        cvservice.decollvforv(id.intValue());
        //删除帖子所有的评论
        commentservice.deleteacommmentfordeleted("video",id.intValue());

        filename = "E:/document/智能系统与大数据课堂代码/java-project/itc/target/itc-1.0-SNAPSHOT/static" + filename;
        File file = new File(filename);// 根据指定的文件名创建File对象
        if (!file.exists()) { // 要删除的文件不存在
            System.out.println("文件" + filename + "不存在，删除失败！");
        } else { // 要删除的文件存在
            if (file.isFile()) { // 如果目标文件是文件，判断是文件
                file.delete();
                System.out.println("已经删除");//删除文件
            }
        }
        return "forward:/WEB-INF/views/my/myvideo.html";
    }
}
