package com.innovention.hystrix.api.beans;

import java.util.List;

public class Customer {
	String accountId;
	String name;
	String surename;
	List<Integer> policyIds;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public List<Integer> getPolicyId() {
		return policyIds;
	}
	public void setPolicyId(List<Integer> policyIds) {
		this.policyIds = policyIds;
	}
}
