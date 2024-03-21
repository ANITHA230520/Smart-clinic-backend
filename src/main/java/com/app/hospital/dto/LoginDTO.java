package com.app.hospital.dto;

public class LoginDTO {
	
	private Integer userid;
    private String pwd;
    private String role;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "LoginDTO [userid=" + userid + ", pwd=" + pwd + ", role=" + role + "]";
	}
  
    


}