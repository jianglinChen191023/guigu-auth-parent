package com.atguigu.model.system;

import com.atguigu.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("角色实体类")
@TableName("sys_role")
@Data
public class SysRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("角色名称")
	@TableField("role_name")
	private String roleName;

	@ApiModelProperty("角色编码")
	@TableField("role_code")
	private String roleCode;

	@ApiModelProperty("描述")
	@TableField("description")
	private String description;

}

