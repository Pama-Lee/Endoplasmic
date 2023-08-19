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

import java.util.HashMap;
import java.util.Map;

/**
 * =====================
 * 通用工具类
 * Common units
 * =====================
 */
public class commonUnits {

    /**
     * =====================
     * 返回包装后的正常数据
     * Return the normal data
     * =====================
     * @param data 数据
     * @return Map 包装后的数据
     */
    public static Object returnData(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        map.put("code", 200);
        map.put("message", "success");
        map.put("data", data);
        return map;
    }

}
