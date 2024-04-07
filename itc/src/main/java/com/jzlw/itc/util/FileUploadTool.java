package com.jzlw.itc.util;

import org.springframework.web.multipart.MultipartFile;

import com.jzlw.itc.domain.FileEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

//文件上传工具
public class FileUploadTool {
    // 转码工具类
    TransfMediaTool transfMediaTool = new TransfMediaTool();
    // 文件最大500M
    private static long upload_maxsize = 5000 * 1024 * 1024;
    // 文件允许格式
    private static String[] allowFiles = { ".rar", ".doc", ".docx", ".zip", ".pdf", ".txt", ".swf", ".xlsx", ".gif",
            ".png", ".jpg", ".jpeg", ".bmp", ".xls", ".mp4", ".flv", ".ppt", ".avi", ".mpg", ".wmv", ".3gp", ".mov",
            ".asf", ".asx", ".vob", ".wmv9", ".rm", ".rmvb", ".mkv" };
    // 允许转码的视频格式（ffmpeg）
    private static String[] allowFLV = { ".avi", ".mpg", ".wmv", ".3gp", ".mov", ".asf", ".asx", ".vob" };
    // 允许的视频转码格式(mencoder)
    private static String[] allowAVI = { ".wmv9", ".rm", ".rmvb" };

    public FileEntity createFile(String logoPathDir, MultipartFile multipartFile, HttpServletRequest request,Integer id) {
        FileEntity entity = new FileEntity();
        boolean bflag = false;
        String fileName = multipartFile.getOriginalFilename().toString();
        // 判断文件不为空
        if (multipartFile.getSize() != 0 && !multipartFile.isEmpty()) {
            bflag = true;
            // 判断文件大小
            if (multipartFile.getSize() <= upload_maxsize) {
                bflag = true;
                // 文件类型判断
                if (this.checkFileType(fileName)) {
                    bflag = true;
                } else {
                    bflag = false;
                    System.out.println("文件类型不允许");
                }
            } else {
                bflag = false;
                System.out.println("文件大小超范围");
            }
        } else {
            bflag = false;
            System.out.println("文件为空");
        }
        if (bflag) {
            //上传到项目的根路径下的前台要求的指定文件夹下
//            String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
            //上传到本地磁盘
            String logoRealPathDir = "E:/document/智能系统与大数据课堂代码/java-project/itc/target/itc-1.0-SNAPSHOT/static/video/"+id.toString();
            File logoSaveFile = new File(logoRealPathDir);
            if (!logoSaveFile.exists()) {
                logoSaveFile.mkdirs();
            }
            //文件名
            String name = fileName.substring(0, fileName.lastIndexOf("."));
            // 新的文件名
            String newFileName = this.getName(name);
            // 文件扩展名
            String fileEnd = this.getFileExt(fileName);
            // 绝对路径
            String fileNamedirs = logoRealPathDir + File.separator + newFileName + fileEnd;
            File filedirs = new File(fileNamedirs);
            // 转入文件
            try {
                multipartFile.transferTo(filedirs);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 相对路径
            entity.setType(fileEnd);
            String fileDir = logoPathDir + newFileName + fileEnd;
            StringBuilder builder = new StringBuilder(fileDir);
            String finalFileDir = builder.substring(1);
            builder = new StringBuilder(finalFileDir);
            finalFileDir = builder.substring(5);
            finalFileDir = "video/" + id.toString() +finalFileDir;
            // size存储为String
            String size = this.getSize(filedirs);
            // 源文件保存路径
            String aviPath = filedirs.getAbsolutePath();
            // 转码Avi
            // //boolean flag = false;
/*			if (this.checkAVIType(fileEnd)) {
				// 设置转换为AVI格式后文件的保存路径
				String codcAviPath = logoRealPathDir + File.separator + newFileName + ".avi";
				// 获取配置的转换工具（mencoder.exe :http://www1.mplayerhq.hu/design7/dload.html）的存放路径
				String mencoderPath = request.getSession().getServletContext().getRealPath("/tools/mencoder.exe");
				aviPath = transfMediaTool.processAVI(mencoderPath, filedirs.getAbsolutePath(), codcAviPath);
				fileEnd = this.getFileExt(codcAviPath);
			}*/

            if (aviPath != null) {
                // 转码Flv
/*				if (this.checkMediaType(fileEnd)) {
					try {
						// 设置转换为flv格式后文件的保存路径
						String codcFilePath = logoRealPathDir + File.separator + newFileName + ".flv";
						// 获取配置的转换工具（ffmpeg.exe :http://www.ffmpeg.org/download.html）的存放路径
						String ffmpegPath = request.getSession().getServletContext().getRealPath("/tools/ffmpeg.exe");
						transfMediaTool.processFLV(ffmpegPath, aviPath,    codcFilePath);
						fileDir = logoPathDir + newFileName + ".flv";
						builder = new StringBuilder(fileDir);
						finalFileDir = builder.substring(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}*/
                entity.setSize(size);
                entity.setPath(finalFileDir);// 相对路径：finalFileDir 绝对路径：fileNamedirs
                entity.setTitleOrig(name);
                entity.setTitleAlter(newFileName);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                entity.setUploadTime(timestamp);
                entity.setUserid(id);
                return entity;
            }
        } else {
            return null;
        }
        return entity;
    }
    /**
     * 文件类型判断
     *
     * @param fileName
     * @return
     */
    private boolean checkFileType(String fileName) {
        Iterator<String> type = Arrays.asList(allowFiles).iterator();
        while (type.hasNext()) {
            String ext = type.next();
            if (fileName.toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 视频类型判断(flv)
     *
     * @param fileEnd
     * @return
     */
    private boolean checkMediaType(String fileEnd) {
        Iterator<String> type = Arrays.asList(allowFLV).iterator();
        while (type.hasNext()) {
            String ext = type.next();
            if (fileEnd.equals(ext)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 视频类型判断(AVI)
     *
     * @param fileEnd
     * @return
     */
    private boolean checkAVIType(String fileEnd) {
        Iterator<String> type = Arrays.asList(allowAVI).iterator();
        while (type.hasNext()) {
            String ext = type.next();
            if (fileEnd.equals(ext)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 获取文件扩展名
     *
     * @return string
     */
    private String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
    /**
     * 依据原始文件名生成新文件名 UUID：全局唯一标识符，由一个十六位的数字组成,由三部分组成：当前日期和时间、时钟序列、全局唯一的IEEE机器识别号
     *
     * @return string
     */
    private String getName(String fileName) {
        Random random = new Random();
        return "" + random.nextInt(10000) + System.currentTimeMillis();
        //return UUID.randomUUID().toString() + "_" + fileName;

    }
    /**
     * 文件大小，返回kb.mb ?
     *
     * @return
     */
    private String getSize(File file) {
        String size = "";
        long fileLength = file.length();
        DecimalFormat df = new DecimalFormat("#.00");
        if (fileLength < 1024) {
            size = df.format((double) fileLength) + "BT";
        } else if (fileLength < 1048576) {
            size = df.format((double) fileLength / 1024) + "KB";
        } else if (fileLength < 1073741824) {
            size = df.format((double) fileLength / 1048576) + "MB";
        } else {
            size = df.format((double) fileLength / 1073741824) + "GB";
        }
        return size;
    }

}
