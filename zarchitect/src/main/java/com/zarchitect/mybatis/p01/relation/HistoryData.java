package com.zarchitect.mybatis.p01.relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HistoryData {
    
	@ApiModelProperty("id")
	private Long id;

	@ApiModelProperty("code")
    private String code;

	@ApiModelProperty("name")
    private String name;

	@ApiModelProperty("desc")
    private String description;

}