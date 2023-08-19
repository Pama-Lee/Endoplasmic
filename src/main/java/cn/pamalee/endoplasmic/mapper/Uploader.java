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

package cn.pamalee.endoplasmic.mapper;

import cn.devspace.nucleus.Manager.Annotation.Router;
import cn.devspace.nucleus.Manager.RouteManager;
import cn.pamalee.endoplasmic.Entity.CommonImage;
import cn.pamalee.endoplasmic.Entity.User.User;
import cn.pamalee.endoplasmic.Manager.error.errorManager;
import cn.pamalee.endoplasmic.Manager.error.errorType;
import cn.pamalee.endoplasmic.Units.imageUnits;
import cn.pamalee.endoplasmic.mapper.units.authUnits;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public class Uploader extends RouteManager {

    @Router(URI = "image/upload", isUpload = true)
    public Object upload(Map<String, String> params, MultipartFile multipartFile) {
        String[] keys = {"token"};
        if (!checkParams(params, keys)) return errorManager.catchError(errorType.ILLEGAL_ARGUMENT);
        // 检查token
        if(!authUnits.checkToken(params.get("token"))) return errorManager.catchError(errorType.TOKEN_INVALID);

        User user = authUnits.getUserByToken(params.get("token"));
        if (user == null) return errorManager.catchError(errorType.TOKEN_INVALID);

        // 检查图片大小
        if(multipartFile.getSize() > 1024 * 1024 * 5) return errorManager.catchError(errorType.UPLOAD_FILE_TOO_LARGE);

        // 检查图片格式
        String[] types = {"image/jpeg", "image/png", "image/gif"};
        boolean isType = false;
        for (String type : types) {
            if (type.equals(multipartFile.getContentType())) {
                isType = true;
                break;
            }
        }
        if (!isType) return errorManager.catchError(errorType.UPLOAD_FILE_TYPE_NOT_SUPPORT);

        // 放置图片
        CommonImage url = imageUnits.saveImageInLocal(multipartFile, user);
        if (url == null) return errorManager.catchError(errorType.UPLOAD_FAILED);
        return url;
    }


}
