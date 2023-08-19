

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

package cn.pamalee.endoplasmic;

import cn.devspace.nucleus.Lang.LangBase;
import cn.devspace.nucleus.Plugin.Config.ConfigBase;
import cn.devspace.nucleus.Plugin.PluginBase;
import cn.pamalee.endoplasmic.mapper.Auth;
import cn.pamalee.endoplasmic.mapper.Uploader;

public class Main extends PluginBase {

    private static Main instance;
    private ConfigBase configBase;

    private static LangBase langBase;



    @Override
    public void onLoad() {
        sendLog("=-=-=-=-=-=-=-=-=-");
        sendLog(translateMessage("Loading"));
        langBase = getPluginLang();

        initRoute(Uploader.class);
        initRoute(Auth.class);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
    }

    public static LangBase getLangBase() {
        return langBase;
    }

    public static Main newInstance() {
        return instance;
    }

    public String getPluginDataPath() {
        return instance.getPluginDataPath();
    }

}
