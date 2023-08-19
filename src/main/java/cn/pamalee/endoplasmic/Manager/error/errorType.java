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

import cn.devspace.nucleus.Lang.LangBase;
import cn.pamalee.endoplasmic.Main;

/**
 * 错误类型
 * @author Pama Lee
 */
public enum errorType {

    /**
     * =====================
     * 通用错误
     * =====================
     */
    // 未知错误
    UNKNOWN_ERROR(0),
    // 非法参数
    ILLEGAL_ARGUMENT(1000),
    // 未知命令
    UNKNOWN_COMMAND(1001),

    /**
     * =====================
     * 用户错误
     * =====================
     */

    // 未知用户
    USER_NOT_FOUND(2000),
    // 用户已存在
    USER_ALREADY_EXIST(2001),
    // 用户名或密码错误
    USER_PASSWORD_ERROR(2002),
    // 用户名或密码为空
    USER_PASSWORD_EMPTY(2003),
    // 验证码token错误
    USER_TOKEN_ERROR(2004),

    /**
     * =====================
     * 权限错误
     * =====================
     */
    // 未知Token
    TOKEN_NOT_FOUND(3000),
    // Token已过期
    TOKEN_EXPIRED(3001),
    // Token已失效
    TOKEN_INVALID(3002),

    /**
     * =====================
     * 服务器错误
     * =====================
     */
    // 服务器错误
    SERVER_ERROR(4000),
    // 服务器繁忙
    SERVER_BUSY(4001),
    // 服务器维护中
    SERVER_MAINTAIN(4002),
    // 服务器已关闭
    SERVER_CLOSED(4003),

    /**
     * =====================
     * 数据库错误
     * =====================
     */
    // 数据库错误
    DATABASE_ERROR(5000),
    // 数据库连接错误
    DATABASE_CONNECT_ERROR(5001),
    // 数据库查询错误
    DATABASE_QUERY_ERROR(5002),


    /**
     * =====================
     * 登录错误
     * =====================
     */

    // 登录错误
    LOGIN_ERROR(6000),
    // 登录失败
    LOGIN_FAILED(6001),
    // 用户名或密码错误
    LOGIN_PASSWORD_ERROR(6002),

    /**
     * =====================
     * 注册错误
     * =====================
     */
    // 注册错误
    REGISTER_ERROR(7000),
    // 注册失败
    REGISTER_FAILED(7001),
    // 用户名已经存在
    REGISTER_USERNAME_EXIST(7002),

    /**
     * =====================
     * 上传错误
     * =====================
     */
    // 上传错误
    UPLOAD_ERROR(8000),
    // 上传失败
    UPLOAD_FAILED(8001),
    // 文件太大
    UPLOAD_FILE_TOO_LARGE(8002),
    // 文件类型不支持
    UPLOAD_FILE_TYPE_NOT_SUPPORT(8003);








    private final int code;
    private final String message;
    // 构造函数
     errorType(int code) {
        this.code = code;
        // 通过多语言支持，获取错误信息
         LangBase langBase = Main.getLangBase();
        this.message = langBase.TranslateOne(this.toString());

    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
