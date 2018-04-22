package com.cn.system.dao.bean;

import java.util.List;

import com.github.pagehelper.Page;

public class BaseResult {
	private boolean success = Boolean.TRUE;
	private String msg = "操作成功！";
	private Object data;
	private List rows;
	private List rowsPage;
	private Long total = 0L;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	public List getRowsPage() {
		return rowsPage;
	}
	public void setRowsPage(List rowsPage) {
		if(rowsPage != null &&rowsPage.size() > 0) {
			Page page = (Page)rowsPage;
			this.total = page.getTotal();
		}
		this.rows = rowsPage;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
}
