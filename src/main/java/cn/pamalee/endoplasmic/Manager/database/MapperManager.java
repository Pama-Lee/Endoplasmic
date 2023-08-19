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

package cn.pamalee.endoplasmic.Manager.database;

import cn.devspace.nucleus.Manager.Annotation.DataMapper;
import cn.pamalee.endoplasmic.Entity.CommonImage;
import cn.pamalee.endoplasmic.Entity.User.Token;
import cn.pamalee.endoplasmic.Entity.User.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@DataMapper
public class MapperManager {

    private static MapperManager instance;

    @Resource
    public BaseMapper<User> userMapper;

    @Resource
    public BaseMapper<Token> tokenMapper;

    @Resource
    public BaseMapper<CommonImage> commonImageBaseMapper;








    @PostConstruct
    public void initMapper() {
        instance = this;
    }

    public static MapperManager getInstance() {
        return instance;
    }



}
