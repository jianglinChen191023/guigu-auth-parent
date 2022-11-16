package com.atguigu.model.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用属性类
 *
 * @author 陈江林
 * @date 2022/11/11
 */
@Data
public class BaseEntity implements Serializable {

    //@TableId(type = IdType.AUTO)
    @ApiModelProperty("唯一标识")
    private Long id;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("逻辑删除{0: 没有删除, 其他: 已经删除}")
    @TableLogic(delval = "id")
    @TableField("is_deleted")
    private Long isDeleted;

    @ApiModelProperty("其他参数")
    @TableField(exist = false)
    private Map<String, Object> param = new HashMap<>();
}
