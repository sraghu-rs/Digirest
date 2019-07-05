package com.digirest.bean;



public class RequestAccountBean {
	
	
		public Integer account_number;
		public Double withdraw_amount;
		public String username;
		public String password;
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Integer getAccount_number() {
			return account_number;
		}
		public void setAccount_number(Integer account_number) {
			this.account_number = account_number;
		}
		public Double getWithdraw_amount() {
			return withdraw_amount;
		}
		public void setWithdraw_amount(Double withdraw_amount) {
			this.withdraw_amount = withdraw_amount;
		}
	
	}


