package com.atguigu.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("角色查询条件视图类")
@Data
public class SysRoleQueryVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("角色名称")
	private String roleName;

}

