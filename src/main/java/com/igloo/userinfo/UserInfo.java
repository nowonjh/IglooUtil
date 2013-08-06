package com.igloo.userinfo;

public class UserInfo {
	private String name;
	private String email;
	private String id;
	private String ip;
	private String mac;
	private boolean blacklist;
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public boolean isBlacklist() {
		return blacklist;
	}
	public void setBlacklist(boolean blacklist) {
		this.blacklist = blacklist;
	}
	
	
	public String toString(){
		return "id=" + getId() + ", name=" + getName() + ", ip=" + getIp() + ", email=" + getEmail() + ", mac=" + getMac() + ", isBL=" + isBlacklist();
	}
}
