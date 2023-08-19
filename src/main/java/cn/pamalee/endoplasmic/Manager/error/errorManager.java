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

package cn.pamalee.endoplasmic.Manager.error;

import cn.devspace.nucleus.Message.Log;

import java.util.HashMap;
import java.util.Map;

public class errorManager {

    public static Object catchError(errorType type) {
        Log.sendLog("Error: " + type.getMessage());
        Log.sendLog("Code: " + type.getCode());
        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);
        map.put("code", type.getCode());
        map.put("message", type.getMessage());
        return map;
    }

}
