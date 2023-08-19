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
import cn.pamalee.endoplasmic.Entity.User.Token;
import cn.pamalee.endoplasmic.Entity.User.User;
import cn.pamalee.endoplasmic.Manager.error.errorManager;
import cn.pamalee.endoplasmic.Manager.error.errorType;
import cn.pamalee.endoplasmic.Units.commonUnits;
import cn.pamalee.endoplasmic.mapper.units.authUnits;

import java.util.HashMap;
import java.util.Map;

public class Auth extends RouteManager{


    @Router("auth/login")
    public Object login(Map<String, String> args) {
        if (!checkParams(args, new String[]{"username", "password"})) return errorManager.catchError(errorType.ILLEGAL_ARGUMENT);
        User user = authUnits.login(args.get("username"), args.get("password"));
        if (user != null){
            Token token = authUnits.issueToken(user);
            Map<String, Object> map = new HashMap<>();
            map.put("result", "success");
            map.put("token", token.getToken());
            return commonUnits.returnData(map);
        }else {
            return errorManager.catchError(errorType.LOGIN_PASSWORD_ERROR);
        }
    }

    @Router("auth/register")
    public Object register(Map<String, String> args) {
        if (!checkParams(args, new String[]{"username", "password"})) return errorManager.catchError(errorType.ILLEGAL_ARGUMENT);
        User user = authUnits.register(args.get("username"), args.get("password"));


        return null;
    }

    @Router(URI = "auth/logout")
    public Object logout(Map<String, String> args) {


        return null;
    }


    @Override
    public boolean checkParams(Map<String, String> maps, String[] params) {
        // 使用默认的参数检查
        if (params == null || params.length == 0){
            params = new String[]{"token"};
        }

        if (!super.checkParams(maps, params)){
            return false;
        }
        // TODO: 其他的参数检查

        return true;
    }
}
