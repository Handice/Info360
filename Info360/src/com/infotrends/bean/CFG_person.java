package com.infotrends.bean;

/**
 * 與消息表對應的實體類
 * @author Lin
 */

public class CFG_person {
	
	private String dbid;
	
	private String first_name;
	
	private String last_name;
	
	private String user_name;
	
	private String employee_id;
	
	private String is_admin;
	
	private String is_agent;
	
	private String state;

	public String getDbid() {
		return dbid;
	}

	public void setDbid(String dbid) {
		this.dbid = dbid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}

	public String getIs_agent() {
		return is_agent;
	}

	public void setIs_agent(String is_agent) {
		this.is_agent = is_agent;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
