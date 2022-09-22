package com.dra.mqtt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户订阅
 * </p>
 *
 * @author dra
 * @since 2022-05-23
 */
@Data
@TableName("mq_user_sub")
@ApiModel(value = "MqUserSub对象", description = "用户订阅")
public class MqUserSub implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    @ApiModelProperty("话题")
    private String topic;

    private Integer isDelete;


}
