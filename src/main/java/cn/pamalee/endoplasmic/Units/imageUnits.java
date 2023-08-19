/*
 *
 *   ______           _             _                     _
 *  |  ____|         | |           | |                   (_)
 *  | |__   _ __   __| | ___  _ __ | | __ _ ___ _ __ ___  _  ___
 *  |  __| | '_ \ / _` |/ _ \| '_ \| |/ _` / __| '_ ` _ \| |/ __|
 *  | |____| | | | (_| | (_) | |_) | | (_| \__ \ | | | | | | (__
 *  |______|_| |_|\__,_|\___/| .__/|_|\__,_|___/_| |_| |_|_|\___|
 *                           | |
 *                           |_|
 *
 *   CreateTime: 2023/2/25
 *   Author: Li JiaKe(Pama)
 */

package cn.pamalee.endoplasmic.Units;

import cn.pamalee.endoplasmic.Entity.CommonImage;
import cn.pamalee.endoplasmic.Entity.User.User;
import cn.pamalee.endoplasmic.Main;
import cn.pamalee.endoplasmic.Manager.database.MapperManager;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class imageUnits {

    // 将图片存放在本地
    public static CommonImage saveImageInLocal(MultipartFile image, User user) {
        // 获取本地存放图片的地址
        String localPath = Main.newInstance().getPluginDataPath()+"/images/";
        // 生成图片UUID
        String uuid = UUID.randomUUID().toString();
        // 获取图片后缀
        String suffix = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
        // 生成图片名称
        String imageName = uuid + suffix;
        // 生成图片路径
        String imagePath = localPath + imageName;
        // 存放图片的目录
        File imageDir = new File(localPath);
        // 如果目录不存在则创建
        if (!imageDir.exists()) {
            imageDir.mkdirs();
        }
        //上传图片的存放路径
        File destFile = new File(imagePath);
        try{
            // 保存图片
            image.transferTo(destFile);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        CommonImage commonImage = new CommonImage();
        commonImage.setUUID(uuid);
        commonImage.setPath(imagePath);
        commonImage.setURL("http://localhost:8080/App/er/images/"+imageName);
        commonImage.setUid(user.getUid());

        MapperManager.getInstance().commonImageBaseMapper.insert(commonImage);
        return commonImage;
    }

    // 将图片存放在七牛云
    public static String saveImageInQiniu(CommonImage image) {
        return null;
    }

    // 将图片存放在阿里云
    public static String saveImageInAliyun(CommonImage image) {
        return null;
    }

    // 将图片存放在腾讯云
    public static String saveImageInTencent(CommonImage image) {
        return null;
    }

    // 将图片存放在华为云
    public static String saveImageInHuawei(CommonImage image) {
        return null;
    }

    // 将图片存放在百度云
    public static String saveImageInBaidu(CommonImage image) {
        return null;
    }


}
