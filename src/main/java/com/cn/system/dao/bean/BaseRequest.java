package com.cn.system.dao.bean;

public class BaseRequest {
	/**当前页数 从1开始 */
    private Integer page = 1;
    /**每页显示个数 */
    private Integer rows = 20;
    
    private String startTime;
    
    private String endTime;
    
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
    
}
