package com.cn.system.dao.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Combotree {
	
	private Integer id;
	private String text;
	private Integer pid;
	private String url;
	private Boolean checked = false;
	private List children = new ArrayList();
	

}
