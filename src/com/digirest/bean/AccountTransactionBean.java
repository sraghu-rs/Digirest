package com.digirest.bean;

import java.util.Date;

public class AccountTransactionBean {

	public int id;
	public double amount;
	public String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getRunning_balance() {
		return running_balance;
	}
	public void setRunning_balance(double running_balance) {
		this.running_balance = running_balance;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public int getTransaction_number() {
		return transaction_number;
	}
	public void setTransaction_number(int transaction_number) {
		this.transaction_number = transaction_number;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getTransaction_state_id() {
		return transaction_state_id;
	}
	public void setTransaction_state_id(int transaction_state_id) {
		this.transaction_state_id = transaction_state_id;
	}
	public int getTransaction_type_id() {
		return transaction_type_id;
	}
	public void setTransaction_type_id(int transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}
	
	public int getTransaction_category_id() {
		return transaction_category_id;
	}
	public void setTransaction_category_id(int transaction_category_id) {
		this.transaction_category_id = transaction_category_id;
	}
	public double running_balance;
	public Date transaction_date;
	public int transaction_number;
	public int account_id;
	public int transaction_state_id;
	public int transaction_type_id;
	public int transaction_category_id;
	
}
