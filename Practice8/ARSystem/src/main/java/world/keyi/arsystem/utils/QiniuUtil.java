package world.keyi.arsystem.utils;

import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import world.keyi.arsystem.config.QiniuProperties;

import java.io.IOException;
import java.util.UUID;

/**
 * @author 万一
 * @date 2021年07月09日20:53
 */
@Component
public class QiniuUtil {

    @Autowired
    private QiniuProperties properties;

    //构造一个带指定Region对象的配置类
    private Configuration cfg = new Configuration(Region.region2());

    private UploadManager uploadManager= new UploadManager(cfg);

    public QiniuUtil(QiniuProperties properties) {
        this.properties = properties;
    }


    public String uploadFile(MultipartFile file) {
        Auth auth = Auth.create(properties.getAccessKey(), properties.getSecretKey());
        String token = auth.uploadToken(properties.getBucket());
        try {
            // 文件后缀
            /*String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));*/

            String suffix=properties.getSuffix();
            String fileKey = UUID.randomUUID().toString() + suffix;
            Response response = uploadManager.put(file.getInputStream(), fileKey, token, null, null);
            return properties.getDomain() +"/"+ fileKey;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
