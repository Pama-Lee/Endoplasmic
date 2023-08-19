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

package cn.pamalee.endoplasmic.Entity;

import cn.devspace.nucleus.Plugin.DataEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "er_image")
@TableName("er_image")
public class CommonImage extends DataEntity implements Image{

    @Id
    @TableId(type = com.baomidou.mybatisplus.annotation.IdType.AUTO)
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String path;
    private String name;
    private Long size;
    private String md5;
    private String UUID;
    private String URL;
    private String token;
    private String type;
    private Long uid;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createTime;

}
