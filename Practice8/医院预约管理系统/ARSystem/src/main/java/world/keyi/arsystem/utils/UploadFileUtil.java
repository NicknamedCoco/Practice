package world.keyi.arsystem.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import world.keyi.arsystem.config.FileProperties;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 万一
 * @date 2021年07月04日20:05
 * 文件上传工具类
 */
@Slf4j
public class UploadFileUtil {
    /**
     *  这里并不能使用自动注入，因为该工具类并不在容器中。
     */
    private static FileProperties fileProperties = SpringContextUtil.getBean(FileProperties.class);

    /**
     * 获取上传的文件类型
     * @param filename file.getOriginalFilename();
     *
     */
    public static String getFileType(String filename){
        return filename.substring(filename.lastIndexOf("."));
        /*if (filename.contains(".")){
        }else{
            return null;
        }*/
    }

    /**
     * 获取时间路径
     *
     */
    public static String getDatePath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    /**
     * 获取随机文件名
     *
     */
    public static String getRandomName(){
        return UUID.randomUUID().toString();
    }

    /**
     * 判断是否是图片
     *
     */
    public static boolean isImage(MultipartFile uploadFile) {
        if (uploadFile.isEmpty()) {
            return false;
        }
        BufferedImage image = null;
        try {
            image = ImageIO.read(uploadFile.getInputStream());
            if (image == null || image.getWidth() <= 0 || image.getHeight() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断图片后缀是否符合要求
     */
    public static boolean isImageType(String fileType){
        return !fileType.toLowerCase().matches("^.+\\.(jpg|jpge|png|gif)$");
    }

    /**
     * 获取文件的大小，以kb为单位
     */
    public static double getFileSize(MultipartFile uploadFile){
        double size = uploadFile.getSize();
        return Math.ceil(size/1024.0);
    }

    /**
     * 如果本地目录不存在，则创建该文件夹
     */
    public static void createMkdir(String fileName){
        File file = new File(fileName);
        if (!file.exists()){
            file.mkdirs();
        }
    }

    /**
     *  上传图片
     *      1，获取时间路径
     *      2，获取随机文件名
     *      3，获取图片后缀
     *      4，获取图片大小，以kb为单元
     *      5，生成本地目录(本地前缀+时间目录，如果为空，则创建文件夹)，
     *          生成完整本地路径(本地目录+随机文件名+文件类型后缀)，
     *          生成完整请求路径(用于前端访问)
     *      6，判断文件是否是图片文件，判断文件后缀是否符合图片类型
     *      7，如果是图片文件，则创建目录，再使用完整本地路径，保存文件
     *
     *  图片实际保存地：完整本地(真实)路径=本地目录(本地前缀+时间目录)+随机文件名+文件类型后缀
     *  前端访问路径：完整请求路径=请求前缀+时间目录+随机文件名+文件类型后缀
     *
     *  datePath：时间目录
     *  randomName：随机文件名
     *  fileType：文件类型后缀
     *  fileSize：文件大小，kb为单位
     *  newFileDir：本地目录=本地前缀+时间目录，没有则创建该文件夹
     *  newFile：完整本地路径=本地目录+随机文件名+文件类型后缀
     *  requestUrl：完整请求路径=请求前缀+时间目录+随机文件名+文件类型后缀
     *
     *  本案例中因为前端传递过来的MultipartFile数据，获取文件后缀后，并没有任何后缀，可能是被设置过的
     *  所以方法中直接声明文件后缀是.jpg，实际上应该由uploadFile.getOriginalFilename()获取
     */
    /*public static Map<String,Object> uploadImage(MultipartFile uploadFile){
        Map<String, Object> map = new HashMap<>();
        String datePath = getDatePath();
        String randomName = getRandomName();
        String fileType = getFileType(uploadFile.getOriginalFilename());
        double fileSize = getFileSize(uploadFile);
        String newFileDir=fileProperties.getLocalPath()+"/"+datePath;
        String newFile = fileProperties.getLocalPath()+"/"+datePath+"/"+randomName+fileType;
        String requestUrl = fileProperties.getRequestPath()+"/"+datePath+"/"+randomName+fileType;

        map.put("fileSize", String.valueOf(fileSize));
        map.put("fileType",fileType);
        map.put("generateFolder",datePath);
        map.put("generateFileName",randomName+fileType);
        map.put("oldName",uploadFile.getOriginalFilename());

        log.info("文件后缀"+fileType);
        log.info("文件大小"+fileSize+"kb");
        log.info("完整文件路径"+newFile);
        log.info("完整请求路径"+requestUrl);

        if (isImage(uploadFile)&&isImageType(fileType)){
            map.put("isImage",true);
            createMkdir(newFileDir);
            try {
                uploadFile.transferTo(new File(newFile));
                map.put("status", 200);
                map.put("requestUrl", requestUrl);
                log.info("图片上传成功");
            } catch (IOException e) {
                map.put("status", 201);
                e.printStackTrace();
                log.info("图片上传失败");
            }
        }else {
            map.put("isImage",false);
            map.put("status", 201);
            log.info("图片上传失败");
        }
        return map;
    }*/

    public static Map<String,Object> uploadImage(MultipartFile uploadFile){
        Map<String, Object> map = new HashMap<>();
        String datePath = getDatePath();
        String randomName = getRandomName();
        String fileType = ".jpg";
        double fileSize = getFileSize(uploadFile);
        String newFileDir=fileProperties.getLocalPath()+"/"+datePath;
        String newFile = fileProperties.getLocalPath()+"/"+datePath+"/"+randomName+fileType;
        String requestUrl = fileProperties.getRequestPath()+"/"+datePath+"/"+randomName+fileType;

        map.put("fileSize", String.valueOf(fileSize));
        map.put("fileType",fileType);
        map.put("generateFolder",datePath);
        map.put("generateFileName",randomName+fileType);
        map.put("oldName",uploadFile.getOriginalFilename());

        log.info("文件后缀"+fileType);
        log.info("文件大小"+fileSize+"kb");
        log.info("完整文件路径"+newFile);
        log.info("完整请求路径"+requestUrl);
        if (isImage(uploadFile)&&isImageType(fileType.substring(1))){
            map.put("isImage",true);
            createMkdir(newFileDir);
            try {
                uploadFile.transferTo(new File(newFile));
                map.put("status", 200);
                map.put("requestUrl", requestUrl);
                log.info("图片上传成功");
            } catch (IOException e) {
                map.put("status", 201);
                e.printStackTrace();
                log.info("图片上传失败");
            }
        }else {
            map.put("isImage",false);
            map.put("status", 201);
            log.info("图片上传失败");
        }
        return map;
    }
}
