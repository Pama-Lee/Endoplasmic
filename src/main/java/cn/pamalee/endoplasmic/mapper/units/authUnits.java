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

package cn.pamalee.endoplasmic.mapper.units;

import cn.pamalee.endoplasmic.Entity.User.Token;
import cn.pamalee.endoplasmic.Entity.User.User;
import cn.pamalee.endoplasmic.Manager.database.MapperManager;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.DigestUtils;

import java.util.List;

public class authUnits {

    public static User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        List<User> list = MapperManager.getInstance().userMapper.selectList(queryWrapper);
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public static User register(String username, String password) {
        User user = new User();
        user.setUsername(username);

        // 检查用户名是否重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Integer list = MapperManager.getInstance().userMapper.selectCount(queryWrapper);
        if(list !=0 ) return null;

        // 暂时不做密码加密
        user.setPassword(password);
        MapperManager.getInstance().userMapper.insert(user);
        return user;
    }


    /**
     * 下发token
     * 使用md5加盐
     */
    public static Token issueToken(User user) {
        String tokenString = DigestUtils.md5DigestAsHex(("er+SuSenLidKsu"+user.getUsername() + System.currentTimeMillis()).getBytes());
        Token token = new Token();
        token.setToken(tokenString);
        token.setUid(user.getUid());

        // 有效时间7天
        token.setAllowTime(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7);
        MapperManager.getInstance().tokenMapper.insert(token);
        return token;
    }

    public static Token getToken(String tokenString) {
        QueryWrapper<Token> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("token", tokenString);
        List<Token> list = MapperManager.getInstance().tokenMapper.selectList(queryWrapper);
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public static boolean checkToken(String tokenString) {
        Token token = getToken(tokenString);
        if (token == null) {
            return false;
        }
        if (token.getAllowTime() < System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    public static User getUserByToken(String tokenString) {
        Token token = getToken(tokenString);
        if (token == null) {
            return null;
        }
        return MapperManager.getInstance().userMapper.selectById(token.getUid());
    }


}
