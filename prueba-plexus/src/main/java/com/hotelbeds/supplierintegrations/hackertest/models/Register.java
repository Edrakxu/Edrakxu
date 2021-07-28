package com.hotelbeds.supplierintegrations.hackertest.models;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.hotelbeds.supplierintegrations.hackertest.utils.StringsUtils;

public class Register {
	
	private String ip;
	private long date;
	private String state;
	private String name;
	
	public Register(String register) {
		super();
		ArrayList<Integer> positions =  StringsUtils.getCommaPositions(register);
		ip = register.substring(0, positions.get(0));
		date = Long.valueOf(register.substring(positions.get(0)+1, positions.get(1)));
		state = register.substring(positions.get(1)+1, positions.get(2));
		name = register.substring(positions.get(2)+1, register.length());
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
