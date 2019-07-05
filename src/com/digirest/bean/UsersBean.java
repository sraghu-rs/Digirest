package com.digirest.bean;

public class UsersBean {
	
	public int id;
	public int account_non_expired;
	public int account_non_locked;
	public int credentials_non_expired;
	public int enabled;
	public String password;
	public String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccount_non_expired() {
		return account_non_expired;
	}
	public void setAccount_non_expired(int account_non_expired) {
		this.account_non_expired = account_non_expired;
	}
	public int getAccount_non_locked() {
		return account_non_locked;
	}
	public void setAccount_non_locked(int account_non_locked) {
		this.account_non_locked = account_non_locked;
	}
	public int getCredentials_non_expired() {
		return credentials_non_expired;
	}
	public void setCredentials_non_expired(int credentials_non_expired) {
		this.credentials_non_expired = credentials_non_expired;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public int profile_id;

}
